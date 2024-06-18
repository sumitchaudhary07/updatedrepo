package sumitframework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSEConcept {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stubb
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.freecrm.com/");
		Thread.sleep(10000);
		WebElement login=driver.findElement(By.xpath("//span[contains(text(),'Log In')]"));
		
		String color=login.getCssValue("backgroundColor");
		JavascriptExecutor js=((JavascriptExecutor)driver);
		/*for(int i=0;i<100;i++)
		{
			
			js.executeScript("arguments[0].style.backgroundColor ='"+"rgb(0,200,0)"+"'",login);
			Thread.sleep(3000);
			js.executeScript("arguments[0].style.backgroundColor ='" +color+"'",login);
		}
		*/
		
		js.executeScript("arguments[0].click();",login);
		System.out.println(js.executeScript("return document.title;").toString());
		
		
		WebElement signup=driver.findElement(By.linkText("Sign Up"));
		js.executeScript("arguments[0].scrollIntoView(true);",signup);
		WebElement email=driver.findElement(By.xpath("//input[@name='email']"));
		
		js.executeScript("arguments[0].click();",email);
		js.executeScript("arguments[0].value='"+"sdgasjd"+"';",email);

	}

}
