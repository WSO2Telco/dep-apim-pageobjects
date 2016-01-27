package com.wso2telco.apimanager.pageobjects.apihome.sandbox;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.apimanager.pageobjects.apihome.manager.ManagerPage;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class SandBoxPage extends BasicPageObject  {
	
	Logger logger = Logger.getLogger(ManagerPage.class);

	private WebPelement lblLogin = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	private WebPelement txtUserName = defineEelement(UIType.Xpath, "//form[@id='loginForm']/input[1]");
	
	private WebPelement txtPassword = defineEelement(UIType.Xpath, "//form[@id='loginForm']/input[2]");
	
	private WebPelement btnLogIn = defineEelement(UIType.Xpath, "//input[@id='loginButton']");
	
	private WebPelement lblWelcome = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	private WebPelement btnUserName = defineEelement(UIType.Xpath, "//a[@id='userMenu']");
	
	private WebPelement btnLogout = defineEelement(UIType.Xpath, "//li[@class='logout-link-special']/button");
	
	public SandBoxPage(WebDriver driver) {
		super(driver);
	}

	public boolean isSandboxLoginPage(String sandbobLoginHeader) throws Exception{
		flag = false;
		logger.debug("Validating Sandbox login page");
		try {
			if (getElement(lblLogin).getText().equalsIgnoreCase(sandbobLoginHeader)){
				flag = true;
				logger.debug("Sandbox login page is load properly");
			} else {
				logger.debug("Sandbox login page is not load properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Sandbox login page 'isSandboxLoginPage()'" + e.getMessage());
			throw new Exception("Exception While Validating Sandbox login page 'isSandboxLoginPage()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public void enterUserName(String username){
		getElement(txtUserName).clearAndSendkeys(username);
	}
	
	public void enterPassword(String password){
		getElement(txtPassword).clearAndSendkeys(password);
	}
	
	public void clickLogin(){
		getElement(btnLogIn).click();
	}
	
	public boolean isSandboxWelcome(String welcome) throws Exception{
		flag = false;
		logger.debug("Validating Sandbox welcome page");
		try {
			if (getElement(lblWelcome).getText().equalsIgnoreCase(welcome)){
				flag = true;
				logger.debug("Sandbox welcome page is load properly");
			} else {
				logger.debug("Sandbox welcome page is not load properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Sandbox welcome page 'isSandboxWelcome()'" + e.getMessage());
			throw new Exception("Exception While Validating Sandbox welcome page 'isSandboxWelcome()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public void clickUserName(){
		getElement(btnUserName).click();
	}
	
	public void clickLogout(){
		getElement(btnLogout).click();
	}
}
