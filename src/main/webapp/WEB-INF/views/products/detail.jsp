<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temps/bootStrap_css.jsp"></c:import>
</head>
<body>
	<c:import url="../temps/header.jsp"></c:import>
	
	    <section class="container-fluid">
    	<div>
	    	<c:if test="${dto != null}">
	    		<h3>${dto.productNum}</h3>
	    		<div>${dto.productName}</div>
	    		<div>${dto.productRate}</div>
	    		<div>${dto.productJumsu}</div>
	    		<div>
	    			<h3>File</h3>	    			
	    			<c:forEach items="${dto.productFileDTOs}" var="i">
						<a href="/resources/upload/products/${i.fileName}">${i.oriName}</a>
					</c:forEach>
				</div>
	    	</c:if>
	    	<c:if test="${empty dto}">
	    		<h3>없는 번호 입니다.</h3>
	    	</c:if>
    	</div>
   	    	<button id="del">Delete</button>
	    	<form id="frm" action="./delete" method="post">
	    		<input type="hidden" name="productNum" value="${dto.productNum}">
	    	</form>
    </section>
	
	
	<c:import url="../temps/bootStrap_js.jsp"></c:import>
	<script src="../resources/js/productDetail.js"></script>	
</body>
</html>