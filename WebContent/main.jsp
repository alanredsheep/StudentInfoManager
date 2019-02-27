<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学生信息管理系统主界面</title>
<%
	if(session.getAttribute("currentUser")==null){
		response.sendRedirect("index.jsp");
		return;
	}
%>
	<link rel="stylesheet" type="text/css" href="jquery-easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui/demo/demo.css">
	<script type="text/javascript" src="jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="jquery-easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
	$(function(){
		// 数据
		var treeData=[{
			text:"根",
			children:[{
				text:"班级信息管理",
				attributes:{
					url:"gradeInfoManage.jsp"
				}
			},{
				text:"学生信息管理",
				attributes:{
					url:"studentInfoManage.jsp"
				}
			}]
		}];
		
		// 实例化树菜单
		$("#tree").tree({
			data:treeData,
			lines:true,
			onClick:function(node){
				if(node.attributes){
					openTab(node.text,node.attributes.url);
				}
			}
		});
		
		function openTab(text,url){
			if($("#tabs").tabs('exists',text)){
				$('#tabs').tabs('select',text);
				}else{
					var content="<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src="+url+"></iframe>";
					$("#tabs").tabs('add',{
						title:text,
						closable:true,
						content:content
					});
				}
		}
	});
		
	</script>
</head>
<body class="easyui-layout">
	<div region="north" style="height:80px;background-color:#E0EDFF ">
		<h1 style="padding-left:20px;float: left">学生信息管理系统</h1>
		<h4 align="left" style="padding-left: 260px;padding-top: 17px">当前用户 : ${currentUser.userName }</h4>
	</div>
	<div region="center">
		<div class="easyui-tabs" fit="true" border="false" id="tabs">
			<div title="首页">
				<div align="center" style="padding-top:100px;"><font color=#E0EDFF size="10">欢迎使用</font></div>
			</div>
		</div>
	</div>
	<div region="west" style="width:170px " title="导航菜单" split="true">
		<ul id="tree"></ul>
	</div>
	<div region="south" style="height:25px" align="center">
		版权所有<a href="www.alanredsheep.com">www.alanredsheep.com</a>
	</div>
</body>
</html>