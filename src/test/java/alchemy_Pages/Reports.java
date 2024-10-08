package alchemy_Pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.BaseClass;


public class Reports extends BaseClass {
public Reports(WebDriver alcDriver) {
		
		PageFactory.initElements(alcDriver, this);
		}
@FindBy(xpath="//div[@class='body']/div/div/div[text()=' Reports ']")
public WebElement reports_TAB;
@FindBy(xpath="//div[text()='Token Exchange History']")
public WebElement tokenexchangehistory;
@FindBy(xpath="//div[text()='Token Exchange History']/following::span[text()='Filter By :']/following-sibling::select")
public WebElement dropdown;
@FindBy(xpath="//option[text()=' Digital Cash Out']")
public WebElement dcooption;
@FindBy(xpath="(//div[contains(@class,'daterange')])[4]/span[contains(text(),'From')]")
public WebElement fromdate;
@FindBy(xpath="(//div[contains(@class,'daterange')])[4]/span[contains(text(),'To')]")
public WebElement todate;
@FindBy(xpath="//div[text()='Token Exchange History']/following::tr/td/div/div[text()=' completed ']")
public WebElement completedstatus;
@FindBy(xpath="//div[text()='Token Exchange History']/following::tr/td/div/div[text()=' pending ']")
public WebElement pendingstatus;
@FindBy(xpath="(//div[contains(text(),'Token')]/parent::div/following::ul/li/a[@aria-label='Next']/parent::li/preceding-sibling::li)[last()]")
public WebElement lastpage;

//dynamic xpaths:-
String dynamicDateXpath="//div[text()='Token Exchange History']/following::ngb-datepicker-month/div/div/span[contains(text(),'param')]";
String editedday;

public void transactionStatusInAlchemyReports() throws InterruptedException {
	
	reports_TAB.click();
	dropdown.click();
	dcooption.click();
	fromdate.click();
	Date today = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd");
	String day = sdf.format(today);
	if(String.valueOf(day.charAt(0)).equals("0")) {
		 editedday=day.replace(String.valueOf(day.charAt(0)), "");
	}
	else {
		editedday=day;
	}
	String newxpath=dynamicDateXpath.replace("param", editedday);
	alcDriver.findElement(By.xpath(newxpath)).click();
	alcDriver.findElement(By.xpath(newxpath)).click();
	Thread.sleep(2000);
	lastpage.click();
	Thread.sleep(2000);
    takescreenshotof(completedstatus,"Transaction is complete in alchemy reports tab.");
    
}
public void transactionStatusInAlchemyReportsforgcash() throws InterruptedException {
	
	reports_TAB.click();
	Thread.sleep(10000);	
	dropdown.click();
	dcooption.click();
	fromdate.click();
	Date today = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd");
	String day = sdf.format(today);
	if(String.valueOf(day.charAt(0)).equals("0")) {
		 editedday=day.replace(String.valueOf(day.charAt(0)), "");
	}
	else {
		editedday=day;
	}
	Thread.sleep(10000);	
	String newxpath=dynamicDateXpath.replace("param", editedday);
	alcDriver.findElement(By.xpath(newxpath)).click();
	alcDriver.findElement(By.xpath(newxpath)).click();
	Thread.sleep(2000);
	lastpage.click();
	Thread.sleep(2000);
	pendingstatus.isDisplayed();
    
}

















}
