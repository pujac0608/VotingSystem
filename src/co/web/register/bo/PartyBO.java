package co.web.register.bo;

import java.util.ArrayList;
import java.util.List;

import co.web.register.dao.PartyDAO;
import co.web.register.dao.RegionDAO;
import co.web.register.to.PartyTO;
import co.web.register.to.RegionTO;

public class PartyBO {

	public PartyBO() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean addParty(PartyTO partyTO){
		boolean flag = false;
		PartyDAO partyDAO = new PartyDAO();
		flag = partyDAO.addParty(partyTO);		
		return flag;
	}
	
	public List<PartyTO> getAllParty(){
		List<PartyTO> partyList = new ArrayList<PartyTO>();
		PartyDAO partyDAO = new PartyDAO();
		partyList = partyDAO.getAllParty();		
		return partyList;
	}


}
