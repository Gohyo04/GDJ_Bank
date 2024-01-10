<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
	<c:import url="../temps/bootStrap_css.jsp"></c:import>
</head>
<body>
	<c:import url="../temps/header.jsp"></c:import>
	<div>
		<form action="add" method="post" class="m-3">
		  <div class="mb-3">
		    <label for="productName" class="form-label">ProductName</label>
		    <input type="text" name="productName" class="form-control" id="productName">
		  </div>
		  <div class="mb-3">
		    <label for="contents" class="form-label">ProductContents</label>
		    <input type="text" name="productContents" class="form-control" id="contents">
		  </div>
		  <div class="mb-3">
		    <label for="rate" class="form-label">ProductRate</label>
		    <input type="number" name="productRate" class="form-control" id="rate">
		  </div>
		  <div class="mb-3">
		    <label for="jumsu" class="form-label">ProductJumsu</label>
		    <input type="number" name="productJumsu" class="form-control" id="jumsu">
		  </div>
		  
		  <button type="submit" class="btn btn-primary">전송</button>
		</form>
	</div>
	<c:import url="../temps/bootStrap_js.jsp"></c:import>
</body>
</html>