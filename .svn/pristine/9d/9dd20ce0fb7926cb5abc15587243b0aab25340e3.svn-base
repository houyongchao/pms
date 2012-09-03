<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
  <link rel="stylesheet" href="css/bootstrap.min.css" />
  <script type="text/javascript" src="js/jquery.js"></script>
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
			<div class="span3" style="margin-left:0px;">
	   			<div class="well" style="padding:8px 0px;">
	   				<ul class="nav nav-list">
					  <li class="nav-header">凯胜软件总部项目</li>
					  <li class="divider"></li>
					  <li><a href="project.jspx"><i class="icon-home"></i>最新动态</a></li>
					  <li><a href="goal.jspx"><i class="icon-white icon-flag"></i>目标</a></li>
					  <li><a href="document.jspx"><i class="icon-folder-open"></i>资料库</a></li>
					  <li><a href="fileType.jspx"><i class="icon-file"></i>文件共享</a></li>
					  <li class="active"><a href="contact.jspx"><i class="icon-user"></i>联系人</a></li>
					  <li><a href="idea.jspx"><i class="icon-fire"></i>想法</a></li>
					  <li><a href="#"><i class="icon-warning-sign"></i>Bug</a></li>
					  <li><a href="#"><i class="icon-cog"></i>项目设置</a></li>
					</ul>
	   			</div>
	    	</div>
			<div class="span9">
				<c:if test="${fn:length(taskList) == 0 }">
					<div style="border:1px solid #DDD">当前还没有任务，您可以去添加任务！</div>
				</c:if>
				<c:choose>
					<c:when test="${fn:length(taskList) != 0 }">
						<c:forEach items="${taskList}" var="task">
							<c:forEach items="${userList }" var="user">
								<c:if test="${user.id == task.userid }">
									<ul class="breadcrumb" style="margin-bottom:0px;border-radius: 3px 3px 0 0;margin-top:15px">
										<li><i class="icon-bookmark"></i>${task.renwuName }【${user.username }】</li>
									</ul>
									<div class="wall">
										<p>${task.renwuMiaoShu}</p>
										<div class="progress">
											<div class="bar" style="width:${task.dangqianjingdu}%">已完成${task.dangqianjingdu}%</div>							
										</div>
									</div>
								</c:if>
							</c:forEach>
						</c:forEach>
					</c:when>
				</c:choose>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function(){
			$("#input01").click(function(){
				$("#task01").attr("style","display:block");
			});
			$("#input02").click(function(){
				$("#task01").attr("style","display:none");
			});
		});
		
	
	
	
	</script>
	
  </body>
</html>
