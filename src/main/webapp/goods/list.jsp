<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<title>Insert title here</title>
</head>
<body>

<h3>Goods</h3>
<c:if  test="${!empty goodsList}">
<table class="data" border=1>
<tr>
	<th>Id</th>
    <th>Code</th>
    <th>Name</th>
    <th>price</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${goodsList}" var="e">
    <tr>
    	<td>${e.id}</td>
        <td>${e.code} </td>
        <td>${e.name} </td>
        <td>${e.price}</td>
        <td><a href="delete/${e.id}">delete</a>&nbsp;&nbsp;<a href="update/${e.id}">update</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
<a href="add.html">Add record</a>
</body>
</html>