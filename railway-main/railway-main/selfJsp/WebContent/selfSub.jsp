<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*,java.io.*,java.sql.*,selfJsp.*,org.json.*"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="selfSub.jsp" method="get">
		<label>empno</label> <input type="text" name="empno" id="empno" > <br>
		<br> <label>ename</label> <input type="text" name="ename" id="ename">
		<br> <br> <label>job</label> <input type="text"  name="job" id="job">
		<br> <br> <label>sal</label> <input type="text" name="sal" id="sal">
		<br> <br> <label>dept</label> <input type="text" name="dept" id="dept">
		<br> <br> <br> <br>
		<button type="submit" name="first" value="first">first</button>
		<button type="submit" name="last" value="last">last</button>
		<button type="submit" name="next" value="next">next</button>
		<button type="submit" name="prev" value="prev">prev</button>
		<button type="submit" name="add" value="add">add</button>
		<button type="submit" name="edit" value="edit">edit</button>
		<button type="submit" name="save" value="save">save</button>
		<button type="submit" name="delete" value="delete">delete</button>
		<button type="submit" name="search" value="search">search</button>
		<select id="select" name ="selected">
			<option value="empty">---</option>
			<option id="add" value="add">add</option>
			<option id="edit" value="edit">edit</option>
		</select>
	</form>
	<%JSONArray js=null;Connection con=null;
	Class.forName("org.postgresql.Driver");
	con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training", "plf_training_admin",
			"pff123");
	Statement s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	ResultSet rs = s.executeQuery("select * from rjpro");
	js = new JSONArray();
	while (rs.next()) {
		JSONObject jo = new JSONObject();
		jo.put("a", rs.getInt(1));
		jo.put("b", rs.getString(2));
		jo.put("c", rs.getString(3));
		jo.put("d", rs.getInt(4));
		jo.put("e", rs.getDouble(5));
		js.put(jo);
	}
	session.setAttribute("xx", js);
	if (request.getParameter("first") != null && request.getParameter("first").equals("first")) {
		JSONArray ja = (JSONArray) session.getAttribute("xx");
		int x = 0;
		session.setAttribute("counter",x);
	%>
	<script>
		var ja =
	<%=ja.toString()%>
		document.getElementById("empno").value = ja[0].a;
		document.getElementById("ename").value = ja[0].b;
		document.getElementById("job").value = ja[0].c;
		document.getElementById("dept").value = ja[0].d;
		document.getElementById("sal").value = ja[0].e;
	</script>
	<%
	}
	if (request.getParameter("last") != null && request.getParameter("last").equals("last")) {
	JSONArray ja = (JSONArray) session.getAttribute("xx");
	session.setAttribute("counter", ja.length() - 1);
	System.out.println(session.getAttribute("counter"));
	%>
	<script>
		var ja =
	<%=ja.toString()%>
		;
		var len = ja.length - 1;

		document.getElementById("empno").value = ja[len].a;
		document.getElementById("ename").value = ja[len].b;
		document.getElementById("job").value = ja[len].c;
		document.getElementById("dept").value = ja[len].d;
		document.getElementById("sal").value = ja[len].e;
	</script>
	<%
	}
	if (request.getParameter("prev") != null && request.getParameter("prev").equals("prev")) {
	JSONArray ja = (JSONArray) session.getAttribute("xx");
	int x = (int) session.getAttribute("counter");
	
	if (x > 0) {
		x--;
		session.setAttribute("counter",x);
		System.out.println(x);
	%>
	<script>
		var ja =
	<%=ja.toString()%>
		;
		var z =
	<%=x%>
		;
		console.log(z);
		document.getElementById("empno").value = ja[z].a;
		document.getElementById("ename").value = ja[z].b;
		document.getElementById("job").value = ja[z].c;
		document.getElementById("dept").value = ja[z].d;
		document.getElementById("sal").value = ja[z].e;
	</script>
	<%
	}
	}
	if (request.getParameter("next") != null && request.getParameter("next").equals("next")) {
	JSONArray ja = (JSONArray) session.getAttribute("xx");
	int x = (int) session.getAttribute("counter");
	if (x < ja.length() - 1) {
	x++;
	session.setAttribute("counter", x);
	%>
	<script>
		var ja =
	<%=ja.toString()%>
		;
		var z =
	<%=x%>
		;
		//console.log(x);
		document.getElementById("empno").value = ja[z].a;
		document.getElementById("ename").value = ja[z].b;
		document.getElementById("job").value = ja[z].c;
		document.getElementById("dept").value = ja[z].d;
		document.getElementById("sal").value = ja[z].e;
	</script>
	<%
	}
	}
	if (request.getParameter("add") != null && request.getParameter("add").equals("add")){
				%>
		<script>
		document.getElementById("select").value="add";
		
		</script>
		<%
	}
	if(request.getParameter("edit")!=null&& request.getParameter("edit").equals("edit")){
		%>
		<script>
		document.getElementById("select").value="edit";
		</script>
		
		<%
	}
	if(request.getParameter("save")!=null&& request.getParameter("save").equals("save")){
		String p=request.getParameter("empno");
		String q=request.getParameter("ename");
		String r=request.getParameter("job");
		String u=request.getParameter("sal");
		String t=request.getParameter("dept");

		//System.out.println(p);
		
		JSONObject ins=new JSONObject();
		ins.put("a", p);
		ins.put("b", q);
		ins.put("c", r);
		ins.put("d", t);
		ins.put("e", u);
		session.setAttribute("lastupdate", ins);
		//System.out.println(session.getAttribute("lastupdate"));
		String sel=request.getParameter("selected");
		if(sel.equals("add")){
			System.out.println(sel);
			JSONObject lastupd=(JSONObject)session.getAttribute("lastupdate");
			js.put(ins);
			PreparedStatement ps2=con.prepareStatement("insert into rjpro values(?,?,?,?,?)");
			System.out.println(lastupd.getString("a"));
			ps2.setInt(1, Integer.parseInt(lastupd.getString("a")));
			ps2.setString(2,lastupd.getString("b"));
			ps2.setString(3,lastupd.getString("c"));
			ps2.setDouble(4, Double.parseDouble(lastupd.getString("e")));
			ps2.setInt(5,Integer.parseInt(lastupd.getString("d")));
			int rs2=ps2.executeUpdate();
			System.out.println(rs2);
		}
		else if(sel.equals("edit")){
			int cc=(int)session.getAttribute("counter");
			JSONObject lastupd=(JSONObject)session.getAttribute("lastupdate");
			//System.out.println(lastupd);
			js.remove(cc);
			js.put(lastupd);
			System.out.println(js);
			PreparedStatement ps3=con.prepareStatement("update rjpro set ename=?,job=?,dept=?,sal=? where empno=?");
			ps3.setString(1, q);
			ps3.setString(2, r);
			ps3.setInt(3, Integer.parseInt(t));
			ps3.setDouble(4, Double.parseDouble(u));
			ps3.setInt(5, Integer.parseInt(p));
			System.out.println(ps3.executeUpdate());
		}
	}
	if(request.getParameter("delete")!=null&& request.getParameter("delete").equals("delete")){
		int cc=(int)session.getAttribute("counter");
		String sear=request.getParameter("empno");
		js.remove(cc);
		PreparedStatement ps4=con.prepareStatement("delete from rjpro where empno=?");
		ps4.setInt(1, Integer.parseInt(sear));
		System.out.println(ps4.executeUpdate());
		System.out.println(js);
		%>
		<script>alert("record deleted");</script>
		<%
	}
	if(request.getParameter("search")!=null&& request.getParameter("search").equals("search")){
		String ser=request.getParameter("empno");
		PreparedStatement ps5=con.prepareStatement("select * from rjpro where empno=?");
		ps5.setInt(1, Integer.parseInt(ser));
		ResultSet serdata=ps5.executeQuery();
		while(serdata.next()){
			System.out.println(serdata.getString("empno"));
			%><script>
			console.log("in script");
		document.getElementById("empno").value ='<%=serdata.getString(1)%>' ;
		document.getElementById("ename").value = '<%=serdata.getString(2)%>';
		document.getElementById("job").value = '<%=serdata.getString(3)%>';
		document.getElementById("dept").value ='<%=serdata.getString(4)%>';
		document.getElementById("sal").value ='<%=serdata.getString(5)%>';
		console.log(document.getElementById("ename").value);
		</script>
			<%
		}
	}
	%>


</body>
</html>