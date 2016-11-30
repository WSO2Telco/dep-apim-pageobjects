package com.wso2telco.apimanager.pageobjects.apipublisher;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class APIPublisherLoginPage.
 */
public class APIPublisherLoginPage extends BasicPageObject{
	
	/** The logger. */
	Logger logger = Logger.getLogger(APIPublisherLoginPage.class);
	
	/** The txt username. */
	private WebPelement txtUsername = defineEelement(UIType.Xpath, "//input[@id='username']");
	
	/** The txt password. */
	private WebPelement txtPassword = defineEelement(UIType.Xpath, "//input[@id='pass']");
	
	/** The btn login. */
	private WebPelement btnLogin = defineEelement(UIType.Xpath, "//button[text()='Sign In']");

	/**
	 * Instantiates a new API publisher login page.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public APIPublisherLoginPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Enter username.
	 *
	 * @author SulakkhanaW
	 * @param username the username
	 */
	public void enterUsername(String username){
		logger.debug("Entering username");
		getElement(txtUsername).clearAndSendkeys(username);
		logger.debug("Entered username");
	}
	
	/**
	 * Enter password.
	 *
	 * @author SulakkhanaW
	 * @param password the password
	 */
	public void enterPassword(String password){
		logger.debug("Entering password");
		getElement(txtPassword).clearAndSendkeys(password);
		logger.debug("Entered password");
	}
	
	/**
	 * Click login.
	 *
	 * @author SulakkhanaW
	 */
	public void clickLogin(){
		logger.debug("Click on login button");
		getElement(btnLogin).click();
		logger.debug("Login button clicked");
	}

}
