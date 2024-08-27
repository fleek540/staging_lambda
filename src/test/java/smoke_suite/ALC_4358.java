package smoke_suite;

import Utilities.BaseClass;
import Utilities.Data;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Branches;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import plastic_Bank_Pages.PB_LoginPage;
import plastic_Bank_Pages.PB_Register_CollectionPoint;
import plastic_Bank_Pages.PB_Register_Member;
import plastic_Bank_Pages.PB_Transaction;
import org.openqa.selenium.JavascriptExecutor;


import java.io.IOException;

public class ALC_4358 extends BaseClass {


    @Test(priority =0,enabled=true, description = "-New member can be successfully created in app | -New member account is searchable in Alchemy under the 'Members' section")
    @Description("Add Branch and Create Member and LogOut")
    public void createSplitBranchAndAddMember() throws InterruptedException, IOException {
try{
        AlchemyLoginPage loginAlchmey=new AlchemyLoginPage(alcDriver);
        loginAlchmey.alc_adminlogin("+17783844311","778778");

        PB_Register_Member rm = new PB_Register_Member(pbDriver);
        rm.clickSignUpButton();
        PB_Register_CollectionPoint branchCreate=new PB_Register_CollectionPoint(pbDriver);
        branchCreate.createSplitBranch(PB_Register_CollectionPoint.splitBranchName1);
        System.out.println(PB_Register_CollectionPoint.splitBranchName1);
        Thread.sleep(2000);
        branchCreate.addMemberToCreatedSplitBranch1();
        Thread.sleep(2000);
        branchCreate.addMemberToCreatedSplitBranch2();
    
 ((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a passed test \"}} ");
	        
		}catch(Exception e) {
			((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a failed test \"}} ");
	        
		}

    }

    @Test(priority =1,enabled=true, description = "Disable one Branch in App")
    @Description("Create Non Split Branch and a Processor")
    public void disableBranchInApp() throws InterruptedException, IOException {
try{
        PB_Register_CollectionPoint branchCreate=new PB_Register_CollectionPoint(pbDriver);
        branchCreate.toggleOffMember();

        PB_Register_Member pbRegMem=new PB_Register_Member(pbDriver);
        pbRegMem.logoutb();
 ((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a passed test \"}} ");
	        
		}catch(Exception e) {
			((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a failed test \"}} ");
	        
		}
    }

    @Test(priority =2,enabled=true, description = "Create Non Split Branch and a Processor")
    @Description("Create Non Split Branch and a Processor")
    public void createNonSplitBranchAndProcessor() throws InterruptedException, IOException {

        Data d = new Data();
        d.createBranchProcessor_4358();

    }

    @Test(priority =3,enabled=true,description = "Do Transaction between Split Branch and regular Branch and Verify Bonus and Kg Transferred")
    @Description("Do Transaction between Split Branch and Regular Branch and Verify Bonus and Kg Transferred")
    public void transaction_SplitBranch_NormalBranch() throws InterruptedException {
try{
        PB_Transaction t3=new PB_Transaction(pbDriver);
        PB_LoginPage lo =new PB_LoginPage(pbDriver);
        lo.login(Data.branch1_Number4358.replace("+63", ""), password,"+63");
        //lo.login("+636849667347".replace("+63", ""), password,"+63");
        t3.bToSb("+63"+PB_Register_CollectionPoint.typedNumberforsplitbranch);
        //t3.bToSb("+6334763968");
        Thread.sleep(4000);
        lo.logout();
 ((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a passed test \"}} ");
	        
		}catch(Exception e) {
			((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a failed test \"}} ");
	        
		}
    }

    @Test(priority =4,enabled=true,description = "Verify the Branch Exchange History for Split Branch In Alchemy")
    public void verifyInAlchemy() throws InterruptedException {
try{
        Branches br=new Branches(alcDriver);
        br.splitBranchVerify("+63"+PB_Register_CollectionPoint.typedNumberforsplitbranch);
((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "passed");
		
		}catch(Exception e) {
			((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "failed");
		}
    }

    @Test(priority =5,enabled=true,description = "Do Transaction between Regular Branch and Processor")
    @Description("Do Transaction between Split Branch and Regular Branch and Verify Bonus and Kg Transferred")
    public void transactionProcessorBranch() throws InterruptedException {
try{
        PB_Transaction t3 = new PB_Transaction(pbDriver);
        PB_LoginPage lo =new PB_LoginPage(pbDriver);
        lo.login(Data.processor_Number4358.replace("+63", ""), password,"+63");
        t3.bToSP(Data.branch1_Number4358);
 ((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a passed test \"}} ");
	        
		}catch(Exception e) {
			((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a failed test \"}} ");
	        
		}
    }

}
