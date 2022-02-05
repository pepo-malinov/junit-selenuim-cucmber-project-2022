package uni.fmi.st.models;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import uni.fmi.st.repo.UserRepo;
import uni.fmi.st.service.RegisterService;

public class RegisterScreenModel {

	private String username;
	private String firstPassword;
	private String secondPassword;
	private String email;
	private String message;

	public void setUsername(final String username) {
		this.username = username;
	}

	public void setFirstPassword(final String password) {
		this.firstPassword = password;
	}

	public void setSecondPassword(String password) {
		this.secondPassword = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void clickRegisterButton() {
		UserRepo userRepoMock = mock(UserRepo.class);
		doReturn(true).when(userRepoMock).save(anyObject());
		doReturn(true).when(userRepoMock).isUsernameExists("Иван123");
		message = new RegisterService(userRepoMock).registerUser(username, firstPassword, secondPassword, email);
	}

	public String getMessage() {
		return message;
	}

}
