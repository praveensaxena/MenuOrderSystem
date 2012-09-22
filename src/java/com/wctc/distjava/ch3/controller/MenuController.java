package com.wctc.distjava.ch3.controller;

import com.wctc.distjava.ch3.model.MenuExpert;
import com.wctc.distjava.ch3.model.MenuItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Praveen Saxena
 */
public class MenuController extends HttpServlet {

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        String destination = "";
        String[] orderItems = null;

        String action = request.getParameter("action");
        String serveFor = request.getParameter("menuentry");

        MenuExpert me = new MenuExpert();
        List<MenuItem> menuList = me.getMenuEntries(serveFor);



        if (action.equals("getList")) {
            destination = "MenuOptions.jsp";
            request.setAttribute("menuList", menuList);

            RequestDispatcher view = request.getRequestDispatcher(destination);
            view.forward(request, response);
        } else if (action.equals("saveOrder")) {
            List<MenuItem> orderList = new ArrayList<MenuItem>();
            orderItems = request.getParameterValues("menuItems");

            for (String item : orderItems) {
                for (MenuItem menuItem : menuList) {
                    if (menuItem.getItemName().equals(item)) {
                        orderList.add(menuItem);
                        break;
                    }
                }
            }
            if (orderList.size() > 0) {
                me.saveOrder(orderList);
                destination = "OrderList.jsp";
                request.setAttribute("orderList", orderList);

                RequestDispatcher view = request.getRequestDispatcher(destination);
                view.forward(request, response);
            }

        }


    }
}
