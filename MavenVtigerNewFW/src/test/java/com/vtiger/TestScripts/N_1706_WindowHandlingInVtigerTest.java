package com.vtiger.TestScripts;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.vtiger.genericlib.N_1006_BaseClass;
import com.vtiger.objectRepository.N_1006_HomePageElements;
import com.vtiger.objectRepository.N_1106_CreateOrganisationPageElements;
import com.vtiger.objectRepository.N_1106_OrganisationInfoPageElements;
import com.vtiger.objectRepository.N_1106_OrganisationPageElements;

public class N_1706_WindowHandlingInVtigerTest extends N_1006_BaseClass {
@Test
public void createOrgWithWindowHandling() throws EncryptedDocumentException, IOException {
	N_1006_HomePageElements hp = PageFactory.initElements(driver,N_1006_HomePageElements.class);
	N_1106_OrganisationPageElements op = PageFactory.initElements(driver,N_1106_OrganisationPageElements.class);
	N_1106_CreateOrganisationPageElements cop = PageFactory.initElements(driver,N_1106_CreateOrganisationPageElements.class);
	N_1106_OrganisationInfoPageElements oip = PageFactory.initElements(driver,N_1106_OrganisationInfoPageElements.class);
	
	hp.getOrganisation().click();
	op.getCreateOrganisation().click();
	String orgName=wlib.getUniqueName(data.getDataFromExcel("organisationData", 2, 1));
	cop.getOrganisationNameTb().sendKeys(orgName);
	//window popup handling
	cop.getMemberOfTbBtn().click();
	wlib.switchToNewWindow();
	cop.getMemberOfAlertWindowSearch().click();
	wlib.acceptAlert();
	wlib.switchToMainWindow();
	cop.getSaveBtn().click();
	String actOrgMsg=oip.getSuccessMsg().getText();
	Assert.assertTrue(actOrgMsg.contains(data.getDataFromExcel("organisationData", 2, 2)));
	Reporter.log("window handle in organisation and created successfully",true);
}
}
