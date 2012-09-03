<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
   <link rel="stylesheet" href="css/bootstrap.min.css" />
	<script type="text/javascript" src="js/jquery.js"></script>
   <script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
   <script type="text/javascript" src="js/bootstrap-tab.js"></script>
	<title>凯盛项目管理系统</title>
	<style type="text/css">
		.row{
			margin-top:60px;
		}
		.qingchu{
			clear:both;
		}
		.breadcrumb{
			margin-bottom:0px;
		}
		.wall{
			border:1px solid #ddd;
			padding:15px;
			margin-top:0px;
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
				
				<c:set var="goalList" value="${sessionScope.goalList.result }"></c:set>
					<c:if test="${fn:length(goalList) == 0 }">
						<div style="border:1px solid #DDD">当前还没有目标，您可以<a href="goal.jspx?_m=new">创建</a>一个目标！</div>
					</c:if>
					<c:choose>
						<c:when test="${fn:length(goalList) != 0 }">
							<div style="float:right" class="btn-group">
								<button  data-toggle="dropdown" class="btn dropdown-toggle">
								<i class="icon-cog"></i>操作
								
								<span class="caret"  id="c"></span></button>
								<ul class="dropdown-menu">
									<li><a href="goal.jspx?_m=new"><i class="icon-plus"></i>添加新目标</a></li>
									<li><a href="task.jspx?_m=seeAlltask"><i class="icon-zoom-in"></i>浏览所有任务</a></li>
								</ul>
							</div>
							<div class="qingchu"></div>
						
							<c:forEach items="${goalList }" var="goal">
								<ul style="margin-top:10px" class="breadcrumb">
									<li class="active">
										<a href="task.jspx?goalid=${goal.id}"><i class="icon-th"></i>${goal.name}</a>
									</li>
									<li style="float:right">
										<i class="icon-edit"></i><a  href="goal.jspx?_m=edit&id=${goal.id}">编辑</a>
									</li>
								</ul>
								<div class="wall">
									<p>${goal.miaoshu}</p>
									<div class="progress progress-danger">
										<div class="bar" style="width: ${goal.rate}%;">已完成${goal.rate}%</div>
									</div>
								</div>
							</c:forEach>
							<div class="pagination pull-right" style="margin-top:0px;">
								<ul>
									<c:choose>
										<c:when test="${sessionScope.goalList.nowPageNum != 1 }">	
											<li><a href="goal.jspx?page=${sessionScope.goalList.nowPageNum - 1 }" class="btn btn-info">上一页</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="goal.jspx?page=1" class="btn btn-info">上一页</a></li>
										</c:otherwise>
									</c:choose>
									 <c:choose>
								    	<c:when test="${sessionScope.goalList.nowPageNum != sessionScope.goalList.totalpages }">
								    		<li><a href="goal.jspx?page=${sessionScope.goalList.nowPageNum + 1 }" class="btn btn-info">下一页</a></li>
								    	</c:when>
								    	<c:otherwise>
								    		<li><a href="goal.jspx?page=${sessionScope.goalList.totalpages }" class="btn btn-info">下一页</a></li>
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
