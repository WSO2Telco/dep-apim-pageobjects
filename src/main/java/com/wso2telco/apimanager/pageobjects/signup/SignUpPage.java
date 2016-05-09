package com.wso2telco.apimanager.pageobjects.signup;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

// TODO: Auto-generated Javadoc
/**
 * The Class SignUpPage.
 */
public class SignUpPage extends BasicPageObject {
	
	/** The logger. */
	Logger logger = Logger.getLogger(SignUpPage.class);

	/** The title sign up. */
	private WebPelement titleSignUp = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	/** The txt new u name. */
	private WebPelement txtNewUName = defineEelement(UIType.ID, "newUsername");
	
	/** The txt p word. */
	private WebPelement txtPWord = defineEelement(UIType.ID, "newPassword");
	
	/** The txt re type p word. */
	private WebPelement txtReTypePWord = defineEelement(UIType.ID, "newPasswordConfirm");
	
	/** The txt l name. */
	private WebPelement txtLName = defineEelement(UIType.ID, "0.0cliamUri");
	
	/** The txt f name. */
	private WebPelement txtFName = defineEelement(UIType.ID, "1.0cliamUri");
	
	/** The txt email. */
	private WebPelement txtEmail = defineEelement(UIType.ID, "5.0cliamUri");
	
	/** The btn submit. */
	private WebPelement btnSubmit = defineEelement(UIType.Xpath, "//input[@class='submit btn btn-primary']");
	
	/** The msg success. */
	private WebPelement msgSuccess = defineEelement(UIType.Xpath, "//span[@class='messageText']");
	
	/** The btn ok. */
	private WebPelement btnOK = defineEelement(UIType.Xpath, "//a[@class='btn btn btn-primary']");
	
	/**
	 * Instantiates a new sign up page.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public SignUpPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Checks if is sign up header.
	 *
	 * @author SulakkhanaW
	 * @param signupHeader the signup header
	 * @return true, if is sign up header
	 * @throws Exception the exception
	 */
	public boolean isSignUpHeader(String signupHeader) throws Exception{
		flag = false;
		logger.debug("Validating Signup header");
		try {
			if (getElement(titleSignUp).getText().equalsIgnoreCase(signupHeader)){
				flag = true;
				logger.debug("Signup header matched");
			} else {
				logger.debug("Signup header mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating signup header 'isSignUpHeader()'" + e.getMessage());
			throw new Exception("Exception While Validating signup header 'isSignUpHeader()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Enter new u name.
	 *
	 * @author SulakkhanaW
	 * @param userName the user name
	 */
	public void enterNewUName(String userName){
		logger.debug("Entering new username");
		getElement(txtNewUName).clearAndSendkeys(userName);
		logger.debug("Entered new username");
	}
	
	/**
	 * Enter p word.
	 *
	 * @author SulakkhanaW
	 * @param password the password
	 */
	public void enterPWord(String password){
		logger.debug("Entering password");
		getElement(txtPWord).clearAndSendkeys(password);
		logger.debug("Entered password");
	}
	
	/**
	 * Re type p word.
	 *
	 * @author SulakkhanaW
	 * @param confirmPassword the confirm password
	 */
	public void reTypePWord(String confirmPassword){
		logger.debug("Entering  confirm passowrd");
		getElement(txtReTypePWord).clearAndSendkeys(confirmPassword);
		logger.debug("Entered confirm passowrd");
	}
	
	/**
	 * Enter l name.
	 *
	 * @author SulakkhanaW
	 * @param lastName the last name
	 */
	public void enterLName(String lastName){
		logger.debug("Entering  last name");
		getElement(txtLName).clearAndSendkeys(lastName);
		logger.debug("Entered  last name");
	}
	
	/**
	 * Enter f name.
	 *
	 * @author SulakkhanaW
	 * @param firstName the first name
	 */
	public void enterFName(String firstName){
		logger.debug("Entering  first name");
		getElement(txtFName).clearAndSendkeys(firstName);
		logger.debug("Entered  first name");
	}
	
	/**
	 * Enter email.
	 *
	 * @author SulakkhanaW
	 * @param email the email
	 */
	public void enterEmail(String email){
		logger.debug("Entering email");
		getElement(txtEmail).clearAndSendkeys(email);
		logger.debug("Entered email");
	}
	
	/**
	 * Click submit.
	 *
	 * @author SulakkhanaW
	 */
	public void clickSubmit(){
		logger.debug("Clicking on submit");
		getElement(btnSubmit).click();
		logger.debug("Clicked on submit");
	}
	
	/**
	 * Checks if is user signup success msg.
	 *
	 * @author SulakkhanaW
	 * @param message the message
	 * @return true, if is user signup success msg
	 * @throws Exception the exception
	 */
	public boolean isUserSignupSuccessMsg(String message) throws Exception{
		flag = false;
		logger.debug("Validating user sginup success message");
		try {
			Thread.sleep(sleepTime);
			if (getElement(msgSuccess).getText().contains(message)){
				flag = true;
				logger.debug("User sginup success message matched");
			} else {
				logger.debug("User sginup success message mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating User sginup success messager 'isUserSignupSuccessMsg()'" + e.getMessage());
			throw new Exception("Exception While Validating User sginup success message 'isUserSignupSuccessMsg()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click ok.
	 *
	 * @author SulakkhanaW
	 */
	public void clickOk(){
		logger.debug("Clicking on ok");
		getElement(btnOK).click();
		logger.debug("Clicked on ok");
	}

}
