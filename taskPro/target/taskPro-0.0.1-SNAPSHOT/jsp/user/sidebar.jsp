<%@ page language="java" pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("side", request.getParameter("side"));
%>
<link rel="stylesheet"
	href="jslib/bootstrap-3.2.0-dist/css/bootstrap.css">
<script src="jslib/jqBootgrid/lib/jquery-1.11.1.min.js"></script>
<script src="jslib/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(function(){
if("${side}"=="tasks"){
	$("#li1").addClass("active");
}else if("${side}"=="releases"){
	$("#li2").addClass("active");
}else if("${side}"=="tasks"){
	$("#li1").addClass("active");
}
});
</script>
<ul class="nav nav-pills nav-stacked" role="tablist">
	<li role="presentation" id="li1"><a href="jsp/user/index.jsp">所有任务</a>
	</li>
	<li role="presentation" id="li2"><a href="jsp/user/myApplication.jsp">我的申请</a>
	</li>
	<li role="presentation" id="li3"><a href="javascript:changeDiv(2)">Messages</a>
	</li>
</ul>