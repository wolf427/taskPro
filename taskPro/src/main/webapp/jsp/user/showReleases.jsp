<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

		var grid = $("#grid-data")
				.bootgrid(
						{
							ajax : true,
							url : "${pageContext.request.contextPath}/userAction!getMyReleases.action",
							formatters : {
								"releaseState" : function(column, row) {
									if (row.releaseState == "init") {
										return "<button class='btn btn-default btn-lg' disabled='disabled' type='button'>等待审核</button>";
									}
									if (row.releaseState == "checked") {
										return "<button class='btn btn-success' type='button' onclick=completeTask(\""+row.releaseId+"\")>报告完成</button>";
									}
									if (row.releaseState == "complete") {
										return "<button class='btn btn-default btn-lg' disabled='disabled' type='button'>等待支付</button>";
									}
									if (row.releaseState == "paid") {
										return "<button class='btn btn-default btn-lg' disabled='disabled' type='button'>交易完成</button>";
									}
								}
							}
						});
	});
	function completeTask(releaseId) {
		$
				.ajax({
					url : '${pageContext.request.contextPath}/userAction!completeTask.action',
					contentType : "application/x-www-form-urlencoded; charset=utf-8",
					data : {
						releaseId:releaseId
					},
					dataType : 'json',
					success : function(data) {
						alert(data.msg);
					}
				});
	}
</script>
<div>
	<table id="grid-data"
		class="table table-condensed table-hover table-striped">
		<thead>
			<tr>
				<th data-column-id="releaseId" data-type="numeric">ID</th>
				<th data-column-id="releaseInfo">申请内容</th>
				<th data-column-id="userId">用户ID</th>
				<th data-column-id="taskId">任务ID</th>
				<th data-column-id="releaseState" data-formatter="releaseState"
					data-sortable="false">releaseState</th>
			</tr>
		</thead>
	</table>
</div>