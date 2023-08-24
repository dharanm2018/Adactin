package Project.Adactinmvn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc3 {

	public static void main(String[] args) throws IOException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://adactinhotelapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		File file = new File("C:\\Users\\dhara\\eclipse-workspace\\Adactinmvn\\data\\Adactin.xlsx");
		FileInputStream input = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(input);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("credential");
		int rowcount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowcount);
		Row row = sheet.getRow(0);
		Cell cell1 = row.getCell(0);
		Cell cell2 = row.getCell(1);
		String string1 = cell1.toString();
		String string2 = cell2.toString();
		WebElement user = driver.findElement(By.xpath("//input[@type='text']"));
		user.sendKeys(string1);
		WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
		pass.sendKeys(string2);
		WebElement submit = driver.findElement(By.xpath("//input[@type='Submit']"));
		submit.click();
		Select loc = new Select(driver.findElement(By.id("location")));
		loc.selectByVisibleText("Sydney");
		/*for (int i = 0; i < rowcount; i++) {
			Row row = sheet.getRow(i);
			int cellCount = row.getPhysicalNumberOfCells();
			for (int j = 0; j < cellCount; j++) {
				Cell cell = row.getCell(j);
				System.out.println(cell);
											}
			
		}*/ 
		Select loc1 = new Select(driver.findElement(By.id("location")));
		loc1.selectByVisibleText("Sydney");
		Select hot = new Select(driver.findElement(By.id("hotels")));
		hot.selectByVisibleText("Hotel Creek");
		Select room = new Select(driver.findElement(By.id("room_type")));
		room.selectByVisibleText("Standard");
		WebElement indate = driver.findElement(By.id("datepick_in"));
		Cell cell3 = row.getCell(2);
		String string3 = cell3.toString();
		indate.sendKeys(string3);
		WebElement outdate = driver.findElement(By.id("datepick_out"));
		Cell cell4 = row.getCell(3);
		String string4 = cell4.toString();
		outdate.sendKeys(string4);
		Select adult = new Select (driver.findElement(By.id("adult_room")));
		adult.selectByValue("2");
		Select child = new Select (driver.findElement(By.id("child_room")));
		child.selectByValue("2");
		WebElement sub = driver.findElement(By.id("Submit"));
		sub.click();
		
		
		WebElement confirm = driver.findElement(By.id("radiobutton_0"));
		confirm.click();
		WebElement cont = driver.findElement(By.id("continue"));
		cont.click();
		WebElement fname = driver.findElement(By.id("first_name"));
		org.apache.poi.ss.usermodel.Sheet sheet2 = workbook.getSheet("Client");
		Row row2 = sheet2.getRow(0);
		String fn = row2.getCell(0).toString();
		fname.sendKeys(fn);
		WebElement lname = driver.findElement(By.id("last_name"));
		lname.sendKeys(row2.getCell(1).toString());
		WebElement addr = driver.findElement(By.id("address"));
		addr.sendKeys(row2.getCell(2).toString());
		WebElement cc = driver.findElement(By.id("cc_num"));
		cc.sendKeys(row2.getCell(3).toString());
		Select cctype = new Select(driver.findElement(By.id("cc_type")));
		cctype.selectByValue("VISA");
		Select exp = new Select(driver.findElement(By.id("cc_exp_month")));
		exp.selectByVisibleText("March");
		Select year = new Select(driver.findElement(By.id("cc_exp_year")));
		year.selectByVisibleText("2025");
		WebElement cvv = driver.findElement(By.id("cc_cvv"));
		cvv.sendKeys(row2.getCell(7).toString());
		WebElement book = driver.findElement(By.id("book_now"));
		book.click();
//		WebDriverWait ex = new WebDriverWait(driver, Duration.ofSeconds(20));
//		ex.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='order_no']"))));
		WebElement dis = driver.findElement(By.xpath("//input[@name='order_no']"));
		String distext = dis.getAttribute("value");
		System.out.println("Order Number  : "+distext);
		driver.close();
		
		

	}

}
