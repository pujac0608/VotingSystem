/**
 * 
 */
package co.web.register.to;

/**
 * @author ajoy
 *
 */
public class CandidateTO {

	/**
	 * 
	 */
	public CandidateTO() {
		// TODO Auto-generated constructor stub
	}
	
	//partyname , regionname, candidatename, surname, address, city, pincode
	private String partyname = "";
	private String regionname = "";
	private String candidatename = "";
	private String surname = "";
	private String address = "";
	private String city = "";
	private String pincode = "";
	private String candidateid = "";
	
	
	public String getCandidateid() {
		return candidateid;
	}
	public void setCandidateid(String candidateid) {
		this.candidateid = candidateid;
	}
	/**
	 * @return the partyname
	 */
	public String getPartyname() {
		return partyname;
	}
	/**
	 * @param partyname the partyname to set
	 */
	public void setPartyname(String partyname) {
		this.partyname = partyname;
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
	/**
	 * @return the candidatename
	 */
	public String getCandidatename() {
		return candidatename;
	}
	/**
	 * @param candidatename the candidatename to set
	 */
	public void setCandidatename(String candidatename) {
		this.candidatename = candidatename;
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	

}
