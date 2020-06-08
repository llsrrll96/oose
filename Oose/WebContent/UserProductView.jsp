<%@ page import = "java.util.List" %>
<%@ page import="persistance.Product"%>
<%@ page import="persistance.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 정보</title>
    
	<style type="text/css">
	
<!--검색-->
        .search_contents{
            border:1px solid #dfdfdf;
            width: 800px;
            height: 48px;
            line-height: 48px;
            margin-bottom: 30px;
        }

		#btnRegister{
			border-radius:10px;
			background-color: blue;
		}
        <!--테이블-->
        
        table {
    		width: 100%;
    		border: 1px solid #444444;
   			border-collapse: collapse;
            border-spacing: 0;
            margin-bottom: 30px;
  		}
  		
        .productTb >thead > tr > th{
            height: 16px;
            border: 1px #dfdfdf solid;
            background: #f2f2f2;
            vertical-align: middle;
            
            border: 1px solid #444444;
    		padding: 10px;
        }
        
        .productTb >tbody > tr > td {
    		border: 1px solid #444444;
    		padding: 10px;
    		
  		}
	
	</style>	
</head>
<body>
    <div class="m_contents">
        <div class="search_contents">
            <form action="<%=request.getContextPath()%>/UserProductSearchView.jsp", method="post">
                <input type="text" name="searchText">
                <input type="submit" value="검색">
            </form>

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
                    </tr>
                </tbody>
                <%} %>
            </table>
        </div>
    </div>

</body>

</html>


<!-- 
모듈 설계자 : 박성용

검토자 : 박성용, 김인환
검토 날짜: 2020-06-05

 -->