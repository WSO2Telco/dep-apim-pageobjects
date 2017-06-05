package com.wso2telco.apimanager.pageobjects.mailinator;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.element.table.Table;
import com.wso2telco.test.framework.util.UIType;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by mahesh on 5/25/17.
 */
public class MailinatorMailPage extends BasicPageObject{

    Logger logger = Logger.getLogger(MailinatorMailPage.class);

    private WebPelement mailBodyTitle = defineEelement(UIType.Xpath,"//h2");
    private WebPelement iframeMail = defineEelement(UIType.Xpath,"//iframe[@id='publicshowmaildivcontent']");
    private WebPelement firstMail = defineEelement(UIType.Xpath,"//*[@class='someviewport']/div[1]");

    private String mailTitle= null;
    private String applicationUser = null;
    private String applicationName = null;
    private String applicationTier = null;
    private String applicationDescription = null;




    public MailinatorMailPage(WebDriver driver) {
        super(driver);
    }

    private String getValueForColumnValue(String colVal){
        String val = null;
        logger.debug("Accesing Table");
        Table table = getTable(UIType.Xpath,".//table");
        List<WebElement> rows = table.body().getAllRows();

        for (WebElement p : rows){
        if(p.findElement(By.xpath("./td")).getText().trim().equals(colVal+" :")){
            val=p.findElement(By.xpath("./td[2]")).getText();
            logger.debug("Table column value for "+ colVal+" is "+val);
        };

        }
        return val;
    }




   public void clickFirstMail(){
       getElement(firstMail).click();
   }



    public String getMailTitle() {
        switchtoFrame("publicshowmaildivcontent");
        this.mailTitle=getElement(mailBodyTitle).getText();
        return mailTitle;
    }

    public String getApplicationUser() {
        switchtoFrame("publicshowmaildivcontent");
        this.applicationUser=getValueForColumnValue("Application User");
        return applicationUser;
    }

    public String getApplicationName() {
        switchtoFrame("publicshowmaildivcontent");
        this.applicationName=getValueForColumnValue("Application Name");
        return applicationName;
    }

    public String getApplicationTier() {
        switchtoFrame("publicshowmaildivcontent");
        this.applicationTier=getValueForColumnValue("Application Tier");
        return applicationTier;
    }

    public String getApplicationDescription() {
        switchtoFrame("publicshowmaildivcontent");
        this.applicationDescription=getValueForColumnValue("Application Description");
        return applicationDescription;
    }
}
