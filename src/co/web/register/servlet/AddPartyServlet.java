package co.web.register.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import co.web.register.bo.PartyBO;
import co.web.register.to.PartyTO;

/**
 * Servlet implementation class AddPartyServlet
 */
@WebServlet("/AddPartyServlet")
@MultipartConfig(maxFileSize = 16177215) // upload file up to 16MB  
public class AddPartyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPartyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 
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
			String patryname = request.getParameter("patryname");
			String patrydescription = request.getParameter("patrydescription");
			
			InputStream inputStream = null; // input stream of the upload file
	         
	        // obtains the upload file part in this multipart request
	        Part filePart = request.getPart("filesymbol");
	        
	        
	        System.out.println(" File Part is >> "+filePart);
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
	        }
	        
	       
			
			// Set data in Party TO
			PartyTO partyTo = new PartyTO();
			partyTo.setPatryname(patryname);
			partyTo.setPatrydescription(patrydescription);
			partyTo.setPartySymbol(inputStream);
			System.out.println(" adding party ");
			PartyBO partyBO = new PartyBO();
			boolean flag = partyBO.addParty(partyTo);
			
			if (flag == true) {
				request.setAttribute("usermessage", "Party Has Been added successfully !!!");
				RequestDispatcher reqDes = request.getRequestDispatcher("/view/addparty.jsp");
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
