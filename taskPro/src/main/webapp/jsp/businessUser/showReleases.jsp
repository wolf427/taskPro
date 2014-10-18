<%@ page language="java" pageEncoding="UTF-8"%>

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
							url : "${pageContext.request.contextPath}/businessUserAction!showRelease.action",
							formatters : {
								"releaseState" : function(column, row) {
									if (row.releaseState == "init") {
										return "<button class='btn btn-info' type='button' onclick='checkRelease(\""
												+ row.releaseId
												+ "\")'>审核通过</button>";
									}
									if (row.releaseState == "checked") {
										return "<button class='btn btn-default btn-lg' disabled='disabled' type='button'>等待完成</button>";
									}
									if (row.releaseState == "complete") {
										return "<button class='btn btn-warning' type='button' onclick='paidForUser(\""
												+ row.releaseId
												+ "\")'>支付佣金</button>";
									}
									if (row.releaseState == "paid") {
										return "<button class='btn btn-default btn-lg' disabled='disabled' type='button'>交易完成</button>";
									}
								}
							}
						});
	});
	function checkRelease(releaseId) {
		$
				.ajax({
					url : '${pageContext.request.contextPath}/businessUserAction!checkByBu.action',
					contentType : "application/x-www-form-urlencoded; charset=utf-8",
					data : {
						releaseId:releaseId
					},
					dataType : 'json',
					success : function(data) {
						alert(data.msg);
					}
				});
	};
	function paidForUser(releaseId) {
		$
				.ajax({
					url : '${pageContext.request.contextPath}/businessUserAction!paidState.action',
					contentType : "application/x-www-form-urlencoded; charset=utf-8",
					data : {
						releaseId:releaseId
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