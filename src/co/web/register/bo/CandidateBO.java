/**
 * 
 */
package co.web.register.bo;

import java.util.ArrayList;
import java.util.List;

import co.web.register.dao.CandidateDAO;
import co.web.register.dao.PartyDAO;
import co.web.register.to.CandidateTO;
import co.web.register.to.PartyTO;

/**
 * @author ajoy
 *
 */
public class CandidateBO {

	/**
	 * 
	 */
	public CandidateBO() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean addCandidate(CandidateTO candidateTO){
		boolean flag = false;
		CandidateDAO candidateDAO = new CandidateDAO();
		flag = candidateDAO.addCandidate(candidateTO);		
		return flag;
	}
	
	public List<CandidateTO> getCandidatesForRegion(String selectedRegion){
		boolean flag = false;
		CandidateDAO candidateDAO = new CandidateDAO();
		List<CandidateTO> candidateList = new ArrayList<CandidateTO>();
		candidateList = candidateDAO.getCandidatesForRegion(selectedRegion);
		return candidateList;
	}
	

}
