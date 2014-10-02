<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
    
 <link href="jslib/plugin/bootstrap.css" rel="stylesheet">
<script src="jslib/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
<script src="jslib/dist/js/vendor/jquery.min.js"></script>
<script src="jslib/plugin/jqBootstrapValidation.js"></script>
<script type="text/javascript">
	$(function() {
		$("input,select,textarea").not("[type=submit]").jqBootstrapValidation();
	});
	function login_commit() {
		$.ajax({
			url : '${pageContext.request.contextPath}/userAction!login.action',
			data : {
				userName : $("#userName").val(),
				userPwd : $("#userPwd").val()
			},
			dataType : 'json',
			success : function(data) {
				window.location.href="${pageContext.request.contextPath}/jsp/user";
			}
		});
	}
</script>

<div class="form-horizontal">
	<p></p>
	<div class="control-group">
		<label class="control-label">用户名：</label>
		<div class="controls">
			<input style="height:30" type="text"
				data-validation-regex-regex="^[a-zA-Z][a-zA-Z0-9_]{4,15}"
				data-validation-regex-message="字母开头，包含字母 数字与下划线" name="userName" id="userName"/>
			<p class="help-block"></p>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">密码：</label>
		<div class="controls">
			<input style="height:30" type="password" name="userPwd" id="userPwd"/>
			<p class="help-block"></p>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">再次输入密码：</label>
		<div class="controls">
			<input style="height:30" type="password" name="userPwdAgain" id="userPwdAgain"  
			data-validation-match-match="userPwd" />
			<p class="help-block"></p>
		</div>
	</div>
	<button class="btn btn-primary" type="button" onclick="login_commit()">登录</button>
	<button class="btn btn-default" type="button">注册</button>
</div>



 
