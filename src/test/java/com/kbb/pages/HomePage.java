package com.kbb.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kbb.utilities.Driver;

public class HomePage {

	private WebDriver driver;
	
	public HomePage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='logo-home-link']")
	public WebElement checkIfLogoIsPresentOnHomePage;

	@FindBy(id = "entryPointShopper")
	public WebElement Price_NewUsedOptionOnHomePage;

	@FindBy(xpath = "//a[@id='navToResearchTools']")
	public WebElement hoverToResearchTools;

	@FindBy(xpath = "//a[@id='navToResearchToolsnavToCompareCars']")
	public WebElement compareCars;

	@FindBy(xpath = "//input[@id='selectedZipCode']")
	public WebElement zipCodePopUpWindow;

	@FindBy(xpath = "//input[@value='NewCar']")
	public WebElement newCarIsSelectedByDefault;
	
	@FindBy(xpath = "(//select[@class='makemodelDropdown'])[1]")
	public WebElement selectMake;
	
	@FindBy(xpath = "(//select[@class='makemodelDropdown w170'])[1]")
	public WebElement selectModel;
	
	@FindBy(xpath = "//select[@id='noresultsyear']")
	public WebElement selectYear;
	
	@FindBy(xpath = "//*[@id=\"noresultstrim\"]")
	public WebElement selectTrim;
	
	@FindBy(xpath = "//a[@class='addButtonStyleBlue btn-secondary-cta']")
	public WebElement add;
	
	@FindBy(linkText = "Overview & Pricing")
	public WebElement overviewAndPricingButton;
	
	@FindBy(id = "surveyIframe")
	public WebElement surveyIframe;
	
	@FindBy(xpath = "//a[contains(text(),'No Thanks')]")
	public WebElement noThanks;
	
	@FindBy(xpath ="//a[@id='navToCarValues']")
	public WebElement carValues;
	
	@FindBy(xpath ="//a[@id='navToCarValuesnavToNewUsedCarPrices']")
	public WebElement newAndUsedCarPrices;
	
	@FindBy(xpath ="//a[@class='compareButtonStyleBlue mb5 btn-main-cta right']")
	public WebElement compare;
	
	@FindBy(xpath = "//div[@id='title']//h1")
	public WebElement compareSideBySide;
	
	@FindBy(xpath = "//a[@class='link_arrow_blue lnkVehName'][1]")
	public WebElement vehicleOne;
	
	@FindBy(xpath = "//div[@class='compSideVeh alt']//a[@href='/bentley/bentayga/2017/?intent=buy-new']")
	public WebElement vehicleTwo;
	
	@FindBy(xpath = "//a[@href='/compare-cars/overview/2017-alfa-romeo-4c-424162/']")
	public WebElement removeCar;
	
	@FindBy(xpath = "//div[@id='ddlCompare1']")
	public WebElement selectVehicleTwo;
	
	@FindBy(xpath = "//td[@id='configuredPrice']")
	public WebElement totalFairPurchasePrice;
	
	@FindBy(xpath = "(//*[@text-anchor='middle'])[1]")
	public WebElement frameFairPurchasePrice;
	//*[@text-anchor='middle'][@font-size='14'][@font-weight='700'])[1]
	
	
	
//	@FindBy(xpath = "//div[@class='fsrInvite']")
//	public WebElement frame;
//		
//	@FindBy(xpath = "//a[@class='fsrDeclineButton']")
//	public WebElement frameDeclineButton;
	
	
	
	
	
	
	
	
	
	
	

}
