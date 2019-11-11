package ru.yandex.market.junit.allure;

import io.qameta.allure.Step;
import org.junit.Assert;

public class Steps {

    @Step(value = "Проверка общей стомости для числа {num1} и числа {num2} не больше 300")
    public static void checkSumStep(int num1, int num2) {
        Assert.assertTrue("Цена за оба товара не больше 300р ", num1 + num2 <= 300);
    }

    @Step(value = "Проверки товаров {str1} {str2} в Разделе сравнения")
    public static void checkTwoStrings(String str1, String str2) {
        Assert.assertTrue("Оба товара идентичны ", str1.equals(str2));
    }
    
    @Step(value = "Удаление товара {str} из Сравнения")
    public static void commiteDeletedItems(String str) {
        Assert.assertTrue("Сообщение об удалении", str.equals("Товаров нет. Чтобы увидеть ранее добавленные вами товары, авторизуйтесь."));
    }
}
