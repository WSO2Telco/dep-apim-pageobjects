package com.wso2telco.apimanager.pageobjects.apihome.sandbox;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class SandboxNumbers.
 */
public class SandboxNumbers extends BasicPageObject {
	
	/** The logger. */
	Logger logger = Logger.getLogger(SandboxNumbers.class);
	
	/** The lbl welcome. */
	private WebPelement lblWelcome = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	/** The lbl number. */
	private String lblNumber = "//table[@id='numbers_data_table']/tbody/tr/td[1]";

	/** The lnk number delete. */
	private String lnkNumberDelete = "//table[@id='numbers_data_table']/tbody/tr/td[contains(.,'%s')]/../td[4]/a[4]";
	
	/** The lbl balance. */
	private String lblBalance = "//table[@id='numbers_data_table']/tbody/tr/td[contains(.,'%s')]/../td[3]";
	
	/** The btn add numbers. */
	private WebPelement btnAddNumbers = defineEelement(UIType.ID,"add_number_row_button");
	
	/** The txt number. */
	private WebPelement txtNumber = defineEelement(UIType.Xpath,"//input[@class='required tel managenum_exist']");
	
	/** The btn save number. */
	private WebPelement btnSaveNumber = defineEelement(UIType.Xpath,"//a[@class='save_data_icon']");
	
	/**The lbl error */
	private WebPelement lblError=defineEelement(UIType.Xpath, "//label[@class='error']");
	
	/**The txt description after error*/
	private WebPelement txtdescriptioAftererror=defineEelement(UIType.Xpath, "//input[@class='required error']");
	
	/** The txt balance. */
	private WebPelement txtBalance = defineEelement(UIType.Xpath,"//input[@class='required balance']");
	
	/**The txt span string Short code edit btn */
	String spantStringNumberEditBtn = "//table[@id='numbers_data_table']/tbody/tr/td[contains(.,'%s')]/../td[4]/a[3]";
	
	/** The txt editNumber. */
	private WebPelement editNumber = defineEelement(UIType.Xpath,"//input[@class='required tel']");
	
	/**The txt span string */
	String spantString = "//table[@id='numbers_data_table']/tbody/tr/td/input[contains(@value,'%s')]/../../td[4]/a[@class='save_edit_icon']";
	
	/** The lbl shortCode. */
	private  String lblshortCode =  "//table[@id='numbers_data_table']/tbody/tr/td[1]";
	
	/** The lnk short code delete. */
	private String lnkShortCodeDelete = "//table[@id='numbers_data_table']/tbody/tr/td[contains(.,'%s')]/../td[3]/a[4]";
	
	/** The btn add short code. */
	private WebPelement btnAddShortCode = defineEelement(UIType.ID,"add_new_row_button");
	
	/**The txt short code add */
	private WebPelement txtAddShortCode=defineEelement(UIType.Xpath, "//input[@class='required number shortcode_exist']");
	
	/**The txt span string Short code edit btn */
	String spantStringShortCodeEditBtn = "//table[@id='numbers_data_table']/tbody/tr/td[contains(.,'%s')]/../td[3]/a[3]";
	
	/**The txt span string Short code */
	String spantStringShortCode = "//table[@id='numbers_data_table']/tbody/tr/td/input[contains(@value,'%s')]/../../td[3]/a[@class='save_edit_icon']";

	/**
	 * Instantiates a new sandbox numbers.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public SandboxNumbers(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Checks if is sandbox welcome.
	 *
	 * @author SulakkhanaW
	 * @param welcome the welcome
	 * @return true, if is sandbox welcome
	 * @throws Exception the exception
	 */
	public boolean isSandboxWelcome(String welcome) throws Exception{
		flag = false;
		logger.debug("Validating Sandbox welcome page");
		try {
			if (getElement(lblWelcome).getText().equalsIgnoreCase(welcome)){
				flag = true;
				logger.debug("Sandbox welcome page is load properly");
			} else {
				logger.debug("Sandbox welcome page is not load properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Sandbox welcome page 'isSandboxWelcome()'" + e.getMessage());
			throw new Exception("Exception While Validating Sandbox welcome page 'isSandboxWelcome()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * @author Achiniuj
	 * @param welcome
	 * @return
	 * @throws Exception
	 */
	public boolean isSansboxManageNumberPage(String title) throws Exception{
		flag = false;
		logger.debug("Validating Sandbox number manage page");
		try {
			if (getElement(lblWelcome).getText().equalsIgnoreCase(title)){
				flag = true;
				logger.debug("Sandbox Manage number page is load properly");
			} else {
				logger.debug("Sandbox Manage nymber page is not load properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Sandbox welcome page 'isSansboxManageNumberPage()'" + e.getMessage());
			throw new Exception("Exception While Validating Sandbox welcome page 'isSansboxManageNumberPage()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Clear existing number.
	 *
	 * @author JayaniP
	 * @param number the number
	 * @throws Exception the exception
	 */
	public void clearExistingNumber(String number) throws Exception {
		Thread.sleep(sleepTime);
		logger.debug("Clearing existing number");
		List<WebElement> allElements = driver.findElements(By.xpath(lblNumber));
		List<String> stringList = new ArrayList<>();
		for (WebElement element : allElements) {
			stringList.add(element.getText());
		}
		if (stringList.toString().contains(number)) {
			String xpath = String.format(lnkNumberDelete, number);
			WebPelement deleteNumber = defineEelement(UIType.Xpath, xpath);
			getElement(deleteNumber).click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
			logger.debug("Cleared existing number");
		}
	}
	
	/**
	 * Gets the balanceof the number.
	 *
	 * @author JayaniP
	 * @param number the number
	 * @return the balanceof the number
	 * @throws Exception the exception
	 */
	public String getBalanceofTheNumber(String number) throws Exception {
		logger.debug("Get the balance");
		String bal = "";
		List<WebElement> allElements = driver.findElements(By.xpath(lblNumber)); 
		List<String> stringList = new ArrayList<>();

			for (WebElement element: allElements) {
			      stringList.add(element.getText());
			}
			if (stringList.toString().contains(number)) {
				String xpath = String.format(lblBalance, number);
				WebPelement balance = defineEelement(UIType.Xpath, xpath);
				bal = getElement(balance).getText();
				logger.debug("Got the balance");
			}
		return bal;
	}
	
	/**
	 * Checks if is number available.
	 *
	 * @author JayaniP
	 * @param number the number
	 * @return true, if is number available
	 * @throws Exception the exception
	 */
	public boolean isNumberAvailable(String number) throws Exception{
		Thread.sleep(sleepTime);
		flag = false;
		logger.debug("Validate number");
		List<WebElement> allElements = driver.findElements(By.xpath(lblNumber)); 
		List<String> stringList = new ArrayList<>();
		try {
			for (WebElement element: allElements) {
			      stringList.add(element.getText());
			}
			if (stringList.toString().contains(number)) {
				logger.debug("Validate number");
			    flag = true;
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating number 'isNumberAvailable()'" + e.getMessage());
			throw new Exception("Exception While Validating number 'isNumberAvailable()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click on add new number.
	 *
	 * @author JayaniP
	 */
	public void clickOnAddNewNumber(){
		logger.debug("Clicking add numbers");
		getElement(btnAddNumbers).click();
		logger.debug("Clicked add numbers");
	}
	
	/**
	 * Enter number.
	 *
	 * @author JayaniP
	 * @param number the number
	 */
	public void enterNumber(String number){
		logger.debug("Entering number");
		getElement(txtNumber).click();
		getElement(txtNumber).clearAndSendkeys(number);
		logger.debug("Number entered");
	}
	
	/**
	 * Click save number.
	 *
	 * @author JayaniP
	 */
	public void clickSaveNumber(){
		logger.debug("Clicking save number");
		getElement(btnSaveNumber).click();
		logger.debug("Number Saved");
	}
	
	/**
	 * Validate error msg
	 * @author Achiniuj
	 * @param errorMsg
	 * @return
	 * @throws Exception
	 */
	public boolean isErrorMsg(String errorMsg) throws Exception {
		flag = false;
		logger.debug("Validating the error message");
		try {
			if (getElement(lblError).getText().equalsIgnoreCase(errorMsg)) {
				flag = true;
				logger.debug("Error message is correct");
			} else {
				logger.debug("Error message is incorrect");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Refund the error message 'isErrorMsg()'" + e.getMessage());
			throw new Exception("Exception While Validating Refund the error message 'isErrorMsg()'" + e.getLocalizedMessage());
		}
		return flag;
	}	
		
	/**
	 * Enter description after a error message
	 * 
	 * @author Achiniuj
	 * @param description
	 */
	public void enterDisAfetrErrorMsg(String description) {
		logger.debug("Entering description");
		getElement(txtdescriptioAftererror).clearAndSendkeys(description);
		logger.debug("Description entered");
	}
	
	/**
	 * Enter balance.
	 *
	 * @author JayaniP
	 * @param balance the balance
	 */
	public void enterBalance(String balance){
		logger.debug("Entering balance");
		getElement(txtBalance).clearAndSendkeys(balance);
		logger.debug("Balance entered");
	}
	 
	/**
	 * Clear the balance in number managment page
	 * @author Achiniuj
	 */
	 public void clearBalance(){
		 logger.debug("Clearing balance");
		 getElement(txtBalance).clear();
		 logger.debug("Cleared balance");
	 }	
		
	/**
	 * Click number edit button
	 * 
	 * @author Achiniuj
	 * @param number
	 * @throws Exception
	 */
	public void clickEditbtnNumber(String number) throws Exception {
		Thread.sleep(sleepTime);
		logger.debug("Clicking Edit button");
		String numberEditbtnXpath = String.format(spantStringNumberEditBtn, number);
		WebPelement btnEditNumber = defineEelement(UIType.Xpath, numberEditbtnXpath);
		getElement(btnEditNumber).click();
		logger.debug("Clicked Edit button");
	}
	
	/**
	 * @author Achiniuj
	 * @param number
	 */
	public void editNumber(String number){
		logger.debug("Editing the number");
		getElement(editNumber).clearAndSendkeys(number);
		logger.debug("Edited the number");	
	}
	
	/**
	 * Click save button after edit the short code.
	 * @author AchiniJ
	 * @param number
	 * @throws Exception
	 */
	public void clickEditSavebtn(String number) throws Exception {
		Thread.sleep(sleepTime);
		logger.debug("Clicking Edit save button");
		String saveNumberXpath=String.format(spantString, number);
		WebPelement btnEditSave = defineEelement(UIType.Xpath, saveNumberXpath);
		getElement(btnEditSave).click();
		logger.debug("Clicked Edit save button");
	}
	
	/**
	 * Clear the existing short code
	 * @author Achiniuj
	 * @param shortCode
	 * @throws Exception
	 */
	public void clearExistingShortCodes(String shortCode) throws Exception {
		Thread.sleep(sleepTime);
		logger.debug("Clearing existing short code");
		List<WebElement> allElements = driver.findElements(By.xpath(lblshortCode)); 
		List<String> stringList = new ArrayList<>();

			for (WebElement element: allElements) {
			      stringList.add(element.getText());
			}
			if (stringList.toString().contains(shortCode)) {
				String xpath = String.format(lnkShortCodeDelete, shortCode);
				WebPelement deleteShortCode = defineEelement(UIType.Xpath, xpath);
				getElement(deleteShortCode).click();
				logger.debug("Start click enter");
				logger.debug("Clicked enter");
				Alert alert = driver.switchTo().alert();
				alert.accept();
				logger.debug("Cleared existing short code");
			}
		
	}
	
	/**
	 * Click Add new button for add new short code
	 * @author Achiniuj
	 */
	public void clickAddNewShortCodebtn(){
		logger.debug("Clicking add new button");
		getElement(btnAddShortCode).click();
		logger.debug("Clicked add new button");
	}
	
	/**
	 * Enter new short code
	 * @author Achiniuj
	 * @param shortCode
	 */
	public void addNewShortCode(String shortCode){
		logger.debug("Adding New short code");
		getElement(txtAddShortCode).clearAndSendkeys(shortCode);
		logger.debug("Added New Short code");	
	}
	 
	/**
	 * Click Short code edit button 
	 * @author Achiniuj
	 * @param shortCode
	 * @throws Exception
	 */
	public void clickEditbtnShortCode(String shortCode) throws Exception {
		Thread.sleep(sleepTime);
		logger.debug("Clicking Edit button");
		String shortCodeEditbtnXpath=String.format(spantStringShortCodeEditBtn,shortCode);
		WebPelement btnEditShortCode = defineEelement(UIType.Xpath, shortCodeEditbtnXpath);
		getElement(btnEditShortCode).click();
		logger.debug("Clicked Edit button");
	}
	
	/**
	 * Click edit save button in short code
	 * @author Achiniuj
	 * @param shortCode
	 * @throws Exception
	 */
	public void clickEditSavebtnShortCode(String shortCode) throws Exception {
		Thread.sleep(sleepTime);
		logger.debug("Clicking Edit save button");
		String saveShortCodeXpath=String.format(spantStringShortCode, shortCode);
		WebPelement btnEditSave = defineEelement(UIType.Xpath, saveShortCodeXpath);
		getElement(btnEditSave).click();
		logger.debug("Clicked Edit save button");
	}

}
