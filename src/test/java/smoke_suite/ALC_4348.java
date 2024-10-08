package smoke_suite;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;


import Utilities.BaseClass;
import Utilities.BaseClass2;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Description;
import plastic_Bank_Pages.PB_LoginPage;
import plastic_Bank_Pages.PB_LoginPage2;
import plastic_Bank_Pages.PB_Register_Member;
import plastic_Bank_Pages.PB_Register_Member2;

public class ALC_4348 extends BaseClass2{
	@Test(priority = 0, description="User not able to sign up if he tries to sign up within 3 minutes of first sign up.")
	@Description("User not able to sign up if he tries to sign up within 3 minutes of first sign up.")
	public void verifyUserCanNot() throws InterruptedException {
		
		PB_Register_Member2 pbsignup= new PB_Register_Member2(pbDriver);
		pbsignup.signUpCollector();
		PB_LoginPage pb= new PB_LoginPage(pbDriver);
		pb.logoutmem();
		pbsignup.signUpButton.click();
		pbsignup.chooseCollectorPannel();
		Thread.sleep(2000);
		pbsignup.image.click();
		Thread.sleep(2000);
		tap(550,2010);
		pbsignup.shutter.click();
		pbsignup.photoDone.click();
		tap(550,2054);
		Thread.sleep(2000);
		pbsignup.edittexts.get(1).sendKeys("Mainak "+RandomStringUtils.randomAlphabetic(5));
		Thread.sleep(1000);
		pbsignup.images.get(3).click();
		pbsignup.searchcountries.sendKeys("+63");
		Thread.sleep(2500);
		pbsignup.firstresult.click();
		Thread.sleep(4000);
		pbsignup.edittexts.get(3).click();
		Thread.sleep(5000);
		pbsignup.typeRandomDigit();
		pbsignup.typeRandomDigit();
		pbsignup.typeRandomDigit();
		pbsignup.typeRandomDigit();
		pbsignup.typeRandomDigit();
		pbsignup.typeRandomDigit();
		pbsignup.typeRandomDigit();
		pbsignup.typeRandomDigit();
		pbsignup.typeRandomDigit();
		pbDriver.pressKey(new KeyEvent(AndroidKey.BACK));
		pbsignup.edittexts.get(4).click();
		Thread.sleep(2000);
		
		scroll(820,905,820,1285);
		Thread.sleep(4000);
		pbsignup.done.click();
		pbsignup.gender.click();
		pbsignup.male.click();
		scroll(500,2100,500,1555);
		pbsignup.edittexts.get(5).sendKeys("123456a");
		pbsignup.edittexts.get(6).sendKeys("123456a");
		pbsignup.images.get(5).click();
		pbsignup.register.click();
		
		takescreenshotofandroid("Registration failed if tried within 3 minutes since previous registration");
		teststatus=true;
	}
	
	@Test(priority =1, description="User able to sign up again if he tries after 3 minute window.")
	@Description("User able to sign up again if he tries after 3 minute window.")
	public void verifyUserCanAfter3Min() throws InterruptedException {
		
		PB_Register_Member2 pbsignup= new PB_Register_Member2(pbDriver);
		Thread.sleep(180000);
		pbsignup.register.click();
		WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(300));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(pbsignup.codesent)));
		pbsignup.codesent.isDisplayed();
		takescreenshotofandroid("Registration successful if tried after 3 minutes since previous registration");
		
		PB_LoginPage2 pb= new PB_LoginPage2(pbDriver);
		Thread.sleep(5000);
		pb.logoutmem();
		teststatus=true;	
	}

}
