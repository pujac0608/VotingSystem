package co.web.register.servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class DisplayAddServlet
 */
@WebServlet("/DisplayAddServlet")
public class DisplayAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAddServlet() {
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
		System.out.println(" Clicked Link is "+clickedLink);
		if (clickedLink != null && clickedLink.equalsIgnoreCase("party")) {
			RequestDispatcher reqDes = request.getRequestDispatcher("/view/addparty.jsp");
			reqDes.forward(request, response);
		} else if (clickedLink != null && clickedLink.equalsIgnoreCase("region")) {
			RequestDispatcher reqDes = request.getRequestDispatcher("/view/addregion.jsp");
			reqDes.forward(request, response);
		} else if (clickedLink != null && clickedLink.equalsIgnoreCase("candidate")) {
			RegionBO regionBO = new RegionBO();
			List<RegionTO> regionList = regionBO.getAllRegions();
			request.setAttribute("regionlist", regionList);
			
			PartyBO partyBO = new PartyBO();
			List<PartyTO> partyList = partyBO.getAllParty();
			request.setAttribute("partylist", partyList);
			
			
			RequestDispatcher reqDes = request.getRequestDispatcher("/view/addcandidate.jsp");
			reqDes.forward(request, response);
		}  else if (clickedLink != null && clickedLink.equalsIgnoreCase("voter")) {
			RegionBO regionBO = new RegionBO();
			List<RegionTO> regionList = regionBO.getAllRegions();
			request.setAttribute("regionlist", regionList);
			
			PartyBO partyBO = new PartyBO();
			List<PartyTO> partyList = partyBO.getAllParty();
			request.setAttribute("partylist", partyList);
			
			
			RequestDispatcher reqDes = request.getRequestDispatcher("/view/addvoter.jsp");
			reqDes.forward(request, response);
		} else if (clickedLink != null && clickedLink.equalsIgnoreCase("ballot")) {
			RegionBO regionBO = new RegionBO();
			List<RegionTO> regionList = regionBO.getAllRegions();
			request.setAttribute("regionlist", regionList);
			request.getSession().setAttribute("regionlist", regionList);
			
			PartyBO partyBO = new PartyBO();
			List<PartyTO> partyList = partyBO.getAllParty();
			request.setAttribute("partylist", partyList);
			request.getSession().setAttribute("partylist", partyList);
			
			
			RequestDispatcher reqDes = request.getRequestDispatcher("/view/addballot.jsp");
			reqDes.forward(request, response);
		}  else if (clickedLink != null && clickedLink.equalsIgnoreCase("checkresult")) {
			RegionBO regionBO = new RegionBO();
			List<RegionTO> regionList = regionBO.getAllRegions();
			request.setAttribute("regionlist", regionList);
			request.getSession().setAttribute("regionlist", regionList);
			
			PartyBO partyBO = new PartyBO();
			List<PartyTO> partyList = partyBO.getAllParty();
			request.setAttribute("partylist", partyList);
			request.getSession().setAttribute("partylist", partyList);
			
			
			RequestDispatcher reqDes = request.getRequestDispatcher("/view/voteresult.jsp");
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
