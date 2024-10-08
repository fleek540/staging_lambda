package smoke_suite;

import Utilities.ScreenshotListener;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;


import Utilities.BaseClass;
import Utilities.Data;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Processors;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.testng.AllureTestNg;
import plastic_Bank_Pages.PB_LoginPage;
import plastic_Bank_Pages.PB_Register_Processor;

@Listeners({AllureTestNg.class, ScreenshotListener.class})
public class ALC_4354 extends BaseClass {

	@Test(priority =0, description = "New Processor account should be successfully created")
	@Description("Create Processor with already Created Branch")
	public void createProcessor() throws InterruptedException, IOException {
		
		Data d = new Data();
		d.createMember4864();
		System.out.println("Create Processor with already Created Branch");
		PB_LoginPage l=new PB_LoginPage(pbDriver);
		l.login(Data.member_Number4864.replace("+63", ""),"123456a","+63");
		PB_Register_Processor cbp =new PB_Register_Processor(pbDriver);
		cbp.createprocessoraftermember();
			teststatus=true;
	}
	@Test(priority =1, description = "New processor account is searchable in Alchemy under the 'Processor' section | -Changes are saved and can be seen in user details")
	@Description("Search and Edit Processor In Alchmey")
	public void seacrchAndEditProcessorInAlchmey() throws InterruptedException {

		System.out.println("Search and Edit Processor In Alchmey");
		AlchemyLoginPage alp = new AlchemyLoginPage(alcDriver);
		alp.alc_adminlogin(adminphoneNumber, adminpassword);
		Processors apt = new Processors(alcDriver);
		System.out.println(Data.member_Number4864);
		apt.SearchAndEditProcessorInAlchemy(Data.member_Number4864);
		teststatus=true;
	}
	@Test(priority =2, description = "User should see the updated data")
	@Description("Login In app and Verify")
	public void VerifyInApp() throws InterruptedException {

		System.out.println("Login In app and Verify");
		Thread.sleep(2000);
		PB_LoginPage l=new PB_LoginPage(pbDriver);
		l.login(Data.member_Number4864.replace("+63", ""),"123456a","+63");
		l.menu();
		tap(400,580);
		tap(140,2085);
		tap(60,155);
		tap(330,1390);	
	
	}
	
	@Test(priority=3,description="Create processor from sign up page directly")
	@Description("Create processor from sign up page directly")
	public void createprocessorfromsignuppage() throws InterruptedException {
		
		PB_Register_Processor cbp =new PB_Register_Processor(pbDriver);
		cbp.createprocessordirectly();
		teststatus=true;
	}
	
	@Test(priority=4,description="Edit details in alchemy for this processor")
	@Description("Edit details in alchemy for this processor")
	public void edit() throws InterruptedException {
	
		Processors apt = new Processors(alcDriver);
		apt.SearchAndEditProcessorInAlchemy("+63"+PB_Register_Processor.typedNumber);
		teststatus=true;
	}
	@Test(priority=5,description="Check edited details in app after logging in")
	@Description("Check edited details in app after logging in")
	public void check() throws InterruptedException {
		
		PB_LoginPage l=new PB_LoginPage(pbDriver);
		l.login(PB_Register_Processor.typedNumber,"123456a","+63");
		l.menu();
		tap(400,580);
		tap(140,2085);
		tap(60,155);
		tap(330,1390);	
		teststatus=true;	
	}

}
