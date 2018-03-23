package com.kbb.tests;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kbb.pages.HomePage;
import com.kbb.utilities.ConfigurationReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SmokeTest  {

	@Test
	public void setUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(ConfigurationReader.getProperty("url"));
		String title = driver.getTitle();
		String expectedTitle = "Kelley Blue Book | New and Used Car Price Values, Expert Car Reviews";
		Assert.assertEquals(title, expectedTitle);

		HomePage homepage = new HomePage();

		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//a[@id='navToResearchTools']"));

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		actions.moveToElement(element).perform();

		driver.findElement(By.linkText("Compare Cars")).click();

		// WebElement iframe = driver.findElement(By.id("overlaybackground"));
		// driver.switchTo().frame(iframe);

		Thread.sleep(2000);
		driver.findElement(By.id("selectedZipCode")).sendKeys("20148");
		driver.findElement(By.id("enterzipsubmit")).click();

		String compareTitle = driver.getTitle();

		String expectedCompareTitle = "Compare New & Used Cars | Kelley Blue Book";

		Assert.assertEquals(compareTitle, expectedCompareTitle);

		assertTrue(driver.findElement(By.xpath("//input[@value='NewCar']")).isSelected());

		WebElement list = driver.findElement(By.xpath("(//select[@class='makemodelDropdown'])[1]"));
		Select select = new Select(list);
		select.selectByValue("Tesla");

		WebElement listModel = driver.findElement(By.xpath("//select[@id='noresultsmodel']"));
		Select select2 = new Select(listModel);
		select2.selectByValue("Model S");

		JavascriptExecutor jsEX = (JavascriptExecutor) driver;
		jsEX.executeScript("window.scrollBy(0,400);");

		WebElement listYear = driver.findElement(By.xpath("//select[@id='noresultsyear']"));
		Select select3 = new Select(listYear);
		select3.selectByValue("2017");

		driver.findElement(By.xpath("//*[@class='addButtonStyleBlue btn-secondary-cta']")).click();

		String actualCompareCareTitle = driver.getTitle();
		String expectedCompareCareTitle = "Compare New & Used Cars | Kelley Blue Book";
		Assert.assertEquals(actualCompareCareTitle, expectedCompareCareTitle);

		String actualModelConfirmation = driver.findElement(By.xpath("//strong[.='New: 2017 Tesla Model S']"))
				.getText();
		String expectedModelConfirmation = "New: 2017 Tesla Model S";
		Assert.assertEquals(actualModelConfirmation, expectedModelConfirmation);

		assertTrue(driver.findElement(By.xpath("//input[@value='NewCar']")).isSelected());
		Thread.sleep(2000);

		WebElement listB = driver.findElement(By.xpath("(//select[@class='makemodelDropdown'])[1]"));
		Select selectB = new Select(listB);
		selectB.selectByValue("Bentley");

		WebElement listBentleyModel = driver.findElement(By.xpath("//select[@id='noresultsmodel']"));
		Select selectlistBentleyModel = new Select(listBentleyModel);
		selectlistBentleyModel.selectByValue("Continental");

		JavascriptExecutor jsEXx = (JavascriptExecutor) driver;
		jsEXx.executeScript("window.scrollBy(0,400);");

		WebElement listYearForBentley = driver.findElement(By.xpath("//select[@id='noresultsyear']"));
		Select select4 = new Select(listYearForBentley);
		
		select4.selectByValue("2017"); 

		driver.findElement(By.xpath("//*[@class='addButtonStyleBlue btn-secondary-cta']")).click();

		String actualModelConfirmation2 = driver.findElement(By.xpath("//strong[.='New: 2017 Tesla Model S']"))
				.getText();
		String expectedModelConfirmation2 = "New: 2017 Tesla Model S";
		Assert.assertEquals(actualModelConfirmation2, expectedModelConfirmation2);

		String actualModelConfirmation3 = driver.findElement(By.xpath("//strong[.='New: 2017 Bentley Continental']"))
				.getText();
		String expectedModelConfirmation3 = "New: 2017 Bentley Continental";
		Assert.assertEquals(actualModelConfirmation3, expectedModelConfirmation3);

		driver.findElement(By.xpath("//*[@class='compareButtonStyleBlue mb5 btn-main-cta right']")).click();

		String actualEE = driver.findElement(By.xpath("//*[@class='link_arrow_blue lnkVehName']")).getText();
		String exepectedEE = "New: 2017 Tesla Model S";

		Assert.assertEquals(actualEE, exepectedEE); // d

		String actualBent = driver.findElement(By.linkText("New: 2017 Bentley Continental")).getText();
		String exepectedEB = "New: 2017 Bentley Continental";

		Assert.assertEquals(actualBent, exepectedEB);
	}
}
