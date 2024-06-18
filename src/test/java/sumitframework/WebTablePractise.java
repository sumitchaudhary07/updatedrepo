package sumitframework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver=new ChromeDriver();
	
		
		driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		WebElement dynamicTbale=driver.findElement(By.xpath("//table[@summary='Sample Table']"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", dynamicTbale);
		String text=driver.findElement(By.xpath("(//span[contains(text(),'Burj Khalifa')])[1]/parent::th/following-sibling::td//span[contains(text(),'829')]")).getText();
		
		System.out.println(text);
		
		/*
		System.out.println(driver.findElement(By.xpath("//span[text()='Microsoft']/parent::td/following-sibling::td[2]")).getText());
		
		
		List<WebElement>webtable=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		
		int row=webtable.size();
		List<WebElement>webtablecol=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]/th"));
		
int col=webtablecol.size();
System.out.println(row);
System.out.println(col);

String beforexpath="//table[@id='customers']/tbody/tr[";
String afterxpath="]/td[";
String last="]";

for(int i=2;i<=row;i++)
{
	for(int j=1;j<=col;j++)
	{
		
		//System.out.println(beforexpath+i+afterxpath+j+last);
	String text1=driver.findElement(By.xpath(beforexpath+i+afterxpath+j+last)).getText();
	
	
	if(text1.equals("Microsoft"))
	{
		
		String text2=	driver.findElement(By.xpath(beforexpath+i+afterxpath+j+last)).getText();
		System.out.println(text2);
		
	}
		
	}
}
*/
	}

}
