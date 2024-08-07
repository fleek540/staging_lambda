package smoke_suite;

import org.testng.annotations.Test;

import Utilities.BaseClass;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Impact_Hub;
import io.qameta.allure.Description;

public class ALC_5160 extends BaseClass{
	@Test(priority=0, description="Run combined")
	@Description("Run combined.")
    public void combined() throws InterruptedException {
		AlchemyLoginPage loginAlchmey=new AlchemyLoginPage(alcDriver);
		loginAlchmey.alc_adminlogin("+17783844311","778778");
   Impact_Hub ih=new Impact_Hub(alcDriver);
   ih.ih5160();
}
}
