package smoke_suite;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import Utilities.BaseClass;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Country_Settings;
import alchemy_Pages.Members;
import alchemy_Pages.Reports;
import io.qameta.allure.Description;
import plastic_Bank_Pages.PB_LoginPage;
import plastic_Bank_Pages.PB_Member_Profile;

public class ALC_4871 extends BaseClass{
	@Test(priority=0, description="Ensure that GCash is turned on in country settings for Philippines "
			+ "and a valid Philippines account linked to GCash having tokens in wallet exists.")
	@Description("Ensure that GCash is turned on in country settings for Philippines and a valid "
			+ "Philippines account linked to GCash having tokens in wallet exists.")
	public void preconditions() throws InterruptedException {
		try {
		AlchemyLoginPage loginAlchmey=new AlchemyLoginPage(alcDriver);
		loginAlchmey.alc_adminlogin("+17783844311","778778");
		Country_Settings cs = new Country_Settings(alcDriver);
		cs.ensureDigitalCashOutToggleIsOn("philippines");
		Members m= new Members(alcDriver);
		m.ensureMemberIsPresentWithTokens("+639665849014", "fleek GCash account", "9665849014", Members.philippines, "602");
((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "passed");
		
		}catch(Exception e) {
			((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "failed");
		}
		}
	@Test(priority=1, description="Login with existing account and perform GCASH Transaction.")
	@Description("Login with existing account and perform GCASH Transaction.")
	public void gCashTransaction() throws IOException, InterruptedException {
		try {
		PB_LoginPage pl = new PB_LoginPage(pbDriver);
		pl.login("9665849014","123456a","+63");
		PB_Member_Profile pmp = new PB_Member_Profile(pbDriver);
		Thread.sleep(5000);
		pmp.menu.click();
		tap(400,480);
		pmp.performDigitalCashOutCollector();
		pmp.checkexhistory4871();
		pmp.unlinkgcash4871();
		PB_LoginPage lp =new PB_LoginPage(pbDriver);
		lp.logoutmem();
		((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a passed test \"}} ");
        
		}catch(Exception e) {
			((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a failed test \"}} ");
	        
		}
	}
	@Test(priority=2, description="Ensure that tokens have deducted and after deduction same tokens are "
			+ "present in member wallet on both Alchemy and app.")
	@Description("Ensure that tokens have deducted and after deduction same tokens are present"
			+ " in member wallet on both Alchemy and app.")
	public void checktokens() throws InterruptedException {
		try {
		Reports r = new Reports(alcDriver);
		r.transactionStatusInAlchemyReportsforgcash();
		Members m = new Members(alcDriver);
		m.compareAlchemyAndAppTokens("+639665849014");
((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "passed");
		
		}catch(Exception e) {
			((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "failed");
		}
	}
	@Test(priority=3,description="Unverified member should not be able to perform gojek transaction and get error message.")
	@Description("Unverified member should not be able to perform gojek transaction and get error message.")
	public void checkforunverifiednum() throws InterruptedException {
		try {
		Members m= new Members(alcDriver);
		m.createRandomMemberWithTokens(Members.philippines, "+63", "1000");
((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "passed");
		
		}catch(Exception e) {
			((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "failed");
		}
		try {
		PB_LoginPage pl = new PB_LoginPage(pbDriver);
		pl.login(Members.rnewnum,"123456a","+63");
		PB_Member_Profile pmp = new PB_Member_Profile(pbDriver);
		pmp.prove_Unverified_Cant_Use_GCash();
		 ((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a passed test \"}} ");
	        
		}catch(Exception e) {
			((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a failed test \"}} ");
	        
		}
		
	}
}
