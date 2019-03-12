package co.web.register.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import co.web.register.to.RegisterTO;
import co.web.register.util.DBConnection;
import co.web.register.util.Utility;

public class RegisterDAO {

	public RegisterTO register(RegisterTO registerTo) {
		
		int countuuidnumber = 0;
		
		
		try {
			String queryString = "SELECT COUNT(*) AS COUNT FROM  masteruuid  WHERE UUID = '"
					+ registerTo.getUUID() + "'";
			System.out.println(" Query String is " + queryString);
			Connection connection = DBConnection.getInstance();
			PreparedStatement statement = connection
					.prepareStatement(queryString);
			ResultSet rs = statement.executeQuery(queryString);
			while (rs.next()) {
				countuuidnumber = rs.getInt("COUNT");
				System.out.println(" COUNT IS >> " + countuuidnumber);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		if (countuuidnumber == 0) {
			registerTo.setUuidpresent("N");
			registerTo.setUuidpresentmessage("UUID not present !! ");
		}
		
		if (countuuidnumber > 0) {
			
			int count = 0;
			
			
			try {
				String queryString = "SELECT COUNT(*) AS COUNT FROM  user  WHERE UUID = '"
						+ registerTo.getUUID() + "'";
				System.out.println(" Query String is " + queryString);
				Connection connection = DBConnection.getInstance();
				PreparedStatement statement = connection
						.prepareStatement(queryString);
				ResultSet rs = statement.executeQuery(queryString);
				while (rs.next()) {
					count = rs.getInt("COUNT");
					System.out.println(" COUNT IS >> " + count);
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			if (count > 0) {
				registerTo.setAlreadyRegister("YES");
				registerTo.setMessage("User Already Registered !! ");
			}

			if (count < 1) {
				try {
					String queryString = "INSERT INTO user (USER_ID,UUID,PASSWORD,FIRST_TIME_USER,ROLE) VALUES ('"
							+ registerTo.getUserName()
							+ "','"
							+ registerTo.getUUID()
							+ "','"
							+ Utility.getRandomPassword() + "','Y','GV')";
					System.out.println(" Query String is " + queryString);
					Connection connection = DBConnection.getInstance();
					PreparedStatement statement = connection
							.prepareStatement(queryString);
					statement.execute(queryString);

				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
			
			try {
				String password = "";
				String queryString = "SELECT PASSWORD FROM  user  WHERE UUID = '"
						+ registerTo.getUUID() + "'";
				System.out.println(" Query String is " + queryString);
				Connection connection = DBConnection.getInstance();
				PreparedStatement statement = connection
						.prepareStatement(queryString);
				ResultSet rs = statement.executeQuery(queryString);
				while (rs.next()) {
					password = rs.getString("PASSWORD");
					System.out.println(" COUNT IS >> " + count);
					registerTo.setPassword(password);
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
		
		

		return registerTo;
	}
}
