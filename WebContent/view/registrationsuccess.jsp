<!DOCTYPE html>

<%@ page import="co.web.register.to.RegisterTO"%>

<html class="bg-black">
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- bootstrap 3.0.2 -->
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<!-- font Awesome -->
<link href="<%=request.getContextPath()%>/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="<%=request.getContextPath()%>/css/AdminLTE.css"
	rel="stylesheet" type="text/css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
</head>
<body class="bg-black">
<div class="form-box" id="login-box">
	<div class="header">Registertion Details</div>
	<form action="<%=request.getContextPath()%>/view/login.jsp" method="post">
		<div class="alert alert-info alert-dismissable">
			<i class="fa fa-info"></i>
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">&times;</button>
			<b>Your User ID is : </b>
			<%=((RegisterTO) request.getAttribute("RegisterTO"))
					.getUUID()%>
		</div>
		<div class="alert alert-info alert-dismissable">
			<i class="fa fa-info"></i>
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">&times;</button>
			<b>Your Password is :</b>
			<%=((RegisterTO) request.getAttribute("RegisterTO"))
					.getPassword()%>
		</div>
		<div class="footer">
				<button type="submit" class="btn bg-olive btn-block">Sign
					me in</button>

				<p>
				
				
			</div>

	</form>
</div>

<!-- jQuery 2.0.2 -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"
	type="text/javascript"></script>

</body>
</html>