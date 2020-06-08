<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="persistance.ProductDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
<style>
	#updateBox{ width:300px;}
	#updateBox label{ display: block; width:300px; float:left;}

</style>

</head>
<body>

<form action="updateProduct" method="Post" name="updateForm">
	<fieldset id="updateBox">
		<legend>상품등록</legend>
		<label for="Product_ID">상품 코드</label>
		<%
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String kinds = request.getParameter("kinds");
			String price = request.getParameter("price");
			String stock = request.getParameter("stock");
			
			
		%>
		<input type="text" name="Product_ID" value=<%=id %> readonly="readonly"/><br/>
		<label for="Product_Name">상품 명</label>
		<input type="text" name="Product_Name" id="Product_Name" value=<%=name %>/><br/>
		<label for="Product_Kinds">상품 분류</label>
		<input type="text" name="Product_Kinds" id="Product_Kinds" value=<%=kinds %>/><br/>
		<label for="Product_Price">상품 가격</label>
		<input type="text" name="Product_Price" id="Product_Price" value=<%=price %>/><br/>
		<label for="Product_Stock">수량</label>
		<input type="text" name="Product_Stock" id="Product_Stock" value=<%=stock %>/><br/>
		
		<input type="button" value="수정"	onClick = "checkData()"/>
		<input type="reset" value="취소"/>
	</fieldset>
</form>
	<%
		String result = (String)request.getAttribute("updateCheck");
	 	if(result != null && !result.isEmpty()){
	 		if(result.equals("1")){
	%>
	<script>
		//성공일때
		(function(){
			alert("수정 성공");
			location.href="/oose/mngProduct";
		})();
	</script>
	<%		
		}else if(result.equals("0")){
	%>
	<script>
		(function(){
			alert("수정 실패");
		})();
	</script>
	<%
			}
	 	} 
	 %>


<script type="text/javascript">

	function checkData(){
		var update = document.updateForm;
		
		var name = document.getElementById('Product_Name').value;
		var kinds = document.getElementById('Product_Kinds').value;
		var price = document.getElementById('Product_Price').value;
		var stock = document.getElementById('Product_Stock').value;
		if(name == ""){ //빈칸인 경우
			alert("상품명을 입력해주세요");
		}else if(kinds ==""){
			alert("상품 분류명을 입력해주세요");
		}else if(price ==""){
			alert("가격을 입력해주세요");
		}else if(stock ==""){
			alert("수량을 입력해주세요");
		}else if(price < 0 | stock < 0){
			alert("0 이상으로 입력해주세요");
		}else if(isNaN(price) | isNaN(stock)){
			alert("숫자를 입력해주세요");
		}else{
			update.submit();
		}
		
	}
</script>

</body>
</html>

<!-- 
모듈 설계자 : 박성용

검토자 : 박성용, 김인환
검토 날짜: 2020-06-05

수정 일자 : 2020-06-08
수정 내용 : DB 실행 결과에 따라 알림 설정, line: 46 ~ 68
 -->