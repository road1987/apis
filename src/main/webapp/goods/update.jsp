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
	<form method="post" action="/apis/goods/update" >
		<input name="id" type="hidden" value="${goods.id}"/>
		<table border=1>
		<tr>
			<td>code</td>
			<td><input name="code" type="text" value="${goods.code}"/></td> 
		</tr>
		<tr>
			<td>name</td>
			<td><input name="name" type="text" value="${goods.name}"/></td> 
		</tr>
		<tr>
			<td>price</td>
			<td><input name="price" type="text" value="${goods.price}"/></td> 
		</tr>
		</table>	
		<input type="submit" value="提交" />
	</form>

</body>
</html>