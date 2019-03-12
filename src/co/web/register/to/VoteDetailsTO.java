/**
 * 
 */
package co.web.register.to;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ajoy
 *
 */
public class VoteDetailsTO {

	/**
	 * 
	 */
	public VoteDetailsTO() {
		// TODO Auto-generated constructor stub
	}
	
	private String id= "";	
	private String ballotName= "";
	private String votingtype= "";
	private String regionname= "";
	private String regionId = "";
	private List<BallotCandidateDetailsTO> ballotCandidateDetails = new ArrayList();
	

	/**
	 * @return the regionId
	 */
	public String getRegionId() {
		return regionId;
	}
	/**
	 * @param regionId the regionId to set
	 */
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	/**
	 * @return the ballotCandidateDetails
	 */
	public List<BallotCandidateDetailsTO> getBallotCandidateDetails() {
		return ballotCandidateDetails;
	}
	/**
	 * @param ballotCandidateDetails the ballotCandidateDetails to set
	 */
	public void setBallotCandidateDetails(
			List<BallotCandidateDetailsTO> ballotCandidateDetails) {
		this.ballotCandidateDetails = ballotCandidateDetails;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}	
	/**
	 * @return the ballotName
	 */
	public String getBallotName() {
		return ballotName;
	}
	/**
	 * @param ballotName the ballotName to set
	 */
	public void setBallotName(String ballotName) {
		this.ballotName = ballotName;
	}
	/**
	 * @return the votingtype
	 */
	public String getVotingtype() {
		return votingtype;
	}
	/**
	 * @param votingtype the votingtype to set
	 */
	public void setVotingtype(String votingtype) {
		this.votingtype = votingtype;
	}
	/**
	 * @return the regionname
	 */
	public String getRegionname() {
		return regionname;
	}
	/**
	 * @param regionname the regionname to set
	 */
	public void setRegionname(String regionname) {
		this.regionname = regionname;
	}
	
	
	

}
