
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="kindedit.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="stylesheet" href="css/bootstrap.min.css" />    
     <script type="text/javascript" src="js/jquery.js"></script>
     <script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
    <title>凯盛项目管理系统</title>
    <style type="text/css">
    	.row{
    		margin-top:60px;
    	}
    	input{
    		height:30px;
    	}
    	.form-actions{
    		background-color:#eee;
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
	${requestScope.goal}
	<div class="container">
		<div class="row">
			<div class="span9 offset2">
				<form class="form-horizontal" action="goal.jspx" method="post" id="myform">
					<input type="hidden" name="_m" value="xiugai"/>
					<input type="hidden" name="id" value="${goal.id }"/>
			        <fieldset>
				          <legend>编辑目标</legend>
				          <div class="control-group">
				            	<label class="control-label" for="input01" >目标名称</label>
					            <div class="controls">
					              <input type="text" class="span5" id="input01" x-webkit-speech="undefined" name="name"  value="${goal.name}">
					              <p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p>
					            </div>
				          </div>
				          <div class="control-group">
					            <label class="control-label" for="input02">目标描述</label>
					            <div class="controls">
					              <textarea id="editor_id" name="content" style="width:620px;height:100px;">${goal.miaoshu }</textarea>
					              	<p>
										您当前输入了 <span class="word_count2">0</span> 个文字。
									</p>
					            </div>
				          </div>				          
				          <div class="form-actions">
				            <input type="submit" class="btn btn-primary" value="保存">
				            <button class="btn" id="input03">返回</button>
				          </div>
			        </fieldset>
		      </form>
			</div>
			
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#input03").click(function(){
				window.location.href = "goal.jspx";
			});
			
			$("#c").click(function(){
			
				$(".dropdown-toggle").dropdown();
			});
		});
	
	
	</script>
	
	
  </body>
</html>


