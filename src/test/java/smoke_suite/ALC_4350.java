package smoke_suite;

import Utilities.ScreenshotListener;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Listeners;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Test;

import Utilities.BaseClass;
import Utilities.Data;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Members;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import plastic_Bank_Pages.PB_LoginPage;
import plastic_Bank_Pages.PB_Register_CollectionPoint;
import plastic_Bank_Pages.PB_Register_Member;
import plastic_Bank_Pages.PB_Transaction;

//ALC-4350 = In App, Member - Create , new user login, edit, check in Alchemy to confirm new user exists , suspend account

@Listeners({AllureTestNg.class, ScreenshotListener.class})
public class ALC_4350 extends BaseClass {


	@Test(priority=0, description = "New member account should be successfully created | New member should be successfully logged in")
	@Description("Signing up a member and Login Verification and Logout")
	public void signUp()throws InterruptedException {
		try{
		System.out.println("Signing up a member and Login Verification and Logout");
		PB_Register_Member pbsignup= new PB_Register_Member(pbDriver);
		pbsignup.signUpCollector();
		Thread.sleep(3000);
		
		pbsignup.logout();	
		PB_LoginPage pblogin = new PB_LoginPage(pbDriver);
		pblogin.login(PB_Register_Member.typedNumber,password,"+63");
		Thread.sleep(5000);
			pblogin.logoutmem();
			 ((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a passed test \"}} ");
	        
		}catch(Exception e) {
			((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a failed test \"}} ");
	        
		}
		
	}

	@Test(priority = 1, description = "Login on alchemy with admin user")
	@Description("Alchmey Login")
	public void loginAlchmey() throws InterruptedException {
		try{
		System.out.println("Alchmey Login");
		AlchemyLoginPage loginAlchmey=new AlchemyLoginPage(alcDriver);
		loginAlchmey.alc_adminlogin("+17783844311","778778");
		Thread.sleep(3000);
		((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "passed");
		
		}catch(Exception e) {
			((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "failed");
		}
	}
	@Test(priority =2, description = "New member account is searchable in Alchemy under the 'Members' section")
	@Description("Verification of member in Alchmey")
	public void VerifyMemberAlchmey() throws InterruptedException {
		try{
		System.out.println("Verification of member in Alchmey");
		
		Members alc_mem =new Members(alcDriver);
		alc_mem.selectAndverifyMember("+63"+PB_Register_Member.typedNumber);
		Thread.sleep(5000);
			((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "passed");
		
		}catch(Exception e) {
			((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "failed");
		}
	}

	@Test(priority =3, description = "-New member can be successfully created in app | -New member account is searchable in Alchemy under the 'Members' section")
	@Description("Add Branch and Create Member and LogOut")
	public void createBranchAndMember() throws InterruptedException, IOException {
		try{
		System.out.println("Add Branch and Create Member and LogOut");
		Data d = new Data();
		d.createBranch();
		PB_Register_CollectionPoint branchCreate=new PB_Register_CollectionPoint(pbDriver);
		PB_LoginPage pblogin = new PB_LoginPage(pbDriver);
		pblogin.login(Data.branchNumber.replace("+63", ""),password,"+63");
		branchCreate.addMemberToCreatedBranch();
		Thread.sleep(5000);
		PB_Register_Member pbRegMem=new PB_Register_Member(pbDriver);
		pbRegMem.logoutb();	
		 ((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a passed test \"}} ");
	        
		}catch(Exception e) {
			((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a failed test \"}} ");
	        
		}	
	}

	@Test(priority=4, description = "- Data displayed in user will turn into a field that can be edited | -Changes are saved and can be seen in user details")
	@Description("Edit the branch member details in Alchmey")
	public void EditMemberDetails() throws InterruptedException {
		try{
		System.out.println("Edit the branch member details in Alchmey");
		Members mem=new Members(alcDriver);
		mem.editMemberDetails("+63"+PB_Register_Member.typedNumber,"Gayas Khan");
		((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "passed");
		
		}catch(Exception e) {
			((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "failed");
		}	
	}
	@Test(priority=5, description = "User should see the updated data")
	@Description("Login in App with Branch Member Details")
	public void loginBranchMemberPB() throws InterruptedException {
		try{
		System.out.println("Login in App with Branch Member Details");
		PB_LoginPage lp =new PB_LoginPage(pbDriver);
		lp.login(PB_Register_Member.typedNumber, password,"+63");
		Thread.sleep(5000);
		
		PB_Register_Member pbRegMem=new PB_Register_Member(pbDriver);
		pbRegMem.logout();
		 ((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a passed test \"}} ");
	        
		}catch(Exception e) {
			((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a failed test \"}} ");
	        
		}	
	}
	@Test(priority=6, description = "-A pop up confirmation will appear and ask user if they are sure to suspend the account | - Once confirming, user should have suspend checkbox checked")
	@Description("Suspend Member in Alchmey")
	public void suspendMemberALC() throws InterruptedException {
		try{
		System.out.println("Suspend Member in Alchmey");
		Members mem=new Members(alcDriver);
		System.out.println("Suspending this member "+"+63"+PB_Register_Member.typedNumber);
		mem.suspendMember("+63"+PB_Register_Member.typedNumber);
		Thread.sleep(4000);
		 ((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a passed test \"}} ");
	        
		}catch(Exception e) {
			((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a failed test \"}} ");
	        
		}	
	}
	@Test(priority=7, description = "User should not be able to login because account was suspended")
	@Description("Login in Mobile app with Suspended Member details")
	public void memberSuspendVerify() throws InterruptedException {
		try{
		System.out.println("Login in Mobile app with Suspended Member details");
		PB_LoginPage lp =new PB_LoginPage(pbDriver);
		lp.login(PB_Register_Member.typedNumber,password,"+63");
		PB_Register_CollectionPoint cp = new PB_Register_CollectionPoint(pbDriver);
		cp.verifysuspendedmember();
		 ((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a passed test \"}} ");
	        
		}catch(Exception e) {
			((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a failed test \"}} ");
	        
		}
		
			
	}
	@Test(priority=8, description = "Suspended member should not appear in the search")
	@Description("Verify Suspended member By Branch Login")
	public void branchSuspendMemberVerification() throws InterruptedException {
	try{
		System.out.println("Verify Suspended member By Branch Login");
		Thread.sleep(3000);
		PB_LoginPage lp = new PB_LoginPage(pbDriver);
		lp.login(Data.branchNumber.replace("+63", ""),password,"+63");
		Thread.sleep(2000);
		PB_Transaction pt = new PB_Transaction(pbDriver);
		
		pt.verifyaddedmemsuspended("+63"+PB_Register_Member.typedNumber);
		Thread.sleep(2000);
	   
		 ((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a passed test \"}} ");
	        
		}catch(Exception e) {
			((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a failed test \"}} ");
	        
		}
		
	}
}
