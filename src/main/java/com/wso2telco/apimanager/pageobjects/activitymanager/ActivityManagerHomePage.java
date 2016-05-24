package com.wso2telco.apimanager.pageobjects.activitymanager;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class ActivityManagerHomePage.
 */
public class ActivityManagerHomePage extends BasicPageObject {

	/**
	 * Instantiates a new activity manager home page.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public ActivityManagerHomePage(WebDriver driver) {
		super(driver);
	}
	
	/** The logger. */
	Logger logger = Logger.getLogger(ActivityManagerHomePage.class);
	
	/** The lbl home page header. */
	private WebPelement lblHomePageHeader = defineEelement(UIType.Xpath, "//div[@id='middle']/h2");
	
	/** The btn main. */
	private WebPelement btnMain = defineEelement(UIType.Xpath, "//div[@id='menu-panel-button1']");
	
	/** The lnk manage area. */
	private WebPelement lnkManageArea = defineEelement(UIType.Xpath, "//li[contains(.,'Manage')]/following-sibling::li");
	
	/** The btn manage. */
	private WebPelement btnManage = defineEelement(UIType.Xpath, "//div[@id='menu']/ul/li[8]");
	
	/** The lnk analytics list. */
	private WebPelement lnkAnalyticsList = defineEelement(UIType.Xpath, "//div[@id='menu']/ul/li[9]/ul/li[8]/ul/li/a[contains(.,'List')]");
	
	private WebPelement lnkAddHumanTask = defineEelement(UIType.Xpath, "//div[@id='menu']/ul/li[contains(.,'Manage')]/following-sibling::li/ul/li[contains(.,'Human Tasks')]/following-sibling::li[1]/ul/li/a[contains(.,'Add')]");
	
	/**
	 * Checks if is home page header.
	 *
	 * @author SulakkhanaW
	 * @param pageHeader the page header
	 * @return true, if is home page header
	 * @throws Exception the exception
	 */
	public boolean isHomePageHeader(String pageHeader) throws Exception{
		flag = false;
		try {
			logger.debug("Validating activity manager home page header");
			if (getElement(lblHomePageHeader).getText().trim().equalsIgnoreCase(pageHeader)){
				flag = true;
				logger.debug("Activity manager home page header matched");
			} else {
				logger.debug("Activity manager home page header mismatched");				
			}
		} catch (Exception e) {
			logInstruction("Exception While validating Activity manager home page header 'clickSignin()'" + e.getMessage());
			throw new Exception("Exception While validating Activity manager home page header 'clickSignin()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click main.
	 *
	 * @author SulakkhanaW
	 */
	public void clickMain(){
		logger.debug("Clicking on main button");
		getElement(btnMain).click();
		logger.debug("Clicked on main button");
	}
	
	/**
	 * Click analytics lsit.
	 *
	 * @author SulakkhanaW
	 * @return the activity manger available scripts
	 * @throws Exception the exception
	 */
	public ActivityMangerAvailableScripts clickAnalyticsLsit() throws Exception{
		try {
			logger.debug("Validating Manager tab is clicked");
			if (getElement(lnkManageArea).getAttribute("style").equalsIgnoreCase("display: none;")){
				logger.debug("Manager tab is not clicked");
				logger.debug("Clicking on Manager tab");
				getElement(btnManage).click();
				logger.debug("Clicked on Manager tab");
				logger.debug("Clicking on Analytics List");
				getElement(lnkAnalyticsList).click();
				logger.debug("Clicked on Analytics List");
			} else {
				logger.debug("Manager tab is clicked");
				logger.debug("Clicking on Analytics List");
				getElement(lnkAnalyticsList).click();
				logger.debug("Clicked on Analytics List");
			}
		} catch (Exception e) {
			logInstruction("Exception While clicking on Analytics List link 'clickAnalyticsLsit()'" + e.getMessage());
			throw new Exception("Exception While clicking on Analytics List link 'clickAnalyticsLsit()'" + e.getLocalizedMessage());
		}
		return new ActivityMangerAvailableScripts(driver);
	}
	
	/**
	 * Click human task add.
	 *
	 * @throws Exception the exception
	 */
	public void clickHumanTaskAdd() throws Exception{
		try {
			logger.debug("Validating Manager tab is clicked");
			if (getElement(lnkManageArea).getAttribute("style").equalsIgnoreCase("display: none;")){
				logger.debug("Manager tab is not clicked");
				logger.debug("Clicking on Manager tab");
				getElement(btnManage).click();
				logger.debug("Clicked on Manager tab");
				logger.debug("Clicking on Human Task Add");
				getElement(lnkAddHumanTask).click();
				logger.debug("Clicked on Human Task Add");
			} else {
				logger.debug("Manager tab is clicked");
				logger.debug("Clicking on Human Task Add");
				getElement(lnkAddHumanTask).click();
				logger.debug("Clicked on Human Task Add");
			}
		} catch (Exception e) {
			logInstruction("Exception While clicking on Human Task add link 'clickHumanTaskAdd()'" + e.getMessage());
			throw new Exception("Exception While clicking on Human Task add link 'clickHumanTaskAdd()'" + e.getLocalizedMessage());
		}
	}

}
