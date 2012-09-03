<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <script type="text/javascript" src="js/jquery.js"></script>
     <script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
	<style type="text/css">
		 .row{
		margin-top:60px;
		}
		
		div.form-actions{
			margin-top:20px;
		}
		input{
			height:30px;
		}
	</style>
	<title>凯盛项目管理系统</title>
  </head> 
  <body>
  	<div class="navbar  navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a href="main.jspx" class="brand" style="color:white;">凯盛项目管理系统</a>
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
			<div class="span3">
				<div class="well" style="padding: 8px 0;">
					<ul class="nav nav-list">
					  <li class="nav-header">凯胜软件总部项目</li>
					  <li class="divider"></li>
					  <li ><a href="project.jspx"><i class="icon-home"></i>最新动态</a></li>
					  <li><a href="goal.jspx"><i class="icon-flag"></i>目标</a></li>
					  <li><a href="document.jspx"><i class="icon-folder-open"></i>资料库</a></li>
					  <li class="active"><a href="fileType.jspx"><i class="icon-white  icon-file"></i>文件共享</a></li>
					  <li><a href="contact.jspx"><i class="icon-user"></i>联系人</a></li>
					  <li><a href="idea.jspx"><i class="icon-fire"></i>想法</a></li>
					  <li><a href="#"><i class="icon-warning-sign"></i>Bug</a></li>
					  <li><a href="#"><i class="icon-cog"></i>项目设置</a></li>
					</ul>
				</div>
			
			</div>
			<div class="span9">
			<!-- 改了这 -->
				<form class="form-horizontal" action="shangchuan.jspx?_m=sc&filetypeid=${filetype.id }" method="post" enctype="multipart/form-data">
				
					<input type="hidden" name="files" value="${fileS}"/>
				
  				  
					<fieldset>
					  <legend>分享新文件</legend>

					  <div class="control-group">
						<label class="control-label" for="input01"></label>
						<div class="controls">
						<!-- 这里面的name属性就是上传的文件的名字,对于数据库里面的name属性 -->
						  <input type="file" class="span5" id="input01" x-webkit-speech="undefined" name="doc"/>
						</div>
					  </div>

					  <div class="form-actions">
					
						<input type="submit" value="上传" class="btn btn-primary"/>
						
					
						 <a class=" fanhui" rel="${filetype.id }" href="javascript:;">返回</a>
				
					  </div>					  
			  	</fieldset> 
					
    				
			  </form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
			$(document).ready(function(){
			$(".fanhui").click(function(){
				var id = $(this).attr("rel");
				window.location.href = "file.jspx?filetypeid=" + id;
			});
			
			$("#c").click(function(){
			
				$(".dropdown-toggle").dropdown();
			});
		});
	
	</script>
  </body>
</html>
