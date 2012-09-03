<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
    <title>创建新项目</title>
    <style type="text/css">
    	 .navbar .brand{
    		color:#fff;
    	}
    	.navbar .container{
    		width:940px;
    	}
    	 .navbar .navbar-inner .container .pull-right{
	    	line-height:40px;
	    	font-size:14px;
	    	margin-left:5px;
    	}
		input{
			height:30px;
			width:380px;
		}
		#input02{
			margin-left:0px;
			margin-top:8px;
			margin-bottom:20px;
			width:380px;
		}
		#input04{
			margin-top:20px;
		}
		p{
			margin-top:10px;
		}
		#btn{
			margin-top:20px;
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
  			<div class="span9">
  				<form action="main.jspx?_m=new_project" class="well form-horizontal" method="post">
  					<fieldset>
  						<legend>创建一个新项目</legend>
  						<div class="control-group">
  							
  							
  							<label class="control-label">项目编号：</label>
  							<div class="controls">
  								<input type="text" name="projectNum" id="input01"><br>
  								<p>只能填写数字</p>
  							</div>
  							<label class="control-label">项目名称：</label>
  							<div class="controls">
  								<input type="text" name="projectName" id="input01"><br>
  								<p>In addition to freeform text, any HTML5 text-based input appears like so.</p>
  							</div>
  							
  							<label class="control-label">项目描述：</label>
  							<div class="controls">
  								<textarea rows="4" name="projectDsc" id="input02">请描述新建的项目</textarea>
  							</div>
  							
  							<label class="control-label">负责人：</label>
  							<div class="controls">
  								<select name="fuZeRen" id="input03">
  									<option selected="selected">彭恩静</option>
  									<option>侯永超</option>
  									<option>许喜英</option>
  								</select>
  							</div>
  							
  							<label class="control-label">项目成员：</label>
  							<div class="controls">
  								<input type="text" name="projectMember" id="input04">
  							</div>
  							
  							<div class="controls" id="btn">
  								<input type="submit" class="btn btn-primary" value="保存">&nbsp;&nbsp;&nbsp;
  								<a class="btn btn-info" href="main.jspx">返回</a>
  							</div>
  						</div>
  					
  					
  					
  					
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
