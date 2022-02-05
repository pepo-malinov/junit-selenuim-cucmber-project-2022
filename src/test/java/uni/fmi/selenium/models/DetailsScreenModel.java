package uni.fmi.selenium.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailsScreenModel {

	private WebDriver driver;
	@FindBy(id = "firstHeading")
	private WebElement header;

	public DetailsScreenModel(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getHeaderValue() {
		return header.getText();
	}
}
