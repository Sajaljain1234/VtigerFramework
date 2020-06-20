package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class N_0906_LoginPageElements {
    @FindBy(name="user_name")
	private WebElement username;
    @FindBy(name="user_password")
    private WebElement password;
    @FindBy(id="submitButton")
    private WebElement loginBtn;
    @FindBy(xpath="//div[contains(text(),'You must specify a valid')]")
    private WebElement errorMsg;
    
    //creating getters
    public WebElement getUsername() {
    	return username;
    }
    public WebElement getPassword() {
    	return password;
    }
    public WebElement getLoginBtn() {
    	return loginBtn;
    }
    public WebElement getErrorMsg() {
    	return errorMsg;
    }
    //writing common business logic
    public void loginToApp(String un,String pwd) {
    	username.sendKeys(un);
    	password.sendKeys(pwd);
    	loginBtn.click();
    }
}
