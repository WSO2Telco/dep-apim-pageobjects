package com.wso2telco.apimanager.pageobjects.apipublisher;

import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.element.CoreElement;
import com.wso2telco.test.framework.util.UIType;
/**
 *this include the page element data for publisher jaggery app. 
 *this supports only on carbon version 4.x 
 *
 */
public enum PuplisherElement_v2x {
	LBL_USER_NAME(UIType.Xpath, "//a[@title='user']/span[2]"),
	ERROR_DUPLICATE_API_NAME(UIType.Xpath, "//label[@id='name-error']");
	
	private UIType uiType;
	private String value;

	PuplisherElement_v2x(UIType uiType, String value) {
		this.uiType = uiType;
		this.value = value;
	}
	
	public  WebPelement getElelment() {
		return new CoreElement(this.uiType, this.value);
	}
}
