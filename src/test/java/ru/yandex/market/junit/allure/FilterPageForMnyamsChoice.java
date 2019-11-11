package ru.yandex.market.junit.allure;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FilterPageForMnyamsChoice {
	
	WebDriver driver;
	Actions act;

	public FilterPageForMnyamsChoice(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
	}
	
	@FindBy (css = "[name=\"Производитель Мнямс\"]")
	private WebElement checkBoxMiams;
	
	@FindBy (css = "[name=\"Производитель Beaphar\"]")
	private WebElement unCheckedBoxBeaphar;
	
	By secItemMnyams = By.className("n-snippet-card2");
	
	By clickItemMnyamsLink = By.className("n-link_theme_blue");
	
	public void setVendorMnyamsAndDisableBeaphar() {
		act.moveToElement(checkBoxMiams).click().build().perform();
		act.moveToElement(unCheckedBoxBeaphar).click().build().perform();
	}
	
	public void clickForSecondItemOfMnyams() {
		List<WebElement> list3 = driver.findElements(secItemMnyams);
		for(int i=0;i<list3.size();i++)
		{
			if (i == 1) {
				WebElement mnyamsItem = list3.get(i).findElement(clickItemMnyamsLink);
				mnyamsItem.click();
				break;
			}
		}
		
	}
}
