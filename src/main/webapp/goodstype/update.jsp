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
	<form method="post" action="/apis/goodstype/update" >
		<input name="id" type="hidden" value="${goodsType.id}"/>
		<table border=1>
		<tr>
			<td>name</td>
			<td><input name="name" type="text" value="${goodsType.name}"/></td> 
		</tr>
		<tr>
			<td>description</td>
			<td><input name="description" type="text" value="${goodsType.description}"/></td> 
		</tr>
		</table>	
		<input type="submit" value="提交" />
	</form>

</body>
</html>