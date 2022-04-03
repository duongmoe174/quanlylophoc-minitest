<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 4/3/2022
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Classes</title>
</head>
<body>
<center>
    <h1>Classes Management</h1>
    <h2>
        <a href="classes?action=create">Add new classes</a>
    </h2>
</center>

<div align="center">
    <table border="1px" cellpadding="5">
        <caption><h2>List of classes</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
        </tr>
        <c:forEach var="classes" items="${listClasses}">
            <tr>
                <td><c:out value="${classes.id}"/></td>
                <td><c:out value="${classes.name}"/></td>
                <td><c:out value="${classes.description}"/></td>
                <td>
                    <a href="">Edit</a>
                    <a href="classes?action=delete&id=${classes.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
