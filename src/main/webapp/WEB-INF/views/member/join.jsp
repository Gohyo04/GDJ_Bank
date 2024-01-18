<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Personal - Start Bootstrap Theme</title>
        <!-- 사용전 경로를 꼭 수정하세요 -->
        <c:import url="../temps/head_css.jsp"></c:import>
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <!-- 사용전 경로를 꼭 수정하세요 -->
			<c:import url="../temps/header.jsp"></c:import>
			<div class="w-50 mx-auto">
	            <form method="post" enctype="multipart/form-data">
	            	<div class="mb-3">
				    <label for="name" class="form-label">Name</label>
				    <input type="text" name="name" class="form-control" id="name">
				  </div>
				  <div class="mb-3">
				    <label for="userName" class="form-label">ID</label>
				    <input type="text" name="userName" class="form-control" id="userName">
				  </div>
				  <div class="mb-3">
				    <label for="password" class="form-label">Password</label>
				    <input type="password" name="password" class="form-control" id="password">
				  </div>
				  <div class="mb-3">
				    <label for="email" class="form-label">Email</label>
				    <input type="email" name="email" class="form-control" id="email">
				  </div>
				  <div class="mb-3">
				    <label for="phone" class="form-label">Phone</label>
				    <input type="text" name="phone" class="form-control" id="phone">
				  </div>
				  <div class="mb-3">
				    <label for="address" class="form-label">Address</label>
				    <input type="text" name="address" class="form-control" id="address">
				  </div>
				  
                  <div class="mb-3">
                     <input class="form-control" type="file" name="f">
                  </div>
				  
				  <button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
        </main>
	<!-- Footer-->
	<!-- 사용전 경로를 꼭 수정하세요 -->
	<c:import url="../temps/footer.jsp"></c:import>
    </body>
</html>
