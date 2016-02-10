package com.wso2telco.apimanager.pageobjects.login;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class LoginPage.
 */
public class LoginPage extends BasicPageObject {
	
	/** The logger. */
	Logger logger = Logger.getLogger(LoginPage.class);
	
	/** The btn sign up. */
	private WebPelement btnSignUp = defineEelement(UIType.ID, "register-link");
	
	/** The link login. */
	private WebPelement linkLogin = defineEelement(UIType.ID, "login-link");
	
	/** The link login_ ie. */
	private WebPelement linkLogin_IE = defineEelement(UIType.Xpath, "//a[@id='login-link']");
	
	/** The txt login user name. */
	private WebPelement txtLoginUserName = defineEelement(UIType.ID, "username");
	
	/** The txt login password. */
	private WebPelement txtLoginPassword = defineEelement(UIType.ID, "password");
	
	/** The btn login. */
	private WebPelement btnLogin = defineEelement(UIType.ID, "loginBtn");
	
	/** The lbl login. */
	private WebPelement lblLogin = defineEelement(UIType.Xpath, "//div[@class='modal-header']/h3");
	
	/** The lbl user name. */
	private WebPelement lblUserName = defineEelement(UIType.Xpath, "//a[@class='link-to-user dropdown-toggle']");
	
	/** The dd user name. */
	private WebPelement ddUserName = defineEelement(UIType.Xpath, "//a[@class='link-to-user dropdown-toggle']/b[1]");
	
	/** The btn logout. */
	private WebPelement btnLogout = defineEelement(UIType.ID, "logout-link");
	
	
	/**
	 * Instantiates a new login page.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Click sign up.
	 *
	 * @author SulakkhanaW
	 */
	public void clickSignUp(){
		logger.debug("Clicking on signup");
		getElement(btnSignUp).click();
		logger.debug("Clicked on signup");
	}
	
    /**
     * Click log in link.
     *
     * @author SulakkhanaW
     */
    public void clickLogInLink() throws Exception{
    	logger.debug("Clicking on Login");
    	WebPelement eleLogin = linkLogin;
    	try {
    	if (config.getValue("browser").equalsIgnoreCase("INTERNETEXPLORER")){
    		eleLogin = linkLogin_IE;
    		logger.debug("Clicked on Login");
    	}
    	else{
    		getElement(eleLogin).click();
    		logger.debug("Clicked on Login");
    	}
    	} catch (Exception e) {
    	logger.debug("Exception While Clicking on Login 'clickLogInLink()'" + e.getMessage());
    	throw new Exception("Exception While Clicking on Login 'clickLogInLink()'" + e.getLocalizedMessage());
    	}
    	
	}
	
	/**
	 * Checks if is login displayed.
	 *
	 * @author SulakkhanaW
	 * @param header the header
	 * @return true, if is login displayed
	 * @throws Exception the exception
	 */
	public boolean isLoginDisplayed(String header) throws Exception {

		flag = false;
		logger.debug("Validating Login pop up header");
		Thread.sleep(sleepTime);
		try {
			if (header.contains(getElement(lblLogin).getText())) {
				flag = true;
				logger.debug("Validating Login pop up header completed");
			} else {
				logger.debug("Login pop up header is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Login pop up header Page Title 'isLoginDisplayed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Login pop up header Page Title 'isLoginDisplayed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Enter login user name.
	 *
	 * @author SulakkhanaW
	 * @param userName the user name
	 */
	public void enterLoginUserName(String userName){
		logger.debug("Entering Login username");
		getElement(txtLoginUserName).clearAndSendkeys(userName);
		logger.debug("Entered Login username");
	}
	
	/**
	 * Enter login password.
	 *
	 * @author SulakkhanaW
	 * @param password the password
	 */
	public void enterLoginPassword(String password){
		logger.debug("Entering Login password");
		getElement(txtLoginPassword).clearAndSendkeys(password);
		logger.debug("Entered Login password");
	}
	
	/**
	 * Click log in button.
	 *
	 * @author SulakkhanaW
	 */
	public void clickLogInButton(){
		logger.debug("Clicking on login button");
		getElement(btnLogin).click();
		logger.debug("Clicked on login button");
	}
	
	/**
	 * Checks if is user name.
	 *
	 * @author SulakkhanaW
	 * @param username the username
	 * @return true, if is user name
	 * @throws Exception the exception
	 */
	public boolean isUserName(String username) throws Exception{
		flag = false;
		logger.debug("Validating user name");
		try {
			if (getElement(lblUserName).getText().equalsIgnoreCase(username)){
				flag = true;
				logger.debug("User name matched");
			} else {
				logger.debug("User name mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating User name 'isUserName()'" + e.getMessage());
			throw new Exception("Exception While Validating User name 'isUserName()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click on user name.
	 *
	 * @author SulakkhanaW
	 */
	public void clickOnUserName(){
		logger.debug("Clicking on username");
		getElement(ddUserName).click();
		logger.debug("Clicked on username");
	}
	
	/**
	 * Click logout.
	 *
	 * @author SulakkhanaW
	 */
	public void clickLogout(){
		logger.debug("Clicking on logout");
		getElement(btnLogout).click();
		logger.debug("Clicked on logout");
	}
	
	/**
	 * Checks if is login.
	 *
	 * @author SulakkhanaW
	 * @param value the value
	 * @return true, if is login
	 * @throws Exception the exception
	 */
	public boolean isLogin(String value) throws Exception{
		flag = false;
		logger.debug("Validating Login button");
		try {
			WebPelement eleLogin = linkLogin;
			if (config.getValue("browser").equalsIgnoreCase("INTERNETEXPLORER")){
				eleLogin = linkLogin_IE;
				}
			if (getElement(eleLogin).getText().equalsIgnoreCase(value)){
				flag = true;
				logger.debug("Login button visible");
			} else {
				logger.debug("Login button not visible");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating User login button 'isLogin()'" + e.getMessage());
			throw new Exception("Exception While Validating User login button 'isLogin()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Checks if is sign up.
	 *
	 * @author SulakkhanaW
	 * @param value the value
	 * @return true, if is sign up
	 * @throws Exception the exception
	 */
	public boolean isSignUp(String value) throws Exception{
		flag = false;
		logger.debug("Validating Signup button");
		try {
			if (getElement(btnSignUp).getText().equalsIgnoreCase(value)){
				flag = true;
				logger.debug("Signup button visible");
			} else {
				logger.debug("Signup button not visible");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating User Signup button 'isSignUp()'" + e.getMessage());
			throw new Exception("Exception While Validating User Signup button 'isSignUp()'" + e.getLocalizedMessage());
		}
		return flag;
	}
}
