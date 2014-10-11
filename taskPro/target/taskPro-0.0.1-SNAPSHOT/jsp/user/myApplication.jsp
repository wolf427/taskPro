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

<title>用户申请</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>
<body>
	<div>
		<div style="width:200px; position:absolute; left:0px; top:0px">
			<jsp:include page="sidebar.jsp"><jsp:param name="side"
					value="releases" /></jsp:include>
		</div>
		<div id="container" style="position:absolute; left:200px; top:0px">
			<jsp:include page="showReleases.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>
