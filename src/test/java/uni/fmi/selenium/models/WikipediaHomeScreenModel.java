package uni.fmi.selenium.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaHomeScreenModel {

	private WebDriver driver;
	private WebElement queryField;
	private WebElement searchButton;

	public WikipediaHomeScreenModel(final WebDriver driver) {
		this.driver = driver;
	}

	public void openScreen() {
		driver.get(
				"https://bg.wikipedia.org/wiki/%D0%9D%D0%B0%D1%87%D0%B0%D0%BB%D0%BD%D0%B0_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");
	}

	/**
	 * @return the queryField
	 */
	public WebElement getQueryField() {
		queryField = driver.findElement(By.id("searchInput"));
		return queryField;
	}

	/**
	 * @return the searchButton
	 */
	public WebElement getSearchButton() {
		searchButton = driver.findElement(By.id("searchButton"));
		return searchButton;
	}

	public DetailsScreenModel clickSearchButton() {

		getSearchButton().click();
		return new DetailsScreenModel(driver);
	}

	public void setQueryParam(final String queryValue) {
		getQueryField().sendKeys(queryValue);
	}

}
