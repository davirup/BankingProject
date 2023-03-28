<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page errorPage="error.jsp"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>


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

	<div class="container">
        <h3>Login </h3>
        <form action="LoginCheck" method="post">
            
            <div class="formcontrol">
                <div class="label">Account Number: </div>
                <div><input type="text" name="accountnumber" placeholder="xxxxxxxxxxxx" autocomplete="off"></div>
            </div>

            <div class="formcontrol">
                <div class="label">Enter Pin: </div>
                <div><input type="number" name="custpin" placeholder="****" autocomplete="off"></div>
            </div>
            
            <button >Login</button>
        </form>
    </div>
</body>
</body>
</html>