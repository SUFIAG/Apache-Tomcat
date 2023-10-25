<%--
     Created by IntelliJ IDEA.
    Author: Devansh Shukla (D-Coder135)
    Date: 19-06-2022/06/2022
    Time: 01:03 PM
    File: custom-tag-demo
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="my-custom-tag-library" prefix="de_coder135" %>

<html>
<head>
    <title>Custom Action/Tag Demo.</title>
</head>
<body>
    <h1>Custom Tag/Action Demo.</h1>
    <hr>

    <de_coder135:date /><br>
    <de_coder135:date pattern="d/M/yyyy"/><br>
    <de_coder135:date pattern="EEEE MMMM d, yyyy"/><br>
    <de_coder135:date pattern="yyyy-MM-dd hh:mm:ss"/><br>

    <de_coder135:table>
        id, name, email, city
        1, Devansh, devansh123@gmail.com, Bengaluru
        2, Akanksha, akanksha123@gmail.com, Varanasi
        3, Harshit, hardixit@gmail.com, Kanpur
        4, Ashu, ashuoddey@gmail.com, Varanasi
    </de_coder135:table>
</body>
</html>
