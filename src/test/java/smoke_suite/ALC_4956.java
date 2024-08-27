package smoke_suite;
import java.io.IOException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utilities.BaseClass;
import Utilities.Data;
import Utilities.ScreenshotListener;
import io.qameta.allure.Description;
import io.qameta.allure.testng.AllureTestNg;
import plastic_Bank_Pages.PB_LoginPage;
import plastic_Bank_Pages.PB_Menu_Options;
import org.openqa.selenium.JavascriptExecutor;


@Listeners({AllureTestNg.class, ScreenshotListener.class})

public class ALC_4956 extends BaseClass{
	@Test(priority = 1, description="Create a valid member.")
	@Description("Create a valid member.")
    public void createmember() throws IOException {
		Data d = new Data();
		d.createMember4864();
	}
	@Test(priority=2, description="Login with newly created member and change password in settings.")
	@Description("Login with newly created member and chnage password in settings.")
	public void changepassword() throws InterruptedException {
		try{
		PB_LoginPage login= new PB_LoginPage(pbDriver);
		login.login(Data.member_Number4864.replace("+63", ""), "123456a","+63");
		PB_Menu_Options mo=  new PB_Menu_Options(pbDriver);
		mo.changepw();
			 ((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a passed test \"}} ");
	        
		}catch(Exception e) {
			((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a failed test \"}} ");
	        
		}
	}
	@Test(priority=2, description="Login with new password")
	@Description("Login with new password")
	public void loginWithNewPassword() throws InterruptedException {
		try{
		PB_LoginPage login= new PB_LoginPage(pbDriver);
		login.login(Data.member_Number4864.replace("+63", ""), "123456ab","+63");
		
		 ((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a passed test \"}} ");
	        
		}catch(Exception e) {
			((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a failed test \"}} ");
	        
		}
	}
}
