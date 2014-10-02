<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<script src="jslib/jqBootgrid/js/moderniz.2.8.1.js"></script>
<script src="jslib/jqBootgrid/lib/jquery-1.11.1.min.js"></script>
<script src="jslib/jqBootgrid/js/bootstrap.js"></script>
<script src="jslib/jqBootgrid/build/jquery.bootgrid.js"></script>
<link rel="stylesheet" href="jslib/jqBootgrid/css/bootstrap.css">
<link rel="stylesheet" href="jslib/jqBootgrid/build/jquery.bootgrid.css">
<link href="jslib/dist/css/vendor/bootstrap.min.css" rel="stylesheet">
<link href="jslib/dist/css/flat-ui.css" rel="stylesheet">
</head>
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
<body>


	<table id="grid-data"
		class="table table-condensed table-hover table-striped">
		<thead>
			<tr>
				<th data-column-id="taskId" data-type="numeric">ID</th>
				<th data-column-id="contact">contact</th>
				<th data-column-id="taskReward" data-order="desc">taskReward</th>
				<th data-column-id="link" data-formatter="link"
					data-sortable="false">Link</th>
			</tr>
		</thead>
	</table>

</body>
</html>
