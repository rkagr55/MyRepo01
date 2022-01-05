package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
	public WebDriver driver;
	private ExtentSparkReporter reporter;
	public static ExtentReports report;
	public static WebDriverWait wait;
	
  @BeforeSuite
  @Parameters("browser")
  public void beforeSuite(String browser){
	  System.out.println(browser);	 
	  if(browser.equalsIgnoreCase("chrome"))
			WebDriverManager.chromedriver().setup();

	  reporter = new ExtentSparkReporter("target/extentreport_"+new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss_SSS").format(new Date())+".html"); //ExtentReports/extentreport_...
	  reporter.config().setDocumentTitle("DocumentTitle_01");
	  reporter.config().setReportName("ReportName_01");
	  reporter.config().setTheme(Theme.DARK);
	  report = new ExtentReports();
	  report.attachReporter(reporter);
	  report.setSystemInfo("OS", "OS_Windows 10");
	  report.setSystemInfo("Environment", "Env_QA");
	     

    }
  
  @BeforeTest
  @Parameters("browser")
  public void beforeTest(String browser) {
 
      if(browser.equalsIgnoreCase("chrome")){
	        ChromeOptions options = new ChromeOptions();
	      	options.addArguments("--no-sandbox");
        	options.addArguments("--disable-dev-shm-usage");
        	options.addArguments("--headless");
    	  	driver = new ChromeDriver(options);
      }
      driver.manage().window().maximize(); 
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
      wait = new WebDriverWait(driver, 120); //2 mins

        
   }
  
  @AfterTest  public void afterTest(){ driver.close(); }
  
  @AfterSuite public void afterSuite(){ report.flush(); }
  

}
