<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<tbody>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.commentNum}</td>
			<td>${dto.commentContents}</td>
			<td>${dto.commentJumsu}</td>
			<td>${dto.commentDate}</td>
		</tr>
		</c:forEach>
	</tbody>


