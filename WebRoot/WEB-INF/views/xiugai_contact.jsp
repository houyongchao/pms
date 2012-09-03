<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <link rel="stylesheet" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery.js"></script>
     <script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
    <title>修改联系人信息</title>
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
    input{
    	height:30px;
    	width:70%;
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
				  <li><a href="project.jspx"><i class="icon-white icon-home"></i>最新动态</a></li>
				  <li><a href="goal.jspx"><i class="icon-flag"></i>目标</a></li>
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
    		<form action="contact.jspx?_c=xiugai&contactid=${requestScope.contact.id }" class="form-horizontal" method="post">
    			<fieldset>
    				<legend>添加新联系人</legend>
    				<div class="control-group">
    					<label class="control-label">姓名：</label>
    					<div class="controls">
    						<input type="text" name="name" value="${requestScope.contact.name }" id="input01" x-webkit-speech="undefined">
    					</div>
    				</div>
    				<div class="control-group">
    					<label class="control-label">公司：</label>
    					<div class="controls">
    						<input type="text" name="company" value="${requestScope.contact.company }" id="input02" x-webkit-speech="undefined">
    					</div>
    				</div>
    				<div class="control-group">
    					<label class="control-label">手机：</label>
    					<div class="controls">
    						<input type="text" name="tele" value="${requestScope.contact.tele }" id="input03" x-webkit-speech="undefined">
    					</div>
    				</div>
    				<div class="control-group">
    					<label class="control-label">固话：</label>
    					<div class="controls">
    						<input type="text" name="homeTelt" value="${requestScope.contact.homeTelt }" id="input04" x-webkit-speech="undefined">
    					</div>
    				</div>
    				<div class="control-group">
    					<label class="control-label">邮箱：</label>
    					<div class="controls">
    						<input type="text" name="email" value="${requestScope.contact.email}" id="input05" x-webkit-speech="undefined">
    					</div>
    				</div>
    				<div class="control-group">
    					<label class="control-label">地址：</label>
    					<div class="controls">
    						<input type="text" name="addr" value="${requestScope.contact.address  }" id="input06" x-webkit-speech="undefined">
    					</div>
    				</div>
    				<div class="control-group">
    					<label class="control-label">主页：</label>
    					<div class="controls">
    						<input type="text" name="zhuye" value="${requestScope.contact.zhuye }" id="input07" x-webkit-speech="undefined">
    						<p style="margin-top:10px;">例如：http://www.xxx.com</p>
    					</div>
    				</div>
    				<div class="control-group">
    					<label class="control-label">微博：</label>
    					<div class="controls">
    						<div class="input-prepend">
    							<select name="weibo">
    								<option>${requestScope.contact.weibo }</option>
    							</select>
    							<span class="add-on">@</span>
    							<input type="text" name="weibohouzhui" value="${requestScope.contact.weibohouzhui }" class="span2" id="input08" x-webkit-speech="undefined">
    						</div>
    					</div>
    				</div>
    				<div class="control-group">
    					<label class="control-label">简介：</label>
    					<div class="controls">
    						<textarea rows="10" cols="100%" name="jianjie" style="width:70%">${requestScope.contact.jianjie }</textarea>
    					</div>
    				</div>
    				 <div class="form-actions">
				            <input type="submit" class="btn btn-primary" value="保存">
				            <a class="btn btn-info" href="contact.jspx">返回</a>
				     </div>
    			
    			</fieldset>
    		
    		
    		</form>
    	
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
