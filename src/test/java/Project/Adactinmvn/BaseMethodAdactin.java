package Project.Adactinmvn;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class BaseMethodAdactin {
	public static String sheetName;
	public static WebDriver driver;
	public static File file;
	public static Select select;

	public static WebDriver browser(String browserName) {
		if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} else if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} else {
			System.out.println("Invalid Browser");
		}
		return driver;

	}

	public static void chrome(String url) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dhara\\eclipse-workspace\\IbrahimClass\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver = new EdgeDriver();
	}

	public static Sheet getSheet(String sheetName) throws IOException {
		file = new File("C:\\Users\\dhara\\eclipse-workspace\\Adactinmvn\\data\\Adactin.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		return sheet;

	}

	public static String getdataUserName(int row, int cell1) throws IOException {
		Row row2 = getSheet(sheetName).getRow(row);
		String userName = row2.getCell(cell1).toString();
		return userName;

	}

	public static String getdataPassWord(int row, int cell2) throws IOException {
		Row row2 = getSheet(sheetName).getRow(row);
		String passWord = row2.getCell(cell2).toString();
		return passWord;
	}

	public static void userName(String userName) {
		WebElement user = driver.findElement(By.xpath("//input[@type='text']"));
		user.sendKeys(userName);
	}

	public static void passWord(String passWord) {
		WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
		pass.sendKeys(passWord);
	}

	public static void login() {
		WebElement log = driver.findElement(By.id("login"));
		log.click();

	}

	public static void submit() {
		WebElement sub = driver.findElement(By.id("Submit"));
		sub.click();
	}

	public static void verifyConinue() {
		WebElement confirm = driver.findElement(By.id("radiobutton_0"));
		confirm.click();
		WebElement cont = driver.findElement(By.id("continue"));
		cont.click();
	}

	public static void book() {
		WebElement book = driver.findElement(By.id("book_now"));
		book.click();
	}

	public static void order() {
		WebElement dis = driver.findElement(By.xpath("//input[@name='order_no']"));
		String distext = dis.getAttribute("value");
		System.out.println("Order Number  : " + distext);
		driver.close();
	}

	/*
	 * public static Sheet datafor( ) { file = new
	 * File("C:\\Users\\dhara\\eclipse-workspace\\Adactinmvn\\data\\Adactin.xlsx");
	 * FileInputStream inputStream = new FileInputStream(file); Workbook workbook =
	 * new XSSFWorkbook(inputStream); Sheet sheet = workbook.getSheet(sheetName);
	 * return sheet; }
	 */
	public static void closeBrowser() {
		driver.close();
	}

	public static void action(String xpath1, String xpath2) {
		WebElement course = driver.findElement(By.xpath(xpath1));
		Actions a = new Actions(driver);
		a.moveToElement(course).perform();
		WebElement option = driver.findElement(By.xpath(xpath2));
		option.click();

	}

	public static void dragAndDropMethod(String sourceXpath, String targetXpath) {
		WebElement sourceele = driver.findElement(By.xpath(sourceXpath));
		WebElement targetele = driver.findElement(By.xpath(targetXpath));
		Actions action = new Actions(driver);
		action.dragAndDrop(sourceele, targetele).perform();

	}

	public static void rightClick(String Xpath) {
		WebElement ele = driver.findElement(By.xpath(Xpath));
		Actions action = new Actions(driver);
		action.contextClick(ele).perform();
	}

	public static void doubleClickMethod(String Xpath) {
		WebElement ele = driver.findElement(By.xpath(Xpath));
		Actions action = new Actions(driver);
		action.doubleClick(ele).perform();
	}

	public static void alertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.getText();
		System.out.println(alert.getText());
	}

	public static void navigatebackMethod() {
		Navigation navigate = driver.navigate();
		navigate.back();
	}

	public static void navigatetoMethod(String url) {
		Navigation navigate = driver.navigate();
		navigate.to(url);

	}

	public static void allowsCookies(String id) {
		WebElement ele = driver.findElement(By.id(id));
		ele.click();
	}

	public static void frameMethod(String frameName) {
		driver.switchTo().frame(frameName);

	}

	public static void prevFrameMethod(int index) {
		driver.switchTo().frame(index);
	}

	public static void defaultFrame() {
		driver.switchTo().defaultContent();

	}

	public static void sendKeysXpath(String xpath, String sendKeys) {
		WebElement user = driver.findElement(By.xpath(xpath));
		user.sendKeys(sendKeys);
	}

	public static void sendKeysID(String ID, String sendKeys) {
		WebElement user = driver.findElement(By.id(ID));
		user.sendKeys(sendKeys);
	}

	public static void screenshot(String filelocation) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(filelocation);
		FileUtils.copyFile(screenshotAs, file);
	}

	public static void multipleSelectMethod(String id) {
		WebElement findElement = driver.findElement(By.id(id));
		select = new Select(findElement);
	}

	public static void printMultipleSelectMethod() {
		java.util.List<WebElement> options = select.getAllSelectedOptions();
		for (WebElement webElement : options) {
			System.out.println(webElement.getText());
		}
	}

}