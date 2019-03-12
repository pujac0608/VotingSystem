<!DOCTYPE html>
<%@ page import="co.web.register.to.RegionTO"%>
<%@ page import="co.web.register.to.PartyTO"%>
<%@ page import="co.web.register.to.CandidateTO"%>
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
		document.addballot.clickedLink.value = data;
		document.addballot.submit();
	}
	
	var getcandidateforregion = function() {
		var selectedregion = document.addballot.regionname.value;
		document.addballot.selectedregion.value = selectedregion;
		document.addballot.clickedLink.value = "onregionchange";
		document.addballot.submit();
	}
</script>



</head>

<%

String selectedregionval  = "";

if (request.getAttribute("selectregion") != null) {
	selectedregionval  = (String)request.getAttribute("selectregion");
}


%>
<body class="bg-black">

	<div class="form-box" id="login-box">
		<div class="header">Add New Ballot</div>
		<form action="AddBallotServlet" method="post" name="addballot">
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
			<input type="hidden" name="selectedregion" value="" />


			<div class="body bg-gray">
			
				<div class="form-group">
					<select class="form-control" name="regionname" onchange="getcandidateforregion()">
						<option id="">-- Select Region --</option>
						<%
							if (session.getAttribute("regionlist") != null) {
								ArrayList regionList = (ArrayList)session.getAttribute("regionlist");
						%>
						<%
							for (int counter = 0; counter < regionList.size(); counter++) {
									RegionTO regionTo = (RegionTO)regionList.get(counter);
						%>
						<% if (selectedregionval != null && regionTo.getRegionId().trim().equalsIgnoreCase(selectedregionval)) { %>
						<option selected value="<%=regionTo.getRegionId()%>"><%=regionTo.getRegionname()%></option>
						<% } else { %>
						<option value="<%=regionTo.getRegionId()%>"><%=regionTo.getRegionname()%></option>
						<% } %>
						<%
							}
						%>
						<%
							}
						%>
					</select>
				</div>
			
				<div class="form-group">
					<select class="form-control" name="votingtype">
						<option value="">-- Select Voting Type --</option>
						
						<option selected value="panchayat">Panchayat Vote</option>
						<option selected value="municipality">Municipality Vote</option>
						<option selected value="corporation">Corporation Vote</option>
						
					</select>
				</div>
			
				<div class="form-group">
					<input type="text" name="ballotname" class="form-control"
						placeholder="Ballot name" />
				</div>
			
			
				
	
				<table style="width: 100%;" border="0">

					
						<%
							if (request.getAttribute("candidatelist") != null) {
								ArrayList candidateList = (ArrayList)request.getAttribute("candidatelist");
						%>
						<%
							for (int counter = 0; counter < candidateList.size(); counter++) {
								CandidateTO candidateTO = (CandidateTO)candidateList.get(counter);
						%>
						<tr >
						<td width="100%"> 
						
						<div class="row">
                                        <div class="col-lg-6">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <input type="checkbox" name="candidate" value="<%=candidateTO.getCandidateid()%>"/>
                                                </span>
                                                <label  class="form-control"><%=candidateTO.getCandidatename()%>&nbsp;<%=candidateTO.getSurname()%></label>
                                                
                                            </div><!-- /input-group -->
                          </div>
						
						
					
					</tr>
											
						<%
							}
						%>
						<%
							}
						%>
					
				
				</table>
			




			<div class="footer" align="right">
				<div class="btn-group">
					<button type="button" onclick='setHiddenParameter("cancel")'
						class="btn bg-navy btn-flat margin">Cancel</button>
					<button type="button" onclick='setHiddenParameter("addballot")'
						class="btn bg-olive btn-flat margin">Add Ballot</button>
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