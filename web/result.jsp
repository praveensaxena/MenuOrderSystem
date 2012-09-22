<%-- 
    Document   : result
    Created on : Sep 9, 2012, 10:29:10 AM
    Author     : Praveen Saxena
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Best in Town Restaurant Menu</title>
    </head>
    <body style="background-color:#FFD700;text-align:center">
        <h1>Chef's Recommendations</h1>
        <p style="font-family:verdana;color:green;">
        <%
        List recs = (List)request.getAttribute("entries");
        Iterator it = recs.iterator();
        while(it.hasNext()) {
            // Notice we're outputting some HTML. Is that a good idea?
            // Also, notice we do not cast the object returned by the
            // iterator to a String. Why?
            out.print("<br>" + it.next());
        }    
        %>
    </body>
</html>
