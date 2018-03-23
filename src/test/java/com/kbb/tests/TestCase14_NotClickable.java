package com.kbb.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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

public class TestCase14_NotClickable extends TestBase {

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
		select.selectByIndex(0);
		Thread.sleep(2000);

		boolean modelNotClickable = homepage.selectModel.isEnabled();
		if (modelNotClickable) {
			System.out.println("Model button is not clickable");
		}
		
		boolean yearNotClickable = homepage.selectYear.isEnabled();
		if (yearNotClickable) {
			System.out.println("Next button is not clickable");
		}

	}

}
