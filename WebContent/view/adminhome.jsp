<!DOCTYPE html>
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

<script type="text/javascript">
	var setHiddenParameter = function(data) {
		document.adminForm.clickedLink.value = data;
		document.adminForm.submit();
	}
</script>
</head>
<body class="bg-black">
	
	<div class="form-box" id="login-box">
	
	
		<div class="header">Setup Voting Parameters</div>
		<form action="DisplayAddServlet" name="adminForm">
			<input type="hidden" name="clickedLink">
			<div class="box">
				<div class="box-body">
					<button onclick='setHiddenParameter("region")'
						class="btn btn-default btn-block">Add Region</button>
					<button onclick='setHiddenParameter("party")'
						class="btn btn-default btn-block">Add Party</button>					
					<button onclick='setHiddenParameter("candidate")'					
						class="btn btn-default btn-block">Add Candidate</button>
					
				</div>
			</div>
			<div class="box">
				<div class="box-body">
					
					<button onclick='setHiddenParameter("voter")'
						class="btn btn-default btn-block">Add Voter</button>						
				
				</div>
			</div>
			<div class="box">
				<div class="box-body">
									
					<button onclick='setHiddenParameter("ballot")'
						class="btn btn-default btn-block">Create Voting Ballot</button>
					<button onclick='setHiddenParameter("checkresult")'
						class="btn btn-default btn-block">Check Voting Result</button>						
				</div>
			</div>
			<!-- /.box -->
		</form>


	</div>


	<!-- jQuery 2.0.2 -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="../js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>