package ru.yandex.market.junit.allure;

public class CheckInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "от 143 руб";
		String str2 = str.substring(3,6);
		int i = Integer.parseInt(str2.replaceAll(" ", ""));
		int j = 2;
		j+=i;
		System.out.println(str);
		System.out.println(str2);
		System.out.println(j);	
	}
}
