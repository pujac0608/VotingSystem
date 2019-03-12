package co.web.register.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.web.register.bo.BallotBO;
import co.web.register.bo.CandidateBO;
import co.web.register.bo.VotingBO;
import co.web.register.dao.VotingDAO;
import co.web.register.dao.VotingResultTO;
import co.web.register.to.CandidateTO;
import co.web.register.to.LoginUserDetailsTO;
import co.web.register.to.VoteDetailsTO;
import co.web.register.to.VoteTO;
import co.web.register.to.VotingRegionTO;

/**
 * Servlet implementation class VotingServlet
 */
@WebServlet("/VotingServlet")
public class VotingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VotingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clickedLink = request.getParameter("clickedLink");
		if (clickedLink != null && clickedLink.equalsIgnoreCase("cancel")) {
			RequestDispatcher reqDes = request
					.getRequestDispatcher("/view/adminhome.jsp");
			reqDes.forward(request, response);
		} else if (clickedLink != null
				&& clickedLink.equalsIgnoreCase("onvoteselection")) {
			// partyname , regionname, candidatename, surname, address, city,
			// pincode
			System.out.println(" adding Candidate ");
			LoginUserDetailsTO loginUserDetailsTO = new LoginUserDetailsTO();
			loginUserDetailsTO = (LoginUserDetailsTO)request.getSession().getAttribute("loginUserDetailsTO");
			String selectedvotingtype = request.getParameter("selectedvotingtype");
			request.setAttribute("selectedvotingtype", selectedvotingtype);

			VoteDetailsTO voteDetailsTO = new VoteDetailsTO();
			VotingDAO votingDAO = new VotingDAO();		
			voteDetailsTO = votingDAO.getVoteDetails(loginUserDetailsTO, selectedvotingtype);
			request.setAttribute("voteDetailsTO", voteDetailsTO);

			BallotBO ballotBO = new BallotBO();
			List<VotingRegionTO> availableVotingTO = new ArrayList<VotingRegionTO>();
			availableVotingTO = ballotBO.getAvailableVoteTypesForRegion(loginUserDetailsTO);
			System.out.println(" Available Voting TO "+availableVotingTO.size());
			request.setAttribute("availableVotingTO", availableVotingTO);
			
			RequestDispatcher reqDes = request
					.getRequestDispatcher("/view/vote.jsp");
			reqDes.forward(request, response);
		} else if (clickedLink != null
				&& clickedLink.equalsIgnoreCase("votenow")) {
			// partyname , regionname, candidatename, surname, address, city,
			// pincode
			System.out.println(" adding Candidate ");
			LoginUserDetailsTO loginUserDetailsTO = new LoginUserDetailsTO();
			loginUserDetailsTO = (LoginUserDetailsTO)request.getSession().getAttribute("loginUserDetailsTO");
			
			String votetype = request.getParameter("votetype");
			String userid = request.getParameter("userid");
			
			String candidateid = "";
			String partyid = "";
			String ballotid = "";					
			String candidate_party = request.getParameter("candidate");
			StringTokenizer st = new StringTokenizer(candidate_party, "~");
			while(st.hasMoreTokens()) { 
				candidateid = st.nextToken();
				partyid = st.nextToken();
				ballotid = st.nextToken();
			}
			
			VoteTO voteTo = new VoteTO();
			voteTo.setCandidateid(candidateid);
			voteTo.setPartyid(partyid);
			voteTo.setUuid(userid);
			voteTo.setVotingtypeid(votetype);
			voteTo.setBallotid(ballotid);
			
			VotingBO votingBO = new VotingBO();
			boolean flag = votingBO.addVote(voteTo);
			
			if (flag) {
				RequestDispatcher reqDes = request
						.getRequestDispatcher("/view/votesuccess.jsp");
				reqDes.forward(request, response);
			} else {
				RequestDispatcher reqDes = request
						.getRequestDispatcher("/view/alreadyvote.jsp");
				reqDes.forward(request, response);
				
			}
			
		}  else if (clickedLink != null
				&& clickedLink.equalsIgnoreCase("onregionselection")) {
			// partyname , regionname, candidatename, surname, address, city,
			// pincode
			
			LoginUserDetailsTO loginUserDetailsTO = new LoginUserDetailsTO();
			
			
			String selectedregiontype = request.getParameter("regionname");
			request.setAttribute("selectregion", selectedregiontype);
			
			loginUserDetailsTO.setRegion(selectedregiontype);
			
			VotingBO votingBO = new VotingBO();
			List<VotingRegionTO> availableVotingTO = votingBO.getAvailableVoteTypesForRegion(loginUserDetailsTO);
			request.setAttribute("availableVotingTO", availableVotingTO);
			RequestDispatcher reqDes = request
					.getRequestDispatcher("/view/voteresult.jsp");
			reqDes.forward(request, response);
		} else if (clickedLink != null
				&& clickedLink.equalsIgnoreCase("onvotingtypeselection")) {
			// partyname , regionname, candidatename, surname, address, city,
			// pincode
			
			LoginUserDetailsTO loginUserDetailsTO = new LoginUserDetailsTO();
			
			
			String selectedregiontype = request.getParameter("regionname");
			request.setAttribute("selectregion", selectedregiontype);
			
			String selectedvotingtype = request.getParameter("votetype");
			request.setAttribute("selectedvotingtype", selectedvotingtype);
			

			request.setAttribute("selectregion", selectedregiontype);
			
			loginUserDetailsTO.setRegion(selectedregiontype);
			
			VotingBO votingBO = new VotingBO();
			List<VotingRegionTO> availableVotingTO = votingBO.getAvailableVoteTypesForRegion(loginUserDetailsTO);
			request.setAttribute("availableVotingTO", availableVotingTO);

			List<VotingResultTO> votingResult = votingBO.getVotingResult(selectedregiontype,selectedvotingtype);
			request.setAttribute("votingResult", votingResult);
			RequestDispatcher reqDes = request
					.getRequestDispatcher("/view/voteresult.jsp");
			reqDes.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
