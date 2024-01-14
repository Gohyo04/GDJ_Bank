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
			
            
			<div class="container px-5 my-5">
	        	<div class="text-center mb-5">
                    <h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">Product List</span></h1>
           		</div>	
                <div>
                	<table class="table">
					  <thead>
					    <tr>
					      <th scope="col">ProductNum</th>
					      <th scope="col">productName</th>
					      <th scope="col">productContents</th>
					      <th scope="col">productRate</th>
					    </tr>
					  </thead>
					  <tbody class="table-group-divider">
						  <c:forEach items="${requestScope.list}" var="dto">
						    <tr>
						      <th>${dto.productNum}</th>
						      <td><a href="./detail?productNum=${dto.productNum}">${dto.productName}</a></td>
						      <td>${dto.productContents}</td>
						      <td>${dto.productRate}</td>
						   </tr>
				   		</c:forEach>
					  </tbody>
					</table>
                </div>
                
                <div>
					<nav aria-label="Page navigation example" class="mx-auto p-2" style="width: 200px;">
					  <ul class="pagination">
					  <c:if test="${!pager.start}">
					    <li class="page-item">
					      <a class="page-link" href="${pager.startNum-1}" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
					    </c:if>
					    
					    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					    	<li class="page-item">
					    		<a class="page-link" href="./list?page=${i}">
					    			${i}
					    		</a>
					    	</li>
					    </c:forEach>
					    
					    <c:if test="${pager.last}">
						    <li class="page-item">
						      <a class="page-link" href="./list?page=${pager.lastNum}" aria-label="Next">
						        <span aria-hidden="true">&raquo;</span>
						      </a>
						    </li>
					    </c:if>
					  </ul>
					</nav>
                </div>
                
                <div>
                	<a href="add" class="btn btn-danger">상품등록</a>
                </div>		
			</div>
            
        </main>
	<!-- Footer-->
	<!-- 사용전 경로를 꼭 수정하세요 -->
	<c:import url="../temps/footer.jsp"></c:import>
    </body>
</html>
