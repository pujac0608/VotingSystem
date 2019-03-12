/**
 * 
 */
package co.web.register.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.web.register.to.PartyTO;
import co.web.register.to.RegionTO;
import co.web.register.util.DBConnection;
import co.web.register.util.Utility;

/**
 * @author puja
 *
 */
public class PartyDAO {

	/**
	 * 
	 */
	public PartyDAO() {
		// TODO Auto-generated constructor stub
	}

	public boolean addParty(PartyTO partyTO){
		boolean flag = false;
		
		try {
			String queryString = "INSERT INTO party (PARTY_NAME, PARTY_DESCRIPTION, PARTY_SYMBOL) VALUES (?,?,?)";
			System.out.println(" Query String is " + queryString);
			Connection connection = DBConnection.getInstance();
			PreparedStatement statement = connection
					.prepareStatement(queryString);
			 statement.setString(1, partyTO.getPatryname());
	         statement.setString(2, partyTO.getPatrydescription());
	         System.out.println(" Party Symbol is >> "+partyTO.getPartySymbol());
	         if (partyTO.getPartySymbol() != null) {
	                // fetches input stream of the upload file for the blob column
	                statement.setBlob(3, partyTO.getPartySymbol());
	            }
	    
			statement.executeUpdate();

            
			flag = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return flag;
	}
	
	
	public List<PartyTO> getAllParty(){
		boolean flag = false;
		List<PartyTO> partyList = new ArrayList<PartyTO>();
		
		try {
			String queryString = "SELECT * FROM party";
			System.out.println(" Query String is " + queryString);
			Connection connection = DBConnection.getInstance();
			PreparedStatement statement = connection
					.prepareStatement(queryString);
			ResultSet rs = statement.executeQuery(queryString);
			while (rs.next()) {
				PartyTO partTO = new PartyTO();
				partTO.setPatryid(rs.getString("PARTY_ID"));
				partTO.setPatryname(rs.getString("PARTY_NAME"));
				partTO.setPatrydescription(rs.getString("PARTY_DESCRIPTION"));				
				partyList.add(partTO);
			}
			flag = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(" List Size is >> "+partyList.size());
		return partyList;
	}
	
	
	
}
