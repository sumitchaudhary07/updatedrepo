package sumitframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomationPractise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/*WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement practise=driver.findElement(By.cssSelector("//div/button[1]/following-sibling::button[1]/parent::div/parent::header/a[1]"));
Thread.sleep(50000);
			
			practise.click();*/
	
 WebDriver driver=new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			WebElement staticdropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
			Select s=new Select(staticdropdown);
			s.selectByIndex(1);
			
			WebElement passengerDropdown=driver.findElement(By.cssSelector("#divpaxinfo"));
			passengerDropdown.click();
			Thread.sleep(10000);
			
			int i=0;
			while(i<4)
			{
				System.out.println("inside while");
				i++;
			driver.findElement(By.cssSelector("#hrefIncAdt")).click();
				
			}
			
			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
			driver.findElement(By.cssSelector("a[value='BLR']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
	}

}
