<%@ page language="java" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/jslib/bootstrap-3.2.0-dist/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/jslib/jqBootgrid/build/jquery.bootgrid.css">
<script src="${pageContext.request.contextPath}/jslib/jqBootgrid/lib/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/jslib/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/jslib/jqBootgrid/build/jquery.bootgrid.js"></script>
<script type="text/javascript">
	$(function() {

		var grid = $("#grid-data")
				.bootgrid(
						{
							ajax : true,
							url : "${pageContext.request.contextPath}/admin/showTaskAction.action",
							formatters : {
								"caozuo" : function(column, row) {
									if (row.taskState == "init") {
										return "<button class='btn btn-info' type='button' onclick='approve_task(\""
												+ row.taskId
												+ "\")'>审核通过</button><a href='javascript:refuse_task(\""+row.taskId+"\")'>拒绝上线</a>";
									}
									if (row.taskState == "refused") {
										return "<button class='btn btn-info' type='button' onclick='approve_task(\""
												+ row.taskId
												+ "\")'>复审通过</button>";
									}
									if (row.taskState == "approved_on") {
										return "<button class='btn btn-danger' type='button' onclick='refuse_task(\""
												+ row.taskId
												+ "\")'>强制下线</button>";
									}if (row.taskState == "approved_off") {
										return "<button class='btn btn-danger' type='button' onclick='refuse_task(\""
												+ row.taskId
												+ "\")'>强制下线</button>";
									}
								}
							}
						})
	});
	function approve_task(taskId) {
		$
				.ajax({
					url : '${pageContext.request.contextPath}/approveTask.action',
					contentType : "application/x-www-form-urlencoded; charset=utf-8",
					data : {
						taskId:taskId
					},
					dataType : 'json',
					success : function(data) {
						alert(data.msg);
					}
				});
	};
	function refuse_task(taskId) {
		$
				.ajax({
					url : '${pageContext.request.contextPath}/refuseTask.action',
					contentType : "application/x-www-form-urlencoded; charset=utf-8",
					data : {
						taskId:taskId
					},
					dataType : 'json',
					success : function(data) {
						alert(data.msg);
					}
				});
	};
	
</script>
<table id="grid-data"
		class="table table-condensed table-hover table-striped">
		<thead>
			<tr>
				<th data-column-id="taskId" data-sortable="false">ID</th>
				<th data-column-id="contact" data-sortable="false">联系方式</th>
				<th data-column-id="taskReward" data-sortable="false">任务奖励</th>
				<th data-column-id="taskNeed" data-sortable="false">任务要求</th>
				<th data-column-id="taskCost" data-sortable="false">垫付金</th>
				<th data-column-id="caozuo" data-formatter="caozuo"
					data-sortable="false">操作</th>
			</tr>
		</thead>
</table>