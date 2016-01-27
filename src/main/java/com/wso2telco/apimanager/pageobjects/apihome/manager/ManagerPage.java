package com.wso2telco.apimanager.pageobjects.apihome.manager;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class ManagerPage extends BasicPageObject {

	Logger logger = Logger.getLogger(ManagerPage.class);
	
	private WebPelement lblManager = defineEelement(UIType.Xpath, "//h2[@class='login-title']");
	
	private WebPelement txtUserName = defineEelement(UIType.Xpath, "//input[@id='username']");
	
	private WebPelement txtPassword = defineEelement(UIType.Xpath, "//input[@id='pass']");
	
	private WebPelement btnLogIn = defineEelement(UIType.Xpath, "//input[@id='loginButton']");
	
	private WebPelement lblHome = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	private WebPelement btnUserName = defineEelement(UIType.Xpath, "//a[@id='userMenu']");
	
	private WebPelement btnLogout = defineEelement(UIType.Xpath, "//li[@class='logout-link-special']/button");

	private WebPelement lnkWorkflow = defineEelement(UIType.Xpath, "//div[@class='navbar-inner main-menu-navbar']/ul/li/a[text()[contains(.,'Workflow')]]");
	
	private WebPelement lnkApplicationCreation = defineEelement(UIType.Xpath, "//li/a[text()[contains(.,'Application Creation')]]");
	
	private WebPelement lblApproveReject = defineEelement(UIType.Xpath, "//div/div/a/../h3");
	
	private WebPelement txtApproveReject = defineEelement(UIType.Xpath, "//div/form/input[@type='text']");
	
	private WebPelement btnApproveOk = defineEelement(UIType.Xpath, "//div/a[text()[contains(.,'OK')]]");
	
	private WebPelement btnSubCreation = defineEelement(UIType.Xpath, "//li[@class='active']/a");
	
	private WebPelement titleAppTasks = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	private WebPelement titleAppRejPopup = defineEelement(UIType.Xpath, "//h3[contains(text(),'Enter approve/reject reasons')]");
	
	
	public ManagerPage(WebDriver driver) {
		super(driver);
	}

	public boolean validateManagerPage(){
		return getElement(lblManager).getText().equalsIgnoreCase("Manager");
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
	
	public boolean validateHomePage(){
		return getElement(lblHome).getText().equalsIgnoreCase("Home");
	}
	
	public void clickUserName(){
		getElement(btnUserName).click();
	}
	
	public void clickLogout(){
		getElement(btnLogout).click();
	}
	
	public boolean validateManageTabs(){
		List<WebElement> tabs = driver.findElements(By.xpath("//div[@class='navbar-inner main-menu-navbar']/ul/li"));
		int tabCount = tabs.size();
		
		if (tabCount <= 3){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validateAllTabs(){
		List<WebElement> tabs = driver.findElements(By.xpath("//div[@class='navbar-inner main-menu-navbar']/ul/li"));
		int tabCount = tabs.size();
		if (tabCount <= 6){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validateThreeTabs(){
		List<WebElement> tabs = driver.findElements(By.xpath("//div[@class='navbar-inner main-menu-navbar']/ul/li"));
		int tabCount = tabs.size();
		if (tabCount <= 4){
			return true;
		} else {
			return false;
		}
	}
	
	public void clickWorkflow(){
		getElement(lnkWorkflow).click();
	}
	
	public boolean validateApllicationCreation(){
		List<WebElement> tabs = driver.findElements(By.xpath("//li/a[text()[contains(.,'Application Creation')]]"));
		int tabCount = tabs.size();
		if (tabCount <= 1){
			return true;
		} else {
			return false;
		}
	}
	
	public void clickApplicationCration(){
		getElement(lnkApplicationCreation).click();
	}
	
	public boolean validateAppName(String appName){
		String xpath = "//tr/td/div/label[text()[contains(.,'" + appName + "')]]";
		List<WebElement> appNames = driver.findElements(By.xpath(xpath));
		int Names = appNames.size();
		if (Names == 1){
			return true;
		} else {
			return false;
		}		
	}
	
	public void clickApplicationDetails(String appname){
		String xpath = "//tr/td/div/label[text()[contains(.,'" + appname + "')]]/../../label/b[text()[contains(.,'Application Details')]]";
		WebPelement lnkAppName = defineEelement(UIType.Xpath, xpath);
		getElement(lnkAppName).click();
	}
	
	public void selectTier(String tier, String appname){
		String xpath = "//tr/td/div/label[text()[contains(.,'" + appname + "')]]/../../div/div/select[@id='tiers_list_89026']";
		WebPelement ddlTier = defineEelement(UIType.Xpath, xpath);
		getElement(ddlTier).sendKeys(tier);
		getElement(ddlTier).sendEnter();
	}
	
	public void clickAssignMe(String appName){
		String xpath = "//tr/td/div/label[text()[contains(.,'" + appName + "')]]/../../../td[5]/button[text()[contains(.,'Assign To Me')]]";
		WebPelement btnAssignMe = defineEelement(UIType.Xpath, xpath);
		getElement(btnAssignMe).click();
	}
	
	public void clickStart(String appName){
		String xpath = "//tr/td/div/label[text()[contains(.,'" + appName + "')]]/../../../td[5]/button[text()[contains(.,'Start')]]";
		WebPelement btnStart = defineEelement(UIType.Xpath, xpath);
		getElement(btnStart).click();
	}
	
	public void selectCondition(String condition, String appName){
		String xpath = "//tr/td/div/label[text()[contains(.,'" + appName + "')]]/../../../td[5]/select[@class='js_stateDropDown pull-left']";
		WebPelement ddlCondition = defineEelement(UIType.Xpath, xpath);
		getElement(ddlCondition).sendKeys(condition);
		getElement(ddlCondition).sendEnter();
	}
	
	public void clickComplete(String appName){
		String xpath = "//tr/td/div/label[text()[contains(.,'" + appName + "')]]/../../../td[5]/button[text()[contains(.,'Complete')]]";
		WebPelement btnComplete = defineEelement(UIType.Xpath, xpath);
		getElement(btnComplete).click();
	}
	
	public boolean validateApproveReject(){
		return getElement(lblApproveReject).getText().trim().contains("Enter approve/reject reasons");
	}
	
	public void enterApproveRejectReason(String reason){
		getElement(txtApproveReject).clearAndSendkeys(reason);
	}
	
	public void clickApproveOK(){
		getElement(btnApproveOk).click();
	}
	
	public boolean validateAppNameNOT(String appName){
		String xpath = "//tr/td/div/label[text()[contains(.,'" + appName + "')]]";
		List<WebElement> appNames = driver.findElements(By.xpath(xpath));
		int Names = appNames.size();
		if (Names < 1){
			return true;
		} else {
			return false;
		}
	}
	
	public void clickSubCreation(){
		getElement(btnSubCreation).click();
	}
	
	public boolean isApprovalTaskDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating Approval Task Title");
		Thread.sleep(10000);
		try {
			if (title.contains(getElement(titleAppTasks).getText())) {
				flag = true;
				logger.debug("Validating Approval Task Title completed");
			} else {
				logger.debug("Approval Task Title is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Approval Task Title Page Title 'isApprovalTaskDisplayed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Approval Task Title Page Title 'isApprovalTaskDisplayed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	public boolean isApproveRejectPopupDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating Approve/Reject popup");
		Thread.sleep(10000);
		try {
			if (title.contains(getElement(titleAppRejPopup).getText())) {
				flag = true;
				logger.debug("Validating Approve/Reject popup completed");
			} else {
				logger.debug("Approve/Reject popup title is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Approve/Reject popup Page Title 'isApproveRejectPopupDisplayed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Approve/Reject popup Page Title 'isApproveRejectPopupDisplayed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
}


