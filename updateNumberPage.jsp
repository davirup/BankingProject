<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Number</title>


<style>

.formcontrol{
	display: flex;
	flex-direction: row;
}

.label{
	margin: 5px;
	width: 8rem;
}

input{
	margin:3px;
	padding: 5px;
}

</style>



</head>
<body>
	<%@include file="header.jsp" %>
	
	<form action="UpdateNumber" method="post">
	
		<div class="formcontrol">
			<div class="label">Account Number: </div>
			<div><input type="text" name="accountnumber" autocomplete="off"/></div>
		</div>
		
		<div class="formcontrol">
			<div class="label">Pin Number: </div>
			<div><input type="text" name="pin" autocomplete="off"/></div>
		</div>
		
		<div class="formcontrol">
			<div class="label">New Number: </div>
			<div><input type="text" name="phone" autocomplete="off"/></div>
		</div>
		
		<input type="submit" value="submit"/>
	
	</form>	
</body>
</html>