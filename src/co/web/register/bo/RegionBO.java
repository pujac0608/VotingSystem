package co.web.register.bo;

import java.util.ArrayList;
import java.util.List;

import co.web.register.dao.RegionDAO;
import co.web.register.to.RegionTO;

public class RegionBO {

	public RegionBO() {
		// TODO Auto-generated constructor stub
	}

	public boolean addRegion(RegionTO RegionTO){
		boolean flag = false;
		RegionDAO regionDAO = new RegionDAO();
		flag = regionDAO.addregion(RegionTO);		
		return flag;
	}
	
	public List<RegionTO> getAllRegions(){
		List<RegionTO> regionList = new ArrayList<RegionTO>();
		RegionDAO regionDAO = new RegionDAO();
		regionList = regionDAO.getAllRegions();		
		return regionList;
	}


}
