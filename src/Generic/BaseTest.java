package Generic;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant{
	public WebDriver driver;
	static{
	System.setProperty(GECKO_KEY, GECKO_PATH);
	System.setProperty(CHROME_KEY, CHROME_PATH);
	}
	@BeforeMethod
	public void openApp() throws InterruptedException{
	
	String url = Lib.getPropertyValue("URL");
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closeApp(ITestResult res){
	if(ITestResult.FAILURE==res.getStatus()){
		Lib.captureScreenShot(driver, res.getName());
	}
		//driver.close();
	}
	
	
}
