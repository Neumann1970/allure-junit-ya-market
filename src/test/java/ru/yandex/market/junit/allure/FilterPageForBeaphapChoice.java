package ru.yandex.market.junit.allure;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FilterPageForBeaphapChoice {
	
	WebDriver driver;
	Actions act;

	public FilterPageForBeaphapChoice(WebDriver webDriver) {
		this.driver = webDriver;
		act = new Actions(driver);
	}
	
	@FindBy(id = "glpricefrom")
	private WebElement fromPrice;
	
	@FindBy(id = "glpriceto")
	private WebElement toPrice;
	
	@FindBy (css = "[name=\"Производитель Beaphar\"]")
	private WebElement checkBoxBeaphar;
	
	@FindBy (css = "[name=\"Способ доставки\"]")
	private WebElement radioBoxBrit;
	
	By catItemSnipet = By.className("n-snippet-card2");
	
	
	public void selectRequeiredFilterPriceFrom(String value) {
				fromPrice.sendKeys(value);
				
	}
	
	public void selectRequeiredFilterPriceTo(String value) {
				toPrice.sendKeys(value);
	}
	
	public void setVendorAndEnableDelivery() {
		act.moveToElement(checkBoxBeaphar).click().build().perform();
		act.moveToElement(radioBoxBrit).click().build().perform();
		
	}
	
	public void clickOnBreapharFirstAtTop() {
		
		List<WebElement> list1 = driver.findElements(catItemSnipet);
		System.out.println("Now is :" + driver.getWindowHandle());
		for(int i=0;i<list1.size();i++)
		{
		// System.out.println(i+" "+list1.get(i));
			if (i == 0) {
				WebElement secondItem = list1.get(i).findElement(By.className("n-link_theme_blue"));
				secondItem.click();
				break;
			}
		}
	}
	
	
	
}
