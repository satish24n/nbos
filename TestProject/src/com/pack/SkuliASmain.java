package com.pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SkuliASmain {	
	
	public static void main(String[] args) throws InterruptedException {
		
		SikuliAS sas = new SikuliAS();
		String imgLocation = "E:/test/srcimg/amazon_foot.PNG";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		WebElement amzn = driver.findElement(By.xpath("//div[@class='nav-logo-base nav-sprite']"));
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;				
		jse.executeScript("arguments[0].scrollIntoView();", amzn);		
		Thread.sleep(2000);		
		
		boolean resul = sas.imageComparision(imgLocation, amzn);
		
		if(resul){
			System.out.println(">> Image match successfull!");
		}
		else{
			System.out.println(">> Image did not match!");
		}
		driver.quit();		
	}

}
