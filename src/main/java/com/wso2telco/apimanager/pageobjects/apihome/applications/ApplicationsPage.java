package com.wso2telco.apimanager.pageobjects.apihome.applications;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class ApplicationsPage.
 */
public class ApplicationsPage extends BasicPageObject  {
	
	/** The logger. */
	Logger logger = Logger.getLogger(ApplicationsPage.class);

	/** The lbl applications. */
	private WebPelement lblApplications = defineEelement(UIType.Xpath, "//div[@class='page-header']/h2");
	
	/** The lbl application form. */
	private WebPelement lblApplicationForm = defineEelement(UIType.Xpath, "//form[@id='appAddForm']/h3");
	
	/** The txt application name. */
	private WebPelement txtApplicationName = defineEelement(UIType.ID, "application-name");
	
	/** The txt application callback url. */
	private WebPelement txtApplicationCallbackUrl = defineEelement(UIType.ID, "callback-url");
	
	/** The txt application description. */
	private WebPelement txtApplicationDescription = defineEelement(UIType.ID, "description");
	
	/** The btn app add. */
	private WebPelement btnAppAdd = defineEelement(UIType.ID, "application-add-button");
	
	/** The lbl application name. */
	private String lblApplicationName = "//h2[@id='application_name']";
	
	/** The ddl tier. */
	private String ddlTier = "//td[contains(.,'%s')]/following-sibling::td[1]/select";
	
	/** The lbl status. */
	private String lblStatus = "//label[text()='Status']/..//strong";
	
	/** The lbl callbackurl. */
	private String lblCallbackurl = "//td[contains(.,'%s_%s')]/following-sibling::td[3]";
	
	/** The lbl description. */
	private String lblDescription = "//td[contains(.,'%s')]/following-sibling::td[4]";
	
	/** The btn yes. */
	private WebPelement btnYes = defineEelement(UIType.Xpath, "//a[text()='Yes']");
 	
 	/** The lbl app available. 
 	 * %s_1 = username
 	 * %s_2 = app
 	 **/
	private String lblAppAvailable = "//a[text()[contains(.,'%s')]]";
	 
	 /** The btn app delete. 
	  * %s = app
	  * */
	private String btnAppDelete = "//a[contains(.,'%s')]/../following-sibling::td/a/span";
	
	/** Application Name field validation */
	private WebPelement lblApplicationNameValidation = defineEelement(UIType.Xpath, "//label[text()='Name']/following-sibling::div/span[1]");
	
	/** Confirm Application Delete Message */
	private WebPelement lblConfirmDeleteMessage = defineEelement(UIType.Xpath, ".//*[@id='myModalLabel']");
	
	/** Duplicate application error message */
//	private WebPelement lblDuplicateApplicationError = defineEelement(UIType.Xpath, ".//span[@class='messageText']");
	private WebPelement lblDuplicateApplicationError = defineEelement(UIType.Xpath, "//h3[@id='myModalLabel']");
	
	/** The btn ok. */
	private WebPelement btnOK = defineEelement(UIType.Xpath, "//a[@class='btn btn btn-primary']");
	
	/** The link Application List */
	private WebPelement lnkApplicationList = defineEelement(UIType.Xpath, "//a[@title='Application List']");
	
	/** The textfeild Search */
	private WebPelement txtSearch = defineEelement(UIType.Xpath, "//input[@type='search']");

	/** The lbl Number of Subscriptions */
	private String lblSubscriptions = "//a[contains(.,'%s')]/../following-sibling::td[3]";
	
	/** The tab Production Keys */
	private WebPelement tabProductionKeys = defineEelement(UIType.Xpath, "//a[text()='Production Keys']");
	
	/** The lbl workflow status */
	private String lblWorkflowStatus = "//a[text()='%s']/../following-sibling::td[2]";
	
	/** The lbl application tier*/
	private String lblAppTier = "//a[text()='%s']/../following-sibling::td[1]";
	
	
	/**
	 * Instantiates a new applications page.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public ApplicationsPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Checks if is application page header.
	 *
	 * @author SulakkhanaW
	 * @param pageHeader the page header
	 * @return true, if is application page header
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Checks if is application form header.
	 *
	 * @author SulakkhanaW
	 * @param formHeader the form header
	 * @return true, if is application form header
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Enter appllication name.
	 *
	 * @author SulakkhanaW
	 * @param applicationName the application name
	 * @throws InterruptedException 
	 */
	public void enterAppllicationName(String applicationName) throws InterruptedException{
		logger.debug("Enter application name");
		Thread.sleep(sleepTime);
		getElement(txtApplicationName).clearAndSendkeys(applicationName);
		Thread.sleep(sleepTime);
		logger.debug("Application name entered Successfully");
	}
	
	/**
	 * Enter appllication callback url.
	 *
	 * @author SulakkhanaW
	 * @param applicationCallbackUrl the application callback url
	 * @throws InterruptedException 
	 */
	public void enterAppllicationCallbackUrl(String applicationCallbackUrl) throws InterruptedException{
		logger.debug("Enter application callback url");
		getElement(txtApplicationCallbackUrl).clearAndSendkeys(applicationCallbackUrl);
		Thread.sleep(sleepTime);
		logger.debug("Application callback url entered Successfully");
	}
	
	/**
	 * Enter appllication description.
	 *
	 * @author SulakkhanaW
	 * @param description the description
	 * @throws InterruptedException 
	 */
	public void enterAppllicationDescription(String description) throws InterruptedException{
		logger.debug("Enter application description");
		getElement(txtApplicationDescription).clearAndSendkeys(description);
		Thread.sleep(sleepTime);
		logger.debug("Application description entered Successfully");
	}
	
	/**
	 * Click application add.
	 *
	 * @author SulakkhanaW
	 */
	public void clickApplicationAdd(){
		logger.debug("Start clicking on application Add");
		getElement(btnAppAdd).click();
		logger.debug("Clicked on application Add successfully");
	}
	
	/**
	 * Checks if is application name.
	 *
	 * @author SulakkhanaW
	 * @param username the username
	 * @param appName the app name
	 * @return true, if is application name
	 * @throws Exception the exception
	 */
	public boolean isApplicationName(String appName) throws Exception{
		flag = false;
		logger.debug("Validating Application name");
		String xpath = String.format(lblApplicationName, appName);
		WebPelement applicationName = defineEelement(UIType.Xpath, xpath);
		String applicationname = getElement(applicationName).getText().trim();
		//String tableAppName = username + "_" + applicationname;
		String tableAppName = applicationname;
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
	
	/**
	 * Checks if is teirname.
	 *
	 * @author SulakkhanaW
	 * @param username the username
	 * @param appname the appname
	 * @param teir the teir
	 * @return true, if is teirname
	 * @throws Exception the exception
	 */
	public boolean isTeirname(String username,String appname,String teir) throws Exception{
		flag = false;
		logger.debug("Validating tier name");
		String xpath = String.format(ddlTier, appname);
		WebPelement tierName = defineEelement(UIType.Xpath, xpath);
		
		try {
			if (getElement(tierName).getAttribute("value").trim().contains(teir)){
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
	
	/**
	 * Checks if is application status.
	 *
	 * @author SulakkhanaW
	 * @param username the username
	 * @param appname the appname
	 * @param status the status
	 * @return true, if is application status
	 * @throws Exception the exception
	 */
	public boolean isApplicationStatus(String appname,String status) throws Exception{
		flag = false;
		logger.debug("Validating application status");
		String xpath = String.format(lblStatus, appname);
		WebPelement statusName = defineEelement(UIType.Xpath, xpath);
		try {
			if (getElement(statusName).getText().trim().contains(status)){
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
	
	/**
	 * Checks if is callbackurl.
	 *
	 * @author SulakkhanaW
	 * @param url the url
	 * @param username the username
	 * @param appname the appname
	 * @return true, if is callbackurl
	 * @throws Exception the exception
	 */
	public boolean isCallbackurl(String url,String username,String appname) throws Exception{
		flag = false;
		logger.debug("Validating application callback url");
		String xpath = String.format(lblCallbackurl, username, appname);
		WebPelement callbackURL = defineEelement(UIType.Xpath, xpath);
		try {
			if (callbackURL.getText().trim().contains(url)){
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
	
	/**
	 * Validate description.
	 *
	 * @author SulakkhanaW
	 * @param username the username
	 * @param appname the appname
	 * @param description the description
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean validateDescription(String username,String appname,String description) throws Exception{
		flag = false;
		logger.debug("Validating application cdescription");
		String xpath = String.format(lblDescription, appname);
		WebPelement textDescription = defineEelement(UIType.Xpath, xpath);
		try {
			if (getElement(textDescription).getText().trim().contains(description)){
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
	
	 /**
 	 * Checks if is app available.
 	 *
 	 * @author SulakkhanaW
 	 * @param app the app
 	 * @param username the username
 	 * @return true, if is app available
 	 * @throws Exception the exception
 	 */
 	public boolean isAppAvailable(String app) throws Exception{
			
			flag = false;
			logger.debug("Validating app is visible");
			String xpath = String.format(lblAppAvailable, app);
			int elements = driver.findElements(By.xpath(xpath)).size(); // TODO : need to implement a better method to check UI elements when its not existing
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
		
	 /**
 	 * Click delete.
 	 *
 	 * @author SulakkhanaW
 	 * @param app the app
 	 * @throws Exception the exception
 	 */
 	public void clickDelete(String app) throws Exception{
		String xpath = String.format(btnAppDelete, app);
		WebPelement lnkDelete = defineEelement(UIType.Xpath, xpath);
		getElement(lnkDelete).click();
		Thread.sleep(sleepTime);
	}
	 
	 /**
 	 * Click yes.
 	 *
 	 * @author SulakkhanaW
 	 */
 	public void clickYes(){
		 getElement(btnYes).click();
	 }
 	
 	/**
 	 * Check when application name text field is empty
 	 *
 	 * @author MalshaniS
 	 * @param errorMessage the errorMessage
 	 * @return true, if application name field validation message
 	 */
 	public boolean isApplicationNameEmpty(String errorMessage){
 		flag = false;
		
		if(getElement(lblApplicationNameValidation).getText().contains(errorMessage)){
			flag = true;
		}
		
		return flag;
 	}
 	
 	
 	/**
 	 * Check if Confirm Delete Popup
 	 *
 	 * @author MalshaniS
 	 * @param errorMessage the errorMessage
 	 * @return true, if Delete Confirmation error pops up
 	 */
 	public boolean isConfirmDeleteMessage(String errorMessage) throws Exception{
		
		flag = false;
		logger.debug("Validating delete confirmation message");
		try {
			Thread.sleep(sleepTime);
			if (getElement(lblConfirmDeleteMessage).getText().contains(errorMessage)) {
				flag = true;
				logger.debug("User confirm delete message matched");
			} else {
				logger.debug("User confirm delete message mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating confirm delete messager 'isConfirmDeleteMessage()'"
					+ e.getMessage());
			throw new Exception("Exception While Validating confirm delete message 'isConfirmDeleteMessage()'"
					+ e.getLocalizedMessage());
		}
		return flag;
	}
 	
 	
 	/**
 	 * Check if User cannot create application by same name
 	 *
 	 * @author MalshaniS
 	 * @param errorMessage the errorMessage
 	 * @return true, if Duplicate Application Error pops up
 	 */
 //	public boolean isDuplicateApplication(String errorMessage, String appName) throws Exception
 	public boolean isDuplicateApplication(String errorMessage) throws Exception{
		flag = false;
		logger.debug("Validating Duplicate Application Name message");
		
		try {			
			Thread.sleep(sleepTime);
//			System.out.println(lblDuplicateApplicationError.getText().trim()); - failed due to object not locate
			
			if (getElement(lblDuplicateApplicationError).getText().contains((errorMessage).trim())) {
				flag = true;
				logger.debug("Duplicate Application Name message matched");
			} else {
				logger.debug("Duplicate Application Name message mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Duplicate Application Name message 'isDuplicateApplication()'"
					+ e.getMessage());
			throw new Exception("Exception While Validating Duplicate Application Name message 'isDuplicateApplication()'"
					+ e.getLocalizedMessage());
		}
		return flag;
	}
 	
 	/**
 	 * Click ok button
 	 *
 	 * @author MalshaniS
  	 */
 	public void clickOk() {
		logger.debug("Clicking on ok");
		getElement(btnOK).click();
		logger.debug("Clicked on ok");
	}
 	
 	/**
 	 * Click Application List link
 	 *
 	 * @author MalshaniS
  	 */
 	public void clickApplicationList() throws Exception{
 		logger.debug("Clicking on Application List");
 		getElement(lnkApplicationList).click();
 		Thread.sleep(sleepTime);
 	}
 	
 	/**
 	 * Search Application
 	 *
 	 * @author MalshaniS
 	 * @param app the searchKey
  	 */	
 	public void enterSearchKey(String searchKey) throws InterruptedException{
		logger.debug("Enter Search Key");
		getElement(txtSearch).clearAndSendkeys(searchKey);
		Thread.sleep(sleepTime);
		logger.debug("Search Key entered Successfully");
	}
 	
 	/**
 	 * Check if there is an editable field per application
 	 *
 	 * @author MalshaniS
 	 * @param app the app
 	 * @return true, if Application has a editable field
 	 */
 	public boolean isAppEditable(String app) throws Exception{
		
		flag = false;
		logger.debug("Validating app is editable");
		String xpath = String.format(btnAppDelete, app);
		String element = driver.findElement(By.xpath(xpath)).getText(); // TODO : need to implement a better method to check UI elements when its not existing
		try {
			if (element.equals("Edit")){
				flag = true;
				logger.debug("App is Editable");
			} else {
				logger.debug("App is not Editable");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating app is Editable 'isAppEditable()'" + e.getMessage());
			throw new Exception("Exception While Validating app is Editable 'isAppEditable()'" + e.getLocalizedMessage());
		}
		return flag;
 	}
 	
 	/**
 	 * Click on Application Name Link
 	 *
 	 * @author MalshaniS
  	 */
 	public void clickAppName(String app){
 		logger.debug("Clicking on Application Name");
 		String xpath = String.format(lblAppAvailable, app);
		WebPelement lnkAppName = defineEelement(UIType.Xpath, xpath);
		getElement(lnkAppName).click();
		logger.debug("Clicked on Application Name");
 	}

 	/**
 	 * Click Production Keys tab
 	 *
 	 * @author MalshaniS
  	 */
 	public void clickTabProductionKeys() {
		logger.debug("Clicking on Production Keys tab");
		getElement(tabProductionKeys).click();
		logger.debug("Clicked on Production Keys tab");
	}
 	
 	/**
 	 * Check number of subscriptions for application
 	 *
 	 * @author MalshaniS
 	 * @param app the app 
 	 * @param numOfSubscriptions the numOfSubscriptions
 	 * @return true, if application has the expected number of subscriptions
 	 * @throws Exception 
 	 */
 	public boolean isNumOfSubscriptions(String app) throws Exception{
 		logger.debug("Number of Subscriptions for application");
 		String xpath = String.format(lblSubscriptions, app);
 		WebPelement lblNumOfSubscriptions = defineEelement(UIType.Xpath, xpath);
 		int subscriptions = Integer.parseInt(getElement(lblNumOfSubscriptions).getText());
 		
 		flag = false;
 		try{
 			if(subscriptions>=1){
 				logger.debug("Application has "+ subscriptions +" Subscriptions");
 				flag = true;
 			}
 		}
 		catch (Exception e) {
 			logger.debug("Exception While checking number of subscriptions 'isNumOfSubscriptions()'" + e.getMessage());
			throw new Exception("Exception While number of subscriptions 'isNumOfSubscriptions()'" + e.getLocalizedMessage());
 		}
 			return flag;	
 	}	
 	
 	
 	/**
 	 * Check workflow status of the application
 	 * 
 	 * MalshaniS
 	 * 
 	 * @param appname the appname
 	 * @param status the status
 	 * @return true if workflow status matched
 	 * @throws Exception
 	 */
 	public boolean validateWorkflowStatus(String appname, String status) throws Exception{
 		flag = false;
 		
 		logger.debug("Validating workflow status of the application");
 		String xpath = String.format(lblWorkflowStatus, appname);
 		WebPelement lblWorkflowStatus = defineEelement(UIType.Xpath, xpath);
 		
 		try{
 			if(getElement(lblWorkflowStatus).getText().trim().contains(status)){
 				logger.debug("workflow status of the application matched");
 				flag = true;
 			}
 			else{
 				logger.debug("workflow status of the application not matched");
 			}
 		}
 		catch (Exception e) {
 			logger.debug("Exception While Validating workflow status of the application 'validateWorkflowStatus()'" + e.getMessage());
			throw new Exception("Exception While Validating workflow status of the application 'validateWorkflowStatus()'" + e.getLocalizedMessage());
 		}
 			return flag;	
 	}
 	
 	/**
 	 * Check workflow status of the application
 	 * 
 	 * MalshaniS
 	 * 
 	 * @param appname the appname
 	 * @param status the status
 	 * @return true if workflow status matched
 	 * @throws Exception
 	 */
 	public boolean validateApplicationTier(String appname, String tier) throws Exception{
 		flag = false;
 		
 		logger.debug("Validating tier of the application");
 		String xpath = String.format(lblAppTier, appname);
 		WebPelement lblAppTier = defineEelement(UIType.Xpath, xpath);
 		
 		try{
 			if(getElement(lblAppTier).getText().trim().contains(tier)){
 				logger.debug("tier of the application matched");
 				flag = true;
 			}
 			else{
 				logger.debug("tier of the application not matched");
 			}
 		}
 		catch (Exception e) {
 			logger.debug("Exception While Validating tier of the application 'validateApplicationTier()'" + e.getMessage());
			throw new Exception("Exception While Validating tier of the application 'validateApplicationTier()'" + e.getLocalizedMessage());
 		}
 			return flag;	
 	}
}
