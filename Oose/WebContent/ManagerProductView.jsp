<%@ page import = "java.util.List" %>
<%@ page import="persistance.Product"%>
<%@ page import="persistance.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자용 상품 정보</title>
	
   	<link href="${pageContext.request.contextPath}/css/UPV.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="m_contents">
        <div class="search_contents">
        </div>
        <div class="product_contents">
            <h4>상품 목록</h4>
            <table class="productTb">
                <thead>
                    <tr>
                        <th>상품 코드</th>
                        <th>상품명</th>
                        <th>상품 분류</th>
                        <th>상품 가격</th>
                        <th>상품 수량</th>
                        <th>수정</th>
                        <th>삭제</th>
                    </tr>
                </thead>
                <%
                	List<Product> pdList = (List<Product>) request.getAttribute("productList");
                                	for(Product dto : pdList){
                                		pageContext.setAttribute("dto", dto);
                %>
                
                <tbody>
                    <tr>
                        <td>${dto.product_ID}</td>
                        <td>${dto.product_Name}</td>
                        <td>${dto.product_Kinds}</td>
                        <td>${dto.product_Price}</td>
                        <td>${dto.product_Stock}</td>
                        <td><a href="UpdateProductView.jsp?id=<%=dto.getProduct_ID() %>" >수정</a></td>
                        <td><a href="DeleteProductView.jsp?id=<%=dto.getProduct_ID() %>" >삭제</a></td>
                    </tr>
                </tbody>
                <%} %>
            </table>
        </div>
    </div>

</body>
</html>


