package sumitframework.pageobjectmodel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResuableAbstractComponent {
	
	WebDriver driver;
	public ResuableAbstractComponent(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}

	public void waitforElement(WebElement successMessage)
	{
		
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10000));
		   wait.until(ExpectedConditions.visibilityOf(successMessage));
	}

}
