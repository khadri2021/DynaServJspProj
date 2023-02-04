<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import= "java.sql.ResultSet" %>
<%@ page import= "java.sql.Connection" %>
<%@ page import= "java.sql.Statement" %>
<%@ page import= "java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="4">   
		<tr>
			<th>OPERATOR</th> 
			<th>IMEA</th>
		</tr>
		
		<%!
		
		ResultSet resultSet = null;
		%>
		
		<% 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/2022batch", "root", "root");
			Statement st = conn.createStatement();
			resultSet = st.executeQuery("select * from phone");

		} catch (Exception e) {
			e.printStackTrace();
		}

		%>
		
		<%while(resultSet.next()){ %>
		
		<tr>
			<td><%=resultSet.getString(1) %></td>
			<td><%=resultSet.getString(2) %></td>
		</tr>
		<%} %>
		

	</table>

</body>
</html>