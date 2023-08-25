<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.ArrayList" pageEncoding="ISO-8859-1"%>
<%@ page import="empmvc.*"%>
<%
ArrayList<Employee> elist = (ArrayList<Employee>) request.getAttribute("jlist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2"><tr><th>empno</th><th>ename</th><th>dept</th><th>job</th><th>sal</th></tr>
	<%
	for (Employee e : elist) {
	%>
	<tr>
	<td><%=e.getEmpno()%></td>
	<td><%=e.getName() %></td>
	<td><%=e.getDept() %></td>
	<td><%=e.getJob()%></td>
	<td><%=e.getSal() %></td>
	<%
	}
	%>
	</tr>
	</table>
</body>
</html>