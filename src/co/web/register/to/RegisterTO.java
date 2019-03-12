package co.web.register.to;

public class RegisterTO {

	
	private String userName = "";
	private String UUID = "";
	private String password = "";
	private String firstTimeUser = "";
	private String alreadyRegister = "";
	private String message = "";
	private String role = "";
	
	private String uuidpresent = "";
	private String uuidpresentmessage = "";

	/**
	 * @return the uuidpresent
	 */
	public String getUuidpresent() {
		return uuidpresent;
	}
	/**
	 * @param uuidpresent the uuidpresent to set
	 */
	public void setUuidpresent(String uuidpresent) {
		this.uuidpresent = uuidpresent;
	}
	/**
	 * @return the uuidpresentmessage
	 */
	public String getUuidpresentmessage() {
		return uuidpresentmessage;
	}
	/**
	 * @param uuidpresentmessage the uuidpresentmessage to set
	 */
	public void setUuidpresentmessage(String uuidpresentmessage) {
		this.uuidpresentmessage = uuidpresentmessage;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the alreadyRegister
	 */
	public String getAlreadyRegister() {
		return alreadyRegister;
	}
	/**
	 * @param alreadyRegister the alreadyRegister to set
	 */
	public void setAlreadyRegister(String alreadyRegister) {
		this.alreadyRegister = alreadyRegister;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the uUID
	 */
	public String getUUID() {
		return UUID;
	}
	/**
	 * @param uUID the uUID to set
	 */
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the firstTimeUser
	 */
	public String getFirstTimeUser() {
		return firstTimeUser;
	}
	/**
	 * @param firstTimeUser the firstTimeUser to set
	 */
	public void setFirstTimeUser(String firstTimeUser) {
		this.firstTimeUser = firstTimeUser;
	}
	
	
}
