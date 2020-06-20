package com.vtiger.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vtiger.genericlib.N_1006_BaseClass;
import com.vtiger.objectRepository.N_1006_HomePageElements;
import com.vtiger.objectRepository.N_1106_CreateProductPageElements;
import com.vtiger.objectRepository.N_1106_ProductInfoPageElements;
import com.vtiger.objectRepository.N_1106_ProductPageElements;

public class N_1106_CreateProductTest extends N_1006_BaseClass{

	@Test
	public void createProduct() throws EncryptedDocumentException, IOException {
	N_1006_HomePageElements hp = PageFactory.initElements(driver, N_1006_HomePageElements.class);
	N_1106_ProductPageElements pp = PageFactory.initElements(driver, N_1106_ProductPageElements.class);
	N_1106_CreateProductPageElements cpp = PageFactory.initElements(driver, N_1106_CreateProductPageElements.class);
	N_1106_ProductInfoPageElements pip = PageFactory.initElements(driver, N_1106_ProductInfoPageElements.class);
	
	hp.getProduct().click();
	pp.getCreateProduct().click();
	cpp.getProductNameTb().sendKeys(wlib.getUniqueName(data.getDataFromExcel("productData", 2, 1)));
	cpp.getSaveBtn().click();
	String actProductMsg=pip.getSuccessMsg().getText();
	Assert.assertTrue(actProductMsg.contains(data.getDataFromExcel("productData", 2, 2)));
		Reporter.log("product created successfully",true);
	}
}
