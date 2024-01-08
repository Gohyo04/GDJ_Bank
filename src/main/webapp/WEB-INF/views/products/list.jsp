<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<c:import url="../temps/bootStrap_css.jsp"></c:import>
</head>
<body>
	<c:import url="../temps/header.jsp"></c:import>
		<div class="mx-auto p-2 w-75">
		<h1 class="mx-auto py-5" style="width: 200px;">PRODUCT</h1>
		<table class="table">
		<thead class="table-dark">
			<tr>
				<th>Num</th>
				<th>Name</th>
				<th>Rate</th>
				<th>Jumsu</th>
			</tr>
		</thead>
		<tbody class="table-group-divider">
			<c:forEach items="${requestScope.list}" var="dto">
				<tr>
					<td>${dto.productNum}</td>
					<td class="col-6"><a href="./detail?productNum=${dto.productNum}">${dto.productName}</a></td>
					<td>${dto.productRate}</td>
					<td>${dto.productJumsu}</td>
				</tr>
			</c:forEach>	
		</tbody>
	</table>
	</div>

	<c:import url="../temps/bootStrap_js.jsp"></c:import>
</body>
</html>