<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <script type="text/javascript" src="js/jquery.js"></script>
     <link rel="stylesheet" href="css/bootstrap.min.css" />
     <script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
    <title>凯盛项目管理系统</title>
    <style type="text/css">
		.row{
    		margin-top:60px;
    	}   
    	input#input01.span5{
    		
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
  	<div class="container">
  		<div class="row">
  			<div class="span9">
  				<form class="form-horizontal" method="post" action="task.jspx">
  					<input type="hidden" name="_m" value="save" />
  					<input type="hidden" name="userid" value="${userid}"/>
  					<input type="hidden" name="goalid" value="${goalid}"/>
			        <fieldset>
				          <legend>添加新任务</legend>
				          <div class="control-group">
				            	<label class="control-label" for="input01">任务名称</label>
					            <div class="controls">
					              <input type="text" class="span5" id="input01" x-webkit-speech="undefined" name="renwuname">
					              <p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p>
					            </div>
				          </div>
				           <div class="control-group">
				            	<label class="control-label" for="input01" >开始时间</label>
					            <div class="controls">
					              <input type="text" class="span5" id="input01" x-webkit-speech="undefined" name="starttime">
					            </div>
				          </div>
				           <div class="control-group">
				            	<label class="control-label" for="input01">截止时间</label>
					            <div class="controls">
					              <input type="text" class="span5" id="input01" x-webkit-speech="undefined" name="endtime">
					            </div>
				          </div>
				          <div class="control-group">
					            <label class="control-label" for="input01">任务描述</label>
					            <div class="controls">
					              <textarea class="span5" rows="8" name="renwumiaoshu">请输入有关目标的描述</textarea>
					            </div>
				          </div>				          
				           <div class="control-group">
					            <label class="control-label" for="select01" >状态</label>
					            <div class="controls">
					              <select id="select01" name = "zhuangtai">
					              	<option>新任务</option>
					              	<option>进行中</option>
					              	<option>已完成</option>					              
					              </select>
					            </div>
				          </div>
				           <div class="control-group">
					            <label class="control-label" for="select01">级别</label>
					            <div class="controls">
					              <select id="select01" name="renwujibie">
					              	<option>重要紧急</option>
					              	<option>重要不紧急</option>
					              	<option>紧急不重要</option>					              
					              	<option>不紧急不重要</option>					              
					              </select>
					            </div>
				          </div>
				            <div class="control-group">
					            <label class="control-label" for="select01">负责人</label>
					            <div class="controls">
					              <select id="select01" name="fuzeren">
					              	<option></option>
					              	<option>TOM</option>
					              	<option>ROSE</option>					              						              
					              </select>
					            </div>
				          </div>
				          <div class="form-actions">
				            <button type="submit" class="btn btn-primary">保存</button>
				           <a  class="btn" rel="${goalid }" href="javascript:;">返回</a>
				          
				          </div>
			        </fieldset>
		      </form>
  			</div>
  			<div class="span3"></div>
  		
  		</div>
  	</div>
  	<script type="text/javascript">
  		$(document).ready(function(){
			$(".btn").click(function(){
				var id = $(this).attr("rel");
				window.location.href = "task.jspx?goalid=" + id;
			});
			
			$("#c").click(function(){
			
				$(".dropdown-toggle").dropdown();
			});
			
		});
  		
  	</script>
  </body>
</html>
