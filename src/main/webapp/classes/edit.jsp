<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 4/3/2022
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Classes Management</title>
</head>
<body>
<center>
    <h1>Classes Management</h1>
    <h2>
        <a href="classes?action=classes">List all classes</a>
    </h2>
</center>
<div align="center">
    <form action="" method="post">
        <table border="1px" cellpadding="5px">
            <caption>
                <h2>
                    Edit Class
                </h2>
            </caption>
            <c:if test="${classes != null}">
                <input type="hidden" name="id" value="<c:out value='${classes.id}' />"/>
            </c:if>
            <tr>
                <th>Class name</th>
                <td><input type="text" name="name" , size="50" value="<c:out value='${classes.getName()}' />"></td>
            </tr>
            <tr>
                <th>Class description</th>
                <td><input type="text" name="description" , size="50" value="<c:out value='${classes.description}' />"></td>
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
