package alchemy_Pages;

import static org.testng.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BaseClass;
import org.testng.Assert;


public class Dashboard extends BaseClass{


	public Dashboard(WebDriver alcDriver){

		PageFactory.initElements(alcDriver, this);
	}
	@FindBy(xpath="//div[@class='body']/div/div/div[text()=' Branches ']")
	private WebElement branches_TAB;
	@FindBy(xpath="//span[text()='PER PAGE:']")
	public WebElement perpage;

	@FindBy(xpath = "//div[contains(@class,'percentage')]")
	    private WebElement anypercentage;
	 @FindBy(xpath = "//div[contains(@class,'percentage')]/parent::div/div")
	    private WebElement newmemberstext;
	 @FindBy(xpath = "//div[contains(@class,'percentage')]/parent::div/following-sibling::div[2]/div")
	    private WebElement kgrecycledtext;
	 @FindBy(xpath = "//div[contains(@class,'percentage')]/parent::div/following-sibling::div[7]/div")
	    private WebElement paidbonuskgtext;
	 
	 
	 public static String nmtext;
	 public static String kgrt;
	 public static String pbkgt;
	 
	 public static String nmtextafter;
	 public static String kgrtafter;
	 public static String pbkgtafter;

	@FindBy(xpath = "//div[text()=' Dashboard ']")
	public static WebElement dashBoard_tab;
	@FindBy(xpath = "//div[text()='KG by Country']/following::span[@class='total-price']")
	public static WebElement kgByCountry;
	@FindBy(xpath = "//div[text()='Tokens by Country in USD']/following::span[@class='total-price']")
	private WebElement tokensByCountry;
	@FindBy(xpath = "//div[text()='Tokens by Country in USD']/following::span[@class='total-price'][1]")
	private WebElement activeLocations;
	@FindBy(xpath = "//div[text()='Members by Country']/following::span[@class='total-price'][1]")
	private WebElement membersByCountry;
	@FindBy(xpath = "(//div[text()=' Philippines '])[4]/following::div")
	public static WebElement kgByPhilippines;
	public static int kgByCountryValue;
	public static int kgByPhilippinesValue;
	public static List<Integer> result = new ArrayList<>();

	public static void clickDashBoard() {
		WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(dashBoard_tab));
		dashBoard_tab.click();
	}
	public static List<Integer> checkKgByCountry() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(50));
		clickDashBoard();
		Thread.sleep(30000);
		Actions action =new Actions(alcDriver);
		action.scrollToElement(kgByCountry).build().perform();
		wait.until(ExpectedConditions.visibilityOf(kgByCountry));
		Thread.sleep(3000);
		String kgCountry = kgByCountry.getText();
		Thread.sleep(2000);
		TakesScreenshot ts11111 = (TakesScreenshot) alcDriver;
		byte[] screenshotsell1 = ts11111.getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("kgByCountry Screenshot", new ByteArrayInputStream(screenshotsell1));
		Thread.sleep(2000);

		action.scrollToElement(kgByPhilippines).build().perform();
		wait.until(ExpectedConditions.visibilityOf(kgByPhilippines));
		String kgPhilippines=kgByPhilippines.getText();
		Thread.sleep(2000);
		TakesScreenshot ts1111 = (TakesScreenshot) alcDriver;
		byte[] kgPhilippinesSC = ts1111.getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("kgPhilippines Screenshot", new ByteArrayInputStream(kgPhilippinesSC));
		Thread.sleep(2000);

		String stringWithoutCommas = kgCountry.replace(",", "");
		String stringWithoutCommasSpace = kgPhilippines.replace(",", "").replace(" ","");
		Thread.sleep(3000);
		//List<Integer> result = new ArrayList<>();

		kgByCountryValue = Integer.parseInt(stringWithoutCommas);
		System.out.println("!!!!"+kgByCountryValue);
		kgByPhilippinesValue = Integer.parseInt(stringWithoutCommasSpace);
		System.out.println("!!!!"+kgByPhilippinesValue);
		Thread.sleep(1000);
		result.add(kgByCountryValue);
		result.add(kgByPhilippinesValue);

		return result;

	}
	public void getmssaftertransaction() throws InterruptedException {
		 branches_TAB.click();
		 wait300.until(ExpectedConditions.visibilityOf(perpage));
		 dashBoard_tab.click();
		 wait300.until(ExpectedConditions.visibilityOf(anypercentage));
		 nmtextafter= newmemberstext.getText();
		 kgrtafter= kgrecycledtext.getText();
		 pbkgtafter= paidbonuskgtext.getText();
		 
		 takescreenshotof(paidbonuskgtext,"Increased Values of new member, kg recycled and paid bonus kg text after transaftion.");
		 
		 
		String nmtextafternc=	 nmtextafter.replace(",", "").replace(" ", "");
		 String nmtextnc = nmtext.replace(",", "").replace(" ", "");
		 
		 int nmTextAfterValue = Integer.parseInt(nmtextafternc);
		    int nmTextValue = Integer.parseInt(nmtextnc);
		    System.out.println("new members before:-- "+nmtextnc);
		    System.out.println("new members after:-- "+nmTextAfterValue);
		    assertTrue(nmTextAfterValue > nmTextValue);
		    
		    String kgrtnc = kgrt.replace(",", "").replace(" ", "");
		   String kgrtafternc= kgrtafter.replace(",", "").replace(" ", "");
		   System.out.println("kg recycled before:-- "+kgrtnc);
		   System.out.println("kg recycled after:-- "+kgrtafternc);
		    int kgrtafterValue = Integer.parseInt(kgrtafternc);
		    int kgrtValue = Integer.parseInt(kgrtnc);
		    assertTrue(kgrtafterValue > kgrtValue);

		   String pbkgtafternc= pbkgtafter.replace(",", "").replace(" ", "");
		String   pbkgtnc=pbkgt.replace(",", "").replace(" ", "");
		    int pbkgtafterValue = Integer.parseInt(pbkgtafternc);
		    int pbkgtValue = Integer.parseInt(pbkgtnc);
		    System.out.println("paid bonus kg before:-- "+pbkgtnc);
		    System.out.println("paid bonus kg after:-- "+pbkgtafternc);
		    assertTrue(pbkgtafterValue > pbkgtValue);

		 
		 
	 }
	public void getmssbeforetransaction() throws InterruptedException {
		 wait300.until(ExpectedConditions.visibilityOf(anypercentage));
		 nmtext= newmemberstext.getText();
		 kgrt= kgrecycledtext.getText();
		 pbkgt= paidbonuskgtext.getText();
		 takescreenshotof(paidbonuskgtext,"Values of new member, kg recycled and paid bonus kg text before transaftion.");
		 
	 }

}
