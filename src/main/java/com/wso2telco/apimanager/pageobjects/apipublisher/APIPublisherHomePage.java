package com.wso2telco.apimanager.pageobjects.apipublisher;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class APIPublisherHomePage.
 */
public class APIPublisherHomePage extends BasicPageObject {
	
//	private static final UIType UIType.Xpath = null;

	/** The logger. */
	Logger logger = Logger.getLogger(APIPublisherHomePage.class);
	
	/** The lbl username. */
	private WebPelement lblUsername = defineEelement(UIType.Xpath, "//a[@title='user']/span[2]");
	
	/** The lnk api add. */
	private WebPelement lnkAPIAdd = defineEelement(UIType.Xpath, "//li/a[text()[contains(.,'Add')]]");
	
	/** The rdo design api. */
	private WebPelement rdoDesignAPI = defineEelement(UIType.Xpath, "//div[text()='Design New API']/../preceding-sibling::*/span");
	
	/** The btn start creating. */
	private WebPelement btnStartCreating = defineEelement(UIType.ID, "designNewAPI");
	
	/** The txt api search. */
	private WebPelement txtAPISearch = defineEelement(UIType.Xpath, "//input[contains(@title,'Search')]");
	
	/** The btn search. */
	private WebPelement btnSearch = defineEelement(UIType.Xpath, "//button[@title='Search']");
	
	/** The txt api name. */
	private WebPelement txtApiName = defineEelement(UIType.ID, "name");
	
	/** The txt api context. */
	private WebPelement txtApiContext = defineEelement(UIType.ID, "context");
	
	/** The txt api version. */
	private WebPelement txtApiVersion = defineEelement(UIType.ID, "version");
	
	/** The txt api url. */
	private WebPelement txtApiURL = defineEelement(UIType.ID, "resource_url_pattern");
	
	/** The txt resource name. */
	private WebPelement txtResourceName = defineEelement(UIType.ID, "inputResource");
	
	/** The btn add new resource. */
	private WebPelement btnAddNewResource = defineEelement(UIType.ID, "add_resource");
	
	/** The lnk resource. */
	private WebPelement lnkResource = defineEelement(UIType.Xpath, "//tr[1]/td[2]/a");
	
	/** The txt parameter name. */
	private WebPelement txtParameterName = defineEelement(UIType.ClassName, "parameter_name");
	
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
	private WebPelement btnImplement = defineEelement(UIType.Xpath, "//a[text()='Next: Implement']");
	
	/** The lnk manage api. */
	private WebPelement lnkManageAPI = defineEelement(UIType.Xpath, "//h4[contains(.,'Managed API')]");
	
	/** The ddl endpoint type. */
	private WebPelement ddlEndpointType = defineEelement(UIType.ID, "endpoint_type");
	
	/** The txt prod endpoint. */
	private WebPelement txtProdEndpoint = defineEelement(UIType.Xpath, "//label[text()[contains(.,'Production Endpoint')]]/following-sibling::div/div/input");
	
	/** The txt sandbox endpoint. */
	private WebPelement txtSandboxEndpoint = defineEelement(UIType.Xpath, "//label[text()[contains(.,'Sandbox Endpoint')]]/following-sibling::div/div/input");
	
	/** The btn manage. */
	private WebPelement btnManage = defineEelement(UIType.ID, "go_to_manage");
	
	/** The btn tier availability. */
	private WebPelement btnTierAvailability = defineEelement(UIType.Xpath, "//div/div/button[@data-toggle='dropdown']");
	
	/** The btn save publish. */
	private WebPelement btnSavePublish = defineEelement(UIType.Xpath, "//a[text()[contains(.,'Save & Publish')]]");
	
	/** The btn goto overview. */
	private WebPelement btnGotoOverview = defineEelement(UIType.Xpath, "//div[@id='navbar']//a[contains(.,'Go to Overview')]");
	
	/** The lbl prod url. */
	private WebPelement lblProdUrl = defineEelement(UIType.Xpath, "//td[text()[contains(.,'Production URL')]]/../td[@id='inUrl']");
	
	/** The lbl sandbox. */
	private WebPelement lblSandbox = defineEelement(UIType.Xpath, "//td[text()[contains(.,'Sandbox URL')]]/../td[@id='sandbox']");
	
	/** The lbl tier availability. */
	private WebPelement lblTierAvailability = defineEelement(UIType.Xpath, "//td[text()[contains(.,'Tier Availability')]]/../td[@id='tierAvb']");
	
	/** The lbl api name. 
	 * %s = apiName
	 **/
	private String lblAPIName = "//div/h4/a[contains(@title,'%s')]";
	
	/** The btn api close. 
	 * %s_1 = apiName
	 **/
	private String btnAPIClose = "//div/h4/a[contains(@title,'%s')]/../following-sibling::h5[text()='%s']/following-sibling::a[@title='DELETE']";
	
	/** The chk url type. 
	 * %s_1 = type
	 **/
	private String chkURLType = "//input[@value='%s']/following-sibling::span";
	
	/** The btn resource add. */
	private WebPelement btnResourceAdd = defineEelement(UIType.ID, "add_resource");
	
	/** The chk url type ie. 
	 * %s_1 = type
	 * */
	private String chkURLTypeIE = "//input[@value='%s']";
	
	/** The btn add parameter. 
	 * %s_1 = AddParameter
	 **/
	private String btnAddParameter = "//a[text()[contains(.,'%s')]]";
	
	/** The lbl tier availability drop. 
	 * %s_1 = tier
	 **/
	private String lblTierAvailabilityDrop = "//div/div/ul/li/a/label[text()[contains(.,'%s')]]/input[@type='checkbox']";

	/** The chk subscription tiers
	 */
	private String chkSubscriptionTier = "//input[@value='%s']/following-sibling::span";
	
	/** btn Save API */
	private WebPelement btnSave = defineEelement(UIType.ID, "save_api");
	
	/** lbl api status */
	private WebPelement lblStatus = defineEelement(UIType.Xpath, "//span[@id='status']");
	
	/** lbl success message pop up */
	private WebPelement lblApiPublishedMessage = defineEelement(UIType.Xpath, "//div[@id='publish-success']/div/div/div/h3");
	
	/** Pop up btn Go to Overview */
	private WebPelement btnPopupGoToOverview = defineEelement(UIType.Xpath, "//div[@id='publish-success']//a[@title='Go to Overview']");
	
	/** lnk API*/
	private String lnkApi = "//h5[text()='%s']/preceding-sibling::h4/a[text()='%s']";
	
	/** tab Lifecycle */
	private WebPelement tabLifecycle = defineEelement(UIType.ID, "lifecyclesLink");
	
	/** lbl current state*/
	private WebPelement lblCurrentState = defineEelement(UIType.Xpath, "//h4[text()='Current State:']/../following-sibling::div//strong");
	
	/** chk api publish options */
	private String chkPublishOptions = "//span[contains(.,'%s')]";
	
	/** btn Publish API*/
	private WebPelement btnPublish = defineEelement(UIType.Xpath, "//input[@value='Publish']");
	
	/** btn create new version*/
	private WebPelement btnCreateNewVersion = defineEelement(UIType.Xpath, "//a[@title='Create New Version']");
	
	/** txt new version number */
	private WebPelement txtNewVersion = defineEelement(UIType.ID, "new-version");
	
	/** button Done */
	private WebPelement btnDone = defineEelement(UIType.Xpath, "//button[text()='Done']");
	
	/** lbl api state*/
	private String lblApiState = "//a[text()='%s']/../following-sibling::h5[text()='%s']/following-sibling::h5";
	
	/** lbl api subscriptions*/
	private String lblSubscriptions = "//a[text()='%s']/../following-sibling::h5[text()='%s']/following-sibling::p/a";
	
	/** lbl api publisher error */
	private WebPelement lblApiPublisherError = defineEelement(UIType.Xpath, "//h3[@class='modal-title']");
	
	WebDriverWait wait = new WebDriverWait(driver, 120);
	
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
		Thread.sleep(sleepTime);
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
	public void deleteExistingAPI(String apiName, String version) throws Exception{
		String xpath = String.format(lblAPIName, apiName);
		String closeXpath = String.format(btnAPIClose, apiName, version);
		WebPelement lnkclose = defineEelement(UIType.Xpath, closeXpath);
		WebPelement btnYes = defineEelement(UIType.Xpath, "//a[text()='Yes']");
		int count = driver.findElements(By.xpath(xpath)).size();//verifyListContent(UIType.Xpath, xpath).size();
		try {
			if(count != 0){
				logger.debug("API exist");
				getElement(lnkclose).click();
				logger.debug("Clicked on delete button");
				Thread.sleep(sleepTime);
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
	 * @throws InterruptedException the interrupted exception
	 */
	public void clickApiAdd() throws InterruptedException{
		logger.debug("Clicking on API add");
		getElement(lnkAPIAdd).click();
		Thread.sleep(sleepTime);
		logger.debug("Clicked on API add");
	}
	
	/**
	 * Click design api.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	public void clickDesignAPI() throws InterruptedException{
		logger.debug("Clicking on Design API");
		getElement(rdoDesignAPI).click();
		Thread.sleep(sleepTime);
		logger.debug("Clicked on Design API");
	}
	
	/**
	 * Click start creating.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	public void clickStartCreating() throws InterruptedException{
		logger.debug("Clicking on Start creating");
		getElement(btnStartCreating).click();
		Thread.sleep(sleepTime);
		logger.debug("Clicked on Start creating");
	}
	
	/**
	 * Enter api name.
	 *
	 * @author SulakkhanaW
	 * @param apiName the api name
	 * @throws InterruptedException the interrupted exception
	 */
	public void enterAPIName(String apiName) throws InterruptedException{
		logger.debug("Entering API name");
		Thread.sleep(sleepTime);
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
	 * Enter resource name.
	 *
	 * @author SulakkhanaW
	 * @param resourceName the resource name
	 * @throws InterruptedException the interrupted exception
	 */
	public void enterResourceName(String resourceName) throws InterruptedException{
		logger.debug("Entering Resource name");
		getElement(txtResourceName).clearAndSendkeys(resourceName);
		logger.debug("Entered Resource name");
		Thread.sleep(sleepTime);
	}
	
	/**
	 * Sets the url type.
	 *
	 * @author SulakkhanaW
	 * @param type the new url type
	 */
	public void setUrlType(String type){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		String Type = type.toLowerCase();
		String xpath = String.format(chkURLType, Type);
		String xpathIe = String.format(chkURLTypeIE, Type);
		WebPelement chkType = defineEelement(UIType.Xpath, xpath);
		WebPelement chkTypeIe = defineEelement(UIType.Xpath, xpathIe);
		
		logger.debug("Entering API URL type");
		if (config.getValue("browser").equalsIgnoreCase("INTERNETEXPLORER")){
			wait.until(ExpectedConditions.elementToBeClickable(getElement(chkTypeIe)));
			getElement(chkTypeIe).click();
		} else {		
			wait.until(ExpectedConditions.elementToBeClickable(getElement(chkType)));
			getElement(chkType).click();
		}
		logger.debug("Entered API URL type");
	}
	
	/**
	 * Click resource add.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	public void clickResourceAdd() throws InterruptedException{
		logger.debug("Clicking on Resource add");
		getElement(btnResourceAdd).click();
		Thread.sleep(sleepTime);
		logger.debug("Clicked on Resource add");
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
		String xpath = String.format(btnAddParameter, addparameter);
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
	 * @throws Exception 
	 */
	public void clickImplement() throws Exception{
		logger.debug("Clicking on Implement");
		getElement(btnImplement).click();
		Thread.sleep(sleepTime);
		logger.debug("Clicked on Implement");
	}
	
	/**
	 * Click mange api.
	 */
	public void clickMangeAPI(){
		logger.debug("Clicking on Manage API");
		getElement(lnkManageAPI).click();
		logger.debug("Clicked on Manage API");
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
	 * @throws InterruptedException 
	 */
	public void selectTierAvailability(String tier) throws InterruptedException{
		logger.debug("Selecting Tier");
		String[] subscriptionTier = tier.split(",");
		for(int i=0; i<subscriptionTier.length; i++){
			String xpath = String.format(chkSubscriptionTier, subscriptionTier[i]);
			WebPelement lblTier = defineEelement(UIType.Xpath, xpath);
			getElement(lblTier).click();			
		}
		logger.debug("Tier Selected");
		Thread.sleep(sleepTime);
	}
	
	/**
	 * Click save publish.
	 *
	 * @author SulakkhanaW
	 * @throws InterruptedException 
	 */
	public void clickSavePublish() throws InterruptedException{
		logger.debug("Clicking on Publish");
		Thread.sleep(sleepTime);
		getElement(btnSavePublish).click();
		logger.debug("Clicked on Publish");
	}
	
	/**
	 * Click goto overview.
	 */
	public void clickGotoOverview(){
		logger.debug("Clicking on Go to overview");
		getElement(btnGotoOverview).click();
		logger.debug("Clicked on Go to overview");
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
	
	/**
	 * Click API save button.
	 *
	 * @author MalshaniS
	 * @throws InterruptedException 
	 */
	public void clickSaveAPI() throws Exception{
		logger.debug("Saving api");
		getElement(btnSave).click();
		Thread.sleep(sleepTime);
		logger.debug("API saved successfully");
	}

	/**
	 * Check the API status
	 *
	 * @author MalshaniS
	 * @throws Exception 
	 * 
	 */
	public boolean isAPIStatusAvailable(String apiStatus) throws Exception{
		flag = false;
		logger.debug("Checking API Status");
		
		try{
			if(getElement(lblStatus).getText().trim().equals(apiStatus)){
				flag = true;
				logger.debug("APi Status matched");
			}
			else{
				logger.debug("APi Status not matched");
			}
		}
		catch(Exception e){
			logger.debug("Exception While checking api status 'isAPIStatusAvailable()'" + e.getMessage());
			throw new Exception("Exception While checking api status 'isAPIStatusAvailable()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Check if the API published successfully
	 *
	 * @author MalshaniS
	 * @throws Exception 
	 * 
	 */
	public boolean isPublishSuccess(String message) throws Exception{	
			flag = false;
			logger.debug("Checking success message displayed");
			
			try{
				if(getElement(lblApiPublishedMessage).getText().trim().equals(message)){
					flag = true;
					logger.debug("APi Successfully Published");
				}
				else{
					logger.debug("APi Not Published");
				}
			}
			catch(Exception e){
				logger.debug("Exception While checking api status 'isPublishSuccess()'" + e.getMessage());
				throw new Exception("Exception While checking api status 'isPublishSuccess()'" + e.getLocalizedMessage());
			}
			return flag;
	}
	
	/**
	 * Click success pop up Go to Overview button
	 *
	 * @author MalshaniS
	 * @throws InterruptedException 
	 */
	public void clickPopupGoToOverview() throws Exception{
		logger.debug("Clicking on Go to overview button");
		getElement(btnPopupGoToOverview).click();
		Thread.sleep(sleepTime);
		logger.debug("Clicked on Go to Overview button");
	}
	
	/**
	 * Click on created api
	 *
	 * @author MalshaniS
	 * @throws Exception 
	 */
	public void clickOnApi(String apiName, String version) throws Exception{
		logger.debug("Clicking on API");
		String xpath = String.format(lnkApi, version, apiName);
		WebPelement lnkApiName = defineEelement(UIType.Xpath, xpath);
		getElement(lnkApiName).click();
		Thread.sleep(sleepTime);
		logger.debug("Clicked on API");
	}
	
	/**
	 * Click on Lifecycle tab
	 *
	 * @author MalshaniS
	 * @throws Exception 
	 */
	public void clickLifecycle() throws Exception{
		logger.debug("Clicking on Lifecycle tab");
		getElement(tabLifecycle).click();
		Thread.sleep(sleepTime);
		logger.debug("Clicked on Lifecycle tab");
	}
	
	/**
	 * Check the current state of the api
	 *
	 * @author MalshaniS
	 * @throws Exception 
	 * 
	 */
	public boolean checkCurrentState(String state) throws Exception{	
			flag = false;
			logger.debug("Checking current state of api");
			
			try{
				if(getElement(lblCurrentState).getText().trim().equals(state)){
					flag = true;
					logger.debug("Current State of api matched");
				}
				else{
					logger.debug("Current State of api not matched");
				}
			}
			catch(Exception e){
				logger.debug("Exception While checking current state of api 'checkCurrentState()'" + e.getMessage());
				throw new Exception("Exception While checking current state of api 'checkCurrentState()'" + e.getLocalizedMessage());
			}
			return flag;
	}
	
	/**
	 * Click on publish options check box 
	 *
	 * @author MalshaniS
	 * @throws Exception 
	 */
	public void clickApiPublishOption(String option) throws Exception{
		logger.debug("Selecting an option before publish the api");
		String xpath = String.format(chkPublishOptions, option);
		WebPelement chkApiPublishOption = defineEelement(UIType.Xpath, xpath);
		getElement(chkApiPublishOption).click();
		Thread.sleep(sleepTime);
		logger.debug("Selected an option before publish the api");
	}
	
	/**
	 * Click on publish button
	 *
	 * @author MalshaniS
	 * @throws Exception 
	 */
	public void clickPublish() throws Exception{
		logger.debug("Clicking on Publish button");
		getElement(btnPublish).click();
		Thread.sleep(sleepTime);
		logger.debug("Clicked on Publish button");
	}
	
	/**
	 * Click on create new version button
	 *
	 * @author MalshaniS
	 * @throws Exception 
	 */
	public void clickCreateNewVersion() throws Exception{
		logger.debug("Clicking on Create New Version button");
		getElement(btnCreateNewVersion).click();
		Thread.sleep(sleepTime);
		logger.debug("Clicked on Create New Version button");
	}
	
	/**
	 * Enter new version number
	 *
	 * @author MalshaniS
	 * @throws Exception 
	 */
	public void enterNewVersionNumber(String newVersion) throws Exception{
		logger.debug("Entering New Version number");
		getElement(txtNewVersion).clearAndSendkeys(newVersion);
		Thread.sleep(sleepTime);
		logger.debug("Entered New Version number");
	}
	
	/**
	 * Click on Done button
	 *
	 * @author MalshaniS
	 * @throws Exception 
	 */
	public void clickDone() throws Exception{
		logger.debug("Clicking on Done button");
		getElement(btnDone).click();
		Thread.sleep(sleepTime);
		logger.debug("Clicked on Done button");
	}
	
	/**
	 * Check the api state
	 *
	 * @author MalshaniS
	 * @throws Exception 
	 * @return true if api state is matched
	 */
	public boolean checkApiState(String apiName, String version, String state) throws Exception{	
			flag = false;
			logger.debug("Checking api state");
			String xpath = String.format(lblApiState, apiName, version);
			WebPelement lblState = defineEelement(UIType.Xpath, xpath);		
			try{
				if(getElement(lblState).getText().trim().equals(state)){
					flag = true;
					logger.debug("Current State of api matched");
				}
				else{
					logger.debug("Current State of api not matched");
				}
			}
			catch(Exception e){
				logger.debug("Exception While checking current state of api 'checkApiState()'" + e.getMessage());
				throw new Exception("Exception While checking current state of api 'checkApiState()'" + e.getLocalizedMessage());
			}
			return flag;
	}
	
	/**
	 * Check the Number of users for api
	 *
	 * @author MalshaniS
	 * @throws Exception 
	 * @return true if number of subscriptions for api matched
	 */
	public boolean checkApiUsers(String apiName, String version, String numOfUsers) throws Exception{	
			flag = false;
			logger.debug("Checking api Users");
			String xpath = String.format(lblSubscriptions, apiName, version);
			WebPelement lblNumOfUsers = defineEelement(UIType.Xpath, xpath);		
			try{
				if(getElement(lblNumOfUsers).getText().trim().equals(numOfUsers)){
					flag = true;
					logger.debug("Number of Users of api matched");
				}
				else{
					logger.debug("Number of Users of api not matched");
				}
			}
			catch(Exception e){
				logger.debug("Exception While checking Number of Users of api 'checkApiUsers()'" + e.getMessage());
				throw new Exception("Exception While checking Number of Users of api 'checkApiUsers()'" + e.getLocalizedMessage());
			}
			return flag;
	}
	
	/**
	 * Validate subscription exists error popup
	 *
	 * @author MalshaniS
	 * @throws Exception 
	 * @return true if subscription exists error poped up
	 */
	public boolean isApiPublisherError(String errormessage) throws Exception{	
			flag = false;
			logger.debug("Checking api publisher error");
				
			try{
				if(getElement(lblApiPublisherError).getText().trim().equalsIgnoreCase(errormessage)){
					flag = true;
					logger.debug("Api publisher error poped up");
				}
				else{
					logger.debug("Api publisher error not poped up");
				}
			}
			catch(Exception e){
				logger.debug("Exception While checking apipublisher error 'isApiPublisherError()'" + e.getMessage());
				throw new Exception("Exception While checking apipublisher error 'isApiPublisherError()'" + e.getLocalizedMessage());
			}
			return flag;
	}
}
