package com.wctc.distjava.ch3.model;

import java.util.*;

/**
 * This service class decouples the controller code from the data access code.
 * The advantage is that we can change what we access without breaking
 * anything. For example, here we can switch between production and development
 * databases.
 */
public class OrderService {
    private List<MenuItem> menuList;
    private IOrderDAO orderDao;

    public OrderService() {
        orderDao = new OrderDAODev();
//        initItemsDb();
    }

    private void initItemsDb() {
//        orderDao = new OrderDAODev();
//        menuList = orderDao.getCurrentMenuChoices();
    }
    
    public void placeOrder(List<MenuItem> orderList) {
        orderDao.saveOrder(orderList);
    }

    public List<MenuItem> getMenuList(String menuType) {
         menuList = orderDao.getCurrentMenuChoices(menuType);
        return menuList;
    }

    public void setMenuList(List<MenuItem> menuList) {
        this.menuList = menuList;
    }

    public IOrderDAO getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(IOrderDAO orderDao) {
        this.orderDao = orderDao;
    }

}
