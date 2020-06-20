package com.vtiger.genericlib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class N_1106_WebDriverCommonUtils {
	String mainBrowserSessionId=null;
public void waitForElement(WebElement element) {
	WebDriverWait wait=new WebDriverWait(N_1006_BaseClass.driver,20);
	wait.until(ExpectedConditions.visibilityOf(element));
}

public void selectItemFromList(WebElement element,String itemToBeSelect) {
	Select s=new Select(element);
	s.selectByVisibleText(itemToBeSelect);
}

public boolean checkMultipleList(WebElement element) {
	Select s=new Select(element);
	return s.isMultiple();
}

public void keepMouseOnElement(WebElement element) {
	Actions act=new Actions(N_1006_BaseClass.driver);
	act.moveToElement(element).perform();
}

public void moveObjectAtRequiredPlace(WebElement source,WebElement target) {
	Actions act=new Actions(N_1006_BaseClass.driver);
	act.dragAndDrop(source, target).perform();
}

public void acceptAlert() {
	Alert alt = N_1006_BaseClass.driver.switchTo().alert();
	alt.accept();
}

public void rejectAlert() {
	Alert alt = N_1006_BaseClass.driver.switchTo().alert();
	alt.dismiss();
}

public void validateAlertMsg(String expAlertText) {
	Alert alt = N_1006_BaseClass.driver.switchTo().alert();
	String actualAlertText = alt.getText();
	Assert.assertEquals(expAlertText, actualAlertText);
	Reporter.log("alert validation pass",true);
}

public void switchToNewWindow() {
	mainBrowserSessionId=N_1006_BaseClass.driver.getWindowHandle();
	Set<String> allId = N_1006_BaseClass.driver.getWindowHandles();
	for(String id:allId) {
		if(!id.equals(mainBrowserSessionId)) {
		N_1006_BaseClass.driver.switchTo().window(id);
		}
	}
}

public void switchToMainWindow() {
	N_1006_BaseClass.driver.switchTo().window(mainBrowserSessionId);
}

public void switchToRequiredFrame(WebElement element) {
	N_1006_BaseClass.driver.switchTo().frame(element);
}

public void switchToDefaultScreen(WebElement element) {
	N_1006_BaseClass.driver.switchTo().defaultContent();
}

public void fileUploadToApplication(String filePath) throws AWTException {
	filePath=filePath.replace("\\", "\\\\");
	StringSelection path=new StringSelection(filePath);
	Toolkit tool = Toolkit.getDefaultToolkit();
	Clipboard clip = tool.getSystemClipboard();
	clip.setContents(path, null);
	
	Robot r=new Robot();
	//paste the path
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_V);
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyRelease(KeyEvent.VK_V);
	//click on enter
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
}

public String getUniqueName(String name)
{
	Random r=new Random();
	int num =r.nextInt(9999);
	name=name+num;
	return name;
}
}
