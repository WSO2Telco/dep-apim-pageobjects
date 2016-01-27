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
	
	private WebPelement ddlApplication = defineEelement(UIType.Xpath, "//select[@id='application-list']");
	
	private WebPelement btnSubscribe = defineEelement(UIType.Xpath, "//button[@id='subscribe-button']");
	
	private WebPelement lblSubsSuccess = defineEelement(UIType.Xpath, "//h3[contains(text(),'Subscription Successful')]");
	
	private WebPelement btnGoToSubscriber = defineEelement(UIType.Xpath, "//a[contains(text(),'Go to My Subscriptions')]");
	
	public APIsPage(WebDriver driver) {
		super(driver);
	}

	public boolean isAPIPage() throws Exception{
		flag = false;
		logger.debug("Validating API page loaded properly");
		try {
			if (getElement(lblAPIs).getText().equalsIgnoreCase("APIs")){
				flag = true;
				logger.debug("API page loaded properly");
			} else {
				logger.debug("API page did not load properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Answer Security Questions Page Title 'isAnswerSecurityQuestionsPage()'" + e.getMessage());
			throw new Exception("Exception While Validating Answer Security Questions Page Title 'isAnswerSecurityQuestionsPage()'" + e.getLocalizedMessage());
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
	
	public boolean validateApiStatus(String status){
		return getElement(lblApiStatus).getText().trim().equalsIgnoreCase(status);
	}
	
	public void clickApplicationDropDown(){
		getElement(ddlApplication).click();
	}
	
	public boolean validateAppName(String appname) {
		List<WebElement> tabs = driver.findElements(By.xpath("//select[@id='application-list']//option"));
		if (tabs.contains(appname)) {
			return false;
		}
		return true;
	}
	
	public boolean validateAppNameInApplications(String appname){
		List<WebElement> tabs = driver.findElements(By.xpath("//select[@id='application-list']//option"));
		if (tabs.contains(appname)) {
			return true;
		}
		return false;
	}
	
	public void clickAppName(String appname){
		String xpath = "//select[@id='application-list']//option[contains(text(),'"+appname+"')]";
		WebPelement lblappname = defineEelement(UIType.Xpath, xpath);
		getElement(lblappname).click();
	}
	
	public void clickOperator(String operator){
		String xpath = "//select[@id='operators']/option[contains(text(),'"+operator+"')]";
		WebPelement lbloperator = defineEelement(UIType.Xpath, xpath);
		getElement(lbloperator).click();
	}
	
	public void clickSubscribe(){
		getElement(btnSubscribe).click();
	}
	
	public boolean validateSubscriptionSuccessPopup(String popupMsg){
		return getElement(lblSubsSuccess).getText().equalsIgnoreCase(popupMsg);
	}
	
	public void clickGoToSubscriber(){
		getElement(btnGoToSubscriber).click();
	}
}
