package co.web.register.bo;

import co.web.register.dao.RegisterDAO;
import co.web.register.to.RegisterTO;

public class RegisterBO {

	public RegisterTO register(RegisterTO registerTo) {
		RegisterDAO registerDAO = new RegisterDAO();
		RegisterTO tempregisterTO = registerDAO.register(registerTo);
		return tempregisterTO;
	}
}
