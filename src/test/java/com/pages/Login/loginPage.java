package com.pages.Login;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import com.base.Test.baseTest;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class loginPage extends baseTest {
	@FindBy(xpath = "//a[normalize-space()='Login with Loan/App No.']")
	WebElement logInTab;
	@FindBy(xpath = "//input[@id='loan_no']")
	WebElement applicationNum;
	@FindBy(id = "dob_day")
	WebElement Dobday;
	@FindBy(id = "dob_month")
	WebElement month;
	@FindBy(id = "dob_year")
	WebElement year;
	//private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private WebDriver driver;
	public loginPage(WebDriver driver) {
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void EnterLoginDetails() {
		WaitAndClick(30,logInTab);
		applicationNum.sendKeys("1234567890");
		Select doDay = new Select(Dobday);
		doDay.selectByValue("2");
		Select dobMon = new Select(month);
		dobMon.selectByValue("2");
		Select dobYear = new Select(year);
		dobYear.selectByValue("1983");		

	}

	public void WaitAndClick(int sec,WebElement element) {		
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
			WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(element));
			ele.click();
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
		}

	}
	public void actionsExamples() {
		Actions acts=new Actions (driver);
		acts.moveToElement(Dobday).perform();
		acts.doubleClick();
		acts.keyDown(Keys.BACK_SPACE);
		acts.keyUp(Keys.ARROW_RIGHT);
	}

	public void Flu() {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30L))
				.pollingEvery(Duration.ofSeconds(5L)).ignoring(NoSuchElementException.class);
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("foo"));
			}
		});

	}

	public void findBrokenElements() {
		List<WebElement>elements=driver.findElements(By.tagName("a"));
		for(WebElement links:elements) {
			String url=links.getAttribute("href");
			if(url!=null&&!url.isEmpty()) {
				verifyLink(url);
			}
		}
	}

	public void verifyLink(String link) {
		try {
			URL url = new URL(link);
			HttpURLConnection connection = (HttpURLConnection) url.getContent();
			connection.setConnectTimeout(60);
			if (connection.getResponseCode() == 200) {
				System.out.println(link+ " is valid link");
			} else {
				System.out.println(link+ " is not valid link");
			}
			connection.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
