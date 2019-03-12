<!DOCTYPE html>
<%@ page import="co.web.register.to.RegionTO"%>
<%@ page import="co.web.register.to.PartyTO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<html class="bg-black">
<head>
<meta charset="UTF-8">
<title>Add New Region</title>
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
		document.addregion.clickedLink.value = data;
		document.addregion.submit();
	}
</script>


</head>
<body class="bg-black">

	<div class="form-box" id="login-box">
		<div class="header">Add New Candidate</div>
		<form action="AddCandidateServlet" method="post" name="addregion">
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
			<input type="hidden" name="clickedLink" value="" />


			<div class="body bg-gray">
				<div class="form-group">
					<select class="form-control" name="regionname">
						<option id="">-- Select Region --</option>
						<%
							if (request.getAttribute("regionlist") != null) {
								ArrayList regionList = (ArrayList)request.getAttribute("regionlist");
						%>
						<%
							for (int counter = 0; counter < regionList.size(); counter++) {
									RegionTO regionTo = (RegionTO)regionList.get(counter);
						%>
						<option value="<%=regionTo.getRegionId()%>"><%=regionTo.getRegionname()%></option>
						<%
							}
						%>
						<%
							}
						%>
					</select>
				</div>
				<div class="form-group">
					<select class="form-control" name="partyname">
						<option>-- Select Party --</option>
						<%
							if (request.getAttribute("partylist") != null) {
								ArrayList partyList = (ArrayList)request.getAttribute("partylist");
						%>
						<%
							for (int counter = 0; counter < partyList.size(); counter++) {
								PartyTO partyTO = (PartyTO)partyList.get(counter);
						%>
						<option value="<%=partyTO.getPatryid()%>"><%=partyTO.getPatryname()%></option>
						<%
							}
						%>
						<%
							}
						%>
					</select>
				</div>
				<div class="form-group">
					<input type="text" name="candidatename" class="form-control"
						placeholder="Candidate name" />
				</div>

				<div class="form-group">
					<input type="text" name="surname" class="form-control"
						placeholder="Add Surname" />
				</div>
				<div class="form-group">
					<input type="text" name="address" class="form-control"
						placeholder="Add Address" />
				</div>
				
				<div class="form-group">
					<input type="text" name="city" class="form-control"
						placeholder="Add City Name" />
				</div>

				<div class="form-group">
					<input type="text" name="pincode" class="form-control"
						placeholder="Add PinCode" />
				</div>

			</div>




			<div class="footer" align="right">
				<div class="btn-group">
					<button type="button" onclick='setHiddenParameter("cancel")'
						class="btn bg-navy btn-flat margin">Cancel</button>
					<button type="button" onclick='setHiddenParameter("addcandidate")'
						class="btn bg-olive btn-flat margin">Add Candidate</button>
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