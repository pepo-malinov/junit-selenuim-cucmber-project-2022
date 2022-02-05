package uni.fmi.selenium;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import uni.fmi.selenium.models.DetailsScreenModel;
import uni.fmi.selenium.models.WikipediaHomeScreenModel;

public class SeleniumTest {
	private WebDriver driver;
	private WikipediaHomeScreenModel homeScreenModel;

	@BeforeClass
	public static void setupClass() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
	}

	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		homeScreenModel = new WikipediaHomeScreenModel(driver);

	}

	@After
	public void after() {
		driver.close();
	}

	@Test
	public void testWikipediaHomescreen() throws InterruptedException {
		driver.get(
				"https://bg.wikipedia.org/wiki/%D0%9D%D0%B0%D1%87%D0%B0%D0%BB%D0%BD%D0%B0_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");
		final WebElement queryField = driver.findElement(By.id("searchInput"));
		queryField.sendKeys("Япония");
		final WebElement searchButton = driver.findElement(By.id("searchButton"));
		searchButton.click();
		final WebElement h1 = driver.findElement(By.id("firstHeading"));
		assertEquals("Япония", h1.getText());

		Thread.sleep(6000);
	}

	@Test
	public void testWikipediaHomescreen2() throws InterruptedException {
		homeScreenModel.openScreen();
		homeScreenModel.setQueryParam("Парагвай");
		final DetailsScreenModel resulScreen = homeScreenModel.clickSearchButton();

		assertEquals("Парагвай", resulScreen.getHeaderValue());

		Thread.sleep(6000);
	}
}
