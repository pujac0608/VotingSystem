package co.web.register.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.web.register.bo.BallotBO;
import co.web.register.bo.CandidateBO;
import co.web.register.to.BallotTO;
import co.web.register.to.CandidateTO;

/**
 * Servlet implementation class AddBallotServlet
 */
@WebServlet("/AddBallotServlet")
public class AddBallotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBallotServlet() {
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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String clickedLink = request.getParameter("clickedLink");
		if (clickedLink != null && clickedLink.equalsIgnoreCase("cancel")) {
			RequestDispatcher reqDes = request
					.getRequestDispatcher("/view/adminhome.jsp");
			reqDes.forward(request, response);
		} else if (clickedLink != null
				&& clickedLink.equalsIgnoreCase("onregionchange")) {
			// partyname , regionname, candidatename, surname, address, city,
			// pincode
			System.out.println(" adding Candidate ");

			String regionname = request.getParameter("regionname");
			request.setAttribute("selectregion", regionname);

			System.out.println(" adding Candidate ");
			CandidateBO candidateBO = new CandidateBO();
			List<CandidateTO> candidateList = new ArrayList<CandidateTO>();
			candidateList = candidateBO.getCandidatesForRegion(regionname);
			request.setAttribute("candidatelist", candidateList);

			RequestDispatcher reqDes = request
					.getRequestDispatcher("/view/addballot.jsp");
			reqDes.forward(request, response);
		} else if (clickedLink != null
				&& clickedLink.equalsIgnoreCase("addballot")) {
			// partyname , regionname, candidatename, surname, address, city,
			// pincode
			System.out.println(" adding Candidate ");

			String ballotname = request.getParameter("ballotname");
			String regionname = request.getParameter("regionname");
			String votingtype = request.getParameter("votingtype");
			String[] selectedcandidateid = request
					.getParameterValues("candidate");

			request.setAttribute("selectregion", "");
			
			System.out.println(" 1 >>"+ballotname);
			System.out.println(" 1 >>"+regionname);
			System.out.println(" 1 >>"+selectedcandidateid.length);
			
			for (int i = 0; i < selectedcandidateid.length; i++) {
				System.out.println(" test >>"+selectedcandidateid[i]);
			}
			
			BallotTO ballotTO = new BallotTO();
			ballotTO.setBallotName(ballotname);
			ballotTO.setRegion(regionname);
			ballotTO.setVotingtype(votingtype);
			ballotTO.setCandidateIds(selectedcandidateid);
			
			BallotBO ballotBO = new BallotBO();
			boolean flag = ballotBO.createBallot(ballotTO);

			RequestDispatcher reqDes = request
					.getRequestDispatcher("/view/addballot.jsp");
			reqDes.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
