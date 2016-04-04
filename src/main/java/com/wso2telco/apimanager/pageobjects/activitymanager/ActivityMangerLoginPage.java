package com.wso2telco.apimanager.pageobjects.activitymanager;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class ActivityMangerLoginPage.
 */
public class ActivityMangerLoginPage extends BasicPageObject {

	/**
	 * Instantiates a new activity manger login page.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public ActivityMangerLoginPage(WebDriver driver) {
		super(driver);
	}
	
	/** The logger. */
	Logger logger = Logger.getLogger(ActivityMangerLoginPage.class);
	
	/** The txt username. */
	private WebPelement txtUsername = defineEelement(UIType.ID, "txtUserName");
	
	/** The txt password. */
	private WebPelement txtPassword = defineEelement(UIType.ID, "txtPassword");
	
	/** The btn signin. */
	private WebPelement btnSignin = defineEelement(UIType.Xpath, "//input[@value='Sign-in']");
	
	/**
	 * Sets the username.
	 *
	 * @author SulakkhanaW
	 * @param username the new username
	 */
	public void setUsername(String username){
		logger.debug("Typing username");
		getElement(txtUsername).clearAndSendkeys(username);
		logger.debug("Username typed");
	}
	
	/**
	 * Sets the password.
	 *
	 * @author SulakkhanaW
	 * @param password the new password
	 */
	public void setPassword(String password){
		logger.debug("Typing password");
		getElement(txtPassword).clearAndSendkeys(password);
		logger.debug("Password typed");
	}
	
	/**
	 * Click signin.
	 *
	 * @author SulakkhanaW
	 * @return the activity manager home page
	 * @throws Exception the exception
	 */
	public ActivityManagerHomePage clickSignin() throws Exception{
		try {
			logger.debug("Start clicking on sign in");
			getElement(btnSignin).click();
			logger.debug("Clicked on signin");
		} catch (Exception e) {
			logInstruction("Exception While clicking on sign in 'clickSignin()'" + e.getMessage());
			throw new Exception("Exception While clicking on sign in 'clickSignin()'" + e.getLocalizedMessage());
		}
		return new ActivityManagerHomePage(driver);
	}

}
