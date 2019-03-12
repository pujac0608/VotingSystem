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
import co.web.register.bo.RegionBO;
import co.web.register.to.CandidateTO;
import co.web.register.to.RegionTO;

/**
 * Servlet implementation class AddCandidateServlet
 */
@WebServlet("/AddCandidateServlet")
public class AddCandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCandidateServlet() {
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
			System.out.println(" adding Candidate ");
			String partyname = request.getParameter("partyname");
			String regionname = request.getParameter("regionname");
			String candidatename = request.getParameter("candidatename");
			String surname = request.getParameter("surname");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String pincode = request.getParameter("pincode");
			
			
			// Set data in Party TO
			CandidateTO candidateTO = new CandidateTO();
			candidateTO.setPartyname(partyname);
			candidateTO.setRegionname(regionname);
			candidateTO.setCandidatename(candidatename);
			candidateTO.setSurname(surname);
			candidateTO.setAddress(address);
			candidateTO.setCity(city);
			candidateTO.setPincode(pincode);
			
	
			System.out.println(" adding Candidate ");
			CandidateBO candidateBO = new CandidateBO();
			boolean flag = candidateBO.addCandidate(candidateTO);
			
			if (flag == true) {
				request.setAttribute("usermessage", "Candidate Has Been added successfully !!!");
				RequestDispatcher reqDes = request.getRequestDispatcher("/view/addcandidate.jsp");
				reqDes.forward(request, response);
			} else {
				
			}
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
