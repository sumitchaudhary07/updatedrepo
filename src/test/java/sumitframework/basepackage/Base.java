package sumitframework.basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import sumitframework.pageobjectmodel.LandingPage;

public class Base {
	WebDriver driver;
	
	
	
	public WebDriver initiateDriver() throws IOException
	{
		
		
		FileInputStream fis=new FileInputStream("\\seleniumframework\\src\\test\\java\\resource\\Global.properties");
		 Properties p=new Properties();
		 p.load(fis);
		System.out.println(p.getProperty("browser")); 
		 
		 
	 driver =new ChromeDriver();
	
	 
	return driver;
	
	}
	

	public LandingPage LaunchApp(WebDriver driver) throws IOException
	{
         
		 
		LandingPage landingpage=new LandingPage(driver);
		
		driver.get("https://www.rahulshettyacademy.com/client/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		return landingpage;
		
	}

	public String takeScreenshot(String  testcaseName,WebDriver driver) throws IOException
	{
       TakesScreenshot ts=  (TakesScreenshot) driver;
      File source= ts.getScreenshotAs(OutputType.FILE);		
       String path="E:\\seleniumframework\\"+testcaseName+".png";
       File f=new File(path);
	
	     FileUtils.copyFile(source, f);
	     return path;
		
	}
	public  List<HashMap<String, String>> readData(String filepath) throws IOException
	{
		//converted JSON file to String
		//File f=new File("E:\\seleniumframework\addBook.json");
	String s =new String(Files.readAllBytes(Paths.get(filepath)));
		
	//convert String to Hash MAp
	ObjectMapper mapper=new ObjectMapper();
	TypeReference<List<HashMap<String,String>>> type=new TypeReference<List<HashMap<String,String>>>() {
	};
	List<HashMap<String,String>> listmap=	mapper.readValue(s, type);
	return listmap;
	
	
	}
}
