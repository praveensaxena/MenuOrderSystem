package com.wctc.distjava.ch3.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Praveen Saxena
 */
public class MenuExpert {
    private OrderService orderService;
    private final boolean DEBUG = false;

    public MenuExpert() {
        orderService = new OrderService();
    }
    
    
    public List<MenuItem> getMenuEntries(String menuType){
        List<MenuItem> menuList = orderService.getMenuList(menuType);
        return menuList;
    }
    
    public void saveOrder(List<MenuItem> order){
        System.out.println(" Praveen - Order is getting placed");
        orderService.placeOrder(order);
    }
}
