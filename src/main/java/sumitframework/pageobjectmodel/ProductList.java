package sumitframework.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductList extends ResuableAbstractComponent {
	WebDriver driver;
	
	public ProductList(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css="#toast-container")
	WebElement successMessage;
	public void waitForvisibility(WebElement successMessage)
	{
		
		waitforElement(successMessage);
		System.out.println(successMessage.getText());
	}

	@FindBy(css=".mb-3")
	
	List<WebElement> listOfProduct;
	By productToBeSelected=By.cssSelector("button[class='btn w-10 rounded']");
	WebElement productTo;
	
	public WebElement getProductList()
	{
		
		for (int i=0;i<listOfProduct.size();i++)
		{
			
			
			if(listOfProduct.get(i).getText().contains("ZARA"))
			{
				
				System.out.println(listOfProduct.get(i).getText());
				 productTo=listOfProduct.get(i).findElement(productToBeSelected);
				
					break;
			}
			
			
		}
		return productTo;
		
	}
	
	public void clickOnProductAddCart(WebElement productTo)
	{
		productTo=getProductList();
		productTo.click();
		
	}

	
}
