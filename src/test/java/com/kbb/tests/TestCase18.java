package com.kbb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kbb.pages.HomePage;
import com.kbb.utilities.BrowserUtils;
import com.kbb.utilities.ConfigurationReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase18 {
	@Test
	public void testListedCars() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(ConfigurationReader.getProperty("url"));
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
		
		
		BrowserUtils.waitForClickablility(driver.findElement(By.linkText("Electric")), 5).click();
		
		
		
	}
}