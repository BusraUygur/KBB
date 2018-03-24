package com.kbb.tests;


import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kbb.pages.HomePage;
import com.kbb.utilities.BrowserUtils;
import com.kbb.utilities.ConfigurationReader;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class TestCase19 {
		

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
			WebElement element = driver.findElement(By.xpath("//a[@id='navToCarValues']"));

			actions.moveToElement(element).perform();

			driver.findElement(By.linkText("New & Used Car Prices")).click();
			
			WebElement makeList = driver.findElement(By.id("makeDropdown0"));
			Select makeCarList = new Select(makeList);
			makeCarList.selectByValue("Lamborghini");
			
			
			WebElement modelList = driver.findElement(By.id("modelDropdown0"));
			Select modelCarList = new Select(modelList);
			modelCarList.selectByValue("Aventador");
			
			BrowserUtils.waitForVisibility(driver.findElement(By.id("startMyResearchBtn")), 4).click();
			
			driver.findElement(By.id("selectedZipCode")).sendKeys("20148");
			driver.findElement(By.id("enterzipsubmit")).click();
			
			
			driver.findElement(By.linkText("Coupe")).click();
			driver.findElement(By.linkText("Compare styles")).click();
			driver.findElement(By.linkText("Select style")).click();
			driver.findElement(By.linkText("Price with standard options")).click();
			
			WebElement totalFairPrice=driver.findElement(By.id("configuredPrice"));
			WebElement fairPrice=driver.findElement(By.xpath(""));
			
			System.out.println(totalFairPrice.getText());
			System.out.println(fairPrice.getText());
			
			
			
		
		}

	}

