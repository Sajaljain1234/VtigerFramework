package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class N_1006_CreateLeadPageElements {
	@FindBy(name="lastname")
	private WebElement lastNametb;
	
	@FindBy(name="company")
	private WebElement companyNametb;
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement saveBtn;
	
	public WebElement getLastNameTb() {
		return lastNametb;
	}
		
	public WebElement getCompanyNameTb() {
		return companyNametb;
	}
		
	public WebElement getSaveBtn() {
		return saveBtn;	
	}
}
