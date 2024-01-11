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
					<a href="/resources/upload/products/${dto.productFileDTO.fileName}">${dto.productFileDTO.oriName}</a>
				</div>
	    	</c:if>
	    	<c:if test="${empty dto}">
	    		<h3>없는 번호 입니다.</h3>
	    	</c:if>
    	</div>
    	<a href="">Update</a>
    </section>
	
	
	<c:import url="../temps/bootStrap_js.jsp"></c:import>
</body>
</html>