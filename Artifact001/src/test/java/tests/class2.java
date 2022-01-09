package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;

import main.BaseClass;
import pages.Page1;
import pages.Page2;
import utilities.ExcelUtils;

public class class2 extends BaseClass{
	Page1 objPage1;
	Page2 objPage2;
 	ExtentTest test;
 	ExcelUtils objExcel;
 	
  @Test
  public void A()  {
	  
	  objPage1 = new Page1(driver,test);
	  
	  String url = objPage1.launchBrowser();
	  Assert.assertTrue(url.equals("https://www.google.com/"));
	  
	  objPage2 = new Page2(driver,test);
	  String inputText = objPage2.searchText(objExcel.getCellData(0, 0));
	  Assert.assertEquals(inputText,objExcel.getCellData(0, 0)); 
  }
  
  @BeforeClass  
  public void beforeClass(){  
	  test = report.createTest(this.getClass().getSimpleName());
	  objExcel=new ExcelUtils();
	  objExcel.SetExcelFile("TestData.xlsx",this.getClass().getSimpleName());
  }
}

