<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
	<c:import url="../temps/bootStrap_css.jsp"></c:import>
	<!--summer note-->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
	<c:import url="../temps/header.jsp"></c:import>
	<section id="contents" class="container-fluid" >
		<div class=row mt-4>
			<form action="add" method="post" enctype="multipart/form-data">
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
			  <div class=mb-3>
			  	<input type="file" name="photo">
			  	<input type="file" name="photo">
			  	<input type="file" name="photo">
			  </div>
			  
			  <button type="submit" class="btn btn-primary">전송</button>
			</form>
		</div>
	 </section>
	<script>
		$('#regionContents').summernote()
	</script>
	<c:import url="../temps/bootStrap_js.jsp"></c:import>
</body>
</html>