package Project.Adactinmvn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.commons.collections4.functors.CatchAndRethrowClosure;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Tc4 extends BaseMethodAdactin {

	public static void main(String[] args) throws IOException {
		browser("edge").get("http://adactinhotelapp.com/");

		Row row = getSheet("credential").getRow(0);
		String cell1 = row.getCell(0).toString();
		String cell2 = row.getCell(1).toString();
		login(cell1, cell2);

		Select loc = new Select(driver.findElement(By.id("location")));
		loc.selectByVisibleText("Sydney");
		List<WebElement> options = loc.getOptions();

		File f = new File("C:\\Users\\dhara\\eclipse-workspace\\Adactinmvn\\data\\Adactin2.xlsx");
		FileInputStream inputStream = new FileInputStream(f);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet("Sheet1");

		for (WebElement w : options) {
			int r = sheet.getPhysicalNumberOfRows();
			Cell createCell = sheet.createRow(r).createCell(0);
			createCell.setCellValue(w.getText());
		}

		try {
			FileOutputStream o = new FileOutputStream(f);
			workbook.write(o);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Select hot = new Select(driver.findElement(By.id("hotels")));
		hot.selectByVisibleText("Hotel Creek");
		Select room = new Select(driver.findElement(By.id("room_type")));
		room.selectByVisibleText("Standard");
		WebElement indate = driver.findElement(By.id("datepick_in"));
		indate.sendKeys("23/08/2023");
		WebElement outdate = driver.findElement(By.id("datepick_out"));
		outdate.sendKeys("24/08/2023");
		Select adult = new Select(driver.findElement(By.id("adult_room")));
		adult.selectByValue("2");
		Select child = new Select(driver.findElement(By.id("child_room")));
		child.selectByValue("2");
		submit();
		verifyConinue();

		Row row3 = getSheet("Client").getRow(0);
		WebElement fname = driver.findElement(By.id("first_name"));
		String fn = row3.getCell(0).toString();
		fname.sendKeys(fn);
		WebElement lname = driver.findElement(By.id("last_name"));
		lname.sendKeys(row3.getCell(1).toString());
		WebElement addr = driver.findElement(By.id("address"));
		addr.sendKeys(row3.getCell(2).toString());
		WebElement cc = driver.findElement(By.id("cc_num"));
		cc.sendKeys(row3.getCell(3).toString());
		Select cctype = new Select(driver.findElement(By.id("cc_type")));
		cctype.selectByValue("VISA");
		Select exp = new Select(driver.findElement(By.id("cc_exp_month")));
		exp.selectByVisibleText("March");
		Select year = new Select(driver.findElement(By.id("cc_exp_year")));
		year.selectByVisibleText("2025");
		WebElement cvv = driver.findElement(By.id("cc_cvv"));
		cvv.sendKeys(row3.getCell(7).toString());
		book();
		order();

	}

}