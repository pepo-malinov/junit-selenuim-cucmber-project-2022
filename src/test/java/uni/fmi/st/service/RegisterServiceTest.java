package uni.fmi.st.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import uni.fmi.st.models.User;
import uni.fmi.st.repo.UserRepo;

/**
 * Test class for {@link RegisterService}
 * 
 * @author pepo
 *
 */
public class RegisterServiceTest {

	private RegisterService testIsntans;
	private UserRepo userRepoMock;

	@Before
	public void setup() {
		userRepoMock = mock(UserRepo.class);
		doReturn(true).when(userRepoMock).save(anyObject());
		//when(userRepoMock.save(anyObject())).thenReturn(true);
		//testIsntans = new RegisterService(getUserRepo());
		testIsntans = new RegisterService(userRepoMock);
	}

	/**
	 * test {@link RegisterService#registerUser(String,String,String,String)} with
	 * valid argument. The email is unique ant the user will be registered.
	 */
	@Test
	public void testRegisterUserWithValidInputs() {
		final String message = testIsntans.registerUser("Иван", "Pass1234!", "Pass1234!", "ivan@abv.bg");
		assertEquals("Успешна регистрация!", message);
	}

	/**
	 * test {@link RegisterService#registerUser(String,String,String,String)} with
	 * not valid user name. The name has to be min 3 simb.
	 */
	@Test
	public void testRegisterUserWithNotValidUsername() {
		final String message = testIsntans.registerUser("Ив", "Pass1234!", "Pass1234!", "ivan@abv.bg");
		assertEquals("Въведете име с поне 3 синвола!", message);
	}

	/**
	 * test {@link RegisterService#registerUser(String,String,String,String)} with
	 * user name without real content. The name has to be min 3 simb.
	 */
	@Test
	public void testRegisterUserWithEmptyUsername() {
		final String message = testIsntans.registerUser("     ", "Pass1234!", "Pass1234!", "ivan@abv.bg");
		assertEquals("Въведете име с поне 3 синвола!", message);
	}

	/**
	 * test {@link RegisterService#registerUser(String,String,String,String)} with
	 * empty user name. The name has to be min 3 simb.
	 */
	@Test
	public void testRegisterUserWithEmptyUsername2() {
		final String message = testIsntans.registerUser("", "Pass1234!", "Pass1234!", "ivan@abv.bg");
		assertEquals("Въведете име с поне 3 синвола!", message);
	}

	/**
	 * test {@link RegisterService#registerUser(String,String,String,String)} with
	 * empty user name. The name has to be min 3 simb.
	 */
	@Test
	public void testRegisterUserWithNullUsername() {
		final String message = testIsntans.registerUser(null, "Pass1234!", "Pass1234!", "ivan@abv.bg");
		assertEquals("Въведете име с поне 3 синвола!", message);
		////System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
		//ChromeDriver driver = new ChromeDriver();
		//driver.get("https://www.abv.bg/");
	}

	private UserRepo getUserRepo() {
		return new UserRepo() {

			@Override
			public boolean save(User newUser) {
				return true;
			}

			@Override
			public boolean isUsernameExists(String username) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}
}
