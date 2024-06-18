package sumitframework;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class Standalone {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//WebDriverManager.chromedriver().setup();

WebDriver driver=new ChromeDriver();
System.out.println("git practise");
driver.get("https://www.rahulshettyacademy.com/client/");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.manage().window().maximize();
WebElement email=driver.findElement(By.id("userEmail"));
email.sendKeys("ty@abc.com");
WebElement password=driver.findElement(By.id("userPassword"));
password.sendKeys("Hanuman@2024");
WebElement login=driver.findElement(By.id("login"));
login.click();
//grab all the product in the screen

List<WebElement> productList=driver.findElements(By.cssSelector(".mb-3"));

int numberofProduct=productList.size();
System.out.println(numberofProduct);
for(int i=0;i<numberofProduct;i++)
	
{
	String productname=productList.get(i).getText();
	System.out.println(productname);
	if(productname.contains("ZARA COAT 3"))
	{
		
	WebElement addToCart=	productList.get(i).findElement(By.cssSelector(".btn.w-10.rounded"));
	addToCart.click();
	break;
	}
	
}

WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement cartsuccMessage=driver.findElement(By.cssSelector("#toast-container"));
wait.until(ExpectedConditions.visibilityOf(cartsuccMessage));
System.out.println(cartsuccMessage.getText());
Thread.sleep(1000);
driver.findElement(By.cssSelector("[routerlink*='cart']")).click();


List <WebElement> result=driver.findElements(By.cssSelector(".cartSection h3"));

int resultsize=result.size();
System.out.println(resultsize);
for(int i=0;i<resultsize;i++) {
	
	if(result.get(i).getText().contains("ZARA COAT 3"))
	{
		
		System.out.println("Product added succesfully");
Assert.assertEquals(true, result.get(i).getText().equals("ZARA COAT 3"));
		
break;
	}
	
	
}

driver.findElement(By.cssSelector(".totalRow button")).click();

Actions a=new Actions(driver);
a.sendKeys(driver.findElement(By.cssSelector("[placeholder*='Select Country']")), "india").build().perform();
}


	}

//css selector  tagname#id
//tagname.classname
//tagname[attribute='value']
//xpath  //tagname[@attribute='value']
//use indexing if we dont have unique value 
//tagname[@attribute='value'][2]
// tagname[attribute='value']:nth-child(3)
//Traversing from parent to child//
// //parenttagname/childtagname[2]


// parentname childname
