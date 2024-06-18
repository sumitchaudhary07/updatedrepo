package sumitframework;

import java.util.Iterator;
import java.util.LinkedHashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ChildWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
      WebDriver driver= new ChromeDriver();
      
   
      
      driver.get("https://rahulshettyacademy.com/loginpagePractise");
	
	driver.findElement(By.cssSelector(".blinkingText")).click();
	LinkedHashSet<String> window1=(LinkedHashSet<String>) driver.getWindowHandles();
    
    Iterator<String> it=window1.iterator();
 
    String windowid = null;
    while(it.hasNext())
    {
   	 windowid=it.next();
   	 
   	 
   	 
    }
    
    driver.switchTo().window(windowid);
   String test= driver.findElement(By.partialLinkText("rahulshettyacademy.com")).getText();
    System.out.println(test);
    System.out.println(it);
    System.out.println(window1);
    System.out.println(it.next());
    driver.switchTo().window(it.next());
    driver.findElement(By.id("username")).sendKeys("test");
  
	}

}
