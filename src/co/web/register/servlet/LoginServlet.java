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
import co.web.register.bo.LoginBO;
import co.web.register.bo.RegisterBO;
import co.web.register.to.LoginUserDetailsTO;
import co.web.register.to.RegisterTO;
import co.web.register.to.UserTO;
import co.web.register.to.VotingRegionTO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		UserTO userTo = new UserTO();
		userTo.setUsername(request.getParameter("userid"));
		userTo.setPassword(request.getParameter("password"));
		userTo.setRole(request.getParameter("role"));
		
		System.out.println(" my role is >> "+userTo.getRole());
		System.out.println(" my password is >> "+userTo.getPassword());
		LoginBO loginBO = new LoginBO();
		loginBO.login(userTo);
		
		if (userTo.getSuccessfulLogin().equalsIgnoreCase("Y")) {
			if (userTo.getFirstTimeUser().equalsIgnoreCase("Y")) {
				RequestDispatcher reqDes = request.getRequestDispatcher("/view/changepassword.jsp");
				reqDes.forward(request, response);
			} else {
				if (userTo.getRole().equalsIgnoreCase("AD")) {
					RequestDispatcher reqDes = request.getRequestDispatcher("/view/adminhome.jsp");
					reqDes.forward(request, response);
				} else {
					System.out.println(" UUID >> "+request.getParameter("userid"));
					LoginUserDetailsTO loginUserDetailsTO = loginBO.getloginUserDetails(request.getParameter("userid"));
					request.setAttribute("loginUserDetailsTO", loginUserDetailsTO);
					request.getSession().setAttribute("loginUserDetailsTO", loginUserDetailsTO);
					System.out.println(" 1 >> "+loginUserDetailsTO.getRegion());
					System.out.println(" 2 >> "+loginUserDetailsTO.getUUID());
					System.out.println(" 3 >> "+loginUserDetailsTO.getVoterid());
					System.out.println(" 4 >> "+loginUserDetailsTO.getRegionName());
					BallotBO ballotBO = new BallotBO();
					List<VotingRegionTO> availableVotingTO = new ArrayList<VotingRegionTO>();
					availableVotingTO = ballotBO.getAvailableVoteTypesForRegion(loginUserDetailsTO);
					System.out.println(" Available Voting TO "+availableVotingTO.size());
					request.setAttribute("availableVotingTO", availableVotingTO);
					RequestDispatcher reqDes = request.getRequestDispatcher("/view/vote.jsp");
					reqDes.forward(request, response);
				}
				
			}
		} else {
			RequestDispatcher reqDes = request.getRequestDispatcher("/view/loginfailure.jsp");
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
