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
            <div class="container px-5">
            	<c:if test="${not empty dto}">
            		<ul class="list-group list-group-flush style="list-style: none">
					  <li class="list-group-item">${dto.productNum}</li>
					  <li class="list-group-item">${dto.productName}</li>
					  <li class="list-group-item">${dto.productContents}</li>
					  <li class="list-group-item">${dto.productRate}</li>
					</ul>
            	</c:if>
           	
    			<a id="del" class="btn btn-danger w-1">삭제</a>
    			<form id="frm" action="./delete" method="post">
    				<input type="hidden" name="productNum" value="${dto.productNum}">
    			</form>
    			<a class="btn btn-primary" href="../product/update?productNum=${dto.productNum}">수정</a>
				<a class="btn btn-dark" href="../account/add?productNum=${dto.productNum}">가입</a>
			</div>
        </main>
		<!-- Footer-->
		<!-- 사용전 경로를 꼭 수정하세요 -->
		<c:import url="../temps/footer.jsp"></c:import>
		<script src="../resources/js/scripts.js"></script>
    </body>
</html>
