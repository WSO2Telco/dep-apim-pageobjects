package com.wso2telco.apimanager.pageobjects.signup;

import org.openqa.selenium.WebDriver;
import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class SignUpPage extends BasicPageObject {
	

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
	
	public boolean validateSignUpHeader(){
		return getElement(titleSignUp).getText().equalsIgnoreCase("Sign - Up for a New Account");
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
	
	public boolean validateSuccessMsg(String message){
		return getElement(msgSuccess).getText().contains(message);
	}
	
	public void clickOk(){
		getElement(btnOK).click();
	}

}
