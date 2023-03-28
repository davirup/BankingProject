<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page errorPage="error.jsp"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


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

	<a href="login.jsp"><div class="buttons">Retry</div></a>
	<a href="index.jsp"><div class="buttons">Go back</div></a>
	
</body>
</html>