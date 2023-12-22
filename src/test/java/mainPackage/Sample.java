package mainPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
	
	public static void main(String[] args) throws IOException {
		String filePath="C:\\Users\\X1 Carbon\\Desktop\\sample.txt";
		FileReader fileReader=new FileReader(filePath);
		BufferedReader bufferReader=new BufferedReader(fileReader);
		String url=bufferReader.readLine();
		String searchTerm=bufferReader.readLine();
		String samsung=bufferReader.readLine();
		String[] arr=samsung.split(" ");
		System.out.println("Word to be found: "+arr[0]+"Index of the word: "+arr[1]);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys(searchTerm,Keys.ENTER);
		List<WebElement> list=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(),'Samsung')]"));
		list.get(1).click();
		String parId=driver.getWindowHandle();
		Set<String> allIds=driver.getWindowHandles();
		for(String x:allIds) {
			if(!x.equals(parId)) {
				driver.switchTo().window(x);
			}
		}
		WebElement element=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[5]"));
		String s=element.getText();
		System.out.println(s);
		
		FileWriter fileWriter=new FileWriter(filePath,true);
		BufferedWriter bufferWriter=new BufferedWriter(fileWriter);
		bufferWriter.newLine();
		bufferWriter.write(s);
		bufferWriter.newLine();
		bufferWriter.close();
	
	

}
}
