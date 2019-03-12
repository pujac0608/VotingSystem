/**
 * 
 */
package co.web.register.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import co.web.register.to.VoterTO;
import co.web.register.util.DBConnection;
import co.web.register.util.Utility;

/**
 * @author puja
 * 
 */
public class VoterDAO {

	/**
	 * 
	 */
	public VoterDAO() {
		// TODO Auto-generated constructor stub
	}

	public VoterTO addvoter(VoterTO voterTO) {
		try {
			String queryString = "INSERT INTO masteruuid (UUID,REGION,ACTIVE) VALUES ('"
					+ voterTO.getVoterid()
					+ "','"
					+ voterTO.getRegionid()
					+ "'," + "'Y')";
			System.out.println(" Query String is " + queryString);
			Connection connection = DBConnection.getInstance();
			PreparedStatement statement = connection
					.prepareStatement(queryString);
			statement.execute(queryString);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return voterTO;
	}
}
