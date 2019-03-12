package co.web.register.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.web.register.bo.RegisterBO;
import co.web.register.to.RegisterTO;

/**
 * Servlet implementation class RegisterServlet
 */

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
	
		RegisterTO registerTo = new RegisterTO();
		registerTo.setUserName(request.getParameter("name"));
		registerTo.setUUID(request.getParameter("uuid"));
		RegisterBO registerBO = new RegisterBO();
		registerBO.register(registerTo);
		
		request.setAttribute("RegisterTO", registerTo);
		
		System.out.println(" registerTo.getAlreadyRegister() "+registerTo.getAlreadyRegister());
		System.out.println(" registerTo.getUuidpresent() "+registerTo.getUuidpresent());
		
		RequestDispatcher reqDes = null;
		if (registerTo.getAlreadyRegister().equalsIgnoreCase("YES")) {
			System.out.println(" dispatching alreadyRegistered");
		 reqDes = request.getRequestDispatcher("/view/alreadyRegistered.jsp");
		} else if (registerTo.getUuidpresent().equalsIgnoreCase("N")) {
			System.out.println(" dispatching uuidnotpresent");
		 reqDes = request.getRequestDispatcher("/view/uuidnotpresent.jsp");
		}  else {
			System.out.println(" dispatching registrationsuccess");
		 reqDes = request.getRequestDispatcher("/view/registrationsuccess.jsp");
		}
		
		reqDes.forward(request, response);
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
