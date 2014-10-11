<%@ page language="java" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="jslib/jqBootgrid/css/bootstrap.css">
<link rel="stylesheet" href="jslib/jqBootgrid/build/jquery.bootgrid.css">
<script src="jslib/jqBootgrid/js/moderniz.2.8.1.js"></script>
<script src="jslib/jqBootgrid/lib/jquery-1.11.1.min.js"></script>
<script src="jslib/jqBootgrid/js/bootstrap.js"></script>
<script src="jslib/jqBootgrid/build/jquery.bootgrid.js"></script>
<script type="text/javascript">
	$(function() {

		var grid = $("#grid-data")
				.bootgrid(
						{
							ajax : true,
							url : "${pageContext.request.contextPath}/userAction!getTaskList.action",
							formatters : {
								"link" : function(column, row) {
									return "<button class='btn btn-primary btn-sm' type='button' onclick='apply_task(\""+row.taskId+"\")'>领取任务</button>";
								}
							}
						})
	});
	function apply_task(task_id){
		window.location.href="${pageContext.request.contextPath}/jsp/static/taskDetials.jsp?taskId="+task_id;
	}
</script>
<table id="grid-data"
		class="table table-condensed table-hover table-striped">
		<thead>
			<tr>
				<th data-column-id="taskId" data-type="numeric">ID</th>
				<th data-column-id="contact">联系方式</th>
				<th data-column-id="taskReward" >任务奖励</th>
				<th data-column-id="taskNeed">任务要求</th>
				<th data-column-id="taskCost">垫付金</th>
				<th data-column-id="link" data-formatter="link"
					data-sortable="false">Link</th>
			</tr>
		</thead>
</table>