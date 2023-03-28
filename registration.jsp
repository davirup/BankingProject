<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page errorPage="error.jsp"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>

.container{
display: flex;
padding:20px;
align-content: center;

}

form{

width: 500px;
border: 2px solid;
}
</style>

</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container">
	 <form action="InputCustomerDetails" method="post">
        <table  cellpadding="12">
            <caption>
                <h2>Register</h2>
            </caption>
            <tr>
                <th><label for="id1">First Name: </label></th>
                <td><input type="text" id="id1" name="first" placeholder="First Name"></td>
            </tr>

            <tr>
                <th><label for="id2">Middle Name: </label></th>
                <td><input type="text" id="id2" name="middle" placeholder="Middle Name"></td>
            </tr>

            <tr>
                <th><label for="id3">Last Name: </label></th>
                <td><input type="text" id="id3" name="last" placeholder="Last Name"></td>
            </tr>

            <tr>
                <th><label for="id4">City: </label></th>
                <td><input type="text" id="id4" name="city" placeholder="City"></td>
            </tr>

            <tr>
                <th><label for="id5">Occupation: </label></th>
                <td><input type="text" id="id5" name="occupation" placeholder="Occupation"></td>
            </tr>

            <tr>
                <th><label for="id6">Date of Birth: </label></th>
                <td><input type="date" id="id6" name="dob" placeholder="Date"></td>
            </tr>

            <tr>
                <th><label for="id8">Phone Number: </label></th>
                <td><input type="number" name="phone" id="id8" placeholder="phone number"></td>
            </tr>

            <tr>
                <th><label for="id9">Email Id: </label></th>
                <td><input type="text" name="email" id="id9" placeholder="email@email.com"></td>
            </tr>

            <tr>
                <th><label for="id7">Gender: </label></th>
                <td><label>Male</label><input type="radio" name="gender" value="male">
                    <label>Female</label><input type="radio" name="gender" value="female">
                </td>
            </tr>

          <tr>
          	<th><label for="id10">Addhar Number: </label></th>
          	<td><input type="text" id="id10" name="addhar" placeholder="Addhar Number"></td>

            <tr>
				<th>
					<button type="submit" class="buttons">Submit</button>
				</th>
				<td><button type="reset" class="buttons">Clear</button></td>
			</tr>
        </table>
    </form>
	</div>
</body>
</html>