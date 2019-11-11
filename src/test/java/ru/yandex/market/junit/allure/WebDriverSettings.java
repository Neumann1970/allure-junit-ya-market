package ru.yandex.market.junit.allure;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverSettings {
	
	private static final Logger LOG = LoggerFactory.getLogger(WebDriverSettings.class);
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,10);
	}
	
	@After
	public void close() {
		driver.quit();
	}
}
