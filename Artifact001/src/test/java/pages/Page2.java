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

public class Page2 extends BaseClass{

	WebDriver driver;
	ExtentTest test;
	@FindBy (xpath=".//*[@name='q']") public WebElement searchbar;	
	
	public Page2(WebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	public String searchText(String input) {
		wait.until(ExpectedConditions.visibilityOf(searchbar));
		searchbar.sendKeys(input);
		File destinationPath = captureSnaps.captureScreenshot(driver);
		String inputText = searchbar.getAttribute("value");
		test.log(Status.PASS, "input text has been entered into search bar", MediaEntityBuilder.createScreenCaptureFromPath(destinationPath.getAbsolutePath()).build());
		return inputText;
	}
}
