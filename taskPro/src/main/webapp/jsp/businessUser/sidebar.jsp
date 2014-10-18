<%@ page language="java" pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("side", request.getParameter("side"));
%>
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
	<li role="presentation" id="li1"><a href="jsp/businessUser/index.jsp">我发布过的任务</a>
	</li>
	<li role="presentation" id="li2"><a href="jsp/businessUser/userApply.jsp">用户的申请</a>
	</li>
	<li role="presentation" id="li3"><a href="javascript:changeDiv(2)">Messages</a>
	</li>
</ul>