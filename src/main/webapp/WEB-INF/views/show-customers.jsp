<%--
     Created by IntelliJ IDEA.
    Author: Devansh Shukla (D-Coder135)
    Date: 21-06-2022/06/2022
    Time: 12:04 AM
    File: show-customers.jsp
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Customer List</title>
</head>
<body>

<h1>Customer List</h1>
<hr>
<p>MVC demo powered by servlets, jsp and mybatis</p>

<table border="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>City</th>
        <th>Email</th>
        <th>Phone</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.customers}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.city}</td>
            <td>${customer.email}</td>
            <td>${customer.phone}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
