package co.web.register.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.web.register.bo.CandidateBO;
import co.web.register.bo.VoteridBO;
import co.web.register.to.CandidateTO;
import co.web.register.to.VoterTO;

/**
 * Servlet implementation class AddVoterServlet
 */
@WebServlet("/AddVoterServlet")
public class AddVoterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVoterServlet() {
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
			RequestDispatcher reqDes = request.getRequestDispatcher("/view/adminhome.jsp");
			reqDes.forward(request, response);
		} else {
			//partyname , regionname, candidatename, surname, address, city, pincode
			System.out.println(" adding Voter ");
			
			String voterid = request.getParameter("voterid");
			String regionname = request.getParameter("regionname");
			
			
			// Set data in Party TO
			VoterTO voterTO = new VoterTO();
			voterTO.setRegionid(regionname);
			voterTO.setVoterid(voterid);
		
			
	
			System.out.println(" adding Candidate ");
			VoteridBO voteridBO = new VoteridBO();
			voteridBO.addvoter(voterTO);
			
			
			request.setAttribute("usermessage", "Voter Has Been added successfully !!!");
			RequestDispatcher reqDes = request.getRequestDispatcher("/view/addvoter.jsp");
			reqDes.forward(request, response);
		
		}

		System.out.println(" Within Service ");
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
