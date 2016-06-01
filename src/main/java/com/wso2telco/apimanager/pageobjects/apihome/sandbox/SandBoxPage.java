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
 * The Class SandBoxPage.
 */
public class SandBoxPage extends BasicPageObject {
	
	
	/** The logger. */
	Logger logger = Logger.getLogger(SandBoxPage.class);

	/** The lbl login. */
	private WebPelement lblLogin = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	/** The txt user name. */
	private WebPelement txtUserName = defineEelement(UIType.Xpath, "//form[@id='loginForm']/input[1]");

	/** The btn log in. */
	private WebPelement btnLogIn = defineEelement(UIType.ID, "loginButton");
	
	/** The lbl welcome. */
	private WebPelement lblWelcome = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	/** The btn user name. */
	private WebPelement btnUserName = defineEelement(UIType.ID, "userMenu");
	
	/** The btn logout. */
	private WebPelement btnLogout = defineEelement(UIType.Xpath, "//li[@class='logout-link-special']/button");
	
	/** The dd numbers. */
	private WebPelement ddNumbers = defineEelement(UIType.Xpath, "//a[@title='Numbers']");
	
	/** The lnk manage numbers. */
	private WebPelement lnkManageNumbers = defineEelement(UIType.Xpath, "//a[contains(.,'Manage Numbers')]");
	
	/** The lbl number. */
	private String lblNumber = "//table[@id='numbers_data_table']/tbody/tr/td[1]";

	/** The lnk number delete. */
	private String lnkNumberDelete = "//table[@id='numbers_data_table']/tbody/tr/td[contains(.,'%s')]/../td[4]/a[4]";
	
	/** The lbl balance. */
	private String lblBalance = "//table[@id='numbers_data_table']/tbody/tr/td[contains(.,'%s')]/../td[3]";
	
	/** The lbl manage numbers. */
	private WebPelement lblManageNumbers = defineEelement(UIType.Xpath, "//div[@id='listing']/div/h2");
	
	/** The btn add numbers. */
	private WebPelement btnAddNumbers = defineEelement(UIType.ID,"add_number_row_button");
	
	/** The txt number. */
	private WebPelement txtNumber = defineEelement(UIType.Xpath,"//input[@class='required tel managenum_exist']");
	
	/** The txt description. */
	private WebPelement txtDescription = defineEelement(UIType.Xpath,"//input[@class='required']");
	
	/** The txt balance. */
	private WebPelement txtBalance = defineEelement(UIType.Xpath,"//input[@class='required balance']");
	
	/** The btn save number. */
	private WebPelement btnSaveNumber = defineEelement(UIType.Xpath,"//a[@class='save_data_icon']");
	
	/** The lnk api. */
	private WebPelement lnkApi = defineEelement(UIType.Xpath,"//a[@title='API']");
	
	/** The lnk payment. */
	private WebPelement lnkPayment = defineEelement(UIType.Xpath,"//li[@class='dropdown tryit-menu-item subnavi open']/ul/li/a[contains(.,'Payment')]");
	
	/** The lnk lbs. */
	private WebPelement lnkLBS = defineEelement(UIType.Xpath, "//ul[@id='mainnavi']//a[contains(.,'LBS')]");
	
	/** The lnk sms. */
	private WebPelement lnkSMS = defineEelement(UIType.Xpath, "//ul[@id='mainnavi']//a[contains(.,'SMS')]");
	
	/** The lbl payment parameters. */
	private WebPelement lblPaymentParameters = defineEelement(UIType.Xpath,"//div[@class='title-section']/h2");
	
	/** The dd transaction status. */
	private WebPelement ddTransactionStatus = defineEelement(UIType.ID,"paystatus");
	
	/** The btn save parameters. */
	private WebPelement btnSaveParameters = defineEelement(UIType.ID,"param-add-button");
	
	/** The txt end user id. */
	private WebPelement txtEndUserId = defineEelement(UIType.ID,"endUsertp");
	
	/** The dd transaction operation status. */
	private WebPelement ddTransactionOperationStatus = defineEelement(UIType.ID,"transactionOperationStatus");
	
	/** The txt reference code. */
	private WebPelement txtReferenceCode = defineEelement(UIType.ID,"referenceCode");
	
	/** The txt request description. */
	private WebPelement txtRequestDescription = defineEelement(UIType.ID,"description");
	
	/** The txt currency. */
	private WebPelement txtCurrency = defineEelement(UIType.ID,"currency");
	
	/** The txt amount. */
	private WebPelement txtAmount = defineEelement(UIType.ID,"amount");
	
	/** The txt client correlator. */
	private WebPelement txtClientCorrelator = defineEelement(UIType.ID,"clientCorrelator");
	
	/** The txt notify url. */
	private WebPelement txtNotifyUrl = defineEelement(UIType.ID,"callbackURL");
	
	/** The txt notify url refund. */
	private WebPelement txtNotifyUrlRefund = defineEelement(UIType.ID,"notifyURL");
	
	/** The txt max pay amount. */
	private WebPelement txtMaxPayAmount = defineEelement(UIType.ID,"maxamt");
	
	/** The txt purchase category code. */
	private WebPelement txtPurchaseCategoryCode = defineEelement(UIType.ID,"purchaseCategoryCode");
	
	/** The txt channel. */
	private WebPelement txtChannel = defineEelement(UIType.ID,"channel");
	
	/** The txt tax amount. */
	private WebPelement txtTaxAmount = defineEelement(UIType.ID,"taxAmount");
	
	/** The btn send request. */
	private WebPelement btnSendRequest = defineEelement(UIType.ID,"payment-add-button");
	
	/** The txt request payload. */
	private WebPelement txtRequestPayload = defineEelement(UIType.Xpath,"//div[@class='ParameterValue']/textarea[@id='request']");
	
	/** The txt response payload. */
	private WebPelement txtResponsePayload = defineEelement(UIType.Xpath,"//div[@class='ParameterValue']/textarea[@id='response']");
	
	/** The lnk refund user. */
	private WebPelement lnkRefundUser = defineEelement(UIType.Xpath,"//a[contains(.,'Refund the User')]");
	
	/** The lbl refund the user. */
	private WebPelement lblRefundTheUser = defineEelement(UIType.Xpath,"//div[@class='title-section']/h2");
	
	/** The txt call back data. */
	private WebPelement txtCallBackData = defineEelement(UIType.ID,"callbackData");
	
	/** The txt code. */
	private WebPelement txtCode = defineEelement(UIType.ID,"code");
	
	/** The txt mandate code. */
	private WebPelement txtMandateCode = defineEelement(UIType.ID,"mandateId");
	
	/** The txt notification format. */
	private WebPelement txtNotificationFormat = defineEelement(UIType.ID,"notificationFormat");
	
	/** The txt on behalf of. */
	private WebPelement txtOnBehalfOf = defineEelement(UIType.ID,"onBehalfOf");
	
	/** The txt server reference code. */
	private WebPelement txtServerReferenceCode = defineEelement(UIType.ID,"originalServerRef");
	
	/** The txt product id. */
	private WebPelement txtProductId = defineEelement(UIType.ID,"productId");
	
	/** The txt service id. */
	private WebPelement txtServiceId = defineEelement(UIType.ID,"serviceID");
	
	/** The lnk manage numbers. */
	private WebPelement lnkSenderAddresses = defineEelement(UIType.Xpath, "//a[contains(.,'Sender Addresses')]");
	
	/** The lbl shortCode. */
	private  String lblshortCode =  "//table[@id='numbers_data_table']/tbody/tr/td[1]";
	
	/** The lnk short code delete. */
	private String lnkShortCodeDelete = "//table[@id='numbers_data_table']/tbody/tr/td[contains(.,'%s')]/../td[3]/a[4]";
	
	/**The txt short code add */
	private WebPelement txtAddShortCode=defineEelement(UIType.Xpath, "//input[@class='required number shortcode_exist']");
	
	/** The btn add short code. */
	private WebPelement btnAddShortCode = defineEelement(UIType.ID,"add_new_row_button");
	
	/**The lbl error */
	private WebPelement lblError=defineEelement(UIType.Xpath, "//label[@class='error']");
	
	/**The txt description after error*/
	private WebPelement txtdescriptioAftererror=defineEelement(UIType.Xpath, "//input[@class='required error']");
	
	/**The txt enter balance after error */
	private WebPelement txtBalanceAfterError=defineEelement(UIType.Xpath, "//input[@class='required balance error']");
	
	/** The txt editNumber. */
	private WebPelement editNumber = defineEelement(UIType.Xpath,"//input[@class='required tel']");
	
	/**The txt span string */
	String spantString = "//table[@id='numbers_data_table']/tbody/tr/td/input[contains(@value,'%s')]/../../td[4]/a[@class='save_edit_icon']";
	
	/**The txt span string Short code */
	String spantStringShortCode = "//table[@id='numbers_data_table']/tbody/tr/td/input[contains(@value,'%s')]/../../td[3]/a[@class='save_edit_icon']";
	
	/**The txt span string Short code edit btn */
	String spantStringShortCodeEditBtn = "//table[@id='numbers_data_table']/tbody/tr/td[contains(.,'%s')]/../td[3]/a[3]";
	
	/**The txt span string Short code edit btn */
	String spantStringNumberEditBtn = "//table[@id='numbers_data_table']/tbody/tr/td[contains(.,'%s')]/../td[4]/a[3]";
	
	
	/**
	 * Instantiates a new sand box page.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public SandBoxPage(WebDriver driver) {
		super(driver);
	}
		
	/**
	 * Checks if is request payload tax amount.
	 *
	 * @param taxAmount the tax amount
	 * @param requestPaylod the request paylod
	 * @return true, if is request payload tax amount
	 * @throws Exception the exception
	 */
	public boolean isRequestPayloadTaxAmount(String taxAmount, String requestPaylod) throws Exception{
		flag = false;
		logger.debug("Validating Request Payload Tax Amount");
		try {
			if (requestPaylod.contains(taxAmount)){
				flag = true;
				logger.debug("Request Payload Tax Amount matched");
			} else{
				logger.debug("Request Payload Tax Amount mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Request Payload Tax Amount 'isRequestPayloadTaxAmount()'" + e.getMessage());
			throw new Exception("Exception While Validating Request Payload Tax Amount 'isRequestPayloadTaxAmount()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Checks if is response payload tax amount.
	 *
	 * @param taxAmount the tax amount
	 * @param responsePayload the response payload
	 * @return true, if is response payload tax amount
	 * @throws Exception the exception
	 */
	public boolean isResponsePayloadTaxAmount(String taxAmount, String responsePayload) throws Exception{
		flag = false;
		logger.debug("Validating Response Payload Tax Amount");
		try {
			if (responsePayload.contains(taxAmount)){
				flag = true;
				logger.debug("Response Payload Tax Amount matched");
			} else{
				logger.debug("Response Payload Tax Amount mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Response Payload Tax Amount 'isResponsePayloadTaxAmount()'" + e.getMessage());
			throw new Exception("Exception While Validating Response Payload Tax Amount 'isResponsePayloadTaxAmount()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Checks if is sandbox login page.
	 *
	 * @author SulakkhanaW
	 * @param sandbobLoginHeader the sandbob login header
	 * @return true, if is sandbox login page
	 * @throws Exception the exception
	 */
	public boolean isSandboxLoginPage(String sandbobLoginHeader) throws Exception{
		flag = false;
		logger.debug("Validating Sandbox login page");
		try {
			if (getElement(lblLogin).getText().equalsIgnoreCase(sandbobLoginHeader)){
				flag = true;
				logger.debug("Sandbox login page is load properly");
			} else {
				logger.debug("Sandbox login page is not load properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Sandbox login page 'isSandboxLoginPage()'" + e.getMessage());
			throw new Exception("Exception While Validating Sandbox login page 'isSandboxLoginPage()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Enter user name.
	 *
	 * @author IsuruM
	 * @param username the username
	 * @throws InterruptedException the interrupted exception
	 */
	public void enterUserName(String username) throws InterruptedException{
		logger.debug("Entering Username");
		Thread.sleep(sleepTime);
		// TODO: add a relative xpath
		WebElement username1 = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div/div[1]/div[2]/div[3]/div/form/input[1]"));
		username1.sendKeys(username);
		Thread.sleep(sleepTime);
		getElement(txtUserName).clearAndSendkeys(username);
		logger.debug("Entered Username successfully");
	}
	
	/**
	 * Enter password.
	 *
	 * @author SulakkhanaW
	 * @param password the password
	 * @throws InterruptedException the interrupted exception
	 */
	
	public void enterPassword(String password) throws InterruptedException{
		WebElement paswd = driver.findElement(By.cssSelector("#loginForm>#pass"));
		logger.debug("Entering password");
		Thread.sleep(sleepTime);
		Thread.sleep(sleepTime);
		paswd.clear();
		paswd.sendKeys(password);
		Thread.sleep(sleepTime);
		logger.debug("Entered password successfully");
	}
	
	/**
	 * Click login.
	 *
	 * @author SulakkhanaW
	 */
	public void clickLogin(){
		logger.debug("Clicking on login");
		getElement(btnLogIn).click();
		logger.debug("Clicked on login");
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
	 * Click user name.
	 *
	 * @author SulakkhanaW
	 */
	public void clickUserName(){
		logger.debug("Clicking on username");
		getElement(btnUserName).click();
		logger.debug("Clicked on username");
	}
	
	/**
	 * Click logout.
	 *
	 * @author SulakkhanaW
	 */
	public void clickLogout(){
		logger.debug("Clicking on logout");
		getElement(btnLogout).click();
		logger.debug("Clicked on logout");
	}
	
	/**
	 * Click numbers.
	 *
	 * @author JayaniP
	 */
	public void clickNumbers(){
		logger.debug("Clicking on numbers");
		getElement(ddNumbers).click();
		logger.debug("Clicked on numbers");
	}
	
	/**
	 * Select manage numbers.
	 *
	 * @author JayaniP
	 */
	public void selectManageNumbers(){
		logger.debug("Selecting manage numbers");
		getElement(lnkManageNumbers).click();
		logger.debug("Selected manage numbers");
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
	 * Checks if is manage numbers.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is manage numbers
	 * @throws Exception the exception
	 */
	public boolean isManageNumbers(String title) throws Exception{
		flag = false;
		logger.debug("Validating manage numbers page");
		try {
			if (getElement(lblManageNumbers).getText().equalsIgnoreCase(title)){
				flag = true;
				logger.debug("Manage numbers page is load properly");
			} else {
				logger.debug("Manage numbers page is not load properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating manage numbers page 'isManageNumbers()'" + e.getMessage());
			throw new Exception("Exception While Validating manage numbers page 'isManageNumbers()'" + e.getLocalizedMessage());
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
	 * Enter description.
	 *
	 * @author JayaniP
	 * @param description the description
	 */
	public void enterDescription(String description){
		logger.debug("Entering description");
		getElement(txtDescription).clearAndSendkeys(description);
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
	 * @author Achiniuj
	 * @param number
	 */
	public void editNumber(String number){
		logger.debug("Editing the number");
		getElement(editNumber).clearAndSendkeys(number);
		logger.debug("Edited the number");
		
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
	 * Click on api.
	 *
	 * @author JayaniP
	 */
	public void clickOnApi(){
		logger.debug("Clicking API");
		getElement(lnkApi).click();
		logger.debug("Clicked on API");
	}
	
	/**
	 * Click on payment.
	 *
	 * @author JayaniP
	 */
	public void clickOnPayment(){
		logger.debug("Clicking Payment");
		getElement(lnkPayment).click();
		logger.debug("Clicked on Payment");
	}
	
	/**
	 * Click on lbs.
	 *
	 * @author SulakkhanaW
	 */
	public void clickOnLBS(){
		logger.debug("Clicking on LBS");
		getElement(lnkLBS).click();
		logger.debug("Clicked on LBS");
	}
	
	/**
	 * Click on sms.
	 *
	 * @author SulakkhanaW
	 */
	public void clickOnSMS(){
		logger.debug("Clicking on SMS");
		getElement(lnkSMS).click();
		logger.debug("Clicked on SMS");
	}
	
	/**
	 * Checks if is payment parameters.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is payment parameters
	 * @throws Exception the exception
	 */
	public boolean isPaymentParameters(String title) throws Exception{
		flag = false;
		logger.debug("Validating payment parameters page");
		try {
			if (getElement(lblPaymentParameters).getText().equalsIgnoreCase(title)){
				flag = true;
				logger.debug("Payment parameters page is load properly");
			} else {
				logger.debug("Payment parameters page is not load properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating payment parameters page 'isPaymentParameters()'" + e.getMessage());
			throw new Exception("Exception While Validating payment parameters page 'isPaymentParameters()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Select transaction status.
	 *
	 * @author JayaniP
	 * @param transactionStatus the transaction status
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectTransactionStatus(String transactionStatus) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on Transaction Status Drop down");
		getElement(ddTransactionStatus).click();
		logger.debug("Clicked on Transaction Status Drop down");

		logger.debug("Start typing Transaction Status");
		getElement(ddTransactionStatus).sendKeys(transactionStatus);
		logger.debug("Typed Transaction Status");

		logger.debug("Start click enter");
		getElement(ddTransactionStatus).sendEnter();
		logger.debug("Clicked enter");

	}
	
	/**
	 * Click on save payment parameters.
	 *
	 * @author JayaniP
	 */
	public void clickOnSavePaymentParameters(){
		logger.debug("Start clicking on Save button");
		getElement(btnSaveParameters).click();
		logger.debug("Clicked on Save button");
	}
	
	/**
	 * Enter end user id.
	 *
	 * @author JayaniP
	 * @param number the number
	 */
	public void enterEndUserId(String number){
		logger.debug("Start entering end user id");
		getElement(txtEndUserId).clearAndSendkeys(number);
		logger.debug("Entered end user id");
	}
	
	/**
	 * Enter transaction operation status.
	 *
	 * @author JayaniP
	 * @param status the status
	 * @throws InterruptedException the interrupted exception
	 */
	public void enterTransactionOperationStatus(String status) throws InterruptedException{
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on Transaction Operation Status Drop down");
		getElement(ddTransactionOperationStatus).click();
		logger.debug("Clicked on Transaction Operation Status Drop down");

		logger.debug("Start typing Transaction Operation Status");
		getElement(ddTransactionOperationStatus).sendKeys(status);
		logger.debug("Typed Transaction Operation Status");

		logger.debug("Start click enter");
		getElement(ddTransactionOperationStatus).sendEnter();
		logger.debug("Clicked enter");
	}
	
	/**
	 * Enter reference code.
	 *
	 * @author JayaniP
	 * @param refCode the ref code
	 */
	public void enterReferenceCode(String refCode){
		logger.debug("Start entering Reference Code");
		getElement(txtReferenceCode).clearAndSendkeys(refCode);
		logger.debug("Entered Reference Code");
	}
	
	/**
	 * Enter request description.
	 *
	 * @author JayaniP
	 * @param description the description
	 */
	public void enterRequestDescription(String description){
		logger.debug("Start entering description");
		getElement(txtRequestDescription).clearAndSendkeys(description);
		logger.debug("Entered description");
	}
	
	/**
	 * Enter currency.
	 *
	 * @author JayaniP
	 * @param currency the currency
	 */
	public void enterCurrency(String currency){
		logger.debug("Start entering currency");
		getElement(txtCurrency).clearAndSendkeys(currency);
		logger.debug("Entered currency");
	}
	
	/**
	 * Enter amount.
	 *
	 * @author JayaniP
	 * @param amount the amount
	 */
	public void enterAmount(String amount){
		logger.debug("Start entering amount");
		getElement(txtAmount).clearAndSendkeys(amount);
		logger.debug("Entered amount");
	}
	
	/**
	 * Enter client correlator.
	 *
	 * @author JayaniP
	 * @param clientCorrelator the client correlator
	 */
	public void enterClientCorrelator(String clientCorrelator){
		logger.debug("Start entering client correlator");
		getElement(txtClientCorrelator).clearAndSendkeys(clientCorrelator);
		logger.debug("Entered client correlator");
	}
	
	/**
	 * Enter notify url.
	 *
	 * @author JayaniP
	 * @param url the url
	 */
	public void enterNotifyURL(String url){
		logger.debug("Start entering NotifyURL");
		getElement(txtNotifyUrl).clearAndSendkeys(url);
		logger.debug("Entered NotifyURL");
	}
	
	/**
	 * Enter purchase category code.
	 *
	 * @author JayaniP
	 * @param categoryCode the category code
	 */
	public void enterPurchaseCategoryCode(String categoryCode){
		logger.debug("Start entering Purchase Category Code");
		getElement(txtPurchaseCategoryCode).clearAndSendkeys(categoryCode);
		logger.debug("Entered Purchase Category Code");
	}
	
	/**
	 * Enter channel.
	 *
	 * @author JayaniP
	 * @param channel the channel
	 */
	public void enterChannel(String channel){
		logger.debug("Start entering channel");
		getElement(txtChannel).clearAndSendkeys(channel);
		logger.debug("Entered channel");
	}
	
	/**
	 * Enter tax amount.
	 *
	 * @author JayaniP
	 * @param tax the tax
	 */
	public void enterTaxAmount(String tax){
		logger.debug("Start entering tax amount");
		getElement(txtTaxAmount).clearAndSendkeys(tax);
		logger.debug("Entered tax amount");
	}
	
	/**
	 * Click on send request.
	 *
	 * @author JayaniP
	 */
	public void clickOnSendRequest(){
		logger.debug("Start clicking on send request");
		getElement(btnSendRequest).click();
		logger.debug("Clicked on send request");
	}
	
	/**
	 * Gets the request payload.
	 *
	 * @author JayaniP
	 * @return the request payload
	 * @throws InterruptedException 
	 */
	public String getRequestPayloadUI() throws InterruptedException {
		Thread.sleep(sleepTime);
		String requestPayload = getElement(txtRequestPayload).getAttribute("value");
		return requestPayload;
	}
	
	/**
	 * Gets the rsponse payload.
	 *
	 * @author JayaniP
	 * @return the rsponse payload
	 * @throws InterruptedException 
	 */
	public String getRsponsePayloadUI() throws InterruptedException {
		Thread.sleep(sleepTime);
		return getElement(txtResponsePayload).getAttribute("value");
	}
	
	/**
	 * Checks if is amount available.
	 *
	 * @author JayaniP
	 * @param amount the amount
	 * @return true, if is amount available
	 * @throws Exception the exception
	 */
	public boolean isAmountAvailableInRequest(String amount) throws Exception{
		flag = false;
		logger.debug("Validate amount");
		String requestPayload = getElement(txtRequestPayload).getText();
		try {
			if (requestPayload.contains(amount)) {
				flag = true;
				logger.debug("Amount is loaded accurately");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating amount 'isAmountAvailable()'" + e.getMessage());
			throw new Exception("Exception While Validating amount 'isAmountAvailable()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Checks if is amount available in response.
	 *
	 * @author JayaniP
	 * @param amount the amount
	 * @return true, if is amount available in response
	 * @throws Exception the exception
	 */
	public boolean isAmountAvailableInResponse(String amount) throws Exception{
		flag = false;
		logger.debug("Validate amount");
		try {
			if (getElement(txtResponsePayload).getText().contains(amount)) {
				flag = true;
				logger.debug("Amount is loaded accurately");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating amount 'isAmountAvailable()'" + e.getMessage());
			throw new Exception("Exception While Validating amount 'isAmountAvailable()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click on refund user.
	 *
	 * @author JayaniP
	 */
	public void clickOnRefundUser(){
		logger.debug("Start clicking on refund user");
		getElement(lnkRefundUser).click();
		logger.debug("Clicked on refund user");
	}
	
	/**
	 * Checks if is refund user.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is refund user
	 * @throws Exception the exception
	 */
	public boolean isRefundUser(String title) throws Exception{
		flag = false;
		logger.debug("Validating refund the user page");
		try {
			if (getElement(lblRefundTheUser).getText().equalsIgnoreCase(title)){
				flag = true;
				logger.debug("Refund the user page is load properly");
			} else {
				logger.debug("Refund the user page is not load properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Refund the user page 'isRefundUser()'" + e.getMessage());
			throw new Exception("Exception While Validating Refund the user page 'isRefundUser()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Enter call back data.
	 *
	 * @author JayaniP
	 * @param callBackData the call back data
	 */
	public void enterCallBackData(String callBackData){
		logger.debug("Start entering call back data");
		getElement(txtCallBackData).clearAndSendkeys(callBackData);
		logger.debug("Entered call back data");
	}
	
	/**
	 * Enter code.
	 *
	 * @author JayaniP
	 * @param code the code
	 */
	public void enterCode(String code){
		logger.debug("Start entering code");
		getElement(txtCode).clearAndSendkeys(code);
		logger.debug("Entered code");
	}
	
	/**
	 * Enter mandate id.
	 *
	 * @author JayaniP
	 * @param mandateId the mandate id
	 */
	public void enterMandateId(String mandateId){
		logger.debug("Start entering mandateId");
		getElement(txtMandateCode).clearAndSendkeys(mandateId);
		logger.debug("Entered mandateId");
	}
	
	/**
	 * Enter notification format.
	 *
	 * @author JayaniP
	 * @param format the format
	 */
	public void enterNotificationFormat(String format){
		logger.debug("Start entering notification format");
		getElement(txtNotificationFormat).clearAndSendkeys(format);
		logger.debug("Entered notification format");
	}
	
	/**
	 * Enter on behalf of.
	 *
	 * @author JayaniP
	 * @param onBehalfOf the on behalf of
	 */
	public void enterOnBehalfOf(String onBehalfOf){
		logger.debug("Start entering onBehalfOf");
		getElement(txtOnBehalfOf).clearAndSendkeys(onBehalfOf);
		logger.debug("Entered onBehalfOf");
	}
	
	/**
	 * Enter server reference code.
	 *
	 * @author JayaniP
	 * @param referenceCode the reference code
	 */
	public void enterServerReferenceCode(String referenceCode){
		logger.debug("Start entering reference Code");
		getElement(txtServerReferenceCode).clearAndSendkeys(referenceCode);
		logger.debug("Entered reference Code");
	}
	
	/**
	 * Enter product id.
	 *
	 * @author JayaniP
	 * @param prodID the prod id
	 */
	public void enterProductId(String prodID){
		logger.debug("Start entering product id");
		getElement(txtProductId).clearAndSendkeys(prodID);
		logger.debug("Entered product id");
	}
	
	/**
	 * Enter service id.
	 *
	 * @author JayaniP
	 * @param serviceId the service id
	 */
	public void enterServiceId(String serviceId){
		logger.debug("Start entering service id");
		getElement(txtServiceId).clearAndSendkeys(serviceId);
		logger.debug("Entered service id");
	}
	
	/**
	 * Enter refund notify url.
	 *
	 * @author JayaniP
	 * @param url the url
	 */
	public void enterRefundNotifyURL(String url){
		logger.debug("Start entering NotifyURL");
		getElement(txtNotifyUrlRefund).clearAndSendkeys(url);
		logger.debug("Entered NotifyURL");
	}
	
	/**
	 * Enter max payment amount.
	 *
	 * @author JayaniP
	 * @param amount the amount
	 */
	public void enterMaxPaymentAmount(String amount){
		logger.debug("Start entering max payment amount");
		getElement(txtMaxPayAmount).clearAndSendkeys(amount);
		logger.debug("Entered max payment amount");
	}
	
	/**
	 * Select Sender Addresses sub menu
	 * @author Achiniuj
	 */
	public void selectSenderAddresses(){
		logger.debug("Selecting Sender Addresses");
		getElement(lnkSenderAddresses).click();
		logger.debug("Selected Sender Addresses");
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
				//getElement(deleteShortCode).sendEnter();
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
	
	/**
	 * Validate error msg
	 * @author Achiniuj
	 * @param errorMsg
	 * @return
	 * @throws Exception
	 */
	 public boolean isErrorMsg(String errorMsg) throws Exception{
		flag = false;
		logger.debug("Validating the error message");
		try {
			if (getElement(lblError).getText().equalsIgnoreCase(errorMsg)){
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
	  * @author Achiniuj
	  * @param balance
	  */
	 public void enterBalanceError(String balance){
			logger.debug("Entering balance");
			getElement(txtBalanceAfterError).clearAndSendkeys(balance);
			logger.debug("Entered balance");
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
	 * Click number edit button
	 * @author Achiniuj
	 * @param number
	 * @throws Exception
	 */
	public void clickEditbtnNumber(String number) throws Exception {
		Thread.sleep(sleepTime);
		logger.debug("Clicking Edit button");
		String numberEditbtnXpath=String.format(spantStringNumberEditBtn,number);
		WebPelement btnEditNumber = defineEelement(UIType.Xpath, numberEditbtnXpath);
		getElement(btnEditNumber).click();
		logger.debug("Clicked Edit button");
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
	 * Enter description after a error message
	 * @author Achiniuj
	 * @param description
	 */
	public void enterDisAfetrErrorMsg(String description){
		logger.debug("Entering description");
		getElement(txtdescriptioAftererror).clearAndSendkeys(description);
		logger.debug("Description entered");
	}

	
}
