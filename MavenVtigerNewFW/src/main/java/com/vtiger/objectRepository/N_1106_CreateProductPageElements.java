package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class N_1106_CreateProductPageElements {

	@FindBy(name="productname")
	private WebElement productNameTb;
	
	@FindBy(css="input[value='  Save  ']")
	private WebElement saveBtn;
	
	public WebElement getProductNameTb() {
		return productNameTb;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
}
