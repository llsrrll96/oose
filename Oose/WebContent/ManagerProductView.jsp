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
  		
  		.update{
  			color : blue;
  		}
  		
 		.delete{
				color : red;
		}
		
	</style>
	
</head>
<body>
    <div class="m_contents">
        <div class="product_contents">
            <h4>상품 목록</h4>
           	<form action="enrollProduct", method="GET">
           		<input type="button" value= "상품등록" id="btnEnroll" onclick="showEnrollView()">
           	</form>
           	
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
                        <td class="update" ><a href="UpdateProductView.jsp?id=<%=dto.getProduct_ID() %>&name=<%=dto.getProduct_Name() %>
                        &kinds=<%=dto.getProduct_Kinds()%>&price=<%=dto.getProduct_Price()%>&stock=<%=dto.getProduct_Stock()%>">수정하기</td>
                        <td class="delete" onclick = "deleteProduct(<%=dto.getProduct_ID() %>)"><a href="#">삭제하기</a></td>
                    </tr>
                </tbody>
                <%} %>
            </table>
        </div>
    </div>

</body>

<script>


function showEnrollView() { //등록
	
    var url = "EnrollProductView.jsp";
    var title = "EnrollProductView";
    var option = "width = 500, height = 400, top = 100, left = 200, location = no"
   	window.open(url, title, option);
}


function deleteProduct(id)
{	
	var con_test = confirm(id+ "을(를) 정말로 삭제하겠습니까?");
	if(con_test) location.href = "deleteProduct?id="+id;
}

</script>

</html>

<!-- 
모듈 설계자 : 박성용

검토자 : 박성용, 김인환
검토 날짜: 2020-06-05

 -->
