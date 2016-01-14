package HM_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import Driver_SuitInit.DriverInit;
import HM_java.Login;

public class SearchTest {
	private WebDriver driver;
	@Test(description="Verify Error Message in Search")

	@Parameters(value = "deviceName")
	public void testNoResultMessage(){
		Login login=new Login(driver);
		login.loginHM(driver, "jdwive", "admin");
		if(driver.getTitle().equals("English")){
			homepagetitle=true;
			System.out.println(homepagetitle);
		}
		WebElement title= driver.findElement(By.xpath(".//h1[@class='text-center']"));
		if(title.getText().equals("HM-News")){
			hometitle=true;
			System.out.println(hometitle);
		}
		driver.findElement(By.xpath(".//span[@class='search-sm-icon pull-right']")).click();
		if(driver.getTitle().equals("Search")){
			searchpagetitle=true;
			System.out.println(searchpagetitle);
		}
		Assert.assertEquals(homepagetitle && hometitle && searchpagetitle, true," Test is Fail");
		driver.quit();
		}
	}
}
