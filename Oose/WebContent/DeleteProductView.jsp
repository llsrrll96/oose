<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="persistance.ProductDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
	String id = request.getParameter("id");
	ProductDAO productDAO = new ProductDAO();
	productDAO.deleteProduct(id);

	
	response.sendRedirect("/oose/mngProduct");
%>

</body>
</html>