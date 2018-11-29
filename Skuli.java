package com.pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Skuli {
	
	public static void main(String[] args) throws FindFailed, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
//		driver.get(""E:\test\srcimg\amazon_foot.PNG"");
		driver.get("https://www.amazon.in/");
		
		Screen screen = new Screen();
		
		Pattern pat1 = new Pattern("E:/test/srcimg/amazon_foot.PNG");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebElement amzn = driver.findElement(By.xpath("//div[@class='nav-logo-base nav-sprite']"));
		
		jse.executeScript("arguments[0].scrollIntoView();", amzn);		
		Thread.sleep(2000);
		screen.capture().save("E:/test/scap");
		
		Finder finder = new Finder(screen.capture().getImage());
		String xyz = finder.find(pat1);
		
		System.out.println("finder ka result: "+ xyz);
		
		if(finder.hasNext()){
			
			Match m = finder.next();
			System.out.println("Match found with "+(m.getScore()*100 +"%"));
			finder.destroy();
		}
		else{
			System.err.println("No Match Found");
		}		
		
//		screen.click(pat1);
		
		
//		driver.quit();
		
	}

}
