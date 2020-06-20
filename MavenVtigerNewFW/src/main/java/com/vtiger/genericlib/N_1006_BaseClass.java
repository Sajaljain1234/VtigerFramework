package com.vtiger.genericlib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import com.vtiger.objectRepository.N_0906_LoginPageElements;
import com.vtiger.objectRepository.N_1006_HomePageElements;

public class N_1006_BaseClass {
	public static WebDriver driver;
	public N_2205_DataUtility data=new N_2205_DataUtility();
	public N_1106_WebDriverCommonUtils wlib=new N_1106_WebDriverCommonUtils();
	
	@BeforeSuite
	public void configBS() {
		System.out.println("----DataBase Connect----");
	}
	@BeforeClass
	public void configBC() throws IOException {
		System.out.println("----Browser launching starts----");
		String browser=data.getDataFromProperty("browser");
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		driver =new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
		driver =new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(data.getDataFromProperty("url"));
		System.out.println("----Browser launching ends----");
	}
	@BeforeMethod
	public void configBM() throws IOException {
		System.out.println("----login starts----");
		N_0906_LoginPageElements login = PageFactory.initElements(driver, N_0906_LoginPageElements.class);
		login.loginToApp(data.getDataFromProperty("username"), data.getDataFromProperty("password"));
// we can use direct common business logic method created by us or through line by line approach
		/*
		login.getUsername().sendKeys(data.getDataFromProperty("username"));
		login.getPassword().sendKeys(data.getDataFromProperty("password"));
		login.getLoginBtn().click();
		*/
		System.out.println("----login ends----");
	}
	@AfterMethod
	public void configAM() {
		System.out.println("----logout starts----");
		N_1006_HomePageElements hp = PageFactory.initElements(driver,N_1006_HomePageElements.class);
		hp.logoutFromApp();
		System.out.println("----logout ends----");
	}
	@AfterClass
	public void configAC() {
		System.out.println("----close browser----");
		driver.quit();
	}
	@AfterSuite
	public void configAS() {
		System.out.println("----DataBase Disconnect----");
	}	
}
