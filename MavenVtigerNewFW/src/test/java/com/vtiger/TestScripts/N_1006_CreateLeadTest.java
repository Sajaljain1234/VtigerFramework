package com.vtiger.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.vtiger.genericlib.N_1006_BaseClass;
import com.vtiger.objectRepository.N_1006_CreateLeadPageElements;
import com.vtiger.objectRepository.N_1006_HomePageElements;
import com.vtiger.objectRepository.N_1006_LeadInfoPageElements;
import com.vtiger.objectRepository.N_1006_LeadPageElements;

public class N_1006_CreateLeadTest extends N_1006_BaseClass{
	@Test
	public void createLead() throws EncryptedDocumentException, IOException {
	N_1006_HomePageElements hp = PageFactory.initElements(driver,N_1006_HomePageElements.class);
	N_1006_LeadPageElements lp = PageFactory.initElements(driver,N_1006_LeadPageElements.class);
	N_1006_CreateLeadPageElements clp = PageFactory.initElements(driver,N_1006_CreateLeadPageElements.class);
	N_1006_LeadInfoPageElements lip = PageFactory.initElements(driver,N_1006_LeadInfoPageElements.class);
	
	hp.getLeads().click();
	lp.getCreateLead().click();
	clp.getLastNameTb().sendKeys(data.getDataFromExcel("leadData", 2, 1));
	clp.getCompanyNameTb().sendKeys(data.getDataFromExcel("leadData", 2, 2));
	clp.getSaveBtn().click();
	
	String actLeadMsg=lip.getSuccessMsg().getText();
	Assert.assertTrue(actLeadMsg.contains(data.getDataFromExcel("leadData", 2, 3)));
	Reporter.log("Lead created successfully",true);
	}
}
