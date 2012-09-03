<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <link rel="stylesheet" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
    <title>添加雇员</title>
      <style type="text/css">
    		.navbar .brand{
    	color:#fff;
    }
    .navbar .navbar-inner .container{
    	width:940px;
    }
     .navbar .navbar-inner .container .pull-right{
    	font-size:14px;
    	margin-left:5px;
    }
    .container{
    	width:940px;
    }
    input{
    	height:30px;
    	width:70%;
    }
    #input05{
    	margin-left:160px;
    }
    
    </style>
  </head>
  
  <body>
   	 <div class="navbar">
  		<div class="navbar-inner">
	  		<div class="container">
	  			<a class="brand" href="index.jspx">凯盛项目管理系统</a>
	  		</div>
  		</div>
 	 </div>
 	 <div class="container">
 	 	<div class="row">
 	 		<div class="span8 offset2">
 	 			<form action="user.jspx?_u=saveuser" method="post" class="well form-horizontal">
 	 				<fieldset>
 	 					<legend>欢迎您注册账号！</legend>
 	 					<c:choose>
 	 						<c:when test="${param.code == '1002' }">
 	 							<div style="color:red">密码不能为空</div>
 	 						</c:when>
 	 						<c:when test="${param.code == '1003' }">
 	 							<div style="color:red">两次密码不一样</div>
 	 						</c:when>
 	 					
 	 					</c:choose>
 	 					
 	 					
 	 					<div class="control-group">
 	 						<label class="control-label">编号：</label>
 	 						<div class="controls">
 	 							<input type="text" name="editnum" id="input01" x-webkit-speech="undefined">
 	 							<span id="msg1" style="color:red;"></span>
 	 							<p>只能输入数字</p>
 	 						</div>
 	 					</div>
 	 					<div class="control-group">
 	 						<label class="control-label">姓名：</label>
 	 						<div class="controls">
 	 							<input type="text" name="username" id="input02" x-webkit-speech="undefined">
 	 						</div>
 	 					</div>
 	 					<div class="control-group">
 	 						<label class="control-label">密码：</label>
 	 						<div class="controls">
 	 							<input type="password" name="password1" id="input03" x-webkit-speech="undefined">
 	 						</div>
 	 					</div>
 	 					<div class="control-group">
 	 						<label class="control-label">确认密码：</label>
 	 						<div class="controls">
 	 							<input type="password" name="password2" id="input04" x-webkit-speech="undefined">
 	 						</div>
 	 					</div>
 	 					<input type="submit" value="注册" class="btn btn-primary" id="input05">
 	 					<a href="user.jspx" class="btn btn-info">返回</a>
 	 				
 	 				
 	 				</fieldset>
 	 			
 	 			
 	 			</form>
 	 		</div>
 	 	
 	 	</div>
 	 
 	 </div>
   <script type="text/javascript">
   		
  		var xmlHttp;
  		
  		function createXMLHttpRequest(){
  			if(window.ActiveXObject){
  				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
  			} else{
  				xmlHttp = new XMLHttpRequest();
  			}
  		};
  		function callback(){
  			if(xmlHttp.readyState == 4){
  				if(xmlHttp.status == 200){
  					var result = xmlHttp.responseText;
  					if(result == "1"){
  						document.getElementById("msg1").innerHTML = "该编号已经被注册";
  					} else if(result == "0"){
  						document.getElementById("msg1").innerHTML = "√";
  					}
  				}
  			} else{
  				document.getElementById("msg1").innerHTML = "检测中....";
  			}
  		}
  		
  		document.getElementById("input01").onblur=function(){
  			createXMLHttpRequest();
  			var editnum = document.getElementById("input01").value;
  			if(editnum != ""&editnum != null){
  				xmlHttp.open("post","login.jspx?_l=loginvalidate&editnum="+editnum,true);
	  			xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	  			xmlHttp.onreadystatechange = callback;
	  			xmlHttp.send();
  			}
  		};
		
   </script>
   
  </body>
</html>
