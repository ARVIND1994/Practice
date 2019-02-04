package login;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.poi.ss.usermodel.DataFormatter;

public class Buyer {
	public static void main(String[] args) throws InterruptedException, IOException, AWTException
	{
		
		System.setProperty("webdriver.chrome.driver","D:\\SELENIUM\\chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.example.com/");
		driver.manage().window().maximize();
		driver.findElement(By.className("new_Buyer")).click();
//	
		
		
//		//New Buyer's Login
//		driver.findElement(By.id("NewBuyerEmailId")).sendKeys("greecy2016@gmail.com");
//		driver.findElement(By.id("NewBuyerPassword")).sendKeys("Summertest@2018");
//		  Thread.sleep(15000);
//		  driver.findElement(By.className("hvr-icon-bounce")).click();
		
		//New Buyer's Registration
		  
		  driver.findElement(By.className("common-btn")).click();
		  FileInputStream fis = new FileInputStream("D:\\SELENIUM\\Summer\\summerbuyer.xlsx");
		  
		  XSSFWorkbook workbook = new XSSFWorkbook(fis);
		  XSSFSheet sheet = workbook.getSheetAt(0);
		  Row row = sheet.getRow(1);
		  Cell cell = row.getCell(0);
		  
		 
		  
		  
		 driver.findElement(By.id("NewBuyerOrgName")).sendKeys(row.getCell(0).toString());
		  driver.findElement(By.id("NewBuyerEmailId")).sendKeys(row.getCell(1).toString());
		  System.out.println(cell);
		  System.out.println(sheet.getRow(1).getCell(1));
		  driver.findElement(By.className("common-btn")).click();
		  Thread.sleep((2000));
		 driver.findElement(By.className("common-btn")).click();
		
		  //Admin Panel Login
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);    
		driver.manage().window().maximize();
		newTabOpen(1,driver);
		//To navigate to new link/URL in 2nd new tab
		driver.get("http://www.summer.checkyourprojects.com/admin");
		driver.findElement(By.id("UserUsername")).sendKeys("admin");
		driver.findElement(By.id("UserPassword")).sendKeys("admin");
		driver.findElement(By.className("btn")).click();
		driver.findElement(By.className("title")).click();
	
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,1000)");
			driver.findElement(By.linkText("New Buyer Manager")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.className("notify")).click();
		
		driver.findElement(By.linkText("Respond to Request")).click();
		 Thread.sleep(2000);
		newTabOpen(0,driver);
		
		//Login with excel
		driver.findElement(By.className("new_Buyer")).click();
		driver.findElement(By.id("NewBuyerEmailId")).sendKeys(row.getCell(1).toString());
		Thread.sleep(40000);
		FileInputStream fis1 = new FileInputStream("D:\\SELENIUM\\Summer\\summerbuyer.xlsx");
		XSSFWorkbook workbook1 = new XSSFWorkbook(fis1);
		XSSFSheet sheet1 = workbook1.getSheetAt(0);
		//To change formattiing of cell 
		DataFormatter objDefaultFormat = new DataFormatter();
		
		Row row1 = sheet1.getRow(1);
		Thread.sleep(15000);
		driver.findElement(By.id("NewBuyerPassword")).sendKeys(row1.getCell(2).toString());
		Thread.sleep(10000);
		driver.findElement(By.className("hvr-icon-bounce")).click();
		driver.findElement(By.id("NewBuyerPassword")).sendKeys(row1.getCell(3).toString());
		driver.findElement(By.id("NewBuyerConfirmPass")).sendKeys(row1.getCell(4).toString());
		driver.findElement(By.className("common-btn")).click();
		
		//EDIT PROFILE
		
		
		
		driver.findElement(By.id("NewBuyerAddressOne")).sendKeys(row1.getCell(5).toString());
		driver.findElement(By.id("NewBuyerCity")).sendKeys(row1.getCell(6).toString());
	   driver.findElement(By.id("NewBuyerZip")).sendKeys(objDefaultFormat.formatCellValue(row1.getCell(7)));
	   Select Country = new Select(driver.findElement(By.id("NewBuyerCountry")));
	   Country.selectByVisibleText("Australia");
	   Select Title = new Select (driver.findElement(By.id("NewBuyerTitle")));
	   Title.selectByVisibleText("Mr");
	   driver.findElement(By.id("NewBuyerFirstName")).sendKeys(row1.getCell(8).toString());
	   driver.findElement(By.id("NewBuyerLastName")).sendKeys(row1.getCell(9).toString());
	   driver.findElement(By.id("NewBuyerContactNumber")).sendKeys(objDefaultFormat.formatCellValue(row1.getCell(10)));
	   driver.findElement(By.id("NewBuyerDesignation")).sendKeys(row1.getCell(11).toString());
	   driver.findElement(By.id("edit-profile")).click();
	   Thread.sleep(2000);
	   //FEEDBACK
	   WebElement upload = driver.findElement(By.id("NewBuyerLogo"));
	   upload.sendKeys("C:\\Users\\Arvind\\Desktop\\DUMMY IMAGES\\car.jpg");
	   Thread.sleep(1000);
	   driver.findElement(By.id("NewBuyerRequiredFeedback")).sendKeys(objDefaultFormat.formatCellValue(row1.getCell(12)));
	     Thread.sleep(2000);
		 driver.findElement(By.xpath("//div[@class='back']//child::button")).click();
		 
		 addingquestions(driver,fis,row); 
	}    
	
	public static void addingquestions(WebDriver driver,FileInputStream fis1,Row row) throws InterruptedException  {
		//driver.get("http://www.summer.checkyourprojects.com/");
		//driver.manage().window().maximize();
		//driver.findElement(By.className("new_Buyer")).click();
		
//		driver.findElement(By.id("NewBuyerEmailId")).sendKeys(row.getCell(1).toString());
//		driver.findElement(By.id("NewBuyerPassword")).sendKeys(row.getCell(3).toString());
//		  Thread.sleep(15000);
//		  driver.findElement(By.className("hvr-icon-bounce")).click();	
		  //Add questions

		  JavascriptExecutor js = (JavascriptExecutor) driver;
		
		  js.executeScript("window.scrollBy(0,300)");
		
		  int[] arr =  {9,5,19,20,21,10,22,23,24,27,13,14,15,26,11};
		  String arr_class[] = {"ms-opt-2","ms-opt-6","ms-opt-10","ms-opt-14","ms-opt-17","ms-opt-24","ms-opt-27","ms-opt-29","ms-opt-34","ms-opt-38","ms-opt-42","ms-opt-46","ms-opt-50","ms-opt-53","ms-opt-58",};
		  int len = arr.length;
		  for(int i = 0; i<len; i++)
		  {
			  
			questionSelection(driver,arr[i],arr_class[i]);
			Thread.sleep(1000);
			
		  }
		 driver.findElement(By.id("save_value")).click();
		 
		 driver.findElement(By.xpath("//button[@id='save']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.linkText("Continue to Dashboard")).click();
		 driver.findElement(By.xpath("//div[@id='back']//child::button"));
	
			 }
		   
	public static void questionSelection(WebDriver driver,int pathId, String pathOptionId) {
		driver.findElement(By.xpath("//select[@id='"+pathId+"']//following-sibling::div//child::button")).click();
		WebElement Tier1 =  driver.findElement(By.id(pathOptionId));
		Tier1.click();
		driver.findElement(By.xpath("//select[@id='"+pathId+"']//following-sibling::div//child::button")).click();
		driver.findElement(By.xpath("//label[@for='question_id"+pathId+"']")).click();
		
		
	}
	

	public static void newTabOpen(int data,WebDriver driver) throws AWTException {
		//Admin Panel
		Robot r = new Robot();  		
		r.keyPress(KeyEvent.VK_CONTROL); 
		r.keyPress(KeyEvent.VK_T); 
		r.keyRelease(KeyEvent.VK_CONTROL); 
		r.keyRelease(KeyEvent.VK_T);    
		//To switch to the new tab
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(data));
	}
}
