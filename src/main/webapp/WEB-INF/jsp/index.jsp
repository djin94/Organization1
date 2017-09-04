<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<a href="${pageContext.servletContext.contextPath}/jsp/CreateUser.jsp">Добавить пользователя</a>
<table border="1">
    <tr>
        <td>id</td>
        <td>Имя</td>
        <td>Должность</td>
        <td>Группа</td>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="status">
        <tr valign="top">
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.position.title}</td>
            <td>${user.group.title}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>