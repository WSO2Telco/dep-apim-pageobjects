package com.wso2telco.apimanager.pageobjects.apipublisher;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.apimanager.pageobjects.apihome.subscriptions.SubscriptionsPage;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class APIPublisherHomePage extends BasicPageObject {
	
	Logger logger = Logger.getLogger(SubscriptionsPage.class);
	
	private WebPelement lblUsername = defineEelement(UIType.Xpath, "//a[@id='userMenu']");
	
	private WebPelement lnkAPIAdd = defineEelement(UIType.Xpath, "//li/a[text()[contains(.,'Add')]]");
	
	private WebPelement txtApiName = defineEelement(UIType.Xpath, "//input[@id='name']");
	
	private WebPelement txtApiContext = defineEelement(UIType.Xpath, "//input[@id='context']");
	
	private WebPelement txtApiVersion = defineEelement(UIType.Xpath, "//input[@id='version']");
	
	private WebPelement txtApiURL = defineEelement(UIType.Xpath, "//input[@id='resource_url_pattern']");
	
	private WebPelement btnAddNewResource = defineEelement(UIType.Xpath, "//button[@id='add_resource']");
	
	private WebPelement lnkResource = defineEelement(UIType.Xpath, "//tr[2]/td[2]/a");
	
	private WebPelement txtParameterName = defineEelement(UIType.Xpath, "//input[@name='parameter_name']");
	
	private WebPelement lnkAddDescription = defineEelement(UIType.Xpath, "//tr[2]/td[2]/a[@class='param_desc editable editable-click editable-empty']");
	
	private WebPelement txtDescription = defineEelement(UIType.Xpath, "//td[2]/..//input[@type='text']");
	
	private WebPelement btnDescriptionSubmit = defineEelement(UIType.Xpath, "//td[2]/..//div/button[@type='submit']");
	
	private WebPelement lnkParameterType = defineEelement(UIType.Xpath, "//td[3]/a[text()[contains(.,'query')]]");
	
	private WebPelement ddlParameterTypeList = defineEelement(UIType.Xpath, "//div/select[@class='input-medium']");
	
	private WebPelement btnParameterTypeSubmit = defineEelement(UIType.Xpath, "//td[3]/..//div//button[@type='submit']");
	
	private WebPelement lnkAddDataType = defineEelement(UIType.Xpath, "//td/a[@class='param_type editable editable-click editable-empty']");
	
	private WebPelement txtDataType = defineEelement(UIType.Xpath, "//td[4]/..//input[@type='text']");
	
	private WebPelement btnSubmitDataType  = defineEelement(UIType.Xpath, "//td[4]/..//div//button[@type='submit']");
	
	private WebPelement lnkRequired = defineEelement(UIType.Xpath, "//td/a[@class='param_required editable editable-click editable-empty']");
	
	private WebPelement ddlRequiredType = defineEelement(UIType.Xpath, "//td[5]//div/select[@class='input-medium']");
	
	private WebPelement btnSubmitRequired = defineEelement(UIType.Xpath, "//td[5]/..//div//button[@type='submit']");
	
	private WebPelement btnImplement = defineEelement(UIType.Xpath, "//a[text()[contains(.,'Implement')]]");
	
	private WebPelement ddlEndpointType = defineEelement(UIType.Xpath, "//select[@id='endpoint_type']");
	
	private WebPelement txtProdEndpoint = defineEelement(UIType.Xpath, "//input[contains(@id,'production_endpoints')]");
	
	private WebPelement txtSandboxEndpoint = defineEelement(UIType.Xpath, "//input[contains(@id,'sandbox_endpoints')]");
	
	private WebPelement btnManage = defineEelement(UIType.Xpath, "//a[@id='go_to_manage']");
	
	private WebPelement btnTierAvailability = defineEelement(UIType.Xpath, "//div/div/button[@data-toggle='dropdown']");
	
	private WebPelement btnSavePublish = defineEelement(UIType.Xpath, "//a[text()[contains(.,'Save & Publish')]]");
	
	private WebPelement lblProdUrl = defineEelement(UIType.Xpath, "//td[text()[contains(.,'Production URL')]]/../td[@id='inUrl']");
	
	private WebPelement lblSandbox = defineEelement(UIType.Xpath, "//td[text()[contains(.,'Sandbox URL')]]/../td[@id='sandbox']");
	
	private WebPelement lblTierAvailability = defineEelement(UIType.Xpath, "//td[text()[contains(.,'Tier Availability')]]/../td[@id='tierAvb']");

	public APIPublisherHomePage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isUserLogin(String username) throws Exception{
		flag = false;
		logger.debug("Validating User login");
		try {
			if (getElement(lblUsername).getText().trim().equalsIgnoreCase(username)){
				flag = true;
				logger.debug("User login is success");
			} else {
				logger.debug("User login is failed");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating User login 'isUserLogin()'" + e.getMessage());
			throw new Exception("Exception While Validating User login 'isUserLogin()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public void clickApiAdd(){
		getElement(lnkAPIAdd).click();
	}
	
	public void enterAPIName(String apiName){
		getElement(txtApiName).clearAndSendkeys(apiName);
	}
	
	public void enterAPIContext(String context){
		getElement(txtApiContext).clearAndSendkeys(context);
	}
	
	public void enterAPIVersion(String version){
		getElement(txtApiVersion).clearAndSendkeys(version);
	}
	
	public void enterAPIUrl(String url){
		getElement(txtApiURL).clearAndSendkeys(url);
	}
	
	public void setUrlType(String type){
		String xpath = "//label[text()[contains(.,'" + type + "')]]/input";
		WebPelement chkType = defineEelement(UIType.Xpath, xpath);
		getElement(chkType).click();
	}
	
	public void clickAddNewResource(){
		getElement(btnAddNewResource).click();
	}
	
	public void clickResource(){
		getElement(lnkResource).click();
	}
	
	public void enterParameterName(String paramtername){
		getElement(txtParameterName).clearAndSendkeys(paramtername);
	}
	
	public void clickAddParameter(String addparameter){
		String xpath = "//a[text()[contains(.,'" + addparameter + "')]]";
		WebPelement btnAddParameter = defineEelement(UIType.Xpath, xpath);
		getElement(btnAddParameter).click();
	}
	
	public void clickAddDescription(){
		getElement(lnkAddDescription).click();
	}
	
	public void enterParameterDescription(String description){
		getElement(txtDescription).clearAndSendkeys(description);
	}
	
	public void submitParameterDescription(){
		getElement(btnDescriptionSubmit).click();
	}
	
	public void clickParameterType(){
		getElement(lnkParameterType).click();
	}
	
	public void selectParameterType(String value){
		getElement(ddlParameterTypeList).sendKeys(value);
		getElement(ddlParameterTypeList).sendEnter();
	}
	
	public void submitParameterType(){
		getElement(btnParameterTypeSubmit).click();
	}
	
	public void clickAddDataType(){
		getElement(lnkAddDataType).click();
	}
	
	public void enterDataType(String dataType){
		getElement(txtDataType).clearAndSendkeys(dataType);
	}
	
	public void submitDataType(){
		getElement(btnSubmitDataType).click();
	}
	
	public void clickAddRequired(){
		getElement(lnkRequired).click();
	}
	
	public void SelectRequiredType(String value){
		getElement(ddlRequiredType).sendKeys(value);
		getElement(ddlRequiredType).sendEnter();
	}
	
	public void submitRequiredType(){
		getElement(btnSubmitRequired).click();
	}
	
	public void clickImplement(){
		getElement(btnImplement).click();
	}
	
	public void selectEndpointType(String endpointType){
		getElement(ddlEndpointType).sendKeys(endpointType);
		getElement(ddlEndpointType).sendEnter();
	}
	
	public void enterProdEndpoint(String prodEndpoint){
		getElement(txtProdEndpoint).clearAndSendkeys(prodEndpoint);
	}
	
	public void enterSandboxEndpoint(String sandboxEndpoint){
		getElement(txtSandboxEndpoint).clearAndSendkeys(sandboxEndpoint);
	}
	
	public void clickManage(){
		getElement(btnManage).click();
	}
	
	public void selectTierAvailability(String tier){
		getElement(btnTierAvailability).click();
		String xpath = "//div/div/ul/li/a/label[text()[contains(.,'" + tier + "')]]/input[@type='checkbox']";
		WebPelement lblTier = defineEelement(UIType.Xpath, xpath);
		getElement(lblTier).click();
	}
	
	public void clickSavePublish(){
		getElement(btnSavePublish).click();
	}
	
	public boolean isProductionUrl(String url) throws Exception{
		flag = false;
		logger.debug("Validating production URL");
		try {
			if (getElement(lblProdUrl).getText().trim().equalsIgnoreCase(url)){
				flag = true;
				logger.debug("Production URL matched");
			} else {
				logger.debug("Production URL mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating production URL 'isProductionUrl()'" + e.getMessage());
			throw new Exception("Exception While Validating production URL 'isProductionUrl()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public boolean isSandboxUrl(String url) throws Exception{
		flag = false;
		logger.debug("Validating sandbox URL");
		try {
			if (getElement(lblSandbox).getText().trim().equalsIgnoreCase(url)){
				flag = true;
				logger.debug("Sandbox URL matched");
			} else {
				logger.debug("Sandbox URL mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating sandbox URL 'isSandboxUrl()'" + e.getMessage());
			throw new Exception("Exception While Validating sandbox URL 'isSandboxUrl()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public boolean isTierAvailability(String url) throws Exception{
		flag = false;
		logger.debug("Validating tier availability");
		try {
			if (getElement(lblTierAvailability).getText().trim().equalsIgnoreCase(url)){
				flag = true;
				logger.debug("Tier availability matched");
			} else {
				logger.debug("Tier availability matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating tier availability 'isTierAvailability()'" + e.getMessage());
			throw new Exception("Exception While Validating tier availability 'isTierAvailability()'" + e.getLocalizedMessage());
		}
		return flag;
	}

}
