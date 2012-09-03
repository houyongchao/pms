<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
     <link rel="stylesheet" href="css/bootstrap.min.css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
    <title>项目管理系统</title>
    <style type="text/css">
    	.row{
    		margin-top:60px;
    	}
    	.breadcrumb{
			margin-bottom:0px;
		}
		.wall{
			margin-top:0px;
			border:1px solid #ddd;
			padding:15px;
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
			<div class="span3">
				<div class="well" style="padding: 8px 0;">
					<ul class="nav nav-list">
					  <li class="nav-header">凯盛总部项目</li>
					  <li class="divider"></li>
					  <li ><a href="project.jspx"><i class="icon-home"></i>最新动态</a></li>
					  <li><a href="goal.jspx"><i class=" icon-flag"></i>目标</a></li>
					  <li><a href="document.jspx"><i class="icon-folder-open"></i>资料库</a></li>
					  <li><a href="fileType.jspx"><i class="icon-file"></i>文件共享</a></li>
					  <li><a href="contact.jspx"><i class="icon-user"></i>联系人</a></li>
					  <li class="active"><a href="idea.jspx"><i class="icon-white  icon-fire"></i>想法</a></li>
					  <li><a href="#"><i class="icon-warning-sign"></i>Bug</a></li>
					  <li><a href="#"><i class="icon-cog"></i>项目设置</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">
				<ul class="breadcrumb" style="margin-bottom:0px;border-radius: 3px 3px 0 0;margin-top:15px">
					<li class="active">
						<a href="idea.jspx"><i class="icon-fire"></i>想法</a>&gt;使用Ajax技术
					</li>
				
				</ul>
				<div class="wall">
				  <div class="page-header">
					<h3>使用Ajax技术&nbsp;&nbsp;<small>樊凯发布于 1个月前</small></h3>
				  </div>
				  <p>在最新的版本中使用Ajax技术怎么样，推荐看看Jquery的Ajax和DWR...</p>
				  
				  <div class="line">
					评论
				  </div>
				  <form>
					<textarea class="span8" rows="5">输入想法</textarea>
					<br>
					<button class="btn">发布</button>
				  </form>
				 
				 <blockquote>
				  可以考虑
				  <small>
					樊凯发布于 1个月前
					<a href="#" title="编辑"><i class="icon-pencil"></i></a>
				    <a href="#" title="删除"><i class="icon-trash"></i></a>
				  </small>
				  
				</blockquote>
				<blockquote>
				  一种老酒装新瓶的技术
				  <small>
					乔布斯发布于 1个月前
					<a href="#" title="编辑"><i class="icon-pencil"></i></a>
				    <a href="#" title="删除"><i class="icon-trash"></i></a>
				  </small>
				  
				</blockquote>
				<blockquote>
				  还有HTML5哦
				  <small>
					艾莉婕发布于 1个月前
					<a href="#" title="编辑"><i class="icon-pencil"></i></a>
				    <a href="#" title="删除"><i class="icon-trash"></i></a>
				  </small>
				  
				</blockquote>
				
				<button class="btn" id="fanhui">←返回想法列表</button>
			</div>	
					
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#fanhui").click(function(){
				window.location.href="idea.jsp";
			});
			
			$("#c").click(function(){
			
				$(".dropdown-toggle").dropdown();
			});
			
		});
	</script>
  </body>
</html>
