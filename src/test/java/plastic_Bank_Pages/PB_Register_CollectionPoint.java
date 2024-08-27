package plastic_Bank_Pages;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Allure;

public class PB_Register_CollectionPoint extends BaseClass {
	
public PB_Register_CollectionPoint(AndroidDriver pbDriver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(pbDriver), this);
	}
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign up\")")
public WebElement signUpButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Log in\")")
public WebElement loginButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Logout\")")
public WebElement logoutButton;
@AndroidFindBy(xpath= "//android.widget.EditText")
public WebElement searchcountries;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Settings\")")
public WebElement settingsButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"menu\")")
public WebElement menuButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"back\")")
public WebElement back;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
public WebElement phoneNumberTextFeild;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(1)")
public WebElement passwordTextFeild;
@AndroidFindBy(id= "org.plasticbank.app:id/action_bar_root")
public WebElement loadedPage;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"While using the app\")")
public WebElement permission;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Allow\")")
public WebElement allow;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Finish\")")
public WebElement finishButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Create Business\")")
public WebElement createBusinessButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Recycling Business\")")
public WebElement recyclingBusinessPanel;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Collection Point\")")
public WebElement collectionPointPanel;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"CREATE BUSINESS\")")
public WebElement createBUSINESSbutton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Add member\")")
public WebElement addmember;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"camera\")")
public WebElement cameraButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Take a picture\")")
public WebElement takeA_PictureOption;
@AndroidFindBy(xpath= "//android.widget.ImageButton[@content-desc=\"Take photo\"]")
public WebElement shutter;
@AndroidFindBy(xpath= "//android.widget.ImageButton[@content-desc=\"Done\"]")
public WebElement photoDone;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"confirm\")")
public WebElement confirmButton;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").instance(0)")
public WebElement crossButton;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Image\")")
public List<WebElement> images;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Register\")")
public WebElement register;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Recycling business\")")
public WebElement recyclingbusiness;
@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Ashish\")")
public WebElement updatedname;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Add new material\")")
public WebElement addnewmaterial;
@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"kg\")")
public WebElement kg;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Save material\")")
public WebElement savematerial;

@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Collection point\")")
public WebElement collectionpoint;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Re-send\")")
public WebElement resend;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Link account\")")
public WebElement linkaccount;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
public WebElement businessNameTextField;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
public WebElement addressTextField;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(0)")
public WebElement mondayCheckBox;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(1)")
public WebElement tuesdayCheckBox;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(2)")
public WebElement wednesdayCheckBox;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(3)")
public WebElement thursdayCheckBox;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Community program\")")
public WebElement communityProgram;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(4)")
public WebElement fridayCheckBox;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(5)")
public WebElement saturdayCheckBox;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(6)")
public WebElement sundayCheckBox;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Save\")")
public WebElement saveButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"OK\")")
public WebElement OKButton;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
public WebElement cashValuePerKgTextField;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
public WebElement currentInventoryTextField;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Add\")")
public WebElement addButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"DONE\")")
public WebElement doneButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Next\")")
public WebElement nextButton;
@AndroidFindBy(id = "tab-t1-2")
public WebElement membersTab;
@AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.EditText\")")
public List<WebElement> edittexts;
@AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.Image\").instance(0)")
public WebElement image;
@AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.Image\").instance(2)")
public WebElement tickimage;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Clear\")")
public WebElement colorClear;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Manage community\")")
public WebElement manageCommunityButton;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
public WebElement branchMemberNameTextField;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
public WebElement branchMemberPhoneNumberTextField;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Gender\")")
public WebElement genderButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Male\")")
public WebElement maleOption;
@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Loading\")")
public WebElement loading;
@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Account Suspended\")")
public WebElement susmem;
@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"OK\")")
public WebElement ok;
@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Home\")")
public WebElement home;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"School Program\")")
public WebElement schoolProgram;
@AndroidFindBy(uiAutomator="new UiSelector().text(\"search outline\")")
public WebElement searchOutline;
@AndroidFindBy(uiAutomator="new UiSelector().text(\"Start their exchange\")")
public WebElement startexchange;
@AndroidFindBy(uiAutomator="new UiSelector().text(\"Your transaction was not recorded due to an error. Please try again. User has been suspended.\")")
public WebElement suspendedaddedmem;
@AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"(?i)Track a Donation\")")
public WebElement chooseDonation;
@AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.EditText\").instance(0)")
public WebElement search;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"REGISTER MEMBER\")")
public WebElement registerUser;
@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"rocess\")")
public WebElement processor;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Show year picker\")")
public WebElement yearpicker;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Hide year picker\")")
public WebElement hideyearpicker;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"DONE\")")
public WebElement done;
@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(2)")
public WebElement searchbutton;
@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Image\")")
public List<WebElement> editButtons;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"HDPE\")")
public WebElement hdpeMaterial;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"PET\")")
public WebElement petMaterial;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Clean\")")
public WebElement cleanCondition;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Search name or phone number\")")
public WebElement snopn;

public static String splitMemberName1;
public static String splitMemberName2;

public static String splitMemberNumber1 = RandomStringUtils.randomNumeric(6);
public static String splitMemberNumber2 = RandomStringUtils.randomNumeric(6);

public static String splitBranchMemberName1;
public static String splitBranchName1 = "br1"+RandomStringUtils.randomAlphabetic(5);
public static String splitBranchNumber1 = RandomStringUtils.randomNumeric(8);

public static String typedAlphabets;
public static String typedNumber;
public static String typedNumberforsplitbranch;

WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(300));
public void createBranch() throws InterruptedException {
//Creating branch after member signup or login.
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(menuButton)));
	menuButton.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(createBusinessButton)));
	createBusinessButton.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(recyclingBusinessPanel)));
	recyclingBusinessPanel.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(collectionPointPanel)));
	collectionPointPanel.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(createBUSINESSbutton)));
	createBUSINESSbutton.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(cameraButton)));
	cameraButton.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(takeA_PictureOption)));
	takeA_PictureOption.click();
	/*
	 * try{ wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(
	 * permission))); permission.click();
	 * wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(allow
	 * ))); allow.click(); }catch(Exception e) {
	 */
		Thread.sleep(2000);
		PointerInput fingerShutter = new PointerInput(PointerInput.Kind.TOUCH, "fingerShutter");
	    Sequence scrollShutter = new Sequence(fingerShutter, 1);
	    scrollShutter.addAction(fingerShutter.createPointerMove(Duration.ofMillis(0),
	        PointerInput.Origin.viewport(), 550, 1930));
	    scrollShutter.addAction(fingerShutter.createPointerDown(0));
	    scrollShutter.addAction(fingerShutter.createPointerMove(Duration.ofMillis(100),
	        PointerInput.Origin.viewport(), 550, 1930));
	    scrollShutter.addAction(fingerShutter.createPointerUp(0));
	    pbDriver.perform(Arrays.asList(scrollShutter));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(photoDone)));
		photoDone.click();	
		
	Thread.sleep(7000);
	PointerInput fingerconfirm = new PointerInput(PointerInput.Kind.TOUCH, "fingerconfirm");
    Sequence scrollconfirm = new Sequence(fingerconfirm, 1);
    scrollconfirm.addAction(fingerconfirm.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), 550, 2030));
    scrollconfirm.addAction(fingerconfirm.createPointerDown(0));
    scrollconfirm.addAction(fingerconfirm.createPointerMove(Duration.ofMillis(100),
        PointerInput.Origin.viewport(), 550, 2030));
    scrollconfirm.addAction(fingerconfirm.createPointerUp(0));
    pbDriver.perform(Arrays.asList(scrollconfirm));
	
    Thread.sleep(5000);
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(businessNameTextField)));
    System.out.println(randomBusinessName);
	//businessNameTextField.click();
	businessNameTextField.sendKeys(randomBusinessName);
	System.out.println(randomBusinessName);
	Thread.sleep(2000);
	PointerInput fingerscrolluptocheckbox = new PointerInput(PointerInput.Kind.TOUCH, "fingerscrolluptocheckbox");
    Sequence scrollscrolluptocheckbox = new Sequence(fingerscrolluptocheckbox, 1);
    scrollscrolluptocheckbox.addAction(fingerscrolluptocheckbox.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), 170, 1870));
    scrollscrolluptocheckbox.addAction(fingerscrolluptocheckbox.createPointerDown(0));
    scrollscrolluptocheckbox.addAction(fingerscrolluptocheckbox.createPointerMove(Duration.ofMillis(1000),
        PointerInput.Origin.viewport(), 170, 300));
    scrollscrolluptocheckbox.addAction(fingerscrolluptocheckbox.createPointerUp(0));
    pbDriver.perform(Arrays.asList(scrollscrolluptocheckbox));
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(mondayCheckBox)));
    mondayCheckBox.click();
    tuesdayCheckBox.click();
    wednesdayCheckBox.click();
    thursdayCheckBox.click();
    fridayCheckBox.click();
    saturdayCheckBox.click();
    sundayCheckBox.click();
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(saveButton)));
    saveButton.click();
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(OKButton)));
    OKButton.click();
    Thread.sleep(2000);
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(cashValuePerKgTextField)));
    cashValuePerKgTextField.click();
    cashValuePerKgTextField.sendKeys("10");
       
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(addButton)));
    addButton.click();
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(doneButton)));
    doneButton.click();
 }
public void createSplitBranch(String branchName) throws InterruptedException {

	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(communityProgram)));
	Thread.sleep(1000);
	communityProgram.click();
	Thread.sleep(2000);
	schoolProgram.click();
	Thread.sleep(2000);
	image.click();
	Thread.sleep(2000);
	tap(550,2131);  // take photo
	shutter.click();
	photoDone.click();
	tap(550,2154);   // save photo
	//
	Thread.sleep(2000);
	tap(500,800); // name*

	splitBranchMemberName1 = getTypedAlphabets();
	    System.out.println("Typed alphabets: " + splitBranchMemberName1);
		
	pbDriver.pressKey(new KeyEvent(AndroidKey.BACK));

	tap(200,1000); // phone code
	Thread.sleep(3000);
	searchcountries.sendKeys("+63");
	tap(270,490);   // result after search code
	tap(660,1000);  // number

	typedNumberforsplitbranch = getTypedNumber();
    System.out.println("Typed number: " + typedNumber);
	pbDriver.pressKey(new KeyEvent(AndroidKey.BACK));
	edittexts.get(3).click();
	
	scroll(775,980,775,1350);
	scroll(775,980,775,1350);
	
	done.click();

	tap(400,1440);  // gender
	tap(140,905);     // male option
	scroll(500,2100,500,1555);
	edittexts.get(4).sendKeys("123456a");
	edittexts.get(5).sendKeys("123456a");
	scroll(500,2100,500,555);
	edittexts.get(2).sendKeys(branchName);
	tickimage.click();
	register.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(resend)));
	tap(156,1100);
	pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_7));
	pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_7));
	pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));
	pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));
	pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));
	pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(savematerial)));

	// 0-Category , 1-Type , 2-Condition , 3-Color , 4-Value

	editButtons.get(1).click();
	Thread.sleep(2000);
	hdpeMaterial.click();
	tap(551,2118);
	cleanCondition.click();
	tap(551,2118);
	colorClear.click();
	tap(551,2118);

	edittexts.get(0).sendKeys("10");
	tap(551,2118);

	savematerial.click();

	wait.until(ExpectedConditions.visibilityOf(addnewmaterial));

	addnewmaterial.click();

	editButtons.get(1).click();
	Thread.sleep(2000);
	petMaterial.click();
	tap(551,2118);
	cleanCondition.click();
	tap(551,2118);
	colorClear.click();
	tap(551,2118);

	edittexts.get(0).sendKeys("10");
	tap(551,2118);

	savematerial.click();

	wait.until(ExpectedConditions.visibilityOf(addnewmaterial));
	tap(140,2197);

Thread.sleep(1000);
	
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(menuButton)));

}
public void toggleOffMember() throws InterruptedException {

Thread.sleep(4000);
snopn.isDisplayed();
tap(936,970);
Thread.sleep(2000);
	back.click();

}

public void addMemberToCreatedSplitBranch1() throws InterruptedException {

	tap(140,2197);  //home
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(manageCommunityButton));
	manageCommunityButton.click();
	addmember.click();
	Thread.sleep(2000);
	images.get(0).click();
	tap(550,2131);  // take photo
	shutter.click();
	photoDone.click();
	tap(550,2154);   // save photo
	tap(400,1120);   //name*
	pbDriver.pressKey(new KeyEvent(AndroidKey.M));
	pbDriver.pressKey(new KeyEvent(AndroidKey.E));
	pbDriver.pressKey(new KeyEvent(AndroidKey.M));
	pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
	splitMemberName1 = "mem1"+getTypedAlphabets();
    System.out.println("Typed alphabets: " + splitMemberName1);

	pbDriver.pressKey(new KeyEvent(AndroidKey.BACK));
	tap(660,1334);   //number

	typedNumber = getTypedNumber();
    System.out.println("Typed number: " + typedNumber);

	pbDriver.pressKey(new KeyEvent(AndroidKey.BACK));
	tap(500,1546);  // dob
	Thread.sleep(2000);
	
	scroll(800,1024,800,1300);   // scroll for year
	scroll(800,1024,800,1300);   //scroll for year
	
	done.click();

	scroll(500,1776,500,700);

	//Selecting gender by tapping
	tap(446,1626);
	tap(185,1105);

	Thread.sleep(2000);

	//selecting role by tapping
	tap(446,1829);
	tap(185,1187);

	Thread.sleep(2000);

	images.get(5).click();
	register.click();
	Thread.sleep(5000);

}
public void addMemberToCreatedSplitBranch2() throws InterruptedException {
	Thread.sleep(5000);
	snopn.isDisplayed();
	
	addmember.click();
	Thread.sleep(2000);
	images.get(0).click();
	tap(550,2131);  // take photo
	shutter.click();
	photoDone.click();
	tap(550,2154);   // save photo
	tap(400,1120);   //name*
	pbDriver.pressKey(new KeyEvent(AndroidKey.M));
	pbDriver.pressKey(new KeyEvent(AndroidKey.E));
	pbDriver.pressKey(new KeyEvent(AndroidKey.M));
	pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
	splitMemberName2 = "mem2"+getTypedAlphabets();
    System.out.println("Typed alphabets: " + splitMemberName2);

	pbDriver.pressKey(new KeyEvent(AndroidKey.BACK));
	tap(660,1334);   //number

	typedNumber = getTypedNumber();
    System.out.println("Typed number: " + typedNumber);

	pbDriver.pressKey(new KeyEvent(AndroidKey.BACK));
	tap(500,1546);  // dob
	Thread.sleep(2000);
	
	scroll(800,1024,800,1300);   // scroll for year
	scroll(800,1024,800,1300);   //scroll for year
	
	done.click();

	scroll(500,1776,500,700);

	//Selecting gender by tapping
	tap(446,1626);
	tap(185,1105);

	Thread.sleep(2000);

	//selecting role by tapping
	tap(446,1829);
	tap(185,1187);

	Thread.sleep(2000);

	images.get(5).click();
	register.click();
	Thread.sleep(5000);
}



 public void verifysuspendedmember() throws InterruptedException {
	 susmem.isDisplayed();
	 ok.click();
	 back.click();
	 
 }
public void addDonation(){
	
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(searchOutline)));
	
	PointerInput fingerconfirmpassword = new PointerInput(PointerInput.Kind.TOUCH, "fingerconfirmpassword");
    Sequence scrollconfirmpassword = new Sequence(fingerconfirmpassword, 1);
    scrollconfirmpassword.addAction(fingerconfirmpassword.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), 950, 2122));
    scrollconfirmpassword.addAction(fingerconfirmpassword.createPointerDown(0));
    scrollconfirmpassword.addAction(fingerconfirmpassword.createPointerMove(Duration.ofMillis(100),
        PointerInput.Origin.viewport(), 950, 2122));
    scrollconfirmpassword.addAction(fingerconfirmpassword.createPointerUp(0));
    pbDriver.perform(Arrays.asList(scrollconfirmpassword));
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(addButton)));
    addButton.click();
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(loading)));
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(addButton)));
    addButton.click();
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(chooseDonation)));
    chooseDonation.click();
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(OKButton)));
    OKButton.click();
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(loading)));
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(menuButton)));
    menuButton.click();
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(logoutButton)));
    logoutButton.click();
}
public String typeRandomAlphabet() {
    Random random = new Random();
    char randomChar = (char) (random.nextInt(26) + 'A'); // Generates random uppercase letter ('A' to 'Z')

    // Simulate pressing the key corresponding to the random alphabet
    AndroidKey keyEvent = AndroidKey.valueOf(String.valueOf(randomChar));
    pbDriver.pressKey(new KeyEvent(keyEvent));

    return String.valueOf(randomChar);
}
public String getTypedAlphabets() {
    StringBuilder typedAlphabets = new StringBuilder();

    for (int i = 0; i < 9; i++) {
        String alphabet = typeRandomAlphabet().toLowerCase();
        typedAlphabets.append(alphabet);
        System.out.println("Typed alphabet: " + alphabet);
    }

    return typedAlphabets.toString();
}
public String typeRandomDigit() {
    Random random = new Random();
    int randomDigit = random.nextInt(9) + 1; // Generates random number between 1 and 9

    AndroidKey keyEvent = AndroidKey.valueOf("DIGIT_" + randomDigit);
    // Simulate pressing the key corresponding to the random digit
    pbDriver.pressKey(new KeyEvent(keyEvent));
    return String.valueOf(randomDigit);
}
public String getTypedNumber() {
    StringBuilder typedNumber = new StringBuilder();

    for (int i = 0; i < 9; i++) {
        String digit = typeRandomDigit();
        typedNumber.append(digit);
        System.out.println("Typed digit: " + digit);
    }

    return typedNumber.toString();
}

//"Mainak "+RandomStringUtils.randomAlphabetic(5)
public void addMemberToCreatedBranch() throws InterruptedException {
	addmember.click();
	images.get(0).click();
	tap(540,2126);
	Thread.sleep(4000);
	shutter.click();
	photoDone.click();
    tap(548,2135);
    tap(400,1125);
    typedAlphabets = getTypedAlphabets();
    System.out.println("Typed alphabets: " + typedAlphabets);
	
	pbDriver.pressKey(new KeyEvent(AndroidKey.BACK));
    tap(660,1345);
    typedNumber = getTypedNumber();
    System.out.println("Typed number: " + typedNumber);
	
	pbDriver.pressKey(new KeyEvent(AndroidKey.BACK));
	edittexts.get(4).click();
	
	scroll(780,960,780,1352);
	scroll(780,960,780,1352);
	
	done.click();
	scroll(500,1776,500,700);
	tap(446,1419);
	tap(446,1685);

	images.get(5).click();
	register.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(startexchange)));
	tap(545,2115);
	
}


public void searchsuspendedmember() throws InterruptedException {
	tap(518,914);
	tap(521,445);
	tap(500,1600);
	tap(164,1655);
	tap(164,1655);
	tap(500,1450);
	tap(500,2000);
	tap(500,2040);
	suspendedaddedmem.isDisplayed();
	
}
public void goToProcessor(){
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(loading)));
	 wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(menuButton)));
	    menuButton.click();
	    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(processor)));
	    processor.click();
}

public void createbranchaftermember() throws InterruptedException {
	 wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(menuButton)));
	    menuButton.click();
	    tap(373,865);
	    Thread.sleep(2000);
	    recyclingbusiness.click();
	    Thread.sleep(2000);
	    collectionpoint.click();
	    edittexts.get(1).sendKeys("MB"+RandomStringUtils.randomAlphabetic(8));
	    tap(500,2137);
	    Thread.sleep(20000);
	    tap(537,2123);
	    tap(985,1305);
	    tap(440,1778);
	    pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
	    pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));
		pbDriver.pressKey(new KeyEvent(AndroidKey.BACK));
	    
	    
	    tap(551,2126);
	    tap(550,2146);
	    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(addnewmaterial)));
	   menuButton.click();
	   tap(330,1433);	    
}

public void checkupdateddata() throws InterruptedException {
	tap(130,2183);
	updatedname.isDisplayed();
	takescreenshotofandroid("Updated name is visible to user.");
	
}
public void createbranchdirectly() throws InterruptedException {
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(signUpButton)));
	Thread.sleep(2000);
	signUpButton.click();
	Thread.sleep(2000);
	recyclingbusiness.click();
	Thread.sleep(2000);
	collectionpoint.click();
	Thread.sleep(2000);
	image.click();
	Thread.sleep(2000);
	tap(550,2120);
	shutter.click();
	photoDone.click();
	tap(550,2150);
	//
	tap(500,786);
	 typedAlphabets = "mainak "+getTypedAlphabets();
	    System.out.println("Typed alphabets: " + typedAlphabets);
	pbDriver.pressKey(new KeyEvent(AndroidKey.BACK));
	
	tap(200,1000);
	Thread.sleep(3000);
	searchcountries.sendKeys("+63");
	tap(270,466);
	tap(660,1000);
	 typedNumber = getTypedNumber();
	    System.out.println("Typed number: " + typedNumber);
	pbDriver.pressKey(new KeyEvent(AndroidKey.BACK));
	edittexts.get(3).click();
	scroll(780,975,780,1300);
	scroll(780,975,780,1300);
	done.click();
	tap(400,1430);
	tap(140,910);
	scroll(500,2100,500,1555);
	edittexts.get(4).sendKeys("123456a");
	edittexts.get(5).sendKeys("123456a");
	scroll(500,2100,500,555);
	edittexts.get(2).sendKeys("Gayas "+RandomStringUtils.randomAlphabetic(5));
	tickimage.click();
	register.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(resend)));
	tap(150,1086);
	 pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_7));
	 pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_7));
	 pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));
	 pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));
	 pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));
	 pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(savematerial)));
	 tap(984,1305);
	 tap(440,1792);
	 pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
	    pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));
		pbDriver.pressKey(new KeyEvent(AndroidKey.BACK));
	    tap(551,2120);
	    savematerial.click();
	    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(menuButton)));
	   menuButton.click();
	   tap(330,1433);	    

}
}
