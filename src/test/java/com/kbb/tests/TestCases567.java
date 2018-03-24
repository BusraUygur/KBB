package com.kbb.tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.kbb.pages.HomePage;
import com.kbb.utilities.TestBase;



public class TestCases567 extends TestBase {

	HomePage homepage = new HomePage();

	@Test

	public void search() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(homepage.researchTool).perform();

		homepage.CompareCars.click();

		Thread.sleep(2000);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		homepage.zipagain.sendKeys("22031");
		homepage.savaAgain.click();
		assertTrue(driver.findElement(By.xpath("//input[@value='NewCar']")).isSelected());

		Select select = new Select(homepage.selectMakeOption);
		select.selectByVisibleText("Tesla");

		select = new Select(homepage.chooseSmodel);
		select.selectByValue("Model S");

		JavascriptExecutor jsEX = (JavascriptExecutor) driver;
		jsEX.executeScript("window.scrollBy(0,400);");

		select = new Select(homepage.chooseYear2017);
		select.selectByValue("2017");

		homepage.ClikcOnAddButton.click();

		assertTrue(homepage.DefaultButtonOfBentley.isSelected());

		select = new Select(homepage.noresultsmake);
		select.selectByVisibleText("Bentley");

		select = new Select(homepage.noresultsmodel);

		select.selectByVisibleText("Continental");
		// select4.deselectByValue("'Continental");
		select = new Select(homepage.noresultsyear);
		select.selectByVisibleText("2017");
		// BrowserUtils.waitForClickablility(button.clickOnAddButtonOfBentley, 5);
		homepage.ClikcOnAddButton.click();
		
		 driver.findElements(By.xpath("//input[@value='UsedCar']")).size();
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		
		select = new Select(homepage.selectYearOfBMW);
		select.selectByValue("1992");
		
	    select = new Select(homepage.selectModelOfBMW);
		 select.selectByValue("BMW");
		
		 select = new Select(homepage.selectM5);
		 select.selectByVisibleText("M5");
		
	     select = new Select(homepage.chooseTrim);
		
		 select.selectByVisibleText("Sedan 4D");

		 homepage.ClikcOnAddButton.click();
         
		 driver.findElement(By.xpath("(//a[@class='close '])[1]")).click();
	
		 driver.findElement(By.xpath("(//a[@class='close '])[2]")).click();

		



	}
}
