package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.vtiger.genericlib.N_1006_BaseClass;

public class N_1006_HomePageElements {
	 	@FindBy(linkText="Leads")
		private WebElement leads;
	 	
	    @FindBy(linkText="Organizations")
	    private WebElement organization;
	    
	    @FindBy(linkText="Products")
	    private WebElement product;
	    
	    @FindBy(xpath="//span[text()=' Administrator']/../following-sibling::td[1]/img")
	    private WebElement signoutDD;
	    
	    @FindBy(linkText="Sign Out")
	    private WebElement signoutLink;
	    
	    //creating getters
	    public WebElement getLeads() {
	    	return leads;
	    }
	    public WebElement getOrganisation() {
	    	return organization;
	    }
	    public WebElement getProduct() {
	    	return product;
	    }
	    public WebElement getSignoutDD() {
	    	return signoutDD;
	    }
	    public WebElement getSignoutLink() {
	    	return signoutLink;
	    }
	    
	    //writing common business logic
	    public void logoutFromApp() {
	    Actions act=new Actions(N_1006_BaseClass.driver);
	    act.moveToElement(signoutDD).perform();
	    signoutLink.click();
	    }
}
