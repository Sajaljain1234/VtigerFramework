package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class N_1106_OrganisationPageElements {
	@FindBy(css="img[title='Create Organization...']")
	private WebElement createOrganisation;
	
	public WebElement getCreateOrganisation() {
		return createOrganisation;
	}
}
