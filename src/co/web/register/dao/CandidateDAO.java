/**
 * 
 */
package co.web.register.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.web.register.to.CandidateTO;
import co.web.register.to.PartyTO;
import co.web.register.util.DBConnection;

/**
 * @author ajoy
 *
 */
public class CandidateDAO {

	/**
	 * 
	 */
	public CandidateDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean addCandidate(CandidateTO candidateTO){
		boolean flag = false;
		//partyname , regionname, candidatename, surname, address, city, pincode
		try {
			String queryString = "INSERT INTO candidates (NAME,SURNAME, PARTY_NAME, REGION, ADDRESS_LINE_1, CITY, PINCODE) VALUES ('"
					+ candidateTO.getCandidatename()
					+ "','"
					+ candidateTO.getSurname()
					+ "','"
					+ candidateTO.getPartyname()
					+ "','"
					+ candidateTO.getRegionname()
					+ "','"
					+ candidateTO.getAddress()
					+ "','"			
					+ candidateTO.getCity()
					+ "','"	
					+ candidateTO.getPincode()
					+ "')";
			System.out.println(" Query String is " + queryString);
			Connection connection = DBConnection.getInstance();
			PreparedStatement statement = connection
					.prepareStatement(queryString);
			statement.execute(queryString);
			flag = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return flag;
	}
	
	public List<CandidateTO> getCandidatesForRegion(String selectedRegion){
		boolean flag = false;
		List<CandidateTO> candidateList = new ArrayList<CandidateTO>();
		
		try {
			String queryString = "SELECT * FROM candidates WHERE REGION = '"+selectedRegion+"'";
			System.out.println(" Query String is " + queryString);
			Connection connection = DBConnection.getInstance();
			PreparedStatement statement = connection
					.prepareStatement(queryString);
			ResultSet rs = statement.executeQuery(queryString);
			while (rs.next()) {
				CandidateTO candidateTO = new CandidateTO();
				candidateTO.setCandidateid(rs.getString("CANDIDATE_ID"));
				candidateTO.setCandidatename(rs.getString("NAME"));
				candidateTO.setSurname(rs.getString("SURNAME"));
				
				
				candidateList.add(candidateTO);
			}
			flag = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(" List Size is >> "+candidateList.size());
		return candidateList;
	}

}
