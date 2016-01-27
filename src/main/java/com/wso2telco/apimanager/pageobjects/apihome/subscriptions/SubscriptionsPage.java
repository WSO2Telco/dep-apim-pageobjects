package com.wso2telco.apimanager.pageobjects.apihome.subscriptions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class SubscriptionsPage extends BasicPageObject  {
	
	Logger logger = Logger.getLogger(SubscriptionsPage.class);
	
	private WebPelement lblSubscriptions = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	private WebPelement lblAppName = defineEelement(UIType.Xpath, "//div[@id='s2id_appListSelected']/a/span[1]");
	
	private WebPelement txtTokenValidityProd = defineEelement(UIType.Xpath, "//input[@id='refreshProdValidityTime']");
	
	private WebPelement btnGenerateProd = defineEelement(UIType.Xpath, "//button[@data-keytype='PRODUCTION']");
	
	private WebPelement btnGenerateSand = defineEelement(UIType.Xpath, "//button[@data-keytype='SANDBOX']");
	
	private WebPelement txtTokenValiditySand = defineEelement(UIType.Xpath, "//input[@id='refreshSandValidityTime']");
	
	private WebPelement lblConsKeyProd = defineEelement(UIType.Xpath, "//div[@class='consumerKey']/span");
	
	private WebPelement lblSecKeyProd = defineEelement(UIType.Xpath, "//div[@class='consumerSecret']/span");
	
    private WebPelement lblConsKeySand = defineEelement(UIType.Xpath, "//input[@id='refreshSandValidityTime']/../../div[4]/span");
	
	private WebPelement lblSecKeySand = defineEelement(UIType.Xpath, "//input[@id='refreshSandValidityTime']/../../div[5]/span");
	
	private WebPelement btnReGenerateProd = defineEelement(UIType.Xpath, "//div[@class='consumerKey']/span/../../div[3]/button");
	
	private WebPelement btnReGenerateSand = defineEelement(UIType.Xpath, "//input[@id='refreshSandValidityTime']/../../div[3]/button");
	
	public SubscriptionsPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isSubscriptionHeaderDisplayed(String header) throws Exception {

		flag = false;
		logger.debug("Validating Subscription Header");
		Thread.sleep(10000);
		try {
			if (header.contains(getElement(lblSubscriptions).getText())) {
				flag = true;
				logger.debug("Validating Subscription Header completed");
			} else {
				logger.debug("Subscription Header is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Subscription Header Page Title 'isSubscriptionHeaderDisplayed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Subscription Header Page Title 'isSubscriptionHeaderDisplayed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	public boolean isNoSubscriptionMsg(String msg) throws Exception{
		flag = false;
		logger.debug("Validating No Subscription message");
		WebPelement lblSubscroptionMsg = defineEelement(UIType.Xpath, "//div/b");
		try {
			if (getElement(lblSubscroptionMsg).getText().trim().contains(msg)){
				flag = true;
				logger.debug("No Subscription message is visible");
			} else {
				logger.debug("No Subscription message is not visible");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating No Subscription message 'isNoSubscriptionMsg()'" + e.getMessage());
			throw new Exception("Exception While Validating No Subscription message 'isNoSubscriptionMsg()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public boolean isAppsWithSubscriptions(String appname) throws Exception{
		flag = false;
		logger.debug("Validating Applications with subscription");
		try {
			if (getElement(lblAppName).getText().equalsIgnoreCase(appname)){
				flag = true;
				logger.debug("Applications with subscription is visible");
			} else {
				logger.debug("Applications with subscription is visible");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Applications with subscription 'isAppsWithSubscriptions()'" + e.getMessage());
			throw new Exception("Exception While Validating Applications with subscription 'isAppsWithSubscriptions()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public void enterTokenValidityProd(String validity){
		getElement(txtTokenValidityProd).clearAndSendkeys(validity);
	}
	
	public void clickProdGen(){
		getElement(btnGenerateProd).click();
	}
	
	public void clickSandGen(){
		getElement(btnGenerateSand).click();
	}
	
	public void enterTokenValiditySand(String validity){
		getElement(txtTokenValiditySand).clearAndSendkeys(validity);
	}
	
	public String getConsKeyProd(){
		String ConsKeyProd = getElement(lblConsKeyProd).getText();
		return ConsKeyProd;
	}
	
	public String geteSecKeyProd(){
		String SecKeyProd = getElement(lblSecKeyProd).getText();
		return SecKeyProd;
	}
	
	public String getConsKeySand(){
		String ConsKeySand = getElement(lblConsKeySand).getText();
		return ConsKeySand;
	}
	
	public String getSecKeySand(){
		String SecKeySand = getElement(lblSecKeySand).getText();
		return SecKeySand;
	}
	
	public void clickReGenProd(){
		getElement(btnReGenerateProd).click();
	}
	
	public void clickReGenSand(){
		getElement(btnReGenerateSand).click();
	}
	
	public boolean isTokenValidityProd(String validity) throws Exception {

		flag = false;
		logger.debug("Validating Token Validity of Production");
		Thread.sleep(10000);
		try {
			if (validity.contains(getElement(txtTokenValidityProd).getText())) {
				flag = true;
				logger.debug("Validating Token Validity of Production completed");
			} else {
				logger.debug("Token Validity of Production is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Token Validity of Production Page Title 'isTokenValidityProd()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Token Validity of Production Page Title 'isTokenValidityProd()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	public boolean isTokenValiditySand(String validity) throws Exception {

		flag = false;
		logger.debug("Validating Token Validity of Sandbox");
		Thread.sleep(10000);
		try {
			if (validity.contains(getElement(txtTokenValiditySand).getText())) {
				flag = true;
				logger.debug("Validating Token Validity of Sandbox completed");
			} else {
				logger.debug("Token Validity of Sandbox is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Token Validity of Sandbox Page Title 'isTokenValiditySand()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Token Validity of Sandbox Page Title 'isTokenValiditySand()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
}

