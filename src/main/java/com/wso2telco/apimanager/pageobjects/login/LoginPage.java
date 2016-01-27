package com.wso2telco.apimanager.pageobjects.login;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.apimanager.pageobjects.apihome.subscriptions.SubscriptionsPage;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class LoginPage extends BasicPageObject {
	
	Logger logger = Logger.getLogger(SubscriptionsPage.class);
	
	private WebPelement btnSignUp = defineEelement(UIType.Xpath, "//a[@id='register-link']");
	
	private WebPelement linkLogin = defineEelement(UIType.Xpath, "//a[@id='login-link']");
	
	private WebPelement txtLoginUserName = defineEelement(UIType.Xpath, "//input[@id='username']");
	
	private WebPelement txtLoginPassword = defineEelement(UIType.Xpath, "//input[@id='password']");
	
	private WebPelement btnLogin = defineEelement(UIType.Xpath, "//a[@id='loginBtn']");
	
	private WebPelement lblLogin = defineEelement(UIType.Xpath, "//div[@class='modal-header']/h3");
	
	private WebPelement lblUserName = defineEelement(UIType.Xpath, "//a[@class='link-to-user dropdown-toggle']");
	
	private WebPelement ddUserName = defineEelement(UIType.Xpath, "//a[@class='link-to-user dropdown-toggle']/b[1]");
	
	private WebPelement btnLogout = defineEelement(UIType.Xpath, "//button[@id='logout-link']");
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void clickSignUp(){
		getElement(btnSignUp).click();
	}
	
    public void clickLogInLink(){
    	getElement(linkLogin).click();
	}
	
	public boolean isLoginDisplayed(String header) throws Exception {

		flag = false;
		logger.debug("Validating Login pop up header");
		Thread.sleep(10000);
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
	
	public void enterLoginUserName(String userName){
		getElement(txtLoginUserName).clearAndSendkeys(userName);
	}
	
	public void enterLoginPassword(String password){
		getElement(txtLoginPassword).clearAndSendkeys(password);
	}
	
	public void clickLogInButton(){
		getElement(btnLogin).click();
	}
	
	public boolean validateUserName(String username){
		return getElement(lblUserName).getText().equalsIgnoreCase(username);
	}
	
	public void clickOnUserName(){
		getElement(ddUserName).click();
	}
	
	public void clickLogout(){
		getElement(btnLogout).click();
	}
	
	public boolean validateLogin(){
		return getElement(linkLogin).getText().equalsIgnoreCase("Login");
	}
	
	public boolean validateSignUp(){
		return getElement(btnSignUp).getText().equalsIgnoreCase("Sign-up");
	}
}
