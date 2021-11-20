package pages;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import main.BaseClass;
import utilities.captureSnaps;

public class Page1 extends BaseClass{

	private WebDriver driver;
	private ExtentTest test;
	@FindBy (xpath=".//*[@name='q']") public WebElement searchbar;	
	
	public Page1(WebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	public String launchBrowser() {
		driver.get("https://www.google.com");
		wait.until(ExpectedConditions.titleIs("Google"));
		File destinationPath = captureSnaps.captureScreenshot(driver);
		test.log(Status.PASS, "Google url has been launched", MediaEntityBuilder.createScreenCaptureFromPath(destinationPath.getAbsolutePath()).build());
		return driver.getCurrentUrl();
	}
}
