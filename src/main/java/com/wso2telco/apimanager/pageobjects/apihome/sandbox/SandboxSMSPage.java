package com.wso2telco.apimanager.pageobjects.apihome.sandbox;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.element.table.Table;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class SandboxSMSPage.
 */
public class SandboxSMSPage extends BasicPageObject {
	
	/** The logger. */
	Logger logger = Logger.getLogger(SandboxSMSPage.class);
	
	/** The lbl send sms. */
	private WebPelement lblSendSMS = defineEelement(UIType.Xpath, "//a[contains(.,'Send SMS')]");
	
	/** The ddl application. */
	private WebPelement ddlApplication = defineEelement(UIType.ID, "destination-address");
	
	/** The ddl sender address. */
	private WebPelement ddlSenderAddress = defineEelement(UIType.ID, "sender-address");
	
	/** The txt sender message. */
	private WebPelement txtSenderMessage = defineEelement(UIType.ID, "message");
	
	/** The btn send request. */
	private WebPelement btnSendRequest = defineEelement(UIType.ID, "send-sms-to-application-button");
	
	/** The send request table. */
	private String sendRequestTable = "sms_send_request_table";
	
	/** The btn settings. */
	private WebPelement btnSettings = defineEelement(UIType.Xpath, "//input[@value='Settings']");
	
	/** The lbl sms parameters. */
	private WebPelement lblSMSParameters = defineEelement(UIType.Xpath,"//div[@class='title-section']/h2");
	
	/** The ddl delivery status. */
	private WebPelement ddlDeliveryStatus = defineEelement(UIType.ID, "delstatus");
	
	/** The txt notification delay. */
	private WebPelement txtNotificationDelay = defineEelement(UIType.ID, "notifydelay");
	
	/** The txt max notification allowed. */
	private WebPelement txtMaxNotificationAllowed = defineEelement(UIType.ID, "maxallowed");
	
	/** The btn param save. */
	private WebPelement btnParamSave = defineEelement(UIType.ID, "param-add-button");
	
	/** The ddl short address. */
	private WebPelement ddlShortAddress = defineEelement(UIType.ID, "senderaddr");
	
	/** The txt notify url. */
	private WebPelement txtNotifyUrl = defineEelement(UIType.ID, "notifyURL");
	
	/** The txt callback data. */
	private WebPelement txtCallbackData = defineEelement(UIType.ID, "callbackData");
	
	/** The txt criteria. */
	private WebPelement txtCriteria = defineEelement(UIType.ID, "criteria");
	
	/** The txt client correlator. */
	private WebPelement txtClientCorrelator = defineEelement(UIType.ID, "clientCorrelator");
	
	/** The btn nofify add button. */
	private WebPelement btnNofifyAddButton = defineEelement(UIType.ID, "nofify-add-button");
	
	/** The txt request payload. */
	private WebPelement txtRequestPayload = defineEelement(UIType.ID, "request");
	
	/** The txt reponse payload. */
	private WebPelement txtReponsePayload = defineEelement(UIType.ID, "response");
	
	/** The tbl response data. */
	private String tblResponseData = "sms_notification_table";
	
	/** The btn retrive sms. */
	private WebPelement btnRetriveSMS = defineEelement(UIType.Xpath, "//input[@value='Retrieve SMS ']");
	
	/** The ddl registration id. */
	private WebPelement ddlRegistrationID = defineEelement(UIType.ID, "registration-id");
	
	/** The txt max batch size. */
	private WebPelement txtMaxBatchSize = defineEelement(UIType.ID, "max-batch-size");
	
	/** The btn sms retrive request. */
	private WebPelement btnSMSRetriveRequest = defineEelement(UIType.ID, "sms-retrieve-request-button");
	
	/** The txt sms response payload. */
	private WebPelement txtSMSResponsePayload = defineEelement(UIType.ID, "json-response");
	
	/** The tbl retrive message. */
	private String tblRetriveMessage = "retrieve_messages_table";
	
	/** The lnk delivery subscription. */
	private WebPelement lnkDeliverySubscription = defineEelement(UIType.ID, "//a[contains(.,'Delivery Subscriptions')]");
	
	/** The txt filter criteria. */
	private WebPelement txtFilterCriteria = defineEelement(UIType.ID, "filterCriteria");
	
	/** The txt subscription notify url. */
	private WebPelement txtSubscriptionNotifyURL = defineEelement(UIType.ID, "notifyURL");
	
	/** The txt subscription callback. */
	private WebPelement txtSubscriptionCallback = defineEelement(UIType.ID, "callbackData");
	
	/** The txt subscription client correlator. */
	private WebPelement txtSubscriptionClientCorrelator = defineEelement(UIType.ID, "clientCorrelator");
	
	/** The btn notify add. */
	private WebPelement btnNotifyAdd = defineEelement(UIType.ID, "nofify-add-button");
	
	/** The tbl delivery sub data. */
	private String tblDeliverySubData = "delivery_sub_data_table";
	
	/** The btn subscription delete. */
	private String btnSubscriptionDelete = "//td[contains(.,'%s')]/../td/a";

	/**
	 * Instantiates a new sandbox sms page.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public SandboxSMSPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Click send sms.
	 *
	 * @author SulakkhanaW
	 */
	public void clickSendSMS(){
		logger.debug("Clicking on Send SMS link");
		getElement(lblSendSMS).click();
		logger.debug("Clicked on Send SMS link");
	}
	
	/**
	 * Select application.
	 *
	 * @author SulakkhanaW
	 * @param application the application
	 */
	public void selectApplication(String application){
		logger.debug("Selecting Application number");
		getElement(ddlApplication).sendKeys(application);
		logger.debug("Application number Selected");
	}
	
	/**
	 * Select sender address.
	 *
	 * @author SulakkhanaW
	 * @param senderAddress the sender address
	 */
	public void selectSenderAddress(String senderAddress){
		logger.debug("Selecting Sender Address");
		getElement(ddlSenderAddress).sendKeys(senderAddress);
		logger.debug("Sender Address Selected");
	}
	
	/**
	 * Sets the sender message.
	 *
	 * @author SulakkhanaW
	 * @param senderMessage the new sender message
	 */
	public void setSenderMessage(String senderMessage){
		logger.debug("Entering Sender message");
		getElement(txtSenderMessage).clearAndSendkeys(senderMessage);
		logger.debug("Sender message entered");
	}
	
	/**
	 * Click send request.
	 *
	 * @author SulakkhanaW
	 */
	public void clickSendRequest(){
		logger.debug("Clicking on Send request button");
		getElement(btnSendRequest).click();
		logger.debug("Clicked on Send request button");
	}
	
	/**
	 * Check row numbers.
	 *
	 * @author SulakkhanaW
	 * @return the int
	 */
	public int checkRowNumbers(){
		int lastRowNumber = 0;
		List<WebElement> allTables = driver.findElements(By.id(sendRequestTable));
		if (allTables.size() == 1){
			Table sendReqTable = getTable(UIType.ID, sendRequestTable);
			lastRowNumber = sendReqTable.body().getNumberOfRows();
		}
		return lastRowNumber;
	}
	
	/**
	 * Gets the row contents array.
	 *
	 * @author SulakkhanaW
	 * @param rowNumber the row number
	 * @return the row contents array
	 */
	public List<String> getRowContentsArray(int rowNumber){
		Table sendReqTable = getTable(UIType.ID, sendRequestTable);
		int allColumn = sendReqTable.head().getNumberOfColumns();
		List<String> rowdata = new ArrayList<String>();
		for (int x = 0; x < allColumn; x++){
			rowdata.add(sendReqTable.body().getCellFromRowIndexColumnIndex(rowNumber, x).getText().trim());
		}
		return rowdata;
	}
	
	/**
	 * Click settings.
	 *
	 * @author SulakkhanaW
	 */
	public void clickSettings(){
		logger.debug("Clicking on Settings button");
		getElement(btnSettings).click();
		logger.debug("Clicked on Settings button");
	}
	
	/**
	 * Checks if is SMS parameters.
	 *
	 * @author SulakkhanaW
	 * @param title the title
	 * @return true, if is SMS parameters
	 * @throws Exception the exception
	 */
	public boolean isSMSPageHeader(String title) throws Exception{
		flag = false;
		logger.debug("Validating SMS parameters page");
		try {
			if (getElement(lblSMSParameters).getText().equalsIgnoreCase(title)){
				flag = true;
				logger.debug("Payment SMS page is load properly");
			} else {
				logger.debug("Payment SMS page is not load properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating SMS parameters page 'isSMSParameters()'" + e.getMessage());
			throw new Exception("Exception While Validating SMS parameters page 'isSMSParameters()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Select delivery status.
	 *
	 * @author SulakkhanaW
	 * @param status the status
	 */
	public void selectDeliveryStatus(String status){
		logger.debug("Selecting delivery status");
		getElement(ddlDeliveryStatus).sendKeys(status);
		logger.debug("Delivery status Selected");
	}
	
	/**
	 * Checks if is delivery status.
	 *
	 * @author SulakkhanaW
	 * @param deliveryStatus the delivery status
	 * @return true, if is delivery status
	 * @throws Exception the exception
	 */
	public boolean isDeliveryStatus(String deliveryStatus) throws Exception{
		flag = false;
		logger.debug("Validating Delivery status");
		try {
			if (getElement(ddlDeliveryStatus).getAttribute("value").equalsIgnoreCase(deliveryStatus)){
				flag = true;
				logger.debug("Delivery status matched");
			} else {
				logger.debug("Delivery status mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Delivery status 'isDeliveryStatus()'" + e.getMessage());
			throw new Exception("Exception While Validating Delivery status 'isDeliveryStatus()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Sets the notification delay.
	 *
	 * @author SulakkhanaW
	 * @param notificationDelay the new notification delay
	 */
	public void setNotificationDelay(String notificationDelay){
		logger.debug("Setting notfication delay");
		getElement(txtNotificationDelay).clearAndSendkeys(notificationDelay);
		logger.debug("Notfication delay set");
	}
	
	/**
	 * Checks if is notification delay.
	 *
	 * @author SulakkhanaW
	 * @param notificationDelay the notification delay
	 * @return true, if is notification delay
	 * @throws Exception the exception
	 */
	public boolean isNotificationDelay(String notificationDelay) throws Exception{
		flag = false;
		logger.debug("Validating notification delay");
		try {
			if (getElement(txtNotificationDelay).getAttribute("value").equalsIgnoreCase(notificationDelay)){
				flag = true;
				logger.debug("notification delay matched");
			} else {
				logger.debug("notification delays mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating notification delay 'isNotificationDelay()'" + e.getMessage());
			throw new Exception("Exception While Validating notification delay 'isNotificationDelay()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Sets the max notification allwed.
	 *
	 * @author SulakkhanaW
	 * @param maxNotificationAllowed the new max notification allwed
	 */
	public void setMaxNotificationAllwed(String maxNotificationAllowed){
		logger.debug("Setting Max notification delay");
		getElement(txtMaxNotificationAllowed).clearAndSendkeys(maxNotificationAllowed);
		logger.debug("Max notification delay Set");
	}
	
	/**
	 * Checks if is max notification allowed.
	 *
	 * @author SulakkhanaW
	 * @param maxNotificationAllowed the max notification allowed
	 * @return true, if is max notification allowed
	 * @throws Exception the exception
	 */
	public boolean isMaxNotificationAllowed(String maxNotificationAllowed) throws Exception{
		flag = false;
		logger.debug("Validating max notification allowed");
		try {
			if (getElement(txtMaxNotificationAllowed).getAttribute("value").equalsIgnoreCase(maxNotificationAllowed)){
				flag = true;
				logger.debug("max notification allowed matched");
			} else {
				logger.debug("max notification allowed mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating max notification allowed 'isMaxNotificationAllowed()'" + e.getMessage());
			throw new Exception("Exception While Validating max notification allowed 'isMaxNotificationAllowed()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click param save.
	 *
	 * @author SulakkhanaW
	 */
	public void clickParamSave(){
		logger.debug("Clicking on parameter save button");
		getElement(btnParamSave).click();
		logger.debug("Clicked on parameter save button");
	}
	
	/**
	 * Sets the short code.
	 *
	 * @author SulakkhanaW
	 * @param shortCode the short code
	 */
	public void SetShortCode(String shortCode){
		logger.debug("Setting up sender address");
		getElement(ddlShortAddress).sendKeys(shortCode);
		logger.debug("Sender address Set");
	}
	
	/**
	 * Sets the notify url.
	 *
	 * @author SulakkhanaW
	 * @param notifyURL the new notify url
	 */
	public void setNotifyURL(String notifyURL){
		logger.debug("Setting up notifyURL");
		getElement(txtNotifyUrl).clearAndSendkeys(notifyURL);
		logger.debug("notify URL set");
	}
	
	/**
	 * Sets the callback data.
	 *
	 * @author SulakkhanaW
	 * @param callbackData the new callback data
	 */
	public void setCallbackData(String callbackData){
		logger.debug("Setting up callback data");
		getElement(txtCallbackData).clearAndSendkeys(callbackData);
		logger.debug("Callback data set");
	}
	
	/**
	 * Sets the criteria.
	 *
	 * @author SulakkhanaW
	 * @param criteria the new criteria
	 */
	public void setCriteria(String criteria){
		logger.debug("Setting up Criteria");
		getElement(txtCriteria).clearAndSendkeys(criteria);
		logger.debug("Criteria set");
	}
	
	/**
	 * Sets the client correlator.
	 *
	 * @author SulakkhanaW
	 * @param clientCorrelator the new client correlator
	 */
	public void setClientCorrelator(String clientCorrelator){
		logger.debug("Setting up client correlator");
		getElement(txtClientCorrelator).clearAndSendkeys(clientCorrelator);
		logger.debug("Client correlator set");
	}
	
	/**
	 * Click notify add button.
	 *
	 * @author SulakkhanaW
	 */
	public void clickNotifyAddButton(){
		logger.debug("Clicking on notify add button");
		getElement(btnNofifyAddButton).click();
		logger.debug("Clicked on notify add button");
	}
	
	/**
	 * Gets the sms request payload.
	 *
	 * @author SulakkhanaW
	 * @return the sms request payload
	 */
	public String getSmsRequestPayload(){
		return getElement(txtRequestPayload).getAttribute("value");
	}
	
	/**
	 * Gets the sms response payload.
	 *
	 * @author SulakkhanaW
	 * @return the sms response payload
	 */
	public String getSmsResponsePayload(){
		return getElement(txtReponsePayload).getAttribute("value");
	}
	
	/**
	 * Gets the row response contents array.
	 *
	 * @author SulakkhanaW
	 * @return the row response contents array
	 */
	public List<String> getRowResponseContentsArray(){
		Table sendReqTable = getTable(UIType.ID, tblResponseData);
		int allColumn = sendReqTable.head().getNumberOfColumns();
		int lastRowNumber = sendReqTable.body().getNumberOfRows() - 1;
		List<String> rowdata = new ArrayList<String>();
		for (int x = 0; x < allColumn; x++){
			rowdata.add(sendReqTable.body().getCellFromRowIndexColumnIndex(lastRowNumber, x).getText().trim());
		}
		return rowdata;
	}
	
	/**
	 * Click retrive sms.
	 *
	 * @author SulakkhanaW
	 */
	public void clickRetriveSMS(){
		logger.debug("Clicking on Retrive SMS button");
		getElement(btnRetriveSMS).click();
		logger.debug("Clicked on Retrive SMS button");
	}
	
	/**
	 * Select registraion id.
	 *
	 * @author SulakkhanaW
	 * @param registrationId the registration id
	 */
	public void selectRegistraionID(String registrationId){
		logger.debug("Selecting Registraion ID");
		getElement(ddlRegistrationID).sendKeys(registrationId);
		logger.debug("Registraion ID Selected");
	}
	
	/**
	 * Enter max batch size.
	 *
	 * @author SulakkhanaW
	 * @param maxBatchSize the max batch size
	 */
	public void enterMaxBatchSize(String maxBatchSize){
		logger.debug("Entering max batch size");
		getElement(txtMaxBatchSize).clearAndSendkeys(maxBatchSize);
		logger.debug("Entered max batch size");
	}
	
	/**
	 * Click sms retrive request.
	 *
	 * @author SulakkhanaW
	 */
	public void clickSMSRetriveRequest(){
		logger.debug("Clicking on SMS retrive request button");
		getElement(btnSMSRetriveRequest).click();
		logger.debug("Clicked on SMS retrive request button");
	}
	
	/**
	 * Gets the SMS retrive payload.
	 *
	 * @author SulakkhanaW
	 * @return the SMS retrive payload
	 */
	public String getSMSRetrivePayload(){
		return getElement(txtSMSResponsePayload).getAttribute("value");
	}
	
	/**
	 * Gets the SMS retrive message.
	 *
	 * @author SulakkhanaW
	 * @return the SMS retrive message
	 */
	public List<List<String>> getSMSRetriveMessage(){
		List<List<String>> tabledata = new ArrayList<List<String>>();
		Table smsRetriveTable = getTable(UIType.ID, tblRetriveMessage);
		smsRetriveTable.body().getAllRows();
		return tabledata;
	}
	
	/**
	 * Click delivery subscription.
	 *
	 * @author SulakkhanaW
	 */
	public void clickDeliverySubscription(){
		logger.debug("Clicking on delivery subscription link");
		getElement(lnkDeliverySubscription).click();
		logger.debug("Clicked on delivery subscription link");
	}
	
	/**
	 * Enter filter criteria.
	 *
	 * @author SulakkhanaW
	 * @param filterCriteria the filter criteria
	 */
	public void enterFilterCriteria(String filterCriteria){
		logger.debug("Entering filter criteria");
		getElement(txtFilterCriteria).clearAndSendkeys(filterCriteria);
		logger.debug("Entered filter criteria");
	}
	
	/**
	 * Enter subscription notify url.
	 *
	 * @author SulakkhanaW
	 * @param notifyURL the notify url
	 */
	public void enterSubscriptionNotifyURL(String notifyURL){
		logger.debug("Entering notify URL");
		getElement(txtSubscriptionNotifyURL).clearAndSendkeys(notifyURL);
		logger.debug("Entered notify URL");
	}
	
	/**
	 * Enter subscription callback.
	 *
	 * @author SulakkhanaW
	 * @param subscriptionCallback the subscription callback
	 */
	public void enterSubscriptionCallback(String subscriptionCallback){
		logger.debug("Entering Subscription callback");
		getElement(txtSubscriptionCallback).clearAndSendkeys(subscriptionCallback);
		logger.debug("Entered Subscription callback");
	}
	
	/**
	 * Enter subscription clietn correlator.
	 *
	 * @author SulakkhanaW
	 * @param subscriptionClientCorrelator the subscription client correlator
	 */
	public void enterSubscriptionClietnCorrelator(String subscriptionClientCorrelator){
		logger.debug("Entering Subscription client correlator");
		getElement(txtSubscriptionClientCorrelator).clearAndSendkeys(subscriptionClientCorrelator);
		logger.debug("Entered Subscription client correlator");
	}
	
	/**
	 * Click subscription send request.
	 *
	 * @author SulakkhanaW
	 */
	public void clickSubscriptionSendRequest(){
		logger.debug("Clicking on subscription send request button");
		getElement(btnNotifyAdd).click();
		logger.debug("Clicked on subscription send request button");
	}
	
	/**
	 * Gets the delivery row table.
	 *
	 * @author SulakkhanaW
	 * @param clietnCorrelator the clietn correlator
	 * @return the delivery row table
	 */
	public List<String> getDeliveryRowTable(String clietnCorrelator){
		List<String> tabledata = new ArrayList<String>();
		Table smsSusbcriptionTable = getTable(UIType.ID, tblDeliverySubData);
		int getRowNumber = smsSusbcriptionTable.body().getRowIndexUsingTextInColumn(clietnCorrelator, 3);
		int columnRow = smsSusbcriptionTable.body().getNumberOfColumns();
		for (int x = 0; x < columnRow; x++)	{
			tabledata.add(smsSusbcriptionTable.body().getCellFromRowIndexColumnIndex(getRowNumber, x).getText().trim());
		}
		return tabledata;
	}
	
	/**
	 * Click delete subscription.
	 *
	 * @author SulakkhanaW
	 * @param subscriptionCorrelator the subscription correlator
	 */
	public void clickDeleteSubscription(String subscriptionCorrelator){
		logger.debug("Clicking on subscription delete button");
		String xpath = String.format(btnSubscriptionDelete, subscriptionCorrelator);
		WebPelement btnDelete = defineEelement(UIType.Xpath, xpath);
		getElement(btnDelete).click();
		logger.debug("Clicked on subscription delete button");
	}
	
	/**
	 * Checks if is subscrtion delete.
	 *
	 * @author SulakkhanaW
	 * @param clientCorrelator the client correlator
	 * @return true, if is subscrtion delete
	 * @throws Exception the exception
	 */
	public boolean isSubscrtionDelete(String clientCorrelator) throws Exception{
		logger.debug("Validating subscription deletion success");
		flag = false;
		Table smsSusbcriptionTable = getTable(UIType.ID, tblDeliverySubData);
		int getRowNumber = smsSusbcriptionTable.body().getRowIndexUsingTextInColumn(clientCorrelator, 3);
		try {
			if (getRowNumber == -1){
				flag = true;
				logger.debug("Subscription deleted successesfully");
			} else {
				logger.debug("Subscription not deleted");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating subscription deletion success 'isSubscrtionDelete()'" + e.getMessage());
			throw new Exception("Exception While Validating subscription deletion success 'isSubscrtionDelete()'" + e.getLocalizedMessage());
		}
		return flag;
	}

}
