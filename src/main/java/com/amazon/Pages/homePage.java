package com.amazon.Pages;
import java.util.List;
import java.util.Map;
import java.time.Duration;
import java.util.ArrayList;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class homePage {
	private WebDriver driver;
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchInput;
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	private WebElement searchButton;
	@FindBy(xpath = "//div[contains(@class,'s-suggestion s-suggestion-ellipsis-direction')]")
	private List<WebElement> searchSuggestions;
	@FindBy(xpath = "//h2[normalize-space()='Results']")
	private WebElement serResult;
	@FindBy(xpath = "//h2[contains(@class,'a-size-base a-spacing-none a-color-base a-text-bold')]//span")
	List<WebElement> searchResult;
	@FindBy(xpath = "//span[@class='a-price-whole']")
	private List<WebElement> productPrice;

	public homePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void validateProduct(String product, String expected) throws InterruptedException {
		searchInput.sendKeys(product);
		Assert.assertTrue(true, "Enter text " + expected);		
		for (WebElement ele : searchSuggestions) {			
			if (ele.getText().equalsIgnoreCase(expected)) {
				System.out.println(ele.getText());
				ele.click();			
				break;
			}
		}		
		
		System.out.println("  ");
		
		//WaitAndClick(30,serResult);
		for(WebElement ele:searchResult) {
			System.out.println(ele.getText()+" is the list of iteams");
		}
		
		
	}
	/*public WebElement waitForElementWithPolling(WebDriver driver, final By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofMillis(250))
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class)
            .withMessage("Element not found: " + locator);
        
        return wait.until(driver -> {
            WebElement element = driver.findElement(locator);
            if (element.isDisplayed() && element.isEnabled()) {
                return element;
            }
            return null;
        });
    }
	*/

	public void WaitAndClick(int sec, WebElement element) {	
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
			WebElement ele = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
			ele.click();
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
		}

	}
}
