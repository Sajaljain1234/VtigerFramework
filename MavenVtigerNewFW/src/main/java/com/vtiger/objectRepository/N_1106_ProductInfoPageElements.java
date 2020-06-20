package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class N_1106_ProductInfoPageElements {
    @FindBy(xpath="//span[contains(text(),'Product Information')]")
    private WebElement successMsg;

    public WebElement getSuccessMsg() {
    	return successMsg;
    }
}
