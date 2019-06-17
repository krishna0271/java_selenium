package com.Java_SELENIUM;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","E:\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("ban");
		Thread.sleep(3000);
		System.out.println(driver.getTitle());

		List<WebElement> lst = driver.findElements(By.xpath("//ul[@class='autoFill']/li"));
		System.out.println(lst.size());
		for (int i = 0; i < lst.size(); i++) {
			System.out.println(lst.get(i).getText());
			if(lst.get(i).getText().contains("Silk Board"))   //.equals("selenium interview questions"))
			{
				lst.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		driver.close();

	}

}

