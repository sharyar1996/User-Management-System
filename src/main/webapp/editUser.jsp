<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <%
          String currentId = request.getParameter("id");
          String previousName =  request.getParameter("name");
          String previousEmail =  request.getParameter("email");
          String previousCountry =  request.getParameter("country");
          
  %>
      <h1> <%= currentId %></h1>
      <h1> <%=  previousName%></h1>
      <h1>  <%=  previousEmail%></h1>
      <form action="controller">
                <tr>
					<td> Enter any existing ID: </td>
					<td><input type="number" name="name" required></td>
				</tr>
                <tr>
					<td> Enter new name: </td>
					<td><input type="text" name="name" placeholder=" <%= previousName %>" required></td>
				</tr>
				<tr>
					<td>Enter new email:</td>
					<td><input type="text" name="email" placeholder="previousEmail" required></td>
				</tr>
				<tr>
					<td>Enter new country:</td>
					<td><input type="text" name="country" placeholder="previousCountry" required></td>
				</tr>
				<tr>
					<td><input type="submit" name="editSubmitBtn" value="TransferUserToDb"></td>
				</tr>
		
      </form>
  

</body>
</html>