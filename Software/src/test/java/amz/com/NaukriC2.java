package amz.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NaukriC2 {
	
	@Test
	public void login_test2() throws InterruptedException  {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.naukri.com/nlogin/login");
		
		
		
	    WebElement username=driver.findElement(By.xpath("//input[@id='usernameField']"));
	    username.sendKeys("audu.bhokare104@gmail.com");
		Thread.sleep(2000);
		
		WebElement pwd=driver.findElement(By.xpath("//input[@id='passwordField']"));
		pwd.sendKeys("audu@104");
		Thread.sleep(2000);
		
		WebElement button=driver.findElement(By.xpath("//button[text()='Login']"));
		button.click();
		Thread.sleep(2000);
		
		WebElement naukri=driver.findElement(By.xpath("//div[text()='My Naukri']"));
		WebElement edtprfl=driver.findElement(By.xpath("//a[@title='Edit Profile']']"));
		
		
		 Actions act = new Actions(driver);
		 
		act.moveToElement(naukri).moveToElement(edtprfl).click().perform();
		
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript(scrollBy(0,500));
//		
//		WebElement editemp=driver.findElement(By.xpath("(//span[@class='edit icon'][normalize-space()='Edit'])[3]"));
//		editemp.click();
		
		
		}

	}
