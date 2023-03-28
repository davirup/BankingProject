<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page errorPage="error.jsp"%>
    
    <%@page import="database.Passbook"%>
 <%@page import="java.util.ArrayList"%>
 <%@page import="java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%! 
	
	ArrayList<Passbook> list;
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<style>

th, td{
	padding: 7px;
}
	
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


<body>
	
	<%@ include file="header.jsp" %>
	
	
	<%list =(ArrayList<Passbook>)request.getAttribute("data"); %>
	
	
	
	<h3>Your transaction history is: </h3>

	<table>
		<tr>
			<th><b>Account Number</b>
			<th><b>Deposit</b>
			<th><b>Withdrawal</b>
			<th><b>Particular</b>
			<th><b>Balance</b>
			<th><b>Date</b></th>
		</tr>
		
		<%  
		
		for(Passbook entry :list)	{%>
		
		<tr>
			<td><%= entry.getAccountnumber()%></td>
			<td><%=entry.getDeposit()%></td>
			<td><%=entry.getWithdrawal()%></td>
			<td><%=entry.getParticular()%></td>
			<td><%=entry.getBalance()%></td>
			<td><%=entry.getDate()%></td>
		</tr>
		
		<%} %>
	</table>
	
	<a href="home.jsp"><div class="buttons">Home</div></a>
	
</body>
</html>