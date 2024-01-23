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
            
            <div class="row gx-5 justify-content-center">
               <div class="col-lg-11 col-xl-9 col-xxl-8">
                   <form method="POST" enctype="multipart/form-data">
                	<input type="text" hidden value="${dto.productNum}">

                     <div class="mb-3">
                       <label for="accountPw" class="form-label">Password</label>
                       <input class="form-control" id="accountPw" name="accountPw"></input>
                     </div>

                     <div class="mb-3">
                       <button class="btn btn-primary">가입</button>
                     </div>
                  </form>
               </div>
                </div>
        </main>
	<!-- Footer-->
	<!-- 사용전 경로를 꼭 수정하세요 -->
	<c:import url="../temps/footer.jsp"></c:import>
    </body>
</html>
