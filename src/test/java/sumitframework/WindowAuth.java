package sumitframework;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowAuth {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	String pathwherefilewillgetdownloaded=	System.getProperty("user.dir");
ChromeOptions option=new ChromeOptions();
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

		chromePrefs.put("profile.default_content_settings.popups", 0);

		chromePrefs.put("download.default_directory", pathwherefilewillgetdownloaded);
		option.setExperimentalOption("prefs", chromePrefs);
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Basic Auth")).click();
		
		driver.get("https://altoconvertpdftojpg.com/");
		driver.manage().window().maximize();
		
		WebElement upload=driver.findElement(By.cssSelector("input[type='file']"));
		upload.sendKeys("E:\\STS_Job Poster Emails_April-2024.pdf");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		driver.findElement(By.cssSelector("#submit_btn")).click();
		Thread.sleep(50000);
		WebElement download=driver.findElement(By.xpath("//div[@class='p-6']/div/div[2]/a"));
		
	/*	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20000));
		wait.until(ExpectedConditions.elementToBeClickable(download));*/
		download.click();
		
		Thread.sleep(20000);
		
		File f=new File(pathwherefilewillgetdownloaded+"/STS_Job_Poster_Emails_April-2024.zip");
		if(f.exists())
		{
			
			System.out.println("File downloaded succesfully");
			
		}
		else
		{
			System.out.println("File  not downloaded ");
			
		}
		
		
	
	}
}
