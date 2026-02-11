package com.base.Test;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
public abstract class baseTest {
	protected static WebDriver driver;	
	@BeforeClass
	public void openBrowser(ITestContext context) {
		String browser = context.getCurrentXmlTest().getParameter("Browser");
		String URL = context.getCurrentXmlTest().getParameter("URL");
		switch (browser) {
		case "Chrome":
			driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			break;
		case "Firefox":
			driver = new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(URL);

	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
