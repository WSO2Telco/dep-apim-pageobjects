package com.wso2telco.apimanager.pageobjects.publisher;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.apimanager.pageobjects.apihome.subscriptions.SubscriptionsPage;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class PublisherHomePage extends BasicPageObject {
	
	Logger logger = Logger.getLogger(SubscriptionsPage.class);
	
	private WebPelement lblUsername = defineEelement(UIType.Xpath, "//li/a[@id='userMenu']");
	
	public PublisherHomePage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isLoginUsername(String username) throws Exception{
		flag = false;
		logger.debug("Validating publisher login");
		try {
			if (getElement(lblUsername).getText().equalsIgnoreCase(username)){
				flag = true;
				logger.debug("Login is success");
			} else {
				logger.debug("Login failed");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating publisher login 'isUserName()'" + e.getMessage());
			throw new Exception("Exception While Validating publisher login 'isUserName()'" + e.getLocalizedMessage());
		}
		return flag;
	}

}
