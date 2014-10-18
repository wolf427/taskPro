<%@ page language="java"  pageEncoding="UTF-8"%>



<script type="text/javascript">
	$(function() {

		var grid = $("#grid-data")
				.bootgrid(
						{
							ajax : true,
							/*post : function() {
								return {
									id : "b0df282a-0d67-40e5-8558-c9e93b7befed"
								};
							},*/
							url : "${pageContext.request.contextPath}/businessUserAction!showUsersTask.action",
							formatters : {
								"commands" : function(column, row) {
									return "<button type=\"button\" class=\"btn btn-xs btn-default command-edit\" data-row-id=\"" + row.id + "\"><span class=\"glyphicon glyphicon-pencil\"></span></button> "
											+ "<button type=\"button\" class=\"btn btn-xs btn-default command-delete\" data-row-id=\"" + row.id + "\"><span class=\"glyphicon glyphicon-remove\"></span></button>";
								},
								"zhuangtai":function(column, row) {
									if (row.taskState == "init"||row.taskState == "approved_on") {
										return "<button class='btn btn-danger' type='button' onclick='task_off(\""
												+ row.taskId
												+ "\")'>下线该任务</button>";
									}
									if (row.taskState == "init_off"||row.taskState == "approved_off") {
										return "<button class='btn btn-info' type='button' onclick='task_on(\""
												+ row.taskId
												+ "\")'>上线该任务</button>";
									}
									if (row.taskState == "refused") {
										return "<a>未通过审核</a>";
									}
								}
							}
						}).on(
						"loaded.rs.jquery.bootgrid",
						function() {
							/* Executes after data is loaded and rendered */
							grid.find(".command-edit").on(
									"click",
									function(e) {
										alert("You pressed edit on row: "
												+ $(this).data("row-id"));
									}).end().find(".command-delete").on(
									"click",
									function(e) {
										alert("You pressed delete on row: "
												+ $(this).data("row-id"));
									});
						});
	});
	function task_off(taskId){
	$
				.ajax({
					url : '${pageContext.request.contextPath}/taskOff.action',
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
	function task_on(taskId){
	$
				.ajax({
					url : '${pageContext.request.contextPath}/taskOn.action',
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
<div>
	<table id="grid-data"
		class="table table-condensed table-hover table-striped">
		<thead>
			<tr>
				<th data-column-id="taskId" data-type="numeric">ID</th>
				<th data-column-id="contact">联系方式</th>
				<th data-column-id="taskReward" data-order="desc">任务奖励</th>
				<th data-column-id="taskNeed">任务要求</th>
				<th data-column-id="commands" data-formatter="commands"
					data-sortable="false">Commands</th>
				<th data-column-id="zhuangtai" data-formatter="zhuangtai"
					data-sortable="false">任务状态</th>
			</tr>
		</thead>
	</table>
</div>