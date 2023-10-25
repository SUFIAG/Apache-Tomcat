<%--
  Created by IntelliJ IDEA.
  User: devan
  Date: 18-06-2022
  Time: 09:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello, JSP!</title>
</head>
<body>
<h1>Hello, JSP!</h1>
<hr>
<p>Developed By Devansh K Shukla aka De_Coder135!</p>

<form action="">
    Enter Your Name:
    <input type="text" name="your_name">
    <button>Submit</button>
</form>

<%
String name = request.getParameter("your_name");
    if (name != null) {
        out.println("<h3>Hello, " + name + "!</h3>");
    }
%>

</body>
</html>
