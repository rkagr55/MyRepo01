package pkg1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;



public class NewTest {
	
	
	
  @Test
  public void f() {
	  
	  SimpleDateFormat dateFormat  = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss_SSS");
	 
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://www.google.com/");
	 //ExtentSparkReporter reporter = new ExtentSparkReporter("./target/extentreport_"+dateFormat.format(new Date())+".html");
	 ExtentSparkReporter reporter = new ExtentSparkReporter("./ExtentReports/extentreport_"+dateFormat.format(new Date())+".html");
	 ExtentReports report = new ExtentReports();
	 report.attachReporter(reporter);
	 report.setSystemInfo("OS", "OS_Windows 10");
	 report.setSystemInfo("Environment", "Env_QA");
	 report.setSystemInfo("Report Name", "Report_01");
	 reporter.config().setDocumentTitle("DocumentTitle_01");
	 reporter.config().setReportName("ReportName_01");
	 reporter.config().setTheme(Theme.DARK);
	 
	 ExtentTest test = report.createTest(this.getClass().getSimpleName());
	 test.pass("test.pass_Passed step");
	 test.fail("test.fail_Failed step");
	 test.info("test.info_info step");
	 test.skip("test.skip_skip step");
	 test.log(Status.WARNING,"test.log_warning status");
	 test.pass(MarkupHelper.createLabel("Expected result is same as actual result", ExtentColor.GREEN));
	 report.flush();
	 driver.quit();
  }
}
