/**
 * 
 */
package co.web.register.bo;

import co.web.register.dao.PasswordManageDAO;
import co.web.register.to.UserTO;

/**
 * @author puja
 *
 */
public class PasswordManageBO {

	/**
	 * 
	 */
	public PasswordManageBO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserTO changePassword(UserTO userTO) {
		PasswordManageDAO passwordManageDAO = new PasswordManageDAO();
		userTO = passwordManageDAO.changePassword(userTO);
		return userTO;
		
	}

}
