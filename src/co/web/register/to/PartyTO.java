/**
 * 
 */
package co.web.register.to;

import java.io.InputStream;


/**
 * @author puja
 *
 */
public class PartyTO {

	/**
	 * 
	 */
	public PartyTO() {
		// TODO Auto-generated constructor stub
	}

	private String patryid = "";
	private String patryname = "";
	private String patrydescription = "";
	private InputStream partySymbol = null;
	
	
	/**
	 * @return the partySymbol
	 */
	public InputStream getPartySymbol() {
		return partySymbol;
	}
	/**
	 * @param partySymbol the partySymbol to set
	 */
	public void setPartySymbol(InputStream partySymbol) {
		this.partySymbol = partySymbol;
	}
	/**
	 * @return the patryid
	 */
	public String getPatryid() {
		return patryid;
	}
	/**
	 * @param patryid the patryid to set
	 */
	public void setPatryid(String patryid) {
		this.patryid = patryid;
	}
	/**
	 * @return the patryname
	 */
	public String getPatryname() {
		return patryname;
	}
	/**
	 * @param patryname the patryname to set
	 */
	public void setPatryname(String patryname) {
		this.patryname = patryname;
	}
	/**
	 * @return the patrydescription
	 */
	public String getPatrydescription() {
		return patrydescription;
	}
	/**
	 * @param patrydescription the patrydescription to set
	 */
	public void setPatrydescription(String patrydescription) {
		this.patrydescription = patrydescription;
	}
	
}
