package smoke_suite;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.BaseClass;
import Utilities.Data;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Dashboard;
import alchemy_Pages.Orders;
import io.qameta.allure.Description;
import plastic_Bank_Pages.PB_LoginPage;
import plastic_Bank_Pages.PB_Transaction;

public class ALC_4957 extends BaseClass{
	@Test(priority=1,description="Get monthly snapshot before member to branch transaction.")
	@Description("Get monthly snapshot before member to branch transaction.")
	public void getmonthlyss() throws InterruptedException {
		AlchemyLoginPage loginAlchmey=new AlchemyLoginPage(alcDriver);
		loginAlchmey.alc_adminlogin("+17783844311","778778");
		Dashboard d= new Dashboard(alcDriver);
		d.getmssbeforetransaction();
	}
	
	@Test(priority=2,description="Create a member to branch transaction and approve it's bonus.")
	@Description("Create a member to branch transaction and approve it's bonus.")
	public void createtransaction() throws IOException, InterruptedException {
		Data d = new Data();
		d.runNewman4957();
		
		
	}
	@Test(priority=3, description="Get monthly snapshot of dashboard after approving bonus. ")
	@Description("Get monthly snapshot of dashboard after approving bonus. ")
     public void getmonthlyss2() throws InterruptedException {
		Dashboard d = new Dashboard(alcDriver);
		d.getmssaftertransaction();
	}
}
