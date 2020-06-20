package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class N_1106_ProductPageElements {
	@FindBy(css="img[title='Create Product...']")
	private WebElement createProduct;
	
	public WebElement getCreateProduct() {
		return createProduct;
	}
}
