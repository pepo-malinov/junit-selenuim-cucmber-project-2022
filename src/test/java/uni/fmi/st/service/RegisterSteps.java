package uni.fmi.st.service;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.fmi.st.models.RegisterScreenModel;

public class RegisterSteps {

	private RegisterScreenModel registerScreen;
	public RegisterSteps(final RegisterScreenModel registerScreen) {
		
		this.registerScreen = registerScreen;
	}
	

	@Given("^Потребителя отваря екрана за регистрация$")
	public void openRegisterScreen() throws Throwable {
	}

	@When("^Въведе потребителско име: \"([^\"]*)\"$")
	public void addUsername(final String username) throws Throwable {
		registerScreen.setUsername(username);
	}

	@When("^въведе валид първа парола$")
	public void addFirstPassword() throws Throwable {
		registerScreen.setFirstPassword("Иван123!");
	}

	@When("^въведе валид втора парола$")
	public void addSecondPassword() throws Throwable {
		registerScreen.setSecondPassword("Иван123!");
	}

	@When("^въведе валидна електронна поща$")
	public void addEmail() throws Throwable {
		registerScreen.setEmail("ivan@abv.bg");
	}

	@When("^натисне бутона за регистрация$")
	public void clickRegisterButton() throws Throwable {
		registerScreen.clickRegisterButton();
	}

	@Then("^вижда съощение: \"([^\"]*)\"$")
	public void checkMessage(final String expectedMessage) throws Throwable {
		assertEquals(expectedMessage, registerScreen.getMessage());
	}
	
	@When("^Въведе невалидно потребителско име$")
	public void въведе_невалидно_потребителско_име() throws Throwable {
		registerScreen.setUsername("Ив");
	}

	@Then("^вижда съощение за невалдно потребителско име$")
	public void вижда_съощение_за_невалдно_потребителско_име() throws Throwable {
		assertEquals("Въведете име с поне 3 синвола!", registerScreen.getMessage());
	}
}
