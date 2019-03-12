<!DOCTYPE html>
<%@page import="co.web.register.to.BallotCandidateDetailsTO"%>
<%@ page import="co.web.register.to.RegionTO"%>
<%@ page import="co.web.register.to.PartyTO"%>
<%@ page import="co.web.register.to.CandidateTO"%>
<%@ page import="co.web.register.to.VotingRegionTO"%>
<%@ page import="co.web.register.to.VoteDetailsTO"%>
<%@ page import="co.web.register.to.BallotCandidateDetailsTO"%>
<%@ page import="co.web.register.to.LoginUserDetailsTO"%>



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
		document.vote.clickedLink.value = data;
		document.vote.submit();
	}
	
	var getcandidatetovote = function() {
		var selectedvotingtype = document.vote.votetype.value;
		document.vote.selectedvotingtype.value = selectedvotingtype;
		document.vote.clickedLink.value = "onvoteselection";
		document.vote.submit();
	}
	 
	
</script>



</head>

<%

String selectedVotingType  = "";

if (request.getAttribute("selectedvotingtype") != null) {
	selectedVotingType  = (String)request.getAttribute("selectedvotingtype");
}

String uuid  = "";

if (session.getAttribute("loginUserDetailsTO") != null) {
	LoginUserDetailsTO  loginUserDetailsTO = (LoginUserDetailsTO)session.getAttribute("loginUserDetailsTO");
	uuid = loginUserDetailsTO.getUUID();
}


%>
<body class="bg-black">

	<div class="form-box" id="login-box">
		<div class="header">Add New Ballot</div>
		<form action="VotingServlet" method="post" name="vote">
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
			<input type="hidden" name="selectedvotingtype" value="" />
			<input type="hidden" name="userid" value="<%=uuid %>" />


			<div class="body bg-gray">
			
				<div class="form-group">
					<select class="form-control" name="votetype" onchange="getcandidatetovote()">
						<option id="">-- Select Voting Types --</option>
						<%
							if (request.getAttribute("availableVotingTO") != null) {
								ArrayList availableVotingList = (ArrayList)request.getAttribute("availableVotingTO");
						%>
						<%
							for (int counter = 0; counter < availableVotingList.size(); counter++) {
								VotingRegionTO votingRegionTo = (VotingRegionTO)availableVotingList.get(counter);
						%>
						<% if (selectedVotingType != null && votingRegionTo.getVotingType().trim().equalsIgnoreCase(selectedVotingType)) { %>
						<option selected value="<%=votingRegionTo.getVotingType()%>"><%=votingRegionTo.getVotingType()%></option>
						<% } else { %>
						<option value="<%=votingRegionTo.getVotingType()%>"><%=votingRegionTo.getVotingType()%></option>
						<% } %>
						<%
							}
						%>
						<%
							}
						%>
					</select>
				</div>
			
				
			
			
				
	
				<table style="width: 100%;" border="0">

					
						<%
							if (request.getAttribute("voteDetailsTO") != null) {
								VoteDetailsTO voteDetailsTO = (VoteDetailsTO)request.getAttribute("voteDetailsTO");
						%>
						
						
						<%
							for (int counter = 0; counter < voteDetailsTO.getBallotCandidateDetails().size(); counter++) {
								BallotCandidateDetailsTO ballotCandidateDetailsTO = (BallotCandidateDetailsTO)voteDetailsTO.getBallotCandidateDetails().get(counter);
						%>
						
						<tr>						
						<td width="100%"> 
						
						<div class="row">
                                        <div class="col-lg-6">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <input type="radio" name="candidate" value="<%=ballotCandidateDetailsTO.getCandidateId()%>~<%=ballotCandidateDetailsTO.getPartyid()%>~<%=voteDetailsTO.getId()%>"/>
                                                </span>
                                                <label  class="form-control">&nbsp;<%=ballotCandidateDetailsTO.getCandidateName()%></label>
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
					<button type="button" onclick='setHiddenParameter("votenow")'
						class="btn bg-olive btn-flat margin">Vote Now</button>
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