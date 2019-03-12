package co.web.register.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.web.register.bo.LoginBO;
import co.web.register.bo.PasswordManageBO;
import co.web.register.to.UserTO;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
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
		userTo.setOldPassword(request.getParameter("oldpassword"));
		userTo.setNewPassword(request.getParameter("newpassword"));		
		
		System.out.println(" my role is >> "+userTo.getRole());
		System.out.println(" my password is >> "+userTo.getPassword());
		PasswordManageBO passwordManageBO = new PasswordManageBO();
		passwordManageBO.changePassword(userTo);
		if (userTo.getFirstTimeUser().equalsIgnoreCase("N")) {
			RequestDispatcher reqDes = request.getRequestDispatcher("/view/changepasswordsuccess.jsp");
			reqDes.forward(request, response);
		} else {
			RequestDispatcher reqDes = request.getRequestDispatcher("/view/vote.jsp");
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
