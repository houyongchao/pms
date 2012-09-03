<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="kindedit.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>项目管理系统</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <script type="text/javascript" src="js/jquery.js"></script>
   <script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
  <style type="text/css">
  	 .navbar .brand{
    	color:#fff;
    }
	 .row{
		margin-top:60px;
	}
	.wall {
		border: 1px solid #ddd;			
		border-top: none;
		
		max-height:400px;
	}
	.box .head {
		border-bottom: 1px solid #ddd;
		font-size: 16px;
		font-weight: bold;
		padding:10px 10px;
		padding-left:50px;
		margin-bottom: 20px;
			
	}
	.box{
		border:1px solid #ddd;
		
	}
	#input01{
		margin-left:350px;
	}
	#form{
		margin-bottom:2px;
	}
	#count{
		margin-bottom:0px;
	}
  </style>
  </head>  
  <body>
  <div class="navbar  navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a href="main.jspx" class="brand">凯盛项目管理系统</a>
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
					  <li class="active"><a href="main.jspx"><i class="icon-white icon-home"></i>最新动态</a></li>
					  <li><a href="goal.jspx"><i class="icon-flag"></i>目标</a></li>
					  <li><a href="document.jspx"><i class="icon-folder-open"></i>资料库</a></li>
					  <li><a href="fileType.jspx"><i class="icon-file"></i>文件共享</a></li>
					  <li><a href="contact.jspx"><i class="icon-user"></i>联系人</a></li>
					  <li><a href="idea.jspx"><i class="icon-fire"></i>想法</a></li>
					  <li><a href="#"><i class="icon-warning-sign"></i>Bug</a></li>
					  <li><a href="#"><i class="icon-cog"></i>项目设置</a></li>
					</ul>
				</div>
			</div>
			<div class="span6">
				<ul style="margin-bottom:0px;border-radius:3px 3px 0px 0px ;" class="breadcrumb">
					<li>
						<i class="icon-th"></i>你在想什么？和大家分享一下吧.
					</li>
				</ul>
				<div class="wall">
					<form action="project.jspx?_p=fenxiang" method="post" id="form">
						<textarea id="editor_id" name="content" style="width:457px;height:100px;"></textarea>
    					<p id="count">
							您当前输入了 <span class="word_count2">0</span> 个文字。
						</p>
						<input type="submit" class="btn btn-primary" value="发布" id="input01">
					</form>
				</div>
				<ul style="margin-bottom:0px;border-radius:3px 3px 0px 0px;margin-top:10px" class="breadcrumb">
					<li>
						<i class="icon-th"></i>信息流
					</li>
				</ul>
				<div class="wall">
					<c:choose>
						<c:when test="${fn:length(messageList.result) == 0 }">
							<div>今天还没人发表想法，赶快发表你的想法吧！</div>
						</c:when>
						<c:when test="${fn:length(messageList.result) != 0 }">
							<c:forEach var="message" items="${messageList.result }">
								<div style="font-size:16px;">${message.neiRong }</div>
								<small style="font-size:14px;">--
									<c:forEach var="user" items="${userList }">
										<c:if test="${user.id == message.userid }">
											${user.username }
										</c:if>
										发表于${message.createtime }<br><br>
									</c:forEach>
								</small>
							</c:forEach>
						
						</c:when>
					</c:choose>
					<div class="pagination pull-right" style="margin-top:0px;">
						<ul>
							<c:choose>
								<c:when test="${messageList.nowPageNum != 1 }">	
									<li><a href="project.jspx?page=${messageList.nowPageNum - 1 }" class="btn btn-info">上一页</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="project.jspx?page=1" class="btn btn-info">上一页</a></li>
								</c:otherwise>
							</c:choose>
							 <c:choose>
						    	<c:when test="${messageList.nowPageNum != messageList.totalpages }">
						    		<li><a href="project.jspx?page=${messageList.nowPageNum + 1 }" class="btn btn-info">下一页</a></li>
						    	</c:when>
						    	<c:otherwise>
						    		<li><a href="project.jspx?page=${messageList.totalpages }" class="btn btn-info">下一页</a></li>
						    	</c:otherwise>
						    </c:choose>
							
						</ul>
					</div>
				</div>
			</div>
			<div class="span3">		
				<div class="box">
					<div class="head">我的任务</div>
					<ul style="padding-left:30px;">
						<c:forEach var="task" items="${taskList }">
							<li><a style="text-decoration:none; font-size:14px;">${task.renwuName }</a></li><br>
						</c:forEach>
					</ul>
				</div>	
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
