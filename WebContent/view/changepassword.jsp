<!DOCTYPE html>
<html class="bg-black">
<head>
<meta charset="UTF-8">
<title>AdminLTE | Log in</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- bootstrap 3.0.2 -->
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<!-- font Awesome -->
<link href="<%=request.getContextPath()%>/css/font-awesome.min.css" rel="stylesheet"
	type="text/css" />
<!-- Theme style -->
<link href="<%=request.getContextPath()%>/css/AdminLTE.css" rel="stylesheet" type="text/css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
</head>
<body class="bg-black">

	<div class="form-box" id="login-box">
		<div class="header">Change Password</div>
		<form action="<%=request.getContextPath()%>/changePasswordServlet" method="post">
			<div class="body bg-gray">
				<div class="form-group">
					<input type="text" name="userid" class="form-control"
						placeholder="User ID" />
				</div>
				<div class="form-group">
					<input type="password" name="oldpassword" class="form-control"
						placeholder="Old Password" />
				</div>
				<div class="form-group">
					<input type="password" name="newpassword" class="form-control"
						placeholder="Enter New Password" />
				</div>
				<div class="form-group">
					<input type="password" name="repetenewpassword" class="form-control"
						placeholder="Repete New Password" />
				</div>
			</div>
			<div class="footer">
				<button type="submit" class="btn bg-olive btn-block">Change Password</button>

				<p>
					<a href="#">I forgot my password</a>
				</p>

				<a href="<%=request.getContextPath()%>/view/register.jsp" class="text-center">Register a new
					membership</a>
			</div>
		</form>


	</div>


	<!-- jQuery 2.0.2 -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>