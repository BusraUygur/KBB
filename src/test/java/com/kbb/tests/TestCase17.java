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
import com.kbb.utilities.ConfigurationReader;
import com.kbb.utilities.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class TestCase17 extends TestBase{

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

			assertTrue(driver.findElement(By.xpath("//input[@value='NewCar']")).isSelected());

			driver.findElement(By.xpath("//input[@value='UsedCar']")).click();

			WebElement usedList = driver.findElement(By.xpath("//select[@id='noresultsusedyear']"));
			Select usedCarList = new Select(usedList);
			usedCarList.selectByValue("2016");

			Boolean found = false;
			WebElement element1 = driver.findElement(By.xpath("//select[@id='noresultsusedmake']"));
			Select select = new Select(element1);
			select.selectByValue("Scion");

			List<WebElement> allOptions = select.getOptions();

			for (WebElement webElement : allOptions) {

				if ((webElement.getText().equals("Scion"))) {

					found = true;
					break;

				}

			}

			if (found == false) {
				System.out.println("Scion not found");
			} else {
				System.out.println("Scion found");
			}
		}

	}

