<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <link rel="stylesheet" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery.js"></script>
   <script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
    <script type="text/javascript" src="js/json.js"></script>
    <title>联系人</title>
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
 	 	<div class="span3" style="margin-left:0px;">
   			<div class="well" style="padding:8px 0px;">
   				<ul class="nav nav-list">
				  <li class="nav-header">凯胜软件总部项目</li>
				  <li class="divider"></li>
				  <li><a href="project.jspx"><i class="icon-home"></i>最新动态</a></li>
				  <li><a href="goal.jspx"><i class="icon-flag"></i>目标</a></li>
				  <li><a href="document.jspx"><i class="icon-folder-open"></i>资料库</a></li>
				  <li><a href="fileType.jspx"><i class="icon-file"></i>文件共享</a></li>
				  <li class="active"><a href="contact.jspx"><i class="icon-white icon-user"></i>联系人</a></li>
				  <li><a href="idea.jspx"><i class="icon-fire"></i>想法</a></li>
				  <li><a href="#"><i class="icon-warning-sign"></i>Bug</a></li>
				  <li><a href="#"><i class="icon-cog"></i>项目设置</a></li>
				</ul>
   			</div>
    	</div>
    	<div class="span9">
    		<ul class="breadcrumb" style="margin-bottom:0px; border-radius:3px 3px 0px 0px;">
    			<li class="active">
    				<a href="contact.jsp" style="font-size:14px;">
    					<i class="icon-user"></i>
    					联系人
    				</a>
    			</li>
    		</ul>
    		<div class="wall" style="height:500px;">
	    		<div class="span3" style="margin-left:0px;border-right:0px solid #ddd;">
	    			<a class="btn" href="contact.jspx?_c=new_contact"><i class="icon-plus"></i>添加联系人</a>
	    			<div style="margin-top:10px;">所有联系人列表如下：</div>
	    			<c:forEach var="contact" items="${contactList }">
		    			<ul class="unstyled" style="margin-top:15px; font-size:14px;">
		    				<li style="line-height:30px;">
		    					<i class="icon-list-alt"></i>
		    					<a href="#" id="${contact.id }" onclick=showInfo(this)>${contact.name }</a>
		    					
		    				</li>
		    			</ul>
	    			</c:forEach>
	    			
	    		</div>
	    		
	    		<div class="span3" style="border-left:1px solid #ddd;margin-left:0px; padding-left:15px;" id="show">
	    		</div>
    			<div class="span2" style="border:0px;padding:0px;" id="encode">
    			</div>
    		</div>
    	
    	
    	</div>
 	 
 	 </div>
 	 
 	 
 	 <script type="text/javascript">
			var xmlHttp;
		function createXMLHttp(){
			if(window.ActiveXObject){
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} else{
				xmlHttp = new XMLHttpRequest();
			}
		}
			function showInfo(obj){
				createXMLHttp();
				var contactid = $(obj).attr("id");
				xmlHttp.open("get", "contact.jspx?_c=chaxuninfo&contactid="+contactid, true);
				xmlHttp.onreadystatechange = callback;
  				xmlHttp.send();
			}
			function del(obj){
				var contactid = $(obj).attr("rel");
				var result = confirm("确定要删除吗？");
				if(result){
					window.location.href = "contact.jspx?_c=delete_contact&contactid="+contactid;
				}
			}
		function callback(){
			if(xmlHttp.readyState == 4) {
				if(xmlHttp.status == 200) {
					var json = JSON.parse(xmlHttp.responseText);
					var name = json.name;
					var company = json.company;
					var tele = json.tele;
					var homeTelt = json.homeTelt;
					var email = json.email;
					var address = json.address;
					var zhuye = json.zhuye;
					var weibo = json.weibo;
					var weibohouzhui = json.weibohouzhui;
					var jianjie = json.jianjie;
					var contactid = json.id;
						$("#show").text("");
						$("<h3>"+name+"</h3>").appendTo("#show");
						$("<div style='font-size:14px;margin-top:3px;'>"+"公司 :"+company+"</div>").appendTo("#show");
						$("<div style='font-size:14px;margin-top:3px;'>"+"手机 :"+tele+"</div>").appendTo("#show");
						$("<div style='font-size:14px;margin-top:3px;'>"+"固话 :"+homeTelt+"</div>").appendTo("#show");
						$("<div style='font-size:14px;margin-top:3px;'>"+"邮箱 :"+email+"</div>").appendTo("#show");
						$("<div style='font-size:14px;margin-top:3px;'>"+"地址 :"+address+"</div>").appendTo("#show");
						$("<div style='font-size:14px;margin-top:3px;'>"+"主页 :"+"<a href='#'>"+zhuye+"</a></div>").appendTo("#show");
						$("<div style='font-size:14px;margin-top:3px;'>"+"微博:"+"<a href='#'>"+weibo+"@"+weibohouzhui+"</a></div>").appendTo("#show");
						$("<div style='font-size:14px;margin-top:3px;'>"+"简介 :"+jianjie+"</div>").appendTo("#show");
						$("<div style='font-size:14px;margin-top:8px;margin-bottom:8px;'>"+"<a href='contact.jspx?_c=chakanjilu&contactid="+contactid+"'>"+"查看所有记录"+"</a></div>").appendTo("#show");
						$("#encode").text("");
						$("<div>"+"<img src="+"'"+"img/"+contactid+".png"+"'"+"/>"+"</div>").appendTo("#encode");
						$("<div style='margin-top:8px;margin-bottom:8px;'>"+"<a class='btn btn-primary' href='contact.jspx?_c=xiugai_contact&contactid="+contactid+"'>"+"<i class='icon-pencil icon-white'></i>修改联系人"+"</a>"+"</div>").appendTo("#show");
						$("<div>"+"<a rel="+"'"+contactid+"'"+" onclick=del(this) class='btn btn-danger' href='#'"+"'>"+"<i class='icon-trash icon-white'></i>删除联系人"+"</a>"+"</div>").appendTo("#show");
				}
			}
  		}
		$(document).ready(function(){
			$("#c").click(function(){
				$(".dropdown-toggle").dropdown();
			});
			
		});
	</script>
 	 
  </body>
</html>
