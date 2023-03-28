<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>

<style>
a{
text-decoration: none;
}

.buttons{
	padding: 10px;
	width:300px;
	margin: 10px;
	background-color: lightblue;
	color: white;
	border-radius: 7px;
}
</style>


</head>
<body>

	<%@include file="header.jsp" %>


	<h2>Please choose a particular action you want to perform</h2>
	
	<a href="getTransactionHistory.jsp"><div class="buttons">Transaction History</div></a>
	
	<a href="updatePinPage.jsp"><div class="buttons">Update Pin</div></a>
	
	<a href="updateEmailPage.jsp"><div class="buttons">Update Email</div></a>
	
	<a href="updateNumberPage.jsp"><div class="buttons">Update Number</div></a>
</body>
</html>