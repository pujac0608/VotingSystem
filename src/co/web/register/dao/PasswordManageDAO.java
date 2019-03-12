/**
 * 
 */
package co.web.register.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import co.web.register.to.RegisterTO;
import co.web.register.to.UserTO;
import co.web.register.util.DBConnection;
import co.web.register.util.Utility;

/**
 * @author puja
 * 
 */
public class PasswordManageDAO {

	/**
	 * 
	 */
	public PasswordManageDAO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public UserTO changePassword(UserTO userTO) {

		int count = 0;
		try {
			String queryString = "UPDATE user SET PASSWORD='"
					+ userTO.getNewPassword()
					+ "',  FIRST_TIME_USER ='"
					+ "N"
					+ "' WHERE UUID ='"
					+ userTO.getUsername()
					+ "' AND PASSWORD = '"
					+ userTO.getOldPassword() + "'";
			System.out.println(" Query String is " + queryString);
			Connection connection = DBConnection.getInstance();
			PreparedStatement statement = connection
					.prepareStatement(queryString);
			int changedRowNumber = statement.executeUpdate(queryString);
			System.out.println(" ****** "+changedRowNumber);
			if (changedRowNumber > 0) {
				userTO.setFirstTimeUser("N");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		

		return userTO;
		// TODO Auto-generated constructor stub
	}
}
