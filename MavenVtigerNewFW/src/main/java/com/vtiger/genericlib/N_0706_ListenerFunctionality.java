package com.vtiger.genericlib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class N_0706_ListenerFunctionality implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		String tcName=result.getMethod().getMethodName();
		EventFiringWebDriver efwd=new EventFiringWebDriver(N_1006_BaseClass.driver);
		File sourceFile=efwd.getScreenshotAs(OutputType.FILE);
		File destinationFile=new File("./screenshot/"+tcName+".png");
		
		try {
			FileUtils.copyFile(sourceFile,destinationFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {
}

	public void onTestSuccess(ITestResult result) {
}

	public void onTestSkipped(ITestResult result) {
}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {	
	}

	public void onFinish(ITestContext context) {
}
}
