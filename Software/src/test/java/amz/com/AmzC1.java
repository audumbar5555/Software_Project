package amz.com;





import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;


 

public class AmzC1 {
	
	       static ChromeDriver driver;
	       static ExtentTest test;
	       static ExtentReports report;
	       static Date date=new Date();
	       static SimpleDateFormat sd= new	 SimpleDateFormat("dd_MM_yyyy");
	
	
	
	   @BeforeTest
	   public void extentReports ()  {  
	       report=new ExtentReports("AmazonProject" + sd.format(date) + ".html", false);
		   test=report.startTest("AmazonProject");
		   System.out.println("ExtentReport");
		      }

	   @BeforeClass
	   public void browserLaunch () {
		
		    WebDriverManager.chromedriver().setup();
	        driver  = new ChromeDriver();
		    driver.manage().window().maximize();
		
		    driver.get("https://www.amazon.com/");
	}
	
	   @AfterClass
	   public void browserClose () {
		
		    driver.close();
     }
	
	   @BeforeMethod
	   public void login_test() throws InterruptedException, IOException {
			
			WebElement	signintab=driver.findElement(By.xpath("//span[@class='a-button-inner']//a"));
			signintab.click();
			WebElement	emailtab=driver.findElement(By.xpath("//input[@name='email']"));
			emailtab.sendKeys("audumbar.bhokare1@gmail.com");
			
			WebElement continu =driver.findElement(By.xpath("//input[@class='a-button-input']"));
			continu.click();
			
			WebElement pwd=driver.findElement(By.xpath("//input[@name='password']"));
			pwd.sendKeys("audu@100");
			
			
			WebElement signtab=driver.findElement(By.id("signInSubmit"));
			signtab.click();
			Thread.sleep(5000);
			
			test.log(LogStatus.PASS,"Amazon home page loaded successfully");
		    test.log(LogStatus.PASS,test.addScreenCapture(capture(driver))+ "Amazon home page loaded successfully");
			
	}
			
		@Test
		public void TC_1 () throws InterruptedException, IOException  {
			
		if (driver.findElement(By.id("searchDropdownBox")).getSize() != null) {
			
		try {	
			Select drp = new Select(driver.findElement(By.id("searchDropdownBox")));
			drp.selectByValue("search-alias=electronics-intl-ship");			
			driver.findElement(By.id("nav-search-submit-button")).click();
			Thread.sleep(4000);		
			JavascriptExecutor js=(JavascriptExecutor)driver;
	        WebElement seeallresults=driver.findElement(By.xpath("//span[@class='a-size-medium a-color-link a-text-bold']"));
			js.executeScript(";arguments[0].click();",seeallresults);	
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='RESULTS']")));
			test.log(LogStatus.PASS,"RESULTS page loaded successfully");
			test.log(LogStatus.PASS,test.addScreenCapture(capture(driver))+ "RESULTS page loaded successfully");
			
			}
		catch (Exception e) {
			 test.log(LogStatus.FAIL,"See all results element Failed to load ");
			 test.log(LogStatus.INFO, e.getMessage());
			 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "See all results element failed to load");
		  }
	     }
		else {
			 test.log(LogStatus.FAIL,"See all results element not available");
		}
	    }	
		@AfterMethod
		public void logpage() throws IOException {
				
			WebElement	acc=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
				
			Actions act = new Actions(driver);
		    act.moveToElement(acc).build().perform();
				
			WebElement logout = driver.findElement(By.xpath("//span[text()='Sign Out']"));
					
			act.moveToElement(logout).click().build().perform();
					
			test.log(LogStatus.PASS,"Logout successfully");
			test.log(LogStatus.PASS,test.addScreenCapture(capture(driver))+ "Logout successfully");
			}
			
		@AfterTest
		public void CloseTest() {
				
			report.flush();
		    driver.quit();
			}
		public static String capture(WebDriver driver) throws IOException 
			{
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File Dest = new File(".//target//ExtentReports//screenshots//" + System.currentTimeMillis()+ ".png");
			String errflpath = Dest.getAbsolutePath();
			FileUtils.copyFile(scrFile, Dest);
		    return errflpath;

		}
   
     }
	  


