<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <link rel="stylesheet" href="css/bootstrap.min.css">
   <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
    <title>修改密码</title>
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
    #input04{
    	margin-left:160px;
    }
    
    </style>
	

  </head>
  
  <body>
   	 <div class="navbar">
  		<div class="navbar-inner">
	  		<div class="container">
	  			<a class="brand" href="main.jspx">凯盛项目管理系统</a>
	  			<ul class="nav pull-right">
	  				<li>								
						<button  data-toggle="dropdown" class="btn dropdown-toggle">
							<i class="icon-cog"></i>${user.username}						
							<span class="caret" id = "c" ></span>
						</button>
						<ul class="dropdown-menu">
								<li><a href="user.jspx?_u=xiugaimima" style="font-size:16px;">修改密码</a></li>
								<li><a href="logout.jspx" style="font-size:16px;">安全退出</a></li>		
						</ul>
					
					</li>
	  			</ul>
	  			
	  		</div>
  		</div>
 	 </div>
    <div class="container">
 	 	<div class="row">
 	 		<div class="span8 offset2">
 	 			<form action="user.jspx?_u=editpassword" method="post" class="well form-horizontal">
 	 				<fieldset>
 	 					<legend>欢迎您修改密码！</legend>
 	 					<c:choose>
 	 						<c:when test="${param.code == '1004' }">
 	 							<div style="color:red">新密码为空不能</div>
 	 						</c:when>
 	 						<c:when test="${param.code == '1005' }">
 	 							<div style="color:red">新密码不相等</div>
 	 						</c:when>
 	 					</c:choose>
 	 					
 	 					<div class="control-group">
 	 						<label class="control-label">旧密码密码：</label>
 	 						<div class="controls">
 	 							<input type="password" name="oldpassword" id="input01" x-webkit-speech="undefined">
 	 						</div>
 	 					</div>
 	 					<div class="control-group">
 	 						<label class="control-label">新密码密码：</label>
 	 						<div class="controls">
 	 							<input type="password" name="newpassword1" id="input02" x-webkit-speech="undefined">
 	 						</div>
 	 					</div>
 	 					<div class="control-group">
 	 						<label class="control-label">确认新密码：</label>
 	 						<div class="controls">
 	 							<input type="password" name="newpassword2" id="input03" x-webkit-speech="undefined">
 	 						</div>
 	 					</div>
 	 					<input type="submit" value="修改" class="btn btn-primary" id="input04">
 	 				</fieldset>
 	 			</form>
 	 		</div>
 	 	
 	 	</div>
 	 
 	 </div>
   
	<script type="text/javascript">
		$(document).ready(function(){
			$("#c").click(function(){
			
				$(".dropdown-toggle").dropdown();
			});
		});
	</script>
  </body>
</html>
