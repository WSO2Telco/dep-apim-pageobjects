package com.wso2telco.apimanager.pageobjects.apihome.applications;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.apimanager.pageobjects.apihome.HomePage;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationsPage.
 */
public class ApplicationsPage extends BasicPageObject  {
	
	/** The logger. */
	Logger logger = Logger.getLogger(HomePage.class);

	/** The lbl applications. */
	private WebPelement lblApplications = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	/** The lbl application form. */
	private WebPelement lblApplicationForm = defineEelement(UIType.Xpath, "//form[@id='appAddForm']/h3");
	
	/** The txt application name. */
	private WebPelement txtApplicationName = defineEelement(UIType.ID, "application-name");
	
	/** The txt application callback url. */
	private WebPelement txtApplicationCallbackUrl = defineEelement(UIType.ID, "callback-url");
	
	/** The txt application description. */
	private WebPelement txtApplicationDescription = defineEelement(UIType.ID, "description");
	
	/** The btn app add. */
	private WebPelement btnAppAdd = defineEelement(UIType.Xpath, "application-add-button");
	
	/** The lbl application name. */
	private WebPelement lblApplicationName = defineEelement(UIType.Xpath, "//table[@id='applicationTable']//tr[1]/td[1]");
	
	/** The ddl tier. */
	private WebPelement ddlTier = defineEelement(UIType.Xpath, "//table[@id='applicationTable']//tr[1]/td[2]/select");
	
	/** The lbl status. */
	private WebPelement lblStatus = defineEelement(UIType.Xpath, "//table[@id='applicationTable']//tr[1]/td[3]");
	
	/** The lbl callbackurl. */
	private WebPelement lblCallbackurl = defineEelement(UIType.Xpath, "//table[@id='applicationTable']//tr[1]/td[4]");
	
	/** The lbl description. */
	private WebPelement lblDescription = defineEelement(UIType.Xpath, "//table[@id='applicationTable']//tr[1]/td[5]");
	
	/** The btn yes. */
	private WebPelement btnYes = defineEelement(UIType.Xpath, ".//*[@id='messageModal']/div[3]/a[contains(.,'Yes')]");
	
	
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
	 */
	public void enterAppllicationName(String applicationName){
		logger.debug("Enter application name");
		getElement(txtApplicationName).clearAndSendkeys(applicationName);
		logger.debug("Application name entered Successfully");
	}
	
	/**
	 * Enter appllication callback url.
	 *
	 * @author SulakkhanaW
	 * @param applicationCallbackUrl the application callback url
	 */
	public void enterAppllicationCallbackUrl(String applicationCallbackUrl){
		logger.debug("Enter application callback url");
		getElement(txtApplicationCallbackUrl).clearAndSendkeys(applicationCallbackUrl);
		logger.debug("Application callback url entered Successfully");
	}
	
	/**
	 * Enter appllication description.
	 *
	 * @author SulakkhanaW
	 * @param description the description
	 */
	public void enterAppllicationDescription(String description){
		logger.debug("Enter application description");
		getElement(txtApplicationDescription).clearAndSendkeys(description);
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
	
	/**
	 * Checks if is teirname.
	 *
	 * @author SulakkhanaW
	 * @param teir the teir
	 * @return true, if is teirname
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Checks if is application status.
	 *
	 * @author SulakkhanaW
	 * @param status the status
	 * @return true, if is application status
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Checks if is callbackurl.
	 *
	 * @author SulakkhanaW
	 * @param url the url
	 * @return true, if is callbackurl
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Validate description.
	 *
	 * @author SulakkhanaW
	 * @param description the description
	 * @return true, if successful
	 * @throws Exception the exception
	 */
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
	
	 /**
 	 * Checks if is app available.
 	 *
 	 * @author SulakkhanaW
 	 * @param app the app
 	 * @param username the username
 	 * @return true, if is app available
 	 * @throws Exception the exception
 	 */
 	public boolean isAppAvailable(String app, String username) throws Exception{
			
			flag = false;
			logger.debug("Validating app is visible");
			String xpath = "//td[text()[contains(.,'" + username + "_" + app + "')]]";
			int elements = verifyListContent(UIType.Xpath, xpath).size();
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
 	 */
 	public void clickDelete(String app){
		String xpath = "//td[contains(.,'"+app+"')]/following-sibling::td[5]/a";
		WebPelement lnkDelete = defineEelement(UIType.Xpath, xpath);
		getElement(lnkDelete).click();
	 }
	 
	 /**
 	 * Click yes.
 	 *
 	 * @author SulakkhanaW
 	 */
 	public void clickYes(){
		 getElement(btnYes).click();
	 }
}
