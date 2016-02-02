package com.wso2telco.apimanager.pageobjects.publisher;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class PublisherHomePage.
 */
public class PublisherHomePage extends BasicPageObject {
	
	/** The logger. */
	Logger logger = Logger.getLogger(PublisherHomePage.class);
	
	/** The lbl username. */
	private WebPelement lblUsername = defineEelement(UIType.Xpath, "//li/a[@id='userMenu']");
	
	/**
	 * Instantiates a new publisher home page.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public PublisherHomePage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Checks if is login username.
	 *
	 * @author SulakkhanaW
	 * @param username the username
	 * @return true, if is login username
	 * @throws Exception the exception
	 */
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
