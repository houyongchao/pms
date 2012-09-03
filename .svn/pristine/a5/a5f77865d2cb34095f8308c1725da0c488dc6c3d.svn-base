<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="kindedit.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <link rel="stylesheet" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
    <title>发表新想法</title>
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
		width:100%;
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
   		<div class="span3">
   			<div class="well" style="padding:8px 0px;">
   				<ul class="nav nav-list">
				  <li class="nav-header">凯胜软件总部项目</li>
				  <li class="divider"></li>
				  <li><a href="project.jspx"><i class="icon-white icon-home"></i>最新动态</a></li>
				  <li><a href="goal.jspx"><i class="icon-flag"></i>目标</a></li>
				  <li><a href="document.jspx"><i class="icon-folder-open"></i>资料库</a></li>
				  <li><a href="fileType.jspx"><i class="icon-file"></i>文件共享</a></li>
				  <li><a href="contact.jspx"><i class="icon-user"></i>联系人</a></li>
				  <li class="active"><a href="idea.jspx"><i class="icon-fire"></i>想法</a></li>
				  <li><a href="#"><i class="icon-warning-sign"></i>Bug</a></li>
				  <li><a href="#"><i class="icon-cog"></i>项目设置</a></li>
				</ul>
   			</div>
    	</div>
   		<div class="span8">
   			<form action="idea.jspx?_i=save_new_idea" method="post">
   				<fieldset>
   					<legend>发表新想法</legend>
   					<div class="control-group">
   						<label class="control-label">标题</label>
   						<div class="controls">
   							<input type="text" name="title" id="input01">
   						</div>
   					</div>
   					<div class="control-group">
   						<label class="control-label">内容</label>
   						<div class="controls">
   							 <textarea id="editor_id" name="content" style="width:100%;height:100px;"></textarea>
				              	<p>
									您当前输入了 <span class="word_count2">0</span> 个文字。
								</p>
   						</div>
   					
   					</div>
   					<div class="form-actions">
   						<input type="submit" id="input01" value="提交" class="btn btn-primary">&nbsp;&nbsp;
   						<a class="btn btn-info" href="idea.jspx">返回</a>
   					</div>
   				
   				</fieldset>
				 			
   			
   			</form>
   		
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
