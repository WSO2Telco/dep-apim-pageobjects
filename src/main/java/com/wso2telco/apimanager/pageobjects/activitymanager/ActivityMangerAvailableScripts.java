package com.wso2telco.apimanager.pageobjects.activitymanager;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class ActivityMangerAvailableScripts.
 */
public class ActivityMangerAvailableScripts extends BasicPageObject {

	/**
	 * Instantiates a new activity manger available scripts.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public ActivityMangerAvailableScripts(WebDriver driver) {
		super(driver);
	}
	
	/** The logger. */
	Logger logger = Logger.getLogger(ActivityMangerAvailableScripts.class);
	
	/** The lnk sb am stats analyzer execute. */
	private WebPelement lnkSbAmStatsAnalyzerExecute = defineEelement(UIType.Xpath, "//label[contains(.,'sb_am_stats_analyzer')]/../../td[2]/a[contains(.,'Execute')]");
	
	/** The lbl page header. */
	private WebPelement lblPageHeader = defineEelement(UIType.Xpath, "//div[@id='middle']/h2");
	
	private String txtExecutedScript = "//div[@id='hiveResult']/span[@class='queryView'][1]";
	
	/**
	 * Checks if is analytics page header.
	 *
	 * @author SulakkhanaW
	 * @param pageHeader the page header
	 * @return true, if is analytics page header
	 * @throws Exception the exception
	 */
	public boolean isAnalyticsPageHeader(String pageHeader) throws Exception{
		flag = false;
		try {
			logger.debug("Validating Analytics list page header");
			if (getElement(lblPageHeader).getText().trim().equalsIgnoreCase(pageHeader)){
				flag = true;
				logger.debug("Analytics list page header matched");
			} else {
				logger.debug("Analytics list page header mismatched");
			}
		} catch (Exception e) {
			logInstruction("Exception While validating Analytics list page header 'clickSignin()'" + e.getMessage());
			throw new Exception("Exception While validating Analytics list page header 'clickSignin()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click sb am stats analyzer execute.
	 *
	 * @author SulakkhanaW
	 */
	public void clickSbAmStatsAnalyzerExecute(){
		logger.debug("Clicking on sb am stats analyzer execute button");
		getElement(lnkSbAmStatsAnalyzerExecute).click();
		logger.debug("Clicked on sb am stats analyzer execute button");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		logger.debug("Waiting for the executed script result");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(txtExecutedScript)));
		logger.debug("Script executed");
	}

}
