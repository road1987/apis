<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	${message}
<h3>Enterprise</h3>
<c:if  test="${!empty enterpriseList}">
<table class="data" border=1>
<tr>
    <th>Name</th>
    <th>Address</th>
    <th>Telephone</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${enterpriseList}" var="e">
    <tr>
        <td>${e.name} </td>
        <td>${e.address}</td>
        <td>${e.telephone}</td>
        <td><a href="delete/${e.id}">delete</a>&nbsp;&nbsp;<a href="update/${e.id}">update</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
<a href="add.html">Add record</a>
</body>
</html>