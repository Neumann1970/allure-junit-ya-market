package ru.yandex.market.junit.allure;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BeapharItemPage {
	
	private WebDriver driver;

	public BeapharItemPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By compareButton = By.cssSelector("[class=\"n-product-toolbar__item-label n-product-toolbar__item-label_activated_no\"]");
	
	public void clickCompare() {
		List<WebElement> list2 = driver.findElements(compareButton);
		for(int i=0;i<list2.size();i++) {
			if (i == 1) {
				WebElement secondItem = list2.get(i);
				secondItem.click();
				break;
			}	
		}
	}
	
	public String getItemH1() {
		String str = driver.findElement(By.cssSelector("h1")).getText();
		
		return str;
	}
	

}
