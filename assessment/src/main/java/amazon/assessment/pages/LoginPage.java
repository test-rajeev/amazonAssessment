package amazon.assessment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage
{
	AndroidDriver<AndroidElement> driver;
	
	   public LoginPage(AndroidDriver<AndroidElement> ldriver) 
	    {
	    	this.driver=ldriver;
	    	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }
	   
	
	@FindBy(id = "com.amazon.mShop.android.shopping:id/sign_in_button")
    public WebElement btn_alreadyCustomerSignIn;
	
	@FindBy(id= "ap_email_login")
    public  WebElement txtbox_mobileNumber;
   
    @FindBy(id = "continue")
    public WebElement btn_Continue;
    
	@FindBy(id= "ap_password")
    public  WebElement txtbox_password;
	
	@FindBy(id= "signInSubmit")
    public  WebElement btn_login;
	
	@FindBy(xpath= "//android.widget.TextView[@text='close']")
    public  WebElement btn_closethepopup;
	
	@FindBy(id= "com.amazon.mShop.android.shopping:id/action_bar_burger_icon")
    public  WebElement btn_hamburger;
	
	@FindBy(id= "icp-btn-close-announce")
	public  WebElement btn_Canceltomessageafterlogin1;
	
	
	
//######################### modular action for the login page #########################/////////   
	
/* ** Click On button containing text already customer? sign in */
    public void clickOnAlreadyCustomerSignInButton()
    {
    	btn_alreadyCustomerSignIn.click();
  	 
    }
    
/* Enter mobile number into text box*/
    public void enterMobileNumer(String mobilenum)
    {
    	txtbox_mobileNumber.clear();
    	txtbox_mobileNumber.sendKeys(mobilenum);
  	 
    }
    
    public void clickContinueButtonAfterEnteringMobileOREmail()
    {
    	btn_Continue.click();
		
  	}
    
    public void enterPassword(String password)
	{
    	try {
    	txtbox_password.clear();
    	txtbox_password.sendKeys(password);
    	} catch(Exception e) {}
    }
    
    public void clickLoginButton() throws InterruptedException
    {
    	btn_login.click();
    	Thread.sleep(4000);
    	try {
      	  if(btn_closethepopup.isDisplayed()==true)
      	  {
      		btn_closethepopup.click();
      		Thread.sleep(2000);
      	  }
      	  
      	} catch(Exception e) {}
    }
 
		
}