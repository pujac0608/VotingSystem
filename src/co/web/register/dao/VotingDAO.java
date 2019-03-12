/**
 * 
 */
package co.web.register.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.web.register.to.BallotCandidateDetailsTO;
import co.web.register.to.LoginUserDetailsTO;
import co.web.register.to.PartyTO;
import co.web.register.to.UserTO;
import co.web.register.to.VoteDetailsTO;
import co.web.register.to.VoteTO;
import co.web.register.to.VotingRegionTO;
import co.web.register.to.VotingResult;
import co.web.register.util.DBConnection;

/**
 * @author ajoy
 *
 */
public class VotingDAO {

	/**
	 * 
	 */
	public VotingDAO() {

	}

	public VoteDetailsTO getVoteDetails(LoginUserDetailsTO loginUserDetailsTO, String selectedVotingType) {

		boolean flag = false;
		VoteDetailsTO voteDetailsTO = null;
		List<BallotCandidateDetailsTO> ballotCandidateDetailsList = new ArrayList<BallotCandidateDetailsTO>();
		try {
			String queryString = "SELECT b.BALLOTNAME, b.BALLOT_ID, b.CANDIDATE_ID, b.ACTIVE, b.REGION, r.NAME as REGIONNAME, c.NAME, c.SURNAME, p.PARTY_ID, p.PARTY_NAME, c.PARTY_SYMBOL FROM votingsystem.ballot b, votingsystem.candidates c, votingsystem.party p, votingsystem.regions r	 where b.VOTING_TYPE_ID = '"+selectedVotingType+"' and r.REGION_ID = b.REGION and b.CANDIDATE_ID = c.CANDIDATE_ID and c.PARTY_NAME = p.PARTY_ID and b.ACTIVE = 'Y' and b.REGION = '"+loginUserDetailsTO.getRegion()+"'";
			System.out.println(" Query String is " + queryString);
			Connection connection = DBConnection.getInstance();
			PreparedStatement statement = connection
					.prepareStatement(queryString);
			ResultSet rs = statement.executeQuery(queryString);
			String tempBallotId = "";

			while (rs.next()) {				
				if (!tempBallotId.equals(rs.getString("BALLOT_ID"))) {
					voteDetailsTO = new VoteDetailsTO();
					tempBallotId = rs.getString("BALLOT_ID");					
					voteDetailsTO.setBallotName(rs.getString("BALLOTNAME"));
					voteDetailsTO.setId(rs.getString("BALLOT_ID"));
					
				}
				BallotCandidateDetailsTO ballotCandidateDetailsTO = new BallotCandidateDetailsTO();
				ballotCandidateDetailsTO.setCandidateId(rs.getString("CANDIDATE_ID"));	
				ballotCandidateDetailsTO.setCandidateName(rs.getString("NAME")+" "+rs.getString("SURNAME"));	
				ballotCandidateDetailsTO.setPartyid(rs.getString("PARTY_ID"));	
				ballotCandidateDetailsTO.setPartyname(rs.getString("PARTY_NAME"));	
				ballotCandidateDetailsList.add(ballotCandidateDetailsTO);			
				
			}
			voteDetailsTO.setBallotCandidateDetails(ballotCandidateDetailsList);
			flag = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
		return voteDetailsTO;
	}
	
	/**
	 * 
	 * @param loginUserDetailsTO
	 * @return
	 */
	public List<VotingRegionTO>  getAvailableVoteTypesForRegion(LoginUserDetailsTO loginUserDetailsTO) {

		boolean flag = false;
		VoteDetailsTO voteDetailsTO = null;
		List<VotingRegionTO> voteTypeLists = new ArrayList<VotingRegionTO>();
		try {
			String queryString = "SELECT  b.VOTING_TYPE_ID, b.BALLOT_ID, b.REGION, r.NAME as REGIONNAME FROM votingsystem.ballot b, votingsystem.regions r where   r.REGION_ID = b.REGION and b.ACTIVE = 'Y' and b.REGION = '"+loginUserDetailsTO.getRegion()+"' GROUP BY VOTING_TYPE_ID";
			System.out.println(" Query String is " + queryString);
			Connection connection = DBConnection.getInstance();
			PreparedStatement statement = connection
					.prepareStatement(queryString);
			ResultSet rs = statement.executeQuery(queryString);
			String tempBallotId = "";

			while (rs.next()) {				
				
				VotingRegionTO votingRegionTO = new VotingRegionTO();
				votingRegionTO.setRegionName(rs.getString("REGIONNAME"));
				votingRegionTO.setVotingType(rs.getString("VOTING_TYPE_ID"));
				votingRegionTO.setBallotid(rs.getString("BALLOT_ID")); 
				voteTypeLists.add(votingRegionTO);			
				
			}
			
			flag = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
		return voteTypeLists;
	}
	
	public boolean addVote(VoteTO voteTO){
		boolean flag = false;
		System.out.println(" Voting Type ID "+voteTO.getVotingtypeid());
		System.out.println(" UUID ID "+voteTO.getUuid());
		int countuuidnumber = 0;
		try {
			String queryString = "SELECT COUNT(*) AS COUNT FROM  votingresult  WHERE VOTING_TYPE_ID = '"+ voteTO.getVotingtypeid() + "' AND UUID ='"+voteTO.getUuid()+"'";
			System.out.println(" Query String is " + queryString);
			Connection connection = DBConnection.getInstance();
			PreparedStatement statement = connection
					.prepareStatement(queryString);
			ResultSet rs = statement.executeQuery(queryString);
			while (rs.next()) {
				countuuidnumber = rs.getInt("COUNT");
				System.out.println(" COUNT IS >> " + countuuidnumber);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		if (countuuidnumber == 0){
			try {
				String queryString = "INSERT INTO votingresult (VOTING_TYPE_ID, UUID, PARTY_ID,CANDIDATE_ID,BALLOT_ID) VALUES (?,?,?,?,?)";
				System.out.println(" Query String is " + queryString);
				Connection connection = DBConnection.getInstance();
				PreparedStatement statement = connection
						.prepareStatement(queryString);
				 statement.setString(1, voteTO.getVotingtypeid());
		         statement.setString(2, voteTO.getUuid());
		         statement.setString(3, voteTO.getPartyid());
		         statement.setString(4, voteTO.getCandidateid());
		         statement.setString(5, voteTO.getBallotid());
		    
				statement.execute();

				flag = true;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			flag = false;
		}
		
		
		return flag;
	}

	public List<VotingResultTO>  getVotingResult(String region, String votingType) {

		
		boolean flag = false;
		VoteDetailsTO voteDetailsTO = null;
		List<VotingRegionTO> voteTypeLists = new ArrayList<VotingRegionTO>();
		Map<String,VotingResultTO> voteResultMap = new HashMap<String,VotingResultTO>();
		System.out.println(" Region >> "+region);
		System.out.println(" votingType >> "+votingType);
		try {
			String queryString = "SELECT v.VOTING_TYPE_ID as VOTING_TYPE_ID, p.PARTY_NAME as PARTY FROM votingsystem.votingresult v, votingsystem.ballot b, votingsystem.party p where v.VOTING_TYPE_ID = '"+votingType+"' and b.REGION = '"+region+"' and p.PARTY_ID = v.PARTY_ID and v.BALLOT_ID = b.BALLOT_ID GROUP BY v.UUID;";
			System.out.println(" Query String is " + queryString);
			Connection connection = DBConnection.getInstance();
			PreparedStatement statement = connection
					.prepareStatement(queryString);
			ResultSet rs = statement.executeQuery(queryString);
			String tempBallotId = "";

			while (rs.next()) {				
				String party = (String)rs.getString("PARTY");
				
				if (voteResultMap.get(party) != null) {					
					VotingResultTO existingVoteResultObj = (VotingResultTO)voteResultMap.get(party);
					int tempVoteCount = existingVoteResultObj.getVoteCount();
					existingVoteResultObj.setVoteCount(tempVoteCount+1);
					voteResultMap.put(party, existingVoteResultObj);
				} else {
					VotingResultTO newVoteResultObj = new VotingResultTO();
					newVoteResultObj.setPartyName(party);
					newVoteResultObj.setVoteCount(1);
					voteResultMap.put(party, newVoteResultObj);
				}	
			}
			
			flag = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
		List<VotingResultTO> valueList = new ArrayList<VotingResultTO>(voteResultMap.values());
		
		System.out.println(" Value List is > "+valueList.size());
		
		return valueList;
	}
	
	//
}
