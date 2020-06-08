<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="persistance.ProductDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<style>
	#enrollBox{ width:300px;}
	#enrollBox label{ display: block; width:300px; float:left;}
</style>

</head>
<body>

<form action="enrollProduct" method="Post" name="enrollForm">
	<fieldset id="enrollBox">
		<legend>상품등록</legend>
		<label for="Product_Name">상품 명</label>
		<input type="text" name="Product_Name" id="Product_Name"/><br/>
		<label for="Product_Kinds">상품 분류</label>
		<input type="text" name="Product_Kinds" id= "Product_Kinds"/><br/>
		<label for="Product_Price">상품 가격</label>
		<input type="text" name="Product_Price" id="Product_Price"/><br/>
		<label for="Product_Stock">수량</label>
		<input type="text" name="Product_Stock" id="Product_Stock"/><br/>
		
		<input type="button" value="등록"	onClick = "checkData()"/>
		<input type="reset" value="취소"/>
		<input type="button" value="갱신" onClick = "reloadParentPage()"/> 
	</fieldset>
</form>
	<%
		String result = (String)request.getAttribute("checkEnroll");
	 	if(result != null && !result.isEmpty()){
	 		if(result.equals("1")){
	%>
	<script>
			//성공일때
			(function(){
				alert("등록 성공");
				window.opener.location.reload();
			})();
	</script>
	<%		
			}else if(result.equals("0")){
	%>
	<script>
			(function(){
				alert("등록 실패");
			})();
	</script>
	<%
			}else if(result.equals("-1")){
				
	%>
		<script>
			(function(){
				alert("등록 실패 : 동일한 상품명 존재");
			})();
		</script>
	<% 
			}
	 	} 
	 %>
</body>

<script type="text/javascript">
	
	function checkData()
	{
		var enroll = document.enrollForm;
		
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
			enroll.submit();
		}
	}
	


</script>

</html>

<!-- 
모듈 설계자 : 박성용

검토자 : 박성용, 김인환
검토 날짜: 2020-06-05

수정 일자 : 2020-06-08
수정 내용 : DB결과에 따라 alert() 호출, line: 35 ~ 58
 -->