package com.wso2telco.apimanager.pageobjects.apihome.applications;

import org.openqa.selenium.WebDriver;
import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class ApplicationsPage extends BasicPageObject  {

	private WebPelement lblApplications = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	private WebPelement lblApplicationForm = defineEelement(UIType.Xpath, "//form[@id='appAddForm']/h3");
	
	private WebPelement txtApplicationName = defineEelement(UIType.Xpath, "//input[@id='application-name']");
	
	private WebPelement txtApplicationCallbackUrl = defineEelement(UIType.Xpath, "//input[@id='callback-url']");
	
	private WebPelement txtApplicationDescription = defineEelement(UIType.Xpath, "//textarea[@id='description']");
	
	private WebPelement btnAppAdd = defineEelement(UIType.Xpath, "//input[@id='application-add-button']");
	
	private WebPelement lblApplicationName = defineEelement(UIType.Xpath, "//table[@id='applicationTable']//tr[1]/td[1]");
	
	private WebPelement ddlTier = defineEelement(UIType.Xpath, "//table[@id='applicationTable']//tr[1]/td[2]/select");
	
	private WebPelement lblStatus = defineEelement(UIType.Xpath, "//table[@id='applicationTable']//tr[1]/td[3]");
	
	private WebPelement lblCallbackurl = defineEelement(UIType.Xpath, "//table[@id='applicationTable']//tr[1]/td[4]");
	
	private WebPelement lblDescription = defineEelement(UIType.Xpath, "//table[@id='applicationTable']//tr[1]/td[5]");
	
	public ApplicationsPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean validateApplicationPage(){
		return getElement(lblApplications).getText().equalsIgnoreCase("Applications");
	}
	
	public boolean validateApplicationFormHeader(){
		return  getElement(lblApplicationForm).getText().trim().equalsIgnoreCase("Add New Application");
	}
	
	public void enterAppllicationName(String applicationName){
		getElement(txtApplicationName).clearAndSendkeys(applicationName);
	}
	
	public void enterAppllicationCallbackUrl(String applicationCallbackUrl){
		getElement(txtApplicationCallbackUrl).clearAndSendkeys(applicationCallbackUrl);
	}
	
	public void enterAppllicationDescription(String description){
		getElement(txtApplicationDescription).clearAndSendkeys(description);
	}
	
	public void clickApplicationAdd(){
		getElement(btnAppAdd).click();
	}
	
	public boolean validateApplicationName(String appName){
		return getElement(lblApplicationName).getText().trim().contains(appName);
	}
	
	public boolean validateTeirname(String teir){
		return getElement(ddlTier).getText().trim().contains(teir);
	}
	
	public boolean validateStatus(String status){
		return getElement(lblStatus).getText().trim().contains(status);
	}
	
	public boolean validateCallbackurl(String url){
		return getElement(lblCallbackurl).getText().trim().contains(url);
	}
	
	public boolean validateDescription(String description){
		return getElement(lblDescription).getText().trim().contains(description);
	}

}
