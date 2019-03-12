/**
 * 
 */
package co.web.register.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import co.web.register.to.LoginUserDetailsTO;
import co.web.register.to.RegisterTO;
import co.web.register.to.UserTO;
import co.web.register.util.DBConnection;
import co.web.register.util.Utility;

/**
 * @author puja
 * 
 */
public class LoginDAO {

	/**
	 * 
	 */
	public LoginDAO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public UserTO login(UserTO userTO) {

		int count = 0;
		try {
			String queryString = "SELECT FIRST_TIME_USER, USER_ID FROM  user  WHERE UUID = '"
					+ userTO.getUsername()
					+ "' AND PASSWORD ='"
					+ userTO.getPassword()
					+ "' AND ROLE = '"
					+ userTO.getRole() + "'";
			System.out.println(" Query String is " + queryString);
			Connection connection = DBConnection.getInstance();
			PreparedStatement statement = connection
					.prepareStatement(queryString);
			ResultSet rs = statement.executeQuery(queryString);
			while (rs.next()) {
				count = 0 + 1;
				userTO.setFirstTimeUser(rs.getString("FIRST_TIME_USER"));
				userTO.setUsername(rs.getString("USER_ID"));
				userTO.setSuccessfulLogin("Y");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println(" ****** " + userTO.getFirstTimeUser());

		return userTO;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public LoginUserDetailsTO getloginUserDetails(String userUUID) {

		LoginUserDetailsTO loginUserDetailsTO = new LoginUserDetailsTO();
		try {
			String queryString = "select m.REGION, m.UUID, r.NAME from votingsystem.masteruuid m, votingsystem.regions r, votingsystem.ballot b where m.UUID = '"
					+ userUUID
					+ "' and r.REGION_ID = m.REGION and b.REGION = m.REGION GROUP BY m.REGION";
			System.out.println(" Query String is " + queryString);
			Connection connection = DBConnection.getInstance();
			PreparedStatement statement = connection
					.prepareStatement(queryString);
			ResultSet rs = statement.executeQuery(queryString);
			while (rs.next()) {

				loginUserDetailsTO.setRegion(rs.getString("REGION"));
				loginUserDetailsTO.setUUID(rs.getString("UUID"));
				loginUserDetailsTO.setVoterid(rs.getString("UUID"));
				loginUserDetailsTO.setRegionName(rs.getString("NAME"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return loginUserDetailsTO;

	}
}
