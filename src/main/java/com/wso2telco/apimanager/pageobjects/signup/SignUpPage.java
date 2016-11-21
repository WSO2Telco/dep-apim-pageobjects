package com.wso2telco.apimanager.pageobjects.signup;

import org.apache.log4j.Logger;
import org.apache.log4j.lf5.viewer.categoryexplorer.TreeModelAdapter;
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
	private WebPelement titleSignUp = defineEelement(UIType.Xpath,
			"//div[@class='title-section']/h2|.//*[@id='sign-up']/h3");

	/** The txt new user name. */
	private WebPelement txtNewUName = defineEelement(UIType.ID, "newUsername");

	/** The txt pword. */
	private WebPelement txtPWord = defineEelement(UIType.ID, "newPassword");

	/** The txt re type p word. */
	private WebPelement txtReTypePWord = defineEelement(UIType.ID, "newPasswordConfirm");

	/** The txt l name. */
	private WebPelement txtLName = defineEelement(UIType.ID, "0.0cliamUri");

	/** The txt f name. */
	private WebPelement txtFName = defineEelement(UIType.ID, "1.0cliamUri");

	/** The txt email. */
	private WebPelement txtEmail = defineEelement(UIType.Xpath, ".//*[@id='2.0cliamUri' or @id='5.0cliamUri']");

	/** The btn submit. */
	private WebPelement btnSubmit = defineEelement(UIType.Xpath,
			".//*[@id='register-link' or a[text()='Sign-up'] ]|.//button[@type='submit']");

	/** The btn submit. */
	private WebPelement btnCancel = defineEelement(UIType.Xpath, ".//*[@id='goBackBtn']");

	/** The msg success. */
	private WebPelement msgSuccess = defineEelement(UIType.Xpath, "//span[@class='messageText']");

	/** The btn ok. */
	private WebPelement btnOK = defineEelement(UIType.Xpath, "//a[@class='btn btn btn-primary']");

	/** Optional Fields **/
	/** The txt Organization . */
	private WebPelement txtOrganization = defineEelement(UIType.Xpath, ".//*[@id='2.0cliamUri']");

	/** The txt Address. */
	private WebPelement txtAddress = defineEelement(UIType.Xpath, ".//*[@id='3.0cliamUri']");

	/** The txt Country. */
	private WebPelement txtCountry = defineEelement(UIType.Xpath, ".//*[@id='4.0cliamUri']");

	/** The txt Land Phone. */
	private WebPelement txtLandPhone = defineEelement(UIType.Xpath, ".//*[@id='6.0cliamUri']");

	/** The txt MobilePhone. */
	private WebPelement txtMobilePhone = defineEelement(UIType.Xpath, ".//*[@id='7.0cliamUri']");

	/** The txt IM. */
	private WebPelement txtIM = defineEelement(UIType.Xpath, ".//*[@id='8.0cliamUri']");

	/** The txt URL. */
	private WebPelement txtURL = defineEelement(UIType.Xpath, ".//*[@id='9.0cliamUri']");
	
	
	/** The link Additional details. */
	private WebPelement linkAdditionalDetails = defineEelement(UIType.Xpath, ".//a[@title='View Additional Details']");

	
	/**
	 * Instantiates a new sign up page.
	 *
	 * @author SulakkhanaW
	 * @param driver
	 *            the driver
	 */
	public SignUpPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Checks if is sign up header.
	 *
	 * @author SulakkhanaW
	 * @param signupHeader
	 *            the signup header
	 * @return true, if is sign up header
	 * @throws Exception
	 *             the exception
	 */
	public boolean isSignUpHeader(String signupHeader) throws Exception {
		flag = false;
		logger.debug("Validating Signup header");
		try {
			if (getElement(titleSignUp).getText().equalsIgnoreCase(signupHeader)) {
				flag = true;
				logger.debug("Signup header matched");
			} else {
				logger.debug("Signup header mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating signup header 'isSignUpHeader()'" + e.getMessage());
			throw new Exception(
					"Exception While Validating signup header 'isSignUpHeader()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Enter new u name.
	 *
	 * @author SulakkhanaW
	 * @param userName
	 *            the user name
	 */
	public void enterNewUName(String userName) {
		logger.debug("Entering new username");
		getElement(txtNewUName).clearAndSendkeys(userName);
		logger.debug("Entered new username");
	}

	/**
	 * Enter p word.
	 *
	 * @author SulakkhanaW
	 * @param password
	 *            the password
	 */
	public void enterPWord(String password) {
		logger.debug("Entering password");
		getElement(txtPWord).clearAndSendkeys(password);
		logger.debug("Entered password");
	}

	/**
	 * Re type p word.
	 *
	 * @author SulakkhanaW
	 * @param confirmPassword
	 *            the confirm password
	 */
	public void reTypePWord(String confirmPassword) {
		logger.debug("Entering  confirm passowrd");
		getElement(txtReTypePWord).clearAndSendkeys(confirmPassword);
		logger.debug("Entered confirm passowrd");
	}

	/**
	 * Enter l name.
	 *
	 * @author SulakkhanaW
	 * @param lastName
	 *            the last name
	 */
	public void enterLName(String lastName) {
		logger.debug("Entering  last name");
		getElement(txtLName).clearAndSendkeys(lastName);
		logger.debug("Entered  last name");
	}

	/**
	 * Enter f name.
	 *
	 * @author SulakkhanaW
	 * @param firstName
	 *            the first name
	 */
	public void enterFName(String firstName) {
		logger.debug("Entering  first name");
		getElement(txtFName).clearAndSendkeys(firstName);
		logger.debug("Entered  first name");
	}

	/**
	 * Enter email.
	 *
	 * @author SulakkhanaW
	 * @param email
	 *            the email
	 */
	public void enterEmail(String email) {
		logger.debug("Entering email");
		getElement(txtEmail).clearAndSendkeys(email);
		logger.debug("Entered email");
	}

	/**
	 * Click submit.
	 *
	 * @author SulakkhanaW
	 */
	public void clickSubmit() {
		logger.debug("Clicking on submit");
		getElement(btnSubmit).click();
		logger.debug("Clicked on submit");
	}

	/**
	 * Enter Organization.
	 *
	 * @author Susantha.Pathirana
	 * @param Organization
	 * 
	 */
	public void enterOrganization(String Organization) {
		logger.debug("Entering Organization");
		getElement(txtOrganization).click();
		getElement(txtOrganization).clearAndSendkeys(Organization);
		logger.debug("Entered Organization");
	}

	/**
	 * Enter Address.
	 *
	 * @author Susantha.Pathirana
	 * @param Address
	 * 
	 */
	public void enterAddress(String Address) {
		logger.debug("Entering Address");
		getElement(txtAddress).clearAndSendkeys(Address);
		logger.debug("Entered Address");
	}

	/**
	 * Enter Country.
	 *
	 * @author Susantha.Pathirana
	 * @param Country
	 * 
	 */
	public void enterCountry(String Country) {
		logger.debug("Entering Country");
		getElement(txtCountry).clearAndSendkeys(Country);
		logger.debug("Entered Country");
	}

	/**
	 * Enter Land Phone.
	 *
	 * @author Susantha.Pathirana
	 * @param Land
	 *            Phone
	 * 
	 */
	public void enterLandPhone(String LandPhone) {
		logger.debug("Entering Land Phone");
		getElement(txtLandPhone).clearAndSendkeys(LandPhone);
		logger.debug("Entered Land Phone");
	}

	/**
	 * Enter Mobile Phone.
	 *
	 * @author Susantha.Pathirana
	 * @param Organization
	 * 
	 */
	public void enterMobilePhone(String MobilePhone) {
		logger.debug("Entering Mobile Phone");
		getElement(txtMobilePhone).clearAndSendkeys(MobilePhone);
		logger.debug("Entered Mobile Phone");
	}

	/**
	 * Enter IM.
	 *
	 * @author Susantha.Pathirana
	 * @param IM
	 * 
	 */
	public void enterIM(String IM) {
		logger.debug("Entering IM");
		getElement(txtIM).clearAndSendkeys(IM);
		logger.debug("Entered IM");
	}

	/**
	 * Enter URL.
	 *
	 * @author Susantha.Pathirana
	 * @param URL
	 * 
	 */
	public void enterURL(String URL) {
		logger.debug("Entering URL");
		getElement(txtURL).isDisplayed();
		getElement(txtURL).clearAndSendkeys(URL);
		logger.debug("Entered URL");
	}
	

	public void clickAdditionaldetails()
	{
		logger.debug("Clicking on Additional Details");
		getElement(linkAdditionalDetails).isDisplayed();
		getElement(linkAdditionalDetails).click();
		//Below Thread.sleep code must be removed and replaced with proper wait. 
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.debug("Clicked on Additional Details");
	}

	
	/**
	 * Checks if is user signup success msg.
	 *
	 * @author SulakkhanaW
	 * @param message
	 *            the message
	 * @return true, if is user signup success msg
	 * @throws Exception
	 *             the exception
	 */
	public boolean isUserSignupSuccessMsg(String message) throws Exception {
		flag = false;
		logger.debug("Validating user sginup success message");
		try {
			Thread.sleep(sleepTime);
			if (getElement(msgSuccess).getText().contains(message)) {
				flag = true;
				logger.debug("User sginup success message matched");
			} else {
				logger.debug("User sginup success message mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating User sginup success messager 'isUserSignupSuccessMsg()'"
					+ e.getMessage());
			throw new Exception("Exception While Validating User sginup success message 'isUserSignupSuccessMsg()'"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Click ok.
	 *
	 * @author SulakkhanaW
	 */
	public void clickOk() {
		logger.debug("Clicking on ok");
		getElement(btnOK).click();
		logger.debug("Clicked on ok");
	}

}
