package com.kbb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kbb.pages.HomePage;
import com.kbb.utilities.TestBase;

public class TestCase3 extends TestBase {
	
	@Test
	public void setUp() throws InterruptedException  {
		;
		String title = driver.getTitle();
		String expectedTitle = "Kelley Blue Book | New and Used Car Price Values, Expert Car Reviews";
		Assert.assertEquals(title, expectedTitle);


		HomePage homepage=new HomePage();
		Actions action=new Actions(driver);
		action.moveToElement(homepage.carValues).perform();
		
		homepage.newAndUsedCarPrices.click();
		
		WebElement list = driver.findElement(By.xpath("//select[@id='intentDropdown0']"));
		Select select = new Select(list);
		select.selectByIndex(0);
		
		WebElement selectMake = driver.findElement(By.xpath("//select[@id='makeDropdown0']"));
		Select select2 = new Select(selectMake);
		select2.selectByValue("Tesla");
		
		WebElement listModel = driver.findElement(By.xpath("//select[@id='modelDropdown0']"));
		Select select3 = new Select(listModel);
		select3.selectByValue("Model S");
		homepage.next.click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("selectedZipCode")).sendKeys("20148");
		driver.findElement(By.id("enterzipsubmit")).click();
		

}
}
