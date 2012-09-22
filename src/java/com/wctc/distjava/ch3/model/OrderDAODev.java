package com.wctc.distjava.ch3.model;

import com.wctc.distjava.ch3.db.DBAccessor;
import com.wctc.distjava.ch3.db.DB_Generic;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Use this version to connect to your local database.
 *
 * @author jlombardo
 */
public class OrderDAODev implements IOrderDAO {

    private DBAccessor db;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL =
            "jdbc:mysql://localhost:3306/restaurant";
    private static final String USER = "root";
    private static final String PWD = "admin";
    private static int orderCount = 0;

    public OrderDAODev() {
        db = new DB_Generic();
    }

    @Override
    public List<MenuItem> getCurrentMenuChoices(String menuType) throws RuntimeException {
        List<MenuItem> items = new ArrayList<MenuItem>();

        try {
            // Make sure you always open a connection before trying to
            // send commands to the database.            
            db.openConnection(OrderDAODev.DRIVER, OrderDAODev.URL, OrderDAODev.USER, OrderDAODev.PWD);

            String sql;

            if (menuType != null && menuType.equalsIgnoreCase("breakfast")) {
                sql = "select * from menu_item where served_for = 'BFS' order by item_name";
            } else if (menuType != null && menuType.equalsIgnoreCase("lunch")) {
                sql = "select * from menu_item where served_for = 'LCH' order by item_name";
            } else if (menuType != null && menuType.equalsIgnoreCase("dinner")) {
                sql = "select * from menu_item where served_for = 'DNR' order by item_name";
            } else {
                sql = "select * from menu_item order by item_name";
            }

            List<Map> rawData = db.findRecords(sql, true);
            for (Map record : rawData) {
                MenuItem item = new MenuItem();
                int id = Integer.valueOf(record.get("menu_item_id").toString());
                item.setId(id);
                String name = String.valueOf(record.get("item_name"));
                item.setItemName(name);
                items.add(item);
            }

            return items;

        } catch (IllegalArgumentException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    @Override
    public void saveOrder(List<MenuItem> orderList) throws RuntimeException {
        try {
            List colDescriptors = new ArrayList();
            List colValues = new ArrayList();
            db.openConnection(OrderDAODev.DRIVER, OrderDAODev.URL,
                    OrderDAODev.USER, OrderDAODev.PWD);

            for (MenuItem item : orderList) {
                colDescriptors.add("menu_item_id");
                colValues.add(item.getId());

                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
                String dateStr = sdf.format(date);
                colValues.add(dateStr + "-" + ++orderCount);
                colDescriptors.add("order_id");

                // Usuallly you want the connection to be closed when the db
                // method finishes (second parameter = true). The reason is that
                // if you leave it open (second parameter = false) then you risk
                // the database connection might time out and close on its own.
                db.insertRecord("order_history", colDescriptors, colValues, false);
                colDescriptors.clear();
                colValues.clear();
            }
            db.closeConnection();

        } catch (IllegalArgumentException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }
}
