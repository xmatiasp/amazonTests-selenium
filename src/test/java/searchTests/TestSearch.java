package searchTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePageItems;
import pageObjects.ListPageItems;
import pageObjects.ProductDetailPage;

public class TestSearch {
	
	private WebDriver driver;
	private static final Logger logger = LogManager.getLogger(TestSearch.class);
	
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		logger.info("Navigate To Amazon Page, driver version {}", 
				((RemoteWebDriver)driver).getCapabilities().getVersion());
		driver.navigate().to("https://www.amazon.com/");
	}
	
	@Test(description = "search playstation 4 and add it to cart")
	public void searchPlaystation() {
		logger.info("search Playstation 4");
		HomePageItems homeItems = new HomePageItems(driver);
		homeItems.searchItem("Playstation 4");
		logger.info("Click on the first item");
		ListPageItems listItems = new ListPageItems(driver);
		listItems.clickFirstItem();
		ProductDetailPage itemDetail = new ProductDetailPage(driver);
		itemDetail.addToCart();
		logger.info("verify that the product is added");
		try {
			Assert.assertEquals(itemDetail.returnProductAddedText(), "Agregado al carrito");
			
		} catch (Exception e) {
			logger.error("Element not found");
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	

}
