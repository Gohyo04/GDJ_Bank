<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="deleteForm">
    <c:forEach items="${result}" var="dto">
        <tr>
            <td>
                <div class="form-check">
                    <input class="form-check-input checks" name="productNum" type="checkbox" value="${dto.productNum}" >
                </div>
            </td>
            <td>${dto.productNum}</td>
            <td><a href="../product/detail?productNum=${dto.productNum}">${dto.productName}</a></td>
            <td>${dto.productRate}</td>
            
        </tr>
    </c:forEach>
</form>