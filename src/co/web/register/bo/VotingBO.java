/**
 * 
 */
package co.web.register.bo;

import java.util.ArrayList;
import java.util.List;

import co.web.register.dao.PartyDAO;
import co.web.register.dao.VotingDAO;
import co.web.register.dao.VotingResultTO;
import co.web.register.to.LoginUserDetailsTO;
import co.web.register.to.PartyTO;
import co.web.register.to.VoteDetailsTO;
import co.web.register.to.VoteTO;
import co.web.register.to.VotingRegionTO;

/**
 * @author ajoy
 *
 */
public class VotingBO {

	
	public VoteDetailsTO getVoteDetails(LoginUserDetailsTO loginUserDetailsTO, String selectedVotingType){
		VoteDetailsTO voteDetailsTO = new VoteDetailsTO();
		VotingDAO votingDAO = new VotingDAO();		
		voteDetailsTO = votingDAO.getVoteDetails(loginUserDetailsTO, selectedVotingType);
		return voteDetailsTO;
	}
	
	public boolean addVote(VoteTO voteTO){
		boolean flag = false;
		VotingDAO votingDAO = new VotingDAO();
		flag = votingDAO.addVote(voteTO);
		return flag;
	}
	
	public List<VotingRegionTO> getAvailableVoteTypesForRegion(LoginUserDetailsTO loginUserDetailsTO){
		boolean flag = false;
		VotingDAO votingDAO = new VotingDAO();
		List<VotingRegionTO> availableVotingTO = new ArrayList<VotingRegionTO>();
		availableVotingTO = votingDAO.getAvailableVoteTypesForRegion(loginUserDetailsTO);
		return availableVotingTO;
	}
	
	public List<VotingResultTO>  getVotingResult(String region, String votingType) {
		boolean flag = false;
		VotingDAO votingDAO = new VotingDAO();
		List<VotingResultTO> votingResult = new ArrayList<VotingResultTO>();
		votingResult = votingDAO.getVotingResult(region,votingType);
		return votingResult;
	}
	
	
}
