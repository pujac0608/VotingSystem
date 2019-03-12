/**
 * 
 */
package co.web.register.to;

/**
 * @author ajoy
 *
 */
public class BallotTO {

	/**
	 * 
	 */
	public BallotTO() {
		// TODO Auto-generated constructor stub
	}

	
	private String ballotName = "";
	private String[] candidateIds = null;
	private String region = "";
	private String votingtype = "";
	
	
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
	 * @return the candidateIds
	 */
	public String[] getCandidateIds() {
		return candidateIds;
	}
	/**
	 * @param candidateIds the candidateIds to set
	 */
	public void setCandidateIds(String[] candidateIds) {
		this.candidateIds = candidateIds;
	}
	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	
	
	
}
