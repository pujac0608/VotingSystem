package co.web.register.to;

public class UserTO {

	
	private String username = "";
	private String password = "";
	private String role = "";
	private String uuid = "";
	private String alreadyRegisterd = "";
	private String message = "";
	private String firstTimeUser = "";	
	private String successfulLogin = "N";	
	private String oldPassword = "";	
	private String newPassword = "";	

	
	
	
	/**
	 * @return the oldPassword
	 */
	public String getOldPassword() {
		return oldPassword;
	}
	/**
	 * @param oldPassword the oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}
	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	/**
	 * @return the successfulLogin
	 */
	public String getSuccessfulLogin() {
		return successfulLogin;
	}
	/**
	 * @param successfulLogin the successfulLogin to set
	 */
	public void setSuccessfulLogin(String successfulLogin) {
		this.successfulLogin = successfulLogin;
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
	 * @return the alreadyRegisterd
	 */
	public String getAlreadyRegisterd() {
		return alreadyRegisterd;
	}
	/**
	 * @param alreadyRegisterd the alreadyRegisterd to set
	 */
	public void setAlreadyRegisterd(String alreadyRegisterd) {
		this.alreadyRegisterd = alreadyRegisterd;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}
	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
	
}
