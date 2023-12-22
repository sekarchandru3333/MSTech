package mainPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BaseClass{

	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'iPhone 15 (128 GB) - Black')]")
	private WebElement product;

	public WebElement getProduct() {
		return product;
	}
	
	
	
	
}
