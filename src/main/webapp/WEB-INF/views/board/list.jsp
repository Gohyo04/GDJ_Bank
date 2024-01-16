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
        <title>${board}List</title>
        <!-- 사용전 경로를 꼭 수정하세요 -->
        <c:import url="../temps/head_css.jsp"></c:import>
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <!-- 사용전 경로를 꼭 수정하세요 -->
			<c:import url="../temps/header.jsp"></c:import>
            
            <section class="py-5">
					<div class="text-center mb-5">
                        <h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">${board}List</span></h1>
                    </div>
                    <div class="row gx-5 justify-content-center">
                        <div class="col-lg-11 col-xl-9 col-xxl-8">
                        	<!-- table -->
                        	<div>
                        		<table class="table table-hover">
                        			<thead>
                        				<tr class="table-warning">
                        					<th>No</th>
                        					<th>Title</th>
                        					<th>Writer</th>
                        					<th>Date</th>
                        					<th>Hit</th>
                        				</tr>
                       				</thead>
                       				<tbody>
										<c:forEach items="${list}" var="i">
										
											<c:set var="f" value="0"></c:set>
											<c:catch>
												<c:set var="f" value="${dto.flag}"></c:set>
												<c:if test="${f eq 0}"></c:if>
												<tr>
													<td></td>
													<td>삭제되었다.</td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												
											</c:catch>
											
											<c:if test="${f eq 1}"></c:if>
		                        				<tr>
													<td>${i.noticeNum}</td>
													<td>
														<a href="./detail?noticeNum=${i.noticeNum}">
															<c:catch>
																<c:forEach begin="1" end="${i.qnaDepth}">--</c:forEach>														
															</c:catch>
																
															${i.noticeTitle}
														</a>
													</td>
													<td>${i.noticeWriter}</td>
													<td>${i.noticeDate}</td>
													<td>${i.noticeCount}</td>
		                        				</tr>
	                        				
	                        			
										</c:forEach>                     					
                       				</tbody>
                        			
                        		</table>
                        		
                        		<div>
                        			<a href="./add" class="btn btn-danger">글쓰기</a>
                        		</div>
                        		
                        	</div>
                        </div>
                    </div>
            </section>
            
        </main>
	<!-- Footer-->
	<!-- 사용전 경로를 꼭 수정하세요 -->
	<c:import url="../temps/footer.jsp"></c:import>
    </body>
</html>
