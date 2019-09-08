package amazon.assessment.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Base {
	
       public AndroidDriver<AndroidElement> initialization() throws InterruptedException, MalformedURLException {
		
	    DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "ZY2239J3T8");
		capabilities.setCapability("platformVersion", "7.0");
		capabilities.setCapability("appium-version", "1.13.0");
		capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		capabilities.setCapability("appActivity", "com.amazon.mShop.android.home.HomeActivity");
		capabilities.setCapability("autoDismissAlerts", true);
		capabilities.setCapability("autoGrantPermissions", true);
		

		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		return driver;
	}

}
