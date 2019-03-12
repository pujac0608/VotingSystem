/**
 * 
 */
package co.web.register.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.UUID;

import co.web.register.to.BallotTO;
import co.web.register.util.DBConnection;
import co.web.register.util.Utility;

/**
 * @author puja
 *
 */
public class BallotDAO extends Object {

	public boolean createBallot(BallotTO ballotTo) {

		String uuid = "";
		boolean flag = false;

		Connection connection = DBConnection.getInstance();
		
		try {
			// Set auto-commit to false
			connection.setAutoCommit(false);
			String queryString ="UPDATE ballot SET ACTIVE='N' WHERE REGION='"+ballotTo.getRegion()+"' AND VOTING_TYPE_ID ='"+ballotTo.getVotingtype()+"'";
			System.out.println(" Query String is " + queryString);
			PreparedStatement statement = connection
					.prepareStatement(queryString);
			statement.executeUpdate(queryString);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		try {
			uuid = UUID.randomUUID().toString().substring(0, 10);

			
			
			Statement statement = (Statement) connection.createStatement();
			for (int counter = 0; counter < ballotTo.getCandidateIds().length; counter++) {

				String queryString = "INSERT INTO ballot (BALLOT_ID,CANDIDATE_ID, REGION, VOTING_TYPE_ID,BALLOTNAME,ACTIVE) VALUES ('"
						+ uuid
						+ "','"
						+ ballotTo.getCandidateIds()[counter].toString()
						+ "','" + ballotTo.getRegion() + "','" + ballotTo.getVotingtype() + "','"+ballotTo.getBallotName()+"','Y')";
				System.out.println(" Query String is " + queryString);
				statement.addBatch(queryString);
			}

			// Create an int[] to hold returned values
			int[] count = statement.executeBatch();
			connection.commit();
			flag = true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

}
