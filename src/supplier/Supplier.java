package supplier;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Supplier {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver","D:\\SELENIUM\\chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.summer.checkyourprojects.com/");
		driver.manage().window().maximize();
		driver.findElement(By.className("supplier")).click();
        //Supplier Registeration
		
		driver.findElement(By.linkText("Register Now")).click();
		 Select Title = new Select(driver.findElement(By.id("SupplierTitle")));
		 Title.selectByVisibleText("Mr");
		
		 //EXCEL DATA INPUT
		 FileInputStream fis2 = new FileInputStream("D:\\SELENIUM\\Summer\\summerbuyer.xlsx");
		 XSSFWorkbook workbook2 = new XSSFWorkbook(fis2) ;
		 XSSFSheet sheet2 = workbook2.getSheetAt(1);
		//To change formattiing of cell 
			DataFormatter objDefaultFormat = new DataFormatter();
			Row row1 = sheet2.getRow(1);
		 
		 driver.findElement(By.id("SupplierFirstName")).sendKeys(row1.getCell(0).toString());
		 driver.findElement(By.id("SupplierLastName")).sendKeys(row1.getCell(1).toString());
		 driver.findElement(By.id("SupplierAddress1")).sendKeys(row1.getCell(2).toString());
		 driver.findElement(By.id("SupplierCity")).sendKeys(row1.getCell(3).toString());
		 driver.findElement(By.id("SupplierZipcode")).sendKeys(objDefaultFormat.formatCellValue(row1.getCell(4)));
		 Select Country = new Select(driver.findElement(By.id("SupplierCountry")));
		 Country.selectByVisibleText("New Zealand");
		 driver.findElement(By.id("SupplierEmailId")).sendKeys(row1.getCell(5).toString());
		 driver.findElement(By.id("SupplierConfirmEmailId")).sendKeys(row1.getCell(6).toString());
		 driver.findElement(By.id("SupplierPassword")).sendKeys(row1.getCell(7).toString());
		 driver.findElement(By.id("SupplierConfirmPass")).sendKeys(row1.getCell(8).toString());
		 WebDriverWait wait = new WebDriverWait(driver, 10);

		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='SupplierTerms']"))).click();    
		 
		 driver.findElement(By.xpath("//label[@for='SupplierReceiveInfo']")).click();
		 driver.findElement(By.className("common-btn")).click();
	}

}
