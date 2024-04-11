package nopCommerce;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class project {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
	@BeforeClass
	public void reportcong()
	{
		report= new ExtentReports(System.getProperty("user.dir")+"nopCommerce.html");
		
		test= report.startTest("nopcommerce");
	}
	
	
	@BeforeTest
	public void setup() throws InterruptedException
	{
		driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		//test.log(LogStatus.PASS, "site open successfuly");
		
		driver.manage().window().maximize();
		//test.log(LogStatus.PASS, "site maximize successfuly");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority = 1, alwaysRun = true)
	public void aegistration() throws InterruptedException
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("gender-male")).click();
		
		driver.findElement(By.id("FirstName")).sendKeys("Rushikesh");
		Thread.sleep(1000);
		driver.findElement(By.id("LastName")).sendKeys("Sonar");
		
		WebElement date = driver.findElement(By.name("DateOfBirthDay"));
		date.click();
		Select sel1= new Select(date);
		sel1.selectByValue("28");
		Thread.sleep(1000);
		
		WebElement month = driver.findElement(By.name("DateOfBirthMonth"));
		month.click();
		Select sel2= new Select(month);
		sel2.selectByIndex(1);
		Thread.sleep(1000);
		
		WebElement year = driver.findElement(By.name("DateOfBirthYear"));
		year.click();
		Select sel3= new Select(year);
		sel3.selectByValue("1999");
		Thread.sleep(1000);
		
		driver.findElement(By.id("Email")).sendKeys("rushikeshdsonar11@gmail.com");
		Thread.sleep(1000);
		
		driver.findElement(By.id("Company")).sendKeys("Masai");
		
		driver.findElement(By.id("Newsletter")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("Password")).sendKeys("Rushi123");
		
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Rushi123");
		Thread.sleep(1000);
		
		driver.findElement(By.id("register-button")).click();
		test.log(LogStatus.PASS, "registration is done successfuly");
	}
	
	
	
	@Test(priority = 2, alwaysRun = true)
	public void zbook() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//iver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//a[@href='/books'])[1]")).click();
		test.log(LogStatus.PASS, "book section open successfuly");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[1]")).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "book add to cart successfuly");
		
		driver.findElement(By.linkText("Shopping cart")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("termsofservice")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "checkout successfuly");
		
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']")).click();
		
	}
	
	@Test(priority = 3, alwaysRun = true)
	public void chekout() throws InterruptedException
	{
		driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Rushikesh");
		//Thread.sleep(3000);
		
		driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Sonar");
		//Thread.sleep(3000);
		
		driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("rushikeshdsonar11@gmail.com");
		//Thread.sleep(3000);
		
		driver.findElement(By.id("BillingNewAddress_Company")).sendKeys("Masai");
		//Thread.sleep(3000);
		
		WebElement dropdown = driver.findElement(By.id("BillingNewAddress_CountryId"));
		dropdown.click();
		Select sel= new Select(dropdown);
		sel.selectByVisibleText("India");
		//Thread.sleep(3000);
		
		driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Amravati");
		//Thread.sleep(3000);
		
		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Karajgaon");
		//Thread.sleep(3000);
		
		driver.findElement(By.id("BillingNewAddress_Address2")).sendKeys("Near Bansod decoration");
		//Thread.sleep(3000);
		
		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("444809");
		//Thread.sleep(3000);
		
		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("9970601276");
		//Thread.sleep(3000);
		
		driver.findElement(By.id("BillingNewAddress_FaxNumber")).sendKeys("9970601276");
		//Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//button[@class='button-1 new-address-next-step-button'])[1]")).click();
		test.log(LogStatus.PASS, "shipping address added successfuly");
		
		
		WebElement alert = driver.findElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
		
		alert.click();
		//driver.switchTo().alert().dismiss();
		
		driver.findElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']")).click();
		test.log(LogStatus.PASS, "payment method choose  successfuly");
		
		driver.findElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']")).click();
		test.log(LogStatus.PASS, "payment info filled  successfuly");
		
		driver.findElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']")).click();
		test.log(LogStatus.PASS, "order placed successfuly");
		}
	
	
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	@AfterClass
	public void reportflush()
	{
		report.endTest(test);
		report.flush();
	}

}
