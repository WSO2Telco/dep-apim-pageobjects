package com.wso2telco.apimanager.pageobjects.apihome.apis;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;
import com.wso2telco.apimanager.pageobjects.BasicPageObject;

// TODO: Auto-generated Javadoc
/**
 * The Class APIsPage.
 */
public class APIsPage extends BasicPageObject {
	
	/** The logger. */
	Logger logger = Logger.getLogger(APIsPage.class);
	
	/** The lbl ap is. */
	private WebPelement lblAPIs = defineEelement(UIType.Xpath, "//div[@class='page-header']/h2");
	
	/** The lbl api status. */
	private WebPelement lblApiStatus = defineEelement(UIType.Xpath, "//strong[contains(text(),'Status')]/../../div//span");
	
	/** The dd application. */
	private WebPelement ddApplicationName = defineEelement(UIType.Xpath, "//label[text()='Applications']/following-sibling::*/button");
	
	/** The ddl application. */
	private WebPelement ddlApplication = defineEelement(UIType.Xpath, "//label[text()='Applications']/following-sibling::*/select/optgroup/option");
	
	/** The ddl application Name. */
	private String ddlAppName = "//select[@id='application-list']/optgroup/option[text()='%s']";
	
	/** The list app name. */
	//private String listAppName = "//*[@id='application-list']/optgroup/option[text()='%s']";
	
	/** The btn subscribe. */
	private WebPelement btnSubscribe = defineEelement(UIType.ID, "subscribe-button");
	
	/** The lbl subs success. */
	private WebPelement lblSubsSuccess = defineEelement(UIType.Xpath, "//div[@id='messageModal']//h3");
	
	/** The btn go to subscriber. */
	private WebPelement btnGoToSubscriber = defineEelement(UIType.Xpath, "//a[contains(text(),'View Subscriptions')]");
	
	/** The ddl tabs. */
	private String ddlTabs = "//select[@id='application-list']//option";
	
	/** The lnk api name.
	 * %_1 = apiName
	 **/
	private String lnkAPIName = "//a[contains(text(),'%s')]/../preceding-sibling::*/a[contains(@title,'%s')]";
	

	/** The ddl operator.
	 * %s_1 = operator
	 **/
	private String ddlOperator = "//select[@id='operators']/option[contains(text(),'%s')]";
	
	/** The txt API Search*/
	private WebPelement txtSearchAPI = defineEelement(UIType.Xpath, "//input[@title='apim_search']");
	
	/** The btn search. */
	private WebPelement btnSearch = defineEelement(UIType.Xpath, "//button[@title='Search']");
	
	/**
	 * Instantiates a new AP is page.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public APIsPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Checks if is API page.
	 *
	 * @author SulakkhanaW
	 * @param apiHeader the api header
	 * @return true, if is API page
	 * @throws Exception the exception
	 */
	public boolean isAPIPage(String apiHeader) throws Exception{
		flag = false;
		logger.debug("Validating API page loaded properly");
		try {
			if (getElement(lblAPIs).getText().equalsIgnoreCase(apiHeader)){
				flag = true;
				logger.debug("API page loaded properly");
			} else {
				logger.debug("API page did not load properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating API page header 'isAPIPage()'" + e.getMessage());
			throw new Exception("Exception While Validating API page header 'isAPIPage()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Checks if is created api on api page.
	 *
	 * @param apiName the api name
	 * @return true, if is created api on api page
	 * @throws Exception the exception
	 */
	public boolean isCreatedAPIOnAPIPage(String apiName) throws Exception{
		flag = false;
		String xpath = String.format(lnkAPIName, apiName);
		ArrayList<String> actFirstSecQstList = new ArrayList<String>();
		List<WebElement> options = driver.findElements(By.xpath(xpath));
		try {
			for (WebElement option : options) {
				actFirstSecQstList.add(option.getAttribute("title"));
			}
			for (int x = 0; x < actFirstSecQstList.size(); x++) {
				if (actFirstSecQstList.get(x).trim().contains(apiName)) {
					flag = true;
					logger.debug("API name is visible");
				} else {
					logger.debug("API name is not visible");
				}
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating API name 'isCreatedAPIOnAPIPage()'" + e.getMessage());
			throw new Exception("Exception While Validating API name 'isCreatedAPIOnAPIPage()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Checks if is created api.
	 *
	 * @author SulakkhanaW
	 * @param apiName the api name
	 * @return true, if is created api
	 * @throws Exception the exception
	 */
	public boolean isCreatedAPI(String apiName) throws Exception{
		flag = false;
		logger.debug("Validating created API");
		String xpath = String.format(lnkAPIName, apiName);		
		WebPelement lnkCreatedAPI = defineEelement(UIType.Xpath, xpath);
		try {
			if (getElement(lnkCreatedAPI).getText().trim().contains(apiName)){
				flag = true;
				logger.debug("API created properly");
			} else {
				logger.debug("API not created properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating created API 'isCreatedAPI()'" + e.getMessage());
			throw new Exception("Exception While Validating created API 'isCreatedAPI()'"  + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click created api.
	 *
	 * @author SulakkhanaW
	 * @param apiName the api name
	 */
	public void clickCreatedAPI(String apiName, String apiVersion){
		String xpath = String.format(lnkAPIName, apiVersion, apiName);		
		WebPelement lnkCreatedAPI = defineEelement(UIType.Xpath, xpath);
		logger.debug("Clicking on create API");
		getElement(lnkCreatedAPI).click();
		logger.debug("Clicked on create API");
	}
	
	/**
	 * Checks if is API status.
	 *
	 * @author SulakkhanaW
	 * @param status the status
	 * @return true, if is API status
	 * @throws Exception the exception
	 */
	public boolean isAPIStatus(String status) throws Exception{
		flag = false;
		logger.debug("Validating created API status");
		try {
			if (getElement(lblApiStatus).getText().trim().equalsIgnoreCase(status)){
				flag = true;
				logger.debug("Created API status as expected");
			} else {
				logger.debug("Created API status mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating API status 'isAPIStatus()'" + e.getMessage());
			throw new Exception("Exception While Validating API status 'isAPIStatus()'"  + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click application drop down.
	 *
	 * @author SulakkhanaW
	 * @throws InterruptedException the interrupted exception
	 */
	public void clickApplicationDropDown() throws InterruptedException{
		logger.debug("Clicking on Application drop down");
		getElement(ddApplicationName).click();
		Thread.sleep(sleepTime);
		logger.debug("Clicked on Application drop down");
	}
	
	/**
	 * Checks if is application name not visible.
	 *
	 * @author SulakkhanaW
	 * @param appname the appname
	 * @return true, if is application name not visible
	 * @throws Exception the exception
	 */
	public boolean isApplicationNameNotVisible(String appname) throws Exception {
		flag = false;
		logger.debug("Validating created application name before approving");
		ArrayList<String> tabs = verifyListContent(UIType.Xpath, ddlTabs);
		try {
			if (!tabs.contains(appname)) {
				flag = true;
				logger.debug("Application name is not visible before approving");
			} else {
				logger.debug("Application name is visible before approving");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating created Application visible in API 'isCreatedAppName()'" + e.getMessage());
			throw new Exception("Exception While Validating created Application visible in API 'isCreatedAppName()'"  + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Checks if is application name visible.
	 *
	 * @author SulakkhanaW
	 * @param appname the appname
	 * @return true, if is application name visible
	 * @throws Exception the exception
	 */
	public boolean isApplicationNameVisible(String appname) throws Exception{
		flag = false;
		logger.debug("Validating created application name after approving");
		ArrayList<String> actFirstSecQstList = new ArrayList<String>();
		WebElement select = getElement(UIType.Xpath, ddlTabs);
		List<WebElement> options = select.findElements(By.xpath(ddlTabs));
		try {
			for (WebElement option : options) {
				actFirstSecQstList.add(option.getText());
				}
			for (int x = 0; x < actFirstSecQstList.size(); x++) {
				if (actFirstSecQstList.get(x).trim().contains(appname)) {
					flag = true;
					getElement(ddlApplication).sendKeys(Keys.ESCAPE);
					logger.debug("Application name is visible after approving");
					break;
				} else {
					logger.debug("Application name is not visible after approving");
				}
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating created Application visible in API 'isApplicationNameVisible()'" + e.getMessage());
			throw new Exception("Exception While Validating created Application visible in API 'isApplicationNameVisible()'"  + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click app name.
	 *
	 * @author SulakkhanaW
	 * @param appname the appname
	 * @throws InterruptedException the interrupted exception
	 */
	public void clickAppName(String appname) throws InterruptedException{
		Thread.sleep(1000);
		String xpath = String.format(ddlAppName, appname);
		WebPelement appNameItem = defineEelement(UIType.Xpath, xpath);
		getElement(appNameItem).click();
		logger.debug("Clicked on Application name drop down");
		logger.debug("Sending enter key");
//		getElement(ddlApplication).sendEnter();
		logger.debug("Send enter key");
	}
	
	/**
	 * Click operator.
	 *
	 * @author SulakkhanaW
	 * @param operator the operator
	 */
	public void clickOperator(String operator){
		String xpath = String.format(ddlOperator, operator);
		WebPelement lbloperator = defineEelement(UIType.Xpath, xpath);
		logger.debug("Clicking on operator");
		getElement(lbloperator).click();
		logger.debug("Clicked on operator");
	}
	
	/**
	 * Click subscribe.
	 *
	 * @author SulakkhanaW
	 */
	public void clickSubscribe(){
		logger.debug("Clicking on subscribe");
		getElement(btnSubscribe).click();
		logger.debug("Clicked on subscribe");
	}
	
	/**
	 * Checks if is subscription success popup.
	 *
	 * @author SulakkhanaW
	 * @param popupMsg the popup msg
	 * @return true, if is subscription success popup
	 * @throws Exception the exception
	 */
	public boolean isSubscriptionSuccessPopup(String popupMsg) throws Exception{
		Thread.sleep(sleepTime);
		flag = false;
		logger.debug("Validating subscription success popup");
		try {
			if (getElement(lblSubsSuccess).getText().equalsIgnoreCase(popupMsg)){
				flag = true;
				logger.debug("Subscription success popup loaded properly");
			} else {
				logger.debug("Subscription success popup not loaded properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating subscription popup 'isSubscriptionSuccessPopup()'" + e.getMessage());
			throw new Exception("Exception While Validating subscription popup 'isSubscriptionSuccessPopup()'"  + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click go to subscriber.
	 *
	 * @author SulakkhanaW
	 * @throws InterruptedException the interrupted exception
	 */
	public void clickGoToSubscriber() throws InterruptedException{
		//WebPelement workround = defineEelement(UIType.Xpath, "//div[@class='modal-footer']/a[@class='btn btn btn-primary']");
		logger.debug("Clicking on go to subscribe");
		Thread.sleep(sleepTime);
		getElement(btnGoToSubscriber).click();
		Thread.sleep(sleepTime);
		//getElement(workround).click();
		logger.debug("Clicked on go to subscribe");
	}
	
	/**
	 * Enter api name search.
	 *
	 * @author MalshaniS
	 * @param apiName the api name
	 */
	public void enterAPINameSearch(String apiName){
		logger.debug("Enter API name on the search text box");
		getElement(txtSearchAPI).clearAndSendkeys(apiName);
		logger.debug("Entered API name on the search text box");
	}
	
	/**
	 * Click search.
	 *
	 * @author MalshaniS
	 */
	public void clickSearch(){
		logger.debug("Clicking on search");
		getElement(btnSearch).click();
		logger.debug("Clicked on search");
	}
}
