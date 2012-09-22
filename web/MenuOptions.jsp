<%@page import="com.wctc.distjava.ch3.model.MenuItem"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Options JSP Page</title>
    </head>
    <body style="background-color:#FFD700;text-align:left">
        <h1>Best in Town proudly features</h1>
        <form method="POST" action="GetMenu?action=saveOrder" >
            <p>Please select our entries</p>
 
            <%
                List<MenuItem> menuList = 
                        (List<MenuItem>) request.getAttribute("menuList");           
                for(MenuItem menuItem : menuList) {
                    String item = menuItem.getItemName();
                            
            %>
            <input type="checkbox" name="menuItems" value="<%= item %>" /> <%= item %><br/>
                    
            <%
                }
            %>
                     
            <br/>
            <input type="submit" value="Place Order" name="submit">
        </form>
        <br>    
    </body>
</html>
