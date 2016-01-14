package Common;


import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
public class CommonFunctions {
	private WebDriver driver;
	@FindBy(xpath=".//span[@class='search-sm-icon pull-right']")
	private WebElement title;

	@FindBy(xpath=".//span[@class='search-sm-icon pull-right']")
	private WebElement searchIcon;


	public CommonFunctions(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(this.driver, this);

	}
	public void waitUntilPageisReady(WebDriver driver) {
		try {
			boolean isPageReady = false;
			JavascriptExecutor js = (JavascriptExecutor)driver;

			while (!isPageReady) {
				isPageReady = js.executeScript("return document.readyState").toString().equals("complete");
				System.out.println("Page is loading");
				Thread.sleep(300);
			}

		} catch (Exception e) {
			System.out.println("Error in waiting");
		}
	}

	public void ScrollElementIntoView(WebElement elem){
		try {
			waitUntilPageisReady(driver);
			Thread.sleep(200);
			//scroll to view
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",elem);
			waitUntilPageisReady(driver);
			Thread.sleep(200);

		} catch (Exception e) {
			System.out.println("Error Scrolling element into view -> " + elem.toString());
		}
	}
	public void Click(WebElement elem){
		try {
			waitUntilPageisReady(driver);
			ScrollElementIntoView(elem);
			elem.click();
			waitUntilPageisReady(driver);

			Thread.sleep(200);
		} catch (InterruptedException e) {
			System.out.println("Error Click on -> " + elem.toString());

		}
	}
	public void enter(WebElement elem, String value){
		try {
			waitUntilPageisReady(driver);
			ScrollElementIntoView(elem);
			elem.clear();
			Thread.sleep(100);
			elem.sendKeys(value);
			waitUntilPageisReady(driver);

			Thread.sleep(200);
		} catch (InterruptedException e) {
			System.out.println("Error entering data in -> " + elem.toString());

		}
	}
	public void select(WebElement elem, String value){
		try {
			waitUntilPageisReady(driver);
			ScrollElementIntoView(elem);
			new Select(elem).selectByVisibleText(value);
			Thread.sleep(200);
			waitUntilPageisReady(driver);

		} catch (InterruptedException e) {
			System.out.println("Error Selecting data in ->  " + elem.toString());

		}
	}
	public void JavaScriptClick(WebElement elem){
		try {
			waitUntilPageisReady(driver);
			ScrollElementIntoView(elem);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",elem);
			Thread.sleep(200);
			waitUntilPageisReady(driver);

		} catch (InterruptedException e) {
			System.out.println("Error click in ->  " + elem.toString());

		}
	}
	public void Wait(int time){
		try{
			Thread.sleep(time);
			System.out.println("Waited : " + time);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public boolean verifyText(WebElement elem, String value){
		boolean result=false;
		try{
			waitUntilPageisReady(driver);
			ScrollElementIntoView(elem);
			Thread.sleep(200);
			if(elem.getText().equalsIgnoreCase(value)){
				result=true;
			}
		}
		catch (Exception e){
			System.out.println("Error in verifyText ->" + elem.toString());
		}
		return result;
	}
	public void Doubleclick(WebElement elem){
		try{
			waitUntilPageisReady(driver);
			ScrollElementIntoView(elem);
			Thread.sleep(200);
			Actions act=new Actions(driver);
			act.doubleClick(elem);
			Thread.sleep(200);
			waitUntilPageisReady(driver);
		}
		catch (Exception e){
			System.out.println("Error in Doubleclick ->" + elem.toString());
		}
	}
	public boolean GetTitle(WebDriver driver, String title){
		boolean result=false;
		try{
			waitUntilPageisReady(driver);
			Thread.sleep(200);
			if(driver.getTitle().equalsIgnoreCase(title)){
				result=true;
			}
		}
		catch (Exception e){
			System.out.println("Error in gettitle ->" +title);
		}
		return result;

	}
	public boolean NavigationSearch(WebElement elem, String title){
		Click(searchIcon);
		boolean result=GetTitle(driver, title);
		return result;
	}
	
}
