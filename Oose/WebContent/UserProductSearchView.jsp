<%@ page import = "java.util.List" %>
<%@ page import="persistance.ProductDTO"%>
<%@ page import="persistance.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>��ǰ ����</title>
	
   	<link href="${pageContext.request.contextPath}/css/UPV.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="m_contents">
        <div class="search_contents">
            <form action="<%=request.getContextPath()%>/UserProductSearchView.jsp", method="post">
                <input type="text" name="searchText">
                <input type="submit" value="�˻�">
            </form>

        </div>
        <div class="product_contents">
            <h4>��ǰ ���</h4>
            <table class="productTb">
                <thead>
                    <tr>
                        <th>��ǰ �ڵ�</th>
                        <th>��ǰ��</th>
                        <th>��ǰ �з�</th>
                        <th>��ǰ ����</th>
                        <th>��ǰ ����</th>
                    </tr>
                </thead>
                         
                <%
                	request.setCharacterEncoding("euc-kr");
                	String productName = request.getParameter("searchText");
                	
                	ProductDAO productDAO = new ProductDAO();
                	List<ProductDTO> searchList = productDAO.searchProduct(productName);
                	for(ProductDTO dto : searchList){
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