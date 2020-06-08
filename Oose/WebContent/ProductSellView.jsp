<%@ page import = "java.util.List" %>
<%@ page import="persistance.ProductSell"%>
<%@ page import="persistance.ProductSellDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 판매 실적 집계</title>
	
	<style type="text/css">
	
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
 
        <div class="product_contents">
            <h4>상품 판매 집계 현황</h4>
            <table class="productTb">
                <thead>
                    <tr>
                        <th>판매ID</th>
                        <th>상품ID</th>
                        <th>판매갯수</th>
                        <th>판매가격</th>
                        <th>합계</th> 
                        <th>판매일자</th>
                        <th>결제자</th>
                    </tr>
                </thead>
                <%
                	
                	List<ProductSell> list = (List<ProductSell>) request.getAttribute("productSellList");
                	for(ProductSell productSell : list){
                		pageContext.setAttribute("productSell", productSell);
                		int sum = productSell.getQuantity() * productSell.getPrice();
                %>
                
                <tbody>
                    <tr>
                        <td>${productSell.sell_ID}</td>
                        <td>${productSell.product_ID}</td>
                        <td>${productSell.quantity}</td>
                        <td>${productSell.price}</td>
                        <td><%=sum %></td>
                        <td>${productSell.sell_Date}</td>
                        <td>${productSell.seller}</td>
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
