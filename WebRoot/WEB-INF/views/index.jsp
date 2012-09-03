<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>首页</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	  <script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
	<style type="text/css">
	.bgc{
		background-color:#000;
	}
	input{
		height:30px;
	}
	.help-block{
		color:red;
	}
	.lgd{
		font-family:楷体_GB2312;
		font-weight:bold;
		font-size:22px;
	}
	label{
		
		font-size:16px;
	}
	.control-label{
		margin-left:10px;
		width:80px;
	}
	</style>
	
  </head>
  
  <body class="bgc">
  	<div class="container" style="margin-top:100px;">
  		<div class="row">
  			<div class="span6 offset3">
  				<form action="login.jspx" class="well form-horizontal" id="myform" method="post">
  					<fieldset>
  						<legend class="lgd">欢迎登陆
  							<span class="active" style="font-size:14px;margin-left:200px;"><a href="user.jspx?_u=adduser">注册账号</a></span>
  						</legend>
  						
  						<c:choose>
  							<c:when test="${param.code == '1001'}">
  								<div style="color:red">账户或密码错误</div>
  							</c:when>
  						</c:choose>
  						<div class="control-group">
  							<label class="control-label">账号：</label>
  							<div class="controls">
  								<input type="text" class="input-large" name="username" id="input01"><span id="msg" style="color:red"></span>
  								<p class="help-block" id="username_error"></p>
  							</div>
  						
  							<label class="control-label">密码：</label>
  							<div class="controls">
  								<input type="password" class="input-large" name="password" id="input02">
  								<p class="help-block" id="password_error"></p><br>
  							</div>
  							<div class="controls">
  								<input type="button" class="btn btn-primary" value="登录系统" id="input03">
  							</div>
  						</div>
  					</fieldset>
  				</form>
  			</div>
  		</div>
  	</div>
  <script type="text/javascript">
  	$(document).ready(function(){
  		$("#input03").click(function(){
  			var username = $("#input01").val();
  			var password = $("#input02").val();
  			if(username.trim() == ""){
  				$("#username_error").html("账号不能为空");
  				return;
  			}
  			if(password.trim() == ""){
  				$("#password_error").html("密码不能为空");
  				return;
  			}
  			return $("#myform").submit();
  		});
	  	$("#input01").keydown(function(){
	  		$("#username_error").html("");
	  				return;
	  	});
	  	$("#input02").keydown(function(){
	  		$("#password_error").html("");
	  				return;
	  	});
  });
  
  </script>
  
  
  
  </body>
</html>
