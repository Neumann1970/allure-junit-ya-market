package ru.yandex.market.junit.allure;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javafx.util.Pair;

public class ComparePage {
	
	WebDriver driver;
	Actions focuse;

	public ComparePage(WebDriver driver) {
		this.driver = driver;
		focuse = new Actions(driver);
	}
	
	public Pair<Integer, Integer> costCheck() { 
		int intItem = 0, sum = 0;
		int nums[] = new int[2];
		List<WebElement> itemsPrice = driver.findElements(By.className("price"));
		for(WebElement item : itemsPrice) {
			
			intItem = Integer.parseInt(item.getText().substring(3,6).replaceAll(" ",""));
			
			if(sum == 0) {
				nums[0] = intItem;
				sum+=intItem;
			
			} else {
				nums[1] = intItem;
				sum+=intItem;
			}
		
		}
		
		System.out.println("Total sum is :" + sum);
		Boolean bool = false;
		if (sum <= 150) {
			 bool = true;
		}
		System.out.println("Bool is :" + bool);
					try {
						Assert.assertEquals(bool, true);
					}catch(java.lang.AssertionError e) {
						System.out.println("Cost more than 150 rubles!");
					}
	return new Pair<>(nums[0],nums[1]);
	}
	
	public String killThatCat(String pattern) throws InterruptedException {
		Boolean found = false;
		String string = null;
		//String pattern = "Мнямс";
		List<WebElement> serchComparableItems = driver.findElements(By.className("n-compare-head__name"));
		for(WebElement searchItem : serchComparableItems ) {
			System.out.println("The name is :" + searchItem.getText());
			string = searchItem.getText();
			found = Arrays.asList(string.split(" ")).contains(pattern);
			if(found){
			      System.out.println("Keyword matched the string");
			     // Actions focuse = new Actions(driver);
			      focuse.moveToElement(searchItem).build().perform();
			      Thread.sleep(1000);
			      WebElement forDeleting = searchItem.findElement(By.xpath(".."));
			      forDeleting.findElement(By.className("n-compare-head__close")).click();
			      break;
			}
			
		}
		return string;
	}
	
}
