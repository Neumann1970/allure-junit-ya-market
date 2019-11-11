package ru.yandex.market.junit.allure;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


import io.qameta.allure.Description;
import javafx.util.Pair;

import org.junit.Test;



public class TestClass extends WebDriverSettings {
	
	
	
	@Test
	@Description(value = "Яндекс маркет кошачий корм")
	public void checkUp() throws InterruptedException {
		
		StartUpPage startUpPage = PageFactory.initElements(driver, StartUpPage.class);
	
		startUpPage.open();
		
		startUpPage.producMenuClick();
		
		startUpPage.focusSubMenuAndClick();
		
		
		//====================================================================
		//Устанавливаем фильтры: Стоимость 50-150 / Производитель и способ доставки
		
		FilterPageForBeaphapChoice fpfbc = PageFactory.initElements(driver, FilterPageForBeaphapChoice.class);
		
		fpfbc.selectRequeiredFilterPriceFrom("50");
		fpfbc.selectRequeiredFilterPriceTo("150");
		
		fpfbc.setVendorAndEnableDelivery();


		Thread.sleep(2000);
		String winHandleBefore = driver.getWindowHandle();
		
		//====================================================================
		//Выбираем первый товар из отфильтрованноно списка 
		
		fpfbc.clickOnBreapharFirstAtTop();
		
	
		//Корректируем работу драйвер с табами Chrome
		System.out.println("Now is :" + driver.getWindowHandle());
	
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		for (String tab : tabs) {
		
		driver.switchTo().window(tab);	
	    System.out.println("Now is :" + tab);
	    
		}
		
		
		//====================================================================
		//Нажимаем кнопку сравнить для производителя Beaphar
		
		
		BeapharItemPage bip = PageFactory.initElements(driver, BeapharItemPage.class);
		
		bip.clickCompare();

		String itemName = bip.getItemH1();
		
		System.out.println(itemName);

		//Браузер хром иногда по разному открывает ссылки, в том же или новом окне 
		//Если в новом, то закрываем вкладку.
		//В том же возвращаемся назад
		Thread.sleep(2000);
		int size = tabs.size();
		System.out.println("Show me your size baby :" + size);
			if(size == 2) {
				driver.close();	
				}else {
					driver.navigate().back();
					//driver.navigate().refresh();
				}
		driver.switchTo().window(winHandleBefore);
		
		//====================================================================
		//Корректировка фильтра ( Выбор производителя Мнямс и снятие галги с Beaphar )
		
		FilterPageForMnyamsChoice fpfmc = PageFactory.initElements(driver, FilterPageForMnyamsChoice.class);
		
		fpfmc.setVendorMnyamsAndDisableBeaphar();
	
		
		//Выбираем второй товар производителя Мнямс из списка и заходим в него
		Thread.sleep(4000);
		
		fpfmc.clickForSecondItemOfMnyams();
	
		
		//Шейкер для вкладок Chrome, что бы устранить сбои в работе драйвера
		ArrayList<String> tabsYet = new ArrayList<String>(driver.getWindowHandles());
		for (String tab : tabsYet) {
		
		driver.switchTo().window(tab);	
	    System.out.println("Now is :" + tab);
		}
		
		//Нажимаем кнопку сравнить для производителя Мнянс
		
		MnyamItemPage mnyamItPage = PageFactory.initElements(driver, MnyamItemPage.class);
		
		mnyamItPage.clickCompare();
		
		String ItemMnyamsH1 = mnyamItPage.getItemH1();
		System.out.println(ItemMnyamsH1);
		
		mnyamItPage.clickForCompareCategory();
		
		//====================================================================
		//Проверка стоимости товаров ( не больше 150 рублей )
		
		ComparePage compPage = PageFactory.initElements(driver, ComparePage.class);
		
		Pair<Integer,Integer> forCheckItems = compPage.costCheck();
		Integer firstItem = forCheckItems.getKey();
		Integer secItem = forCheckItems.getValue();
		
		Steps.checkSumStep(firstItem, secItem);
		
		System.out.println("Price of first item :" + firstItem);
		System.out.println("Price of second item :" + secItem);
		
		//====================================================================
		//Удаление Мнямс из сранения
		String nameComparableItem = compPage.killThatCat("Мнямс");
		
		Steps.checkTwoStrings(ItemMnyamsH1, nameComparableItem);
		driver.navigate().refresh();
		
		//====================================================================
		//Удаление Breaphar из сранения
		
		//compPage.killThatCat("Beaphar");
		
		
		//====================================================================
		//Повторная проверка сравнения
		

		Thread.sleep(3000);
		
		driver.findElement(By.className("n-compare-toolbar__action")).click();
		
		Thread.sleep(3000);
		
		String endMessage = driver.findElement(By.cssSelector("[class=\"title title_size_18\"]")).getText();
		
		System.out.println(endMessage);

		Steps.commiteDeletedItems(endMessage);
		
		Thread.sleep(3000);
		
	}	
}
