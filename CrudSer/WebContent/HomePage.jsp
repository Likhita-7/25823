<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

</head>

<body>
	<label>empno</label>
	<input type="text" id="empno"><br><br>
	<label>ename</label>
	<input type="text" id="ename"><br><br>
	<label>job</label>
	<input type="text" id="job"><br><br>
	<label>sal</label>
	<input type="text" id="sal"><br><br>
	<label>dept</label>
	<input type="text" id="dept"><br><br><br><br>
	<button id="first" onclick="first()">first</button>
	<button id="last" onclick="last()">last</button>
	<button id="next" onclick="next()">next</button>
	<button id="prev" onclick="prev()">prev</button>
	<button id="add" onclick="add()">add</button>
	<button id="edit" onclick="edit()">edit</button>
	<button id="save" onclick="save()">save</button>
	<button id="search" onclick="search1()">Search</button>
	<button onclick="clear1()">Clear</button>
	<button onclick="delete1()">Delete</button>
	<select id="select">
		<option>---</option>
		<option id="add">add</option>
		<option id="edit">edit</option>
	</select>
	<div id="container"></div>
	<%String x=response.getHeader("headvar"); System.out.println(x); %>
	<script>
	var a=document.getElementById("empno");
	var b=document.getElementById("ename");
	var c=document.getElementById("job");
	var d=document.getElementById("sal");
	var e=document.getElementById("dept");
	var f=document.getElementById("container");
	f.textContent="";
	function first(){
		var xhr=new XMLHttpRequest();
		xhr.open("GET","MainSer?par=first",true);
		xhr.setRequestHeader('head','<%=x%>');
		xhr.onreadystatechange=function(){
			if(xhr.status==200){
				var x=JSON.parse(xhr.responseText);
				console.log(xhr.responseText);
				a.value=x.empno;
				b.value=x.ename;
				c.value=x.job;
				d.value=x.sal;
				e.value=x.dept;
			}
		}
		xhr.send();
	}
	
	function last(){
		var xhr=new XMLHttpRequest();
		xhr.open("GET","MainSer?par=last",true);
		xhr.setRequestHeader('head','<%=x%>');
		xhr.onreadystatechange=function(){
			if(xhr.status==200){
				var x=JSON.parse(xhr.responseText);
				console.log(xhr.responseText);
				a.value=x.empno;
				b.value=x.ename;
				c.value=x.job;
				d.value=x.sal;
				e.value=x.dept;
			}
		}
		xhr.send();
	}
	function next(){
		var xhr=new XMLHttpRequest();
		xhr.open("GET","MainSer?par=next",true);
		xhr.setRequestHeader('head','<%=x%>');
		xhr.onreadystatechange=function(){
			if(xhr.status==200){
				var x=JSON.parse(xhr.responseText);
				console.log(xhr.responseText);
				a.value=x.empno;
				b.value=x.ename;
				c.value=x.job;
				d.value=x.sal;
				e.value=x.dept;
			}
		}
		xhr.send();
	}	
	function prev(){
		var xhr=new XMLHttpRequest();
		xhr.open("GET","MainSer?par=prev",true);
		xhr.setRequestHeader('head','<%=x%>');
		xhr.onreadystatechange=function(){
			if(xhr.status==200){
				var x=JSON.parse(xhr.responseText);
				console.log(xhr.responseText);
				a.value=x.empno;
				b.value=x.ename;
				c.value=x.job;
				d.value=x.sal;
				e.value=x.dept;
			}
		}
		xhr.send();
	}
	function save(){
		var val=document.getElementById("select").value;
		var p=a.value;
		var q=b.value;
		var r=c.value;
		var s=d.value;
		var t=e.value;
		var data="&empno="+p+"&ename="+q+"&job="+r+"&sal="+s+"&dept="+t;
		var xhr=new XMLHttpRequest();
		xhr.open("GET","MainSer?par=save"+"&par2="+val+"&dat="+data,true);
		xhr.setRequestHeader('head','<%=x%>');
		xhr.onreadystatechange=function(){
			if(xhr.status==200){
				alert("record updated")
				 console.log(xhr.responseText);
				clear1();
			}
		}
		xhr.send();
	}
	function add(){
		document.getElementById("select").value="add";
	}
	
	function edit(){
		document.getElementById("select").value="edit";
	}
	function clear1(){
		a.value="";
		b.value="";
		c.value="";
		d.value="";
		e.value="";
	}
	function search1(){
		var xhr=new XMLHttpRequest();
		var sea=a.value;
		console.log(a.value);
		xhr.open("GET","MainSer?par=search"+"&par3="+sea,true);
		xhr.setRequestHeader('head','<%=x%>');
		xhr.onreadystatechange=function(){
			if(xhr.status==200){
				var x=JSON.parse(xhr.responseText);
				console.log(xhr.responseText);
				a.value=x.empno;
				b.value=x.ename;
				c.value=x.job;
				d.value=x.sal;
				e.value=x.dept;
			}
		}
		xhr.send();
	}
	function delete1(){
		var xhr=new XMLHttpRequest();
		var sea=a.value;
		console.log(a.value);
		xhr.open("GET","MainSer?par=delete"+"&par3="+sea,true);
		xhr.setRequestHeader('head','<%=x%>');
		xhr.onreadystatechange=function(){
			if(xhr.status==200){
				alert("record deleted");
				clear1();
			}
		}
		xhr.send();
	}
	</script>
</body>
</html>