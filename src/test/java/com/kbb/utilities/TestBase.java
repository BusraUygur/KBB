package com.kbb.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

	protected WebDriver driver;

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)

	public void setUp(@Optional String browser) {
		driver = Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(ConfigurationReader.getProperty("url"));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		//Driver.quit();
	}

}
