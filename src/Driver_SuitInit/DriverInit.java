package Driver_SuitInit;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import bsh.util.Util;

public class DriverInit {
	private RemoteWebDriver androidDriver;
	private RemoteWebDriver iPadDriver;
	private RemoteWebDriver iPhoneDriver;
	private RemoteWebDriver IEDriver;
	public static DriverInit driverInstance = null;
	public WebDriver driver;
	
	private DriverInit() {
		URL gridurl = null;
		URL androidurl =null;
		URL iosurl = null;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {
			String grid_hub = "http://localhost:4444/wd/hub";
			String	android_hub = "http://localhost:4723/wd/hub";
			String 	ios_hub = "http://localhost:4723/wd/hub";
			
			gridurl = new URL(grid_hub);
			androidurl = new URL(android_hub);
			iosurl = new URL(ios_hub);
		} catch (MalformedURLException e) {
			System.err.println(e.getMessage());
		}
		try {

			DesiredCapabilities c = DesiredCapabilities.internetExplorer();
			c.setCapability("nativeEvents", false);
			c.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);
			c.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			c.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
			c.setCapability("REQUIRE_WINDOW_FOCUS", false);
			c.setCapability("unexpectedAlertBehaviour", "accept");
			

			IEDriver = new RemoteWebDriver(gridurl, c);
		} catch (Exception e) {
			System.err.println("Exception in starting IE driver: "
					+ e.getMessage());
		}
		/*try {
			DesiredCapabilities dmaemu = DesiredCapabilities.android();
			
			dmaemu.setCapability("deviceName", "Android Emulator");
			dmaemu.setCapability("browserName","Browser");
			dmaemu.setCapability("platformVersion","5.1");
			dmaemu.setCapability("platformName", "Android");
			dmaemu.setCapability("orientation", "LANDSCAPE");
			dmaemu.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			dmaemu.setCapability("appPackage", "com.android.browser");
			dmaemu.setCapability("androidActivity", "com.android.browser.BrowserActivity");
			dmaemu.setCapability("unexpectedAlertBehaviour", "accept");
			dmaemu.setCapability("cssSelectorsEnabled",true);
			dmaemu.setCapability("deviceReadyTimeout", "350");
			dmaemu.setCapability("androidDeviceReadyTimeout", "350");
			dmaemu.setCapability("avdLaunchTimeout", "360000");
			dmaemu.setCapability("avdReadyTimeout", "360000");
			//dmaemu.setCapability("avd", "AndroidTablet1");
	
			androidDriver = new RemoteWebDriver(androidurl,dmaemu);
		} catch (Exception e) {
			System.err.println("Exception in starting android driver on Appium: "
					+ e.getMessage());
		}*/
		try {
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");  //provide browser name, we are using chrome       
			capabilities.setCapability("platformName", "Android"); 
			capabilities.setCapability("deviceName", "43004985b682c0e5"); //device name need to enter
			capabilities.setCapability("platformVersion", "5.1");  //OS Version   
		} catch (Exception e) {
			System.err.println("Exception in starting android driver on Appium: "
					+ e.getMessage());
		}
		try {
			DesiredCapabilities dmisim =DesiredCapabilities.ipad();
		
			dmisim.setCapability("deviceName","iPad Simulator");
			dmisim.setCapability("browserName","Safari");
			dmisim.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			dmisim.setCapability("platformVersion","7.1");
			dmisim.setCapability("platformName", "iOS");
			dmisim.setCapability("orientation", "LANDSCAPE");
			dmisim.setCapability("launchTimeout", "360000");
			dmisim.setCapability("unexpectedAlertBehaviour", "accept");
			dmisim.setCapability("cleanSession",true);
			dmisim.setCapability("cssSelectorsEnabled",true);
					
			iPadDriver = new RemoteWebDriver(iosurl,dmisim);
		} catch (Exception e) {
			System.err.println("Exception in starting iPad driver: "
					+ e.getMessage());
			e.printStackTrace();
		}
		try {
			DesiredCapabilities dmisim =DesiredCapabilities.iphone();
		
			dmisim.setCapability("deviceName","iPhone Simulator");
			dmisim.setCapability("browserName","Safari");
			dmisim.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			dmisim.setCapability("platformVersion","7.1");
			dmisim.setCapability("platformName", "iOS");
			dmisim.setCapability("orientation", "LANDSCAPE");
			dmisim.setCapability("launchTimeout", "360000");
			dmisim.setCapability("unexpectedAlertBehaviour", "accept");
			dmisim.setCapability("cleanSession",true);
			dmisim.setCapability("cssSelectorsEnabled",true);
					
			iPhoneDriver = new RemoteWebDriver(iosurl,dmisim);
		} catch (Exception e) {
			System.err.println("Exception in starting iPhone driver: "
					+ e.getMessage());
			e.printStackTrace();
		}


	}

	public static DriverInit getDriverInstance() {
		if (driverInstance == null) {
			driverInstance = new DriverInit();
		}
		return driverInstance;
	}

	public RemoteWebDriver getIEDriver() {
		return IEDriver;
	}

	public RemoteWebDriver getAndroidDriver() {
		return androidDriver;
	}
	
	public RemoteWebDriver getIpadDriver() {
		return iPadDriver;
	}
	public RemoteWebDriver iPhoneDriver() {
		return iPhoneDriver;
	}

}
