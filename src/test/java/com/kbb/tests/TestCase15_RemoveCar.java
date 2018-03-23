package com.kbb.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.kbb.pages.HomePage;
import com.kbb.utilities.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase15_RemoveCar extends TestBase {

	@Test
	public void test() throws InterruptedException {
		HomePage homepage = new HomePage();
		Actions actions = new Actions(driver);
		actions.moveToElement(homepage.hoverToResearchTools).perform();

		homepage.compareCars.click();
		Thread.sleep(2000);

		homepage.zipCodePopUpWindow.sendKeys("22181" + Keys.ENTER);
		Assert.assertTrue(homepage.newCarIsSelectedByDefault.isDisplayed());

		JavascriptExecutor jsEX = (JavascriptExecutor) driver;
		jsEX.executeScript("window.scrollBy(0,400);");
		Thread.sleep(2000);

		WebElement list = homepage.selectMake;
		Select select = new Select(list);
		select.selectByIndex(2);
		Thread.sleep(3000);

		list = homepage.selectModel;
		select = new Select(list);
		select.selectByIndex(1);
		Thread.sleep(3000);

		list = homepage.selectYear;
		select = new Select(list);
		select.selectByIndex(1);
		Thread.sleep(3000);

		list = homepage.selectTrim;
		select = new Select(list);
		select.selectByIndex(1);
		Thread.sleep(3000);

		homepage.add.click();
		Thread.sleep(2000);

		jsEX.executeScript("window.scrollBy(0,400);");
		Thread.sleep(2000);

		list = homepage.selectMake;
		select = new Select(list);
		select.selectByIndex(5);
		Thread.sleep(3000);

		list = homepage.selectModel;
		select = new Select(list);
		select.selectByIndex(1);
		Thread.sleep(3000);
		select.selectByIndex(1);

		list = homepage.selectYear;
		select = new Select(list);
		select.selectByIndex(2);
		Thread.sleep(3000);

		list = homepage.selectTrim;
		select = new Select(list);
		select.selectByIndex(1);
		Thread.sleep(3000);

		homepage.add.click();
		Thread.sleep(2000);

		homepage.compare.click();
		Thread.sleep(2000);

		String title = driver.getTitle();
		String expectedTitle = "Compare 2017 Alfa Romeo 4C vs 2017 Bentley Bentayga | Kelley Blue Book";
		Assert.assertEquals(title, expectedTitle);
		Thread.sleep(2000);

		assertTrue(homepage.compareSideBySide.isDisplayed());
		Thread.sleep(2000);

		String firstVehicle = "New: 2017 Alfa Romeo 4C";
		assertTrue(homepage.vehicleOne.getText().equals(firstVehicle));

		String secondVehicle = "New: 2017 Bentley Bentayga";
		assertTrue(homepage.vehicleTwo.getText().equals(secondVehicle));

		homepage.removeCar.click();
		Thread.sleep(2000);

		String title2 = driver.getTitle();
		String expectedTitle2 = "Compare 2017 Alfa Romeo 4C | Kelley Blue Book";
		Assert.assertEquals(title2, expectedTitle2);

		boolean notVisible = homepage.selectVehicleTwo.isEnabled();
		if (notVisible) {
			System.out.println("Vehicle 2 is not visible");
		}

		Navigation navigator = driver.navigate();
		navigator.back();
		Thread.sleep(2000);
		
		Assert.assertEquals(title, expectedTitle);
		Thread.sleep(2000);
		
		assertTrue(homepage.vehicleTwo.getText().equals(secondVehicle));


	}

}