<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">

<link href="jslib/plugin/bootstrap.css" rel="stylesheet">
<link href="jslib/dist/css/flat-ui.css" rel="stylesheet">
<script src="jslib/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
<script src="jslib/dist/js/vendor/jquery.min.js"></script>
<script src="jslib/plugin/jqBootstrapValidation.js"></script>
<script src="jslib/dist/js/flat-ui.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("input,select,textarea").not("[type=submit]").jqBootstrapValidation();
	});
	function login_commit() {
		var user_type=$("input[name='optionsRadios']:checked").val();
		if(user_type=="option1"){
			user_login();
		}else if(user_type=="option2"){
			bsuer_login();
		}
	};
	function user_login(){
		$
				.ajax({
					url : '${pageContext.request.contextPath}/userAction!login.action',
					data : {
						userName : $("#userName").val(),
						userPwd : $("#userPwd").val()
					},
					dataType : 'json',
					success : function(data) {
						if(data.success==true){
						window.location.href = "${pageContext.request.contextPath}/jsp/user";}
					}
				});
	};
	function bsuer_login(){
		$
				.ajax({
					url : '${pageContext.request.contextPath}/businessUserAction!login.action',
					data : {
						userName : $("#userName").val(),
						userPwd : $("#userPwd").val()
					},
					dataType : 'json',
					success : function(data) {
					if(data.success==true){
						window.location.href = "${pageContext.request.contextPath}/jsp/businessUser/";}
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
				data-validation-regex-message="字母开头，包含字母 数字与下划线" name="userName"
				id="userName" />
			<p class="help-block"></p>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">密码：</label>
		<div class="controls">
			<input style="height:30" type="password" name="userPwd" id="userPwd" />
			<p class="help-block"></p>
		</div>
	</div>
	<div>
		<label class="radio primary"> <input id="optionsRadios1c"
			class="custom-radio" type="radio" required=""
			data-radiocheck-toggle="radio" value="option1" name="optionsRadios"
			data-toggle="radio"> <span class="icons"> <span
				class="icon-unchecked"></span> <span class="icon-checked"></span></span>普通用户</label>
		<label class="radio primary"> <input id="optionsRadios2c"
					class="custom-radio" type="radio" data-radiocheck-toggle="radio"
					value="option2" name="optionsRadios" data-toggle="radio"><span
					class="icons"> <span class="icon-unchecked"></span> <span
						class="icon-checked"></span></span>商家</label>
	</div>
	<button class="btn btn-primary" type="button" onclick="login_commit()">登录</button>
	<button class="btn btn-default" type="button">注册</button>
</div>



