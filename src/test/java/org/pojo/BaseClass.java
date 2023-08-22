package org.pojo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static  WebDriver driver;
	
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	public static void launchUrl(String url) {
		driver.get(url);
	}
	
	public static void maximize() {
		driver.manage().window().maximize();
	}
	public static void closeBrowser() {
		driver.close();
	}
	
	public static void passTxt(String txt,WebElement e) {
		e.sendKeys(txt);
	}
	
	public static void clk(WebElement e) {
		e.click();
	}
	public static void implicitWait(int secs) {
		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
	}
	public static String getUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}
	public static String getTittle() {
		String title = driver.getTitle();
		return title;	
	}
	public static String getAttribute(WebElement e) {
		String attr = e.getAttribute("value");
		return attr;
	}
	
	
	//MouseActions
		public static void moveToElement(WebElement e) {
			Actions ac=new Actions(driver);
			ac.moveToElement(e).perform();
		}
		public static void dragAndDrop(WebElement src,WebElement des) {
			Actions ac=new Actions(driver);
			ac.dragAndDrop(src, des).perform();;	
		}
		public static void rightclick(WebElement e) {
			Actions ac=new Actions(driver);
			ac.contextClick(e).perform();
		}
		public static void doubleclick(WebElement e) {
			Actions ac=new Actions(driver);
			ac.doubleClick(e).perform();;
		}
		
	//Alert
		public static void accept(WebElement e) {
			Alert al=driver.switchTo().alert();
			al.accept();
		}
		public static void dimiss(WebElement e) {
			Alert al=driver.switchTo().alert();
			al.dismiss();
		}
		public static void insertValues(WebElement e,String str) {
			Alert al=driver.switchTo().alert();
			al.sendKeys(str);
		}
		public static void getText(WebElement e) {
			Alert al=driver.switchTo().alert();
			al.getText();
		}
	//DropDown
		public static void selectByValue(WebElement e,String str) {
			Select s=new Select(e);
			s.selectByValue(str);	
		}
		public static void selectByIndex(WebElement e,int i) {
			Select s=new Select(e);
			s.selectByIndex(i);
		}
		public static void selectByVisibleText(WebElement e,String str) {
			Select s=new Select(e);
			s.selectByVisibleText(str);
		}
		public static List<WebElement> getOptions(WebElement e) {
			Select s=new Select(e);
			List<WebElement> options = s.getOptions();
			return options;
		}
		public static List<WebElement> getAllSelectedOptions(WebElement e) {
			Select s=new Select(e);
			List<WebElement> all = s.getAllSelectedOptions();
			return all;
		}
		public static WebElement getFirstSelectedOptions(WebElement e) {
			Select s=new Select(e);
		    WebElement first = s.getFirstSelectedOption();
			return first;
		}
		public static boolean isMultiple(WebElement e) {
			Select s=new Select(e);
			boolean multiple = s.isMultiple();
			return multiple;
		}
		public static void deSelectByIndex(WebElement e,int i) {
			Select s=new Select(e);
			s.deselectByIndex(i);
		}
		public static void deselectByVisibleText(WebElement e,String str) {
			Select s=new Select(e);
			s.deselectByVisibleText(str);
		}
		public static void deselectByValue(WebElement e,String str) {
			Select s=new Select(e);
			s.deselectByValue(str);	
		}
		public static void deselectAll(WebElement e) {
			Select s=new Select(e);
			s.deselectAll();	
		}
	//JavaScript
		public static void insert(WebElement e,String str,int i) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeAsyncScript("arguments[i].setAttribute('value','str')",e);
			
		}
		public static void click1(WebElement e,int i) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeAsyncScript("arguments[i].click()",e);
		}
		public static Object getValues(WebElement e,int i) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			Object txt=js.executeScript("return arguments[i].getAttribute('value')",e);
			return txt;
		}
		public static void scrollDownAndUp(WebElement e,boolean b,int i) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[i].scrollIntoView(b)",e);
		}
	//Frames
		public static void byIndex(int i) {
			driver.switchTo().frame(i);
		}
		public static  void byName(String str) {
			driver.switchTo().frame(str);
		}
		public static void byWebElement(WebElement e) {
			driver.switchTo().frame(e);
		}
	//WindowHandling
		public static void Url(String str) {
			driver.switchTo().window(str);
		}
		public static void tittle(String str) {
			driver.switchTo().window(str);
		}
		public static void windowId(String str) {
			driver.switchTo().window(str);
		}
		public static String getWindowId() {
			String id = driver.getWindowHandle();
			return id;
		}
		public static Set<String> getAllWindowId() {
			Set<String> allId = driver.getWindowHandles();
			return allId;
		}
	//Navigation
		public static void get(String str) {
			driver.navigate().to(str);
		}
		public static void forward() {
			driver.navigate().forward();
		}
		public static  void back() {
			driver.navigate().back();
		}
		public static void refresh() {
			driver.navigate().refresh();
		}
		public static boolean isDisplay(WebElement e) {
			boolean dis = e.isDisplayed();
			return dis;
		}
		public static boolean isEnable(WebElement e) {
			boolean dis = e.isEnabled();
			return dis;
		}
		public static boolean isSelected(WebElement e) {
			boolean dis = e.isSelected();
			return dis;
		}
	//Files DataDriven
		public static void createNewExcelFile(int r,int c,String newdata) throws IOException {
			File f=new File("C:\\Users\\maris\\eclipse-workspace\\MavenProject\\Excel\\File1.xlsx");
			FileInputStream fi=new FileInputStream(f);
			Workbook w=new XSSFWorkbook();
			Sheet newsheet = w.createSheet("Data");
			Row newRow = newsheet.createRow(r);
			Cell newCell = newRow.createCell(c);
			newCell.setCellValue(newdata);
			FileOutputStream fo=new FileOutputStream(f);
			w.write(fo);
		}
		public static void createNewCell(int row,int col,String newdata) throws IOException {
			File f=new File("C:\\Users\\maris\\eclipse-workspace\\MavenProject\\Excel\\File1.xlsx");
			FileInputStream fi=new FileInputStream(f);
			Workbook w=new XSSFWorkbook(fi);
			Sheet s = w.getSheet("Data");
			Row r= s.getRow(row);
			Cell newCell = r.createCell(col);
			newCell.setCellValue(newdata);
			FileOutputStream fo=new FileOutputStream(f);
			w.write(fo);
		}
		public static void createNewRow(int crerow,int crecol,String newdata) throws IOException {
			File f=new File("C:\\Users\\maris\\eclipse-workspace\\MavenProject\\Excel\\File1.xlsx");
			FileInputStream fi =new FileInputStream(f);
			Workbook w=new XSSFWorkbook(fi);
			Sheet s = w.getSheet("Data");
			Row newRow = s.createRow(crerow);
			Cell newCell = newRow.createCell(crecol);
			newCell.setCellValue(newdata);
			FileOutputStream fo=new FileOutputStream(f);
			w.write(fo);
		}
		public static void updateData(int GetRow,int GetCol,String oldData,String newData) throws IOException {
			File f=new File("C:\\Users\\maris\\eclipse-workspace\\MavenProject\\Excel\\File1.xlsx");
			FileInputStream fi=new FileInputStream(f);
			Workbook w=new XSSFWorkbook();
			Sheet newsheet = w.createSheet("Data");
			Row Row = newsheet.getRow(GetRow);
			Cell Cell = Row.getCell(GetCol);
			String str = Cell.getStringCellValue();
			if (str.equals(oldData)) {
				Cell.setCellValue(newData);
			}
			FileOutputStream fo=new FileOutputStream(f);
			w.write(fo);
			
		}
}
