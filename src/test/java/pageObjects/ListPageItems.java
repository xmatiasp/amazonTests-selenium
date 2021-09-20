package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListPageItems {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//span[@data-component-type='s-search-results']/div[2]/div[1]//h2//a")
	private WebElement thirdDivItem;
	
	public ListPageItems(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickFirstItem() {
		thirdDivItem.click();
	}
	
	

}
