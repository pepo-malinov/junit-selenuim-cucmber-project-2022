package uni.fmi.st.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import uni.fmi.st.repo.UserRepo;

@RunWith(Parameterized.class)
public class ParameterizedRegisterSreviceTest {

	//@Parameters(name = "Test with username: '"+"{0}"+"' first password '{1}'")
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays
				.asList(new Object[][] { //
					    { "Иван", "Pass1234!", "Pass1234!", "ivan@abv.bg", "Успешна регистрация!" },//0
					    { "Иван123", "Pass1234!", "Pass1234!", "ivan123@abv.bg", "Потребителското име е заето!" },//1
						{ "Ив", "Pass1234!", "Pass1234!", "ivan@abv.bg", "Въведете име с поне 3 синвола!" },//2
						{ "     ", "Pass1234!", "Pass1234!", "ivan@abv.bg", "Въведете име с поне 3 синвола!" },//3
						{ "", "Pass1234!", "Pass1234!", "ivan@abv.bg", "Въведете име с поне 3 синвола!" },//4
						{ "Иван", "Pass", "Pass1234!", "ivan@abv.bg", "Въведете еднакви пароли!" },//5
						{ "Иван", "Pass1234!", "", "ivan@abv.bg", "Въведете еднакви пароли!" },//6
						{ "Иван", "Pass1234!", null, "ivan@abv.bg", "Въведете еднакви пароли!" },//7
						{ "Иван", "Pass1234!", "Pass1234!", "ivan", "Въведете валидна електронна поща!" },//8
						{ "Иван", "Pass1234!", "Pass1234!", "", "Въведете валидна електронна поща!" },//9
						{ "Иван", "Pass1234!", "Pass1234!", "     ", "Въведете валидна електронна поща!" },//10
						{ "Иван", "Pass1234!", "Pass1234!", null, "Въведете валидна електронна поща!" },//11
						{ "Иван", null, "Pass1234!", "ivan@abv.bg", "Въведете първа парола!" },//12
						{ null, "Pass1234!", "Pass1234!", "ivan@abv.bg", "Въведете име с поне 3 синвола!" } //13
						});
	}

	@Parameter
	public String username;
	@Parameter(1)
	public String firstPassword;
	@Parameter(2)
	public String secondPassword;
	@Parameter(3)
	public String emails;
	@Parameter(4)
	public String expectedMessage;

	private RegisterService testIsntans;
	private UserRepo userRepoMock;

	@Before
	public void setup() {
		userRepoMock = mock(UserRepo.class);
		doReturn(true).when(userRepoMock).save(anyObject());
		doReturn(true).when(userRepoMock).isUsernameExists("Иван123");
		// when(userRepoMock.save(anyObject())).thenReturn(true);
		// testIsntans = new RegisterService(getUserRepo());
		testIsntans = new RegisterService(userRepoMock);
	}

	@Test
	public void testRegisterUser() {
		final String message = testIsntans.registerUser(username, firstPassword, secondPassword, emails);
		assertEquals(expectedMessage, message);
	}
}
