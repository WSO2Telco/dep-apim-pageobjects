package com.wso2telco.apimanager.pageobjects.apihome.subscriptions;

import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class SubscriptionsPage extends BasicPageObject  {
	
	private WebPelement lblSubscriptions = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	private WebPelement lblAppName = defineEelement(UIType.Xpath, "//div[@id='s2id_appListSelected']/a/span[1]");
	
	private WebPelement txtTokenValidityProd = defineEelement(UIType.Xpath, "//input[@id='refreshProdValidityTime']");
	
	private WebPelement btnGenerateProd = defineEelement(UIType.Xpath, "//button[@data-keytype='PRODUCTION']");
	
	private WebPelement btnGenerateSand = defineEelement(UIType.Xpath, "//button[@data-keytype='SANDBOX']");
	
	private WebPelement txtTokenValiditySand = defineEelement(UIType.Xpath, "//input[@id='refreshSandValidityTime']");
	
	private WebPelement lblConsKeyProd = defineEelement(UIType.Xpath, "//div[@class='consumerKey']/span");
	
	private WebPelement lblSecKeyProd = defineEelement(UIType.Xpath, "//div[@class='consumerSecret']/span");
	
    private WebPelement lblConsKeySand = defineEelement(UIType.Xpath, "//div[@id='wrap']/div[6]/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div/div/div[1]/div[4]/span");
	
	private WebPelement lblSecKeySand = defineEelement(UIType.Xpath, "//div[@id='wrap']/div[6]/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div/div/div[1]/div[5]/span");

	public SubscriptionsPage(WebDriver driver) {
		super(driver);
	}

	public boolean validateSubscriptionsPage(){
		return getElement(lblSubscriptions).getText().equalsIgnoreCase("Subscriptions");
	}
	
	public boolean validateNoSubscription(String msg){
		WebPelement lblSubscroptionMsg = defineEelement(UIType.Xpath, "//div/b");
		return getElement(lblSubscroptionMsg).getText().trim().contains(msg);
	}
	
	public boolean validateAppsWithSubscriptions(String appname){
		return getElement(lblAppName).getText().equalsIgnoreCase(appname);
	}
	
	public void enterTokenValidityProd(String validity){
		getElement(txtTokenValidityProd).clearAndSendkeys(validity);
	}
	
	public void clickProdGen(){
		getElement(btnGenerateProd).click();
	}
	
	public void clickSandGen(){
		getElement(btnGenerateSand).click();
	}
	
	public void enterTokenValiditySand(String validity){
		getElement(txtTokenValiditySand).clearAndSendkeys(validity);
	}
	
	public String validateConsKeyProd(){
		String ConsKeyProd = getElement(lblConsKeyProd).getText();
		return ConsKeyProd;
	}
	
	public String validateSecKeyProd(){
		String SecKeyProd = getElement(lblSecKeyProd).getText();
		return SecKeyProd;
	}
	
	public String validateConsKeySand(){
		String ConsKeySand = getElement(lblConsKeySand).getText();
		return ConsKeySand;
	}
	
	public String validateSecKeySand(){
		String SecKeySand = getElement(lblSecKeySand).getText();
		return SecKeySand;
	}
}
