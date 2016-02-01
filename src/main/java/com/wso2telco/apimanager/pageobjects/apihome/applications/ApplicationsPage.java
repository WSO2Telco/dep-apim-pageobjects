package com.wso2telco.apimanager.pageobjects.apihome.applications;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.apimanager.pageobjects.apihome.HomePage;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class ApplicationsPage extends BasicPageObject  {
	
	Logger logger = Logger.getLogger(HomePage.class);

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
	
	private WebPelement btnYes = defineEelement(UIType.Xpath, ".//*[@id='messageModal']/div[3]/a[contains(.,'Yes')]");
	
	
	public ApplicationsPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isApplicationPageHeader(String pageHeader) throws Exception{
		flag = false;
		logger.debug("Validating Application page hedaer");
		try {
			if (getElement(lblApplications).getText().equalsIgnoreCase(pageHeader)){
				flag = true;
				logger.debug("Application page hedaer matched");
			} else {
				logger.debug("Application page hedaer mismatch");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Application page header 'isApplicationPageHeader()'" + e.getMessage());
			throw new Exception("Exception While Validating Application page header 'isApplicationPageHeader()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public boolean isApplicationFormHeader(String formHeader) throws Exception{
		flag = false;
		logger.debug("Validating Application form hedaer");
		try {
			if (getElement(lblApplicationForm).getText().trim().equalsIgnoreCase(formHeader)){
				flag = true;
				logger.debug("Application form hedaer matched");
			} else {
				logger.debug("Application form hedaer mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Application form hedaer 'isApplicationFormHeader()'" + e.getMessage());
			throw new Exception("Exception While Validating Application form hedaer 'isApplicationFormHeader()'" + e.getLocalizedMessage());
		}
		return flag;
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
	
	public boolean isApplicationName(String username, String appName) throws Exception{
		flag = false;
		logger.debug("Validating Application name");
		String appname = getElement(lblApplicationName).getText().trim();
		String tableAppName = username + "_" + appname;
		try {
			if (tableAppName.contains(appName)){
				flag = true;
				logger.debug("Application name matched");
			} else {
				logger.debug("Application name mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Application name 'isApplicationName()'" + e.getMessage());
			throw new Exception("Exception While Validating Application name 'isApplicationName()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public boolean isTeirname(String teir) throws Exception{
		flag = false;
		logger.debug("Validating tier name");
		try {
			if (getElement(ddlTier).getText().trim().contains(teir)){
				flag = true;
				logger.debug("Application tier matched");
			} else {
				logger.debug("Application tier mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Application tier 'isTeirname()'" + e.getMessage());
			throw new Exception("Exception While Validating Application tier 'isTeirname()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public boolean isApplicationStatus(String status) throws Exception{
		flag = false;
		logger.debug("Validating application status");
		try {
			if (getElement(lblStatus).getText().trim().contains(status)){
				flag = true;
				logger.debug("Application status matched");
			} else {
				logger.debug("Application status mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Application status 'isApplicationStatus()'" + e.getMessage());
			throw new Exception("Exception While Validating Application status 'isApplicationStatus()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public boolean isCallbackurl(String url) throws Exception{
		flag = false;
		logger.debug("Validating application callback url");
		try {
			if (getElement(lblCallbackurl).getText().trim().contains(url)){
				flag = true;
				logger.debug("Application callback url matched");
			} else {
				logger.debug("Application callback url mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Application callback url 'isCallbackurl()'" + e.getMessage());
			throw new Exception("Exception While Validating Application callback url 'isCallbackurl()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public boolean validateDescription(String description) throws Exception{
		flag = false;
		logger.debug("Validating application cdescription");
		try {
			if (getElement(lblDescription).getText().trim().contains(description)){
				flag = true;
				logger.debug("Application description matched");
			} else {
				logger.debug("Application description mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Application description 'isCallbackurl()'" + e.getMessage());
			throw new Exception("Exception While Validating Application description 'isCallbackurl()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	 public boolean isAppAvailable(String app, String username) throws Exception{
			
			flag = false;
			logger.debug("Validating app is visible");
			String xpath = "//td[text()[contains(.,'" + username + "_" + app + "')]]";
			int elements = driver.findElements(By.xpath(xpath)).size();
			try {
				if (elements != 0){
					flag = true;
					logger.debug("App is visible");
				} else {
					logger.debug("App is not visible");
				}
			} catch (Exception e) {
				logger.debug("Exception While Validating app is visible 'isAppAvailable()'" + e.getMessage());
				throw new Exception("Exception While Validating app is visible 'isAppAvailable()'" + e.getLocalizedMessage());
			}
			return flag;
		}
		
	 public void clickDelete(String app){
		String xpath = "//td[contains(.,'"+app+"')]/following-sibling::td[5]/a";
		WebPelement lnkDelete = defineEelement(UIType.Xpath, xpath);
		getElement(lnkDelete).click();
	 }
	 
	 public void clickYes(){
		 getElement(btnYes).click();
	 }
}
