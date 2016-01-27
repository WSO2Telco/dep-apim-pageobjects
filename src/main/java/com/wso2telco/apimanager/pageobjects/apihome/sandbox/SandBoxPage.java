package com.wso2telco.apimanager.pageobjects.apihome.sandbox;

import org.openqa.selenium.WebDriver;
import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class SandBoxPage extends BasicPageObject  {

	private WebPelement lblLogin = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	private WebPelement txtUserName = defineEelement(UIType.Xpath, "//form[@id='loginForm']/input[1]");
	
	private WebPelement txtPassword = defineEelement(UIType.Xpath, "//form[@id='loginForm']/input[2]");
	
	private WebPelement btnLogIn = defineEelement(UIType.Xpath, "//input[@id='loginButton']");
	
	//need to validate using a proper element
	private WebPelement lblWelcome = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	private WebPelement btnUserName = defineEelement(UIType.Xpath, "//a[@id='userMenu']");
	
	private WebPelement btnLogout = defineEelement(UIType.Xpath, "//li[@class='logout-link-special']/button");
	
	public SandBoxPage(WebDriver driver) {
		super(driver);
	}

	public boolean validateLoginPage(){
		return getElement(lblLogin).getText().equalsIgnoreCase("Login");
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
	
	//need to validate using a proper element
	public boolean validateWelcome(){
		return getElement(lblWelcome).getText().equalsIgnoreCase("Welcome");
	}
	
	public void clickUserName(){
		getElement(btnUserName).click();
	}
	
	public void clickLogout(){
		getElement(btnLogout).click();
	}
}
