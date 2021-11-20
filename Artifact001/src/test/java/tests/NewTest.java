package tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {
  @Test
  public void f() {
	  WebDriverManager.chromedriver().setup(); 	  WebDriver driver = new ChromeDriver();  driver.get("http://demo.guru99.com/test/web-table-element.php");
	  
	  List<WebElement>  cols = driver.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th")); System.out.println("No of cols are : " +cols.size());   
	  List<WebElement>  rows = driver.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/tbody/tr")); System.out.println("No of rows are : " +rows.size()); 

	  for(int i=1; i<=rows.size();i++)
		  for(int j=1; j<=cols.size(); j++)   System.out.println(driver.findElement(By.xpath(".//*[@id=\"leftcontainer\"]/table/tbody/tr["+i+"]/td["+j+"]")).getText());
 
	  for (WebElement col : cols)   System.out.println(col.getText());
	  
	  int colIndex=-1;
	  for(int i=0;i<cols.size();i++)   if(cols.get(i).getText().equalsIgnoreCase("Current Price (Rs)")) { colIndex=i;break;}
	  
	  for(int i=1; i<=rows.size(); i++) 	System.out.println(driver.findElement(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr["+i+"]/td["+(colIndex+1)+"]")).getText());
  }
}
