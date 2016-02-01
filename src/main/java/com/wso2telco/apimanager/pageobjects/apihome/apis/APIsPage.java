package com.wso2telco.apimanager.pageobjects.apihome.apis;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;
import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.apimanager.pageobjects.apihome.HomePage;

public class APIsPage extends BasicPageObject {
	
	Logger logger = Logger.getLogger(HomePage.class);
	
	private WebPelement lblAPIs = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	private WebPelement lblApiStatus = defineEelement(UIType.Xpath, "//th[text()[contains(.,'Status')]]/../td");
	
	private WebPelement ddlApplication = defineEelement(UIType.ID, "application-list");
	
	private WebPelement btnSubscribe = defineEelement(UIType.ID, "subscribe-button");
	
	private WebPelement lblSubsSuccess = defineEelement(UIType.Xpath, "//div[@id='messageModal']/div[1]/h3");
	
	private WebPelement btnGoToSubscriber = defineEelement(UIType.Xpath, "//a[contains(text(),'Go to My Subscriptions')]");
	
	public APIsPage(WebDriver driver) {
		super(driver);
	}

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
	
	public void clickCreatedAPI(String apiName){
		String xpath = "//a[text()[contains(.,'" + apiName + "')]]";		
		WebPelement lnkCreatedAPI = defineEelement(UIType.Xpath, xpath);
		getElement(lnkCreatedAPI).click();
	}
	
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
	
	public void clickApplicationDropDown(){
		getElement(ddlApplication).click();
	}
	
	public boolean isApplicationNameNotVisible(String appname) throws Exception {
		flag = false;
		logger.debug("Validating created application name before approving");
		List<WebElement> tabs = driver.findElements(By.xpath("//select[@id='application-list']//option"));
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
	
	public boolean isApplicationNameVisible(String appname) throws Exception{
		flag = false;
		logger.debug("Validating created application name after approving");
		List<WebElement> tabs = driver.findElements(By.xpath("//select[@id='application-list']//option"));
		int tabCount = tabs.size();
		try {
			for (int x = 0; x < tabCount; x++) {
				if (tabs.get(x).getText().trim().contains(appname)) {
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
	
	public void clickAppName(String appname) throws InterruptedException{
		String xpath = "//select[@id='application-list']//option[contains(text(),'"+appname+"')]";
		WebPelement lblappname = defineEelement(UIType.Xpath, xpath);
		Thread.sleep(1000);
		getElement(ddlApplication).click();
		getElement(lblappname).click();
		getElement(lblappname).sendEnter();
	}
	
	public void clickOperator(String operator){
		String xpath = "//select[@id='operators']/option[contains(text(),'"+operator+"')]";
		WebPelement lbloperator = defineEelement(UIType.Xpath, xpath);
		getElement(lbloperator).click();
	}
	
	public void clickSubscribe(){
		getElement(btnSubscribe).click();
	}
	
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
	
	public void clickGoToSubscriber(){
		getElement(btnGoToSubscriber).click();
	}
}
