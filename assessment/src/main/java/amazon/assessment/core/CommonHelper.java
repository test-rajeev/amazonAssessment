package amazon.assessment.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CommonHelper
{
	// Expected wait 
	 public boolean expwaitElmentTobeClickable(AndroidDriver<AndroidElement> driver, int time, WebElement element)
	 {		
		 try{	
			WebDriverWait wait = new WebDriverWait(driver, time);		 
		 	wait.until(ExpectedConditions.elementToBeClickable(element));
		 	return true;
		   }catch(Exception e){
			   return false;
		   					   }
		
	 }
	
	// Scroll down (swipe) 
	@SuppressWarnings("rawtypes")
	public void swipUpwithCoOrdinates(AndroidDriver<AndroidElement> driver, int startx, int starty, int endx, int endy)
			throws InterruptedException {
			(new TouchAction(driver)).press(PointOption.point(startx, starty))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(endx, endy))
			.release().perform();

		}



	// ** take Screenshot and save at desired place and in desired format ** //

	   public void getScreenShot(String fileName, AndroidDriver<AndroidElement> driver) throws IOException {
       DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy h-m-s");

		Date date = new Date();

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/ScreenShots/" + fileName + "-" + dateFormat.format(date) + ".png"));

	}
	   
	  
	//  ** Common finder of same element **

	public boolean isElementAvailable(AndroidDriver<AndroidElement> driver, WebElement element) {
		boolean status = true;
		try {
			element.isDisplayed();
			return status;
			// Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			status = false;
			return status;
		}

	}
	
	 public void clickonCancelbuttonAfterLogin(WebElement ele)
	  {
		 ele.click();
	  }
	 

		public boolean isElementAvailable(AndroidDriver<AndroidElement> driver, String Xpath) {
		boolean status = true;
		try {
			driver.findElement(By.xpath(Xpath)).isDisplayed();
			// element.isDisplayed();
			return status;
			// Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			status = false;
			return status;
		}

	}

	   public String propertiesReading(String inputFieldName) {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(System.getProperty("user.dir") + "/Resources/TestData.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop.getProperty(inputFieldName);
	}

	

	public boolean isElementClickable(AndroidDriver<AndroidElement> driver, WebElement element) {
		boolean status = true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return status;
		} catch (Exception e) {
			status = false;
			return status;
		}

	}

	

	@SuppressWarnings("rawtypes")
	public void tapByCoordinates(AndroidDriver<AndroidElement> driver, int x, int y) throws InterruptedException {

		TouchAction abc = new TouchAction(driver);
		abc.press(PointOption.point(x, y)).release().perform(); // 371, 22
		Thread.sleep(2000);

	}

	
}
