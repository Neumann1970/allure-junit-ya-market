package ru.yandex.market.junit.allure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartUpPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public StartUpPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,10);
	}
	
	@FindBy(className = "n-w-tab__control-hamburger")
	private WebElement menu;
	private By catalogDlyaZhivotnykhMenuItem = By.cssSelector("[href=\"/catalog--tovary-dlia-zhivotnykh/54496\"]");

	@FindBy (css = "[href=\"/catalog--lakomstva-dlia-koshek/62819/list?hid=15963668\"]")
	private WebElement petsMenu;
	
	public void open() {
		driver.get("https://market.yandex.ru/");
	}
	
	public void producMenuClick() {

		menu.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(catalogDlyaZhivotnykhMenuItem));
	}
	
	public void focusSubMenuAndClick() {
		

		WebElement subMenu = driver.findElement(catalogDlyaZhivotnykhMenuItem);
		
		Actions builder = new Actions(driver);
		builder.moveToElement(subMenu).build().perform();
		
		petsMenu.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("footer")));
		
	}

}
