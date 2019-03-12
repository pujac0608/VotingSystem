package co.web.register.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.web.register.to.PartyTO;
import co.web.register.to.RegionTO;
import co.web.register.util.DBConnection;

public class RegionDAO {

	public RegionDAO() {
		// TODO Auto-generated constructor stub
	}

	public boolean addregion(RegionTO regionTO){
		boolean flag = false;
		
		try {
			String queryString = "INSERT INTO regions (NAME,DESCRIPTION) VALUES ('"
					+ regionTO.getRegionname()
					+ "','"
					+ regionTO.getRegiondescription()
					+ "')";
			System.out.println(" Query String is " + queryString);
			Connection connection = DBConnection.getInstance();
			PreparedStatement statement = connection
					.prepareStatement(queryString);
			statement.execute(queryString);
			flag = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return flag;
	}
	
	public List<RegionTO> getAllRegions(){
		boolean flag = false;
		List<RegionTO> regionList = new ArrayList<RegionTO>();
		
		try {
			String queryString = "SELECT * FROM regions";
			System.out.println(" Query String is " + queryString);
			Connection connection = DBConnection.getInstance();
			PreparedStatement statement = connection
					.prepareStatement(queryString);
			ResultSet rs = statement.executeQuery(queryString);
			while (rs.next()) {
				RegionTO regionTO = new RegionTO();
				regionTO.setRegionId(rs.getString("REGION_ID"));
				regionTO.setRegionname(rs.getString("NAME"));
				regionTO.setRegiondescription(rs.getString("DESCRIPTION"));
				regionList.add(regionTO);
			}
			flag = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(" List Size is >> "+regionList.size());
		return regionList;
	}
	
}


