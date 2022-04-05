<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 4/3/2022
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Management</title>
</head>
<body>
<center>
    <h1>Student Management</h1>
    <h2>
        <a href="students?action=classes">List of Student</a>
    </h2>
</center>
<div align="center">
    <form action="" method="post">
        <table border="1px" cellpadding="5px">
            <caption>
                <h2>Add new student</h2>
            </caption>
            <tr>
                <th>Student first name:</th>
                <td>
                    <input type="text" name="firstname", id="firstname", size="50"/>
                </td>
            </tr>
            <tr>
                <th>Student last name</th>
                <td>
                    <input type="text" name="lastname" id="lastname" size="50"/>
                </td>
            </tr>
            <tr>
                <th>Student address</th>
                <td>
                    <input type="text" name="address" id="address" size="50"/>
                </td>
            </tr>
            <tr>
                <th>Choice Class</th>
                <td>
                    <select name="classes" id="classes">
                        <c:forEach var="c" items="${classes}">
                            <option value="${c.id}">${c.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
