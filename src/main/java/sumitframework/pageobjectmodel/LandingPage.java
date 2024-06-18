package sumitframework.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
	}


		// TODO Auto-generated method stub
         @FindBy(css="#userEmail")
		WebElement username;
		
         @FindBy(css="input[formcontrolname='userPassword']")
		WebElement password;
		
         @FindBy(css="#login")
		WebElement login;
		
		
		public void loginapp(String email,String pwd)
		{
			username.sendKeys(email);
			password.sendKeys(pwd);
			login.click();
		}
	
		
	

}
