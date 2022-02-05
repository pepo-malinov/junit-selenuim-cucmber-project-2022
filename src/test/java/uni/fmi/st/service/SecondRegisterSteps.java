package uni.fmi.st.service;

import cucumber.api.java.en.When;
import uni.fmi.st.models.RegisterScreenModel;

public class SecondRegisterSteps {
	RegisterScreenModel registerscreen;

	public SecondRegisterSteps(final RegisterScreenModel registerScreen) {

		this.registerscreen = registerScreen;
	}

	@When("^въведе първа парола: \"([^\"]*)\"$")
	public void addFirstPassword(final String password) throws Throwable {
		registerscreen.setFirstPassword(password);
	}

	@When("^въведе втора парола: \"([^\"]*)\"$")
	public void addSecondPassword(final String password) throws Throwable {
		registerscreen.setSecondPassword(password);
	}

	@When("^въведе електронна поща: \"([^\"]*)\"$")
	public void addEmail(final String email) throws Throwable {
		registerscreen.setEmail(email);
	}
}
