package cms_Suite;

import Utilities.BaseClass;
import alchemy_Pages.AlchemyLoginPage;
import impactHub_Pages.impactHubHomePage;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ALC_5507 extends BaseClass {

    @Test(priority = 0,description =" Login ")
    public void Login() throws InterruptedException, IOException {


        AlchemyLoginPage login=new AlchemyLoginPage(alcDriver);
        login.alc_adminlogin("+17783844311","778778");

    }
    @SuppressWarnings("deprecation")
	@Test(priority = 1,description =" Verify If Location Is visible  ")
    public void verifyLocation() throws InterruptedException, IOException {

        alcDriver.get("https://qa-impact.cognitionfoundry.io/postprodchecks/dashboard/page/home");

        try {
            alcDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AlchemyLoginPage login = new AlchemyLoginPage(alcDriver);
            login.loginImpactHub("ashish.rawat@fleekitsolutions.com", "123456a");
            impactHubHomePage ihp = new impactHubHomePage(alcDriver);
            ihp.verifyLocation();
            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        catch(Exception e) {

            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            impactHubHomePage ihp = new impactHubHomePage(alcDriver);
            ihp.verifyLocation();
        }

    }





}
