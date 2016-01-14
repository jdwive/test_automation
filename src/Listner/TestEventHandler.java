/**
 * 
 */
package Listner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestEventHandler implements WebDriverEventListener {

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		waitUntilPageisReady(driver);
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		waitUntilPageisReady(driver);
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		waitUntilPageisReady(driver);
	}
	@Override
	public void afterNavigateBack(WebDriver driver) {
		waitUntilPageisReady(driver);
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		waitUntilPageisReady(driver);
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		waitUntilPageisReady(driver);
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		waitUntilPageisReady(driver);
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		waitUntilPageisReady(driver);
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		
		waitUntilPageisReady(driver);
	
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		
		waitUntilPageisReady(driver);
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		waitUntilPageisReady(driver);
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		waitUntilPageisReady(driver);
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		waitUntilPageisReady(driver);
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		waitUntilPageisReady(driver);
		
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		
	}
	
	
	public void waitUntilPageisReady(WebDriver driver) {
		try {
			boolean isPageReady = false;
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			while (!isPageReady) {
				isPageReady = js.executeScript("return document.readyState").toString().equals("complete");
				Thread.sleep(100);
				
			}
			} catch (Exception e) {
		}
			
	}	
	
	

}
