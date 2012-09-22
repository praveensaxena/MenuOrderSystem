<%-- 
    Document   : index
    Created on : Sep 9, 2012, 11:05:02 AM
    Author     : Bittu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Best in Town Restaurant</title>
    </head>
    <body style="background-color:#FFCC99;text-align:center">
        <h1>Thanks for selecting Best in Town restaurant</h1>
        <br><br>
        <form method="POST" action="GetMenu?action=getList">
            <p>Please select our entries</p>
 
            <select id="entry" name="menuentry">
                <option value="breakfast">Breakfast Menu</option>
                <option value="lunch">Lunch Menu</option>
                <option value="dinner">Dinner Menu</option>
            </select>
            <br><br>
            <center>
                <input type="SUBMIT" value="View Selections">
            </center>
            
        </form>
    </body>
</html>
