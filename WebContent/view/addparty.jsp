<!DOCTYPE html>
<html class="bg-black">
<head>
<meta charset="UTF-8">
<title>Add New Party</title>
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
		document.addparty.clickedLink.value = data;
		document.addparty.submit();
	}
</script>

</head>
<body class="bg-black">

	<div class="form-box" id="login-box">
		
		<form action="AddPartyServlet" name="addparty" method="POST" enctype="multipart/form-data">
			<%
				if (request.getAttribute("usermessage") != null) {
			%>
			<div class="alert alert-success alert-dismissable">
				<i class="fa fa-check"></i>
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">&times;</button>
				<b>Alert!</b>
				<%=request.getAttribute("usermessage")%>
			</div>
			<%
				}
			%>
			<div class="header">Add New Party</div>
			<input type="hidden" name="clickedLink">
			<div class="body bg-gray">
				<div class="form-group">
					<input type="text" name="patryname" class="form-control"
						placeholder="Party name" />
				</div>
				<div class="form-group">
					<input type="text" name="patrydescription" class="form-control"
						placeholder="Add Party Description" />
				</div>
				<div class="form-group">
					<input type="file" name="filesymbol" id="exampleInputFile"
						class="form-control" placeholder="Add Party Description" />
				</div>
			</div>
			<div class="footer" align="right">
				<div class="btn-group">
					<button type="button" onclick='setHiddenParameter("cancel")'
						class="btn bg-navy btn-flat margin">Cancel</button>
					<button type="button" onclick='setHiddenParameter("addparty")'
						class="btn bg-olive btn-flat margin">Add Party</button>
				</div>

			</div>
		</form>

	</div>


	<!-- jQuery 2.0.2 -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="../js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>