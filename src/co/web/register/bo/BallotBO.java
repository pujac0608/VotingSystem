package co.web.register.bo;

import java.util.ArrayList;
import java.util.List;

import co.web.register.dao.BallotDAO;
import co.web.register.dao.CandidateDAO;
import co.web.register.dao.VotingDAO;
import co.web.register.to.BallotTO;
import co.web.register.to.CandidateTO;
import co.web.register.to.LoginUserDetailsTO;
import co.web.register.to.VotingRegionTO;

public class BallotBO {

	public boolean createBallot(BallotTO ballotTo){
		boolean flag = false;
		BallotDAO ballotDAO = new BallotDAO();
		flag = ballotDAO.createBallot(ballotTo);		
		return flag;
	}
	
	public List<VotingRegionTO> getAvailableVoteTypesForRegion(LoginUserDetailsTO loginUserDetailsTO){
		boolean flag = false;
		VotingDAO votingDAO = new VotingDAO();
		List<VotingRegionTO> availableVotingTO = new ArrayList<VotingRegionTO>();
		availableVotingTO = votingDAO.getAvailableVoteTypesForRegion(loginUserDetailsTO);
		return availableVotingTO;
	}
	
}
