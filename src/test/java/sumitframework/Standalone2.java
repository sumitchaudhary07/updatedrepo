package sumitframework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sumitframework.basepackage.Base;

import sumitframework.pageobjectmodel.LandingPage;
import sumitframework.pageobjectmodel.ProductList;

public class Standalone2  extends Base{


	
	
	
@Test(dataProvider = "getData")
	public void driveTest(HashMap<String,String> input) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
	
		System.out.println("started");
	
		WebDriver driver=initiateDriver();
	//LandingPage lp=	LaunchApp(driver);
		
		/*WebDriver driver =new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/client/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();/
		/*
		WebElement username=driver.findElement(By.cssSelector("#userEmail"));
		username.sendKeys("ty@abc.com");
		
		WebElement password=driver.findElement(By.cssSelector("input[formcontrolname='userPassword']"));
		passwod.sendKeys("Hanuman@2024");
		
		WebElement login=driver.findElement(By.cssSelector("#login"));
		login.click();
		*/
		
		//LandingPage landingpage=new LandingPage(driver);
		
		LandingPage lp=new LandingPage(driver);
         
		 
		 lp=LaunchApp(driver);
		System.out.println(input.get("email"));
		System.out.println(input.get("password"));
		lp.loginapp(input.get("email"), input.get("password"));
		
	/*	List<WebElement> listOfProduct=driver.findElements(By.cssSelector(".mb-3"));
		
		
		for (int i=0;i<listOfProduct.size();i++)
		{
			
			
			if(listOfProduct.get(i).getText().contains("ZARA"))
			{
				listOfProduct.get(i).findElement(By.cssSelector("button[class='btn w-10 rounded']")).click();
				
					break;
			}
		}
		*/
		
		
		ProductList pl=new ProductList(driver);
		WebElement procttobeselected=pl.getProductList();
		pl.clickOnProductAddCart(procttobeselected);
  // WebElement successMessage=driver.findElement(By.cssSelector("#toast-container"));
  // WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10000));
 //  wait.until(ExpectedConditions.visibilityOf(successMessage));
  // System.out.println(successMessage.getText());
   
  
   Thread.sleep(30000);
   WebElement addToCart=driver.findElement(By.cssSelector("button[routerlink*='cart']"));
	addToCart.click();
	
	List<WebElement> cartProduct=driver.findElements(By.cssSelector(".cart"));
	System.out.println("going for loop");
	for (int i=0;i<cartProduct.size();i++)
	{
		System.out.println("outside");
		String productname=cartProduct.get(i).findElement(By.cssSelector(".cartSection h3")).getText();
		System.out.println(productname);
		if(productname.contains("ZARA"))
		{
			System.out.println("inside");
			System.out.println("product added succesfully");
			cartProduct.get(i).findElement(By.xpath("//div[3]/button[1]")).click();
				break;
		}
	}
	
	WebElement country=driver.findElement(By.cssSelector("input[placeholder='Select Country']"));
	Actions a=new Actions(driver);
	a.moveToElement(country).click().sendKeys("ind").build().perform();
	
	
	List<WebElement> selectCountry=driver.findElements(By.cssSelector(".ta-results"));
	System.out.println("going for loop");
	for (int i=0;i<selectCountry.size();i++)
	{
		System.out.println("outside");
	
		String countryname=selectCountry.get(i).findElement(By.xpath("//section/button[2]")).getText();
		if(countryname.contains("India"))
		{
			System.out.println("inside");
			
			selectCountry.get(i).findElement(By.xpath("//section/button[2]")).click();
				break;
		}
	}
	driver.quit();
	}
	
	@DataProvider
	
	public Object[][]  getData() throws IOException
	{
		
//DataReader data=new DataReader();
List<HashMap<String,String>> listmap1=readData("E:\\seleniumframework\\data.json");
HashMap<String,String> map1=  listmap1.get(0);
HashMap<String,String> map2=  listmap1.get(1);

return new Object[][] {{map1},{map2}} ;
	}
}
	
