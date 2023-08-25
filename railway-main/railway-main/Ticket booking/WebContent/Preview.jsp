<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.pack.Ticket,com.pack.Passenger,java.util.ArrayList"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Preview page</h1>
<%Ticket tt=(Ticket)request.getAttribute("ticket");
ArrayList<Passenger> pas=tt.getTl();
%>
<p>train name:<%=tt.getTname() %></p>
<p>from station:<%=tt.getFrom() %></p>
<p> to station:<%=tt.getTo() %></p>
<p>class:<%=tt.getClas()%></p>
<p> date:<%=tt.getDate()%></p>
<h5>passenger details</h5>
<%for(Passenger p:pas){ %>
<p>name:<%=p.getName() %></p>
<p>age:<%=p.getAge() %></p>
<p>gender:<%=p.getGender() %></p>
<%} %>

<button onclick="confirmB()">-confirm-</button>
<button onclick=cancel()">cancel</button>
<script>
function confirmB(){
	var xx=new XMLHttpRequest();
	xx.open("GET","LastBookSer",true);
	xx.onreadystatechange=function(){
		//console.log(xx.status+" "+xx.readyState);
		if(xx.status===200 && xx.readyState===4){
			console.log(xx.responseText);
		}
	};
	xx.send();
}
</script>
</body>
</html>