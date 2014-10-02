<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
	function save_task() {
		$
				.ajax({
					url : '${pageContext.request.contextPath}/businessUserAction!saveTask.action',
					contentType : "application/x-www-form-urlencoded; charset=utf-8",
					type:'post',
					data : {
						taskReward : $("#taskReward").val(),
						taskCost : $("#taskCost").val(),
						contact : $("#contact").val(),
						taskType : $("#taskType").val(),
						taskNeed : $("#taskNeed").val()
					},
					dataType : 'json',
					success : function(data) {
						alert(data.msg);
					}
				});
	}
</script>

<div class="form-horizontal">
	<div class="control-group">
		<label class="control-label">任务奖励</label>
		<div class="controls">
			<input type="text" id="taskReward"  style="height:30" required />
			<p class="help-block"></p>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">垫付金额</label>
		<div class="controls">
			<input type="text" id="taskCost" style="height:30" required />
			<p class="help-block"></p>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">联系方式</label>
		<div class="controls">
			<input type="text" id="contact"  style="height:30" required />
			<p class="help-block"></p>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">任务类型</label>
		<div class="controls">
			<input type="text" id="taskType" style="height:30" required />
			<p class="help-block"></p>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">任务内容</label>
		<div class="controls">
			<input type="text" id="taskNeed" style="height:30" required />
			<p class="help-block"></p>
		</div>
	</div>
	<button class="btn btn-primary" type="button" onclick="save_task()">发布任务</button>
</div>




