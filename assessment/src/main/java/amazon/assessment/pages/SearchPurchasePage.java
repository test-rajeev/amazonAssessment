package amazon.assessment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPurchasePage 
{
	AndroidDriver<AndroidElement> driver;
	
	   public SearchPurchasePage(AndroidDriver<AndroidElement> sdriver) 
	    {
	    	this.driver=sdriver;
	    	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }
	   
	
	/*@FindBy(id= "icp-btn-close-announce")
	public  WebElement btn_Canceltomessageafterlogin;*/
	
	@FindBy(id= "com.amazon.mShop.android.shopping:id/action_bar_burger_icon")
	public  WebElement btn_hamburgeronHomepage;
	
	@FindBy(xpath= "//android.widget.ImageView[@instance='5']")
	public  WebElement btn_SettingsDrawerArrow;

	@FindBy(xpath= "//android.widget.TextView[@text='Country & Language']")
	public  WebElement btn_countryandlanguage;
	
	@FindBy(xpath= "//android.widget.Button[@text='Country/Region: India']")
	public  WebElement btn_countryRegion;
	
	@FindBy(id= "pref-option-group-primary-opt-0")
	public  WebElement rad_Aus;
	
	@FindBy(xpath= "//android.widget.Button[@text='Done']")
	public  WebElement btn_done;
	
	@FindBy(xpath= "//android.widget.ImageView[@content-desc=\"Home\"]")
	public  WebElement lbl_homeNamewithAu;
	
	@FindBy(id= "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	public  WebElement txt_searchtextbox;
	
	@FindBy(xpath= "//android.view.View[@text='Sony 65\" X70F LED 4K Ultra HDR Smart TV']") // text = Sony 65" X70F LED 4K Ultra HDR Smart TV
	public  WebElement lbl_tvnameonsearchscreenn;
	
	@FindBy(id= "title")
	public  WebElement lbl_tvNameonPurchasescreen;
	
	@FindBy(xpath= "//android.view.View[@text='Sony 65\" X70F LED 4K Ultra HDR Smart TV 4.0 out of 5 stars53 $1,449.00(1 new offer)']") // text = Sony 65" X70F LED 4K Ultra HDR Smart TV 4.0 out of 5 stars53 $1,449.00(1 new offer)
	public  WebElement lbl_fulldescriptionwithprice;
		
	@FindBy(xpath= "//android.widget.Button[@text='See All Buying Options']")
	public  WebElement btn_seeallbuyoptions;
	
	@FindBy(xpath= "//android.view.View[@text='$1,449.00']")
	public  WebElement lbl_price;
	
	@FindBy(xpath= "//android.widget.Button[@text='Add to Cart from seller Amazon AU and price $1,449.00']")
	public  WebElement btn_addtocart;
	
	@FindBy(id= "com.amazon.mShop.android.shopping:id/action_bar_cart_image")
	public  WebElement btn_carticon;
	
	@FindBy(id= "a-autoid-0-announce")
	public  WebElement btn_proceedtocheckout;
	
	@FindBy(id= "enterAddressFullName")
	public  WebElement txt_fullname;
	
	@FindBy(id= "enterAddressPhoneNumber")
	public  WebElement txt_phonenumber;
	
	@FindBy(id= "enterAddressAddressLine1")
	public  WebElement txt_add1;
	
	@FindBy(id= "enterAddressPostalCode")
	public  WebElement txt_postal;
	
	@FindBy(id= "enterAddressCityText")
	public  WebElement txt_city;
	
	@FindBy(id= "enterAddressStateOrRegionText")
	public  WebElement txt_state;
	
	@FindBy(xpath= "//android.widget.Button[@text='1']")
	public  WebElement btn_continuetonext;
	
	
	
//######################### modular action for the hamburger page #########################/////////   
	
/*  public void clickonCancelbuttonAfterLogin()
  {
	  btn_Canceltomessageafterlogin.click();
  }*/
  public void clickOnHamburgerbutton()
  {
	 btn_hamburgeronHomepage.click();
  }
  
  public void clickOnSettingsDrawerButton()
  {
	  btn_SettingsDrawerArrow.click();
  }

  public void clickonCountryandLanguage()
  {
	  btn_countryandlanguage.click();
  }
  
  public void clickonCountryRegionbutton()
  {
	  btn_countryRegion.click();
  }
  
  public void clickonAustralia()
  {
	  rad_Aus.click();
  }
  
  public void clickonDonebutton()
  {
	  btn_done.click();
  }
  
  public void getHomeName()
  {
	  lbl_homeNamewithAu.getText();
  }
  
  public void enterValueinSearchtextfield(String text)
  {
	  txt_searchtextbox.sendKeys(text);
  }
  
  public void selectedTV()
  {
	  lbl_tvnameonsearchscreenn.click();
  }
  
  public void fillAddressDetails(String fname, String phone, String add, String postal, String city, String state)
  {
	  txt_fullname.sendKeys(fname);
	  txt_phonenumber.sendKeys(phone);
	  txt_add1.sendKeys(add);
	  txt_postal.sendKeys(postal);
	  txt_city.sendKeys(city);
	  txt_state.sendKeys(state);
	  
  }
  
  public void clickOnContinue()
  {
	  btn_continuetonext.click();
  }
}
