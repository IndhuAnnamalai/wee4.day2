package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.beust.jcommander.JCommander.Builder;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryResizable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		
		
		WebElement frame1 = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame1);
		
		WebElement webElement = driver.findElement(By.xpath("//div[@class='ui-widget-content ui-resizable']/div[3]"));
		
		
		Actions builder = new Actions(driver);	
		builder.clickAndHold(webElement).perform();	
		builder.dragAndDropBy(webElement, -100, -100).perform();
		
	}

}
