package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageItems {
	
	private WebDriver driver;
	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBar;
	@FindBy(id = "nav-search-submit-button")
	private WebElement searchSubmitButton;
	
	public HomePageItems(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void searchItem(String key) {
		searchBar.sendKeys(key);
		searchSubmitButton.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
