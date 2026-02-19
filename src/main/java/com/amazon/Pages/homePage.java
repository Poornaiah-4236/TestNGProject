package com.amazon.Pages;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.Point;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.base.Test.baseTest;
import com.common.Utils.ExtentManager;

public class homePage{
	private WebDriver driver;
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchInput;
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	private WebElement searchButton;
	@FindBy(xpath = "//div[contains(@class,'s-suggestion s-suggestion-ellipsis-direction')]")
	private List<WebElement> searchSuggestions;
	@FindBy(xpath = "//h2[normalize-space()='Results']")
	private WebElement serResult;
	
	By titl=By.xpath("preceding::div[@data-cy='title-recipe'][1]");
	@FindBy(xpath = "//span[@class='a-price-whole']")
	private List<WebElement> productPrice;
	Logger log=LogManager.getLogger(homePage.this);
	
	public homePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	

	public void validateProduct(String product, String expected) throws InterruptedException {
		
		searchInput.sendKeys(product);
		searchButton.click();
		Assert.assertTrue(true, "Enter text " + expected);		
		System.out.println(" These are the list os search result "+productPrice.size());		
		Map<WebElement,Integer>mapEle=new HashMap<>();
		for(WebElement ele:productPrice) {
			mapEle.put(ele, Integer.parseInt(ele.getText().replaceAll(",", "")));			
		}
		Point pos=searchButton.getLocation();
		int x=pos.getX();
		int y=pos.getY();
		searchButton.getAriaRole();
		//System.out.println(mapEle);
		System.out.println("   ");
		List<Entry<WebElement,Integer>>priceEle=new ArrayList<Map.Entry<WebElement,Integer>>(mapEle.entrySet());		
		priceEle.sort(Entry.comparingByValue());
		System.out.println("   ");
		for(Entry e:priceEle) {
			WebElement ele=(WebElement)e.getKey();			
			WebElement title=ele.findElement(titl);
			System.out.println(title.getText());
			System.out.println(" ");		
		}
		priceEle.get(0).getKey().click();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
	}
	
	public void jsScriptClick() {
		WebElement shadowRootEle=driver.findElement(By.xpath(""));
		SearchContext rootEle=shadowRootEle.getShadowRoot();
		rootEle.findElement(By.cssSelector(""));
		//JavascriptExecutor js=JavascriptExecutor(driver);
	}
	public void getDaynicData(String expected) {
		List<WebElement>rows=driver.findElements(By.xpath("//tr"));
		for(int i=0;i<rows.size();i++) {
			List<WebElement>Coloumns=rows.get(i).findElements(By.tagName("tr/td"));
			for(int j=0;i<Coloumns.size();j++) {
				WebElement ele=driver.findElement(By.xpath("ecp"));
				if(ele.getText().equalsIgnoreCase(expected)) {
					ele.click();
					break;
				}else {
					System.out.println("Expected value not present in the given table");
				}
			}
		}
	}
	public void getPriceInOrder() {
		List<Integer> prices = new ArrayList<>();
		for (WebElement price : driver.findElements(By.xpath("//table/tbody/tr/td[2]"))) {
		    prices.add(Integer.parseInt(price.getText().replaceAll("[^0-9]", "")));
		}
		prices.sort(null);
	}
	

	public void WaitAndClick(int sec, List<WebElement> element) {	
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
			for(WebElement ele:element) {
				wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(ele)));
			//ele.click();
			}
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
		}

	}
	
	public void FluientWait() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		Wait<WebDriver>Fluwait=new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(TimeoutException.class);
				
	}
}
