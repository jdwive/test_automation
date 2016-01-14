package HM_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Common.CommonFunctions;
import Driver_SuitInit.DriverInit;

public class Login extends CommonFunctions {
	@FindBy(xpath=".//*[@id='username']")
	private WebElement username;
	
	@FindBy(xpath=".//*[@id='password']")
	private WebElement password;
	
	@FindBy(xpath=".//*[@id='submit-button']")
	private WebElement signin;
	
	public Login(WebDriver driver) {
		super(driver);
		
	}

	public HomeFeed loginHM(WebDriver driver, String id, String pwd){
		enter(username, id );
		enter(password, pwd);
		Click(signin);
		return PageFactory.initElements(driver, HomeFeed.class);
	}

}
