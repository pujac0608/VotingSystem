package co.web.register.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.web.register.bo.PartyBO;
import co.web.register.bo.RegionBO;
import co.web.register.to.PartyTO;
import co.web.register.to.RegionTO;

/**
 * Servlet implementation class AddRegionServlet
 */
@WebServlet(description = "AddRegionServlet", urlPatterns = { "/AddRegionServlet" })
public class AddRegionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRegionServlet() {
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
			System.out.println(" adding party ");
			String regionname = request.getParameter("regionname");
			String regiondesc = request.getParameter("regiondesc");
			
			// Set data in Party TO
			RegionTO regionTO = new RegionTO();
			regionTO.setRegionname(regionname);
			regionTO.setRegiondescription(regiondesc);
	
			System.out.println(" adding region ");
			RegionBO regionBO = new RegionBO();
			boolean flag = regionBO.addRegion(regionTO);
			
			if (flag == true) {
				request.setAttribute("usermessage", "Region Has Been added successfully !!!");
				RequestDispatcher reqDes = request.getRequestDispatcher("/view/addregion.jsp");
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
