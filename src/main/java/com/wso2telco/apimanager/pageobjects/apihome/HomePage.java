package com.wso2telco.apimanager.pageobjects.apihome;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.apimanager.pageobjects.apihome.apis.APIsPage;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class HomePage extends BasicPageObject {
	
	Logger logger = Logger.getLogger(HomePage.class);

	private WebPelement linkAPIs = defineEelement(UIType.Xpath, "//ul[@class='nav orderFix']/li[2]/a");
	
	private WebPelement linkMyApplications = defineEelement(UIType.Xpath, "//ul[@class='nav orderFix']/li[3]/a");
	
	private WebPelement linkMySubscriptions = defineEelement(UIType.Xpath, "//ul[@class='nav orderFix']/li[4]/a");
	
	private WebPelement linkManage = defineEelement(UIType.Xpath, "//ul[@class='nav orderFix']/li[5]/a");
	
	private WebPelement linkSandBox = defineEelement(UIType.Xpath, "//ul[@class='nav orderFix']/li[6]/a");

	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public APIsPage clickApiLink(){
		getElement(linkAPIs).click();
		return new APIsPage(driver);
	}
	
	public APIsPage clickMyApplicationsLink(){
		getElement(linkMyApplications).click();
		return new APIsPage(driver);
	}
	
	public APIsPage clickMySubscriptionsLink(){
		getElement(linkMySubscriptions).click();
		return new APIsPage(driver);
	}
	
	public APIsPage clickManageLink(){
		getElement(linkManage).click();
		return new APIsPage(driver);
	}
	
	public APIsPage clickSandBoxLink(){
		getElement(linkSandBox).click();
		return new APIsPage(driver);
	}
	
}
