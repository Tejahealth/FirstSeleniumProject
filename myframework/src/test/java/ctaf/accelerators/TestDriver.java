package ctaf.accelerators;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ctaf.support.ActionEngineSupport;
//import ctaf.support.HtmlReportSupport;
//import ctaf.utilities.Reporter;

import ctaf.support.ConfiguratorSupport;

public class TestDriver {
	public static String suiteStartTimestamp =""; 
	public static String suitEndTimestamp ="";
	
	public static String testStartTimestamp =""; 
	public static String testEndTimestamp ="";
	
	public static WebDriver webDriver = null;
	public static EventFiringWebDriver driver;
	public static String browsers = "";
	public String browser = "";
	public static ITestContext itc;
	public static ConfiguratorSupport configProps = new ConfiguratorSupport("config.properties");

  @BeforeSuite
  public void beforeSuite(ITestContext ctx) {
	  itc =  ctx;
	  System.out.println(itc.getName());
	  System.out.println("Reporting Summary should be done here");	
  }
  
 @Parameters({ "browserType" }) // String browserParam
  @BeforeTest
  public void beforeTest() {
	  browser = configProps.getProperty("browserType");
	  if (browser.toString().equalsIgnoreCase("firefox")) {
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile ffprofile = profile.getProfile("boa");			
			webDriver = new FirefoxDriver(ffprofile);			
	  	} else if (browser.toString().equalsIgnoreCase("ie")) {
			File file = new File("Drivers\\IEDriverServer.exe");
			System.out.println(file.getAbsolutePath());
			System.setProperty("webdriver.ie.driver",
					file.getAbsolutePath());
			webDriver = new InternetExplorerDriver();
	  	} else if (browser.toString().equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"Drivers\\chromedriver.exe");
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile ffprofile = profile.getProfile("boa");
			webDriver = new ChromeDriver();
	  	} 
		driver = new EventFiringWebDriver(webDriver);
		ActionEngineSupport myListener = new ActionEngineSupport();
		driver.register(myListener);
		try {
			driver.get(configProps.getProperty("URL"));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			System.out.println("Browser: "+ browser+" is launched and navigated to: "+ configProps.getProperty("URL"));
			driver.manage().window().maximize();	
			
			//driver.findElement(By.name("q")).sendKeys("Laptops");
			//driver.findElement(By.name("q")).submit();
			
		} catch (Exception oExp) {
			System.out.println(oExp);
		}	  
  }
//
//  @BeforeMethod
//  public void beforeMethod() {0
//  }
//
//  @AfterMethod
//  public void afterMethod() {
//  }
  
  @AfterTest
  public void afterTest() {
//	  driver.close();
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Close the Suite Repoort");
  }
//  @Test
//  public void test(){
//	System.out.println("test");
//  }
  
  
}
