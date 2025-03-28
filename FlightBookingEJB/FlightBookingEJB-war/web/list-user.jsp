<%-- 
    Document   : list-user
    Created on : Mar 28, 2025, 3:55:32 PM
    Author     : dangx
--%>

<%@page import="entities.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            List<User> listUser = (List<User>)session.getAttribute("listUser");
            for (int i = 0; i < listUser.size(); i++) {
                    %>
                    <p><%= listUser.get(i).getName() %></p><br>
                    <%
                }
        %>
    </body>
</html>
