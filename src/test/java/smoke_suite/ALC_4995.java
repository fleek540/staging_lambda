package smoke_suite;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.BaseClass;
import Utilities.Data;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Members;
import alchemy_Pages.Processors;
import io.qameta.allure.Description;
import plastic_Bank_Pages.PB_LoginPage;
import plastic_Bank_Pages.PB_Member_Profile;
import org.openqa.selenium.JavascriptExecutor;


public class ALC_4995 extends BaseClass{
	@Test(priority=1, description="Create a processor.")
	@Description("Create a processor.")
	public void createstore() throws IOException {
		Data d= new Data();
		d.createProcessor();
	}
	
	
	
	@Test(priority=2, description="Send 1000 tokens to the newly created processor")
	@Description("Send 1000 tokens to the newly created processor")
	public void sendtokenstobranch() throws InterruptedException {
		try{
		AlchemyLoginPage loginAlchmey=new AlchemyLoginPage(alcDriver);
		loginAlchmey.alc_adminlogin("+17783844311","778778");
		Processors p = new Processors(alcDriver);
		p.sendtokenstoprocessor(Data.processorNumber);  
		((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "passed");
		
		}catch(Exception e) {
			((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "failed");
		}	
	}
	
	@Test(priority=3, description="Verify newly transfered tokens are visble in the processor account wallet in app.")
	@Description("Verify newly transfered tokens are visble in the processor account wallet in app.")
	public void verifytokensinapp() throws InterruptedException {
		try{
		PB_LoginPage pl = new PB_LoginPage(pbDriver);
		pl.login(Data.processorNumber.replace("+63", ""),"123456a","+63");
		PB_Member_Profile pmp = new PB_Member_Profile(pbDriver);
		pmp.verifytokensarepresentprocessor();
		 ((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a passed test \"}} ");
	        
		}catch(Exception e) {
			((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a failed test \"}} ");
	        
		}
	}
	@Test(priority = 4, description="Reclaim the 1000 tokens from store account on alchemy.")
	@Description("Reclaim the 1000 tokens from store account on alchemy.")
	public void reclaimtokens() {
		try{
		Members m = new Members(alcDriver);
		m.reclaimtokens();
		((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "passed");
		
		}catch(Exception e) {
			((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "failed");
		}	
	}
	@Test(priority=5, description="Verify reclaimed tokens are not present in the processor account wallet in app.")
	@Description("Verify reclaimed tokens are not present in the processor account wallet in app.")
	public void verifytokensnotinapp() throws InterruptedException {
		try{
		PB_LoginPage pl = new PB_LoginPage(pbDriver);
		pl.logout();
		PB_LoginPage pl1 = new PB_LoginPage(pbDriver);
		pl1.login(Data.processorNumber.replace("+63", ""),"123456a","+63");
		PB_Member_Profile pmp = new PB_Member_Profile(pbDriver);
		pmp.verifytokensarenotpresentprocessor();
		((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a passed test \"}} ");
	        
		}catch(Exception e) {
			((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a failed test \"}} ");
	        
		}	
	}
}
