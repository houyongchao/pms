<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
		.down{
			border:1px solid #ddd;
			padding:20px;
		}
		.clear{
			clear:both;
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
					  <li><a href="fileType.jspx"><i class="  icon-file"></i>文件共享</a></li>
					  <li><a href="contact.jspx"><i class="icon-user"></i>联系人</a></li>
					  <li class="active"><a href="idea.jspx"><i class="icon-white  icon-fire"></i>想法</a></li>
					  <li><a href="#"><i class="icon-warning-sign"></i>Bug</a></li>
					  <li><a href="#"><i class="icon-cog"></i>项目设置</a></li>
					</ul>
				</div>			
			</div>
			<div class="span9">
				<ul class="breadcrumb" style="margin-bottom:0px;border-radius: 5px 5px 0 0;margin-top:15px">
					<li class="active">
						<a href="idea.jspx"><i class="icon-fire"></i>想法</a>
					</li>
					<li class="pull-right"><i class="icon-plus"></i><a href="idea.jspx?_i=new_idea" >发表想法</a></li>
				</ul>
				<div class="down" style="margin-bottom:20px;">
					<c:choose>
						<c:when test="${fn:length(ideaList) == 0 }">
							<div>还没有人发表想法，赶快去发表你的<a href="idea.jspx?_i=new_idea">新想法</a>吧！</div>
						</c:when>
						<c:when test="${fn:length(ideaList) != 0 }">
							<c:forEach var="idea" items="${sessionScope.ideaList }">
								<blockquote>
								  <h4><a href="idea.jspx?_i=show_idea">${idea.title }</a></h4>
								  <p style="font-size:16px;line-height:1.5;">${idea.neiRong }</p>
								  <c:forEach var="user" items="${sessionScope.userIdeaList }">
								  	<c:if test="${user.id == idea.userid }"></c:if>
								  		 <small>${user.username }发布于 ${idea.createtime }前</small>
								  </c:forEach>
								  <a href="idea.jspx?_i=edit_idea&ideaid=${idea.id }" title="编辑"><i class="icon-pencil"></i>编辑</a>
								  <a href="idea.jspx?_i=delete_idea&ideaid=${idea.id }" title="删除" id="delete"><i class="icon-trash"></i>删除</a>
								</blockquote>
							</c:forEach>
						</c:when>
					</c:choose>
					
					<div class="pagination pull-right">
					  <ul>
						<li><a href="#">Prev</a></li>
						<li class="active">
						  <a href="#">1</a>
						</li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">Next</a></li>
					  </ul>
					</div>
					
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#delete").click(function(){
				return confirm("你确定要删除吗？一旦删除就不可恢复。");
			});
		
		$("#c").click(function(){
			
				$(".dropdown-toggle").dropdown();
			});
		});
	
	
	</script>
	
  </body>
</html>
