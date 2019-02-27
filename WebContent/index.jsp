<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学生信息管理系统登陆</title>
<script type="text/javascript">
	function resetValue(){
		document.getElementById("userName").value="";
		document.getElementById("password").value="";
	}
</script>
</head>
<body>
	<div align="center" style="padding-top:100px">
		<table style="width:128px; height:128px;" background="images/login.png" >
			
		</table>
	</div>
	<div align="center" style="padding-top:20px">
		<form action="login" method="post">
		<table style="border-collapse:separate; border-spacing:10px;">
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="userName" value="${userName }" id="userName"/></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password" value="${password }" id="password"/></td>
			</tr>
			<tr>
				<td align="left"><input type="button" value="重置" onclick="resetValue()"/></td>
				<td align="right"><input type="submit" value="登录"/></td>
			</tr>
			
		</table>
		<table>
		<tr>
			<td align="center">
				<font color="red">${error }</font>
			</td>
			</tr>
		</table>
			
		</form>
	</div>
</body>
</html>