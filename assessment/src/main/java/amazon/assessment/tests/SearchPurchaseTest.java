package amazon.assessment.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import amazon.assessment.core.Base;
import amazon.assessment.core.CommonHelper;
import amazon.assessment.pages.LoginPage;
import amazon.assessment.pages.SearchPurchasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SearchPurchaseTest 
{

	AndroidDriver<AndroidElement> driver;
	LoginPage lp;
	CommonHelper ch  = new CommonHelper();
	Base bs = new Base();
	SearchPurchasePage sp;
	
	
	@BeforeClass()
	public void startDriver() throws InterruptedException, IOException
	{
		this.driver = bs.initialization();
		this.lp = new LoginPage(driver);
	    Thread.sleep(5000);
	    
	    lp.clickOnAlreadyCustomerSignInButton();
	    ch.expwaitElmentTobeClickable(driver, 10, lp.txtbox_mobileNumber);
		lp.enterMobileNumer(ch.propertiesReading("mobileNo"));
		lp.clickContinueButtonAfterEnteringMobileOREmail();
		lp.enterPassword(ch.propertiesReading("password"));
		lp.clickLoginButton();
		Thread.sleep(5000);
		try {
		ch.clickonCancelbuttonAfterLogin(lp.btn_Canceltomessageafterlogin1);
		} catch(Exception e) {System.out.println();}
		ch.expwaitElmentTobeClickable(driver, 10, lp.btn_hamburger);
		Assert.assertTrue(lp.btn_hamburger.isDisplayed()==true);
		this.sp = new SearchPurchasePage(driver);
	}
	
// ######################### Tests for Search TV and purchase it //////////////////////////
	

	/* 
	 * this will click on Hamburger button then will swipe up to 
	 * see Settings button and change country
	 *
	 */
    @Test(priority=0)
	public void changeTheCountryNameAsAustralia() throws InterruptedException, IOException 
	{
		sp.clickOnHamburgerbutton();
		Thread.sleep(2000);
		ch.swipUpwithCoOrdinates(driver, 380, 1500, 380, 400);
		Thread.sleep(2000);
		ch.expwaitElmentTobeClickable(driver, 5, sp.btn_SettingsDrawerArrow);
		sp.clickOnSettingsDrawerButton();
		ch.expwaitElmentTobeClickable(driver, 5, sp.btn_countryandlanguage);
		sp.clickonCountryandLanguage();
		ch.expwaitElmentTobeClickable(driver, 5, sp.btn_countryRegion);
		sp.clickonCountryRegionbutton();
		ch.expwaitElmentTobeClickable(driver, 5, sp.rad_Aus);
		sp.clickonAustralia();
		ch.expwaitElmentTobeClickable(driver, 5, sp.btn_done);
		sp.clickonDonebutton();
		Thread.sleep(5000);
		ch.getScreenShot("CountrySetasAustralia", driver);
	
		Assert.assertTrue(sp.lbl_homeNamewithAu.isDisplayed()==true);
		
	}

	@SuppressWarnings("deprecation")
	@Test(priority=1)
	public void searchProductTV() throws InterruptedException, IOException
	{
		sp.enterValueinSearchtextfield(ch.propertiesReading("searchText"));
		driver.pressKeyCode(66);
		Thread.sleep(3000);
		for(int i =0; i<100;i++)
		{
		ch.swipUpwithCoOrdinates(driver, 700, 1533, 700, 400); // moto g4 plus screen
		if(ch.isElementAvailable(driver, sp.lbl_tvnameonsearchscreenn)==true)
		  {   sp.lbl_tvnameonsearchscreenn.click();
			break;
		  } else {
				System.out.println("not found");
				
			}
		 
		}
		Thread.sleep(5000);
		try {
		Assert.assertEquals(sp.lbl_tvNameonPurchasescreen.getText().toString(), ch.propertiesReading("expectedTVname"));
		} catch (Exception e) {
			
		}
		
	}
    
    @Test(priority=2)
    public void purchaseTV() throws InterruptedException, IOException
    {
      for(int i =0; i<100;i++)
		{
		ch.swipUpwithCoOrdinates(driver, 700, 1533, 700, 600); // moto g4 plus screen
		if(ch.isElementAvailable(driver, sp.btn_seeallbuyoptions)==true)
		  {   sp.btn_seeallbuyoptions.click();
			break;
		  } else {
				System.out.println("not found");
			     }
		  }
    	
    	ch.getScreenShot("SeeAllBuyOptions", driver);
    	Thread.sleep(2000);
    	try {
    	Assert.assertEquals(sp.lbl_price.getText().toString(), ch.propertiesReading("price"));
    	} catch(Exception e) {}
    	sp.btn_addtocart.click();
    	Thread.sleep(2000);
    	sp.btn_carticon.click();
    	Thread.sleep(2000);
    	sp.btn_proceedtocheckout.click();
    	Thread.sleep(5000);
    	sp.fillAddressDetails(ch.propertiesReading("fullName"), ch.propertiesReading("phone"), 
    			ch.propertiesReading("address1"), ch.propertiesReading("postal"), 
    			ch.propertiesReading("city"), ch.propertiesReading("state"));
    	ch.getScreenShot("FillAddressDetails", driver);
    	sp.clickOnContinue();
    	Thread.sleep(5000);
    	ch.getScreenShot("BuyTV", driver);
    	
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
