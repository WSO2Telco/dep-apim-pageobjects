package com.wso2telco.apimanager.pageobjects.apihome.sandbox;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.element.table.Table;
import com.wso2telco.test.framework.util.UIType;

import org.apache.log4j.Logger;

public class SandBoxUSSDPage extends BasicPageObject{
	
	/** The logger. */
	Logger logger = Logger.getLogger(SandBoxPage.class);

	/**The lbl USSD header*/
	private WebPelement lblUSSDParameters=defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");
	
	/**The txt address*/
	private WebPelement txtAddressUssd = defineEelement(UIType.ID, "address");
	
	/**The txt short code*/
	private WebPelement txtShortCode = defineEelement(UIType.ID, "shortCode");
	
	/**The txt Outbound USSDMessage*/
	private WebPelement txtOutBoundUssdMsg = defineEelement(UIType.ID, "outboundUSSDMessage");
	
	/**The txt client correlator*/
	private WebPelement txtClienCorrelator=defineEelement(UIType.ID, "clientCorrelator");
	
	/**The dd Ussd action*/
	private WebPelement ddUssdAction=defineEelement(UIType.ID, "ussdAction");
	
	/**The txt call back url*/
	private WebPelement txtCallBackDataUSSD=defineEelement(UIType.ID, "callbackData");
	
	/**The txt notify url*/
	private WebPelement txtNotifyUrlforUSSD =defineEelement(UIType.ID, "notifyURL");
	
	/**The txt key word*/
	private WebPelement txtKeyWord=defineEelement(UIType.ID, "keyword");
	
	/**The btn request send for ussd*/
	private WebPelement btnrequestSendUssd=defineEelement(UIType.ID, "ussd-submit-add-button");
	
	/**The txt request payload*/
	private WebPelement txtUssdRequevestpayload=defineEelement(UIType.Xpath, "//div[@class='ParameterValue']/textarea[@id='request']");
	
	/**The txt request payload*/
	private WebPelement txtUssdRespnsepayload=defineEelement(UIType.Xpath, "//div[@class='ParameterValue']/textarea[@id='response']");

	/** The tbl response data. */
	private String tblResponseData = "ussd_request_table";
	/**
	 * Instantiates a new sand box USSD page.
	 * @author Achiniuj
	 * @param driver
	 */
	public SandBoxUSSDPage(WebDriver driver) {
		super(driver);
		
	}
	
	/**
	 * Validate USSD page loaded correctly
	 * @author Achiniuj
	 * @param title
	 * @throws Exception
	 */
	public boolean isUssdParameters(String title)throws Exception{
		
		flag=false;
		logger.debug("Validating Ussd parameter page");
		try {
			if (getElement(lblUSSDParameters).getText().equals(title)){
			flag=true;	
			logger.debug("Validated Ussd parameter page");
			}else{
				logger.debug("Ussd parameter page not load correctly");
			}					
		} catch (Exception e) {		
			logger.debug("Exception While Validating payment parameters page 'isPaymentParameters()'" + e.getMessage());
			throw new Exception("Exception While Validating payment parameters page 'isPaymentParameters()'" + e.getLocalizedMessage());		
		}	
		return flag;
	}
	
	/**
	 * Enter USSD parameter address
	 * @author Achiniuj
	 * @param address
	 */
	public void enterAdress(String address){
		logger.debug("Entering address");	
		getElement(txtAddressUssd).clearAndSendkeys(address);
		logger.debug("Entered address");
		
	}
	/**
	 * Enter USSD parameter Short Code
	 * @author Achiniuj
	 * @param shortCode
	 */
	public void enterShortCode(String shortCode){
		logger.debug("Entering short code");
		getElement(txtShortCode).clearAndSendkeys(shortCode);
		logger.debug("Entered short code");
		
	}
	/**
	 * Enter USSD parameter Out Bound Message
	 * @author Achiniuj
	 * @param msg
	 */
	public void enterOutBoudMsg(String msg){
		logger.debug("Entering outbound USSD Message");
		getElement(txtOutBoundUssdMsg).clearAndSendkeys(msg);
		logger.debug("Entered outbound USSD Message");
	}
	
	/**
	 * Enter USSD parameter Client Correlator
	 * @author Achiniuj
	 * @param correlator
	 */
	public void enterCorrelator(String correlator){
		logger.debug("Entering Correlator");
		getElement(txtClienCorrelator).clearAndSendkeys(correlator);
		logger.debug("Entered Correlator");
	}
	
	/**
	 * Enter USSD parameter Call Back Data
	 * @author Achiniuj
	 * @param callBackData
	 */
	public void enterCallBackData(String callBackData){
		logger.debug("Entering call back data");
		getElement(txtCallBackDataUSSD).clearAndSendkeys(callBackData);
		logger.debug("Entered call back data");	
	}
	
	/**
	 * Enter USSD parameter Notify URL
	 * @author Achiniuj
	 * @param notifyUrl
	 */
	public void enterNotifyUrl(String notifyUrl){
		logger.debug("Entering Notify URL");
		getElement(txtNotifyUrlforUSSD).clearAndSendkeys(notifyUrl);
		logger.debug("Entered Notify URL");	
	}
	
	/**
	 * Enter USSD parameter Key Word
	 * @author Achiniuj
	 * @param keyWord
	 */
	public void enterKeyWord(String keyWord){
		logger.debug("Entering key word");
		getElement(txtKeyWord).clearAndSendkeys(keyWord);
		logger.debug("Entered key word");	
	}
	
	/**
	 * Select USSD action
	 * @author Achiniuj
	 * @param ussdAction
	 * @throws InterruptedException
	 */
	public void clickussdAction(String ussdAction) throws InterruptedException{
		Thread.sleep(1000);
		getElement(ddUssdAction).sendKeys(ussdAction);
		logger.debug("Clicked on Application name drop down");
		logger.debug("Sending enter key");
		getElement(ddUssdAction).sendEnter();
		logger.debug("Send enter key");
	}
	
	/**
	 * Click btn Send request 
	 * @author Achiniuj
	 */
	public void clickSendrequest(){
		logger.debug("Clcking send request");
		getElement(btnrequestSendUssd).click();
		logger.debug("Clcked send request");	
	}
	
	/**
	 * Get the USSD request payload parameters
	 * @author Achiniuj
	 * @return
	 * @throws InterruptedException
	 */
	public String getUSSDRequest() throws InterruptedException{
		Thread.sleep(sleepTime);
		return getElement(txtUssdRequevestpayload).getAttribute("value");
	}
	
	/**
	 * Get the USSD response payload parameters
	 * @return
	 * @throws InterruptedException
	 */
	public String getUSSDResponse() throws InterruptedException{
		Thread.sleep(sleepTime);
		return getElement(txtUssdRespnsepayload).getAttribute("value");
	}
	
	/**
	 * Get value from response result table 
	 * @author Achiniuj
	 * @return
	 */
	public List<String> getRowResponseContentsArray(){
		Table sendReqTable = getTable(UIType.ID, tblResponseData);
		int allColumn =sendReqTable.body().getNumberOfColumns();
		int lastRowNumber = sendReqTable.body().getNumberOfRows() - 1;
		List<String> rowdata = new ArrayList<String>();
		for (int x = 0; x < allColumn; x++){
			rowdata.add(sendReqTable.body().getCellFromRowIndexColumnIndex(lastRowNumber, x).getText().trim());
		}
		return rowdata;
	}


}
