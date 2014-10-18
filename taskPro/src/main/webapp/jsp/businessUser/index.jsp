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

<title>商家主页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="${pageContext.request.contextPath}/jslib/bootstrap-3.2.0-dist/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/jslib/jqBootgrid/build/jquery.bootgrid.css">
<script src="${pageContext.request.contextPath}/jslib/jqBootgrid/lib/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/jslib/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/jslib/jqBootgrid/build/jquery.bootgrid.js"></script>
<script src="${pageContext.request.contextPath}/jslib/jqBootgrid/js/moderniz.2.8.1.js"></script>
</head>
<script type="text/javascript">
</script>
<body>
<div>
	<div style="width:200px; position:absolute; left:0px; top:0px" >
		<jsp:include page="sidebar.jsp"><jsp:param name="side" value="tasks"/></jsp:include>
	</div>
	
	<div id="container" style="position:absolute; left:200px; top:0px">
	<div><button class='btn btn-info' type='button' onclick="window.location.href='jsp/businessUser/addTask.jsp'">发布任务</button></div>
	<div>
		<%@ include file="bsTasks.jsp" %>
	</div>
	</div>
</div>
</body>
</html>
