package smoke_suite;

import org.testng.annotations.Test;

import Utilities.BaseClass;
import alchemy_Pages.Impact_Hub;
import io.qameta.allure.Description;

public class ALC_5161 extends BaseClass{
	@Test(priority=0, description="Run combined")
	@Description("Run combined.")
    public void combined() throws InterruptedException {
		Impact_Hub ih=new Impact_Hub(alcDriver);
   ih.ih5161();
}
}