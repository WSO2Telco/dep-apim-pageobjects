package com.wso2telco.apimanager.pageobjects.apipublisher;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class APIPublisherHomePage.
 */
public class APIPublisherHomePage extends BasicPageObject {
	
	/** The logger. */
	Logger logger = Logger.getLogger(APIPublisherHomePage.class);
	
	/** The lbl username. */
	private WebPelement lblUsername = defineEelement(UIType.ID, "userMenu");
	
	/** The lnk api add. */
	private WebPelement lnkAPIAdd = defineEelement(UIType.Xpath, "//li/a[text()[contains(.,'Add')]]");
	
	/** The txt api search. */
	private WebPelement txtAPISearch = defineEelement(UIType.Xpath, "//form/input[@class='input-xlarge search-query']");
	
	/** The btn search. */
	private WebPelement btnSearch = defineEelement(UIType.Xpath, "//button[text()[contains(.,'Search')]]");
	
	/** The txt api name. */
	private WebPelement txtApiName = defineEelement(UIType.ID, "name");
	
	/** The txt api context. */
	private WebPelement txtApiContext = defineEelement(UIType.ID, "context");
	
	/** The txt api version. */
	private WebPelement txtApiVersion = defineEelement(UIType.ID, "version");
	
	/** The txt api url. */
	private WebPelement txtApiURL = defineEelement(UIType.ID, "resource_url_pattern");
	
	/** The btn add new resource. */
	private WebPelement btnAddNewResource = defineEelement(UIType.ID, "add_resource");
	
	/** The lnk resource. */
	private WebPelement lnkResource = defineEelement(UIType.Xpath, "//tr[2]/td[2]/a");
	
	/** The txt parameter name. */
	private WebPelement txtParameterName = defineEelement(UIType.ID, "parameter_name");
	
	/** The lnk add description. */
	private WebPelement lnkAddDescription = defineEelement(UIType.Xpath, "//tr[2]/td[2]/a[@class='param_desc editable editable-click editable-empty']");
	
	/** The txt description. */
	private WebPelement txtDescription = defineEelement(UIType.Xpath, "//td[2]/..//input[@type='text']");
	
	/** The btn description submit. */
	private WebPelement btnDescriptionSubmit = defineEelement(UIType.Xpath, "//td[2]/..//div/button[@type='submit']");
	
	/** The lnk parameter type. */
	private WebPelement lnkParameterType = defineEelement(UIType.Xpath, "//td[3]/a[text()[contains(.,'query')]]");
	
	/** The ddl parameter type list. */
	private WebPelement ddlParameterTypeList = defineEelement(UIType.Xpath, "//div/select[@class='input-medium']");
	
	/** The btn parameter type submit. */
	private WebPelement btnParameterTypeSubmit = defineEelement(UIType.Xpath, "//td[3]/..//div//button[@type='submit']");
	
	/** The lnk add data type. */
	private WebPelement lnkAddDataType = defineEelement(UIType.Xpath, "//td/a[@class='param_type editable editable-click editable-empty']");
	
	/** The txt data type. */
	private WebPelement txtDataType = defineEelement(UIType.Xpath, "//td[4]/..//input[@type='text']");
	
	/** The btn submit data type. */
	private WebPelement btnSubmitDataType  = defineEelement(UIType.Xpath, "//td[4]/..//div//button[@type='submit']");
	
	/** The lnk required. */
	private WebPelement lnkRequired = defineEelement(UIType.Xpath, "//td/a[@class='param_required editable editable-click editable-empty']");
	
	/** The ddl required type. */
	private WebPelement ddlRequiredType = defineEelement(UIType.Xpath, "//td[5]//div/select[@class='input-medium']");
	
	/** The btn submit required. */
	private WebPelement btnSubmitRequired = defineEelement(UIType.Xpath, "//td[5]/..//div//button[@type='submit']");
	
	/** The btn implement. */
	private WebPelement btnImplement = defineEelement(UIType.Xpath, "//a[text()='Implement']");
	
	/** The ddl endpoint type. */
	private WebPelement ddlEndpointType = defineEelement(UIType.ID, "endpoint_type");
	
	/** The txt prod endpoint. */
	private WebPelement txtProdEndpoint = defineEelement(UIType.Xpath, "//input[contains(@id,'production_endpoints')]");
	
	/** The txt sandbox endpoint. */
	private WebPelement txtSandboxEndpoint = defineEelement(UIType.Xpath, "//input[contains(@id,'sandbox_endpoints')]");
	
	/** The btn manage. */
	private WebPelement btnManage = defineEelement(UIType.Xpath, "//a[@id='go_to_manage']");
	
	/** The btn tier availability. */
	private WebPelement btnTierAvailability = defineEelement(UIType.Xpath, "//div/div/button[@data-toggle='dropdown']");
	
	/** The btn save publish. */
	private WebPelement btnSavePublish = defineEelement(UIType.Xpath, "//a[text()[contains(.,'Save & Publish')]]");
	
	/** The lbl prod url. */
	private WebPelement lblProdUrl = defineEelement(UIType.Xpath, "//td[text()[contains(.,'Production URL')]]/../td[@id='inUrl']");
	
	/** The lbl sandbox. */
	private WebPelement lblSandbox = defineEelement(UIType.Xpath, "//td[text()[contains(.,'Sandbox URL')]]/../td[@id='sandbox']");
	
	/** The lbl tier availability. */
	private WebPelement lblTierAvailability = defineEelement(UIType.Xpath, "//td[text()[contains(.,'Tier Availability')]]/../td[@id='tierAvb']");

	/**
	 * Instantiates a new API publisher home page.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public APIPublisherHomePage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Checks if is user login.
	 *
	 * @author SulakkhanaW
	 * @param username the username
	 * @return true, if is user login
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Enter api name search.
	 *
	 * @author SulakkhanaW
	 * @param apiName the api name
	 */
	public void enterAPINameSearch(String apiName){
		logger.debug("Enter API name on the search text box");
		getElement(txtAPISearch).clearAndSendkeys(apiName);
		logger.debug("Entered API name on the search text box");
	}
	
	/**
	 * Click search.
	 *
	 * @author SulakkhanaW
	 */
	public void clickSearch(){
		logger.debug("Clicking on search");
		getElement(btnSearch).click();
		logger.debug("Clicked on search");
	}
	
	/**
	 * Delete existing api.
	 *
	 * @author SulakkhanaW
	 * @param apiName the api name
	 * @throws Exception the exception
	 */
	public void deleteExistingAPI(String apiName) throws Exception{
		String xpath = "//div/h5/a[contains(@title,'" + apiName + "')]";
		String closeXpath = "//div/h5/a[contains(@title,'" + apiName + "')]/../../../button[@type='button']";
		WebPelement lnkclose = defineEelement(UIType.Xpath, closeXpath);
		WebPelement btnYes = defineEelement(UIType.Xpath, "//a[text()='Yes']");
		int count = verifyListContent(UIType.Xpath, xpath).size();
		try {
			if(count != 0){
				logger.debug("API exist");
				getElement(lnkclose).click();
				logger.debug("Clicked on delete button");
				Thread.sleep(2000);
				getElement(btnYes).click();
				logger.debug("Clicked on delete warining popup yes button");
			}
			logger.debug("API is not exist");
		} catch (Exception e) {
			logger.debug("Exception While deleting existing API 'deleteExistingAPI()'" + e.getMessage());
			throw new Exception("Exception While deleting existing API 'deleteExistingAPI()'" + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Click api add.
	 *
	 * @author SulakkhanaW
	 */
	public void clickApiAdd(){
		logger.debug("Clicking on API add");
		getElement(lnkAPIAdd).click();
		logger.debug("Clicked on API add");
	}
	
	/**
	 * Enter api name.
	 *
	 * @author SulakkhanaW
	 * @param apiName the api name
	 */
	public void enterAPIName(String apiName){
		logger.debug("Entering API name");
		getElement(txtApiName).clearAndSendkeys(apiName);
		logger.debug("Entered API name");
	}
	
	/**
	 * Enter api context.
	 *
	 * @author SulakkhanaW
	 * @param context the context
	 */
	public void enterAPIContext(String context){
		logger.debug("Entering API context");
		getElement(txtApiContext).clearAndSendkeys(context);
		logger.debug("Entered API context");
	}
	
	/**
	 * Enter api version.
	 *
	 * @author SulakkhanaW
	 * @param version the version
	 */
	public void enterAPIVersion(String version){
		logger.debug("Entering API version");
		getElement(txtApiVersion).clearAndSendkeys(version);
		logger.debug("Enteriws API version");
	}
	
	/**
	 * Enter api url.
	 *
	 * @author SulakkhanaW
	 * @param url the url
	 */
	public void enterAPIUrl(String url){
		logger.debug("Entering API URL");
		getElement(txtApiURL).clearAndSendkeys(url);
		logger.debug("Entered API URL");
	}
	
	/**
	 * Sets the url type.
	 *
	 * @author SulakkhanaW
	 * @param type the new url type
	 */
	public void setUrlType(String type){
		String Type = type.toUpperCase();
		String xpath = "//label[text()[contains(.,'" + Type + "')]]/input";
		WebPelement chkType = defineEelement(UIType.Xpath, xpath);
		logger.debug("Entering API URL type");
		getElement(chkType).click();
		logger.debug("Entered API URL type");
	}
	
	/**
	 * Click add new resource.
	 *
	 * @author SulakkhanaW
	 */
	public void clickAddNewResource(){
		logger.debug("Clicking on Add new resource");
		getElement(btnAddNewResource).click();
		logger.debug("Clicked on add new resource");
	}
	
	/**
	 * Click resource.
	 *
	 * @author SulakkhanaW
	 */
	public void clickResource(){
		logger.debug("Clicking on Resource");
		getElement(lnkResource).click();
		logger.debug("Clicked on Resource");
	}
	
	/**
	 * Enter parameter name.
	 *
	 * @author SulakkhanaW
	 * @param paramtername the paramtername
	 */
	public void enterParameterName(String paramtername){
		logger.debug("Entering parameter name");
		getElement(txtParameterName).clearAndSendkeys(paramtername);
		logger.debug("Entered parameter name");
	}
	
	/**
	 * Click add parameter.
	 *
	 * @author SulakkhanaW
	 * @param addparameter the addparameter
	 */
	public void clickAddParameter(String addparameter){
		String xpath = "//a[text()[contains(.,'" + addparameter + "')]]";
		WebPelement btnAddParameter = defineEelement(UIType.Xpath, xpath);
		logger.debug("Clicking on Add parameter");
		getElement(btnAddParameter).click();
		logger.debug("Clicked on Add parameter");
	}
	
	/**
	 * Click add description.
	 *
	 * @author SulakkhanaW
	 */
	public void clickAddDescription(){
		logger.debug("Clicking on Add description");
		getElement(lnkAddDescription).click();
		logger.debug("Clicked on Add description");
	}
	
	/**
	 * Enter parameter description.
	 *
	 * @author SulakkhanaW
	 * @param description the description
	 */
	public void enterParameterDescription(String description){
		logger.debug("Entering paramter description");
		getElement(txtDescription).clearAndSendkeys(description);
		logger.debug("Entered paramter description");
	}
	
	/**
	 * Submit parameter description.
	 *
	 * @author SulakkhanaW
	 */
	public void submitParameterDescription(){
		logger.debug("Clicking on submit paramter description");
		getElement(btnDescriptionSubmit).click();
		logger.debug("Clicked on submit paramter description");
	}
	
	/**
	 * Click parameter type.
	 *
	 * @author SulakkhanaW
	 */
	public void clickParameterType(){
		logger.debug("Clicking on parameter type");
		getElement(lnkParameterType).click();
		logger.debug("Clicked on parameter type");
	}
	
	/**
	 * Select parameter type.
	 *
	 * @author SulakkhanaW
	 * @param value the value
	 */
	public void selectParameterType(String value){
		logger.debug("Selecting parameter type");
		getElement(ddlParameterTypeList).sendKeys(value);
		logger.debug("Parameter type selected");
	}
	
	/**
	 * Submit parameter type.
	 *
	 * @author SulakkhanaW
	 */
	public void submitParameterType(){
		logger.debug("Clicking on Submit parameter type");
		getElement(btnParameterTypeSubmit).click();
		logger.debug("Clicked on Submit parameter type");
	}
	
	/**
	 * Click add data type.
	 *
	 * @author SulakkhanaW
	 */
	public void clickAddDataType(){
		logger.debug("Clicking on Add data type");
		getElement(lnkAddDataType).click();
		logger.debug("Add data type clicked");
	}
	
	/**
	 * Enter data type.
	 *
	 * @author SulakkhanaW
	 * @param dataType the data type
	 */
	public void enterDataType(String dataType){
		logger.debug("Entering Data type");
		getElement(txtDataType).clearAndSendkeys(dataType);
		logger.debug("Entered Data type");
	}
	
	/**
	 * Submit data type.
	 *
	 * @author SulakkhanaW
	 */
	public void submitDataType(){
		logger.debug("Clicking on Submit Data type");
		getElement(btnSubmitDataType).click();
		logger.debug("Clicked on Submit Data type");
	}
	
	/**
	 * Click add required.
	 *
	 * @author SulakkhanaW
	 */
	public void clickAddRequired(){
		logger.debug("Clicking on Add required");
		getElement(lnkRequired).click();
		logger.debug("Clicked on Add required");
	}
	
	/**
	 * Select required type.
	 *
	 * @author SulakkhanaW
	 * @param value the value
	 */
	public void selectRequiredType(String value){
		logger.debug("Selecting Required type");
		getElement(ddlRequiredType).sendKeys(value);
		logger.debug("Required type Selected");
	}
	
	/**
	 * Submit required type.
	 *
	 * @author SulakkhanaW
	 */
	public void submitRequiredType(){
		logger.debug("Clicking on Submit Required type");
		getElement(btnSubmitRequired).click();
		logger.debug("Clicked on Submit Required type");
	}
	
	/**
	 * Click implement.
	 *
	 * @author SulakkhanaW
	 */
	public void clickImplement(){
		logger.debug("Clicking on Implement");
		getElement(btnImplement).click();
		logger.debug("Clicked on Implement");
	}
	
	/**
	 * Select endpoint type.
	 *
	 * @author SulakkhanaW
	 * @param endpointType the endpoint type
	 */
	public void selectEndpointType(String endpointType){
		logger.debug("Selecting endpoint type");
		getElement(ddlEndpointType).sendKeys(endpointType);
		logger.debug("Endpoint type Selected");
	}
	
	/**
	 * Enter prod endpoint.
	 *
	 * @author SulakkhanaW
	 * @param prodEndpoint the prod endpoint
	 */
	public void enterProdEndpoint(String prodEndpoint){
		logger.debug("Entering production endpoint");
		getElement(txtProdEndpoint).clearAndSendkeys(prodEndpoint);
		logger.debug("Entered production endpoint");
	}
	
	/**
	 * Enter sandbox endpoint.
	 *
	 * @author SulakkhanaW
	 * @param sandboxEndpoint the sandbox endpoint
	 */
	public void enterSandboxEndpoint(String sandboxEndpoint){
		logger.debug("Entering sandbox endpoint");
		getElement(txtSandboxEndpoint).clearAndSendkeys(sandboxEndpoint);
		logger.debug("Entered sandbox endpoint");
	}
	
	/**
	 * Click manage.
	 *
	 * @author SulakkhanaW
	 */
	public void clickManage(){
		logger.debug("Clicking on Manage");
		getElement(btnManage).click();
		logger.debug("Clicked on Manage");
	}
	
	/**
	 * Select tier availability.
	 *
	 * @author SulakkhanaW
	 * @param tier the tier
	 */
	public void selectTierAvailability(String tier){
		logger.debug("Clicking Tier availabilty drop down");
		getElement(btnTierAvailability).click();
		logger.debug("Clicked Tier availabilty drop down");
		String xpath = "//div/div/ul/li/a/label[text()[contains(.,'" + tier + "')]]/input[@type='checkbox']";
		WebPelement lblTier = defineEelement(UIType.Xpath, xpath);
		logger.debug("Selecting Tier");
		getElement(lblTier).click();
		logger.debug("Tier Selected");
	}
	
	/**
	 * Click save publish.
	 *
	 * @author SulakkhanaW
	 */
	public void clickSavePublish(){
		logger.debug("Clicking on Publish");
		getElement(btnSavePublish).click();
		logger.debug("Clicked on Publish");
	}
	
	/**
	 * Checks if is production url.
	 *
	 * @author SulakkhanaW
	 * @param url the url
	 * @return true, if is production url
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Checks if is sandbox url.
	 *
	 * @author SulakkhanaW
	 * @param url the url
	 * @return true, if is sandbox url
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Checks if is tier availability.
	 *
	 * @author SulakkhanaW
	 * @param url the url
	 * @return true, if is tier availability
	 * @throws Exception the exception
	 */
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
