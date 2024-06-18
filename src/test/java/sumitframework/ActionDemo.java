package sumitframework;

import java.util.Iterator;
import java.util.LinkedHashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
      WebDriver driver= new ChromeDriver();
      
      Actions a=new Actions(driver);
      
      driver.get("https://www.amazon.com/");
      Thread.sleep(20000);
      driver.manage().window().maximize();
      driver.findElement(By.cssSelector("input[data-action-type='DISMISS']")).click();
      
      WebElement search= driver.findElement(By.cssSelector("#twotabsearchtextbox"));
      a.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("hello").keyUp(Keys.SHIFT).sendKeys("ello").sendKeys(Keys.ARROW_LEFT)
      .keyDown(Keys.SHIFT)
      .sendKeys(Keys.ARROW_UP)
      .keyUp(Keys.SHIFT)
      .build().perform();
      
     a.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList"))).build().perform();
     
     LinkedHashSet<String> window=(LinkedHashSet<String>) driver.getWindowHandles();
     
     Iterator<String> it=window.iterator();
     int size=window.size();
     String windowid = null;
     while(it.hasNext())
     {
    	 windowid=it.next();
    	 
    	 
    	 
     }
     
     driver.switchTo().window(windowid);
     
   
      
      
	}

}
