<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>User Management Application</title>

</head>
<body>
      <h1>Welcome !</h1>
      <h1>Add New User</h1>
      <form action="controller">
                <tr>
					<td>Enter your id: </td>
					<td><input type="number" name="id" required></td>
				</tr>
                <tr>
					<td>Enter your name: </td>
					<td><input type="text" name="name" placeholder=" <%= (String)session.getAttribute("name") %>" required></td>
				</tr>
				<tr>
					<td>Enter your email:</td>
					<td><input type="text" name="email" required></td>
				</tr>
				<tr>
					<td>Enter your country:</td>
					<td><input type="text" name="country" required></td>
				</tr>
				<tr>
					<td><input type="submit" name="formSubmitBtn" value="TransferUserToDb"></td>
				</tr>
		
      </form>

</body>
</html>