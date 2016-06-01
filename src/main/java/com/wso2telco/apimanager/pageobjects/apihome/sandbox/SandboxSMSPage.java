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

// TODO: Auto-generated Javadoc
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
	public boolean isSMSParameters(String title) throws Exception{
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

}
