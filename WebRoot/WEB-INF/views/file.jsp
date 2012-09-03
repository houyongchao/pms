<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
			padding:15px;
			margin-top:0px;
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
			
				
				
			<ul class="breadcrumb" style="margin-bottom:0px;border-radius: 3px 3px 0 0;">
				<li class="active">
					<a href="#"><i class="icon-th"></i>文件列表</a>
				</li>
				<li class="pull-right"><i class="icon-plus"></i><a href="fileType.jspx?_m=new" >创建文件夹</a></li>
			</ul>
			<div class="down">
				<table class="table table-striped">
					<thead>
						<tr>	
							<th></th>
							<th width="60%">名称</th>
							<th width="20%">大小1</th>
							<th>创建人</th>
						</tr>
					</thead>
					<c:choose>
						<c:when test="${fn:length(filetypeList) == 0 }">
							<tr>
								<td colspan="4">当前还没有文件，您可以<a href="fileType.jspx?_m=new">创建</a>一个文件！</td>
							</tr>

						</c:when>
						<c:when test="${fn:length(filetypeList) != 0 }">
						<c:forEach items="${filetypeList}" var="filetype"> 
							<tbody>
								<tr>
									<td>
										<img src="img/2.png">
									</td>
									
									<td><a href="file.jspx?filetypeid=${filetype.id}" >${filetype.fileName}</a></td>
									<td>${filetype.fSize}${filetype.strst }</td>
									<td>
									<c:forEach var="user" items="${userList }">
										<c:if test="${user.id == filetype.userid }">
											${user.username }
											
										</c:if>
									</c:forEach>
								
									</td>
								</tr>
													
							</tbody>
						</c:forEach>
						</c:when>
					</c:choose>		
			</table>
			
		
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
