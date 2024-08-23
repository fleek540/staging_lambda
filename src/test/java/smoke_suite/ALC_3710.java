package smoke_suite;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;


import Utilities.BaseClass;
import Utilities.ScreenshotListener;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Country_Settings;
import alchemy_Pages.Members;
import alchemy_Pages.Reports;
import io.qameta.allure.Description;
import io.qameta.allure.testng.AllureTestNg;
import plastic_Bank_Pages.PB_LoginPage;
import plastic_Bank_Pages.PB_Member_Profile;

@Listeners({AllureTestNg.class, ScreenshotListener.class})
public class ALC_3710 extends BaseClass{

	@Test(priority=0, description="Ensure that Gojek is turned on in country settings for Indonesia "
			+ "and a valid Indonessian account linked to gojek having tokens in wallet exists.")
	@Description("Ensure that Gojek is turned on in country settings for Indonesia and a valid "
			+ "Indonessian account linked to gojek having tokens in wallet exists.")
	public void preconditions() throws InterruptedException {
		try{
		AlchemyLoginPage loginAlchmey=new AlchemyLoginPage(alcDriver);
		loginAlchmey.alc_adminlogin("+17783844311","778778");
		Country_Settings cs = new Country_Settings(alcDriver);
		cs.ensureDigitalCashOutToggleIsOn("indonesia");
		Members m= new Members(alcDriver);
		m.ensureMemberIsPresentWithTokens("+628123450000", "fleek gojek account", "8123450000", Members.indonesia, "10");
	((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "passed");
		
		}catch(Exception e) {
			((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "failed");
		}		
	}
	@Test(priority=1, description="Login with existing account and perform Gojek Transaction.")
	@Description("Login with existing account and perform Gojek Transaction.")
	public void gojekTransaction() throws IOException, InterruptedException {
		try{
		PB_LoginPage pl = new PB_LoginPage(pbDriver);
		pl.login("8123450000","123456a","+62");
		PB_Member_Profile pmp = new PB_Member_Profile(pbDriver);
		
		pmp.performDigitalCashOut();
	 ((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a passed test \"}} ");
	        
		}catch(Exception e) {
			((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a failed test \"}} ");
	        
		}		
	}
	@Test(priority=2, description="Ensure that transaction status in reports is completed and "
			+ "member on both alchemy along with the app has same number of tokens."
			+ "Ensure that Gojek accounts can be unlinked")
	@Description("Ensure that transaction status in reports is completed and member "
			+ "on both alchemy along with the app has same number of tokens."
			+ "Ensure that Gojek accounts can be unlinked")
	public void checktokens() throws InterruptedException {
		try{
		Reports r = new Reports(alcDriver);
		r.transactionStatusInAlchemyReports();
		Members m = new Members(alcDriver);
		m.compareAlchemyAndAppTokens("+628123450000");
		PB_Member_Profile pmp = new PB_Member_Profile(pbDriver);
		pmp.checkexhistory();
		pmp.unlink();
			 ((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a passed test \"}} ");
	        
		}catch(Exception e) {
			((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a failed test \"}} ");
	        
		}
		
	}
	@Test(priority=3,description="Unverified member should not be able to perform gojek transaction and get error message.")
	@Description("Unverified member should not be able to perform gojek transaction and get error message.")
	public void checkforunverifiednum() throws InterruptedException {
		try{
		Members m= new Members(alcDriver);
		m.createRandomMemberWithTokens(Members.indonesia, "+62", "1000");
		
((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "passed");
		
		}catch(Exception e) {
			((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "failed");
		}		
		try {
		PB_LoginPage pl = new PB_LoginPage(pbDriver);
		pl.login(Members.rnewnum,"123456a","+62");
		PB_Member_Profile pmp = new PB_Member_Profile(pbDriver);
		pmp.prove_Unverified_Cant_Use_Gojek();
		 ((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a passed test \"}} ");
	        
		}catch(Exception e) {
			((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a failed test \"}} ");
	        
		}
	}
	
}
