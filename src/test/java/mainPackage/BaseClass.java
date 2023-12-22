package mainPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{
	
	public static WebDriver driver;
	public void launchBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void typeText(WebElement box,String text) {
		box.sendKeys(text,Keys.ENTER);
	}
	
	public void touch(WebElement element) {
		element.click();
	}
	
	public void switchWindow() {
		String parId=driver.getWindowHandle();
		Set<String> allIds=driver.getWindowHandles();
		for(String id:allIds) {
			if(!id.equals(parId)) {
				driver.switchTo().window(id);
			}
		}

	}
	
	public String titleText(WebElement element) {
		return element.getText();
	}
	
	public List<String> readExcelFile(String filePath) throws IOException {
			List<String> list=new ArrayList<String>();
            File file = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fileInputStream);

            // Get the first sheet in the workbook
            Sheet sheet = workbook.getSheet("Sheet1");

            // Retrieve data from cells A1, A2, A3, and A4
            Row rowA1 = sheet.getRow(0);
            Row rowA2 = sheet.getRow(1);
            Row rowA3 = sheet.getRow(2);
            Row rowA4 = sheet.getRow(3);

            Cell cellA1 = rowA1.getCell(0);
            Cell cellA2 = rowA2.getCell(0);
            Cell cellA3 = rowA3.getCell(0);
            Cell cellA4 = rowA4.getCell(0);

            // Print the data
            list.add(cellA1.getStringCellValue());
            list.add(cellA2.getStringCellValue());
            list.add(cellA3.getStringCellValue());
            list.add(cellA4.getStringCellValue());

            // Close the workbook and input stream
            workbook.close();
            fileInputStream.close();

            // Use the retrieved data as needed
            return list;

        }
}


	


