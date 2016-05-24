package com.wso2telco.apimanager.pageobjects.activitymanager;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class ActivityManagerHumanTask.
 */
public class ActivityManagerHumanTask extends BasicPageObject {
	
	/** The logger. */
	Logger logger = Logger.getLogger(ActivityManagerHumanTask.class);

	/** The lbl page header. */
	private WebPelement lblPageHeader = defineEelement(UIType.Xpath, "//div[@id='middle']/h2");
	
	/** The txt file upload. */
	private WebPelement txtFileUpload = defineEelement(UIType.Xpath, "//input[@name='humantaskFileName']");
	
	/** The btn upload. */
	private WebPelement btnUpload = defineEelement(UIType.Xpath, "//input[@name='upload' and @class='button registryWriteOperation']");

	/**
	 * Instantiates a new activity manager human task.
	 *
	 * @param driver the driver
	 */
	public ActivityManagerHumanTask(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Checks if is analytics page header.
	 *
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
	 * Select file.
	 *
	 * @param filePath the file path
	 * @throws InterruptedException 
	 */
	public void selectFile(String filePath) throws InterruptedException{
		String browserType = config.getValue("browser");
		if (browserType.equals("FIREFOX")) {
			logger.debug("Selecting upload file");
			selectFileFF(filePath);
			logger.debug("Upload file selected");
		} else {
			logger.debug("Selecting upload file");
			getElement(txtFileUpload).sendKeys(filePath);
			logger.debug("Upload file selected");			
		}
	}
	
	/**
	 * Select file ff.
	 *
	 * @param filePath the file path
	 * @throws InterruptedException 
	 */
	public void selectFileFF(String filePath) throws InterruptedException{
		String file  = filePath.replaceAll("/", "\\\\");
		getElement(txtFileUpload).click();
		Thread.sleep(sleepTime);
		selectFileFromPopup(file);
	}
	
	/**
	 * Select file from popup.
	 *
	 * @param filePath the file path
	 */
	public static void selectFileFromPopup(String filePath){
		setClipboardData(filePath);
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets the clipboard data.
	 *
	 * @param filePath the new clipboard data
	 */
	public static void setClipboardData(String filePath){
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}
	
	/**
	 * Click upload.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	public void clickUpload(){
		logger.debug("Clicking on upload button");
		getElement(btnUpload).click();
		logger.debug("Clicked on upload button");
	}

}
