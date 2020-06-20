package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class N_1006_LeadPageElements {
	@FindBy(css="img[title='Create Lead...']")
	private WebElement createLead;
	
	public WebElement getCreateLead() {
		return createLead;
	}
}
