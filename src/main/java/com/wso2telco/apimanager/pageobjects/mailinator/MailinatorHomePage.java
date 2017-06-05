package com.wso2telco.apimanager.pageobjects.mailinator;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by mahesh on 5/25/17.
 */
public class MailinatorHomePage extends BasicPageObject{


    Logger logger = Logger.getLogger(MailinatorHomePage.class);

    WebPelement mailIdInput = defineEelement(UIType.ID,"inboxfield");

    public MailinatorHomePage(WebDriver driver) {
        super(driver);
    }



        private void enterUserId(String userAccount){
            logger.info("entering user account");
            getElement(mailIdInput).clearAndSendkeys(userAccount);

        }

     public MailinatorMailPage getEmailForUserAccount(String user){
            logger.info("Calling enterUerId method");
            enterUserId(user);
         getElement(mailIdInput).sendEnter();
         return new MailinatorMailPage(driver);
     }

}
