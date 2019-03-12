/**
 * 
 */
package co.web.register.bo;

import co.web.register.dao.VoterDAO;
import co.web.register.to.VoterTO;

/**
 * @author puja
 * 
 */
public class VoteridBO {

	/**
	 * 
	 */
	public VoteridBO() {
		// TODO Auto-generated constructor stub
	}

	public VoterTO addvoter(VoterTO voterTO) {
		VoterDAO voterDAO = new VoterDAO();
		voterTO = voterDAO.addvoter(voterTO);
		return voterTO;
	}

}
