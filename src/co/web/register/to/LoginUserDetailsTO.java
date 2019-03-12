/**
 * 
 */
package co.web.register.to;

/**
 * @author ajoy
 *
 */
public class LoginUserDetailsTO {
	
	private String voterid = "";
	private String UUID = "";
	private String region = "";
	private String regionName = "";
	
	
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
	/**
	 * @return the voterid
	 */
	public String getVoterid() {
		return voterid;
	}
	/**
	 * @param voterid the voterid to set
	 */
	public void setVoterid(String voterid) {
		this.voterid = voterid;
	}
	/**
	 * @return the uUID
	 */
	public String getUUID() {
		return UUID;
	}
	/**
	 * @param uUID the uUID to set
	 */
	public void setUUID(String uUID) {
		UUID = uUID;
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
