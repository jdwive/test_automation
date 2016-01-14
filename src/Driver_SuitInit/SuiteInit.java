package Driver_SuitInit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SuiteInit {
	private DriverInit driverInstance;
		  
	@BeforeSuite
	public void init() {
		driverInstance = DriverInit.getDriverInstance();
		
	}

	
	@AfterSuite
	public void closeAll() {
		
				try {
			driverInstance.getIEDriver().quit();
		} catch (Exception e) {
			System.err.println("Exception in quiting the IE driver: "
					+ e.getMessage());
		}
	
		
		try {
			driverInstance.getAndroidDriver().quit();
		} catch (Exception e) {
			System.err.println("Exception in quiting the Android Appium driver: "
					+ e.getMessage());
		}
		
		try {
			driverInstance.getIpadDriver().quit();
		} catch (Exception e) {
			System.err.println("Exception in quiting the Ipad Appium driver: "
					+ e.getMessage());
		}
		
	}
	

}
