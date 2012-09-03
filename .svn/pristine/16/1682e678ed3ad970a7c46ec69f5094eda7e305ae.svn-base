<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>项目</title>
   <link rel="stylesheet" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	 <script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
    <style type="text/css">
    .navbar .brand{
    	color:#fff;
    }
    .navbar .navbar-inner .container{
    	width:940px;
    }
     .navbar .navbar-inner .container .pull-right{
    	line-height:40px;
    	font-size:14px;
    	margin-left:5px;
    }
    .container{
    	width:940px;
    }
    .wall{
    	border:1px solid #DDD;
    	border-top:none;
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
  		<div class="span9">
  			<div class="page-header">
  				<h2>项目列表</h2>
  			</div>
  			<a href="main.jspx?_m=new_project" class="btn btn-success" style="font-size:16px;">
  			<i class="icon-plus icon-white"></i>
  			创建一个新项目
  			</a>
  		<c:if test="${fn:length(proList.result) == 0 }">
  			<div style="border:1px solid #DDD;padding:15px;">没有项目</div>
  		
  		</c:if>
  		
  		<c:if test="${fn:length(proList.result) != 0 }">
	  		<c:forEach items="${sessionScope.proList.result }" var="p">
	  			<ul class="breadcrumb" style="margin-bottom:0px;border-radius:3px 3px 0px 0px;margin-top:15px;">
	  				<li class="active">
	  					<a href="project.jspx?_p=first&projectid=${p.id }" style="font-size:16px;">
	  						<i class="icon-th"></i>
	  						${p.projectName }
	  					</a>
	  				</li>
	  			</ul>
	  			<div class="wall">
	  				<p>${p.xiangMuMiaoShu }</p>
	  			</div>
	  		</c:forEach>	
  		</c:if>	
  		<div class="pagination pull-right" style="margin-top:0px;">
			<ul>
				<c:choose>
					<c:when test="${proList.nowPageNum != 1 }">	
						<li><a href="main.jspx?_p=${proList.nowPageNum - 1 }" class="btn btn-info">上一页</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="main.jspx?_p=1" class="btn btn-info">上一页</a></li>
					</c:otherwise>
				</c:choose>
				 <c:choose>
			    	<c:when test="${proList.nowPageNum != proList.totalpages }">
			    		<li><a href="main.jspx?_p=${proList.nowPageNum + 1 }" class="btn btn-info">下一页</a></li>
			    	</c:when>
			    	<c:otherwise>
			    		<li><a href="main.jspx?_p=${proList.totalpages }" class="btn btn-info">下一页</a></li>
			    	</c:otherwise>
			    </c:choose>
				
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
