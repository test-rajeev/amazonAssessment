package amazon.assessment.tests;

import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import amazon.assessment.core.Base;
import amazon.assessment.core.CommonHelper;
import amazon.assessment.pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginTest extends Base {

	AndroidDriver<AndroidElement> driver;
	LoginPage lp;
	CommonHelper ch  = new CommonHelper();
	Base bs = new Base();
	
	
	@BeforeClass()
	public void startDriver() throws MalformedURLException, InterruptedException
	{
		this.driver = bs.initialization();
		this.lp = new LoginPage(driver);
	    Thread.sleep(5000);
	}
	
// ######################### Methods/ functions on Login page to test
	

	/* Test Case to login into the application */
    @Test()
	public void loginIntoApplication() throws InterruptedException, IOException 
	{
		lp.clickOnAlreadyCustomerSignInButton();
		lp.enterMobileNumer(ch.propertiesReading("mobileNo"));
		lp.clickContinueButtonAfterEnteringMobileOREmail();
		Thread.sleep(3000);
		lp.enterPassword(ch.propertiesReading("password"));
		lp.clickLoginButton();
		Thread.sleep(2000);
		try {
		ch.clickonCancelbuttonAfterLogin(lp.btn_Canceltomessageafterlogin1);;
		} catch(Exception e) {System.out.println();}
		ch.expwaitElmentTobeClickable(driver, 10, lp.btn_hamburger);
		ch.getScreenShot("LoginSuccessful", driver);
		Assert.assertTrue(lp.btn_hamburger.isDisplayed()==true);
	}

	

	/********************************************************************
	 * To close the android driver
	 ******************************************/
	@AfterClass()
	public void tearDown() {
		driver.quit();
		System.out.println(
				"Android driver is closed now. To run another methods Please initiate the android driver in the class.");

	}
}