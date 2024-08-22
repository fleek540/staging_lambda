package smoke_suite;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;


import Utilities.BaseClass;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Description;
import plastic_Bank_Pages.PB_Register_Member;

public class ALC_4349 extends BaseClass{
	@Test(priority=0,description="Password criteria displayed if not met by user.")
	@Description("Password criteria displayed if not met by user.")
	public void verifypasswordcriteria() throws InterruptedException {
		try{
		PB_Register_Member pbsignup= new PB_Register_Member(pbDriver);
		pbsignup.clickSignUpButton();
		pbsignup.chooseCollectorPannel();
		scroll(500,2000,500,1500);
		pbsignup.edittexts.get(5).click();
		pbDriver.pressKey(new KeyEvent(AndroidKey.H));
		pbDriver.pressKey(new KeyEvent(AndroidKey.K));
		pbDriver.pressKey(new KeyEvent(AndroidKey.H));
		pbDriver.pressKey(new KeyEvent(AndroidKey.F));
		
		pbDriver.pressKey(new KeyEvent(AndroidKey.BACK));
		tap(500,1658);
		pbsignup.pwdcriteria.isDisplayed();
		Thread.sleep(1000);
		 ((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a passed test \"}} ");
	        
		}catch(Exception e) {
			((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a failed test \"}} ");
	        
		}
		
	}

}
