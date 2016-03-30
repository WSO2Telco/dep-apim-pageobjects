package com.wso2telco.apimanager.pageobjects.publisher.login;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class PublisherLoginPage.
 */
public class PublisherLoginPage extends BasicPageObject  {
	
	/** The logger. */
	Logger logger = Logger.getLogger(PublisherLoginPage.class);
	
	/** The txt username. */
	private WebPelement txtUsername = defineEelement(UIType.Xpath, "//form/input[@id='username']");
	
	/** The txt password. */
	private WebPelement txtPassword = defineEelement(UIType.Xpath, "//form/input[@id='pass']");
	
	/** The btn login. */
	private WebPelement btnLogin = defineEelement(UIType.ID, "loginButton");
	
	/**
	 * Instantiates a new publisher login page.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public PublisherLoginPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Sets the publisher username.
	 *
	 * @author SulakkhanaW
	 * @param username the new publisher username
	 */
	public void setPublisherUsername(String username){
		logger.debug("Entering publisher username");
		getElement(txtUsername).clearAndSendkeys(username);
		logger.debug("Entered publisher username");
	}
	
	/**
	 * Sets the publisher password.
	 *
	 * @author SulakkhanaW
	 * @param password the new publisher password
	 */
	public void setPublisherPassword(String password){
		logger.debug("Entering publisher password");
		getElement(txtPassword).clearAndSendkeys(password);
		logger.debug("Entered publisher password");
	}

	/**
	 * Click login.
	 *
	 * @author SulakkhanaW
	 */
	public void clickLogin(){
		logger.debug("Clicking on login");
		getElement(btnLogin).click();
		logger.debug("Clicked on login");
	}

}
