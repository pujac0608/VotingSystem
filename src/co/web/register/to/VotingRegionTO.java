/**
 * 
 */
package co.web.register.to;

/**
 * @author ajoy
 *
 */
public class VotingRegionTO {

	private String votingType = "";
	private String regionName = "";
	private String ballotid = "";
	
	
	
	/**
	 * @return the ballotid
	 */
	public String getBallotid() {
		return ballotid;
	}
	/**
	 * @param ballotid the ballotid to set
	 */
	public void setBallotid(String ballotid) {
		this.ballotid = ballotid;
	}
	/**
	 * @return the votingType
	 */
	public String getVotingType() {
		return votingType;
	}
	/**
	 * @param votingType the votingType to set
	 */
	public void setVotingType(String votingType) {
		this.votingType = votingType;
	}
	/**
	 * @return the regionName
	 */
	public String getRegionName() {
		return regionName;
	}
	/**
	 * @param regionName the regionName to set
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
	
	
}
