
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="stylesheet" href="css/bootstrap.min.css" />    
     <script type="text/javascript" src="js/jquery.js"></script>
      <script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
    <title>凯盛项目管理系统</title>
    <style type="text/css">
    	.row{
    		margin-top:60px;
    	}
    	input{
    		height:30px;
    	}
    	.form-actions{
    		background-color:#eee;
    	}
    </style>
  </head>
  <body>
    <div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a href="main.jspx" class="brand" style="color:white">凯盛项目管理系统</a>
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
			<div class="span9 offset2">
				<form class="form-horizontal" action="fileType.jspx" method="post" id="myform">
					<input type="hidden" name="_m" value="save"/>
					<input type="hidden" name="userid" value="${sessionScope.user.id }"/>
					<input type="hidden" name="project" value="${sessionScope.projectid }"/>
					
			        <fieldset>
				          <legend>创建新文件夹</legend>
				          <div class="control-group">
				            	<label class="control-label" for="input01" >文件名称</label>
					            <div class="controls">
					              <input type="text" class="span5" id="input01" x-webkit-speech="undefined" name="filetypename" >
					            </div>
				          </div>
				         				          
				          <div class="form-actions">
				            <input type="submit" class="btn btn-primary" value="保存">
				           
				             <a  class="btn" rel="" href="javascript:;">返回</a>
				          </div>
			        </fieldset>
		      </form>
			</div>
			
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			
			$(".btn").click(function(){
				
				window.location.href = "fileType.jspx";
			});
			
			$("#c").click(function(){
			
				$(".dropdown-toggle").dropdown();
			});
			
		});
	
	
	</script>
	
	
  </body>
</html>


