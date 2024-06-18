package sumitframework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Frames {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		 WebDriver driver= new ChromeDriver();
	      
		  driver.get("https://jqueryui.com/droppable/");
		  
		  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		  
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.cssSelector("iframe[class='demo-frame']"))));
	      
		  
		  Thread.sleep(10000);
	      driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
WebElement drag=driver.findElement(By.id("draggable"));
drag.click();
	}
}
