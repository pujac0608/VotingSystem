/**
 * 
 */
package co.web.register.bo;

import co.web.register.dao.LoginDAO;
import co.web.register.to.LoginUserDetailsTO;
import co.web.register.to.RegisterTO;
import co.web.register.to.UserTO;

/**
 * @author puja
 *
 */
public class LoginBO {

	/**
	 * 
	 */
	public LoginBO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserTO login(UserTO userTO) {
		LoginDAO loginDAO = new LoginDAO();
		userTO = loginDAO.login(userTO);
		return userTO;
		
	}
	
	
	public LoginUserDetailsTO getloginUserDetails(String UUID) {
		LoginDAO loginDAO = new LoginDAO();
		LoginUserDetailsTO loginUserDetailsTO = new LoginUserDetailsTO();
		loginUserDetailsTO = loginDAO.getloginUserDetails(UUID);
		System.out.println(" 1 >> "+loginUserDetailsTO.getRegion());
		System.out.println(" 2 >> "+loginUserDetailsTO.getUUID());
		System.out.println(" 3 >> "+loginUserDetailsTO.getVoterid());
		System.out.println(" 4 >> "+loginUserDetailsTO.getRegionName());
		return loginUserDetailsTO;
		
	}

}
