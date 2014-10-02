<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">

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
							/*post : function() {
								return {
									id : "b0df282a-0d67-40e5-8558-c9e93b7befed"
								};
							},*/
							url : "${pageContext.request.contextPath}/businessUserAction!showUsersTask.action",
							formatters : {
								"commands" : function(column, row) {
									return "<button type=\"button\" class=\"btn btn-xs btn-default command-edit\" data-row-id=\"" + row.id + "\"><span class=\"fa fa-pencil\"></span></button> "
											+ "<button type=\"button\" class=\"btn btn-xs btn-default command-delete\" data-row-id=\"" + row.id + "\"><span class=\"fa fa-trash-o\"></span></button>";
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
</script>
<div>
	<table id="grid-data"
		class="table table-condensed table-hover table-striped">
		<thead>
			<tr>
				<th data-column-id="taskId" data-type="numeric">ID</th>
				<th data-column-id="contact">contact</th>
				<th data-column-id="taskReward" data-order="desc">taskReward</th>
				<th data-column-id="taskNeed" data-order="desc">任务要求</th>
				<th data-column-id="commands" data-formatter="commands"
					data-sortable="false">Commands</th>
			</tr>
		</thead>
	</table>
</div>