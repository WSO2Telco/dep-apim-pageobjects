package com.wso2telco.apimanager.pageobjects.publisher;

import org.openqa.selenium.WebDriver;
import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class PublisherHomePage extends BasicPageObject {
	
	private WebPelement lblUsername = defineEelement(UIType.Xpath, "//li/a[@id='userMenu']");
	
	public PublisherHomePage(WebDriver driver) {
		super(driver);
	}
	
	public boolean validateLoginUsername(String username){
		return getElement(lblUsername).getText().equalsIgnoreCase(username);
	}

}
