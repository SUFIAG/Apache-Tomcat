<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %><%--
     Created by IntelliJ IDEA.
    Author: Devansh Shukla (D-Coder135)
    Date: 18-06-2022/06/2022
    Time: 11:56 PM
    File: customer-list.jsp
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    Connection connection;
    public void jpsInit() {
        try {
            Class.forName("org.h2.Driver");
            String url = "jdbc:h2:tcp://localhost/~/training";
            String user = "devansh";
            String password = "secret";
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void jspDestroy() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
%>

<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customer List</h1>
<hr>
<p>Powered By JSP.</p>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>City</th>
        <th>Email ID</th>
        <th>Phone</th>
    </tr>
    </thead>

    <tbody>
    <%
        try {
            PreparedStatement statement = connection.prepareStatement("select * from customers");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
    %>
    <tr>
        <td><%= resultSet.getInt("id") %></td>
        <td><%= resultSet.getString("name") %></td>
        <td><%= resultSet.getString("city") %></td>
        <td><%= resultSet.getString("email") %></td>
        <td><%= resultSet.getString("phone") %></td>
    </tr>
    <%
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>
    </tbody>

</table>
</body>
</html>
