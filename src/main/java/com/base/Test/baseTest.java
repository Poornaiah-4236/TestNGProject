package com.base.Test;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.common.Utils.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
public abstract class baseTest {
	private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	ExtentReports extent = ExtentManager.getInstance();
    public static ExtentTest testLog;
	public static WebDriver driver;	
	public static Logger log = LogManager.getLogger(baseTest.class);
	public int absTest=49;
	@BeforeClass
	public void openBrowser(ITestContext context) {
		testLog = extent.createTest("Login Test");
		//Log.pass("Iteam searched successfully");
		String browser = context.getCurrentXmlTest().getParameter("Browser");
		String URL = context.getCurrentXmlTest().getParameter("URL");
		switch (browser) {
		case "Chrome":
			driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			log.info("Chrome browse is Launched");
			break;
		case "Firefox":
			driver = new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
			log.info("Firefox browse is Launched");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(URL);
		log.info("URL Launched:-> "+URL);
		

	}
	@AfterClass
	public void tearDown() {
		extent.flush(); 
		driver.quit();
	}
}
