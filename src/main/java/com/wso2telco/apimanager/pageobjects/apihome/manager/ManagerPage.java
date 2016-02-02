package com.wso2telco.apimanager.pageobjects.apihome.manager;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

// TODO: Auto-generated Javadoc
/**
 * The Class ManagerPage.
 */
public class ManagerPage extends BasicPageObject {

	/** The logger. */
	Logger logger = Logger.getLogger(ManagerPage.class);
	
	/** The lbl manager. */
	private WebPelement lblManager = defineEelement(UIType.Xpath, "//h2[@class='login-title']");
	
	/** The txt user name. */
	private WebPelement txtUserName = defineEelement(UIType.Xpath, "//input[@id='username']");
	
	/** The txt password. */
	private WebPelement txtPassword = defineEelement(UIType.Xpath, "//input[@id='pass']");
	
	/** The btn log in. */
	private WebPelement btnLogIn = defineEelement(UIType.Xpath, "//input[@id='loginButton']");
	
	/** The lbl home. */
	private WebPelement lblHome = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	/** The btn user name. */
	private WebPelement btnUserName = defineEelement(UIType.Xpath, "//a[@id='userMenu']");
	
	/** The btn logout. */
	private WebPelement btnLogout = defineEelement(UIType.Xpath, "//li[@class='logout-link-special']/button");

	/** The lnk workflow. */
	private WebPelement lnkWorkflow = defineEelement(UIType.Xpath, "//div[@class='navbar-inner main-menu-navbar']/ul/li/a[text()[contains(.,'Workflow')]]");
	
	/** The lnk application creation. */
	private WebPelement lnkApplicationCreation = defineEelement(UIType.Xpath, "//li/a[text()[contains(.,'Application Creation')]]");
	
	/** The lbl approve reject. */
	private WebPelement lblApproveReject = defineEelement(UIType.Xpath, "//div[@class='modal-header']/h3");
	
	/** The txt approve reject. */
	private WebPelement txtApproveReject = defineEelement(UIType.Xpath, "//div/form/input[@type='text']");
	
	/** The btn approve ok. */
	private WebPelement btnApproveOk = defineEelement(UIType.Xpath, "//div/a[text()[contains(.,'OK')]]");
	
	/** The btn sub creation. */
	private WebPelement btnSubCreation = defineEelement(UIType.Xpath, "//a[contains(.,'Subscriptions Creation')]");
	
	/** The title app tasks. */
	private WebPelement titleAppTasks = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	/** The tab path. */
	private String tabPath = "//div[@class='navbar-inner main-menu-navbar']/ul/li";
	
	/** The lnk black list. */
	private WebPelement lnkBlackList = defineEelement(UIType.Xpath, "//div[@class='navbar-inner main-menu-navbar']/ul/li/a[text()[contains(.,'Blacklist')]]");
	
	/** The lbl api black list. */
	private WebPelement lblAPIBlackList = defineEelement(UIType.Xpath, "//div[@class='title-section']");
	
	/** The dd select api. */
	private WebPelement ddSelectAPI = defineEelement(UIType.Xpath, "//div[@class='well form-inline']/table/tbody/tr[2]/td/select");
	
	/** The lbl ussd. */
	private WebPelement lblUSSD = defineEelement(UIType.Xpath, "//select[@id='apiSelect']/option[contains(.,'USSD')]");
	
	/** The btn add new. */
	private WebPelement btnAddNew = defineEelement(UIType.ID, "add-new");
	
	/** The lbl admin mod error. */
	private WebPelement lblAdminModError = defineEelement(UIType.Xpath, "//div[@id='messageModal']/div[1]/h3");
	
	/** The lnk white list. */
	private WebPelement lnkWhiteList = defineEelement(UIType.Xpath, "//div[@class='navbar-inner main-menu-navbar']/ul/li/a[text()[contains(.,'Whitelist')]]");
	
	/** The lbl ap iwise white list. */
	private WebPelement lblAPIwiseWhiteList = defineEelement(UIType.Xpath, "//div[@id='middle']/div[1]/h2");
	
	/** The dd subscriber. */
	private WebPelement ddSubscriber = defineEelement(UIType.ID, "subsSelect");
	
	/** The dd application. */
	private WebPelement ddApplication = defineEelement(UIType.ID, "appSelect");
	
	/** The dd api. */
	private WebPelement ddAPI = defineEelement(UIType.ID, "apiSelect");
	
	/** The lbl whitelist ussd. */
	private WebPelement lblWhitelistUSSD = defineEelement(UIType.Xpath, "//select[@id='apiSelect']/option[contains(.,'ussd')]");
	
	/** The btn manual. */
	private WebPelement btnManual = defineEelement(UIType.ID, "isManual");
	
	/** The txt number. */
	private WebPelement txtNumber = defineEelement(UIType.ID, "manualNumber");
	
	/** The btn upload number. */
	private WebPelement btnUploadNumber = defineEelement(UIType.ID, "add-manual");
	
	/** The btn number range. */
	private WebPelement btnNumberRange = defineEelement(UIType.ID, "isRange");
	
	/** The txt min number. */
	private WebPelement txtMinNumber = defineEelement(UIType.ID, "minnumber");
	
	/** The txt max number. */
	private WebPelement txtMaxNumber = defineEelement(UIType.ID, "maxnumber");
	
	/** The btn number list. */
	private WebPelement btnNumberList = defineEelement(UIType.ID, "add-range");
	
	/** The btn upload number list. */
	private WebPelement btnUploadNumberList = defineEelement(UIType.ID, "isList");
	
	/** The btn add number list. */
	private WebPelement btnAddNumberList = defineEelement(UIType.ID, "add-new");
	
	/**
	 * Instantiates a new manager page.
	 *
	 * @author JayaniP
	 * @param driver the driver
	 */
	public ManagerPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Checks if is manager page.
	 *
	 * @author JayaniP
	 * @param managerHeader the manager header
	 * @return true, if is manager page
	 * @throws Exception the exception
	 */
	public boolean isManagerPage(String managerHeader) throws Exception{
		flag = false;
		logger.debug("Validating Manager page hedaer");
		Thread.sleep(5000);
		try {
			if (getElement(lblManager).getText().equalsIgnoreCase(managerHeader)){
				flag = true;
				logger.debug("Manager page hedaer matched");
			} else {
				logger.debug("Manager page hedaer mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Manager page header 'isManagerPage()'" + e.getMessage());
			throw new Exception("Exception While Validating Manager page header 'isManagerPage()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Enter user name.
	 *
	 * @author JayaniP
	 * @param username the username
	 */
	public void enterUserName(String username){
		getElement(txtUserName).clearAndSendkeys(username);
	}
	
	/**
	 * Enter password.
	 *
	 * @author JayaniP
	 * @param password the password
	 */
	public void enterPassword(String password){
		getElement(txtPassword).clearAndSendkeys(password);
	}
	
	/**
	 * Click login.
	 *
	 * @author JayaniP
	 */
	public void clickLogin(){
		getElement(btnLogIn).click();
	}
	
	/**
	 * Checks if is home page.
	 *
	 * @author JayaniP
	 * @param homeHeader the home header
	 * @return true, if is home page
	 * @throws Exception the exception
	 */
	public boolean isHomePage(String homeHeader) throws Exception{
		flag = false;
		logger.debug("Validating Home page hedaer");
		try {
			if (getElement(lblHome).getText().equalsIgnoreCase(homeHeader)){
				flag = true;
				logger.debug("Home page hedaer matched");
			} else {
				logger.debug("Home page hedaer mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Home page header 'isHomePage()'" + e.getMessage());
			throw new Exception("Exception While Validating Home page header 'isHomePage()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click user name.
	 *
	 * @author JayaniP
	 */
	public void clickUserName(){
		getElement(btnUserName).click();
	}
	
	/**
	 * Click logout.
	 *
	 * @author JayaniP
	 */
	public void clickLogout(){
		getElement(btnLogout).click();
	}
	
	/**
	 * Checks if is manager two tabs access.
	 *
	 * @author JayaniP
	 * @return true, if is manager two tabs access
	 * @throws Exception the exception
	 */
	public boolean isManagerTwoTabsAccess() throws Exception{
		flag = false;
		logger.debug("Validating Manager page tabs for normal users");
		int tabCount = verifyListContent(UIType.Xpath, tabPath).size();	
		try {
			if (tabCount <= 3){
				flag = true;
				logger.debug("User has access for 2 tabs");
			} else {
				logger.debug("User has access for more than 2 tabs");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Manager page tabs 'isManagerTwoTabsAccess()'" + e.getMessage());
			throw new Exception("Exception While Validating Manager page tabs 'isManagerTwoTabsAccess()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Checks if is all tabs accessible.
	 *
	 * @author JayaniP
	 * @return true, if is all tabs accessible
	 * @throws Exception the exception
	 */
	public boolean isAllTabsAccessible() throws Exception{
		flag = false;
		logger.debug("Validating Manager page tabs for admin users");
		int tabCount = verifyListContent(UIType.Xpath, tabPath).size();
		try {
			if (tabCount <= 6){
				flag = true;
				logger.debug("User has access for all the tabs");
			} else {
				logger.debug("User has access for less than 5 tabs");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Manager page tabs 'isAllTabsAccessible()'" + e.getMessage());
			throw new Exception("Exception While Validating Manager page tabs 'isAllTabsAccessible()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Checks if is three tabs.
	 *
	 * @author JayaniP
	 * @return true, if is three tabs
	 * @throws Exception the exception
	 */
	public boolean isThreeTabs() throws Exception{
		flag = false;
		logger.debug("Validating Manager page tabs for operator users");
		int tabCount = verifyListContent(UIType.Xpath, tabPath).size();
		try {
			if (tabCount <= 4){
				flag = true;
				logger.debug("Operator user has access for three tabs");
			} else {
				logger.debug("Operator user has access for less/more than three tabs");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Manager page tabs 'isThreeTabs()'" + e.getMessage());
			throw new Exception("Exception While Validating Manager page tabs 'isThreeTabs()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click workflow.
	 *
	 * @author JayaniP
	 */
	public void clickWorkflow(){
		getElement(lnkWorkflow).click();
	}
	
	/**
	 * Checks if is apllication creation.
	 *
	 * @author JayaniP
	 * @return true, if is apllication creation
	 * @throws Exception the exception
	 */
	public boolean isApllicationCreation() throws Exception{
		flag = false;
		logger.debug("Validating Application creation link");
		List<WebElement> tabs = driver.findElements(By.xpath("//li/a[text()[contains(.,'Application Creation')]]"));
		int tabCount = tabs.size();
		try {
			if (tabCount <= 1){
				flag = true;
				logger.debug("Application creation link is visible");
			} else {
				logger.debug("Application creation link is not visible");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Application creation link 'isApllicationCreation()'" + e.getMessage());
			throw new Exception("Exception While Validating Application creation link 'isApllicationCreation()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click application cration.
	 *
	 * @author JayaniP
	 */
	public void clickApplicationCration(){
		getElement(lnkApplicationCreation).click();
	}
	
	/**
	 * Checks if is application name visible.
	 *
	 * @author JayaniP
	 * @param appName the app name
	 * @return true, if is application name visible
	 * @throws Exception the exception
	 */
	public boolean isApplicationNameVisible(String appName) throws Exception{
		flag = false;
		logger.debug("Validating Application name");
		Thread.sleep(2000);
		String xpath = "//tr/td/div/label[text()[contains(.,'" + appName + "')]]";
		List<WebElement> appNames = driver.findElements(By.xpath(xpath));
		int Names = appNames.size();
		try {
			if (Names == 1){
				flag = true;
				logger.debug("Application name is visible");
			} else {
				logger.debug("Application creation name is not visible");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Application name 'isApplicationNameVisible()'" + e.getMessage());
			throw new Exception("Exception While Validating Application name 'isApplicationNameVisible()'" + e.getLocalizedMessage());
		}	
		return flag;
	}
	
	/**
	 * Click application details.
	 *
	 * @author JayaniP
	 * @param appname the appname
	 */
	public void clickApplicationDetails(String appname){
		String xpath = "//tr/td/div/label[text()[contains(.,'" + appname + "')]]/../../label/b[text()[contains(.,'Application Details')]]";
		WebPelement lnkAppName = defineEelement(UIType.Xpath, xpath);
		getElement(lnkAppName).click();
	}
	
	/**
	 * Select tier.
	 *
	 * @author JayaniP
	 * @param tier the tier
	 * @param appname the appname
	 */
	public void selectTier(String tier, String appname){
		String xpath = "//td[@id='desc0']/div[4]/div[1]/select/option[@value='Unlimited']";
		WebPelement ddlTier = defineEelement(UIType.Xpath, xpath);
		getElement(ddlTier).sendKeys(tier);
		getElement(ddlTier).sendEnter();
	}
	
	/**
	 * Click assign me.
	 *
	 * @author JayaniP
	 * @param appName the app name
	 */
	public void clickAssignMe(String appName){
		String xpath = "//tr/td/div/label[text()[contains(.,'" + appName + "')]]/../../../td[5]/button[text()[contains(.,'Assign To Me')]]";
		WebPelement btnAssignMe = defineEelement(UIType.Xpath, xpath);
		getElement(btnAssignMe).click();
	}
	
	/**
	 * Click start.
	 *
	 * @author JayaniP
	 * @param appName the app name
	 */
	public void clickStart(String appName){
		String xpath = "//tr/td/div/label[text()[contains(.,'" + appName + "')]]/../../../td[5]/button[text()[contains(.,'Start')]]";
		WebPelement btnStart = defineEelement(UIType.Xpath, xpath);
		getElement(btnStart).click();
	}
	
	/**
	 * Select condition.
	 *
	 * @author JayaniP
	 * @param condition the condition
	 * @param appName the app name
	 */
	public void selectCondition(String condition, String appName){
		String xpath = "//tr/td/div/label[text()[contains(.,'" + appName + "')]]/../../../td[5]/select[@class='js_stateDropDown pull-left']";
		WebPelement ddlCondition = defineEelement(UIType.Xpath, xpath);
		getElement(ddlCondition).sendKeys(condition);
		getElement(ddlCondition).sendEnter();
	}
	
	/**
	 * Click complete.
	 *
	 * @author JayaniP
	 * @param appName the app name
	 */
	public void clickComplete(String appName){
		String xpath = "//tr/td/div/label[text()[contains(.,'" + appName + "')]]/../../../td[5]/button[text()[contains(.,'Complete')]]";
		WebPelement btnComplete = defineEelement(UIType.Xpath, xpath);
		getElement(btnComplete).click();
	}
	
	/**
	 * Enter approve reject reason.
	 *
	 * @author JayaniP
	 * @param reason the reason
	 */
	public void enterApproveRejectReason(String reason){
		getElement(txtApproveReject).clearAndSendkeys(reason);
	}
	
	/**
	 * Click approve ok.
	 *
	 * @author JayaniP
	 */
	public void clickApproveOK(){
		getElement(btnApproveOk).click();
	}
	
	/**
	 * Checks if is application name not visible.
	 *
	 * @author JayaniP
	 * @param appName the app name
	 * @return true, if is application name not visible
	 * @throws Exception the exception
	 */
	public boolean isApplicationNameNotVisible(String appName) throws Exception{
		flag = false;
		logger.debug("Validating Application name not visible");
		String xpath = "//tr/td/div/label[text()[contains(.,'" + appName + "')]]";
		List<WebElement> appNames = driver.findElements(By.xpath(xpath));
		int Names = appNames.size();
		try {
			if (Names < 1){
				flag = true;
				logger.debug("Application name not visible");
			} else {
				logger.debug("Application name visible");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Application name 'isApplicationNameNotVisible()'" + e.getMessage());
			throw new Exception("Exception While Validating Application name 'isApplicationNameNotVisible()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click sub creation.
	 *
	 * @author JayaniP
	 */
	public void clickSubCreation(){
		getElement(btnSubCreation).click();
	}
	
	/**
	 * Checks if is approval task displayed.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is approval task displayed
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Checks if is approve reject popup displayed.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is approve reject popup displayed
	 * @throws Exception the exception
	 */
	public boolean isApproveRejectPopupDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating Approve/Reject popup");
		Thread.sleep(10000);
		try {
			if (title.contains(getElement(lblApproveReject).getText())) {
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
	
	/**
	 * Click black list.
	 *
	 * @author JayaniP
	 */
	public void clickBlackList(){
		logger.debug("Click on Black List Tab");
		getElement(lnkBlackList).click();
		logger.debug("Error while clicking on BlackList tab");
	}
	
	/**
	 * Checks if is API blacklist page displayed.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is API blacklist page displayed
	 * @throws Exception the exception
	 */
	public boolean isAPIBlacklistPageDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating title APIwise Blacklist");
		Thread.sleep(10000);
		try {
			if (title.contains(getElement(lblAPIBlackList).getText())) {
				flag = true;
				logger.debug("Validating title APIwise Blacklist completed");
			} else {
				logger.debug("APIwise Blacklist title is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating title APIwise Blacklist Page Title 'isAPIBlacklistPageDisplayed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating title APIwise Blacklist Page Title 'isAPIBlacklistPageDisplayed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click api drop down.
	 *
	 * @author JayaniP
	 */
	public void clickAPIDropDown(){
		logger.debug("Click on API Drop box");
		getElement(ddSelectAPI).click();
		logger.debug("Clicked on API Drop box");
	}
	
	/**
	 * Select ussd.
	 *
	 * @author JayaniP
	 */
	public void selectUSSD(){
		logger.debug("Select USSD");
		getElement(lblUSSD).click();
		logger.debug("USSD selected");
	}
	
	/**
	 * Click add new button.
	 *
	 * @author JayaniP
	 */
	public void clickAddNewButton(){
		logger.debug("Click on Add new button");
		getElement(btnAddNew).click();
		logger.debug("Clicked on Add new button");
	}
	
	/**
	 * Checks if is adds the number alert displayed.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is adds the number alert displayed
	 * @throws Exception the exception
	 */
	public boolean isAddNumberAlertDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating add number alert");
		Thread.sleep(2000);
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			if (title.contains(alert.getText())) {
				flag = true;
				logger.debug("Validating add number alert completed");
			} else {
				logger.debug("Add number alert title is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating add number alert Page Title 'isAddNumberAlertDisplayed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating add number alert Page Title 'isAddNumberAlertDisplayed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Enter black list number.
	 *
	 * @author JayaniP
	 * @param number the number
	 */
	public void enterBlackListNumber(String number){
		logger.debug("Enter the number to blacklist");
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.sendKeys(number);
		logger.debug("Entered the number");
	}
	
	/**
	 * Click alert ok button.
	 *
	 * @author JayaniP
	 */
	public void clickAlertOKButton(){
		logger.debug("Click on Ok button");
		Alert alert = driver.switchTo().alert();
		alert.accept();
		logger.debug("Clicked on OK button");
	}
	
	/**
	 * Checks if is added number displayed.
	 *
	 * @author JayaniP
	 * @param number the number
	 * @return true, if is added number displayed
	 * @throws Exception the exception
	 */
	public boolean isAddedNumberDisplayed(String number) throws Exception {

		flag = false;
		logger.debug("Validating added number in table");
		Thread.sleep(2000);
		String xpath = " //td[text()='"+number+"']";
		WebPelement lblAddedNumber = defineEelement(UIType.Xpath, xpath);
		try {
			if (number.contains(getElement(lblAddedNumber).getText())) {
				flag = true;
				logger.debug("Validating added number in table completed");
			} else {
				logger.debug("added number is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating added number in table Page Title 'isAddedNumberDisplayed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating added number in table Page Title 'isAddedNumberDisplayed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Checks if is API manager admin module error popup displayed.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is API manager admin module error popup displayed
	 * @throws Exception the exception
	 */
	public boolean isAPIManagerAdminModuleErrorPopupDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating API Manager Error Popup");
		Thread.sleep(10000);
		try {
			if (title.contains(getElement(lblAdminModError).getText())) {
				flag = true;
				logger.debug("Validating API Manager Error Popup completed");
			} else {
				logger.debug("API Manager Error Popup title is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating title API Manager Error Popup Page Title 'isAPIManagerAdminModuleErrorPopupDisplayed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating title API Manager Error Popup Page Title 'isAPIManagerAdminModuleErrorPopupDisplayed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click white list tab.
	 *
	 * @author JayaniP
	 */
	public void clickWhiteListTab(){
		logger.debug("Click on White list tab");
		getElement(lnkWhiteList).click();
		logger.debug("Clicked on White list tab");
	}
	
	/**
	 * Checks if is AP iwise whitelist page displayed.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is AP iwise whitelist page displayed
	 * @throws Exception the exception
	 */
	public boolean isAPIwiseWhitelistPageDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating APIwise White List Page");
		Thread.sleep(10000);
		try {
			if (title.contains(getElement(lblAPIwiseWhiteList).getText())) {
				flag = true;
				logger.debug("Validating APIwise White List Page completed");
			} else {
				logger.debug("APIwise White List Page is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating APIwise White List Page Title 'isAPIwiseWhitelistPageDisplayed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating APIwise White List Page Title 'isAPIwiseWhitelistPageDisplayed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click subscriber drop box.
	 *
	 * @author JayaniP
	 */
	public void clickSubscriberDropBox(){
		logger.debug("Click on Subscriber");
		getElement(ddSubscriber).click();
		logger.debug("Clicked on Subscriber");
	}
	
    /**
     * Select subscriber.
     *
     * @author JayaniP
     * @param subscriber the subscriber
     */
    public void selectSubscriber(String subscriber){
    	logger.debug("Select a Subscriber");
    	String xpath = "//select[@id='subsSelect']/option[contains(.,'"+subscriber+"')]";
		WebPelement lblSubscriber = defineEelement(UIType.Xpath, xpath);
		getElement(lblSubscriber).click();
		logger.debug("Selected a Subscriber");
    }
    
    /**
     * Click application drop box.
     *
     * @author JayaniP
     */
    public void clickApplicationDropBox(){
    	logger.debug("Click on Application");
    	getElement(ddApplication).click();
		logger.debug("Clicked on Application");
    }
   
    /**
     * Select application.
     *
     * @author JayaniP
     * @param appname the appname
     */
    public void selectApplication(String appname){
    	logger.debug("Select an Application");
    	String xpath = "//select[@id='appSelect']/option[contains(.,'"+appname+"')]";
		WebPelement lblApplication = defineEelement(UIType.Xpath, xpath);
		getElement(lblApplication).click();
		logger.debug("Selected an Application");
    }
    
    /**
     * Click api drop box.
     *
     * @author JayaniP
     */
    public void clickAPIDropBox(){
    	logger.debug("Click on API");
    	getElement(ddAPI).click();
		logger.debug("Clicked on API");
    }
    
    /**
     * Select white list apiussd.
     *
     * @author JayaniP
     */
    public void selectWhiteListAPIUSSD(){
    	logger.debug("Select ussd");
    	getElement(lblWhitelistUSSD).click();
		logger.debug("Selected ussd");
    }
    
    /**
     * Click upload manually.
     *
     * @author JayaniP
     */
    public void clickUploadManually(){
    	logger.debug("Select button upload manually");
    	getElement(btnManual).click();
		logger.debug("Selected button upload manually");
    }
    
    /**
     * Enter manual number.
     *
     * @author JayaniP
     * @param number the number
     */
    public void enterManualNumber(String number){
    	logger.debug("Enter Manual Number");
    	getElement(txtNumber).clearAndSendkeys(number);
		logger.debug("Entered Manual Number");
    }
    
    /**
     * Click upload number button.
     *
     * @author JayaniP
     */
    public void clickUploadNumberButton(){
    	logger.debug("Click upload Number");
    	getElement(btnUploadNumber).click();
		logger.debug("Clicked upload Number");
    }
    
    /**
     * Click number range button.
     *
     * @author JayaniP
     */
    public void clickNumberRangeButton(){
    	logger.debug("Click Number Range button");
    	getElement(btnNumberRange).click();
		logger.debug("Clicked Number Range button");
    }
    
    /**
     * Enter min number.
     *
     * @author JayaniP
     * @param number the number
     */
    public void enterMinNumber(String number){
    	logger.debug("Enter min number");
    	getElement(txtMinNumber).clearAndSendkeys(number);
		logger.debug("Min number entered");
    }
    
    /**
     * Enter max number.
     *
     * @author JayaniP
     * @param number the number
     */
    public void enterMaxNumber(String number){
    	logger.debug("Enter max number");
    	getElement(txtMaxNumber).clearAndSendkeys(number);
		logger.debug("Max number entered");
    }
    
    /**
     * Click upload number list.
     *
     * @author JayaniP
     */
    public void clickUploadNumberList(){
    	logger.debug("Click upload number list");
    	getElement(btnNumberList).click();
		logger.debug("Clicked upload number list");
    }
    
    /**
     * Click upload whitelist number list.
     *
     * @author JayaniP
     */
    public void clickUploadWhitelistNumberList(){
    	logger.debug("Click upload whitelist number list");
    	getElement(btnUploadNumberList).click();
		logger.debug("Clicked upload whitelist number list");
    }
    
    /**
     * Click add number list.
     *
     * @author JayaniP
     */
    public void clickAddNumberList(){
    	logger.debug("Click add number list");
    	getElement(btnAddNumberList).click();
		logger.debug("Clicked add number list");
    }
    
    /**
     * Enter white list number list.
     *
     * @author JayaniP
     * @param number the number
     */
    public void enterWhiteListNumberList(String numbers){
		logger.debug("Enter the number list to blacklist");
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.sendKeys(numbers);
		logger.debug("Entered the number list");
	}
    
    public void clearBlacklistNumber(String number) throws Exception{
		logger.debug("Remove blacklist number if available");
		
		String xpathlblNumber = "//td[text()='" + number + "']";
		int countWhiteListNumber = verifyListContent(UIType.Xpath, xpathlblNumber).size();
		
		String xpathRemoveNumber = "//td[text()='" + number + "']/following-sibling::td[1]/div/a";
		WebPelement btnRemoveNumber = defineEelement(UIType.Xpath, xpathRemoveNumber);
		
		try {
			if (countWhiteListNumber == 1){
				logger.debug("Click remove number");
				getElement(btnRemoveNumber).click();
				logger.debug("Clicked remove number");
			}
		} catch (Exception e) {
			logger.debug("Exception While removing blacklist number 'clearBlacklistNumber()'" + e.getMessage());
			throw new Exception("Exception While removing blacklist number 'clearBlacklistNumber()'" + e.getLocalizedMessage());
		}
	}
}


