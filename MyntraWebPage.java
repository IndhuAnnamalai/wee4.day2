package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraWebPage {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		WebElement webMen = driver.findElement(By.xpath("//div[@class='desktop-navLink']/a"));
		Actions builder = new Actions(driver);
		builder.moveToElement(webMen).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[@class='desktop-oddColumnContent'])[1]//li[7]/a")).click();
		String text = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		String onlyNumFromText = text.replaceAll("[^0-9]", "");
		int count = Integer.parseInt(onlyNumFromText);
		System.out.println("The count of jackets is: " + count);
		Thread.sleep(1000);
		String str1 = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		String str2= driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		String onlyNumFromStr1 = str1.replaceAll("[^0-9]", "");
		String onlyNumFromStr2 = str2.replaceAll("[^0-9]", "");
		int jackets = Integer.parseInt(onlyNumFromStr1);
	int rainJackets = Integer.parseInt(onlyNumFromStr2);
	System.out.println("The number of Jackets is: "+jackets);
	System.out.println("The number of RainJackets is: "+rainJackets);
	int total = jackets+rainJackets;
	System.out.println("The total is: "+total);
	if(count==total) {
		System.out.println("The counts are equal");
	}else {
		System.out.println("The counts are not equal");
	}
	driver.findElement(By.xpath("//div[@class='common-checkboxIndicator']")).click();
	driver.findElement(By.xpath("//div[@class='brand-more']")).click();
	driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");
	driver.findElement(By.xpath("//ul[@class='FilterDirectory-list']/li[2]//div")).click();
	driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
	List<WebElement> webResult = driver.findElements(By.xpath("//ul[@class='results-base']"));
	for(int i=0;i< webResult.size();i++ ) {
		String title = driver.findElement(By.xpath("//img[@class='img-responsive']")).getAttribute("title");
		if(title.contains("Duke")) {
			System.out.println("The result are all Duke brand");
		}else {
			System.out.println("The results are not correct");
		}
	}
	WebElement webSort = driver.findElement(By.xpath("//div[@class='sort-sortBy']/span"));
	builder.moveToElement(webSort).perform();
	driver.findElement(By.xpath("//ul[@class='sort-list']/li[3]/label")).click();
	String price = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
	System.out.println("The discounted price is: "+price);
	//driver.findElement(By.xpath("//div[@class='slick-list']//div")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//img[@class='img-responsive'])[1]")).click();
	//driver.getScreenshotAs(Output)
	Set<String> windowHandles = driver.getWindowHandles();
	List<String> winList=new ArrayList<String>(windowHandles);
	driver.switchTo().window(winList.get(1));
	File src=driver.getScreenshotAs(OutputType.FILE);
	File dst=new File("./snaps/DukeShirt.png");
	FileUtils.copyFile(src, dst);
	driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
	driver.quit();
	}
	

}
