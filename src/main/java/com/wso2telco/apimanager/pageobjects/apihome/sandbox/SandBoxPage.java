package com.wso2telco.apimanager.pageobjects.apihome.sandbox;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class SandBoxPage.
 */
public class SandBoxPage extends BasicPageObject  {
	
	
	/** The logger. */
	Logger logger = Logger.getLogger(SandBoxPage.class);

	/** The lbl login. */
	private WebPelement lblLogin = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	/** The txt user name. */
	private WebPelement txtUserName = defineEelement(UIType.Xpath, "//form[@id='loginForm']/input[1]");

	/** The btn log in. */
	private WebPelement btnLogIn = defineEelement(UIType.ID, "loginButton");
	
	/** The lbl welcome. */
	private WebPelement lblWelcome = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	/** The btn user name. */
	private WebPelement btnUserName = defineEelement(UIType.ID, "userMenu");
	
	/** The btn logout. */
	private WebPelement btnLogout = defineEelement(UIType.Xpath, "//li[@class='logout-link-special']/button");
	
	/** The dd numbers. */
	private WebPelement ddNumbers = defineEelement(UIType.Xpath, "//a[@title='Numbers']");
	
	/** The lnk manage numbers. */
	private WebPelement lnkManageNumbers = defineEelement(UIType.Xpath, "//a[contains(.,'Manage Numbers')]");
	
	/** The lbl number. */
	private String lblNumber = "//table[@id='numbers_data_table']/tbody/tr/td[1]";
	
	/** The lnk number delete. */
	private String lnkNumberDelete = "//table[@id='numbers_data_table']/tbody/tr/td[contains(.,'%s')]/../td[4]/a[4]";
	
	/** The lbl manage numbers. */
	private WebPelement lblManageNumbers = defineEelement(UIType.Xpath, "//div[@id='listing']/div/h2");
	
	/** The btn add numbers. */
	private WebPelement btnAddNumbers = defineEelement(UIType.ID,"add_number_row_button");
	
	/** The txt number. */
	private WebPelement txtNumber = defineEelement(UIType.ClassName,"required managenum_exist");
	
	/** The txt description. */
	private WebPelement txtDescription = defineEelement(UIType.ClassName,"required");
	
	/** The txt balance. */
	private WebPelement txtBalance = defineEelement(UIType.ClassName,"required balance");
	
	private WebPelement btnSaveNumber = defineEelement(UIType.ClassName,"save_data_icon");
	
	/**
	 * Instantiates a new sand box page.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public SandBoxPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Checks if is sandbox login page.
	 *
	 * @author SulakkhanaW
	 * @param sandbobLoginHeader the sandbob login header
	 * @return true, if is sandbox login page
	 * @throws Exception the exception
	 */
	public boolean isSandboxLoginPage(String sandbobLoginHeader) throws Exception{
		flag = false;
		logger.debug("Validating Sandbox login page");
		try {
			if (getElement(lblLogin).getText().equalsIgnoreCase(sandbobLoginHeader)){
				flag = true;
				logger.debug("Sandbox login page is load properly");
			} else {
				logger.debug("Sandbox login page is not load properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Sandbox login page 'isSandboxLoginPage()'" + e.getMessage());
			throw new Exception("Exception While Validating Sandbox login page 'isSandboxLoginPage()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Enter user name.
	 *
	 * @author SulakkhanaW
	 * @param username the username
	 * @throws InterruptedException 
	 */
	public void enterUserName(String username) throws InterruptedException{
		logger.debug("Entering Username");
		Thread.sleep(sleepTime);
		// TODO: add a relative xpath
		WebElement username1 = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div/div[1]/div[2]/div[3]/div/form/input[1]"));
		username1.sendKeys(username);
		Thread.sleep(sleepTime);
		getElement(txtUserName).clearAndSendkeys(username);
		logger.debug("Entered Username successfully");
	}
	
	/**
	 * Enter password.
	 *
	 * @author SulakkhanaW
	 * @param password the password
	 * @throws InterruptedException 
	 */
	
	public void enterPassword(String password) throws InterruptedException{
		logger.debug("Entering password");
		Thread.sleep(sleepTime);
		WebElement paswd=driver.findElement(By.cssSelector("#loginForm>#pass"));
		paswd.sendKeys(password);
		Thread.sleep(sleepTime);
		logger.debug("Entered password successfully");
	}
	
	/**
	 * Click login.
	 *
	 * @author SulakkhanaW
	 */
	public void clickLogin(){
		logger.debug("Clicking on login");
		getElement(btnLogIn).click();
		logger.debug("Clicked on login");
	}
	
	/**
	 * Checks if is sandbox welcome.
	 *
	 * @author SulakkhanaW
	 * @param welcome the welcome
	 * @return true, if is sandbox welcome
	 * @throws Exception the exception
	 */
	public boolean isSandboxWelcome(String welcome) throws Exception{
		flag = false;
		logger.debug("Validating Sandbox welcome page");
		try {
			if (getElement(lblWelcome).getText().equalsIgnoreCase(welcome)){
				flag = true;
				logger.debug("Sandbox welcome page is load properly");
			} else {
				logger.debug("Sandbox welcome page is not load properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Sandbox welcome page 'isSandboxWelcome()'" + e.getMessage());
			throw new Exception("Exception While Validating Sandbox welcome page 'isSandboxWelcome()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click user name.
	 *
	 * @author SulakkhanaW
	 */
	public void clickUserName(){
		logger.debug("Clicking on username");
		getElement(btnUserName).click();
		logger.debug("Clicked on username");
	}
	
	/**
	 * Click logout.
	 *
	 * @author SulakkhanaW
	 */
	public void clickLogout(){
		logger.debug("Clicking on logout");
		getElement(btnLogout).click();
		logger.debug("Clicked on logout");
	}
	
	/**
	 * Click numbers.
	 *
	 * @author JayaniP
	 */
	public void clickNumbers(){
		logger.debug("Clicking on numbers");
		getElement(ddNumbers).click();
		logger.debug("Clicked on numbers");
	}
	
	/**
	 * Select manage numbers.
	 *
	 * @author JayaniP
	 */
	public void selectManageNumbers(){
		logger.debug("Selecting manage numbers");
		getElement(lnkManageNumbers).click();
		logger.debug("Selected manage numbers");
	}
	
	/**
	 * Clear existing number.
	 *
	 * @author JayaniP
	 * @param number the number
	 * @throws Exception the exception
	 */
	public void clearExistingNumber(String number) throws Exception {
		
		logger.debug("Clearing existing number");
		List<WebElement> allElements = driver.findElements(By.xpath(lblNumber)); 
		List<String> stringList = new ArrayList<>();

			for (WebElement element: allElements) {
			      stringList.add(element.getText());
			}
			if (stringList.toString().contains(number)) {
				WebElement deleteNumber = driver.findElement(By.xpath(lnkNumberDelete));
				deleteNumber.click();
				logger.debug("Cleared existing number");
			}
		
	}
	
	/**
	 * Checks if is manage numbers.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is manage numbers
	 * @throws Exception the exception
	 */
	public boolean isManageNumbers(String title) throws Exception{
		flag = false;
		logger.debug("Validating manage numbers page");
		try {
			if (getElement(lblManageNumbers).getText().equalsIgnoreCase(title)){
				flag = true;
				logger.debug("Manage numbers page is load properly");
			} else {
				logger.debug("Manage numbers page is not load properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating manage numbers page 'isManageNumbers()'" + e.getMessage());
			throw new Exception("Exception While Validating manage numbers page 'isManageNumbers()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click on add new number.
	 *
	 * @author JayaniP
	 */
	public void clickOnAddNewNumber(){
		logger.debug("Clicking add numbers");
		getElement(btnAddNumbers).click();
		logger.debug("Clicked add numbers");
	}
	
	/**
	 * Enter number.
	 *
	 * @author JayaniP
	 * @param number the number
	 */
	public void enterNumber(String number){
		logger.debug("Entering number");
		getElement(txtNumber).clearAndSendkeys(number);
		logger.debug("Number entered");
	}
	
	/**
	 * Enter description.
	 *
	 * @author JayaniP
	 * @param description the description
	 */
	public void enterDescription(String description){
		logger.debug("Entering description");
		getElement(txtDescription).clearAndSendkeys(description);
		logger.debug("Description entered");
	}
	
	/**
	 * Enter balance.
	 *
	 * @author JayaniP
	 * @param balance the balance
	 */
	public void enterBalance(String balance){
		logger.debug("Entering balance");
		getElement(txtBalance).clearAndSendkeys(balance);
		logger.debug("Balance entered");
	}
	
	public void clickSaveNumber(){
		logger.debug("Clicking save number");
		getElement(btnSaveNumber).click();
		logger.debug("Number Saved");
	}
}
