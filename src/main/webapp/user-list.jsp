<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css"/>

</head>
<body> 
         <header class="navbar">
                 <ul>
                     <li><h2>USER MANAGEMENT APP</h2></li>
                     <li><a href="./user-list.jsp"> <h2>See All Users</h2></a></li>
                 </ul>
         </header>
         
         <main>
         
                <h1>List Of Users</h1>
                <form action="controller">
                       <button type="submit" name="addUserBtn" value="./user-form.jsp" >Add new user</button> 
                       <button type="submit" name="editUserBtn" value="./user-form.jsp" >Edit user</button> 
                </form>
              
         
            <div class="container">
                <table>
                    <tr>
                         <td><h3>ID</h3></td>
                         <td><h3>name</h3></td>
                         <td><h3>email</h3></td>
                         <td><h3>country</h3></td>
                         <td><h3>actions</h3></td>
                  </tr>   
                  <tr>
                       <td><h5> <%=  request.getParameter("id")  %> </h5></td>
                         <td><h5><%= request.getParameter("name") %></h5></td>
                         <td><h5><%= request.getParameter("email") %></h5></td>
                         <td><h5><%= request.getParameter("country") %> </h5></td>
                  </tr>
               </table>  
       </div>  
       
       </main>
         
</body>
</html>