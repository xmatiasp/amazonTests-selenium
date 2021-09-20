package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.gson.JsonObject;



public class ProductDetailPage {
	
	private WebDriver driver;
	
	@FindBy(id = "productTitle")
	private WebElement productTitle;
	@FindBy(id = "priceblock_ourprice")
	private WebElement productPrice;
	@FindBy(id = "add-to-cart-button")
	private WebElement addToCartButton;
	@FindBy(xpath = "//*[@id=\"huc-v2-order-row-confirm-text\"]/h1")
	private WebElement orderConfirmText;
	
	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void getPriceAndProductName() {
		productTitle.getText();
		JsonObject producto1 = new JsonObject();
		producto1.addProperty("ProductName", productTitle.getText());
		
	}
	
	public void addToCart() {
		addToCartButton.click();
		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public String returnProductAddedText() {
		return orderConfirmText.getText();
		
	}
}
