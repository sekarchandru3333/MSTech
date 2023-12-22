package mainPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BaseClass{
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Add to Cart']")
	private WebElement mobile;

	@FindBy(xpath="//span[@id='productTitle']")
	private WebElement prodTitle;
		
	@FindBy(xpath="(//span[text()=' 128 GB '])[1]")
	private WebElement prodStorage;
	
	@FindBy(xpath="(//span[text()='Apple'])[1]")
	private WebElement prodBrand;
	
	@FindBy(xpath="(//span[contains(text(),'Black')])[2]")
	private WebElement color;
	
	public WebElement getColor() {
		return color;
	}


	public WebElement getProdBrand() {
		return prodBrand;
	}

	@FindBy(xpath="(//span[text()='₹']//following-sibling::span[text()='77,900'])[3]")
	private WebElement prodPrice;
	
	public WebElement getProdPrice() {
		return prodPrice;
	}


	public WebElement getProdStorage() {
		return prodStorage;
	}


	public WebElement getProdTitle() {
		return prodTitle;
	}


	public WebElement getMobile() {
		return mobile;
	}
	
	
	

}
