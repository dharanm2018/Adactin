package otherSeleniumActionNotInAdactin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.collections4.functors.SwitchTransformer;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Project.Adactinmvn.BaseMethodAdactin;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumAction extends BaseMethodAdactin {

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		browser("edge");
		// driver.get("https://www.qafox.com/");
		/*
		 * driver.get("https://www.qafox.com/"); driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); WebElement
		 * course =driver.findElement(By.xpath("//li[@id='menu-item-1073']")); Actions a
		 * = new Actions(driver); a.moveToElement(course).perform(); WebElement option =
		 * driver.findElement(By.xpath("(//a[text()='Selenium Video Course'])[2]"));
		 * option.click();
		 */
		// ===========================================
		// action("//li[@id='menu-item-1073']", "(//a[text()='Selenium Video
		// Course'])[2]");
		// closeBrowser();
		// =========================================
		// driver.get("https://demo.guru99.com/test/drag_drop.html");
		// dragAndDropMethod("(//a[@class='button button-orange'])[5]",
		// "(//li[@class='placeholder'])[1]");
		// ========================================
		// driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		// rightClick("//span[contains(text(),'right')]");
		// doubleClickMethod("//button[@ondblclick='myFunction()']");
		// ========================================
		// driver.get("http://adactinhotelapp.com/");
		// Robot robot = new Robot();
		// robot.keyPress(KeyEvent.VK_A);
		// robot.keyRelease(KeyEvent.VK_A);
		// =======================================
		// driver.get("https://demo.guru99.com/test/delete_customer.php");
		// WebElement ele = driver.findElement(By.xpath("//input[@type='text']"));
		// ele.sendKeys("9884",Keys.ENTER);
		// alertAccept();
		// ===============================================
		// driver.get("https://letcode.in/alert");
		// WebElement ele = driver.findElement(By.id("prompt"));
		// ele.click();
		// Alert alert=driver.switchTo().alert();
		// alert.sendKeys("thanks");
		// alert.accept();
		// ===============================================
		// chrome("https://www.voucherify.io/generator");
		// // driver.get("https://www.voucherify.io/generator");
		// WebElement ele = driver.findElement(By.id("amount"));
		// ele.sendKeys("3");
		// WebElement ele2 = driver.findElement(By.id("length"));
		// ele2.sendKeys("3");
		// WebElement ele3 = driver.findElement(By.id("generate"));
		// ele3.click();
		// WebElement findElement1 =
		// driver.findElement(By.xpath("//div[@id='codes-list-displayed']//div[1]"));
		// String text1 = findElement1.getText();
		// navigatetoMethod("http://adactinhotelapp.com/");
		// userName(text1);
		// navigatebackMethod();
		/*
		 * allowsCookies("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
		 * WebElement findElement2=
		 * driver.findElement(By.xpath("//div[@id='codes-list-displayed']//div[2]"));
		 * String text2 = findElement2.getText();
		 * navigatetoMethod("http://adactinhotelapp.com/"); userName(text2);
		 * navigatebackMethod();
		 */
		// ===============================================
		// driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		// List<WebElement> frame= driver.findElements(By.tagName("iframe"));
		// System.out.println(frame.size());
		//// driver.switchTo().frame(0);
		// frameMethod("frame1");
		// sendKeysXpath("//input[@type='text']", "Pragathi");
		// prevFrameMethod(0);
		// driver.findElement(By.id("a")).click();
		// defaultFrame();
		// frameMethod("frame2");
		// driver.findElement(By.id("animals"));
		// Select select = new Select(driver.findElement(By.id("animals")));
		// select.selectByIndex(1);
		// ===============================================
		// driver.get("http://adactinhotelapp.com/");
		// screenshot("C:\\Users\\dhara\\eclipse-workspace\\Adactinmvn\\screenshot\\loginpage.png");
		// ===============================================
		driver.get("https://output.jsbin.com/osebed/2");
		multipleSelectMethod("fruits");
//		WebElement findElement = driver.findElement(By.id("fruits"));
//		Select select = new Select(findElement);
		select.selectByIndex(0);
		select.selectByIndex(1);
		printMultipleSelectMethod();
		// ===============================================					
		}
	
	}


