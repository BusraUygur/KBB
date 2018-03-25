package com.kbb.tests;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.kbb.utilities.BrowserUtils;
import com.kbb.utilities.ConfigurationReader;


public class kbbPositives {
	 
	 
	 public static WebDriver driver;
	 public static String nextUrl;
	 public String firstWinHandle;  
	 public String secondWinHandle;
	
	
	
    @BeforeTest
    public void openinBrowser(){
    	driver = BrowserUtils.initDriver();

    }
    
//    @Ignore
	@Test
	public void verifyHomePage() {
		String expectedUrl = ConfigurationReader.getProperty("url");
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
		String expectedTitle = "Kelley Blue Book | New and Used Car Price Values, Expert Car Reviews";
		Assert.assertEquals(driver.getTitle(), expectedTitle);
	}

//	@Ignore
	@Test
	public void verifyHoverCarValue() {
		String expectedTooltip = "New & Used Car Prices";
		
		WebElement newUsedCar = driver.findElement(By.id("navToCarValuesnavToNewUsedCarPrices"));
		WebElement carValue = driver.findElement(By.id("navToCarValues"));
		Actions action = new Actions(driver);
		action.moveToElement(carValue);
		action.clickAndHold().moveToElement(newUsedCar);
		action.moveToElement(newUsedCar).build().perform();
		String actualTooltip = newUsedCar.getAttribute("Title");
		Assert.assertEquals(actualTooltip, expectedTooltip);
	
	}
//	@Ignore
	@Test 
	public void verifyClickOnNewUsedCars() {
		Actions action = new Actions(driver);
		String expectedTitle = "New Cars & New Car Prices | Kelley Blue Book";
		String actualTitle = null;
		WebElement carValue = driver.findElement(By.id("navToCarValues"));
		WebElement newUsedCar = driver.findElement(By.id("navToCarValuesnavToNewUsedCarPrices"));
		action.moveToElement(carValue).click(newUsedCar).build().perform();
		actualTitle = driver.getTitle();
		nextUrl = driver.getCurrentUrl();
		System.out.println(nextUrl);
		Assert.assertEquals(actualTitle, expectedTitle);
		
		
		
	}
//	@Ignore
	@Test 
	public void verigyDefaultDropDownMenueValue() {
		
		Actions action = new Actions(driver);
		WebElement carValue = driver.findElement(By.id("navToCarValues"));
		WebElement newUsedCar = driver.findElement(By.id("navToCarValuesnavToNewUsedCarPrices"));
		action.moveToElement(carValue).click(newUsedCar).build().perform();
		WebElement dropDown =  driver.findElement(By.id("intentDropdown0"));
		Select select = new Select(dropDown);
		String defaultContent = "New";
		String ActualValue = select.getFirstSelectedOption().getText();
		Assert.assertEquals(ActualValue, defaultContent);
	
	}
//	@Ignore
	@Test 
	public void tc_20() throws InterruptedException {
		
		Actions action = new Actions(driver);
		WebElement carValue = BrowserUtils.findElementById("navToCarValues");
		WebElement newUsedCar = driver.findElement(By.id("navToCarValuesnavToNewUsedCarPrices"));
		action.moveToElement(carValue).click(newUsedCar).build().perform();
		WebElement makeDropDown =  driver.findElement(By.id("makeDropdown0"));
		Select select = new Select(makeDropDown);
		String OptionContent = "BMW";
	    select.selectByVisibleText(OptionContent);
	    WebElement modelDropDown =  driver.findElement(By.id("modelDropdown0"));
	    String modelContent = "2 Series";
	    Select select1 = new Select(modelDropDown);
	    select1.selectByVisibleText(modelContent);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"startMyResearchBtn\"]")).click();
	    String nexUrl = driver.getCurrentUrl();
	    Assert.assertTrue(nexUrl.contains("https://www.kbb.com/bmw/2-series/?intent=buy-new&vehicleclass=newcar#zipo="));
	    Thread.sleep(3000);
	    driver.findElement(By.id("selectedZipCode")).sendKeys("20010");
	    driver.findElement(By.id("enterzipsubmit")).click();
	    BrowserUtils.findElementByCss("#Model-year-select > div.model-year-container.mod-content.y-2018 > div.right > a").click();
	    String expectedTitle2 = "2018 BMW 2 Series - Select A Category | Kelley Blue Book";
	    Assert.assertTrue(driver.getTitle().contains(expectedTitle2));
	    //click on convertible
	    BrowserUtils.waitForClickablility(By.cssSelector("#Content > div.mod-gradiated-content.styles.trade-sell > section > div.mod-single > div.mod-category.category-2.last > div > a"),5000).click();
	    Assert.assertTrue(driver.getTitle().contains("2018 BMW 2 Series Styles and Equipment, New Cars | Kelley Blue Book"));
	    // click on select this style
	    BrowserUtils.waitForClickablility(By.cssSelector("div.vehicle-styles-container:nth-child(3) > div:nth-child(1) > a:nth-child(3)"),30).click();

	  	String stdOptnBt = BrowserUtils.findElementByCss("#Options-container > p.section-subtitle > a").getText(); 
	    String colorAndInterior  = BrowserUtils.findElementByCss("#Options-container > div:nth-child(2) > div.accordion.mod-head.expandable > span.mod-title").getText();
	    String pwrTrain = BrowserUtils.findElementByCss("#Options-container > div:nth-child(3) > div.accordion.mod-head.expandable > span.mod-title").getText();
	    String packages = BrowserUtils.findElementByCss("#Options-container > div:nth-child(4) > div.accordion.mod-head.expandable > span.mod-title").getText();
	    String optns = BrowserUtils.findElementByCss("#Options-container > div:nth-child(5) > div.accordion.mod-head.expandable > span.mod-title").getText();
	    String feesAndIncentives = BrowserUtils.findElementByCss("#Options-container > div:nth-child(6) > div.accordion.mod-head.expandable > span.mod-title").getText();
	    Assert.assertEquals(stdOptnBt, "Price with standard options");
	    Assert.assertEquals(colorAndInterior, "Colors and Interiors");
	    Assert.assertEquals(pwrTrain, "Powertrain");
	    Assert.assertEquals(packages, "Packages");
	    Assert.assertEquals(optns, "Options");
	    Assert.assertEquals(feesAndIncentives, "Fees and Incentives");
	    //click on stndard options
	    BrowserUtils.waitForClickablility(By.cssSelector("#Options-container > p.section-subtitle > a"),30).click();
        // accepting javascript alert
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        
	    Assert.assertEquals(driver.getTitle(), "2018 BMW 2 Series 230i xDrive New Car Prices | Kelley Blue Book");
	    String FairMarketValue = BrowserUtils.findElementByXpath("//*[@id=\"RangeBox\"]/text[4]").getText();
	    Assert.assertEquals(FairMarketValue, "Fair Market Range");
	    //click on compare
	    BrowserUtils.findElementByCss("#pageBottom > div.container-18.nct.medium.js-push-right > div.grid-3.nav-wrap.aside > ul > li:nth-child(2) > a").click();
	    String fe = BrowserUtils.findElementByCss("#pageBottom > div.container-18.nct.medium.js-push-right > section > div.mod-inv.vehicle-scorecard > div.mod-content > div.left-column > ul > li:nth-child(1) > a").getText();
	    String hp = BrowserUtils.findElementByCss("#pageBottom > div.container-18.nct.medium.js-push-right > section > div.mod-inv.vehicle-scorecard > div.mod-content > div.left-column > ul > li:nth-child(2) > a").getText();
	    	String fiveYear = BrowserUtils.findElementByCss("#pageBottom > div.container-18.nct.medium.js-push-right > section > div.mod-inv.vehicle-scorecard > div.mod-content > div.left-column > ul > li:nth-child(3) > a").getText();
	    	String cr = BrowserUtils.findElementByCss("#pageBottom > div.container-18.nct.medium.js-push-right > section > div.mod-inv.vehicle-scorecard > div.mod-content > div.left-column > ul > li:nth-child(4) > a").getText();
	    	String msrp = BrowserUtils.findElementByCss("#pageBottom > div.container-18.nct.medium.js-push-right > section > div.mod-inv.vehicle-scorecard > div.mod-content > div.left-column > ul > li:nth-child(5) > a").getText();
	    Assert.assertEquals(fe, "Fuel Economy");
	    Assert.assertEquals(hp, "Horsepower");
	    Assert.assertEquals(fiveYear, "5-Year Cost");
	    Assert.assertEquals(cr, "Consumer Ratings");
	    Assert.assertEquals(msrp, "MSRP");
	    // click on hp button
	    BrowserUtils.findElementByCss("#pageBottom > div.container-18.nct.medium.js-push-right > section > div.mod-inv.vehicle-scorecard > div.mod-content > div.left-column > ul > li:nth-child(2) > a").click();
	    String firstHighestHp = BrowserUtils.findElementByXpath("//*[@id=\"result-data\"]/li[1]/div[1]").getText();
	    String secondHighestHp = BrowserUtils.findElementByXpath("//*[@id=\"result-data\"]/li[2]/div[1]/p").getText();
	    String thirdHighestHp = BrowserUtils.findElementByXpath("//*[@id=\"result-data\"]/li[3]/div[1]/p").getText();
	    String fourthHighestHp = BrowserUtils.findElementByXpath("//*[@id=\"result-data\"]/li[4]/div[1]/p").getText();
	    
	    
	    Assert.assertTrue(Integer.parseInt(firstHighestHp) > Integer.parseInt(secondHighestHp));
	    Assert.assertTrue(Integer.parseInt(secondHighestHp) > Integer.parseInt(thirdHighestHp));
	    Assert.assertTrue(Integer.parseInt(thirdHighestHp) > Integer.parseInt(fourthHighestHp));

	    // click on pricing button
	    BrowserUtils.waitForClickablility(By.xpath("//*[@id=\\\"pageBottom\\\"]/div[1]/div[3]/ul/li[1]/a"),30).click();
    	    driver.findElement(By.id("downPayment")).sendKeys("One Thousand");
	  
	}
//	@Ignore
	@Test 
	public void tc_22() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement carValue = BrowserUtils.findElementById("navToCarValues");
		WebElement newUsedCar = driver.findElement(By.id("navToCarValuesnavToNewUsedCarPrices"));
		action.moveToElement(carValue).click(newUsedCar).build().perform();
		WebElement makeDropDown =  driver.findElement(By.id("makeDropdown0"));
		Select select = new Select(makeDropDown);
		String OptionContent = "Acura";
	    select.selectByVisibleText(OptionContent);
	    WebElement modelDropDown =  driver.findElement(By.id("modelDropdown0"));
	    String modelContent = "MDX";
	    Select select1 = new Select(modelDropDown);
	    
	    select1.selectByVisibleText(modelContent);
	    // click on next button
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"startMyResearchBtn\"]")).click();
	    // enter the zipcode value 
	    BrowserUtils.waitForClickablility(By.id("selectedZipCode"),30).sendKeys("20010");
	    BrowserUtils.waitForClickablility(By.id("enterzipsubmit"),30).click();
	    String nexUrl = driver.getCurrentUrl();
	    Assert.assertTrue(nexUrl.contains("https://www.kbb.com/acura/mdx"));
	    // click on model 2018 mdx
	    BrowserUtils.waitForClickablility(By.cssSelector("#Model-year-select > div.model-year-container.mod-content.y-2018 > div.right > a"),30).click();
	    String expectedTitle2 = "2018 Acura MDX Styles and Equipment, New Cars | Kelley Blue Book";
	    Assert.assertTrue(driver.getTitle().contains(expectedTitle2));
	    // click on select this base style
	    BrowserUtils.waitForClickablility(By.cssSelector("#Styles-list-container > div > div > div.vehicle-styles-container.clear.row-white.first > div.vehicle-styles-head.accordion-sub.expandable > a"),30).click();
	    Assert.assertTrue(driver.getTitle().contains("2018 Acura MDX Options | Kelley Blue Book"));
	    //click on standard option price button
	    String handle = driver.getWindowHandle();
	    BrowserUtils.waitForClickablility(By.cssSelector("#Options-container > p.section-subtitle > a"),30).click();
        // accepting javascript alert
	    Set<String> RecipeHandle = driver.getWindowHandles();
	     System.out.println(RecipeHandle); 
	     Thread.sleep(3000);
	     Alert alert = driver.switchTo().alert();
	     Thread.sleep(3000);
	     alert.dismiss();
	     //click on pricing 
		    BrowserUtils.waitForClickablility(By.xpath("//*[@id=\\\"pageBottom\\\"]/div[1]/div[3]/ul/li[1]/a"),30).click();
	    // click on compare 
        BrowserUtils.waitForClickablility(By.xpath("//*[@id=\\\"pageBottom\\\"]/div[1]/div[3]/ul/li[1]/a"),30).click();
	}
	
//	@Ignore
	@Test
	public void tc_23() throws InterruptedException {
		
		Actions action = new Actions(driver);
		WebElement carValue = BrowserUtils.findElementById("navToCarValues");
		WebElement newUsedCar = driver.findElement(By.id("navToCarValuesnavToNewUsedCarPrices"));
		action.moveToElement(carValue).click(newUsedCar).build().perform();
		WebElement makeDropDown =  driver.findElement(By.id("makeDropdown0"));
		Select select = new Select(makeDropDown);
		String OptionContent = "BMW";
	    select.selectByVisibleText(OptionContent);
	    WebElement modelDropDown =  driver.findElement(By.id("modelDropdown0"));
	    String modelContent = "3 Series";
	    Select select1 = new Select(modelDropDown);
	    select1.selectByVisibleText(modelContent);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"startMyResearchBtn\"]")).click();
	    String nexUrl = driver.getCurrentUrl();
	    Assert.assertTrue(nexUrl.contains("https://www.kbb.com/bmw/3-series/?intent=buy-new&vehicleclass=newcar#zipo="));
	    Thread.sleep(3000);
	    driver.findElement(By.id("selectedZipCode")).sendKeys("20010");
	    driver.findElement(By.id("enterzipsubmit")).click();
	    BrowserUtils.findElementByCss("#Model-year-select > div.model-year-container.mod-content.y-2017 > div.right > a").click();
	    String expectedTitle2 = "2017 BMW 3 Series - Select A Category | Kelley Blue Book";
	    Assert.assertTrue(driver.getTitle().contains(expectedTitle2));
	    //click on sedan
	    BrowserUtils.waitForClickablility(By.cssSelector("#Content > div.mod-gradiated-content.styles.trade-sell > section > div.mod-single > div:nth-child(2) > div > a"),5000).click();
	    Assert.assertTrue(driver.getTitle().contains("2017 BMW 3 Series Styles and Equipment, New Cars | Kelley Blue Book"));
	    // click on select this style
	    BrowserUtils.waitForClickablility(By.cssSelector("#Styles-list-container > div.style-category-container > div > div.vehicle-styles-container.clear.row-white.first > div.vehicle-styles-head.accordion-sub.expandable > a"),30).click();

	  	String stdOptnBt = BrowserUtils.findElementByCss("#Options-container > p.section-subtitle > a").getText(); 
	    String colorAndInterior  = BrowserUtils.findElementByCss("#Options-container > div:nth-child(2) > div.accordion.mod-head.expandable > span.mod-title").getText();
	    String pwrTrain = BrowserUtils.findElementByCss("#Options-container > div:nth-child(3) > div.accordion.mod-head.expandable > span.mod-title").getText();
	    String packages = BrowserUtils.findElementByCss("#Options-container > div:nth-child(4) > div.accordion.mod-head.expandable > span.mod-title").getText();
	    String optns = BrowserUtils.findElementByCss("#Options-container > div:nth-child(5) > div.accordion.mod-head.expandable > span.mod-title").getText();
	    String feesAndIncentives = BrowserUtils.findElementByCss("#Options-container > div:nth-child(6) > div.accordion.mod-head.expandable > span.mod-title").getText();
	    Assert.assertEquals(stdOptnBt, "Price with standard options");
	    Assert.assertEquals(colorAndInterior, "Colors and Interiors");
	    Assert.assertEquals(pwrTrain, "Powertrain");
	    Assert.assertEquals(packages, "Packages");
	    Assert.assertEquals(optns, "Options");
	    Assert.assertEquals(feesAndIncentives, "Fees and Incentives");
	    //click on stndard options
	    BrowserUtils.waitForClickablility(By.cssSelector("#pageBottom > div.container-18.nct.medium.js-push-right > div.grid-3.nav-wrap.aside > ul > li:nth-child(2) > a"),30).click();
	     Thread.sleep(3000);
	     Alert alert = driver.switchTo().alert();
	     Thread.sleep(3000);
	     alert.dismiss();
	     driver.findElement(By.id("surveyClose")).click();
	     //click on pricing 
		    BrowserUtils.waitForClickablility(By.xpath("//*[@id=\\\"pageBottom\\\"]/div[1]/div[3]/ul/li[1]/a"),30).click();
	    // click on compare 
       BrowserUtils.waitForClickablility(By.xpath("//*[@id=\\\"pageBottom\\\"]/div[1]/div[3]/ul/li[1]/a"),30).click();
		
	}
	
	@Ignore
	@Test
	public void tc_24() throws InterruptedException {
		
		Actions action = new Actions(driver);
		WebElement carValue = BrowserUtils.findElementById("navToCarValues");
		WebElement newUsedCar = driver.findElement(By.id("navToCarValuesnavToNewUsedCarPrices"));
		action.moveToElement(carValue).click(newUsedCar).build().perform();
		WebElement makeDropDown =  driver.findElement(By.id("makeDropdown0"));
		Select select = new Select(makeDropDown);
		String OptionContent = "Dodge";
	    select.selectByVisibleText(OptionContent);
	    WebElement modelDropDown =  driver.findElement(By.id("modelDropdown0"));
	    String modelContent = "Charger";
	    Select select1 = new Select(modelDropDown);
	    select1.selectByVisibleText(modelContent);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"startMyResearchBtn\"]")).click();
	    String nexUrl = driver.getCurrentUrl();
	    Assert.assertTrue(nexUrl.contains("https://www.kbb.com/dodge/charger/?intent=buy-new&vehicleclass=newcar#zipo="));
	    Thread.sleep(3000);
	    driver.findElement(By.id("selectedZipCode")).sendKeys("20010");
	    driver.findElement(By.id("enterzipsubmit")).click();
	    BrowserUtils.findElementByCss("#Model-year-select > div.model-year-container.mod-content.y-2018 > div.right > a").click();
	    String expectedTitle2 = "2018 Dodge Charger - Select A Category | Kelley Blue Book";
	    Assert.assertTrue(driver.getTitle().contains(expectedTitle2));
	    //click on sedan
	    BrowserUtils.waitForClickablility(By.cssSelector("#Content > div.mod-gradiated-content.styles.trade-sell > section > div.mod-single > div:nth-child(2) > div > a"),5000).click();
	    Assert.assertTrue(driver.getTitle().contains("2018 Dodge Charger Styles and Equipment, New Cars | Kelley Blue Book"));
	    // click on select this style
	    BrowserUtils.waitForClickablility(By.cssSelector("div.vehicle-styles-container:nth-child(3) > div:nth-child(1) > a:nth-child(3)"),30).click();

	  	String stdOptnBt = BrowserUtils.findElementByCss("#Options-container > p.section-subtitle > a").getText(); 
	    String colorAndInterior  = BrowserUtils.findElementByCss("#Options-container > div:nth-child(2) > div.accordion.mod-head.expandable > span.mod-title").getText();
	    String pwrTrain = BrowserUtils.findElementByCss("#Options-container > div:nth-child(3) > div.accordion.mod-head.expandable > span.mod-title").getText();
	    String packages = BrowserUtils.findElementByCss("#Options-container > div:nth-child(4) > div.accordion.mod-head.expandable > span.mod-title").getText();
	    String optns = BrowserUtils.findElementByCss("#Options-container > div:nth-child(5) > div.accordion.mod-head.expandable > span.mod-title").getText();
	    String feesAndIncentives = BrowserUtils.findElementByCss("#Options-container > div:nth-child(6) > div.accordion.mod-head.expandable > span.mod-title").getText();
	    Assert.assertEquals(stdOptnBt, "Price with standard options");
	    Assert.assertEquals(colorAndInterior, "Colors and Interiors");
	    Assert.assertEquals(pwrTrain, "Powertrain");
	    Assert.assertEquals(packages, "Packages");
	    Assert.assertEquals(optns, "Options");
	    Assert.assertEquals(feesAndIncentives, "Fees and Incentives");
	    //click on stndard options
	    BrowserUtils.waitForClickablility(By.cssSelector("#pageBottom > div.container-18.nct.medium.js-push-right > div.grid-3.nav-wrap.aside > ul > li:nth-child(2) > a"),30).click();
	     Thread.sleep(3000);
	     Alert alert = driver.switchTo().alert();
	     Thread.sleep(3000);
	     alert.dismiss();
	     //click on pricing 
		BrowserUtils.waitForClickablility(By.xpath("//*[@id=\\\"pageBottom\\\"]/div[1]/div[3]/ul/li[1]/a"),30).click();
	    // click on compare 
       BrowserUtils.waitForClickablility(By.xpath("//*[@id=\\\"pageBottom\\\"]/div[1]/div[3]/ul/li[1]/a"),30).click();
		
	}
	
}
