package mainPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainClass {
	
	@Test
	private void method1() throws InterruptedException, IOException {
		BaseClass b=new BaseClass();
		b.launchBrowser("https://www.amazon.in/");
		HomePage h=new HomePage();
		b.typeText(h.getSearchBox(), "iphone 15");
		Thread.sleep(3000);
		SearchPage s=new SearchPage();
		b.touch(s.getProduct());
		b.switchWindow();
		ProductPage p=new ProductPage();
		String actualName=b.titleText(p.getProdTitle());
		String filePath="C:\\Users\\X1 Carbon\\eclipse-workspace\\MsTechProject\\src\\main\\resources\\mstechdata.xlsx";
		List<String> expectedList=b.readExcelFile(filePath);
		String expectedName=expectedList.get(0);
		Assert.assertEquals(expectedName, actualName);
		String expectedStorage=expectedList.get(1);
		String actualStorage=b.titleText(p.getProdStorage());
		Assert.assertEquals(expectedStorage, actualStorage);
		String expectedBrand=expectedList.get(2);
		String actualBrand=b.titleText(p.getProdBrand());
		Assert.assertEquals(expectedBrand, actualBrand);
		String expectedColor=expectedList.get(3);
		String actualColor=b.titleText(p.getColor());
		Assert.assertEquals(expectedColor, actualColor);
	}

}
