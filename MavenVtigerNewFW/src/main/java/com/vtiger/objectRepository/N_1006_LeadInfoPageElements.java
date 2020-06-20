package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class N_1006_LeadInfoPageElements {
	@FindBy(xpath="//span[contains(text(),'Lead Information')]")
	private WebElement successMsg;
	
	public WebElement getSuccessMsg() {
		return successMsg;
	}
	
}
