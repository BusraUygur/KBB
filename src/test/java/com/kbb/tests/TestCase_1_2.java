package com.kbb.tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.kbb.pages.HomePage;
import com.kbb.utilities.TestBase;

public class TestCase_1_2 extends TestBase {

	@Test
	public void test() {
		HomePage homepage = new HomePage();
		Actions action = new Actions(driver);
		action.moveToElement(homepage.carValues).perform();

		homepage.newAndUsedCarPrices.click();

	}
}
