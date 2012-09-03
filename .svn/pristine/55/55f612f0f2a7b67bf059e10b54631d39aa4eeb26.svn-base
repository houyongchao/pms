<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <script type="text/javascript" charset="utf-8" src="kindeditor-4.1.1/kindeditor.js"></script>
	
   
    <title>编辑页</title>
	<script type="text/javascript">
        var editor;
        KindEditor.ready(function(K) {
                editor = K.create('textarea[name="content"]', {
					resizeType : 1,
					allowPreviewEmoticons : false,
					allowImageUpload : false,
					items : [
						'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons'],
				
					afterChange : function() {
						K('.word_count2').html(this.count('text'));
					}
				
				});
        });
	
	</script>
  </head>
  
  <body>
	
  </body>
</html>
