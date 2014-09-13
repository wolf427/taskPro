<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'navbar.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- Loading Bootstrap -->
    <link href="jslib/dist/css/vendor/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="jslib/dist/css/flat-ui.css" rel="stylesheet">

    <link rel="shortcut icon" href="jslib/dist/img/favicon.ico">

  </head>
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="jslib/dist/js/vendor/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="jslib/dist/js/flat-ui.min.js"></script>

    <script src="jslib/assets/js/application.js"></script>
  <script type="text/javascript">
  	function login_commit(){
  		$.ajax({
  			url:'${pageContext.request.contextPath}/userAction!login.action',
  			data:{
  				userName:$("#userName").val(),
  				userPwd:$("#userPwd").val()
  			},
  			dataType:'json',
  			success:function(data){
				alert(data);
			}
  		});
  	}
  </script>
  <body>
   <style>
      body {
          padding-bottom: 20px;
          padding-top: 0px;
      }
      .navbar {
          margin-bottom: 20px;
      }
    </style>
    <div>
	   		<nav class="navbar navbar-inverse navbar-lg navbar-embossed" role="navigation">
	        <div class="container-fluid" >
	          <div class="navbar-header">
	            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-9">
	              <span class="sr-only">Toggle navigation</span>
	              <span class="icon-bar"></span>
	              <span class="icon-bar"></span>
	              <span class="icon-bar"></span>
	            </button>
	            <a class="navbar-brand" href="#">WOLF</a>
	          </div>
	          <div class="navbar-collapse collapse" id="navbar-collapse-9">
	            <div id="login_loginForm" class="navbar-form navbar-right">
	              <div class="form-group">
	                <input type="text" placeholder="Email" id="userName" class="form-control">
	              </div>
	              <div class="form-group">
	                <input type="password" placeholder="Password" id="userPwd" class="form-control">
	              </div>
	              <button class="btn btn-success" onclick="login_commit()">Sign in</button>
	              <button type="submit" class="btn btn-danger">Register</button>
	            </div>
	
	          </div><!--/.navbar-collapse -->
	        </div>
	      </nav>
	</div>
  </body>
</html>
