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
            <div class="w-50 mx-auto mt-5 p-5">            	
            	<ul class="list-group p-5">
				  <li class="list-group-item">ID : ${member.userName}</li>
				  <li class="list-group-item">Name : ${member.name}</li>
				  <li class="list-group-item">Phone : ${member.phone}</li>
				  <li class="list-group-item">Email : ${member.email}</li>
				  <li class="list-group-item">Addr : ${member.address}</li>
				  <li class="list-group-item">File : ${member.avatarDTO}</li>
				  <li class="list-group-item">Photo : 
				  	<a href="../resources/upload/join/${member.avatarDTO.fileName}">${member.avatarDTO.oriName}</a>
				  </li>
				</ul>
				<div>
					<a class="btn btn-primary" href="./update">수정</a>
					<a class="btn btn-primary" href="./updatePassword">비밀번호수정</a>
					<a class="btn btn-danger" href="./delete">탈퇴</a>
				</div>
            </div>
        </main>
	<!-- Footer-->
	<!-- 사용전 경로를 꼭 수정하세요 -->
	<c:import url="../temps/footer.jsp"></c:import>
    </body>
</html>
