package uni.fmi.st;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uni.fmi.st.models.User;

public class TestFinal {

	@Test
	public void testCreateUser() {
		User user = new User("pesho", "123", "test@test.com");
		configureUser(user);
		System.out.println(user.getUsername());
		assertEquals("ivan", user.getUsername());
	}

	private void configureUser(final User userLocal) {
		if (userLocal.getUsername().equals("pesho")) {
			//userLocal = new User("ivan", "123", "test@test.com");
			userLocal.setUsername("ivan");
		}
	}

}
