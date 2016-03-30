package com.wso2telco.apimanager.pageobjects.publisher;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class PublisherHomePage.
 */
public class PublisherHomePage extends BasicPageObject {
	
	/** The logger. */
	Logger logger = Logger.getLogger(PublisherHomePage.class);
	
	/** The lbl username. */
	private WebPelement lblUsername = defineEelement(UIType.Xpath, "//li/a[@id='userMenu']");
	
	private String apiPublisherLabelLogin= "//*[@id='middle']/div/div/div/div[2]/div/h2";
	private String apiPublisherLabel= "//*[@id='listing']/div[1]/h2";
	private String subscriptionLink="//*[@id='left']/div/ul/li[6]/a";
	private String subscriptionLabelHeader="//*[@id='userKey']/div[1]/h2";
	private String paginationNavigator="//a[contains(.,'>>')]";
	private String pagination = "//*[@id='userKey']/div[2]/div/div/ul/li";
	private String subscriptionTableRowIdentifier="//div[@id='userKey']/div[2]/div/table/tbody/tr";
	
	/**
	 * Instantiates a new publisher home page.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public PublisherHomePage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Checks if is login username.
	 *
	 * @author SulakkhanaW
	 * @param username the username
	 * @return true, if is login username
	 * @throws Exception the exception
	 */
	public boolean isLoginUsername(String username) throws Exception{
		flag = false;
		logger.debug("Validating publisher login");
		try {
			if (getElement(lblUsername).getText().equalsIgnoreCase(username)){
				flag = true;
				logger.debug("Login is success");
			} else {
				logger.debug("Login failed");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating publisher login 'isUserName()'" + e.getMessage());
			throw new Exception("Exception While Validating publisher login 'isUserName()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public boolean isPublisherLoginPageLabelDisplayed(String arg) {
		flag = false;

		if (driver.findElement(By.xpath(apiPublisherLabelLogin)).isDisplayed()) {
			flag = true;
		}

		return flag;
	}
	
	public boolean isPublisherPageLabelDisplayed(String arg) {
		flag = false;

		if (driver.findElement(By.xpath(apiPublisherLabel)).isDisplayed()) {
			flag = true;
		}

		return flag;
	}
	
	public void clickSubscritionLink(){
		
		driver.findElement(By.xpath(subscriptionLink)).click();
	}
	
	public boolean isSubscriptionLabelDisplayed(String arg) {
		flag = false;

		if (driver.findElement(By.xpath(subscriptionLabelHeader)).isDisplayed()) {
			flag = true;
		}

		return flag;
	}
	
	public boolean validateTableSubscriptions(String userName, String appName, String apiName) throws InterruptedException {

		int initial = 0;
		boolean flags = false;
		if (driver.findElement(By.xpath(subscriptionLabelHeader)).isDisplayed()) {
			Thread.sleep(sleepTime);
			int row_num = 1;
			String user, application, subscribedAPI, subscribedAPIS;
			int appNameSize = appName.length();
			int apiNameSize = apiName.length();
			int size = driver.findElements(By.xpath(pagination)).size();
			int numOfTimes = 2;

			while ((numOfTimes < (size - 1))) {

				if (row_num == 11) {
					row_num = 1;
					numOfTimes++;
					// TODO:declare the xpath as a string on top of the class
					if (!(driver.findElement(By.xpath(paginationNavigator)).getAttribute("class") == "disabled")) {
						driver.findElement(By.xpath(paginationNavigator)).click();
					}
					Thread.sleep(4000);

					List<WebElement> tr_collection = driver.findElements(By.xpath(subscriptionTableRowIdentifier));
					for (WebElement trElement : tr_collection) {
						String value = trElement.getText();

						String[] valueArray;

						valueArray = value.split(" ");
						user = valueArray[0];
						application = valueArray[1].substring(0, appNameSize);
						subscribedAPI = valueArray[1].replaceAll("[\u0000-\u001f]", "");
						subscribedAPI = valueArray[1].substring(appNameSize);
						subscribedAPIS = subscribedAPI.replaceAll("[\u0000-\u001f]", "");
						if ((subscribedAPIS.length()) > apiNameSize) {
							subscribedAPIS = subscribedAPIS.substring(0,apiNameSize);
						}
						if ((userName.equals(user) && appName.equals(application))&& (apiName.equals(subscribedAPIS))) {

							flags = true;
							return flags;

						}

						row_num++;

					}

				} else if ((row_num != 11) && initial == 0) {
					List<WebElement> tr_collection1 = driver.findElements(By.xpath(subscriptionTableRowIdentifier));
					for (WebElement trElement : tr_collection1) {
						String value = trElement.getText();

						String[] valueArray;

						valueArray = value.split(" ");
						user = valueArray[0];
						application = valueArray[1].substring(0, appNameSize);
						subscribedAPI = valueArray[1].replaceAll("[\u0000-\u001f]", "");
						subscribedAPI = valueArray[1].substring(appNameSize);
						subscribedAPIS = subscribedAPI.replaceAll("[\u0000-\u001f]", "");
						if ((subscribedAPIS.length()) > apiNameSize) {
							subscribedAPIS = subscribedAPIS.substring(0,apiNameSize);
						}
						if ((userName.equals(user) && appName.equals(application))&& (apiName.equals(subscribedAPIS))) {

							flags = true;
							return flags;

						}

						row_num++;

					}
					initial = 1;
				}
			}

		}
		return flags;
	}
}
