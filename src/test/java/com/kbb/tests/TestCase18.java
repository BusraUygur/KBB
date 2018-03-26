package com.kbb.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kbb.pages.HomePage;
import com.kbb.utilities.BrowserUtils;
import com.kbb.utilities.ConfigurationReader;
import com.kbb.utilities.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase18 extends TestBase{
	@Test
	public void testListedCars() throws InterruptedException {
		
		String title = driver.getTitle();
		String expectedTitle = "Kelley Blue Book | New and Used Car Price Values, Expert Car Reviews";
		Assert.assertEquals(title, expectedTitle);

		HomePage homepage = new HomePage();
		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//a[@id='navToResearchTools']"));

		actions.moveToElement(element).perform();

		driver.findElement(By.linkText("Compare Cars")).click();

		driver.findElement(By.id("selectedZipCode")).sendKeys("20148");
		driver.findElement(By.id("enterzipsubmit")).click();
		
		JavascriptExecutor jsEX = (JavascriptExecutor) driver;
		jsEX.executeScript("window.scrollBy(0,800);");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//div[@id='compareCategoriesNew']//a[@class='link_arrow_blue'])[8]")).click();

		List<WebElement> findElements = driver.findElements(By.xpath("//div[@id='compSideGrid']//table//tr[8]//td"));
		
		for (WebElement webElement : findElements) {
			if (webElement.getText().contains("Electric)")){
			}
			
		}
		
		System.out.println("final two updated");
		
	
		
		
		
	}
}
