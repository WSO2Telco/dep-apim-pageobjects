package com.wso2telco.apimanager.pageobjects.activitiexplorer;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Activiti Explorer Home Page
 *
 */
public class ActivitiExplorerHomePage extends BasicPageObject{

    /** The logger. */
    Logger logger = Logger.getLogger(ActivitiExplorerHomePage.class);

    /** The txt username. */
    private WebPelement txtActExpUsername = defineEelement(UIType.Xpath, "//*[@id='loginf']/table/tbody/tr[1]/td[2]/input");

    /** The txt password. */
    private WebPelement txtPassword = defineEelement(UIType.Xpath, "//*[@id='loginf']/table/tbody/tr[2]/td[2]/input");

    /** The login button. */
    private WebPelement btnLogin = defineEelement(UIType.Xpath, "//*[@id='loginf']/div/div");

    /** The Manage Icon button. */
    private WebPelement manageIcon = defineEelement(UIType.Xpath, "//*[@src='/activiti-explorer/VAADIN/themes/activiti/img/mm-manage.png']");

    /** The Upload New item. */
    private WebPelement uploadNewItem = defineEelement(UIType.Xpath, "//html/body/div[3]/div/div/span[2]/span");

    /** The choose a file button. */
    private WebPelement chooseFileBtn = defineEelement(UIType.Xpath, "//input[@class='gwt-FileUpload']");

    /** The Deployments Menu name. */
    private String upperMenu = "//*[@class='v-menubar-menuitem-caption']";

    /** The DeplLogin Iframe name. */
    private String loginIframe = "//*[contains(@src, '/activiti-explorer/ui/APP/2/login')]";

    /**
     * Instantiates a new basic page object.
     *
     * @param driver the driver
     */
    public ActivitiExplorerHomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Sets the Activiti Explorer username.
     *
     * @param username for the activiti-explorer login
     * @throws Exception
     */
    public void setActExpUsername(String username) throws Exception{
        logger.debug("Entering username");
        try{
            driver.switchTo().frame(driver.findElement(By.xpath(loginIframe)));
           getElement(txtActExpUsername).clearAndSendkeys(username);
        }catch (Exception ex){
            logger.debug("Exception while Entering username");
            throw ex;
        }

        logger.debug("Entered username");
    }

    /**
     * Sets the Activiti Explorer password.
     *
     * @param password for the activiti-explorer login
     * @throws Exception
     */
    public void setActExpPassword(String password) throws Exception{
        logger.debug("Entering username");
        typeTextBox(txtPassword, password);
        logger.debug("Entered username");
    }

    /**
     * Click login.
     *
     */
    public void clickLogin() throws Exception{
        logger.debug("Click on login button");
        getElement(btnLogin).click();
        Thread.sleep(2000);
        logger.debug("Login button clicked");
    }

    /**
     * Click Manage Icon.
     *
     */
    public void clickManageIcon() throws Exception{
        logger.debug("Click on login button");
        switchtoDefaultContent();
        Thread.sleep(4000);
        getElement(manageIcon).click();

    }

    /**
     * Click on menu Deployments.
     *
     */
    public void clickDeploymentMenu() throws Exception{
        logger.debug("Click on Deployment Menu");
        Thread.sleep(2000);
        List<WebElement> list = driver.findElements(By.xpath(upperMenu));
        for(WebElement p:list){
                if(p.getText().equalsIgnoreCase("Deployments")){
                    p.click();
                }
        }
    }

    /**
     * Click on menu item: Upload new file.
     *
     */
    public void clickMenuItemUploadNew() throws Exception{
        logger.debug("Click on Menu item: Upload New file");
       Thread.sleep(1500);
        getElement(uploadNewItem).click();
        logger.debug("Clicked Deployment Menu");
    }

    /**
     * Set Bar file to upload
     * @Param filePath  absolute path to Bar file
     *
     */
    public void uploadBarFile(String filePath) throws Exception {
        try{
            Thread.sleep(2000);
            logger.debug("set file path to choose button");
            getElement(chooseFileBtn).sendKeys(filePath);
            Thread.sleep(3000);
            logger.debug("Uploaded bar file");
        }catch (Exception ex){
            logger.debug("Exception while uploadBarFile");
            throw ex;
        }

    }


}
