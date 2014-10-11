<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("taskId", request.getParameter("taskId"));
%>
<base href="<%=basePath%>">

<script src="jslib/jqBootgrid/js/moderniz.2.8.1.js"></script>
<script src="jslib/jqBootgrid/lib/jquery-1.11.1.min.js"></script>
<script src="jslib/jqBootgrid/js/bootstrap.js"></script>
<script src="jslib/jqBootgrid/build/jquery.bootgrid.js"></script>
<link rel="stylesheet" href="jslib/jqBootgrid/css/bootstrap.css">
<link rel="stylesheet" href="jslib/jqBootgrid/build/jquery.bootgrid.css">
<link href="jslib/dist/css/vendor/bootstrap.min.css" rel="stylesheet">
<link href="jslib/dist/css/flat-ui.css" rel="stylesheet">
<script type="text/javascript">
	$(function() {
		$
				.ajax({
					url : '${pageContext.request.contextPath}/userAction!getTaskDetial.action',
					contentType : "application/x-www-form-urlencoded; charset=utf-8",
					data : {
						taskId : '${taskId}'
					},
					dataType : 'json',
					success : function(data) {
						fillTable(data.obj);
					},
					error : function(data) {
						alert(1);
					}
				});
	});
	function fillTable(task) {
		$("#taskReward").text(task.taskReward);
		$("#taskCost").text(task.taskCost);
		$("#taskNeed").text(task.taskNeed);
		$("#taskType").text(task.taskType);
		$("#contact").text(task.contact);
	}
	function commitRelease() {
		$
				.ajax({
					url : '${pageContext.request.contextPath}/userAction!commitRelease.action',
					contentType : "application/x-www-form-urlencoded; charset=utf-8",
					type:'post',
					data : {
						taskId : '${taskId}',
						releaseInfo:$("#releaseInfo").val()
					},
					dataType : 'json',
					success : function(data) {
						alert(data.msg);
					},
					error : function(data) {
						alert(1);
					}
				});
	}
</script>

<table>
	<tr>
		<td>收益:</td>
		<td><p id="taskReward"></p>
		</td>
	</tr>
	<tr>
		<td>需要垫付金额:</td>
		<td><p id="taskCost"></p>
		</td>
	</tr>
	<tr>
		<td>要求:</td>
		<td><p id="taskNeed"></p>
		</td>
	</tr>
	<tr>
		<td>类型:</td>
		<td><p id="taskType"></p>
		</td>
	</tr>
	<tr>
		<td>联系方式:</td>
		<td><p id="contact"></p>
		</td>
	</tr>
</table>
<div><textarea class="form-control" rows="3" id="releaseInfo"></textarea></div>
<button class="btn btn-success" type="button" onclick="commitRelease()">提交申请</button>