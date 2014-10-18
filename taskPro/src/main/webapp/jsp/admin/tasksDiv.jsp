<%@ page language="java" pageEncoding="UTF-8"%>

<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<!--
<link href="jslib/bootstrap-3.2.0-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="jslib/bootstrap-3.2.0-dist/css/bootstrap-theme.min.css"
	rel="stylesheet">
<script src="jslib/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
-->
<script type="text/javascript">
$(function (){
datagrid();
});
	function datagrid() {
		$
				.ajax({
					url : '${pageContext.request.contextPath}/admin/showTaskAction.action',
					contentType : "application/x-www-form-urlencoded; charset=utf-8",
					data : {
					},
					dataType : 'json',
					success : function(data) {
						fill_tbody(data);
					}
				});
	}
	function fill_tbody(data){
		var innerHtml = "";
		for(row in data.rows){
			var $tr = $("<tr></tr>");
			var $td1 = $("<td></td>");
		}
	}
</script>
<div>
	<table class="table table-hover table-striped table-condensed">
		<thead>
			<tr>
				<th>商户ID</th>
				<th>商户联系方式</th>
				<th>任务奖励</th>
				<th>任务垫付金额</th>
				<th>任务状态</th>
			</tr>
		</thead>
		<div id="admin_tasks_row"></div>
	</table>
</div>
