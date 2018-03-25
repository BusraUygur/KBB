package com.kbb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.kbb.pages.HomePage;
import com.kbb.utilities.TestBase;




public class TestCases9 extends TestBase {
	
   HomePage homepage = new HomePage();
	
	@Test
	public void testClick() {
	 
		homepage.checkLogo.click();
		homepage.Price_NewUsedOption.click();
	    
	    homepage.dropdown.click();


	  Select select = new Select(driver.findElement(By.xpath(("(//select[@id='makeDropdown0'][1])"))));
	   Select select1 = new Select(driver.findElement(By.xpath("(//select[@id='modelDropdown0'][1])")));
	   
	   
		select.selectByVisibleText("Acura");
	    select1.selectByVisibleText("MDX");
	    homepage.next.click();
	    

	   homepage.EnterZip.sendKeys("22031");
	   homepage.save.click();
	   homepage.select2017.click();
	   homepage.BaseButton.click();
	   homepage.ChooseThisStyleButton.click();
	   
	    
	    
	    
	}
  

	
		
	}
		 
		 
		 
	 
	 
	
	 


