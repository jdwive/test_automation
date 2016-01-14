package Listner;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import Driver_SuitInit.BrowserDriver;

public class TestListner extends TestListenerAdapter {
	
	public int resultCounter=1;
	public static Map<Integer, Object[]> testresultdata = new LinkedHashMap<Integer, Object[]>();

	public void  ResultCollatorExcel(String browser,String testCaseClass,String testCase,String status){

		testresultdata.put(resultCounter, new Object[] {browser,testCaseClass, testCase, status});

	}
	@Override
	public void onTestStart(ITestResult result) {
		String browser = result.getTestContext().getCurrentXmlTest()
				.getParameter("browser");
		EventFiringWebDriver driver = BrowserDriver.getDriver(browser);
		//driver.manage().deleteAllCookies();
		driver.navigate().refresh();

	}


	@Override
	public void onTestSkipped(ITestResult result) {
		String browser = result.getTestContext().getCurrentXmlTest()
				.getParameter("browser");
		String rs = getMethodContext(result);
		ResultCollatorExcel(browser,result.getTestClass().getName(),result.getName(),"SKIPPED");
		System.out.println(rs + " | SKIPPED");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String browser = result.getTestContext().getCurrentXmlTest()
				.getParameter("browser");
		String rs = getMethodContext(result);
		ResultCollatorExcel(browser,result.getTestClass().getName(),result.getName(),"PASSED");
		System.out.println(rs + " | PASSED");
	}

	public String getMethodContext(ITestResult result) {
		String browser = result.getTestContext().getCurrentXmlTest()
				.getParameter("browser");
		String testClasss = result.getTestClass().getName();
		String name = result.getName();
		String rs = browser + " | " + testClasss + " | " + name;
		if (resultCounter==1){
			ResultCollatorExcel("Browser","Test Class","Test Case","Status");
		}
		resultCounter=resultCounter+1;
		return rs;
	}
}
