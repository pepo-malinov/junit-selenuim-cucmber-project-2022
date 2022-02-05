package uni.fmi.st.models;

/**
 * Main model for user data representation
 * 
 * @author pepo
 *
 */
public class User {

	private String username;
	private String email;
	private String firstPassword;

	/**
	 * Constructor
	 * 
	 * @param username valid not null or empty User name.
	 * @param password valid not null or empty User password.
	 * @param email    valid not null or empty User email.
	 */
	public User(final String username, final String password, final String email) {
		this.username = username;
		this.firstPassword = password;
		this.email = email;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the firstPassword
	 */
	public String getFirstPassword() {
		return firstPassword;
	}

	/**
	 * @param firstPassword the firstPassword to set
	 */
	public void setFirstPassword(String firstPassword) {
		this.firstPassword = firstPassword;
	}

}
