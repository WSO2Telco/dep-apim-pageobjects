package com.wso2telco.apimanager.pageobjects.apihome.apis;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;
import com.wso2telco.apimanager.pageobjects.BasicPageObject;

/**
 * The Class APIsPage.
 */
public class APIsPage extends BasicPageObject {
	
	/** The logger. */
	Logger logger = Logger.getLogger(APIsPage.class);
	
	/** The lbl ap is. */
	private WebPelement lblAPIs = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	/** The lbl api status. */
	private WebPelement lblApiStatus = defineEelement(UIType.Xpath, "//th[text()[contains(.,'Status')]]/../td");
	
	/** The ddl application. */
	private WebPelement ddlApplication = defineEelement(UIType.ID, "application-list");
	
	/** The btn subscribe. */
	private WebPelement btnSubscribe = defineEelement(UIType.ID, "subscribe-button");
	
	/** The lbl subs success. */
	private WebPelement lblSubsSuccess = defineEelement(UIType.Xpath, "//div[@id='messageModal']/div[1]/h3");
	
	/** The btn go to subscriber. */
	private WebPelement btnGoToSubscriber = defineEelement(UIType.Xpath, "//a[contains(text(),'Go to My Subscriptions')]");
	
	/** The ddl tabs. */
	private String ddlTabs = "//select[@id='application-list']//option";
	
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
		String xpath = "//a[text()[contains(.,'" + apiName + "')]]";		
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
	public void clickCreatedAPI(String apiName){
		String xpath = "//a[text()[contains(.,'" + apiName + "')]]";		
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
	 */
	public void clickApplicationDropDown(){
		logger.debug("Clicking on Application drop down");
		getElement(ddlApplication).click();
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
		ArrayList<String> tabs = verifyListContent(UIType.Xpath, ddlTabs);
		int tabCount = tabs.size();
		try {
			for (int x = 0; x < tabCount; x++) {
				if (tabs.get(x).trim().contains(appname)) {
					flag = true;
					logger.debug("Application name is visible after approving");
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
		String xpath = "//select[@id='application-list']//option[contains(text(),'"+appname+"')]";
		WebPelement lblappname = defineEelement(UIType.Xpath, xpath);
		Thread.sleep(1000);
		logger.debug("Clicking on Application name drop down");
		getElement(ddlApplication).click();
		logger.debug("Clicked on Application name drop down");
		logger.debug("Clicking on Application name");
		getElement(lblappname).click();
		logger.debug("Clicking on Application name");
		logger.debug("Sending enter key");
		getElement(lblappname).sendEnter();
		logger.debug("Send enter key");
	}
	
	/**
	 * Click operator.
	 *
	 * @author SulakkhanaW
	 * @param operator the operator
	 */
	public void clickOperator(String operator){
		String xpath = "//select[@id='operators']/option[contains(text(),'"+operator+"')]";
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
	 */
	public void clickGoToSubscriber(){
		logger.debug("Clicking on go to subscribe");
		getElement(btnGoToSubscriber).click();
		logger.debug("Clicked on go to subscribe");
	}
}
