<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피자 주문 결과</title>
</head>
<body>
	<h3>피자 종류 : <%=request.getAttribute("pizzaName") %>
				   (<%= request.getParameter("size") %>)
	</h3>
				   
		<h3>수령 : <%=request.getParameter("amount") %></h3>
		<h3>총 가격 : <%=request.getAttribute("price") %></h3>		   
				   
</body>
</html>