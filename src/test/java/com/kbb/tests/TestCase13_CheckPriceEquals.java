package com.kbb.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kbb.pages.HomePage;
import com.kbb.utilities.TestBase;

public class TestCase13_CheckPriceEquals extends TestBase {

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
		Thread.sleep(1000);

		list = homepage.selectModel;
		select = new Select(list);
		select.selectByIndex(1);
		Thread.sleep(1000);

		list = homepage.selectYear;
		select = new Select(list);
		select.selectByIndex(1);
		Thread.sleep(1000);

		list = homepage.selectTrim;
		select = new Select(list);
		select.selectByIndex(1);
		Thread.sleep(1000);

		homepage.add.click();
		Thread.sleep(2000);
		

//		WebElement fr = homepage.frame;
//		driver.switchTo().frame(fr);
//		Thread.sleep(2000);
//
//		fr = homepage.frameDeclineButton;
//		fr.click();
//		Thread.sleep(2000);

		homepage.overviewAndPricingButton.click();
		Thread.sleep(2000);

		String title = driver.getTitle();
		String expectedTitle = "2017 Alfa Romeo 4C New Car Prices | Kelley Blue Book";
		Assert.assertEquals(title, expectedTitle);
		Thread.sleep(2000);
		
		WebElement fr = homepage.surveyIframe;
		driver.switchTo().frame(fr);
		Thread.sleep(2000);

		fr = homepage.noThanks;
		fr.click();
		Thread.sleep(2000);

		jsEX.executeScript("window.scrollBy(0,1000);");
		Thread.sleep(2000);
		
		WebElement totalFairPurchase = homepage.totalFairPurchasePrice;
		System.out.println(totalFairPurchase.getText());
		
		jsEX.executeScript("window.scrollBy(0,-1000);");
//		WebDriverWait wait=new WebDriverWait(driver, 10);
//		WebElement frameFairPurchase = homepage.frameFairPurchasePrice;
//		wait.until(ExpectedConditions.visibilityOf(frameFairPurchase));
//		
//		System.out.println(frameFairPurchase.getText());
//		Assert.assertEquals(totalFairPurchase.getText(), frameFairPurchase.getText());
		
		

		
		
	
	}

}
