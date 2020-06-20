package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class N_1106_CreateOrganisationPageElements {
	@FindBy(css="input[name='accountname']")
	private WebElement organisationNameTb;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement memberOfTbBtn;
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement saveBtn;
	
	@FindBy(linkText="redchip92")
	private WebElement memberOfAlertWindowSearch;
	
	public WebElement getOrganisationNameTb(){
		return organisationNameTb;
	}
	
	public WebElement getMemberOfTbBtn() {
		return memberOfTbBtn;
	}
	
	public WebElement getSaveBtn(){
		return saveBtn;
	}
	
	public WebElement getMemberOfAlertWindowSearch(){
		return memberOfAlertWindowSearch;
	}
	
}
