package Driver_SuitInit;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Listner.TestEventHandler;

public class BrowserDriver {
public static EventFiringWebDriver getDriver(String browser) {
		
		RemoteWebDriver Wdriver = null;
		EventFiringWebDriver driver =null;
		if (browser.equals("iexplore")) {
			Wdriver = DriverInit.getDriverInstance().getIEDriver();
			driver=eventRegister(Wdriver);
			driver.manage().window().maximize();
		} else if (browser.equals("safari")) {
			Wdriver = DriverInit.getDriverInstance().iPhoneDriver();
			driver=eventRegister(Wdriver);
			driver.manage().window().maximize();
		} else if (browser.equals("android")) {
			Wdriver = DriverInit.getDriverInstance().getAndroidDriver();
			driver=eventRegister(Wdriver);
		} else if (browser.equals("ipad")) {
			Wdriver = DriverInit.getDriverInstance().getIpadDriver();
			driver=eventRegister(Wdriver);
		} 
		
			
		return driver;
	}
	
	public static EventFiringWebDriver eventRegister(RemoteWebDriver Wdriver){
		EventFiringWebDriver driver= new EventFiringWebDriver(Wdriver);
		TestEventHandler handler = new TestEventHandler();
		driver.register(handler);
		return driver;
	}

}
