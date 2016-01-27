package com.wso2telco.apimanager.pageobjects.signup;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.apimanager.pageobjects.apihome.subscriptions.SubscriptionsPage;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class SignUpPage extends BasicPageObject {
	
	Logger logger = Logger.getLogger(SubscriptionsPage.class);

	private WebPelement titleSignUp = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	private WebPelement txtNewUName = defineEelement(UIType.Xpath, "//input[@id='newUsername']");
	
	private WebPelement txtPWord = defineEelement(UIType.Xpath, "//input[@id='newPassword']");
	
	private WebPelement txtReTypePWord = defineEelement(UIType.Xpath, "//input[@id='newPasswordConfirm']");
	
	private WebPelement txtLName = defineEelement(UIType.Xpath, "//input[@id='0.0cliamUri']");
	
	private WebPelement txtFName = defineEelement(UIType.Xpath, "//input[@id='1.0cliamUri']");
	
	private WebPelement txtEmail = defineEelement(UIType.Xpath, "//input[@id='2.0cliamUri']");
	
	private WebPelement btnSubmit = defineEelement(UIType.Xpath, "//input[@class='submit btn btn-primary']");
	
	private WebPelement msgSuccess = defineEelement(UIType.Xpath, "//span[@class='messageText']");
	
	private WebPelement btnOK = defineEelement(UIType.Xpath, "//a[@class='btn btn btn-primary']");
	
	public SignUpPage(WebDriver driver) {
		super(driver);
	}
	
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
	
	public void enterNewUName(String userName){
		getElement(txtNewUName).clearAndSendkeys(userName);
	}
	
	public void enterPWord(String password){
		getElement(txtPWord).clearAndSendkeys(password);
	}
	
	public void reTypePWord(String confirmPassword){
		getElement(txtReTypePWord).clearAndSendkeys(confirmPassword);
	}
	
	public void enterLName(String lastName){
		getElement(txtLName).clearAndSendkeys(lastName);
	}
	
	public void enterFName(String firstName){
		getElement(txtFName).clearAndSendkeys(firstName);
	}
	
	public void enterEmail(String email){
		getElement(txtEmail).clearAndSendkeys(email);
	}
	
	public void clickSubmit(){
		getElement(btnSubmit).click();
	}
	
	public boolean isUserSignupSuccessMsg(String message) throws Exception{
		flag = false;
		logger.debug("Validating user sginup success message");
		try {
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
	
	public void clickOk(){
		getElement(btnOK).click();
	}

}
