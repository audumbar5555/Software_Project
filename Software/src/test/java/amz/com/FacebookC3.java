package amz.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookC3 {
	
	static ChromeDriver driver;
	static WebElement ele;
	
	@BeforeClass
	public void Browser_Launch() {
		
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		
		 driver.get("https://www.facebook.com/");
	}

	
	@Test
	public void Signup() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		Thread.sleep(3000);
		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstname.sendKeys("Rahul");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Bhokare");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).sendKeys("audumbarbhokare1@gmail.com");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@aria-label='Re-enter email address']")).sendKeys("audumbarbhokare1@gmail.com");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("9763532278");
		Thread.sleep(3000);
		
		Select datedrp = new Select(driver.findElement(By.xpath("//select[@id='day']")));
		datedrp.selectByValue("10");
		Thread.sleep(3000);
		Select monthdrp = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		monthdrp.selectByVisibleText("Apr");
		Thread.sleep(3000);
		Select yeardrp = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		yeardrp.selectByValue("1991");
		Thread.sleep(5000);
		
		WebElement checkbox= driver.findElement(By.xpath("//label[text()='Male']"));
	    boolean result= checkbox.isSelected();
	 if (result) {
		  
		System.out.println("It is selected by default");
	   }
	 else {
		  
		checkbox.click();
	  }
	 
	    Thread.sleep(5000);
		
				
	   driver.findElement(By.xpath("(//button[text()='Sign Up'])[1]")).click();
	   
	   driver.findElement(By.xpath("//input[@autofocus='1']")).sendKeys("26636");  // OTP and Captcha not handled by selenium
	//   driver.findElement(By.xpath("//button[text()='Continue']")).click();
	}
	
	//@AfterClass
	//public void Browser_Close () {      
		
		//driver.close();
	}



