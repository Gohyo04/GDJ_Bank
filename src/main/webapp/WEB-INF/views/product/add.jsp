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
        <c:import url="./head_css.jsp"></c:import>
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <!-- 사용전 경로를 꼭 수정하세요 -->
			<c:import url="./header.jsp"></c:import>
            
        </main>
	<!-- Footer-->
	<!-- 사용전 경로를 꼭 수정하세요 -->
	<div>
		<form id="contactForm" data-sb-form-api-token="API_TOKEN">
	         <!-- 상품명 input-->
	         <div class="form-floating mb-3">
	             <input class="form-control" id="name" type="text" placeholder="Enter your name..." data-sb-validations="required" />
	             <label for="name">Full name</label>
	             <div class="invalid-feedback" data-sb-feedback="name:required">A name is required.</div>
	         </div>
	         <!-- detail input-->
	         <div class="form-floating mb-3">
	             <input class="form-control" id="email" type="email" placeholder="name@example.com" data-sb-validations="required,email" />
	             <label for="email">Email address</label>
	             <div class="invalid-feedback" data-sb-feedback="email:required">An email is required.</div>
	             <div class="invalid-feedback" data-sb-feedback="email:email">Email is not valid.</div>
	         </div>
	         <!-- 이자율 input-->
	         <div class="form-floating mb-3">
	             <input class="form-control" id="phone" type="tel" placeholder="(123) 456-7890" data-sb-validations="required" />
	             <label for="phone">Phone number</label>
	             <div class="invalid-feedback" data-sb-feedback="phone:required">A phone number is required.</div>
	         </div>
	         <!-- 청부파일 input (5개)-->
	         <div class="form-floating mb-3">
	             <input type="file">
	         </div>
	         <!-- Submit success message-->
	         <!---->
	         <!-- This is what your users will see when the form-->
	         <!-- has successfully submitted-->
	         <div class="d-none" id="submitSuccessMessage">
	             <div class="text-center mb-3">
	                 <div class="fw-bolder">Form submission successful!</div>
	                 To activate this form, sign up at
	                 <br />
	                 <a href="https://startbootstrap.com/solution/contact-forms">https://startbootstrap.com/solution/contact-forms</a>
	             </div>
	         </div>
	         <!-- Submit error message-->
	         <!---->
	         <!-- This is what your users will see when there is-->
	         <!-- an error submitting the form-->
	         <div class="d-none" id="submitErrorMessage"><div class="text-center text-danger mb-3">Error sending message!</div></div>
	         <!-- Submit Button-->
	         <div class="d-grid"><button class="btn btn-primary btn-lg" id="submitButton" type="submit">상품등록</button></div>
	     </form>
	</div>
	
	
	
	<c:import url="./footer.jsp"></c:import>
    </body>
</html>
