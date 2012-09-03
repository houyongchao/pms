<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
    <title>资料库</title>
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
    		<div class="span3">
    			<div class="well" style="padding:8px 0px;">
    				<ul class="nav nav-list">
					  <li class="nav-header">凯胜软件总部项目</li>
					  <li class="divider"></li>
					  <li><a href="project.jspx"><i class=" icon-home"></i>最新动态</a></li>
					  <li><a href="goal.jspx"><i class="icon-flag"></i>目标</a></li>
					  <li class="active"><a href="document.jspx"><i class="icon-folder-open"></i>资料库</a></li>
					  <li><a href="fileType.jspx"><i class="icon-file"></i>文件共享</a></li>
					  <li><a href="contact.jspx"><i class="icon-user"></i>联系人</a></li>
					  <li><a href="idea.jspx"><i class="icon-fire"></i>想法</a></li>
					  <li><a href="#"><i class="icon-warning-sign"></i>Bug</a></li>
					  <li><a href="#"><i class="icon-cog"></i>项目设置</a></li>
					</ul>
    			</div>
    		</div>
    		<div class="span9">
    			<ul class="breadcrumb" style="margin-bottom:0px;border-radius:3px 3px 0px 0px;margin-top:15px;">
	  				<li class="active">
	  					<a href="document.jspx" style="font-size:16px;">
	  						<i class="icon-folder-open"></i>
	  						资料
	  					</a>
	  				</li>
	  				<li class="active pull-right">
	  					<a href="document.jspx?_d=new_document">
	  						<i class="icon-plus"></i>
	  						分享新资料
	  					</a>
	  				</li>
  				</ul>
    			<div class="wall" style="margin-bottom:20px;">
    				<c:choose>
    					<c:when test="${fn:length(documentList.result) == 0 }">
    						<div>没有分享的资料，现在去<a href="document.jspx?_d=new_document">分享资料</a>!</div>
    					</c:when>
	    				<c:when test="${fn:length(documentList.result) != 0 }">
		    				<c:forEach var="document" items="${requestScope.documentList.result }">
			    				<blockquote>
			    					<h4><a href="document.jspx?_d=show_document&documentid=${document.id }">${document.title }</a></h4>
			    					<p style="font-size:14px;max-height:40px;overflow:hidden">${document.neiRong }</p>
			    					<small>
				    					<c:forEach var="user" items="${sessionScope.userList }">
				    					     	    
				    						<c:set value="${document.userid }" var="documentUserid"></c:set>
				    						<c:set value="${user.id }" var="userId"></c:set>
				    						<c:if test="${documentUserid == userId }">
				    							${user.username }
				    						</c:if>
				    					</c:forEach>
				    					发布于${document.createtime }
			    					</small>
			    					<a href="#" title="编辑"><i class="icon-pencil"></i></a>
			    					<a href="#" title="删除"><i class="icon-trash"></i></a>
			    				</blockquote>
			    			</c:forEach>
		    				<div class="pagination pull-right" style="margin-top:5px;">
		    					<ul>
									<c:choose>
										<c:when test="${documentList.nowPageNum != 1 }">	
											<li><a href="document.jspx?page=${documentList.nowPageNum - 1 }" class="btn btn-info">上一页</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="document.jspx?page=1" class="btn btn-info">上一页</a></li>
										</c:otherwise>
									</c:choose>
									 <c:choose>
								    	<c:when test="${documentList.nowPageNum != documentList.totalpages }">
								    		<li><a href="document.jspx?page=${documentList.nowPageNum + 1 }" class="btn btn-info">下一页</a></li>
								    	</c:when>
								    	<c:otherwise>
								    		<li><a href="document.jspx?page=${documentList.totalpages }" class="btn btn-info">下一页</a></li>
								    	</c:otherwise>
								    </c:choose>
									
								</ul>
		    				</div>
    				</c:when>
    				</c:choose>
    				
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
