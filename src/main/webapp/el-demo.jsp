<%@ page import="com.example.apache_tomcat_demo.entity.Address" %>
<%@ page import="com.example.apache_tomcat_demo.entity.Person" %><%--
     Created by IntelliJ IDEA.
    Author: Devansh Shukla (D-Coder135)
    Date: 20-06-2022/06/2022
    Time: 11:30 AM
    File: el-demo
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL-Demo</title>
</head>
<body>
<h1>EL-Demo</h1>
<hr>

<%
    String name = "Devansh Kumar Shukla";
    pageContext.setAttribute("name", name);
    request.setAttribute("name", "Akanksha Singh");

    Address add = new Address("Bengaluru", "Karnataka");
    Person p1 = new Person("Devansh Kumar Shukla", add);
    request.setAttribute("person", p1);
%>

<div>
    Name: ${person.name} <br>
    City: ${person.address.city} <br>
    State: ${person.address.state} <br>
</div>

<h3>Hello ${name}</h3>
<h3>Hello ${requestScope.name}</h3>
<h3>Hello ${requestScope.name == null ? "Friend" : requestScope.name}</h3>

<form action="">
    <input type="text" placeholder="Enter a name: " name="your_name">
</form>

<h3>Hello, ${param.your_name == null ? "Friend" : param.your_name}</h3>

</body>
</html>
