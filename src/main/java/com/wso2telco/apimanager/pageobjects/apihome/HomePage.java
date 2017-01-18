package com.wso2telco.apimanager.pageobjects.apihome;

import java.util.ArrayList;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.apimanager.pageobjects.apihome.apis.APIsPage;
import com.wso2telco.apimanager.pageobjects.apihome.applications.ApplicationsPage;
import com.wso2telco.apimanager.pageobjects.apihome.manager.ManagerPage;
import com.wso2telco.apimanager.pageobjects.apihome.sandbox.SandBoxPage;
import com.wso2telco.apimanager.pageobjects.apihome.subscriptions.SubscriptionsPage;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class HomePage.
 */
public class HomePage extends BasicPageObject {
	
	/** The logger. */
	Logger logger = Logger.getLogger(HomePage.class);

	/** The link ap is. */
	private WebPelement linkAPIs = defineEelement(UIType.Xpath, "//a[@title='APIs']");
	
	/** The link my applications. */
	private WebPelement linkMyApplications = defineEelement(UIType.Xpath, "//a[@class='link-myapplications']");
	
	/** The link add application */
	private WebPelement linkAddAplication = defineEelement(UIType.Xpath, "//a[@title='Add Application']");
	
	/** The link my subscriptions. */
	private WebPelement linkMySubscriptions = defineEelement(UIType.Xpath, "//ul[@class='nav orderFix']/li[4]/a");
	
	/** The link manage. */
	private WebPelement linkManage = defineEelement(UIType.Xpath, "//ul[@class='nav orderFix']/li[5]/a");
	
	/** The link sand box. */
	private WebPelement linkSandBox = defineEelement(UIType.Xpath, "//ul[@class='nav orderFix']/li[6]/a");

	WebDriverWait wait = new WebDriverWait(driver, 120);
	
	/**
	 * Instantiates a new home page.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public HomePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Click api link.
	 *
	 * @author SulakkhanaW
	 * @return the AP is page
	 * @throws Exception the exception
	 */
	public APIsPage clickApiLink() throws Exception{
		try {
			logger.debug("Start clicking on API link");
			getElement(linkAPIs).click();
			Thread.sleep(8000);
			logger.debug("Clicked on API link successfully");
		} catch (Exception e) {
			logInstruction("Exception While clicking on API link 'clickApiLink()'" + e.getMessage());
			throw new Exception("Exception While clicking on API link 'clickApiLink()'" + e.getLocalizedMessage());
		}
		return new APIsPage(driver);
	}
	
	/**
	 * Click my applications link.
	 *
	 * @author SulakkhanaW
	 * @return the applications page
	 * @throws Exception 
	 */
	public ApplicationsPage clickMyApplicationsLink() throws Exception{
		try {
			logger.debug("Start clicking on My Applications link");
			wait.until(ExpectedConditions.elementToBeClickable(getElement(linkMyApplications)));
			getElement(linkMyApplications).click();
			Thread.sleep(15000);
			logger.debug("Clicked on My Applications link");
		} catch (Exception e) {
			logInstruction("Exception While clicking on My Applications link 'clickMyApplicationsLink()'" + e.getMessage());
			throw new Exception("Exception While clicking on My Applications link 'clickMyApplicationsLink()'" + e.getLocalizedMessage());
		}
		return new ApplicationsPage(driver);
	}
	
	public ApplicationsPage clickAddApplicationLink() throws Exception{
		try {
			logger.debug("Start clicking on Add Application link");
			getElement(linkAddAplication).click();
			Thread.sleep(15000);
			logger.debug("Clicked on Add Application link");
		} catch (Exception e) {
			logInstruction("Exception While clicking on Add Application link 'clickAddApplicationLink()'" + e.getMessage());
			throw new Exception("Exception While clicking on Add Application link 'clickAddApplicationLink()'" + e.getLocalizedMessage());
		}
		return new ApplicationsPage(driver);
	}
	
	/**
	 * Click my subscriptions link.
	 *
	 * @author SulakkhanaW
	 * @return the subscriptions page
	 * @throws Exception 
	 */
	public SubscriptionsPage clickMySubscriptionsLink() throws Exception{
		try {
			logger.debug("Start clicking on My Subscriptions link");
			getElement(linkMySubscriptions).click();
			Thread.sleep(20000);
			logger.debug("Clicked on My Subscriptions link");
		} catch (Exception e) {
			logInstruction("Exception While clicking on My Subscription link 'clickMyApplicationsLink()'" + e.getMessage());
			throw new Exception("Exception While clicking on My Applications link 'clickMyApplicationsLink()'" + e.getLocalizedMessage());
		}
		return new SubscriptionsPage(driver);
	}
	
	/**
	 * Click manage link.
	 *
	 * @author SulakkhanaW
	 * @return the manager page
	 * @throws Exception 
	 */
	public ManagerPage clickManageLink() throws Exception{
		logger.debug("Start clicking on Manage link");
		String parent = driver.getWindowHandle();
		Thread.sleep(sleepTime);
		getElement(linkManage).click();
		Thread.sleep(20000);
		String win1=null;
		String win2=null;
		Set<String> availableWindows = driver.getWindowHandles();
		ArrayList<String> elements = new ArrayList<>();
		try {
			for (String winNum : availableWindows) {
				elements.add(winNum);
			}
			if (elements.size() > 2){
				if (elements.contains(parent)){
					int getParentArray = elements.indexOf(parent);
					elements.remove(getParentArray);
				}
				if (elements.size() == 2){
					win1 = elements.get(0);
					win2 = elements.get(1);
					driver.switchTo().window(win1);
					driver.close();
					driver.switchTo().window(win2);
				}
			}
		} catch (Exception e) {
			logInstruction("Exception While clicking on Manager link 'clickManageLink()'" + e.getMessage());
			throw new Exception("Exception While clicking on Manager link 'clickManageLink()'" + e.getLocalizedMessage());
		}
		logger.debug("Clicked on Manage link");
		return new ManagerPage(driver);
	}
	
	/**
	 * Click sand box link.
	 *
	 * @author SulakkhanaW
	 * @return the sand box page
	 * @throws Exception 
	 */
	public SandBoxPage clickSandBoxLink() throws Exception{
		logger.debug("Start clicking on Sandbox link");
		//String parent = driver.getWindowHandle();
		Thread.sleep(sleepTime);
		getElement(linkSandBox).click();
		Thread.sleep(sleepTime);
		/*String win1=null;
		String win2=null;
		Set<String> availableWindows = driver.getWindowHandles();
		ArrayList<String> elements = new ArrayList<>();
		try{
			for (String winNum : availableWindows) {
			elements.add(winNum);
			}
		
			if (elements.size() > 2){
				if (elements.contains(parent)){
					int getParentArray = elements.indexOf(parent);
					elements.remove(getParentArray);
				}
			}
			if (elements.size() == 2){
				win1 = elements.get(0);
				win2 = elements.get(1);
				driver.switchTo().window(win1);
				driver.close();
				driver.switchTo().window(win2);
			}	
		}
		/*catch (Exception e) {
		logInstruction("Exception While clicking on Sandbox link 'clickSandboxLink()'" + e.getMessage());
		throw new Exception("Exception While clicking on Sandbox link 'clickSandboxLink()'" + e.getLocalizedMessage());
		}*/
		//logger.debug("Clicked on Sandbox link");
		return new SandBoxPage(driver);
		
	}
	
}
