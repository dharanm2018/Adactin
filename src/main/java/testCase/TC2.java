package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
		WebElement user = driver.findElement(By.xpath("//input[@type='text']"));
		user.sendKeys("dharanm2018");
		WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
		pass.sendKeys("Testing@123");
		WebElement submit = driver.findElement(By.xpath("//input[@type='Submit']"));
		submit.click();
		
		//=================================Select==================================
		Select loc = new Select(driver.findElement(By.id("location")));
		loc.selectByVisibleText("Sydney");
		Select hot = new Select(driver.findElement(By.id("hotels")));
		hot.selectByVisibleText("Hotel Creek");
		Select room = new Select(driver.findElement(By.id("room_type")));
		room.selectByVisibleText("Standard");
		WebElement indate = driver.findElement(By.id("datepick_in"));
		indate.sendKeys("15/08/2023");
		WebElement outdate = driver.findElement(By.id("datepick_out"));
		outdate.sendKeys("16/08/2023");
		Select adult = new Select (driver.findElement(By.id("adult_room")));
		adult.selectByValue("2");
		Select child = new Select (driver.findElement(By.id("child_room")));
		child.selectByValue("2");
		WebElement sub = driver.findElement(By.id("Submit"));
		sub.click();
		//=================================radio==================================
		WebElement confirm = driver.findElement(By.id("radiobutton_0"));
		confirm.click();
		WebElement cont = driver.findElement(By.id("continue"));
		cont.click();
		WebElement fname = driver.findElement(By.id("first_name"));
		fname.sendKeys("Gangadharan");
		WebElement lname = driver.findElement(By.id("last_name"));
		lname.sendKeys("Mohan");
		WebElement addr = driver.findElement(By.id("address"));
		addr.sendKeys("Chennai, Tamilnadu");
		WebElement cc = driver.findElement(By.id("cc_num"));
		cc.sendKeys("1234567891234567");
		Select cctype = new Select(driver.findElement(By.id("cc_type")));
		cctype.selectByValue("VISA");
		Select exp = new Select(driver.findElement(By.id("cc_exp_month")));
		exp.selectByVisibleText("March");
		Select year = new Select(driver.findElement(By.id("cc_exp_year")));
		year.selectByVisibleText("2025");
		WebElement cvv = driver.findElement(By.id("cc_cvv"));
		cvv.sendKeys("234");
		WebElement book = driver.findElement(By.id("book_now"));
		book.click();
//		 Thread.sleep(5000);
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("\"//input[@name='order_no']\""), text));*/
		WebElement dis = driver.findElement(By.xpath("//input[@name='order_no']"));
		String distext = dis.getAttribute("value");
		System.out.println("Order Number  : "+distext);
		driver.close();
	}

}
