package com.wso2telco.apimanager.pageobjects.apihome.sandbox;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class SandboxLBSPage.
 */
public class SandboxLBSPage extends BasicPageObject {
	
	/** The logger. */
	Logger logger = Logger.getLogger(SandboxLBSPage.class);
	
	/** The txt altitude. */
	private WebPelement txtAltitude = defineEelement(UIType.ID, "altitude");
	
	/** The txt latitude. */
	private WebPelement txtLatitude = defineEelement(UIType.ID, "latitude");
	
	/** The txt longitude. */
	private WebPelement txtLongitude = defineEelement(UIType.ID, "longitude");
	
	/** The ddllocation retrieval status. */
	private WebPelement ddllocationRetrievalStatus = defineEelement(UIType.ID, "retState");
	
	/** The btn save. */
	private WebPelement btnSave = defineEelement(UIType.ID, "param-add-button");
	
	/** The txt tel address. */
	private WebPelement txtTelAddress = defineEelement(UIType.ID, "address");
	
	/** The txt requested accuracy. */
	private WebPelement txtRequestedAccuracy = defineEelement(UIType.ID, "requestedAccuracy");
	
	/** The btn send request. */
	private WebPelement btnSendRequest = defineEelement(UIType.ID, "location-request-button");
	
	/** The txt response payload. */
	private WebPelement txtResponsePayload = defineEelement(UIType.ID, "json-response");

	/**
	 * Instantiates a new sandbox lbs page.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public SandboxLBSPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Sets the altitude.
	 *
	 * @author SulakkhanaW
	 * @param altitude the new altitude
	 */
	public void setAltitude(String altitude){
		logger.debug("Setting altitude");
		getElement(txtAltitude).clearAndSendkeys(altitude);
		logger.debug("Altitude is set");
	}
	
	/**
	 * Sets the latitude.
	 *
	 * @author SulakkhanaW
	 * @param latitude the new latitude
	 */
	public void setLatitude(String latitude){
		logger.debug("Setting latitude");
		getElement(txtLatitude).clearAndSendkeys(latitude);
		logger.debug("Latitude is set");
	}
	
	/**
	 * Sets the longitude.
	 *
	 * @author SulakkhanaW
	 * @param longitude the new longitude
	 */
	public void setLongitude(String longitude){
		logger.debug("Setting latitude");
		getElement(txtLongitude).clearAndSendkeys(longitude);
		logger.debug("Longitude is set");
	}
	
	/**
	 * Sets the location retrieval status.
	 *
	 * @author SulakkhanaW
	 * @param locationRetrievalStatus the new location retrieval status
	 */
	public void setLocationRetrievalStatus(String locationRetrievalStatus){
		logger.debug("Selecting LocationvRetrievalvStatus");
		getElement(ddllocationRetrievalStatus).sendKeys(locationRetrievalStatus);
		logger.debug("Location Retrieval Status selected");
	}
	
	/**
	 * Click save.
	 *
	 * @author SulakkhanaW
	 */
	public void clickSave(){
		logger.debug("Clicking on Savet");
		getElement(btnSave).click();
		logger.debug("Clicked on Save");
	}
	
	/**
	 * Sets the tel address.
	 *
	 * @author SulakkhanaW
	 * @param address the new tel address
	 */
	public void setTelAddress(String address){
		logger.debug("Setting tele address");
		getElement(txtTelAddress).clearAndSendkeys(address);;
		logger.debug("Tele address set");
	}
	
	/**
	 * Sets the requested accuracy.
	 *
	 * @author SulakkhanaW
	 * @param requestedAccuracy the new requested accuracy
	 */
	public void setRequestedAccuracy(String requestedAccuracy){
		logger.debug("Setting Requested Accuracy");
		getElement(txtRequestedAccuracy).click();
		logger.debug("Requested Accuracy set");
	}
	
	/**
	 * Click send request.
	 *
	 * @author SulakkhanaW
	 */
	public void clickSendRequest(){
		logger.debug("Clicking on send request");
		getElement(btnSendRequest).click();
		logger.debug("Clicked on send request");
	}
	
	/**
	 * Gets the location response.
	 *
	 * @author SulakkhanaW
	 * @return the location response
	 * @throws InterruptedException 
	 */
	public String getLocationResponse() throws InterruptedException{
		Thread.sleep(sleepTime);
		return getElement(txtResponsePayload).getAttribute("value");
	}

}
