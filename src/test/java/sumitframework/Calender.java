package sumitframework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(20000);
		//WebElement table=driver.findElement(By.cssSelector(".tableFixHead"));
		List<WebElement> insidetable=driver.findElements(By.cssSelector(".tableFixHead table tbody tr"));
		
		System.out.println(insidetable.size());
		
		
		//*[@id="product"]/tbody/tr[1]/td[4]
		//*[@id="product"]/tbody/tr[2]/td[4]
		//*[@id="product"]/tbody/tr[1]/td[4]
				//*[@id="product"]/tbody/tr[2]/td[4]
				
				String beforexpath="//*[@id='product']/tbody/tr[";
				String afterXpath="]/td[4]";
				for(int i=1;i<=insidetable.size();i++)
				{
					String actualPath=beforexpath+i+afterXpath;
				System.out.println(driver.findElement(By.xpath(actualPath)).getText());
					
				}
		   
		
			}
	
	//*[@id="product"]/thead/tr/th[1]
	//*[@id="product"]/thead/tr/th[2]

}
