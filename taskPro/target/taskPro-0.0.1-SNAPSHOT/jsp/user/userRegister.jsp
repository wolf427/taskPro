<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<link href="jslib/plugin/bootstrap.css" rel="stylesheet">
<link href="jslib/dist/css/flat-ui.css" rel="stylesheet">
<script src="jslib/dist/js/vendor/jquery.min.js"></script>
<script src="jslib/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
<script src="jslib/plugin/jqBootstrapValidation.js"></script>
<script src="jslib/dist/js/flat-ui.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("input,select,textarea").not("[type=submit]").jqBootstrapValidation();
	});
	function register_commit() {
		$
				.ajax({
					url : '${pageContext.request.contextPath}/userAction!register.action',
					data : {
						userName : $("#userName").val(),
						userPwd : $("#userPwd").val(),
						email : $("#email").val(),
						phoneNumber : $("#phoneNumber").val(),
						qq : $("#qq").val(),
					},
					dataType : 'json',
					success : function(data) {
						if(data.success==true)
						window.location.href = "${pageContext.request.contextPath}/jsp/static/login.jsp";
					}
				});
	}
</script>
<form class="form-horizontal">
	<div class="control-group">
		<label class="control-label">用户名：</label>
		<div class="controls">
			<input style="height:30" type="text"
				data-validation-regex-regex="^[a-zA-Z][a-zA-Z0-9_]*"
				data-validation-regex-message="字母开头，包含字母 数字或下划线"
				data-validation-length-regex="^[a-zA-Z][a-zA-Z0-9_]{4,15}"
				data-validation-length-message="长度为5至15个字符" name="userName"
				id="userName" />
			<p class="help-block"></p>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">密码：</label>
		<div class="controls">
			<input style="height:30" type="password"
				data-validation-regex-regex="^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\(\)\~]*"
				data-validation-regex-message="包含不可录入字符"
				data-validation-length-regex="^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\(\)\~]{6,22}"
				data-validation-length-message="密码长度为6到22位" name="userPwd"
				id="userPwd" />
			<p class="help-block"></p>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">再次输入密码：</label>
		<div class="controls">
			<input style="height:30" type="password" name="userPwdAgain"
				id="userPwdAgain" data-validation-match-match="userPwd" />
			<p class="help-block"></p>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">Email</label>
		<div class="controls">
			<input style="height:30" type="email" id="email" name="email" />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">手机号</label>
		<div class="controls">
			<input style="height:30" type="text" name="phoneNumber"
				id="phoneNumber" 
				data-validation-regex-regex="^\d{11}"
				data-validation-regex-message="请填写合法手机号" />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">手机号</label>
		<div class="controls">
			<input style="height:30" type="text" name="qq"
				id="qq" 
				data-validation-regex-regex="^\d*"
				data-validation-regex-message="请填写合法qq" />
		</div>
	</div>
	<button class="btn btn-info" type="button" onclick="register_commit()">注册</button>
</form>