package com.wso2telco.apimanager.pageobjects.apihome.subscriptions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class SubscriptionsPage.
 */
public class SubscriptionsPage extends BasicPageObject  {
	
	/** The logger. */
	Logger logger = Logger.getLogger(SubscriptionsPage.class);
	
	/** The lbl subscriptions. */
	private WebPelement lblSubscriptions = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	/** The lbl app name. */
	private WebPelement lblAppName = defineEelement(UIType.Xpath, "//div[@id='s2id_appListSelected']/a/span[1]");
	
	/** The txt token validity prod. */
	private WebPelement txtTokenValidityProd = defineEelement(UIType.ID, "refreshProdValidityTime");
	
	/** The btn generate prod. */
	private WebPelement btnGenerateProd = defineEelement(UIType.Xpath, "//button[@data-keytype='PRODUCTION']");
	
	/** The btn generate sand. */
	private WebPelement btnGenerateSand = defineEelement(UIType.Xpath, "//button[@data-keytype='SANDBOX']");
	
	/** The txt token validity sand. */
	private WebPelement txtTokenValiditySand = defineEelement(UIType.ID, "refreshSandValidityTime");
	
	/** The lbl cons key prod. */
	private WebPelement lblConsKeyProd = defineEelement(UIType.Xpath, "//div[@class='consumerKey']/span");
	
	/** The lbl sec key prod. */
	private WebPelement lblSecKeyProd = defineEelement(UIType.Xpath, "//div[@class='consumerSecret']/span");
	
	/** The dd select app. */
	private WebPelement ddSelectApp = defineEelement(UIType.Xpath, "//span[@class='select2-arrow']/b");
	
    /** The lbl cons key sand. */
    private WebPelement lblConsKeySand = defineEelement(UIType.Xpath, "//input[@id='refreshSandValidityTime']/../../div[4]/span");
	
	/** The lbl sec key sand. */
	private WebPelement lblSecKeySand = defineEelement(UIType.Xpath, "//input[@id='refreshSandValidityTime']/../../div[5]/span");
	
	/** The btn re generate prod. */
	private WebPelement btnReGenerateProd = defineEelement(UIType.Xpath, "//div[@class='consumerKey']/span/../../div[3]/button");
	
	/** The btn re generate sand. */
	private WebPelement btnReGenerateSand = defineEelement(UIType.Xpath, "//input[@id='refreshSandValidityTime']/../../div[3]/button");
	
	/**
	 * Instantiates a new subscriptions page.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public SubscriptionsPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Checks if is subscription header displayed.
	 *
	 * @author SulakkhanaW
	 * @param header the header
	 * @return true, if is subscription header displayed
	 * @throws Exception the exception
	 */
	public boolean isSubscriptionHeaderDisplayed(String header) throws Exception {

		flag = false;
		logger.debug("Validating Subscription Header");
		Thread.sleep(sleepTime);
		try {
			if (header.contains(getElement(lblSubscriptions).getText())) {
				flag = true;
				logger.debug("Validating Subscription Header completed");
			} else {
				logger.debug("Subscription Header is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Subscription Header Page Title 'isSubscriptionHeaderDisplayed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Subscription Header Page Title 'isSubscriptionHeaderDisplayed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Checks if is no subscription msg.
	 *
	 * @author SulakkhanaW
	 * @param msg the msg
	 * @return true, if is no subscription msg
	 * @throws Exception the exception
	 */
	public boolean isNoSubscriptionMsg(String msg) throws Exception{
		flag = false;
		logger.debug("Validating No Subscription message");
		WebPelement lblSubscroptionMsg = defineEelement(UIType.Xpath, "//div/b");
		try {
			if (getElement(lblSubscroptionMsg).getText().trim().contains(msg)){
				flag = true;
				logger.debug("No Subscription message is visible");
			} else {
				logger.debug("No Subscription message is not visible");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating No Subscription message 'isNoSubscriptionMsg()'" + e.getMessage());
			throw new Exception("Exception While Validating No Subscription message 'isNoSubscriptionMsg()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Checks if is apps with subscriptions.
	 *
	 * @author SulakkhanaW
	 * @param appname the appname
	 * @return true, if is apps with subscriptions
	 * @throws Exception the exception
	 */
	public boolean isAppsWithSubscriptions(String appname) throws Exception{
		flag = false;
		logger.debug("Validating Applications with subscription");
		try {
			if (getElement(lblAppName).getText().equalsIgnoreCase(appname)){
				flag = true;
				logger.debug("Applications with subscription is visible");
			} else {
				logger.debug("Applications with subscription is visible");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Applications with subscription 'isAppsWithSubscriptions()'" + e.getMessage());
			throw new Exception("Exception While Validating Applications with subscription 'isAppsWithSubscriptions()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Enter token validity prod.
	 *
	 * @author SulakkhanaW
	 * @param validity the validity
	 */
	public void enterTokenValidityProd(String validity){
		logger.debug("Start typing token validity period for production");
		getElement(txtTokenValidityProd).clearAndSendkeys(validity);
		logger.debug("Entered token validity period for production");
	}
	
	/**
	 * Click prod gen.
	 *
	 * @author SulakkhanaW
	 */
	public void clickProdGen(){
		logger.debug("Start clicking on production key generate button");
		getElement(btnGenerateProd).click();
		logger.debug("Clicked on production key generate button");
	}
	
	/**
	 * Click sand gen.
	 *
	 * @author SulakkhanaW
	 */
	public void clickSandGen(){
		logger.debug("Start clicking on Sandbox key generate button");
		getElement(btnGenerateSand).click();
		logger.debug("Clicked on Sandbox key generate button");
	}
	
	/**
	 * Enter token validity sand.
	 *
	 * @author SulakkhanaW
	 * @param validity the validity
	 */
	public void enterTokenValiditySand(String validity){
		logger.debug("Start typing token validity period for sandbox");
		getElement(txtTokenValiditySand).clearAndSendkeys(validity);
		logger.debug("Typed token validity period for sandbox");
	}
	
	/**
	 * Gets the cons key prod.
	 *
	 * @author SulakkhanaW
	 * @return the cons key prod
	 */
	public String getConsKeyProd(){
		logger.debug("Finding production consumer key");
		String consKeyProd = getElement(lblConsKeyProd).getText();
		logger.debug("Production consumer key found");
		return consKeyProd;
	}
	
	/**
	 * Gets the e sec key prod.
	 *
	 * @author SulakkhanaW
	 * @return the e sec key prod
	 */
	public String geteSecKeyProd(){
		logger.debug("Finding production consumer secrect key");
		String secKeyProd = getElement(lblSecKeyProd).getText();
		logger.debug("Production consumer secrect key found");
		return secKeyProd;
	}
	
	/**
	 * Gets the cons key sand.
	 *
	 * @author SulakkhanaW
	 * @return the cons key sand
	 */
	public String getConsKeySand(){
		logger.debug("Finding Sandbox consumer key");
		String consKeySand = getElement(lblConsKeySand).getText();
		logger.debug("Sandbox consumer key found");
		return consKeySand;
	}
	
	/**
	 * Gets the sec key sand.
	 *
	 * @author SulakkhanaW
	 * @return the sec key sand
	 */
	public String getSecKeySand(){
		logger.debug("Finding sandbox consumer secrect key");
		String secKeySand = getElement(lblSecKeySand).getText();
		logger.debug("Sandbox consumer secrect key found");
		return secKeySand;
	}
	
	/**
	 * Click re gen prod.
	 *
	 * @author SulakkhanaW
	 */
	public void clickReGenProd(){
		logger.debug("Clicking on Production re-generate button");
		getElement(btnReGenerateProd).click();
		logger.debug("Clicked on Production re-generate button");
	}
	
	/**
	 * Click re gen sand.
	 *
	 * @author SulakkhanaW
	 */
	public void clickReGenSand(){
		logger.debug("Clicking on sandbox re-generate button");
		getElement(btnReGenerateSand).click();
		logger.debug("Clicked on sandbox re-generate button");
	}
	
	/**
	 * Checks if is token validity prod.
	 *
	 * @author SulakkhanaW
	 * @param validity the validity
	 * @return true, if is token validity prod
	 * @throws Exception the exception
	 */
	public boolean isTokenValidityProd(String validity) throws Exception {

		flag = false;
		logger.debug("Validating Token Validity of Production");
		Thread.sleep(sleepTime);
		try {
			if (validity.contains(getElement(txtTokenValidityProd).getText())) {
				flag = true;
				logger.debug("Validating Token Validity of Production completed");
			} else {
				logger.debug("Token Validity of Production is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Token Validity of Production Page Title 'isTokenValidityProd()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Token Validity of Production Page Title 'isTokenValidityProd()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Checks if is token validity sand.
	 *
	 * @author SulakkhanaW
	 * @param validity the validity
	 * @return true, if is token validity sand
	 * @throws Exception the exception
	 */
	public boolean isTokenValiditySand(String validity) throws Exception {

		flag = false;
		logger.debug("Validating Token Validity of Sandbox");
		Thread.sleep(sleepTime);
		try {
			if (validity.contains(getElement(txtTokenValiditySand).getText())) {
				flag = true;
				logger.debug("Validating Token Validity of Sandbox completed");
			} else {
				logger.debug("Token Validity of Sandbox is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Token Validity of Sandbox Page Title 'isTokenValiditySand()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Token Validity of Sandbox Page Title 'isTokenValiditySand()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click select app dd.
	 *
	 * @author SulakkhanaW
	 */
	public void clickSelectAppDD(){
		logger.debug("Start clicking on Application with subscription down arrow");
		getElement(ddSelectApp).click();
		// TODO : need to implement this method with the step definitions 
		logger.debug("Clicked on Application with subscription down arrow");
	}
	
/*	public void selectApp(){
		getElement(lblAppName).click();
		//TODO : need to implement this method with the step definitions 
	}*/
}

