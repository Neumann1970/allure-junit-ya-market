package ru.yandex.market.junit.allure;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MnyamItemPage {

	WebDriver driver;

	public MnyamItemPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By checkBtn = By.cssSelector("[class=\"n-product-toolbar__item-label n-product-toolbar__item-label_activated_no\"]");
	
	@FindBy (css = "[href=\"/compare?track=head\"]")
	private WebElement compareCategory;
	
	public void clickCompare() {
		List<WebElement> list4 = driver.findElements(checkBtn);
		for(int i=0;i<list4.size();i++) {
			if (i == 1) {
				WebElement secondItem = list4.get(i);
				secondItem.click();
				break;
			}
		}
	}
	
	public void clickForCompareCategory() {
		compareCategory.click();
	}
	
	public String getItemH1() {
		String str = driver.findElement(By.cssSelector("h1")).getText();
		
		return str;
	}
	
}
