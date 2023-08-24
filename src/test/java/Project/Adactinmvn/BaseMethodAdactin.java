package Project.Adactinmvn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseMethodAdactin {
	public static String sheetName;
	public static WebDriver driver;
	public static File file;

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

	public static void login(String userName, String passWord) {
		WebElement user = driver.findElement(By.xpath("//input[@type='text']"));
		user.sendKeys(userName);
		WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
		pass.sendKeys(passWord);
		WebElement submit = driver.findElement(By.xpath("//input[@type='Submit']"));
		submit.click();

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
}
