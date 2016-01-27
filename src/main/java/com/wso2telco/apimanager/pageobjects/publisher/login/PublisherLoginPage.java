package com.wso2telco.apimanager.pageobjects.publisher.login;

import org.openqa.selenium.WebDriver;
import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class PublisherLoginPage extends BasicPageObject  {
	
	private WebPelement txtUsername = defineEelement(UIType.Xpath, "//form/input[@id='username']");
	
	private WebPelement txtPassword = defineEelement(UIType.Xpath, "//form/input[@id='pass']");
	
	private WebPelement btnLogin = defineEelement(UIType.Xpath, "//input[@id='loginButton']");
	
	public PublisherLoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void setPublisherUsername(String username){
		getElement(txtUsername).clearAndSendkeys(username);
	}
	
	public void setPublisherPassword(String password){
		getElement(txtPassword).clearAndSendkeys(password);
	}

	public void clickLogin(){
		getElement(btnLogin).click();
	}

}
