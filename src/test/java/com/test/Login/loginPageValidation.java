package com.test.Login;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.amazon.Pages.homePage;
import com.base.Test.baseTest;
import com.pages.Login.loginPage;
public class loginPageValidation extends baseTest {
	loginPage loginPage;
	homePage homePage;
    @BeforeMethod
    public void setup() {
        loginPage = new loginPage(driver);
        homePage=new homePage(driver);
    }
	
	public void validateLogin() {		
		loginPage.EnterLoginDetails();
	}
	@Parameters({"product","search"})
	@Test
	public void validateProd(String product,String expected) throws InterruptedException {		
		homePage.validateProduct(product,expected);
	}
}
