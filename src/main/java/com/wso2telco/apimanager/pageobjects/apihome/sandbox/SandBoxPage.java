package com.wso2telco.apimanager.pageobjects.apihome.sandbox;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

// TODO: Auto-generated Javadoc
/**
 * The Class SandBoxPage.
 */
public class SandBoxPage extends BasicPageObject{
	
	
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
	
	/** The lbl manage numbers. */
	private WebPelement lblManageNumbers = defineEelement(UIType.Xpath, "//div[@id='listing']/div/h2");
	
	/** The btn add numbers. */
	private WebPelement btnAddNumbers = defineEelement(UIType.ID,"add_number_row_button");
	
	/** The txt number. */
	private WebPelement txtNumber = defineEelement(UIType.Xpath,"//input[@class='required managenum_exist']");
	
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
	 * @author SulakkhanaW
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
		logger.debug("Entering password");
		Thread.sleep(sleepTime);
		WebElement paswd=driver.findElement(By.cssSelector("#loginForm>#pass"));
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
		
		logger.debug("Clearing existing number");
		List<WebElement> allElements = driver.findElements(By.xpath(lblNumber)); 
		List<String> stringList = new ArrayList<>();

			for (WebElement element: allElements) {
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
	 */
	public String getRequestPayload() {
		return getElement(txtRequestPayload).getAttribute("value");
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
	
	public String getValueFromJson(String tag, String json){
		JsonParser p = new JsonParser();
		JsonObject o = p.parse(json).getAsJsonObject();
		o.get(tag);
		return o.get(tag).toString();
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
}
