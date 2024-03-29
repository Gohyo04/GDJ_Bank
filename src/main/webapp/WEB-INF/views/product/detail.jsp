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
			<!-- 사용전 경로를 꼭 수정하세요  -->
			<!-- Navigation-->
			<c:import url="../temps/header.jsp"></c:import>
			<div class="container px-5 my-5">
				<div class="text-center mb-5">
	
					<div class="container-lg">
						<c:if test="${not empty dto}">
							<table class="table table-hover">
								<thead>
									<tr class="table-dark">
										<th>Product Num</th>
										<th>Product Name</th>
										<th>Product Contents</th>
										<th>Product Rate</th>
										<th>Product Jumsu</th>
										<th>Product File</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>${dto.productNum}</td>
										<td>${dto.productName}</td>
										<td>${dto.productContents}</td>
										<td>${dto.productRate}</td>
										<td>${dto.productJumsu}</td>
										<td>
											<c:forEach items="${dto.productFileDTOs}" var="f">
												<a href="/resources/upload/product/${f.fileName}">${f.oriName}</a>
												<br>
											</c:forEach>
										</td>
									</tr>
								</tbody>
							</table>
							<button class="btn btn-light" id="up"
								data-product-num="${detail.productNum}">수정</button>
							<button class="btn btn-light" id="del">삭제</button>
							<c:if test="${member ne null}">
								<button class="btn btn-light" id="create">상품가입</button>
								<button class="btn btn-light" id="wishList">관심상품</button>
							</c:if>
							<form id="frm" action="./update" method="get">
								<input type="hidden" name="productNum"
									value="${dto.productNum}">
							</form>
						</c:if>
						<c:if test="${empty dto}">
							<h3>없는 상품번호 입니다</h3>
						</c:if>
					</div>
	
					<div class="my-3">
						<table>
							<tr>
								<th>Contents</th>
								<th>Writer</th>
								<th>Date</th>
								<th></th>
								<th></th>
							</tr>
						</table>

						<tbody id="replyList" data-user="${member.userName}">
							
						</tbody>

						<div>
							<button id="more" data-replyList-page="1" data-replyList-totalPage="1">더보기</button>
						</div>
					</div>
	
					<div class="my-3">
						<form id="replyForm">
							  <input type="hidden" name="productNum" value="${dto.productNum}">	
							  <div class="mb-3">
								<textarea class="form-control" name="commentContents" id="commentContents" rows="3"></textarea>
							  </div>
							  <div class="mb-3">
							  <select class="form-select" name="commentJumsu" aria-label="Default select example">
								<option value="5">5</option>
								<option value="4">4</option>
								<option value="3">3</option>
								<option value="2">2</option>
								<option value="1">1</option>
							  </select>
							  </div>
	
							  <div>
								<button type="button" class="btn btn-primary" id="replyAdd">댓글달기</button>
							  </div>
						</form>
	
					</div>
	
				</div>
	
			</div>
		</main>

		<!-- Modal -->
		<div class="modal fade" id="replyUpdateModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form method="post" id="replyUpdateForm">
							<textarea class="form-control" name="commentContents" id="replyUpdateContents" rows="3"></textarea>
							<input type="hidden" id="replyUpdateNum" name="commentNum" value="${commentNum}">
							<input type="hidden" id="replyWriter" name="userName" value="">
						</form>
					</div>
					<div class="modal-footer">
					<button type="button" id="replyCloseButton" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
					<button type="button" id="replyUpdateButton" class="btn btn-primary">Update</button>
				</div>
			</div>
			</div>
		</div>

		<!-- 사용전 경로를 꼭 수정하세요  -->
		<!-- Footer  -->
		<c:import url="../temps/footer.jsp"></c:import>
		<script src="../resources/js/scripts.js"></script>
		<script src="../../../resources/js/wishlist/wishlist.js"></script>
		<script src="../../../resources/js/productDetail.js"></script>
	</body>
</html>