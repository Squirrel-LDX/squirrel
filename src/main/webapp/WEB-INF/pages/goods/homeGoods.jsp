<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'homeGoods.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<form>
		<table>
			<tr>
				<th>商品名</th>
				<th>价格</th>
				<th>商品描述</th>
				<th>上架时间</th>
			</tr>
			<c:forEach var="item" items="${catelogGoods2}">
				<tr>
					<td><c:out value="${item.name}"></c:out>
					</td>
					<td><c:out value="${item.price}"></c:out>
					</td>
					<td><c:out value="${item.desc}"></c:out>
					</td>
					<td><c:out value="${item.startTime}"></c:out>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>
