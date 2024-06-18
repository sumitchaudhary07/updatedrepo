package sumitframework;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> link=driver.findElements(By.tagName("a"));
		int countoflink=link.size();
		System.out.println(countoflink);
		WebElement footer=driver.findElement(By.id("gf-BIG"));
		List<WebElement> footerlink=footer.findElements(By.tagName("a"));
		
		System.out.println(footerlink.size());
		WebElement coulumdriver=footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		List<WebElement> coulum=coulumdriver.findElements(By.tagName("a"));
		System.out.println(coulum.size());
		

		
		for(int i=1;i<coulum.size();i++)
			
		{
			//Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			coulum.get(i).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
		}
			
			Set<String> linkwindow=driver.getWindowHandles();
			
			Iterator<String> it=linkwindow.iterator();
			while(it.hasNext())
			{
				String windowname=driver.switchTo().window(it.next()).getTitle();
				System.out.println(windowname);
				
			}
		}

	}


