package co.web.register.util;

import java.util.UUID;

public class Utility {

	public static String getRandomPassword(){
		String uuid = UUID.randomUUID().toString();		
		return uuid.substring(0,4);
	}
}
