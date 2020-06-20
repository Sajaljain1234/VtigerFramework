package com.vtiger.TestScripts;

import java.io.IOException;
import java.util.Random;

import javax.net.ssl.HostnameVerifier;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vtiger.genericlib.N_1006_BaseClass;
import com.vtiger.objectRepository.N_1006_HomePageElements;
import com.vtiger.objectRepository.N_1106_CreateOrganisationPageElements;
import com.vtiger.objectRepository.N_1106_OrganisationInfoPageElements;
import com.vtiger.objectRepository.N_1106_OrganisationPageElements;

public class N_1106_CreateOrganisationTest extends N_1006_BaseClass{
	@Test
	public void createOrg() throws IOException {
	N_1006_HomePageElements hp = PageFactory.initElements(driver, N_1006_HomePageElements.class);	
	N_1106_OrganisationPageElements op = PageFactory.initElements(driver , N_1106_OrganisationPageElements.class);	
	N_1106_CreateOrganisationPageElements cop = PageFactory.initElements(driver, N_1106_CreateOrganisationPageElements.class);
	N_1106_OrganisationInfoPageElements oip = PageFactory.initElements(driver, N_1106_OrganisationInfoPageElements.class);
	
	hp.getOrganisation().click();
	op.getCreateOrganisation().click();
/*	String orgName=data.getDataFromExcel("organisationData", 2, 1);
	Random r=new Random();
	int num=r.nextInt(9999);
	orgName=orgName+num;*/
//for above lines new method created for code optimization 
	cop.getOrganisationNameTb().sendKeys(wlib.getUniqueName(data.getDataFromExcel("organisationData", 2, 1)));
	cop.getSaveBtn().click();
	String actOrgMsg=oip.getSuccessMsg().getText();
	Assert.assertTrue(actOrgMsg.contains(data.getDataFromExcel("organisationData", 2, 2)));
	Reporter.log("organisation created successfully",true);
}
}