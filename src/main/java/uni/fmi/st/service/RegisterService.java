package uni.fmi.st.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import uni.fmi.st.models.User;
import uni.fmi.st.repo.UserRepo;

/**
 * Provide functionality to register new user in the system
 * 
 * @author pepo
 *
 */
public class RegisterService {

	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
			.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	private UserRepo userRepo;

	/**
	 * Constructor
	 * 
	 * @param userRepo valid not {@code NULL} instance of {@link UserRepo}
	 */
	public RegisterService(final UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	/**
	 * 
	 * @param username
	 * @param firstPassword
	 * @param secondPassword
	 * @param email
	 * @return
	 */
	public String registerUser(final String username, final String firstPassword, final String secondPassword,
			final String email) {

		if (null == username || username.length() < 3 || username.isBlank()) {
			return "Въведете име с поне 3 синвола!";
		}

		if (!isEmailValid(email)) {
			return "Въведете валидна електронна поща!";
		}

		if (null == firstPassword || firstPassword.isBlank()) {
			return "Въведете първа парола!";
		}

		if (!firstPassword.equals(secondPassword)) {

			return "Въведете еднакви пароли!";
		}

		if (userRepo.isUsernameExists(username)) {
			return "Потребителското име е заето!";
		}

		final User newUser = new User(username, firstPassword, email);
		return userRepo.save(newUser) ? "Успешна регистрация!" : null;
	}

	private static boolean isEmailValid(final String emailStr) {
		if (null != emailStr) {
			Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
			return matcher.find();
		}
		return false;
	}

}
