<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		#input02{
			height:25px;
			width:30px;
			margin-top:9px;
		}
		input{
			width:40px;
			height:28px;
		}
		#form{
			margin-top:0px;
			margin-bottom:0px;
			padding-top:1px;
			padding-bottom:1px;
			height:30px;
		}
		.progress{
			margin-bottom:5px;
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
	${project.projectMember }
	<div class="container">
		<div class="row">
			<div class="span3">
				<div class="well" style="padding: 8px 0;">
					<ul class="nav nav-list">
					  <li class="nav-header">凯盛总部项目</li>
					  <li class="divider"></li>
					  <li ><a href="project.jspx"><i class="icon-home"></i>最新动态</a></li>
					  <li class="active"><a href="goal.jspx"><i class="icon-white icon-flag"></i>目标</a></li>
					  <li><a href="document.jspx"><i class="icon-folder-open"></i>资料库</a></li>
					  <li><a href="fileType.jspx"><i class="icon-file"></i>文件共享</a></li>
					  <li><a href="contact.jspx"><i class="icon-user"></i>联系人</a></li>
					  <li><a href="idea.jspx"><i class="icon-fire"></i>想法</a></li>
					  <li><a href="#"><i class="icon-warning-sign"></i>Bug</a></li>
					  <li><a href="#"><i class="icon-cog"></i>项目设置</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">
				<ul style="margin-top:10px" class="breadcrumb">
					<li class="active">
						<i class="icon-th"></i>${goal.name }
					</li>
				
				</ul>	
			<c:choose>
				<c:when test="${fn:length(taskList.result) == 0 }">
					<div class="wall">
						<p>${goal.miaoshu}</p>
						<div class="progress progress-danger">
							<div class="bar" style="width:0px;">已完成0%</div>							
						</div>
						<div class="page-header">
							<a href="task.jspx?_m=new&goalid=${goal.id }" class="btn btn-success"><i class="icon-plus icon-white"></i>添加新任务</a>
						</div>
						<div>目前还没有任务，赶快添加任务吧！</div>
					</div>
				</c:when>
				<c:when test="${fn:length(taskList.result) != 0 }">
						
					<div class="wall">
						<p>${goal.miaoshu}</p>
						<div class="progress progress-danger">
							<div class="bar" style="width:${goal.rate}%;">已完成${goal.rate }%</div>							
						</div>
						<div class="page-header">
							<a href="task.jspx?_m=new&goalid=${goal.id }" class="btn btn-success"><i class="icon-plus icon-white"></i>添加新任务</a>
						</div>
								<c:forEach items="${taskList.result}" var="ta">	
									<div>
										<i class="icon-bookmark"></i>
										<a href="task.jspx?_m=edit&id=${ta.id}">${ta.renwuName }</a>
									&nbsp;&nbsp;&nbsp;
									<c:forEach var="user" items="${userList }">
										<c:if test="${user.id == ta.userid }">
											[${user.username }]
										</c:if>
									</c:forEach>
									</div>

									<p>${ta.renwuMiaoShu}</p>
									<div class="progress">
										<div class="bar" style="width:${ta.dangqianjingdu}%">已完成${ta.dangqianjingdu}%</div>							
									</div>
										<form action="task.jspx?_m=xiugaijindu&taskid=${ta.id }" method="post" id="form">
											<input type="hidden" name="goalid" value="${goal.id }" />
											<input type="text" id="input02" name="jindu">%
											<input type="submit" value="提交" class="btn btn-info input03">
										</form>
										<br>
								</c:forEach>
						  </div>
						  
						  <div class="pagination pull-right" style="margin-top:0px;">
								<ul>
									<c:choose>
										<c:when test="${requestScope.taskList.nowPageNum != 1 }">	
											<li><a href="task.jspx?page=${requestScope.taskList.nowPageNum - 1 }&goalid=${goal.id }" class="btn btn-info">上一页</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="task.jspx?page=1&goalid=${goal.id }" class="btn btn-info">上一页</a></li>
										</c:otherwise>
									</c:choose>
									 <c:choose>
								    	<c:when test="${requestScope.taskList.nowPageNum != requestScope.taskList.totalpages }">
								    		<li><a href="task.jspx?page=${requestScope.taskList.nowPageNum + 1 }&goalid=${goal.id }" class="btn btn-info">下一页</a></li>
								    	</c:when>
								    	<c:otherwise>
								    		<li><a href="task.jspx?page=${requestScope.taskList.totalpages }&goalid=${goal.id }" class="btn btn-info">下一页</a></li>
								    	</c:otherwise>
								    </c:choose>
									
								</ul>
							</div>
						  
						  
				</c:when>
			</c:choose>
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
