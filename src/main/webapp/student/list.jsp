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
    <title>Student</title>
</head>
<body>
<center>
    <h1>Student Management</h1>
    <h2>
        <a href="students?action=create">Add new student</a>
    </h2>
</center>

<div align="center">
    <table border="1px" cellpadding="5">
        <caption><h2>List of Student</h2></caption>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Address</th>
            <th>Class</th>
        </tr>
        <c:forEach var="students" items="${students}">
            <tr>
                <td><c:out value="${students.id}"/></td>
                <td><c:out value="${students.firstname}"/></td>
                <td><c:out value="${students.lastname}"/></td>
                <td><c:out value="${students.address}"/></td>
                <td><c:out value="${students.classes.name}"/></td>
                <td>
                    <a href="students?action=edit&id=${students.id}">Edit</a>
                    <a href="students?action=delete&id=${students.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
