<%@page import="com.wctc.distjava.ch3.model.MenuItem"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Options JSP Page</title>
    </head>
    <body style="background-color:#FFD700;text-align:left">
        <h1>Best in Town Restaurant</h1>
        <h2>Thank you! Your meal order has been placed.</h2>
        <p>You ordered the following:</p>
        <ul>
            <%
                List<MenuItem> orderList = 
                        (List<MenuItem>) request.getAttribute("orderList");           
                for(MenuItem orderItem : orderList) {
                    String item = orderItem.getItemName();
                            
            %>
            <li>  <%= item %> </li>
                    
            <%
                }
            %>

            </ul>
            <p>Please select <a href="index.jsp">menu </a> to place a new order</p> 
    </body>
</html>
