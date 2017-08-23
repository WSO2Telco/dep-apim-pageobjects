package com.wso2telco.apimanager.pageobjects.apihome.manager;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.wso2telco.apimanager.pageobjects.BasicPageObject;
import com.wso2telco.apimanager.pageobjects.db.queries.SQLQuery;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.db.connection.executers.SQLExecuter;
import com.wso2telco.test.framework.db.connection.sql.QueryResult;
import com.wso2telco.test.framework.element.table.Table;
import com.wso2telco.test.framework.util.UIType;
import com.wso2telco.test.framework.tools.excelfile.CSVFileReader;
import com.wso2telco.test.framework.tools.excelfile.ExcelFileReader;
import com.wso2telco.test.framework.tools.excelfile.ExcelFileWriter;

/**
 * The Class ManagerPage.
 */
public class ManagerPage extends BasicPageObject {

	/** The logger. */
	Logger logger = Logger.getLogger(ManagerPage.class);

	/** The lbl manager. */
	private WebPelement lblManager = defineEelement(UIType.Xpath, "//h2[@class='login-title']");

	/** The txt user name. */
	private WebPelement txtUserName = defineEelement(UIType.ID, "username");

	/** The txt password. */
	private WebPelement txtPassword = defineEelement(UIType.ID, "pass");

	/** The btn log in. */
	private WebPelement btnLogIn = defineEelement(UIType.ID, "loginButton");

	/** The lbl home. */
	private WebPelement lblHome = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");

	/** The btn user name. */
	private WebPelement btnUserName = defineEelement(UIType.ID, "userMenu");

	/** The btn logout. */
	private WebPelement btnLogout = defineEelement(UIType.Xpath, "//li[@class='logout-link-special']/button");

	/** The lnk workflow. */
	private WebPelement lnkWorkflow = defineEelement(UIType.Xpath, "//div[@class='navbar-inner main-menu-navbar']/ul/li/a[text()[contains(.,'Workflow')]]");

	/** The lnk application creation. */
	private WebPelement lnkApplicationCreation = defineEelement(UIType.Xpath, "//li/a[text()[contains(.,'Application Creation')]]");

	/** The lnk app craeation. */
	private String lnkAppCraeation = "//li/a[text()[contains(.,'Application Creation')]]";

	/** The lbl approve reject. */
	private WebPelement lblApproveReject = defineEelement(UIType.Xpath, "//div[@class='modal-header']/h3");

	/** The txt approve reject. */
	private WebPelement txtApproveReject = defineEelement(UIType.Xpath, "//div/form/input[@type='text']");

	/** The btn approve ok. */
	private WebPelement btnApproveOk = defineEelement(UIType.Xpath, "//div/a[text()[contains(.,'OK')]]");

	/** The btn sub creation. */
	private WebPelement btnSubCreation = defineEelement(UIType.Xpath, "//a[contains(.,'Subscriptions Creation')]");

	/** The title app tasks. */
	private WebPelement titleAppTasks = defineEelement(UIType.Xpath, "//div[@class='title-section']/h2");

	/** The tab path. */
	private String tabPath = "//div[@class='navbar-inner main-menu-navbar']/ul/li";
	
	
	/** The monthly invoice sb. */
	private String monthlyInvoiceSBpath = "//div[@class='sidebar-nav left-menu-back01']/ul/li";

	/** The lnk black list. */
	private WebPelement lnkBlackList = defineEelement(UIType.Xpath, "//div[@class='navbar-inner main-menu-navbar']/ul/li/a[text()[contains(.,'Blacklist')]]");

	/** The lbl api black list. */
	private WebPelement lblAPIBlackList = defineEelement(UIType.Xpath, "//div[@class='title-section']");

	/** The dd select api. */
	private WebPelement ddSelectAPI = defineEelement(UIType.Xpath, "//div[@class='well form-inline']/table/tbody/tr[2]/td/select");

	/** The lbl ussd. */
	private WebPelement lblUSSD = defineEelement(UIType.Xpath, "//select[@id='apiSelect']/option[contains(.,'USSD')]");

	/** The ddl api. */
	private WebPelement ddlAPIList = defineEelement(UIType.ID, "apiSelect");

	/** The btn add new. */
	private WebPelement btnAddNew = defineEelement(UIType.ID, "add-new");

	/** The lbl admin mod error. */
	private WebPelement lblAdminModError = defineEelement(UIType.Xpath, "//div[@id='messageModal']/div[1]/h3");

	/** The lnk white list. */
	private WebPelement lnkWhiteList = defineEelement(UIType.Xpath, "//div[@class='navbar-inner main-menu-navbar']/ul/li/a[text()[contains(.,'Whitelist')]]");

	/** The lbl ap iwise white list. */
	private WebPelement lblAPIwiseWhiteList = defineEelement(UIType.Xpath, "//div[@id='middle']/div[1]/h2");

	/** The dd subscriber. */
	private WebPelement ddSubscriber = defineEelement(UIType.ID, "subsSelect");

	/** The dd application. */
	private WebPelement ddApplication = defineEelement(UIType.ID, "appSelect");

	/** The dd api. */
	private WebPelement ddAPI = defineEelement(UIType.ID, "apiSelect");

	/** The btn view. */
	private WebPelement btnView = defineEelement(UIType.ID, "view");

	/** The btn manual. */
	private WebPelement btnManual = defineEelement(UIType.ID, "isManual");

	/** The btn upload number. */
	private WebPelement btnUploadNumber = defineEelement(UIType.ID,
			"add-manual");

	/** The btn number range. */
	private WebPelement btnNumberRange = defineEelement(UIType.ID, "isRange");

	/** The txt min number. */
	private WebPelement txtMinNumber = defineEelement(UIType.ID, "minnumber");

	/** The txt max number. */
	private WebPelement txtMaxNumber = defineEelement(UIType.ID, "maxnumber");

	/** The btn number list. */
	private WebPelement btnNumberList = defineEelement(UIType.ID, "add-range");

	/** The btn upload number list. */
	private WebPelement btnUploadNumberList = defineEelement(UIType.ID,
			"isList");

	/** The btn add number list. */
	private WebPelement btnAddNumberList = defineEelement(UIType.ID, "add-new");

	/**
	 * The lbl application name. %s_1 = appName
	 **/
	private String lblApplicationName = "//tr/td/div/label[text()[contains(.,'%s')]]";
	
	/**
	 * The lbl subscription name.
	 **/                              
	private String lblSubscription = "//tr/td/div/label[text()[contains(.,'%s')]]/../following-sibling::div/label[text()[contains(.,'%s')]]";


	/**
	 * The lnk application details. %s_1 = appname
	 **/
	private String lnkApplicationDetails = "//tr/td/div/label[text()[contains(.,'%s')]]/../../label/b[text()[contains(.,'Application Details')]]";

	/** The ddl tier. */
	//private WebPelement ddlTier = defineEelement(UIType.Xpath, "//td[@id='desc0']/div[4]/div[1]/select/option[@value='Unlimited']");

	/** The ddl tier l. */
	private String ddlTierL = "//label[contains(.,'%s')]/../..//select";

	/** The ddl subscription tier  */
	private String ddlSubscriptionTierL = "//label[contains(.,'%s')]/../following-sibling::div/label[text()[contains(.,'%s')]]/../..//select";
	
	/**
	 * The btn assign me. %s_1 = appName
	 **/
	private String btnAssignMe = "//tr/td/div/label[text()[contains(.,'%s')]]/../../../td[5]/button[text()[contains(.,'Assign To Me')]]";
	
	/** The btn Subscription Assign to Me*/
	private String btnSubscrtionAssignMe = "//tr/td/div/label[text()[contains(.,'%s')]]/../following-sibling::div/label[text()[contains(.,'%s')]]/../../../td[5]/button[text()[contains(.,'Assign To Me')]]";

	/**
	 * The btn start. %s_1 = appname
	 **/
	private String btnStart = "//tr/td/div/label[text()[contains(.,'%s')]]/../../../td[5]/button[text()[contains(.,'Start')]]";
	
	/** btn Start Subscription Approval*/
	private String btnSubscriptionStart = "//tr/td/div/label[text()[contains(.,'%s')]]/../following-sibling::div/label[text()[contains(.,'%s')]]/../../../td[5]/button[text()[contains(.,'Start')]]";

	/**
	 * The ddl condition list. %s_1 = appName
	 **/
	private String ddlConditionList = "//tr/td/div/label[text()[contains(.,'%s')]]/../../../td[5]/select[@class='js_stateDropDown pull-left']";
	
	/** The ddl subscription condition list*/
	private String ddlSubscriptionConditionList = "//tr/td/div/label[text()[contains(.,'%s')]]/../following-sibling::div/label[text()[contains(.,'%s')]]/../../../td[5]/select[@class='js_stateDropDown pull-left']";

	/** The ddl condition list options*/
	
	private String ddlConditionListOptions = "//tr/td/div/label[text()[contains(.,'%s')]]/../../../td[5]/select[@class='js_stateDropDown pull-left']/option[%s]";
	
	/** The ddl Subscription condition list options */
	private String ddlSubscriptionConditionListOptions = "//tr/td/div/label[text()[contains(.,'%s')]]/../following-sibling::div/label[text()[contains(.,'%s')]]/../../../td[5]/select[@class='js_stateDropDown pull-left']/option[%s]";
	/**
	 * The btn complete. %s_1 = appName
	 **/
	private String btnComplete = "//tr/td/div/label[text()[contains(.,'%s')]]/../../../td[5]/button[text()[contains(.,'Complete')]]";
	
	/** The btn subscription approval complete */
	private String btnSubscriptionComplete = "//tr/td/div/label[text()[contains(.,'%s')]]/../following-sibling::div/label[text()[contains(.,'%s')]]/../../../td[5]/button[text()[contains(.,'Complete')]]";
			
	/**
	 * The lbl number. %s_1 = number
	 **/
	private String lblNumber = "//td[text()='%s']";

	/**
	 * The lbl white list numbers. %s_1 = number
	 **/
	private String lblWhiteListNumbers = "//td[text()='%s']";

	/**
	 * The btn remove number. %s_1 = number
	 **/
	private String btnRemoveNumber = "//td[text()='%s']/following-sibling::td[1]/div/a";

	/** The lnk billing and metering. */
	private WebPelement lnkBillingAndMetering = defineEelement(UIType.Xpath, "//div[@class='navbar-inner main-menu-navbar']/ul/li/a[text()[contains(.,'Billing & Metering')]]");

	/** The lbl total api traffic. */
	private WebPelement lblTotalAPITraffic = defineEelement(UIType.Xpath, "//div[@id='middle']/div[1]/h2");

	/** The txt total api traffic from date. */
	private WebPelement txtTotalAPITrafficFromDate = defineEelement(UIType.ID, "from_date");

	/** The txt total api traffic to date. */
	private WebPelement txtTotalAPITrafficToDate = defineEelement(UIType.ID, "to_date");

	/** The dd total api traffic operator. */
	private WebPelement ddTotalAPITrafficOperator = defineEelement(UIType.ID, "operator");

	/** The dd total api traffic service provider. */
	private WebPelement ddTotalAPITrafficServiceProvider = defineEelement(UIType.ID, "subscriber");

	/** The dd total api traffic application. */
	private WebPelement ddTotalAPITrafficApplication = defineEelement(UIType.ID, "app");

	/** The dd total api traffic api. */
	private WebPelement ddTotalAPITrafficAPI = defineEelement(UIType.ID, "api");

	/** The btn generate. */
	private WebPelement btnGenerate = defineEelement(UIType.ID, "generate");

	/** The lnk transaction log. */
	private WebPelement lnkTransactionLog = defineEelement(UIType.Xpath, "//ul[@class='nav nav-list']/li[3]/a");
	
	/** The lnk transaction logNB. */
	private WebPelement lnkTransactionLogNB = defineEelement(UIType.Xpath, "//div[@id='left']/div/ul/li[4]/a");

	/** The lbl transaction log. */
	private WebPelement lblTransactionLog = defineEelement(UIType.Xpath, "//div[@id='middle']/div[1]/h2");

	/** The txt transaction log from date. */
	private WebPelement txtTransactionLogFromDate = defineEelement(UIType.ID, "from_date");

	/** The txt transaction log to date. */
	private WebPelement txtTransactionLogToDate = defineEelement(UIType.ID, "to_date");

	/** The dd transaction log operator. */
	private WebPelement ddTransactionLogOperator = defineEelement(UIType.ID, "operator");

	/** The dd transaction log service provider. */
	private WebPelement ddTransactionLogServiceProvider = defineEelement(UIType.ID, "subscriber");

	/** The dd transaction log api. */
	private WebPelement ddTransactionLogOperationType = defineEelement(UIType.ID, "api");

	/** The dd transaction log status. */
	private WebPelement ddTransactionLogRecordsType = defineEelement(UIType.ID, "ResType");
	
	/** The btn download report. */
	private WebPelement btnDownloadReport = defineEelement(UIType.Name, "download_file");

	/** The lnk operator api traffic. */
	private WebPelement lnkOperatorAPITraffic = defineEelement(UIType.Xpath, "//ul[@class='nav nav-list']/li[5]/a");

	/** The lbl operator api traffic. */
	private WebPelement lblOperatorAPITraffic = defineEelement(UIType.Xpath, "//div[@id='middle']/div[1]/h2");

	/** The txt operator api traffic from date. */
	private WebPelement txtOperatorAPITrafficFromDate = defineEelement(UIType.ID, "from_date");

	/** The txt operator api traffic to date. */
	private WebPelement txtOperatorAPITrafficToDate = defineEelement(UIType.ID, "to_date");

	/** The dd operator api traffic service provider. */
	private WebPelement ddOperatorAPITrafficServiceProvider = defineEelement(UIType.ID, "subscriber");

	/** The dd operator api traffic api. */
	private WebPelement ddOperatorAPITrafficAPI = defineEelement(UIType.ID, "api");

	/** The dd operator api traffic application. */
	private WebPelement ddOperatorAPITrafficApplication = defineEelement(UIType.ID, "app");

	/** The lnk monthly invoice. */
	private WebPelement lnkMonthlyInvoice = defineEelement(UIType.Xpath, "//ul[@class='nav nav-list']/li[5]/a");

	/** The lbl monthly invoice. */
	private WebPelement lblMonthlyInvoice = defineEelement(UIType.Xpath, "//div[@id='middle']/div[1]/h2");

	/** The dd monthly invoice year. */
	private WebPelement ddMonthlyInvoiceYear = defineEelement(UIType.ID, "year");

	/** The dd monthly invoice month. */
	private WebPelement ddMonthlyInvoiceMonth = defineEelement(UIType.ID, "month");

	/** The dd monthly invoice service provider. */
	private WebPelement ddMonthlyInvoiceServiceProvider = defineEelement(UIType.ID, "subscriber");

	/** The lnk revenue breakdown. */
	private WebPelement lnkRevenueBreakdown = defineEelement(UIType.Xpath, "//ul[@class='nav nav-list']/li[6]/a");
	
	/** The lnk revenue breakdown nb. */
	private WebPelement lnkRevenueBreakdownNB = defineEelement(UIType.Xpath, "//ul[@class='nav nav-list']/li[7]/a");

	/** The lbl revenue breakdown. */
	private WebPelement lblRevenueBreakdown = defineEelement(UIType.Xpath, "//div[@id='middle']/div[1]/h2");

	/** The dd revenue breakdown year. */
	private WebPelement ddRevenueBreakdownYear = defineEelement(UIType.ID, "yearSelect");

	/** The dd revenue breakdown month. */
	private WebPelement ddRevenueBreakdownMonth = defineEelement(UIType.ID, "monthSelect");

	/** The dd revenue breakdown operator. */
	private WebPelement ddRevenueBreakdownOperator = defineEelement(UIType.ID, "operatorSelect");

	/** The dd revenue breakdown service provider. */
	private WebPelement ddRevenueBreakdownServiceProvider = defineEelement(UIType.ID, "subscriberSelect");

	/** The dd revenue breakdown application. */
	private WebPelement ddRevenueBreakdownApplication = defineEelement(UIType.ID, "appSelect");

	/** The lnk customer care. */
	private WebPelement lnkCustomerCare = defineEelement(UIType.Xpath, "//ul[@class='nav nav-list']/li[10]/a");

	/** The lbl customer care. */
	private WebPelement lblCustomerCare = defineEelement(UIType.Xpath, "//div[@id='middle']/div[1]/h2");

	/** The txt customer care from date. */
	private WebPelement txtCustomerCareFromDate = defineEelement(UIType.ID, "from_date");

	/** The txt customer care to date. */
	private WebPelement txtCustomerCareToDate = defineEelement(UIType.ID, "to_date");

	/** The txt customer care msisdn. */
	private WebPelement txtCustomerCareMSISDN = defineEelement(UIType.ID, "msisdnText");

	/** The dd customer care operator. */
	private WebPelement ddCustomerCareOperator = defineEelement(UIType.ID, "operatorSelect");

	/** The dd customer care service provider. */
	private WebPelement ddCustomerCareServiceProvider = defineEelement(UIType.ID, "subscriberSelect");

	/** The dd customer care application. */
	private WebPelement ddCustomerCareApplication = defineEelement(UIType.ID, "appSelect");

	/** The lnk api response time. */
	private WebPelement lnkAPIResponseTime = defineEelement(UIType.Xpath, "//div[@id='left']/div/ul/li[12]/a");
	//private WebPelement lnkAPIResponseTime = defineEelement(UIType.Xpath, "//ul[@class='nav nav-list']/li[9]/a");

	/** The lbl api response time. */
	private WebPelement lblAPIResponseTime = defineEelement(UIType.Xpath, "//div[@id='middle']/div[1]/h2");

	/** The txt api response time from date. */
	private WebPelement txtAPIResponseTimeFromDate = defineEelement(UIType.ID, "from_date");

	/** The txt api response time to date. */
	private WebPelement txtAPIResponseTimeToDate = defineEelement(UIType.ID, "to_date");

	/** The dd api response time operator. */
	private WebPelement ddAPIResponseTimeOperator = defineEelement(UIType.ID, "operatorSelect");

	/** The dd api response time service provider. */
	private WebPelement ddAPIResponseTimeServiceProvider = defineEelement(UIType.ID, "subscriberSelect");

	/** The dd api response time application. */
	private WebPelement ddAPIResponseTimeApplication = defineEelement(UIType.ID, "appSelect");

	/** The btn api response time generate. */
	private WebPelement btnAPIResponseTimeGenerate = defineEelement(UIType.Name, "download_file");

	/** The lnk performance error rates. */
	private WebPelement lnkPerformanceErrorRates = defineEelement(UIType.Xpath, "//div[@id='left']/div/ul/li[13]/a");
	//private WebPelement lnkPerformanceErrorRates = defineEelement(UIType.Xpath, "//ul[@class='nav nav-list']/li[10]/a");

	/** The lbl performance error rates. */
	private WebPelement lblPerformanceErrorRates = defineEelement(UIType.Xpath, "//div[@id='middle']/div[1]/h2");

	/** The txt performance error rates from date. */
	private WebPelement txtPerformanceErrorRatesFromDate = defineEelement(UIType.ID, "from_date");

	/** The txt performance error rates to date. */
	private WebPelement txtPerformanceErrorRatesToDate = defineEelement(UIType.ID, "to_date");

	/** The dd performance error rates operator. */
	private WebPelement ddPerformanceErrorRatesOperator = defineEelement(UIType.ID, "operator");

	/** The dd performance error rates service provider. */
	private WebPelement ddPerformanceErrorRatesServiceProvider = defineEelement(UIType.ID, "subscriber");

	/** The dd performance error rates application. */
	private WebPelement ddPerformanceErrorRatesApplication = defineEelement(UIType.ID, "app");

	/** The dd performance error rates api. */
	private WebPelement ddPerformanceErrorRatesAPI = defineEelement(UIType.ID, "api");

	/** The btn monthly invoice download report. */
	private WebPelement btnMonthlyInvoiceDownloadReport = defineEelement(UIType.Xpath, "//div[@id='userKey']/button");

	/** The lbl white list added popup. */
	private WebPelement lblWhiteListAddedPopup = defineEelement(UIType.Xpath, "//span[@class='messageText']");

	/** The btn white list added popup ok. */
	private WebPelement btnWhiteListAddedPopupOK = defineEelement(UIType.Xpath, "//a[contains(text(),'OK')]");

	/** The lbl white list error popup. */
	private WebPelement lblWhiteListErrorPopup = defineEelement(UIType.Xpath, "//span[@class='messageText']");

	/** The pie chart. */
	String pieChartTotalAPITraffic = "//div[@id='total-api-traffic-pie-chart']/div/div";
	
	/** The pie chart rvenue breakdown sb. */
	String pieChartRvenueBreakdownSB = "//div[@id='apiUsageGraph']/div/div";

	/** The pie chart performance error rates. */
	String pieChartPerformanceErrorRates = "//div[@id='error-response-codes-pie-chart']/div/div";

	/** The pie chart operator api traffic. */
	String pieChartOperatorAPITraffic = "//div[@id='operator-wise-api-traffic-pie-chart']/div/div";

	/** The tbl customer care. */
	String tblCustomerCare = "//div[@id='customer_care_tbl_div']/table";

	/** The report pagination. */
	String reportPagination = "//div[@id='pagination-demo']/ul/li";
	
	/** The lbl reports. */
	private String lblReports = "//div[@id='left']/div/ul/li";
	
	/** The lnk sp blacklist. */
	private WebPelement lnkSPBlacklist = defineEelement(UIType.Xpath, "//a[contains(.,'SP Blacklist')]");
	
	/** The dd sp blacklist select. */
	private WebPelement ddSPBlacklistSelect = defineEelement(UIType.ID,"spSelect");
	
	/** The btn black list. */
	private WebPelement btnBlackList = defineEelement(UIType.Xpath,"//button[contains(.,'Blacklist')]");
	
	/** The lbl sp black list. */
	private WebPelement lblSPBlackList = defineEelement(UIType.Xpath,"//div[@class='title-section']/h2");
	
	/** The lbl admin module. */
	private WebPelement lblAdminModule = defineEelement(UIType.Xpath,"//div[@id='messageModal']/div/h3");
	
	/** The btn admin module yes. */
	private WebPelement btnAdminModuleYes = defineEelement(UIType.Xpath,"//a[contains(.,'Yes')]");
	
	/** The lnk monthly invoice nb. */
	private WebPelement lnkMonthlyInvoiceNB = defineEelement(UIType.Xpath, "//ul[@class='nav nav-list']/li/a[text()[contains(.,'Monthly Invoice NB')]]");
	
	/** The lnk monthly invoice sb. */
	private WebPelement lnkMonthlyInvoiceSB = defineEelement(UIType.Xpath, "//ul[@class='nav nav-list']/li/a[text()[contains(.,'Monthly Invoice SB')]]");
	
	/** The nb monthly invoice table. */
	private String nbMonthlyInvoiceTable = "//*[@id='reportTable']";
	
	/** The sb monthly invoice table. */
	private String sbMonthlyInvoiceTable = "//div[@id='usageDiv']/div/table";

	/** The lbl required msg. */
	private WebPelement lblRequiredMsg = defineEelement(UIType.Xpath, "//div[@class='bootbox modal fade in']/div[@class='modal-body']");
	
	/** The btn reqired msg ok. */
	private WebPelement btnReqiredMsgOk = defineEelement(UIType.Xpath, "//div[@class='bootbox modal fade in']/div[@class='modal-footer']/a");

	/** The lbl application approval task status*/
	private String lblApprovalTaskStatus = "//tr/td/div/label[text()[contains(.,'%s')]]/../../following-sibling::td[contains(@id,'status')]";
	
	/** The lnk Subscription Details*/
	private String lnkSubscriptionDetails = "//label[contains(.,'%s')]/../following-sibling::div/label[text()[contains(.,'%s')]]/../following-sibling::label/label/b[text()='Subscription Details']";
	
	/** The label Subscription Apprval Task Status*/
	private String lblSubscriptionApprovalTaskStatus = "//tr/td/div/label[text()[contains(.,'%s')]]/../following-sibling::div/label[text()[contains(.,'%s')]]/../../following-sibling::td[contains(@id,'status')]";
	
	/**
	 * Instantiates a new manager page.
	 *
	 * @author JayaniP
	 * @param driver the driver
	 */
	public ManagerPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Checks if is manager page.
	 *
	 * @author JayaniP
	 * @param managerHeader the manager header
	 * @return true, if is manager page
	 * @throws Exception the exception
	 */
	public boolean isManagerPage(String managerHeader) throws Exception {
		flag = false;
		logger.debug("Validating Manager page hedaer");
		Thread.sleep(sleepTime);
		try {
			if (getElement(lblManager).getText().equalsIgnoreCase(managerHeader)) {
				flag = true;
				logger.debug("Manager page hedaer matched");
			} else {
				logger.debug("Manager page hedaer mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Manager page header 'isManagerPage()'" + e.getMessage());
			throw new Exception("Exception While Validating Manager page header 'isManagerPage()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Enter user name.
	 *
	 * @author JayaniP
	 * @param username the username
	 */
	public void enterUserName(String username) {
		logger.debug("Entering username");
		getElement(txtUserName).clearAndSendkeys(username);
		logger.debug("Entered username");
	}

	/**
	 * Enter password.
	 *
	 * @author JayaniP
	 * @param password the password
	 */
	public void enterPassword(String password) {
		logger.debug("Entering password");
		getElement(txtPassword).clearAndSendkeys(password);
		logger.debug("Entered password");
	}

	/**
	 * Click login.
	 *
	 * @author SulakkhanaW
	 * @throws InterruptedException the interrupted exception
	 */
	public void clickLogin() throws InterruptedException {
		logger.debug("Clicking on login");
		getElement(btnLogIn).click();
		logger.debug("Clicked on login");
		Thread.sleep(sleepTime);
	}

	/**
	 * Checks if is home page.
	 *
	 * @author SulakkhanaW
	 * @param homeHeader the home header
	 * @return true, if is home page
	 * @throws Exception the exception
	 */
	public boolean isHomePage(String homeHeader) throws Exception {
		flag = false;
		logger.debug("Validating Home page hedaer");
		try {
			if (getElement(lblHome).getText().equalsIgnoreCase(homeHeader)) {
				flag = true;
				logger.debug("Home page hedaer matched");
			} else {
				logger.debug("Home page hedaer mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Home page header 'isHomePage()'" + e.getMessage());
			throw new Exception("Exception While Validating Home page header 'isHomePage()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Click user name.
	 *
	 * @author JayaniP
	 */
	public void clickUserName() {
		logger.debug("Clicking on username");
		getElement(btnUserName).click();
		logger.debug("Clicked on username");
	}

	/**
	 * Click logout.
	 *
	 * @author JayaniP
	 */
	public void clickLogout() {
		logger.debug("Clicking on logout");
		getElement(btnLogout).click();
		logger.debug("Clickedon logout");
	}

	/**
	 * Checks if is manager two tabs access.
	 *
	 * @author JayaniP
	 * @return true, if is manager two tabs access
	 * @throws Exception the exception
	 */
	public boolean isManagerTwoTabsAccess() throws Exception {
		flag = false;
		logger.debug("Validating Manager page tabs for normal users");
		int tabCount = verifyListContent(UIType.Xpath, tabPath).size();
		try {
			if (tabCount <= 3) {
				flag = true;
				logger.debug("User has access for 2 tabs");
			} else {
				logger.debug("User has access for more than 2 tabs");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Manager page tabs 'isManagerTwoTabsAccess()'" + e.getMessage());
			throw new Exception("Exception While Validating Manager page tabs 'isManagerTwoTabsAccess()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Checks if is all tabs accessible.
	 *
	 * @author JayaniP
	 * @return true, if is all tabs accessible
	 * @throws Exception the exception
	 */
	public boolean isAllTabsAccessible() throws Exception {
		flag = false;
		Thread.sleep(sleepTime);
		logger.debug("Validating Manager page tabs for admin users");
		int tabCount = verifyListContent(UIType.Xpath, tabPath).size();
		try {
			if (tabCount <= 6) {
				flag = true;
				logger.debug("User has access for all the tabs");
			} else {
				logger.debug("User has access for less than 5 tabs");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Manager page tabs 'isAllTabsAccessible()'" + e.getMessage());
			throw new Exception("Exception While Validating Manager page tabs 'isAllTabsAccessible()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Checks if is three tabs.
	 *
	 * @author JayaniP
	 * @return true, if is three tabs
	 * @throws Exception the exception
	 */
	public boolean isThreeTabs() throws Exception {
		flag = false;
		logger.debug("Validating Manager page tabs for operator users");
		int tabCount = verifyListContent(UIType.Xpath, tabPath).size();
		try {
			if (tabCount <= 4) {
				flag = true;
				logger.debug("Operator user has access for three tabs");
			} else {
				logger.debug("Operator user has access for less/more than three tabs");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Manager page tabs 'isThreeTabs()'" + e.getMessage());
			throw new Exception("Exception While Validating Manager page tabs 'isThreeTabs()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Click workflow.
	 *
	 * @author JayaniP
	 * @throws InterruptedException the interrupted exception
	 */
	public void clickWorkflow() throws InterruptedException {
		Thread.sleep(sleepTime);
		logger.debug("Clicking on workflow");
		getElement(lnkWorkflow).click();
		Thread.sleep(sleepTime);
		logger.debug("Clicked on workflow");
	}

	/**
	 * Checks if is application creation.
	 *
	 * @author JayaniP
	 * @return true, if is application creation
	 * @throws Exception the exception
	 */
	public boolean isApplicationCreation() throws Exception {
		flag = false;
		logger.debug("Validating Application creation link");
		int tabCount = verifyListContent(UIType.Xpath, lnkAppCraeation).size();
		try {
			if (tabCount <= 1) {
				flag = true;
				logger.debug("Application creation link is visible");
			} else {
				logger.debug("Application creation link is not visible");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Application creation link 'isApllicationCreation()'" + e.getMessage());
			throw new Exception("Exception While Validating Application creation link 'isApllicationCreation()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Click application creation.
	 *
	 * @author JayaniP
	 */
	public void clickApplicationCreation() {
		logger.debug("Clicking on Application creation");
		getElement(lnkApplicationCreation).click();
		logger.debug("Clicked on Application creation");
	}

	/**
	 * Checks if is application name visible.
	 *
	 * @author JayaniP
	 * @param appName the app name
	 * @return true, if is application name visible
	 * @throws Exception the exception
	 */
	public boolean isApplicationNameVisible(String appName) throws Exception {
		flag = false;
		logger.debug("Validating Application name");
		Thread.sleep(sleepTime);
		String xpath = String.format(lblApplicationName, appName);
		int Names = driver.findElements(By.xpath(xpath)).size();
		try {
			if (Names == 1) {
				flag = true;
				logger.debug("Application name is visible");
			} else {
				logger.debug("Application creation name is not visible");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Application name 'isApplicationNameVisible()'" + e.getMessage());
			throw new Exception("Exception While Validating Application name 'isApplicationNameVisible()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Click application details.
	 *
	 * @author JayaniP
	 * @param appname the appname
	 */
	public void clickApplicationDetails(String appname) {
		String xpath = String.format(lnkApplicationDetails, appname);
		WebPelement lnkAppName = defineEelement(UIType.Xpath, xpath);
		logger.debug("Clicking on Application details");
		getElement(lnkAppName).click();
		logger.debug("Clicked on Application details");
	}

	/**
	 * Select tier.
	 *
	 * @author JayaniP
	 * @param tier the tier
	 * @param appname the appname
	 */
	public void selectTier(String tier, String appname) {
		String xpath = String.format(ddlTierL, appname);
		WebPelement ddlTierList = defineEelement(UIType.Xpath, xpath);
		getElement(ddlTierList).click();
		logger.debug("Selecting tier");
		getElement(ddlTierList).sendKeys(tier);
		logger.debug("Tier selected");
		getElement(ddlTierList).sendEnter();		
	}


	/**
	 * Click assign me.
	 *
	 * @author JayaniP
	 * @param appName the app name
	 */
	public void clickAssignMe(String appName) {
		String xpath = String.format(btnAssignMe, appName);
		WebPelement btnAssignMe = defineEelement(UIType.Xpath, xpath);
		logger.debug("Clicking on Assign me");
		getElement(btnAssignMe).click();
		logger.debug("Clicked on Assign me");
	}

	/**
	 * Click start.
	 *
	 * @author JayaniP
	 * @param appName the app name
	 */
	public void clickStart(String appName) {
		String xpath = String.format(btnStart, appName);
		WebPelement btnStart = defineEelement(UIType.Xpath, xpath);
		logger.debug("Clicking on start button");
		getElement(btnStart).click();
		logger.debug("Clicked on start button");
	}

	/**
	 * Select condition.
	 *
	 * @author JayaniP
	 * @param condition the condition
	 * @param appName the app name
	 */
	public void selectCondition(String condition, String appName) {
		String xpath = String.format(ddlConditionList, appName);
		WebPelement ddlCondition = defineEelement(UIType.Xpath, xpath);
		logger.debug("Selecting condition");
		getElement(ddlCondition).sendKeys(condition);
		getElement(ddlCondition).sendEnter();
		logger.debug("Condition selected");
	}

	/**
	 * Click complete.
	 *
	 * @author JayaniP
	 * @param appName the app name
	 */
	public void clickComplete(String appName) {
		String xpath = String.format(btnComplete, appName);
		WebPelement btnComplete = defineEelement(UIType.Xpath, xpath);
		logger.debug("Clicking on complete");
		getElement(btnComplete).click();
		logger.debug("Clicked on complete");
	}

	/**
	 * Enter approve reject reason.
	 *
	 * @author JayaniP
	 * @param reason the reason
	 */
	public void enterApproveRejectReason(String reason) {
		logger.debug("Entering approve reject reason");
		getElement(txtApproveReject).clearAndSendkeys(reason);
		logger.debug("Entered approve reject reason");
	}

	/**
	 * Click approve ok.
	 *
	 * @author JayaniP
	 */
	public void clickApproveOK() {
		logger.debug("Clicking on Approve ok button");
		getElement(btnApproveOk).click();
		logger.debug("Clicked on Approve ok button");
	}

	/**
	 * Checks if is application name not visible.
	 *
	 * @author JayaniP
	 * @param appName the app name
	 * @return true, if is application name not visible
	 * @throws Exception the exception
	 */
	public boolean isApplicationNameNotVisible(String appName) throws Exception {
		flag = false;
		logger.debug("Validating Application name not visible");
		String xpath = String.format(lblApplicationName, appName);
		int Names = driver.findElements(By.xpath(xpath)).size();
		try {
			if (Names < 1) {
				flag = true;
				logger.debug("Application name not visible");
			} else {
				logger.debug("Application name visible");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Application name 'isApplicationNameNotVisible()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Application name 'isApplicationNameNotVisible()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Click subscription creation.
	 *
	 * @author JayaniP
	 */
	public void clickSubCreation() {
		logger.debug("Clicking on Subscription creation");
		getElement(btnSubCreation).click();
		logger.debug("Clicked on Subscription creation");
	}

	/**
	 * Checks if is approval task displayed.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is approval task displayed
	 * @throws Exception the exception
	 */
	public boolean isApprovalTaskDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating Approval Task Title");
		Thread.sleep(sleepTime);
		try {
			if (title.contains(getElement(titleAppTasks).getText())) {
				flag = true;
				logger.debug("Validating Approval Task Title completed");
			} else {
				logger.debug("Approval Task Title is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Approval Task Title Page Title 'isApprovalTaskDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating Approval Task Title Page Title 'isApprovalTaskDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Checks if is approve reject popup displayed.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is approve reject popup displayed
	 * @throws Exception the exception
	 */
	public boolean isApproveRejectPopupDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating Approve/Reject popup");
		Thread.sleep(sleepTime);
		try {
			if (title.contains(getElement(lblApproveReject).getText())) {
				flag = true;
				logger.debug("Validating Approve/Reject popup completed");
			} else {
				logger.debug("Approve/Reject popup title is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Approve/Reject popup Page Title 'isApproveRejectPopupDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating Approve/Reject popup Page Title 'isApproveRejectPopupDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Click black list.
	 *
	 * @author JayaniP
	 */
	public void clickBlackList() {
		logger.debug("Click on Black List Tab");
		getElement(lnkBlackList).click();
		logger.debug("Error while clicking on BlackList tab");
	}

	/**
	 * Checks if is API blacklist page displayed.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is API blacklist page displayed
	 * @throws Exception the exception
	 */
	public boolean isAPIBlacklistPageDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating title APIwise Blacklist");
		Thread.sleep(sleepTime);
		try {
			if (title.contains(getElement(lblAPIBlackList).getText())) {
				flag = true;
				logger.debug("Validating title APIwise Blacklist completed");
			} else {
				logger.debug("APIwise Blacklist title is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating title APIwise Blacklist Page Title 'isAPIBlacklistPageDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating title APIwise Blacklist Page Title 'isAPIBlacklistPageDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Click api drop down.
	 *
	 * @author JayaniP
	 */
	public void clickAPIDropDown() {
		logger.debug("Click on API Drop box");
		getElement(ddSelectAPI).click();
		logger.debug("Clicked on API Drop box");
	}

	/**
	 * Select ussd.
	 *
	 * @author JayaniP
	 */
	public void selectUSSD() {
		logger.debug("Select USSD");
		getElement(lblUSSD).click();
		logger.debug("USSD selected");
	}

	/**
	 * Select api.
	 *
	 * @author JayaniP
	 * @param apiType the api type
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectAPI(String apiType) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on API Drop down");
		getElement(ddlAPIList).click();
		logger.debug("Clicked on API Drop down");

		logger.debug("Start typing api type");
		getElement(ddlAPIList).sendKeys(apiType);
		logger.debug("Typed api type");

		logger.debug("Start click enter");
		getElement(ddlAPIList).sendEnter();
		logger.debug("Clicked enter");

		logger.debug("Start clicking view button");
		getElement(btnView).click();
		logger.debug("Clicked view button");
	}

	/**
	 * Click add new button.
	 *
	 * @author JayaniP
	 * @throws InterruptedException the interrupted exception
	 */
	public void clickAddNewButton() throws InterruptedException {
		Thread.sleep(sleepTime);
		logger.debug("Click on Add new button");
		getElement(btnAddNew).click();
		logger.debug("Clicked on Add new button");
	}

	/**
	 * Checks if is adds the number alert displayed.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is adds the number alert displayed
	 * @throws Exception the exception
	 */
	public boolean isAddNumberAlertDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating add number alert");
		Thread.sleep(sleepTime);
		try {
			Alert alert = driver.switchTo().alert();
			if (title.contains(alert.getText())) {
				flag = true;
				logger.debug("Validating add number alert completed");
			} else {
				logger.debug("Add number alert title is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating add number alert Page Title 'isAddNumberAlertDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating add number alert Page Title 'isAddNumberAlertDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Enter black list number.
	 *
	 * @author JayaniP
	 * @param number the number
	 */
	public void enterBlackListNumber(String number) {
		logger.debug("Enter the number to blacklist");
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(number);
		logger.debug("Entered the number");
	}

	/**
	 * Click alert ok button.
	 *
	 * @author JayaniP
	 */
	public void clickAlertOKButton() {
		logger.debug("Click on Ok button");
		Alert alert = driver.switchTo().alert();
		alert.accept();
		logger.debug("Clicked on OK button");
	}

	/**
	 * Checks if is added number displayed.
	 *
	 * @author JayaniP
	 * @param number the number
	 * @return true, if is added number displayed
	 * @throws Exception the exception
	 */
	public boolean isAddedNumberDisplayed(String number) throws Exception {

		flag = false;
		logger.debug("Validating added number in table");
		Thread.sleep(sleepTime);
		String xpath = String.format(lblNumber, number);
		WebPelement lblAddedNumber = defineEelement(UIType.Xpath, xpath);
		try {
			if (number.contains(getElement(lblAddedNumber).getText())) {
				flag = true;
				logger.debug("Validating added number in table completed");
			} else {
				logger.debug("added number is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating added number in table Page Title 'isAddedNumberDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating added number in table Page Title 'isAddedNumberDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Checks if is API manager admin module error popup displayed.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is API manager admin module error popup displayed
	 * @throws Exception the exception
	 */
	public boolean isAPIManagerAdminModuleErrorPopupDisplayed(String title)
			throws Exception {

		flag = false;
		logger.debug("Validating API Manager Error Popup");
		Thread.sleep(sleepTime);
		try {
			if (title.contains(getElement(lblAdminModError).getText())) {
				flag = true;
				logger.debug("Validating API Manager Error Popup completed");
			} else {
				logger.debug("API Manager Error Popup title is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating title API Manager Error Popup Page Title 'isAPIManagerAdminModuleErrorPopupDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating title API Manager Error Popup Page Title 'isAPIManagerAdminModuleErrorPopupDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Click white list tab.
	 *
	 * @author JayaniP
	 * @throws Exception
	 *             the exception
	 */
	public void clickWhiteListTab() throws Exception {
		logger.debug("Click on White list tab");
		getElement(lnkWhiteList).click();
		Thread.sleep(sleepTime);
		logger.debug("Clicked on White list tab");
	}

	/**
	 * Checks if is AP iwise whitelist page displayed.
	 *
	 * @author SulakkhanaW
	 * @param title the title
	 * @return true, if is AP iwise whitelist page displayed
	 * @throws Exception the exception
	 */
	public boolean isAPIwiseWhitelistPageDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating APIwise White List Page");
		Thread.sleep(sleepTime);
		try {
			if (title.contains(getElement(lblAPIwiseWhiteList).getText())) {
				flag = true;
				logger.debug("Validating APIwise White List Page completed");
			} else {
				logger.debug("APIwise White List Page is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating APIwise White List Page Title 'isAPIwiseWhitelistPageDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating APIwise White List Page Title 'isAPIwiseWhitelistPageDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Select subscriber.
	 *
	 * @author JayaniP
	 * @param subscriber
	 *            the subscriber
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public void selectSubscriber(String subscriber) throws InterruptedException {
		logger.debug("Start clicking on Subscriber Drop down");
		getElement(ddSubscriber).click();
		logger.debug("Clicked on Subscriber Drop down");

		logger.debug("Start typing Subscriber type");
		getElement(ddSubscriber).sendKeys(subscriber);
		logger.debug("Typed Subscriber type");

		logger.debug("Start click enter");
		getElement(ddSubscriber).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Select application.
	 *
	 * @author JayaniP
	 * @param appname
	 *            the appname
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public void selectApplication(String appname) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on application Drop down");
		getElement(ddApplication).click();
		logger.debug("Clicked on application Drop down");

		logger.debug("Start typing application type");
		getElement(ddApplication).sendKeys(appname);
		logger.debug("Typed application type");

		logger.debug("Start click enter");
		getElement(ddApplication).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Click api drop box.
	 *
	 * @author JayaniP
	 */
	public void clickAPIDropBox() {
		logger.debug("Click on API");
		getElement(ddAPI).click();
		logger.debug("Clicked on API");
	}

	/**
	 * Select white list api.
	 *
	 * @author SulakkhanaW
	 * @param api the api
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectWhiteListAPI(String api) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on API Drop down");
		getElement(ddAPI).click();
		logger.debug("Clicked on API Drop down");

		logger.debug("Start typing api type");
		getElement(ddAPI).sendKeys(api);
		logger.debug("Typed api type");

		logger.debug("Start click enter");
		getElement(ddAPI).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Click upload manually.
	 *
	 * @author JayaniP
	 */
	public void clickUploadManually() {
		logger.debug("Select button upload manually");
		getElement(btnManual).click();
		logger.debug("Selected button upload manually");
	}

	/**
	 * Gen while list num.
	 *
	 * @author IsuruM
	 * @return the string
	 */
	public String GenWhileListNum() {

		double middleNum = Math.random();
		String middleNumCon = Double.toString(middleNum);
		int index = middleNumCon.indexOf('.');
		char[] myNameChars = middleNumCon.toCharArray();
		myNameChars[index] = '7';
		middleNumCon = String.valueOf(myNameChars);
		char[] array2 = Arrays.copyOfRange(myNameChars, 1, 6);
		middleNumCon = String.valueOf(array2);
		middleNumCon = "+9477521" + middleNumCon;
		return middleNumCon;
	}

	/**
	 * Generate random string for the minimum number.
	 *
	 * @author IsuruM return generated value
	 * @return the string
	 */

	public String GenMinNum() {

		String ini = "0776";
		double middleNum = Math.random();
		String middleNumCon = Double.toString(middleNum);
		int index = middleNumCon.indexOf('.');
		char[] myNameChars = middleNumCon.toCharArray();
		myNameChars[index] = '7';
		middleNumCon = String.valueOf(myNameChars);
		char[] array2 = Arrays.copyOfRange(myNameChars, 1, 6);
		array2[(array2.length) - 1] = '1';
		middleNumCon = String.valueOf(array2);
		middleNumCon = ini + middleNumCon;
		return middleNumCon;
	}

	/**
	 * Generate random string for the maximum number.
	 *
	 * @author IsuruM return generated value
	 * @param max the max
	 * @return the string
	 */

	public String GenMaxNum(String max) {

		String middleNumCon;
		char[] myNameChars = max.toCharArray();
		myNameChars[(myNameChars.length) - 1] = '9';
		middleNumCon = String.valueOf(myNameChars);
		return middleNumCon;
	}

	/**
	 * Enter redundent value.
	 *
	 * @author IsuruM return generated value
	 * @param redval the redval
	 */
	public void enterRedundentValue(String redval) {

		logger.debug("Enter Redundent Value");
		driver.findElement(By.xpath("//*[@id='manualNumber']"))
				.sendKeys(redval);
		logger.debug("Entered Redundent Value");
	}

	/**
	 * Enter manual number.
	 *
	 * @author IsuruM return generated value
	 * @param number the number
	 */
	public void enterManualNumber(String number) {
		logger.debug("Enter Manual Number");
		driver.findElement(By.xpath("//*[@id='manualNumber']"))
				.sendKeys(number);
		logger.debug("Entered Manual Number");
	}

	/**
	 * Click upload number button.
	 *
	 * @author JayaniP
	 */
	public void clickUploadNumberButton() {
		logger.debug("Click upload Number");

		getElement(btnUploadNumber).click();
		logger.debug("Clicked upload Number");
	}

	/**
	 * Click number range button.
	 *
	 * @author JayaniP
	 */
	public void clickNumberRangeButton() {
		logger.debug("Click Number Range button");
		getElement(btnNumberRange).click();
		logger.debug("Clicked Number Range button");
	}

	/**
	 * Enter min number.
	 *
	 * @author JayaniP
	 * @param number
	 *            the number
	 */
	public void enterMinNumber(String number) {
		logger.debug("Enter min number");
		getElement(txtMinNumber).clearAndSendkeys(number);
		logger.debug("Min number entered");
	}

	/**
	 * Enter max number.
	 *
	 * @author JayaniP
	 * @param number
	 *            the number
	 */
	public void enterMaxNumber(String number) {
		logger.debug("Enter max number");
		getElement(txtMaxNumber).clearAndSendkeys(number);
		logger.debug("Max number entered");
	}

	/**
	 * Click upload number list.
	 *
	 * @author JayaniP
	 * @throws InterruptedException the interrupted exception
	 */
	public void clickUploadNumberList() throws InterruptedException {
		logger.debug("Click upload number list");
		Thread.sleep(sleepTime);
		getElement(btnNumberList).click();
		logger.debug("Clicked upload number list");
	}

	/**
	 * Click upload whitelist number list.
	 *
	 * @author JayaniP
	 */
	public void clickUploadWhitelistNumberList() {
		logger.debug("Click upload whitelist number list");
		getElement(btnUploadNumberList).click();
		logger.debug("Clicked upload whitelist number list");
	}

	/**
	 * Click add number list.
	 *
	 * @author JayaniP
	 */
	public void clickAddNumberList() {
		logger.debug("Click add number list");
		getElement(btnAddNumberList).click();
		logger.debug("Clicked add number list");
	}

	/**
	 * Enter white list number list.
	 *
	 * @author JayaniP
	 * @param numbers the numbers
	 */
	public void enterWhiteListNumberList(String numbers) {
		logger.debug("Enter the number list to blacklist");
		Alert alert = driver.switchTo().alert();
		String list;
		String temp;
		String append;

		append = "+94776543";
		temp = GenMinNum();
		list = append + temp;

		list = list + "," + append + GenMinNum();

		alert.sendKeys(list);
		logger.debug("Entered the number list");
	}

	/**
	 * Clear blacklist number.
	 *
	 * @author JayaniP
	 * @param number the number
	 * @throws Exception the exception
	 */
	public void clearBlacklistNumber(String number) throws Exception {
		logger.debug("Remove blacklist number if available");

		String xpathlblNumber = String.format(lblWhiteListNumbers, number);
		List<WebElement> whitelistNum = driver.findElements(By.xpath(xpathlblNumber));
		int countWhiteListNumber = whitelistNum.size();

		String xpathRemoveNumber = String.format(btnRemoveNumber, number);
		WebPelement btnRemoveNumber = defineEelement(UIType.Xpath, xpathRemoveNumber);

		try {
			if (countWhiteListNumber == 1) {
				logger.debug("Click remove number");
				getElement(btnRemoveNumber).click();
				logger.debug("Clicked remove number");
			}
		} catch (Exception e) {
			logger.debug("Exception While removing blacklist number 'clearBlacklistNumber()'" + e.getMessage());
			throw new Exception("Exception While removing blacklist number 'clearBlacklistNumber()'" + e.getLocalizedMessage());
		}
	}

	/**
	 * Click on billingand metering.
	 *
	 * @author JayaniP
	 */
	public void clickOnBillingandMetering() {
		logger.debug("Click billing and metering");
		getElement(lnkBillingAndMetering).click();
		logger.debug("Clicked on billing and metering");
	}

	/**
	 * Checks if is total api traffic page displayed.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is total api traffic page displayed
	 * @throws Exception the exception
	 */
	public boolean isTotalAPITrafficPageDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating Total API Traffic Page");
		Thread.sleep(sleepTime);
		try {
			if (title.contains(getElement(lblTotalAPITraffic).getText())) {
				flag = true;
				logger.debug("Validating Total API Traffic Page completed");
			} else {
				logger.debug("Total API Traffic Page is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Total API Traffic Page Title 'isTotalAPITrafficPageDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating Total API Traffic Page Title 'isTotalAPITrafficPageDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Enter api traffic from date.
	 *
	 * @author JayaniP
	 * @param fromDate the from date
	 */
	public void enterAPITrafficFromDate(String fromDate) {
		logger.debug("Enter Total API traffic From date");
		getElement(txtTotalAPITrafficFromDate).clearAndSendkeys(fromDate);
		logger.debug("Entered Total API traffic From date");
	}

	/**
	 * Enter api traffic to date.
	 *
	 * @author JayaniP
	 * @param toDate the to date
	 */
	public void enterAPITrafficToDate(String toDate) {
		logger.debug("Enter Total API traffic To date");
		getElement(txtTotalAPITrafficToDate).clearAndSendkeys(toDate);
		logger.debug("Entered Total API traffic To date");
	}

	/**
	 * Select api traffic operator.
	 *
	 * @author JayaniP
	 * @param operator the operator
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectAPITrafficOperator(String operator) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on operator Drop down");
		getElement(ddTotalAPITrafficOperator).click();
		logger.debug("Clicked on operator Drop down");

		logger.debug("Start typing operator");
		getElement(ddTotalAPITrafficOperator).sendKeys(operator);
		logger.debug("Typed operator");

		logger.debug("Start click enter");
		getElement(ddTotalAPITrafficOperator).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Select total api traffic service provider.
	 *
	 * @author JayaniP
	 * @param sprovider the sprovider
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectTotalAPITrafficServiceProvider(String sprovider) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on Service provider Drop down");
		getElement(ddTotalAPITrafficServiceProvider).click();
		logger.debug("Clicked on Service provider Drop down");

		logger.debug("Start typing Service provider");
		getElement(ddTotalAPITrafficServiceProvider).sendKeys(sprovider);
		logger.debug("Typed Service provider");

		logger.debug("Start click enter");
		getElement(ddTotalAPITrafficServiceProvider).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Click api traffic application drop down.
	 *
	 * @author JayaniP
	 */
	public void clickAPITrafficApplicationDropDown() {
		logger.debug("Click Total API traffic Application");
		getElement(ddTotalAPITrafficApplication).click();
		logger.debug("Clicked Total API traffic Application");
	}

	/**
	 * Select total api traffic application.
	 *
	 * @author JayaniP
	 * @param app the app
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectTotalAPITrafficApplication(String app) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on Application Drop down");
		getElement(ddTotalAPITrafficApplication).click();
		logger.debug("Clicked on API Drop down");

		logger.debug("Start typing Application");
		getElement(ddTotalAPITrafficApplication).sendKeys(app);
		logger.debug("Typed Application");

		logger.debug("Start click enter");
		getElement(ddTotalAPITrafficApplication).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Select total api traffic api.
	 *
	 * @author JayaniP
	 * @param api the api
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectTotalAPITrafficAPI(String api) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on API Drop down");
		getElement(ddTotalAPITrafficAPI).click();
		logger.debug("Clicked on API Drop down");

		logger.debug("Start typing api type");
		getElement(ddTotalAPITrafficAPI).sendKeys(api);
		logger.debug("Typed api type");

		logger.debug("Start click enter");
		getElement(ddTotalAPITrafficAPI).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Click on generate.
	 *
	 * @author JayaniP
	 */
	public void clickOnGenerate() {
		logger.debug("Click on Generate");
		getElement(btnGenerate).click();
		logger.debug("Clicked on Generate");
	}

	/**
	 * Click on transaction logSB.
	 *
	 * @author JayaniP
	 */
	public void clickOnTransactionLog() {
		logger.debug("Click on Transaction Log");
		getElement(lnkTransactionLog).click();
		logger.debug("Clicked on Transaction Log");
	}
	
	/**
	 * Click on transaction logNB.
	 *
	 * @author Suji
	 */
	public void clickOnTransactionLogNB() {
		logger.debug("Click on Transaction LogNB");
		getElement(lnkTransactionLogNB).click();
		logger.debug("Clicked on Transaction LogNB");
	}

	/**
	 * Checks if is transaction log page displayed.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is transaction log page displayed
	 * @throws Exception the exception
	 */
	public boolean isTransactionLogPageDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating Transaction Log Page");
		Thread.sleep(sleepTime);
		try {
			if (title.contains(getElement(lblTransactionLog).getText())) {
				flag = true;
				logger.debug("Validating Transaction Log Page completed");
			} else {
				logger.debug("Transaction Log Page is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Transaction Log Page Title 'isTransactionLogPageDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating Transaction Log Page Title 'isTransactionLogPageDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Enter transaction log from date.
	 *
	 * @author JayaniP
	 * @param fromDate the from date
	 */
	public void enterTransactionLogFromDate(String fromDate) {
		logger.debug("Enter Transaction Log from date");
		getElement(txtTransactionLogFromDate).clearAndSendkeys(fromDate);
		logger.debug("Entered Transaction Log from date");
	}

	/**
	 * Enter transaction log to date.
	 *
	 * @author JayaniP
	 * @param toDate the to date
	 */
	public void enterTransactionLogToDate(String toDate) {
		logger.debug("Enter Transaction Log to date");
		getElement(txtTransactionLogToDate).clearAndSendkeys(toDate);
		logger.debug("Entered Transaction Log to date");
	}

	/**
	 * Select transaction log operator.
	 *
	 * @author JayaniP
	 * @param operator the operator
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectTransactionLogOperator(String operator) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on operator Drop down");
		getElement(ddTransactionLogOperator).click();
		logger.debug("Clicked on operator Drop down");

		logger.debug("Start typing operator");
		getElement(ddTransactionLogOperator).sendKeys(operator);
		logger.debug("Typed operator");

		logger.debug("Start click enter");
		getElement(ddTransactionLogOperator).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Select transaction log service provider.
	 *
	 * @author JayaniP
	 * @param serviceProvider the service provider
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectTransactionLogServiceProvider(String serviceProvider) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on service provider Drop down");
		getElement(ddTransactionLogServiceProvider).click();
		logger.debug("Clicked on service provider Drop down");

		logger.debug("Start typing service provider");
		getElement(ddTransactionLogServiceProvider).sendKeys(serviceProvider);
		logger.debug("Typed service provider");

		logger.debug("Start click enter");
		getElement(ddTransactionLogServiceProvider).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Select transaction log api.
	 *
	 * @author JayaniP
	 * @param operationType the operation type
	 * @throws InterruptedException             the interrupted exception
	 */
	public void selectTransactionLogOperationType(String operationType) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on OperationType Drop down");
		getElement(ddTransactionLogOperationType).click();
		logger.debug("Clicked on API Drop down");

		logger.debug("Start typing OperationType");
		getElement(ddTransactionLogOperationType).sendKeys(operationType);
		logger.debug("Typed API");

		logger.debug("Start click enter");
		getElement(ddTransactionLogOperationType).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Select transaction log records type.
	 *
	 * @author JayaniP
	 * @param status the status
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectTransactionLogRecordsType(String status) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on RecordsType Drop down");
		getElement(ddTransactionLogRecordsType).click();
		logger.debug("Clicked on RecordsType Drop down");

		logger.debug("Start typing Status");
		getElement(ddTransactionLogRecordsType).sendKeys(status);
		logger.debug("Typed Status");

		logger.debug("Start click enter");
		getElement(ddTransactionLogRecordsType).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Click download file.
	 *
	 * @author JayaniP
	 */
	public void clickDownloadFile() {
		logger.debug("Start click download file");
		getElement(btnDownloadReport).click();
		logger.debug("Clicked download file");
	}

	/**
	 * Click operator api traffic.
	 *
	 * @author JayaniP
	 */
	public void clickOperatorAPITraffic() {
		logger.debug("Start click Operator API Traffic");
		getElement(lnkOperatorAPITraffic).click();
		logger.debug("Clicked Operator API Traffic");
	}

	/**
	 * Checks if is operator api traffic page displayed.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is operator api traffic page displayed
	 * @throws Exception the exception
	 */
	public boolean isOperatorAPITrafficPageDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating Operator API Traffic Page");
		Thread.sleep(sleepTime);
		try {
			if (title.contains(getElement(lblOperatorAPITraffic).getText())) {
				flag = true;
				logger.debug("Validating Operator API Traffic Page completed");
			} else {
				logger.debug("Operator API Traffic Page is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Operator API Traffic Page Title 'isOperatorAPITrafficPageDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating Operator API Traffic Page Title 'isOperatorAPITrafficPageDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Enter operator api traffic from date.
	 *
	 * @author JayaniP
	 * @param fromDate the from date
	 */
	public void enterOperatorAPITrafficFromDate(String fromDate) {
		logger.debug("Enter Operator API Traffic From Date");
		getElement(txtOperatorAPITrafficFromDate).clearAndSendkeys(fromDate);
		logger.debug("Entered Operator API Traffic From Date");
	}

	/**
	 * Enter operator api traffic to date.
	 *
	 * @author JayaniP
	 * @param toDate the to date
	 */
	public void enterOperatorAPITrafficToDate(String toDate) {
		logger.debug("Enter Operator API Traffic To Date");
		getElement(txtOperatorAPITrafficToDate).clearAndSendkeys(toDate);
		logger.debug("Entered Operator API Traffic To Date");
	}

	/**
	 * Select operator api traffic service provider.
	 *
	 * @author JayaniP
	 * @param serviceProvider the service provider
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectOperatorAPITrafficServiceProvider(String serviceProvider) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on service provider Drop down");
		getElement(ddOperatorAPITrafficServiceProvider).click();
		logger.debug("Clicked on service provider Drop down");

		logger.debug("Start typing service provider");
		getElement(ddOperatorAPITrafficServiceProvider).sendKeys(serviceProvider);
		logger.debug("Typed service provider");

		logger.debug("Start click enter");
		getElement(ddOperatorAPITrafficServiceProvider).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Select operator api traffic application.
	 *
	 * @author JayaniP
	 * @param app the app
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectOperatorAPITrafficApplication(String app) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on application Drop down");
		getElement(ddOperatorAPITrafficApplication).click();
		logger.debug("Clicked on application Drop down");

		logger.debug("Start typing application");
		getElement(ddOperatorAPITrafficApplication).sendKeys(app);
		logger.debug("Typed application");

		logger.debug("Start click enter");
		getElement(ddOperatorAPITrafficApplication).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Select operator api traffic api.
	 *
	 * @author JayaniP
	 * @param api the api
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectOperatorAPITrafficAPI(String api) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on api Drop down");
		getElement(ddOperatorAPITrafficAPI).click();
		logger.debug("Clicked on api Drop down");

		logger.debug("Start typing api");
		getElement(ddOperatorAPITrafficAPI).sendKeys(api);
		logger.debug("Typed api");

		logger.debug("Start click enter");
		getElement(ddOperatorAPITrafficAPI).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Click monthly invoice.
	 *
	 * @author JayaniP
	 */
	public void clickMonthlyInvoice() {
		logger.debug("Start click Monthly Invoice");
		getElement(lnkMonthlyInvoice).click();
		logger.debug("Clicked Monthly Invoice");
	}
	
	/**
	 * Click monthly invoice nb.
	 *
	 * @author SulakkhanaW
	 */
	public void clickMonthlyInvoiceNB(){
		logger.debug("Start click Monthly Invoice NB");
		getElement(lnkMonthlyInvoiceNB).click();
		logger.debug("Clicked Monthly Invoice NB");
	}
	
	/**
	 * Click monthly invoice sb.
	 *
	 * @author SulakkhanaW
	 */
	public void clickMonthlyInvoiceSB(){
		logger.debug("Start click Monthly Invoice NB");
		getElement(lnkMonthlyInvoiceSB).click();
		logger.debug("Clicked Monthly Invoice NB");
	}

	/**
	 * Checks if is monthly invoice page displayed.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is monthly invoice page displayed
	 * @throws Exception the exception
	 */
	public boolean isMonthlyInvoicePageDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating Monthly Invoice Page");
		Thread.sleep(sleepTime);
		try {
			if (title.contains(getElement(lblMonthlyInvoice).getText())) {
				flag = true;
				logger.debug("Validating Monthly Invoice Page completed");
			} else {
				logger.debug("Monthly Invoice Page is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Monthly Invoice Page Title 'isMonthlyInvoicePageDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating Monthly Invoice Page Title 'isMonthlyInvoicePageDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Select monthly invoice year.
	 *
	 * @author JayaniP
	 * @param year the year
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectMonthlyInvoiceYear(String year) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on year down");
		getElement(ddMonthlyInvoiceYear).click();
		logger.debug("Clicked on year Drop down");

		logger.debug("Start typing year");
		getElement(ddMonthlyInvoiceYear).sendKeys(year);
		logger.debug("Typed year");

		logger.debug("Start click enter");
		getElement(ddMonthlyInvoiceYear).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Select monthly invoice month.
	 *
	 * @author JayaniP
	 * @param month the month
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectMonthlyInvoiceMonth(String month) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on month down");
		getElement(ddMonthlyInvoiceMonth).click();
		logger.debug("Clicked on month Drop down");

		logger.debug("Start typing month");
		getElement(ddMonthlyInvoiceMonth).sendKeys(month);
		logger.debug("Typed month");

		logger.debug("Start click enter");
		getElement(ddMonthlyInvoiceMonth).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Select monthly invoice service provider.
	 *
	 * @author JayaniP
	 * @param serviceProvider the service provider
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectMonthlyInvoiceServiceProvider(String serviceProvider) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on service provider down");
		getElement(ddMonthlyInvoiceServiceProvider).click();
		logger.debug("Clicked on service provider Drop down");

		logger.debug("Start typing service provider");
		getElement(ddMonthlyInvoiceServiceProvider).sendKeys(serviceProvider);
		logger.debug("Typed service provider");

		logger.debug("Start click enter");
		getElement(ddMonthlyInvoiceServiceProvider).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Click on rvenue breakdown.
	 *
	 * @author JayaniP
	 */
	public void clickOnRvenueBreakdownSB() {
		logger.debug("Start click revenue breakdown");
		getElement(lnkRevenueBreakdown).click();
		logger.debug("Clicked revenue breakdown");
	}

	/**
	 * Click on rvenue breakdown nb.
	 *
	 * @author JayaniP
	 */
	public void clickOnRvenueBreakdownNB() {
		logger.debug("Start click revenue breakdown");
		getElement(lnkRevenueBreakdownNB).click();
		logger.debug("Clicked revenue breakdown");
	}
	/**
	 * Checks if is revenue breakdown page displayed.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is revenue breakdown page displayed
	 * @throws Exception the exception
	 */
	public boolean isRevenueBreakdownPageDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating Revenue Break down Page");
		Thread.sleep(sleepTime);
		try {
			if (title.contains(getElement(lblRevenueBreakdown).getText())) {
				flag = true;
				logger.debug("Validating Revenue Break down Page completed");
			} else {
				logger.debug("Revenue Break down Page is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Revenue Break down Page Title 'isRevenueBreakdownPageDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating Revenue Break down Page Title 'isRevenueBreakdownPageDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Select revenue breakdown year.
	 *
	 * @author JayaniP
	 * @param year the year
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectRevenueBreakdownYear(String year) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on year Drop down");
		getElement(ddRevenueBreakdownYear).click();
		logger.debug("Clicked on year Drop down");

		logger.debug("Start typing year");
		getElement(ddRevenueBreakdownYear).sendKeys(year);
		logger.debug("Typed year");

		logger.debug("Start click enter");
		getElement(ddRevenueBreakdownYear).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Select revenue breakdown month.
	 *
	 * @author JayaniP
	 * @param month the month
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectRevenueBreakdownMonth(String month) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on month Drop down");
		getElement(ddRevenueBreakdownMonth).click();
		logger.debug("Clicked on month Drop down");

		logger.debug("Start typing month");
		getElement(ddRevenueBreakdownMonth).sendKeys(month);
		logger.debug("Typed month");

		logger.debug("Start click enter");
		getElement(ddRevenueBreakdownMonth).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Select revenue breakdown operator.
	 *
	 * @author JayaniP
	 * @param operator the operator
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectRevenueBreakdownOperator(String operator) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on operator Drop down");
		getElement(ddRevenueBreakdownOperator).click();
		logger.debug("Clicked on operator Drop down");

		logger.debug("Start typing operator");
		getElement(ddRevenueBreakdownOperator).sendKeys(operator);
		logger.debug("Typed operator");

		logger.debug("Start click enter");
		getElement(ddRevenueBreakdownOperator).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Select revenue breakdown service provider.
	 *
	 * @author JayaniP
	 * @param serviceProvider the service provider
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectRevenueBreakdownServiceProvider(String serviceProvider) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on service provider Drop down");
		getElement(ddRevenueBreakdownServiceProvider).click();
		logger.debug("Clicked on service provider Drop down");

		logger.debug("Start typing service provider");
		getElement(ddRevenueBreakdownServiceProvider).sendKeys(serviceProvider);
		logger.debug("Typed service provider");

		logger.debug("Start click enter");
		getElement(ddRevenueBreakdownServiceProvider).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Select revenue breakdown application.
	 *
	 * @author JayaniP
	 * @param app the app
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectRevenueBreakdownApplication(String app) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on application Drop down");
		getElement(ddRevenueBreakdownApplication).click();
		logger.debug("Clicked on application Drop down");

		logger.debug("Start typing application");
		getElement(ddRevenueBreakdownApplication).sendKeys(app);
		logger.debug("Typed application");

		logger.debug("Start click enter");
		getElement(ddRevenueBreakdownApplication).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Click on customer care.
	 *
	 * @author JayaniP
	 */
	public void clickOnCustomerCare() {
		logger.debug("Start click customer care");
		getElement(lnkCustomerCare).click();
		logger.debug("Clicked customer care");
	}

	/**
	 * Checks if is customer care page displayed.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is customer care page displayed
	 * @throws Exception the exception
	 */
	public boolean isCustomerCarePageDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating customer care Page");
		Thread.sleep(sleepTime);
		try {
			if (title.contains(getElement(lblCustomerCare).getText())) {
				flag = true;
				logger.debug("Validating customer care Page completed");
			} else {
				logger.debug("customer care Page is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating customer care Page Title 'isCustomerCarePageDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating customer care Page Title 'isCustomerCarePageDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Enter customer care from date.
	 *
	 * @author JayaniP
	 * @param fromDate the from date
	 */
	public void enterCustomerCareFromDate(String fromDate) {
		logger.debug("Start enter customer care from date");
		getElement(txtCustomerCareFromDate).clearAndSendkeys(fromDate);
		logger.debug("Entered customer care from date");
	}

	/**
	 * Enter customer care to date.
	 *
	 * @author JayaniP
	 * @param toDate the to date
	 */
	public void enterCustomerCareToDate(String toDate) {
		logger.debug("Start enter customer care To date");
		getElement(txtCustomerCareToDate).clearAndSendkeys(toDate);
		logger.debug("Entered customer care To date");
	}

	/**
	 * Enter customer care msisdn.
	 *
	 * @author JayaniP
	 * @param msisdn the msisdn
	 */
	public void enterCustomerCareMSISDN(String msisdn) {
		logger.debug("Start enter customer care MSISDN");
		getElement(txtCustomerCareMSISDN).clearAndSendkeys(msisdn);
		logger.debug("Entered customer care MSISDN");
	}

	/**
	 * Select customer care operator.
	 *
	 * @author JayaniP
	 * @param operator the operator
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectCustomerCareOperator(String operator) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on operator Drop down");
		getElement(ddCustomerCareOperator).click();
		logger.debug("Clicked on operator Drop down");

		logger.debug("Start typing operator");
		getElement(ddCustomerCareOperator).sendKeys(operator);
		logger.debug("Typed operator");

		logger.debug("Start click enter");
		getElement(ddCustomerCareOperator).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Select customer care service provider.
	 *
	 * @author JayaniP
	 * @param serviceProvider the service provider
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectCustomerCareServiceProvider(String serviceProvider) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on service provider Drop down");
		getElement(ddCustomerCareServiceProvider).click();
		logger.debug("Clicked on service provider Drop down");

		logger.debug("Start typing service provider");
		getElement(ddCustomerCareServiceProvider).sendKeys(serviceProvider);
		logger.debug("Typed service provider");

		logger.debug("Start click enter");
		getElement(ddCustomerCareServiceProvider).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Select customer care application.
	 *
	 * @author JayaniP
	 * @param app the app
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectCustomerCareApplication(String app) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on application Drop down");
		getElement(ddCustomerCareApplication).click();
		logger.debug("Clicked on application Drop down");

		logger.debug("Start typing application");
		getElement(ddCustomerCareApplication).sendKeys(app);
		logger.debug("Typed application");

		logger.debug("Start click enter");
		getElement(ddCustomerCareApplication).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Click on api response time.
	 *
	 * @author JayaniP
	 */
	public void clickOnAPIResponseTime() {
		logger.debug("Start click API response time");
		getElement(lnkAPIResponseTime).click();
		logger.debug("Clicked API response time");
	}

	/**
	 * Checks if is API response time page displayed.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is API response time page displayed
	 * @throws Exception the exception
	 */
	public boolean isAPIResponseTimePageDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating API Response Time Page");
		Thread.sleep(sleepTime);
		try {
			if (title.contains(getElement(lblAPIResponseTime).getText())) {
				flag = true;
				logger.debug("Validating API Response Time Page completed");
			} else {
				logger.debug("API Response Time Page is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating API Response Time Page Title 'isAPIResponseTimePageDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating API Response Time Page Title 'isAPIResponseTimePageDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Enter api response time from date.
	 *
	 * @author JayaniP
	 * @param fromDate the from date
	 */
	public void enterAPIResponseTimeFromDate(String fromDate) {
		logger.debug("Start enter API response time from date");
		getElement(txtAPIResponseTimeFromDate).clearAndSendkeys(fromDate);
		logger.debug("Entered API response time from date");
	}

	/**
	 * Enter api response time to date.
	 *
	 * @author JayaniP
	 * @param toDate the to date
	 */
	public void enterAPIResponseTimeToDate(String toDate) {
		logger.debug("Start enter API response time to date");
		getElement(txtAPIResponseTimeToDate).clearAndSendkeys(toDate);
		logger.debug("Entered API response time to date");
	}

	/**
	 * Select api response times operator.
	 *
	 * @author JayaniP
	 * @param operator the operator
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectAPIResponseTimesOperator(String operator) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on operator Drop down");
		getElement(ddAPIResponseTimeOperator).click();
		logger.debug("Clicked on operator Drop down");

		logger.debug("Start typing operator");
		getElement(ddAPIResponseTimeOperator).sendKeys(operator);
		logger.debug("Typed operator");

		logger.debug("Start click enter");
		getElement(ddAPIResponseTimeOperator).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Select api response times service provider.
	 *
	 * @author JayaniP
	 * @param serviceProvider the service provider
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectAPIResponseTimesServiceProvider(String serviceProvider) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on service provider Drop down");
		getElement(ddAPIResponseTimeServiceProvider).click();
		logger.debug("Clicked on service provider Drop down");

		logger.debug("Start typing service provider");
		getElement(ddAPIResponseTimeServiceProvider).sendKeys(serviceProvider);
		logger.debug("Typed service provider");

		logger.debug("Start click enter");
		getElement(ddAPIResponseTimeServiceProvider).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Select api response times application.
	 *
	 * @author JayaniP
	 * @param app the app
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectAPIResponseTimesApplication(String app) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on application Drop down");
		getElement(ddAPIResponseTimeApplication).click();
		logger.debug("Clicked on application Drop down");

		logger.debug("Start typing application");
		getElement(ddAPIResponseTimeApplication).sendKeys(app);
		logger.debug("Typed application");

		logger.debug("Start click enter");
		getElement(ddAPIResponseTimeApplication).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Click on api response time generate.
	 *
	 * @author JayaniP
	 */
	public void clickOnAPIResponseTimeGenerate() {
		logger.debug("Start click generate");
		getElement(btnAPIResponseTimeGenerate).click();
		logger.debug("Clicked generate");
	}

	/**
	 * Click on performance error rates.
	 *
	 * @author JayaniP
	 */
	public void clickOnPerformanceErrorRates() {
		logger.debug("Start click Performance error rates");
		getElement(lnkPerformanceErrorRates).click();
		logger.debug("Clicked Performance error rates");
	}

	/**
	 * Checks if is performance error rates page displayed.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is performance error rates page displayed
	 * @throws Exception the exception
	 */
	public boolean isPerformanceErrorRatesPageDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating Performance Error Rates Page");
		Thread.sleep(sleepTime);
		try {
			if (title.contains(getElement(lblPerformanceErrorRates).getText())) {
				flag = true;
				logger.debug("Validating Performance Error Rates completed");
			} else {
				logger.debug("Performance Error Rates Page is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Performance Error Rates Page Title 'isPerformanceErrorRatesPageDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating Performance Error Rates Page Title 'isPerformanceErrorRatesPageDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Enter performance error rates from date.
	 *
	 * @author JayaniP
	 * @param fromdate the fromdate
	 */
	public void enterPerformanceErrorRatesFromDate(String fromdate) {
		logger.debug("Start enter from date");
		getElement(txtPerformanceErrorRatesFromDate).clearAndSendkeys(fromdate);
		logger.debug("Entered from date");
	}

	/**
	 * Enter performance error rates to date.
	 *
	 * @author JayaniP
	 * @param todate the todate
	 */
	public void enterPerformanceErrorRatesToDate(String todate) {
		logger.debug("Start enter to date");
		getElement(txtPerformanceErrorRatesToDate).clearAndSendkeys(todate);
		logger.debug("Entered to date");
	}

	/**
	 * Select performance error operator.
	 *
	 * @author JayaniP
	 * @param operator the operator
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectPerformanceErrorOperator(String operator) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on operator Drop down");
		getElement(ddPerformanceErrorRatesOperator).click();
		logger.debug("Clicked on operator Drop down");

		logger.debug("Start typing operator");
		getElement(ddPerformanceErrorRatesOperator).sendKeys(operator);
		logger.debug("Typed operator");

		logger.debug("Start click enter");
		getElement(ddPerformanceErrorRatesOperator).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Select performance error service provider.
	 *
	 * @author JayaniP
	 * @param serviceProvider the service provider
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectPerformanceErrorServiceProvider(String serviceProvider) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on service provider Drop down");
		getElement(ddPerformanceErrorRatesServiceProvider).click();
		logger.debug("Clicked on service provider Drop down");

		logger.debug("Start typing service provider");
		getElement(ddPerformanceErrorRatesServiceProvider).sendKeys(
				serviceProvider);
		logger.debug("Typed service provider");

		logger.debug("Start click enter");
		getElement(ddPerformanceErrorRatesServiceProvider).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Select performance error application.
	 *
	 * @author JayaniP
	 * @param app the app
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectPerformanceErrorApplication(String app) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on Application Drop down");
		getElement(ddPerformanceErrorRatesApplication).click();
		logger.debug("Clicked on Application Drop down");

		logger.debug("Start typing Application");
		getElement(ddPerformanceErrorRatesApplication).sendKeys(app);
		logger.debug("Typed Application");

		logger.debug("Start click enter");
		getElement(ddPerformanceErrorRatesApplication).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Select performance error api.
	 *
	 * @author JayaniP
	 * @param api the api
	 * @throws InterruptedException the interrupted exception
	 */
	public void selectPerformanceErrorAPI(String api) throws InterruptedException {
		Thread.sleep(sleepTime);

		logger.debug("Start clicking on API Drop down");
		getElement(ddPerformanceErrorRatesAPI).click();
		logger.debug("Clicked on API Drop down");

		logger.debug("Start typing API");
		getElement(ddPerformanceErrorRatesAPI).sendKeys(api);
		logger.debug("Typed API");

		logger.debug("Start click enter");
		getElement(ddPerformanceErrorRatesAPI).sendEnter();
		logger.debug("Clicked enter");

	}

	/**
	 * Click on monthly invoice download report.
	 *
	 * @author JayaniP
	 */
	public void clickOnMonthlyInvoiceDownloadReport() {
		logger.debug("Start click Download Report");
		getElement(btnMonthlyInvoiceDownloadReport).click();
		logger.debug("Clicked Download Report");
	}

	/**
	 * Checks if is white list added successfully popup displayed.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is white list added successfully popup displayed
	 * @throws Exception the exception
	 */
	public boolean isWhiteListAddedSuccessfullyPopupDisplayed(String title)
			throws Exception {

		flag = false;
		logger.debug("Validating Success Pop up");
		Thread.sleep(sleepTime);
		try {
			if (title.contains(getElement(lblWhiteListAddedPopup).getText())) {
				flag = true;
				logger.debug("Validating Success Pop up completed");
			} else {
				logger.debug("Success Pop up is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Success Pop up Title 'isWhiteListAddedSuccessfullyPopupDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating Success Pop up Title 'isWhiteListAddedSuccessfullyPopupDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Click ok.
	 *
	 * @author JayaniP
	 * @throws Exception the exception
	 */
	public void clickOK() throws Exception {
		logger.debug("Start clicking on OK");
		getElement(btnWhiteListAddedPopupOK).click();
		Thread.sleep(sleepTime);
		logger.debug("Clicked OK");
	}

	/**
	 * Checks if is white list error popup displayed.
	 *
	 * @author JayaniP
	 * @param title the title
	 * @return true, if is white list error popup displayed
	 * @throws Exception the exception
	 */
	public boolean isWhiteListErrorPopupDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating Error Pop up");
		Thread.sleep(sleepTime);
		try {
			if (title.contains(getElement(lblWhiteListErrorPopup).getText())) {
				flag = true;
				logger.debug("Validating Error Pop up completed");
			} else {
				logger.debug("Error Pop up is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Error Pop up Title 'isWhiteListErrorPopupDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating Error Pop up Title 'isWhiteListErrorPopupDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Checks if is pie graph performance error rates.
	 *
	 * @author SulakkhanaW
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param operatorId the operator id
	 * @param serviceProvider the service provider
	 * @return true, if is pie graph performance error rates
	 * @throws Exception the exception
	 */
	public boolean isPieGraphPerformanceErrorRates(String fromDate, String toDate, String operatorId, String serviceProvider) throws Exception {
		flag = false;
		ArrayList<String> apiList = new ArrayList<String>();
		WebElement select;
		try {
			select = getElement(UIType.Xpath, pieChartPerformanceErrorRates);
			List<WebElement> options = select.findElements(By.xpath(pieChartPerformanceErrorRates));
			for (WebElement option : options) {
				apiList.add(option.getText());
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating graphs data 'isPieGraph()'" + e.getMessage());
			throw new Exception("Exception While Validating graphs data 'isPieGraph()'" + e.getLocalizedMessage());
		}
		int count = apiList.size();
		String apiListDetails[][] = new String[count][2];
		for (int i = 0; i < count; i++) {
			String element = apiList.get(i);
			int openParanthis = element.indexOf("(") + 1;
			int closeParanthis = element.indexOf(")");
			String value = element.substring(openParanthis, closeParanthis);
			String apiName = element.substring(0, openParanthis - 1).trim();
			apiListDetails[i][0] = apiName;
			apiListDetails[i][1] = value;
		}
		try {
			flag = dbReturningDataPerformanceErrorRates(apiListDetails, fromDate, toDate, operatorId, serviceProvider);
		} catch (Exception e) {
			logger.debug("Exception While Validating matching data 'dbReturningData()'" + e.getMessage());
			throw new Exception("Exception While Validating matching data 'dbReturningData()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Checks if is pie graph total api traffic.
	 *
	 * @author SulakkhanaW
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param operatorId the operator id
	 * @param serviceProvider the service provider
	 * @return true, if is pie graph total api traffic
	 * @throws Exception the exception
	 */
	public boolean isPieGraphTotalAPITraffic(String fromDate, String toDate, String operatorId, String serviceProvider) throws Exception {
		flag = false;
		ArrayList<String> apiList = new ArrayList<String>();
		WebElement select;
		try {
			select = getElement(UIType.Xpath, pieChartTotalAPITraffic);
			List<WebElement> options = select.findElements(By.xpath(pieChartTotalAPITraffic));
			for (WebElement option : options) {
				apiList.add(option.getText());
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating graphs data 'isPieGraph()'" + e.getMessage());
			throw new Exception("Exception While Validating graphs data 'isPieGraph()'" + e.getLocalizedMessage());
		}
		int count = apiList.size();
		String apiListDetails[][] = new String[count][2];
		for (int i = 0; i < count; i++) {
			String element = apiList.get(i);
			int openParanthis = element.indexOf("(") + 1;
			int closeParanthis = element.indexOf(")");
			String value = element.substring(openParanthis, closeParanthis);
			String apiName = element.substring(0, openParanthis - 1).trim();
			apiListDetails[i][0] = apiName;
			apiListDetails[i][1] = value;
		}
		try {
			flag = dbReturningDataTotalAPITraffic(apiListDetails, fromDate, toDate, operatorId, serviceProvider);
		} catch (Exception e) {
			logger.debug("Exception While Validating matching data 'dbReturningData()'" + e.getMessage());
			throw new Exception("Exception While Validating matching data 'dbReturningData()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Db returning data performance error rates.
	 *
	 * @author SulakkhanaW
	 * @param apiTrafficListUI the api traffic list ui
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param operatorId the operator id
	 * @param serviceProvider the service provider
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean dbReturningDataPerformanceErrorRates(String[][] apiTrafficListUI, String fromDate, String toDate, String operatorId, String serviceProvider) throws Exception {
		flag = false;
		String query = String.format(SQLQuery.PERFORMANCE_ERROR_RATES, fromDate, toDate, operatorId, serviceProvider);
		QueryResult qsApiTotalTraffic;
		String uiApiName = null;
		String uiApiCount = null;
		String dbApiCount = null;
		try {
			qsApiTotalTraffic = SQLExecuter.getQueryResults(query);
			if (qsApiTotalTraffic.numOfResult() == apiTrafficListUI.length) {
				int rowCount = qsApiTotalTraffic.numOfResult();
				for (int x = 0; x < rowCount;) {
					uiApiName = apiTrafficListUI[x][0];
					uiApiCount = apiTrafficListUI[x][1];
					dbApiCount = qsApiTotalTraffic.getValueFromCondition("valueCounts", "exceptionId", uiApiName);
					if (!uiApiCount.equals(dbApiCount)) {
						flag = false;
					}
					x++;
				}
				flag = true;
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating matching datae 'dbReturningData()' UICount : " + uiApiCount + " and DBCount : " + dbApiCount + e.getMessage());
			throw new Exception("Exception While Validating matching data 'dbReturningData()' UICount : " + uiApiCount + " and DBCount : " + dbApiCount + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Db returning data total api traffic.
	 *
	 * @author SulakkhanaW
	 * @param apiTrafficListUI the api traffic list ui
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param operatorId the operator id
	 * @param serviceProvider the service provider
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean dbReturningDataTotalAPITraffic(String[][] apiTrafficListUI, String fromDate, String toDate, String operatorId, String serviceProvider) throws Exception {
		flag = false;
		String query = String.format(SQLQuery.TOTAL_API_TRAFFIC, fromDate, toDate, operatorId, serviceProvider);
		QueryResult qsApiTotalTraffic;
		String uiApiName = null;
		String uiApiCount = null;
		String dbApiCount = null;
		try {
			qsApiTotalTraffic = SQLExecuter.getQueryResults(query);

			if (qsApiTotalTraffic.numOfResult() == apiTrafficListUI.length) {
				int rowCount = qsApiTotalTraffic.numOfResult();
				for (int x = 0; x < rowCount;) {
					uiApiName = apiTrafficListUI[x][0];
					uiApiCount = apiTrafficListUI[x][1];
					dbApiCount = qsApiTotalTraffic.getValueFromCondition("trafficCount", "api", uiApiName);
					if (!uiApiCount.equals(dbApiCount)) {
						flag = false;
					}
					x++;
				}
				flag = true;
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating matching datae 'dbReturningData()' UICount : " + uiApiCount + " and DBCount : " + dbApiCount + e.getMessage());
			throw new Exception("Exception While Validating matching data 'dbReturningData()' UICount : " + uiApiCount + " and DBCount : " + dbApiCount + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Checks if is pie chart operator api traffic.
	 *
	 * @author SulakkhanaW
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param serviceProvider the service provider
	 * @param application the application
	 * @param api the api
	 * @return true, if is pie chart operator api traffic
	 * @throws Exception the exception
	 */
	public boolean isPieChartOperatorAPITraffic(String fromDate, String toDate, String serviceProvider, String application, String api) throws Exception {
		flag = false;
		ArrayList<String> apiList = new ArrayList<String>();
		WebElement select;
		try {
			select = getElement(UIType.Xpath, pieChartOperatorAPITraffic);
			List<WebElement> options = select.findElements(By.xpath(pieChartOperatorAPITraffic));
			for (WebElement option : options) {
				apiList.add(option.getText());
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating graphs data 'isPieGraph()'" + e.getMessage());
			throw new Exception("Exception While Validating graphs data 'isPieGraph()'" + e.getLocalizedMessage());
		}

		int count = apiList.size();
		String apiListDetails[][] = new String[count][2];
		for (int i = 0; i < count; i++) {
			String element = apiList.get(i);
			int openParanthis = element.indexOf("(") + 1;
			int closeParanthis = element.indexOf(")");
			String value = element.substring(openParanthis, closeParanthis);
			String apiName = element.substring(0, openParanthis - 1).trim();
			apiListDetails[i][0] = apiName;
			apiListDetails[i][1] = value;
		}
		try {
			flag = dbRetuningDataOperatorTraffic(apiListDetails, fromDate, toDate, serviceProvider, application, api);
		} catch (Exception e) {
			logger.debug("Exception While Validating matching data 'dbReturningData()'" + e.getMessage());
			throw new Exception("Exception While Validating matching data 'dbReturningData()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Db retuning data operator traffic.
	 *
	 * @author IsuruM
	 * @param apiTrafficListUI the api traffic list ui
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param serviceProvider the service provider
	 * @param application the application
	 * @param api the api
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean dbRetuningDataOperatorTraffic(String[][] apiTrafficListUI, String fromDate, String toDate, String serviceProvider, String application, String api) throws Exception {
		String query = String.format(SQLQuery.OPERATOR_API_TRAFFIC, fromDate, toDate, serviceProvider, application, api );
		QueryResult qsOperatorAPITraffic;
		String uiApiName = null;
		String uiApiCount = null;
		String dbApiCount = null;
		try {
			qsOperatorAPITraffic = SQLExecuter.getQueryResults(query);

			if (qsOperatorAPITraffic.numOfResult() == apiTrafficListUI.length) {
				int rowCount = qsOperatorAPITraffic.numOfResult();
				for (int x = 0; x < rowCount;) {
					uiApiName = apiTrafficListUI[x][0];
					uiApiCount = apiTrafficListUI[x][1];
					dbApiCount = qsOperatorAPITraffic.getValueFromCondition(
							"trafficCount", "operatorId", uiApiName);
					if (!uiApiCount.equals(dbApiCount)) {
						flag = false;
					}
					x++;
				}
				flag = true;
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating matching datae 'dbRetuningDataOperatorTraffic()' UICount : " + uiApiCount + " and DBCount : " + dbApiCount + e.getMessage());
			throw new Exception("Exception While Validating matching data 'dbRetuningDataOperatorTraffic() UICount : " + uiApiCount + " and DBCount : " + dbApiCount + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Checks if is customer care report.
	 *
	 * @author SulakkhanaW
	 * @param query the query
	 * @param column the column
	 * @param dbColumn the db column
	 * @return true, if is customer care report
	 * @throws Exception the exception
	 */
	public boolean isCustomerCareReport(String query, String column, String dbColumn)throws Exception {
		flag = false;
		try {
			QueryResult qsOperatorAPITraffic = SQLExecuter.getQueryResults(query);
			ArrayList<WebElement> pageination = new ArrayList<WebElement>(driver.findElements(By.xpath(reportPagination)));
			if (pageination.get(0).getText().contains("Prev")) {
				pageination.remove(0);
			}
			if (pageination.get(pageination.size() - 1).getText().contains("Next")) {
				pageination.remove(pageination.size() - 1);
			}
			int count = pageination.size();
			for (int i = 0; i < count;) {
				pageination.get(i).click();
				Thread.sleep(sleepTime);
				Table tableContent = getTable(UIType.Xpath, tblCustomerCare);
				int rowCount = tableContent.body().getAllRows().size();
				int columnCount = tableContent.head().getColumnIndex(column);
				int matchingColumnCount = tableContent.head().getColumnIndex("Date");
				ArrayList<WebElement> matchingRowElements = new ArrayList<WebElement>(tableContent.body().getCellsFromColumn(matchingColumnCount));
				/*if (!(rowCount == qsOperatorAPITraffic.getResultSize())){
					return flag = false;
				}*/
				for (int x = 0; x < rowCount;) {
					String rowValue = tableContent.body().getCellFromRowIndexColumnIndex(x, columnCount).getText();
					String rowMatchingValue = matchingRowElements.get(x).getText();
					String dbRowVale = qsOperatorAPITraffic.getValueFromCondition(dbColumn, "time", rowMatchingValue);
					if (!rowValue.equalsIgnoreCase(dbRowVale)) {
						return false;
					}
					x++;
				}
				i++;
				flag = true;
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating customer care report against DB 'isCustomerCareReport()'"+ e.getMessage());
			throw new Exception("Exception While Validating customer care report against DB 'isCustomerCareReport()"+ e.getMessage());
		}
		return flag;
	}

	/**
	 * Checks if is manager page usename password text boxes displayed.
	 *
	 * @author SulakkhanaW
	 * @return true, if is manager page usename password text boxes displayed
	 * @throws Exception the exception
	 */
	public boolean isManagerPageUsenamePasswordTextBoxesDisplayed()
			throws Exception {

		flag = false;
		logger.debug("Validating User name and password text boxes");
		Thread.sleep(sleepTime);
		try {
			if (getElement(txtUserName).isDisplayed() && getElement(txtPassword).isDisplayed()) {
				flag = true;
				logger.debug("Validating User name and password text boxes completed");
			} else {
				logger.debug("User name and password text boxes are Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating User name and password text boxes Title 'isManagerPageUsenamePasswordTextBoxesDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating User name and password text boxes Title 'isManagerPageUsenamePasswordTextBoxesDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Conver csv to xlsx.
	 *
	 * @author IsuruM
	 * @param path the path
	 * @param csvName the csv name
	 * @param xlsxName the xlsx name
	 */
	public void converCSVToXlsx(String path, String csvName, String xlsxName){
		CSVFileReader csv = new CSVFileReader();
		try {
			csv.convertCSVToXLSX(path, csvName, xlsxName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Checks if is transaction log data.
	 *
	 * @author IsuruM
	 * @param query the query
	 * @param xlsxName the xlsx name
	 * @param dbColumn the db column
	 * @param excelColumn the excel column
	 * @return true, if is transaction log data
	 * @throws Exception the exception
	 */
	public boolean isTransactionLogData(String query, String xlsxName, String dbColumn, String excelColumn) throws Exception {
		flag = false;
		try {
			QueryResult qsTransactionLog = SQLExecuter.getQueryResults(query);
			ExcelFileReader excelFileReader = new ExcelFileReader(xlsxName, "sheet1");
			List<List<String>> exceldata = excelFileReader.readExcelFile("sheet1");
			List<String> rows = qsTransactionLog.getAllValues("requestId");
			int rowCount = rows.size();
			for (int i = 0; i < rowCount; i++) {
				String matchingValue = rows.get(i);
				String dbValue = qsTransactionLog.getValueFromCondition(dbColumn, "requestId", matchingValue);
				String excelMatchingVal = matchingValue;
				String excelValue = excelFileReader.getDesiredValue(exceldata, excelColumn, "MIFE_ReferenceCode", excelMatchingVal);
				double dbval = 0,excelVal = 0;
				if(dbValue.contains(".")||excelValue.contains(".")){
					dbval = Double.parseDouble(dbValue);
					excelVal = Double.parseDouble(excelValue);
					if ((Math.abs(dbval - excelVal) >= 0.01)) {
						flag = false;
					}
				}
				if (!(dbValue.equalsIgnoreCase(excelValue))) {
					flag = false;
				}
			}
			flag = true;
		} catch (Exception e) {
			logger.debug("Exception While Validating Transaction log against DB 'isTransactionLogData()'"+ e.getMessage());
			throw new Exception("Exception While Validating Transaction log against DB 'isTransactionLogData()"+ e.getMessage());
		}
		return flag;
	}
	
	/**
	 * Checks if is report accessing.
	 *
	 * @author SulakkhanaW
	 * @param reportName the report name
	 * @return true, if is report accessing
	 * @throws Exception the exception
	 */
	public boolean isReportAccessing(String reportName) throws Exception {
		flag = false;
		ArrayList<String> reportList = new ArrayList<String>();
		WebElement select;
		try {
			select = getElement(UIType.Xpath, lblReports);
			List<WebElement> options = select.findElements(By.xpath(lblReports));
			for (WebElement option : options) {
				reportList.add(option.getText().trim());
			}
			logger.debug("Validating Report Access");
			Thread.sleep(sleepTime);
			if (reportList.contains(reportName)){
				flag = true;
				logger.debug("Validating Report Access completed");
			} else {
				logger.debug("Report is Not Matched");
			}
		} catch (InterruptedException e) {
			logger.debug("Exception While Validating Report Access 'isReportAccessing()'" + e.getMessage());
			throw new Exception("Exception While Validating Report Access 'isReportAccessing()" + e.getMessage());
		} 
		return flag;
	}
	
	/**
	 * Click on sp black list.
	 *
	 * @author SulakkhanaW
	 */
	public void clickOnSPBlackList(){
		logger.debug("Start clicking on SP Blacklist");
		getElement(lnkSPBlacklist).click();
		logger.debug("Clicked on SP Blacklist");
	}
	
	/**
	 * Select sp blacklist application.
	 *
	 * @author SulakkhanaW
	 * @param appname the appname
	 */
	public void selectSPBlacklistApplication(String appname){
		logger.debug("Start selecting on SP Blacklist application");
		getElement(ddSPBlacklistSelect).clearAndSendkeys(appname);
		logger.debug("Selected SP Blacklist application");
	}
	
	/**
	 * Click on black list.
	 *
	 * @author SulakkhanaW
	 */
	public void clickOnSPBlackListButton(){
		logger.debug("Start clicking on Blacklist");
		getElement(btnBlackList).click();
		logger.debug("Clicked on Blacklist");
	}
	
	/**
	 * Checks if is SP blacklist page displayed.
	 *
	 * @author SulakkhanaW
	 * @param title the title
	 * @return true, if is SP blacklist page displayed
	 * @throws Exception the exception
	 */
	public boolean isSPBlacklistPageDisplayed(String title)
			throws Exception {

		flag = false;
		logger.debug("Validating SP Blacklist Page");
		Thread.sleep(sleepTime);
		try {
			if (title.contains(getElement(lblSPBlackList).getText())) {
				flag = true;
				logger.debug("Validating SP Blacklist page completed");
			} else {
				logger.debug("SP Blacklist Page is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating SP Blacklist Page Title 'isSPBlacklistPageDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating SP Blacklist Page Title 'isSPBlacklistPageDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Checks if is SP blacklist api admin module page displayed.
	 *
	 * @author SulakkhanaW
	 * @param title the title
	 * @return true, if is SP blacklist api admin module page displayed
	 * @throws Exception the exception
	 */
	public boolean isSPBlacklistAPIAdminModulePageDisplayed(String title) throws Exception {

		flag = false;
		logger.debug("Validating SP Blacklist API Admin Module Page");
		Thread.sleep(sleepTime);
		try {
			if (title.contains(getElement(lblAdminModule).getText())) {
				flag = true;
				logger.debug("Validating SP Blacklist API Admin Module page completed");
			} else {
				logger.debug("SP Blacklist Page API Admin Module is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating SP Blacklist API Admin Module Page Title 'isSPBlacklistAPIAdminModulePageDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating SP Blacklist API Admin Module Page Title 'isSPBlacklistAPIAdminModulePageDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click admin module yes.
	 *
	 * @author SulakkhanaW
	 */
	public void clickAdminModuleYes(){
		logger.debug("Start clicking on admin module yes");
		getElement(btnAdminModuleYes).click();
		logger.debug("Clicked on admin module yes");
	}
	
	/**
	 * Checks if is CSV file exists.
	 *
	 * @author SulakkhanaW
	 * @param filePath the file path
	 * @return true, if is CSV file exists
	 * @throws Exception the exception
	 */
	public boolean isCSVFileExists(String filePath) throws Exception{
		logger.debug("Validating CSV file exists");
		flag = false;
		File file = new File(filePath);
		try {
			if (file.exists()){
				logger.debug("CSV file exists");
				file.delete();
				flag = true;
				logger.debug("CSV file deleted");
			} else {
				flag = true;
				logger.debug("CSV file is not exists");
			}
		} catch (Exception e) {
			logger.debug("Exception While deleteing CSV file 'isCSVFileExists()'" + e.getMessage());
			throw new Exception("Exception While deleteing CSV file 'isCSVFileExists()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * App row count southbound table.
	 *
	 * @author SulakkhanaW
	 * @param appName the app name
	 * @return the int
	 */
	private int appRowCountSouthboundTable(String appName){
		Table sbInvoiceTable = getTable(UIType.Xpath, sbMonthlyInvoiceTable);
		int appRows = sbInvoiceTable.body().getAllRows().size();
		int appRowNumber = sbInvoiceTable.body().getRowIndex(appName);
		for (int x = appRowNumber; x < appRows; x++){
			WebElement columnTotalAmount = sbInvoiceTable.body().getRow(x).findElement(By.xpath("./td[7]"));
			if (columnTotalAmount.getText().equals("Total Amount")){
				return x;
			}
		}
		return appRows;
	}

	/**
	 * App row count nb table.
	 *
	 * @author SulakkhanaW
	 * @param appName the app name
	 * @return the int
	 */
	private int appRowCountNbTable(String appName){
		Table invoiceTable = getTable(UIType.Xpath, nbMonthlyInvoiceTable);
		int appRows = invoiceTable.body().getAllRows().size();
		int appRowNumber = invoiceTable.body().getRowIndex(appName);
		for (int x = appRowNumber; x < appRows; x++){
			WebElement columnTotalAmount = invoiceTable.body().getRow(x).findElement(By.xpath("./td[7]"));
			if (columnTotalAmount.getText().equals("Total Amount")){
				return x;
			}
		}
		return appRows;
	}
	
	/**
	 * Gets the southbound total amount.
	 *
	 * @author SulakkhanaW
	 * @param columnName the column name
	 * @return the southbound total amount
	 */
	public String getSouthboundTotalAmount(String columnName){
		Table sbInvoiceTable = getTable(UIType.Xpath, sbMonthlyInvoiceTable);
		String returnValue = null;
		int rowCountTotalAmount = sbInvoiceTable.body().getAllRows().size();
		WebElement rowTotalAmount = sbInvoiceTable.body().getRow(rowCountTotalAmount - 1);
		if(rowTotalAmount != null){
			switch (columnName) {
			case "Usage Charge":
				returnValue = rowTotalAmount.findElement(By.xpath("./td[10]")).getText().trim();
				break;
				
			case "Tax":
				returnValue = rowTotalAmount.findElement(By.xpath("./td[11]")).getText().trim();
				break;
				
			case "Credit":
				returnValue = rowTotalAmount.findElement(By.xpath("./td[12]")).getText().trim();
				break;
				
			case "Grand Total":
				returnValue = rowTotalAmount.findElement(By.xpath("./td[13]")).getText().trim();
				break;
								
			default:
				break;
			}
		}
		return returnValue;
	}
	
	/**
	 * Gets the nb total amount.
	 *
	 * @author SulakkhanaW
	 * @param appName the app name
	 * @param columnName the column name
	 * @return the nb total amount
	 */
	public String getNbTotalAmount(String appName, String columnName){
		Table invoiceTable = getTable(UIType.Xpath, nbMonthlyInvoiceTable);
		String returnValue = null;
		int rowCountTotalAmount = appRowCountNbTable(appName);
		WebElement rowTotalAmount = invoiceTable.body().getRow(rowCountTotalAmount);
		if(rowTotalAmount != null){
			switch (columnName) {
			case "Usage Charge":
				returnValue = rowTotalAmount.findElement(By.xpath("./td[8]")).getText().trim();
				break;
				
			case "Tax":
				returnValue = rowTotalAmount.findElement(By.xpath("./td[9]")).getText().trim();
				break;
				
			case "Credit":
				returnValue = rowTotalAmount.findElement(By.xpath("./td[10]")).getText().trim();
				break;
				
			case "Grand Total":
				returnValue = rowTotalAmount.findElement(By.xpath("./td[11]")).getText().trim();
				break;
								
			default:
				break;
			}
		}
		return returnValue;
	}
	
	/**
	 * Gets the southbound invoic value.
	 *
	 * @author SulakkhanaW
	 * @param appName the app name
	 * @param apiName the api name
	 * @param operator the operator
	 * @param operation the operation
	 * @param columnName the column name
	 * @return the southbound invoic value
	 */
	public String getSouthboundInvoicValue(String appName,String apiName,String operator, String operation,String columnName){
		String returnValue = null;
		Table sbInvoiceTable = getTable(UIType.Xpath, sbMonthlyInvoiceTable);
		int appRowNumber = sbInvoiceTable.body().getRowIndex(appName);
		int appRowCount = appRowCountSouthboundTable(appName);
		for (int x = appRowNumber; x <= appRowCount; x++){
			WebElement columnApi = sbInvoiceTable.body().getRow(x).findElement(By.xpath("./td[3]"));
			if (columnApi.getText().equals(apiName)){
				for (int y = x; y <= appRowCount; y++){
					WebElement columnOperator = sbInvoiceTable.body().getRow(y).findElement(By.xpath("./td[5]"));
					if (columnOperator.getText().equals(operator)){
						for (int z = y; y <= appRowCount; z++){
							WebElement columnOperation = sbInvoiceTable.body().getRow(z).findElement(By.xpath("./td[6]"));
							if (columnOperation.getText().equals(operation)){
								WebElement currentRow = sbInvoiceTable.body().getRow(z);
								if(currentRow != null){
									switch (columnName) {
									case "Charging Plan":
										return returnValue = currentRow.findElement(By.xpath("./td[7]")).getText().trim();
										
									case "Count":
										return returnValue = currentRow.findElement(By.xpath("./td[8]")).getText().trim();
										
									case "Operator Charges":
										return returnValue = currentRow.findElement(By.xpath("./td[9]")).getText().trim();
										
									case "Usage Charge":
										return returnValue = currentRow.findElement(By.xpath("./td[10]")).getText().trim();
										
									case "Tax":
										return returnValue = currentRow.findElement(By.xpath("./td[11]")).getText().trim();
									
									case "Credit":
										return returnValue = currentRow.findElement(By.xpath("./td[12]")).getText().trim();

									case "Grand Total":
										return returnValue = currentRow.findElement(By.xpath("./td[13]")).getText().trim();
													
									default:
										break;
									}
								}
							}
						}
					}
				}
			}
		}
		return returnValue;
	}

	/**
	 * Gets the nb value invoice.
	 *
	 * @author SulakkhanaW
	 * @param appName the app name
	 * @param apiName the api name
	 * @param operation the operation
	 * @param columnName the column name
	 * @return the nb value invoice
	 */
	public String getNbValueInvoice(String appName,String apiName,String operation,String columnName){
		String returnValue = null;
		Table invoiceTable = getTable(UIType.Xpath, nbMonthlyInvoiceTable);
		int appRowNumber = invoiceTable.body().getRowIndex(appName);
		int appRowCount = appRowCountNbTable(appName);
		for (int x = appRowNumber; x <= appRowCount; x++){
			WebElement columnApi = invoiceTable.body().getRow(x).findElement(By.xpath("./td[3]"));
			if (columnApi.getText().equals(apiName)){
				for (int y = x; x <= appRowCount; y++){
					WebElement columnOperation = invoiceTable.body().getRow(y).findElement(By.xpath("./td[5]"));
					if (columnOperation.getText().equals(operation)){
						WebElement currentRow = invoiceTable.body().getRow(y);
						if (currentRow != null) {
							switch (columnName) {
							case "Charging Plan":
								return returnValue = currentRow.findElement(By.xpath("./td[6]")).getText().trim();
						
							case "Count":
								return returnValue = currentRow.findElement(By.xpath("./td[7]")).getText().trim();
						
							case "Usage Charge":
								return returnValue = currentRow.findElement(By.xpath("./td[8]")).getText().trim();
						
							case "Tax":
								return returnValue = currentRow.findElement(By.xpath("./td[9]")).getText().trim();
						
							case "Credit":
								return returnValue = currentRow.findElement(By.xpath("./td[10]")).getText().trim();

							case "Grand Total":
								return returnValue = currentRow.findElement(By.xpath("./td[11]")).getText().trim();
									
							default:
								break;
							}
						}
					}
				}
			}
		}
		return returnValue;
	}
	
	/**
	 * Gets the nb ui table data.
	 *
	 * @author SulakkhanaW
	 * @return the nb ui table data
	 */
	public List<List<String>> getNbUITableData(){
		WebElement invoiceTableNB = driver.findElement(By.xpath(nbMonthlyInvoiceTable));
		Table invoiceTable = getTable(UIType.Xpath, nbMonthlyInvoiceTable);
		int columnCount = invoiceTable.head().getAllColumn().size();
		int rowCount = invoiceTable.body().getAllRows().size();
		int allRows = rowCount + 1;
		List<List<String>> sheetdata = new ArrayList<List<String>>();
		List<String> headerData = new ArrayList<String>();
		for (int a = 0; a < columnCount; a++){
			int colCount = a + 1;
			String headerPath = "./thead/tr/th[" + colCount + "]";
			String headerValue = invoiceTableNB.findElement(By.xpath(headerPath)).getText();
			headerData.add(headerValue);
		}
		sheetdata.add(headerData);
		for (int x = 1; x < allRows; x++){
			List<String> bodyData = new ArrayList<String>();
			for (int y = 0; y < columnCount; y++){
				int colCount = y + 1;
				String bodyPath = "./tbody/tr[" + x + "]/td[" + colCount + "]";
				String bodyValue = invoiceTableNB.findElement(By.xpath(bodyPath)).getText();
				bodyData.add(bodyValue);
			}
			sheetdata.add(bodyData);
		}
		return sheetdata;
	}
	
	/**
	 * Gets the sb ui table data.
	 *
	 * @author SulakkhanaW
	 * @return the sb ui table data
	 */
	public List<List<String>> getSbUITableData(){
		WebElement invoiceTableNB = driver.findElement(By.xpath(sbMonthlyInvoiceTable));
		Table invoiceTable = getTable(UIType.Xpath, sbMonthlyInvoiceTable);
		int columnCount = invoiceTable.head().getAllColumn().size();
		int rowCount = invoiceTable.body().getAllRows().size();
		int allRows = rowCount + 1;
		List<List<String>> sheetdata = new ArrayList<List<String>>();
		List<String> headerData = new ArrayList<String>();
		for (int a = 0; a < columnCount; a++){
			int colCount = a + 1;
			String headerPath = "./thead/tr/th[" + colCount + "]";
			String headerValue = invoiceTableNB.findElement(By.xpath(headerPath)).getText();
			headerData.add(headerValue);
		}
		sheetdata.add(headerData);
		for (int x = 1; x < allRows; x++){
			List<String> bodyData = new ArrayList<String>();
			for (int y = 0; y < columnCount; y++){
				int colCount = y + 1;
				String bodyPath = "./tbody/tr[" + x + "]/td[" + colCount + "]";
				String bodyValue = invoiceTableNB.findElement(By.xpath(bodyPath)).getText();
				bodyData.add(bodyValue);
			}
			sheetdata.add(bodyData);
		}
		return sheetdata;
	}
	
	/**
	 * Gets the app name from array.
	 *
	 * @author SulakkhanaW
	 * @param data the data
	 * @return the app name from array
	 */
	public List<String> getAppNameFromArray(List<List<String>> data){
		int lastRow = data.size();
		List<String> appNames = new ArrayList<String>();
		for (int x = 1; x < lastRow; x++){
			if (!data.get(x).get(1).isEmpty()){
				appNames.add(data.get(x).get(1));
			}
		}
		return appNames;
	}
	
	/**
	 * Gets the app start row.
	 *
	 * @author SulakkhanaW
	 * @param appName the app name
	 * @param data the data
	 * @return the app start row
	 */
	public int getAppStartRow(String appName, List<List<String>> data){
		int appStartRow = 0;
		int rowCount = data.size();
		for (int x = 0; x < rowCount; x++){
			if (data.get(x).get(1).equalsIgnoreCase(appName)){
				return appStartRow = x;
			}
		}
		return appStartRow;
	}
	
	/**
	 * Gets the app end row.
	 *
	 * @author SulakkhanaW
	 * @param startRow the start row
	 * @param data the data
	 * @return the app end row
	 */
	public int getAppEndRow(int startRow, List<List<String>> data){
		int appEndRow = 0;
		int rowCount = data.size();
		for (int x = startRow; x < rowCount; x++){
			if (data.get(x).get(6).equalsIgnoreCase("Total Amount")){
				return appEndRow = x;
			}
		}
		return appEndRow;
	}
	
	/**
	 * Gets the operation row num.
	 *
	 * @author SulakkhanaW
	 * @param opration the opration
	 * @param startRow the start row
	 * @param endRow the end row
	 * @param data the data
	 * @return the operation row num
	 */
	public int getOperationRowNum(String opration, int startRow, int endRow, List<List<String>> data){
		int oprationRowNum = 0;
		for (int x = startRow; x <= endRow; x++){
			if (data.get(x).get(4).equalsIgnoreCase(opration)){
				return oprationRowNum = x;
			}
		}
		return oprationRowNum;
	}
	
	/**
	 * Gets the sb app end row.
	 *
	 * @author SulakkhanaW
	 * @param appStartRow the app start row
	 * @param data the data
	 * @return the sb app end row
	 */
	private int getSbAppEndRow(int appStartRow, List<List<String>> data){
		int appDetailsEndRow = 0;
		int rowCount = data.size();
		appStartRow++;
		int lastRow = rowCount - 1;
		for (int s = appStartRow; s < rowCount; s++){
			
			if ((!data.get(s).get(1).trim().equals(""))|s==lastRow){
				if (s == lastRow){
					s++;
				}
				return appDetailsEndRow = s - 1;
			}
		}
		return appDetailsEndRow;
	}
	
	/**
	 * Gets the sb operation row num.
	 *
	 * @author SulakkhanaW
	 * @param operator the operator
	 * @param opration the opration
	 * @param startRow the start row
	 * @param endRow the end row
	 * @param data the data
	 * @return the sb operation row num
	 */
	public int getSbOperationRowNum(String operator, String opration, int startRow, int endRow, List<List<String>> data){
		int oprationRowNum = 0;
		for (int x = startRow; x <= endRow; x++){
			if (data.get(x).get(4).equalsIgnoreCase(operator) && data.get(x).get(5).equalsIgnoreCase(opration)){
				return oprationRowNum = x;
			}
		}
		return oprationRowNum;
	}
	
	/**
	 * Gets the operator start row.
	 *
	 * @author SulakkhanaW
	 * @param startRow the start row
	 * @param endRow the end row
	 * @param operator the operator
	 * @param operation the operation
	 * @param afterExcel the after excel
	 * @return the operator start row
	 */
	private int getOperatorStartRow(int startRow, int endRow, String operator, String operation, List<List<String>> afterExcel){
		int start = 0;
		for (int x = startRow; x <= endRow; x++){
			if (afterExcel.get(x).get(4).equalsIgnoreCase(operator) && afterExcel.get(x).get(5).equalsIgnoreCase(operation)){
				return start = x;
			}
		}
		return start;
	}
	
	/**
	 * Gets the operator last row.
	 *
	 * @author SulakkhanaW
	 * @param operatorStartRow the operator start row
	 * @param appEndRow the app end row
	 * @param afterExcel the after excel
	 * @return the operator last row
	 */
	private int getOperatorLastRow(int operatorStartRow, int appEndRow, List<List<String>> afterExcel){
		int endRow = 0;
		int rowCount = afterExcel.size();
		int lastRow = rowCount - 1;
		operatorStartRow++;
		for (int s = operatorStartRow; s < rowCount; s++){
			if ((!afterExcel.get(s).get(4).trim().equals(""))|s==lastRow){
				return endRow = s - 1;
			}
		}
		return endRow;
	}
	
	/**
	 * Sb monthly invoice difference.
	 *
	 * @author SulakkhanaW
	 * @param beforeExcel the before excel
	 * @param afterExcel the after excel
	 * @return the list
	 */
	public List<List<String>> sbMonthlyInvoiceDifference(List<List<String>> beforeExcel, List<List<String>> afterExcel) {
		int beforeExcelLastRow = beforeExcel.size();
		int afterExcelLastRow = afterExcel.size();
		List<String> appNames = getAppNameFromArray(beforeExcel);
		List<List<String>> sheetdata = new ArrayList<List<String>>();
		sheetdata.add(beforeExcel.get(0));
		int appCount = appNames.size();
		if (beforeExcelLastRow == afterExcelLastRow) {
			for (int x = 0; x < appCount; x++) {
				int startRowBeforeExcel = getAppStartRow(appNames.get(x), beforeExcel);
				int startRowAfterExcel = getAppStartRow(appNames.get(x), afterExcel);
				int endRowBeforeExcel = getSbAppEndRow(startRowBeforeExcel, beforeExcel);
				int endRowAfterExcel = getSbAppEndRow(startRowAfterExcel, afterExcel);
				int operatorStartRowAfter = 0;
				int operatorEndRowAfter = 0;
				for (int y = startRowBeforeExcel; y <= endRowBeforeExcel; y++) {
					List<String> bodyData = new ArrayList<String>();
					bodyData.add(beforeExcel.get(y).get(0));
					bodyData.add(beforeExcel.get(y).get(1));
					bodyData.add(beforeExcel.get(y).get(2));
					bodyData.add(beforeExcel.get(y).get(3));
					bodyData.add(beforeExcel.get(y).get(4));
					bodyData.add(beforeExcel.get(y).get(5));
					bodyData.add(beforeExcel.get(y).get(6));
					String operator = beforeExcel.get(y).get(4);
					String operation = beforeExcel.get(y).get(5);
					int afterExcelOperationRow = 0;
					if (!operator.equals("")){
						operatorStartRowAfter = getOperatorStartRow(startRowAfterExcel, endRowAfterExcel, operator, operation, afterExcel);
						operatorEndRowAfter = getOperatorLastRow(operatorStartRowAfter, endRowAfterExcel, afterExcel);
					}
					if (beforeExcel.get(y).get(8).equalsIgnoreCase("Total Amount")){
						afterExcelOperationRow = afterExcelLastRow - 1;
					} else {
						afterExcelOperationRow = getSbOperationRowNum(operator, operation, operatorStartRowAfter, operatorEndRowAfter, afterExcel);
					}
					if (beforeExcel.get(y).get(6).equalsIgnoreCase(afterExcel.get(afterExcelOperationRow).get(6))) {
						for (int a = 7; a <= 12; a++) {
							String beforeCellString = beforeExcel.get(y).get(a);
							String afterCellString = afterExcel.get(afterExcelOperationRow).get(a);
							if (!beforeCellString.equalsIgnoreCase("Total Amount")) {
								int endIndex = beforeCellString.indexOf(" ");
								String toBeRepalcedBeforeCell = beforeCellString.substring(0, endIndex + 1);
								String toBeRepalcedAfterCell = afterCellString.substring(0, endIndex + 1);
								if (toBeRepalcedBeforeCell.equalsIgnoreCase(toBeRepalcedAfterCell)) {
									String valueBefore = beforeCellString.replace(toBeRepalcedBeforeCell, "");
									String valueAfter = afterCellString.replace(toBeRepalcedAfterCell, "");
									String nullValue = "";
									if (valueBefore.isEmpty() && valueAfter.isEmpty()) {
										bodyData.add(nullValue);
									} else {
										double beforeCell = Double.parseDouble(valueBefore);
										double afterCell = Double.parseDouble(valueAfter);
										double priceDiff = afterCell - beforeCell;
										String concatPrice = toBeRepalcedBeforeCell + Double.toString(priceDiff);
										bodyData.add(concatPrice);
									}
								} else {
									String price = "priceTypeMismatch";
									bodyData.add(price);
								}
							} else {
								bodyData.add(beforeCellString);
							}
						}
					}
					sheetdata.add(bodyData);
				}
			}
		}
		return sheetdata;
	}
	
	/**
	 * Checks if is sb difference match.
	 *
	 * @author SulakkhanaW
	 * @param diffUi the diff ui
	 * @param diffManual the diff manual
	 * @return true, if is sb difference match
	 * @throws Exception the exception
	 */
	public boolean isSbDifferenceMatch(List<List<String>> diffUi, List<List<String>> diffManual) throws Exception{
		flag = false;
		int uiLastRowNum = diffUi.size();
		int manualLastRowNum = diffManual.size();
		List<String> appNames = getAppNameFromArray(diffUi);
		int appCount = appNames.size();
		try {
			if (uiLastRowNum == manualLastRowNum){
				logger.debug("Monthly Invoice SB diff row numbers matched");
				for (int x = 0; x < appCount; x++){
					int startRowDiffUi = getAppStartRow(appNames.get(x), diffUi);
					int startRowDiffManual = getAppStartRow(appNames.get(x), diffManual);
					int endRowDiffUi = getSbAppEndRow(startRowDiffUi, diffUi);
					int endRowDiffManual = getSbAppEndRow(startRowDiffManual, diffManual);
					int operatorStartRowAfter = 0;
					int operatorEndRowAfter = 0;
					for (int y = startRowDiffUi; y <= endRowDiffUi; y++){
						String operator = diffUi.get(y).get(4);
						String operation = diffUi.get(y).get(5);
						int diffManualOperationRow = 0;
						if (!operator.equals("")){
							operatorStartRowAfter = getOperatorStartRow(startRowDiffManual, endRowDiffManual, operator, operation, diffManual);
							operatorEndRowAfter = getOperatorLastRow(operatorStartRowAfter, endRowDiffManual, diffManual);
						}
						if (diffUi.get(y).get(8).equalsIgnoreCase("Total Amount")){
							diffManualOperationRow = manualLastRowNum - 1;
						} else {
							diffManualOperationRow = getSbOperationRowNum(operator, operation, operatorStartRowAfter, operatorEndRowAfter, diffManual);
						}
						for (int a = 7; a <= 12; a++) {
							String beforeCellString = diffUi.get(y).get(a);
							String afterCellString = diffManual.get(diffManualOperationRow).get(a);
							if (!beforeCellString.equalsIgnoreCase(afterCellString)){
								flag = false;
								logger.debug("Monthly Invoice NB diff mismatched - " + beforeCellString + " And " + afterCellString + ", Row number - " + y + " Column Number - " + a);
								return flag;
							}
							else {
								logger.debug("Monthly Invoice NB diff matched, Row number - " + y + " Column Number - " + a);
								flag = true;
							}
						}
					}
				}
			} else {
				logger.debug("Monthly Invoice SB diff row numbers mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating two excel sheets 'isSbDifferenceMatch()'" + e.getMessage());
			throw new Exception("Exception While Validating two excel sheets 'isSbDifferenceMatch()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Nb monthly invoice difference.
	 *
	 * @author SulakkhanaW
	 * @param beforeExcel the before excel
	 * @param afterExcel the after excel
	 * @return the list
	 */
	public List<List<String>> nbMonthlyInvoiceDifference(List<List<String>> beforeExcel, List<List<String>> afterExcel){
		int beforeExcelLastRow = beforeExcel.size();
		int afterExcelLastRow = afterExcel.size();
		List<String> appNames = getAppNameFromArray(beforeExcel);
		List<List<String>> sheetdata = new ArrayList<List<String>>();
		sheetdata.add(beforeExcel.get(0));
		int appCount = appNames.size();
		if (beforeExcelLastRow == afterExcelLastRow){
			for (int x = 0; x < appCount; x++){
				int startRowBeforeExcel = getAppStartRow(appNames.get(x), beforeExcel);
				int startRowAfterExcel = getAppStartRow(appNames.get(x), afterExcel);
				int endRowBeforeExcel = getSbAppEndRow(startRowBeforeExcel, beforeExcel);
				int endRowAfterExcel = getSbAppEndRow(startRowAfterExcel, afterExcel);
				for (int y = startRowBeforeExcel; y <= endRowBeforeExcel; y++){
					List<String> bodyData = new ArrayList<String>();
					bodyData.add(beforeExcel.get(y).get(0));
					bodyData.add(beforeExcel.get(y).get(1));
					bodyData.add(beforeExcel.get(y).get(2));
					bodyData.add(beforeExcel.get(y).get(3));
					bodyData.add(beforeExcel.get(y).get(4));
					bodyData.add(beforeExcel.get(y).get(5));
					String operation = beforeExcel.get(y).get(4);
					int afterExcelOperationRow = getOperationRowNum(operation, startRowAfterExcel, endRowAfterExcel, afterExcel);
					for (int a = 6; a <= 10; a++){
						String beforeCellString = beforeExcel.get(y).get(a);
						String afterCellString = afterExcel.get(afterExcelOperationRow).get(a);
						if (!beforeCellString.equalsIgnoreCase("Total Amount")) {
							int endIndex = beforeCellString.indexOf(" ");
							String toBeRepalcedBeforeCell = beforeCellString.substring(0, endIndex + 1);
							String toBeRepalcedAfterCell = afterCellString.substring(0, endIndex + 1);
							if (toBeRepalcedBeforeCell.equalsIgnoreCase(toBeRepalcedAfterCell)) {
								String valueBefore = beforeCellString.replace(toBeRepalcedBeforeCell, "");
								String valueAfter = afterCellString.replace(toBeRepalcedAfterCell, "");
								String nullValue = "";
								if (valueBefore.isEmpty() && valueAfter.isEmpty()) {
									bodyData.add(nullValue);
								} else {
									double beforeCell = Double.parseDouble(valueBefore);
									double afterCell = Double.parseDouble(valueAfter);
									double priceDiff = afterCell - beforeCell;
									String concatPrice = toBeRepalcedBeforeCell + Double.toString(priceDiff);
									bodyData.add(concatPrice);
								}
							} else {
								String price = "priceTypeMismatch";
								bodyData.add(price);
							}
						} else {
							bodyData.add(beforeCellString);
						}
					}
					sheetdata.add(bodyData);
				}
			}
		}
		return sheetdata;
	}
	
	/**
	 * Checks if is difference match.
	 *
	 * @author SulakkhanaW
	 * @param diffUi the diff ui
	 * @param diffManual the diff manual
	 * @return true, if is difference match
	 * @throws Exception the exception
	 */
	public boolean isDifferenceMatch(List<List<String>> diffUi, List<List<String>> diffManual) throws Exception{
		flag = false;
		int uiLastRowNum = diffUi.size();
		int manualLastRowNum = diffManual.size();
		List<String> appNames = getAppNameFromArray(diffUi);
		int appCount = appNames.size();
		try {
			if (uiLastRowNum == manualLastRowNum){
				logger.debug("Monthly Invoice NB diff row numbers matched");
				for (int x = 0; x < appCount; x++){
					int startRowDiffUi = getAppStartRow(appNames.get(x), diffUi);
					int startRowDiffManual = getAppStartRow(appNames.get(x), diffManual);
					int endRowDiffUi = getSbAppEndRow(startRowDiffUi, diffUi);
					int endRowDiffManual = getSbAppEndRow(startRowDiffManual, diffManual);
					for (int y = startRowDiffUi; y <= endRowDiffUi; y++){
						String operation = diffUi.get(y).get(4);
						int diffManualOperationRow = getOperationRowNum(operation, startRowDiffManual, endRowDiffManual, diffManual);
						for (int a = 6; a <= 10; a++){
							String beforeCellString = diffUi.get(y).get(a);
							String afterCellString = diffManual.get(diffManualOperationRow).get(a);
							if (!beforeCellString.equalsIgnoreCase(afterCellString)){
								flag = false;
								return flag;
							}
							else {
								logger.debug("Monthly Invoice NB diff matched");
								flag = true;
							}
						}
					}
				}
			}else {
				logger.debug("Monthly Invoice NB diff row numbers mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating two excel sheets 'isDifferenceMatch()'" + e.getMessage());
			throw new Exception("Exception While Validating two excel sheets 'isDifferenceMatch()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	
	/**
	 * Write string ary to xlsx.
	 *
	 * @author SulakkhanaW
	 * @param fileName the file name
	 * @param array the array
	 */
	public void writeStringAryToXlsx(String fileName, List<List<String>> array){
		try {
				ExcelFileWriter excelWriter = new ExcelFileWriter();
				excelWriter.writeFileUsingArray(fileName, array);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Compare string.
	 *
	 * @author SulakkhanaW
	 * @param valueOne the value one
	 * @param valueTwo the value two
	 * @return true, if successful
	 */
	public boolean compareString(String valueOne, String valueTwo){
		return valueOne.equalsIgnoreCase(valueTwo);
	}
	
	/**
	 * Checks if is validate numbers.
	 *
	 * @author SulakkhanaW
	 * @param valueOne the value one
	 * @param valueTwo the value two
	 * @return true, if is validate numbers
	 * @throws Exception the exception
	 */
	public boolean isValidateNumbers(String valueOne, String valueTwo) throws Exception{
		flag = false;
		double valOne = Double.parseDouble(valueOne);
		double valTwo = Double.parseDouble(valueTwo);
		try {
			if (Math.abs(valOne - valTwo) <= 0.01){
				flag = true;
			}
			else {
				flag = false;
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating two numbers 'isValidateNumbers()'" + e.getMessage());
			throw new Exception("Exception While Validating two numbers 'isValidateNumbers()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Removes the currency type.
	 *
	 * @author SulakkhanaW
	 * @param value the value
	 * @return the string
	 */
	public String removeCurrencyType(String value){
		int endIndex = value.indexOf(" ");
		int startIndex = 0;
		String toBeRepalced = value.substring(startIndex, endIndex + 1);
		return value.replace(toBeRepalced, "");
	}
	
	/**
	 * Gets the app row number.
	 *
	 * @author SulakkhanaW
	 * @param exceldata the exceldata
	 * @param appName the app name
	 * @param rowCount the row count
	 * @return the app row number
	 */
	private int getAppRowNumber(List<List<String>> exceldata, String appName, int rowCount){
		int appNameRowNumber = 0;
		for (int a = 0; a < rowCount; a++){
			if (exceldata.get(a).get(1).trim().equalsIgnoreCase(appName)){
				appNameRowNumber = a;
			}
		}
		return appNameRowNumber;
	}
	
	/**
	 * Gets the app details end row.
	 *
	 * @author SulakkhanaW
	 * @param exceldata the exceldata
	 * @param appNameRowNumber the app name row number
	 * @param rowCount the row count
	 * @return the app details end row
	 */
	private int getAppDetailsEndRow(List<List<String>> exceldata, int appNameRowNumber, int rowCount){
		int appDetailsEndRow = 0;
		appNameRowNumber++;
		int lastRow = rowCount - 1;
		for (int s = appNameRowNumber; s < rowCount; s++){
			
			if ((!exceldata.get(s).get(1).trim().equals(""))|s==lastRow){
				if (s == lastRow){
					s++;
				}
				return appDetailsEndRow = s - 1;
			}
		}
		return appDetailsEndRow;
	}
	
	/**
	 * Gets the api row number.
	 *
	 * @author SulakkhanaW
	 * @param exceldata the exceldata
	 * @param appNameRowNumber the app name row number
	 * @param appDetailsEndRow the app details end row
	 * @param apiName the api name
	 * @return the api row number
	 */
	private int getApiRowNumber(List<List<String>> exceldata, int appNameRowNumber, int appDetailsEndRow, String apiName){
		int apiRowNumber = 0;
		for (int x = appNameRowNumber; x <= appDetailsEndRow; x++){
			if (exceldata.get(x).get(2).trim().equalsIgnoreCase(apiName)){
				apiRowNumber = x;
			}
		}
		return apiRowNumber;
	}
	
	/**
	 * Gets the operation row number.
	 *
	 * @author SulakkhanaW
	 * @param exceldata the exceldata
	 * @param apiRowNumber the api row number
	 * @param appDetailsEndRow the app details end row
	 * @param operation the operation
	 * @return the operation row number
	 */
	private int getOperationRowNumber(List<List<String>> exceldata, int apiRowNumber, int appDetailsEndRow, String operation){
		int operationRowNumber = 0;
		for (int y = apiRowNumber; y <= appDetailsEndRow; y++){
			if (exceldata.get(y).get(4).trim().equalsIgnoreCase(operation)){
				operationRowNumber = y;
			}
		}
		return operationRowNumber;
	}
	
	/**
	 * Gets the value from nb excel.
	 *
	 * @author SulakkhanaW
	 * @param appName the app name
	 * @param apiName the api name
	 * @param operation the operation
	 * @param columnName the column name
	 * @param xlsxName the xlsx name
	 * @return the value from nb excel
	 * @throws Exception the exception
	 */
	public String getValueFromNBExcel(String appName,String apiName,String operation,String columnName, String xlsxName) throws Exception{
		ExcelFileReader excelFileReader = new ExcelFileReader(xlsxName, "sheet1");
		List<List<String>> exceldata = excelFileReader.readExcelFile("sheet1");
		String returnValue = null;
		int rowCount = exceldata.size();
		int appNameRowNumber = getAppRowNumber(exceldata, appName, rowCount);
		int appDetailsEndRow = getAppDetailsEndRow(exceldata, appNameRowNumber, rowCount);
		int apiRowNumber = getApiRowNumber(exceldata, appNameRowNumber, appDetailsEndRow, apiName);
		int operationRowNumber = getOperationRowNumber(exceldata, apiRowNumber, appDetailsEndRow, operation);
		switch (columnName) {
		case "Plan":
			return returnValue = exceldata.get(operationRowNumber).get(5);

		case "Count":
			return returnValue = exceldata.get(operationRowNumber).get(11);

		case "Usage Charge":
			return returnValue = exceldata.get(operationRowNumber).get(13);

		case "Tax":
			return returnValue = exceldata.get(operationRowNumber).get(14);

		case "Credit":
			return returnValue = exceldata.get(operationRowNumber).get(15);

		case "Grand Total":
			return returnValue = exceldata.get(operationRowNumber).get(16);

		default:
			break;
		}
		return returnValue;
	}
	
	/**
	 * Gets the value from sb excel.
	 *
	 * @author SulakkhanaW
	 * @param appName the app name
	 * @param apiName the api name
	 * @param operator the operator
	 * @param operation the operation
	 * @param columnName the column name
	 * @param xlsxName the xlsx name
	 * @return the value from sb excel
	 * @throws Exception the exception
	 */
	public String getValueFromSBExcel(String appName,String apiName,String operator, String operation,String columnName, String xlsxName) throws Exception{
		ExcelFileReader excelFileReader = new ExcelFileReader(xlsxName, "sheet1");
		List<List<String>> exceldata = excelFileReader.readExcelFile("sheet1");
		String returnValue = null;
		int rowCount = exceldata.size();
		int appNameRowNumber = getAppRowNumber(exceldata, appName, rowCount);
		int appDetailsEndRow = getAppDetailsEndRow(exceldata, appNameRowNumber, rowCount);
		int apiRowNumber = getApiRowNumber(exceldata, appNameRowNumber, appDetailsEndRow, apiName);
		int operatorRowNumber = getSbOperatorRowNumber(exceldata, apiRowNumber, appDetailsEndRow, operator);
		int operationRowNumber = getSbOPerationRowNumber(exceldata, operatorRowNumber, appDetailsEndRow, operation);
		switch (columnName) {
		case "Plan":
			return returnValue = exceldata.get(operationRowNumber).get(6);

		case "Count":
			return returnValue = exceldata.get(operationRowNumber).get(12);

		case "Operator Charges":
			return returnValue = exceldata.get(operationRowNumber).get(13);
			
		case "Usage Charge":
			return returnValue = exceldata.get(operationRowNumber).get(14);

		case "Tax":
			return returnValue = exceldata.get(operationRowNumber).get(15);

		case "Credit":
			return returnValue = exceldata.get(operationRowNumber).get(16);

		case "Grand Total":
			return returnValue = exceldata.get(operationRowNumber).get(17);

		default:
			break;
		}
		return returnValue;
	}
	
	/**
	 * Gets the sb o peration row number.
	 *
	 * @author SulakkhanaW
	 * @param exceldata the exceldata
	 * @param operatorRowNumber the operator row number
	 * @param appDetailsEndRow the app details end row
	 * @param operation the operation
	 * @return the sb o peration row number
	 */
	private int getSbOPerationRowNumber(List<List<String>> exceldata, int operatorRowNumber, int appDetailsEndRow, String operation){
		int operationNumber = 0;
		for (int x = operatorRowNumber; x <= appDetailsEndRow; x++){
			if (exceldata.get(x).get(5).trim().equalsIgnoreCase(operation)){
				return operationNumber = x;
			}
		}
		return operationNumber;
	}
	
	/**
	 * Gets the sb operator row number.
	 *
	 * @author SulakkhanaW
	 * @param exceldata the exceldata
	 * @param apiRowNumber the api row number
	 * @param appDetailsEndRow the app details end row
	 * @param operator the operator
	 * @return the sb operator row number
	 */
	private int getSbOperatorRowNumber(List<List<String>> exceldata, int apiRowNumber, int appDetailsEndRow, String operator){
		int operatorNumber = 0;
		for (int x = apiRowNumber; x <= appDetailsEndRow; x++){
			if (exceldata.get(x).get(4).trim().equalsIgnoreCase(operator)){
				return operatorNumber = x;
			}
		}
		return operatorNumber;
	}

	/**
	 * Checks if is subscription rates tables updated.
	 *
	 * @author JayaniP
	 * @param query the query
	 * @return true, if is subscription rates tables updated
	 * @throws Exception the exception
	 */
	public boolean isSubscriptionRatesTablesUpdated(String query) throws Exception{
		logger.debug("Validating subscription_rates table");
		flag = false;
		QueryResult qsTransactionLog = SQLExecuter.getQueryResults(query);
		try {
			if(qsTransactionLog.isOnlyOneRecord()){
				flag = true;
				logger.debug("subscription_rates table is updated");
			}else{
				flag = false;
				logger.debug("subscription_rates table is updated");
			}
			
		} catch (Exception e) {
			logger.debug("Exception While validating subscription_rates'issubscription_rates()'" + e.getMessage());
			throw new Exception("Exception While validating subscription_rates 'issubscription_rates()'" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Checks if is pie graph revenue breakdown sb.
	 *
	 * @author JayaniP
	 * @param api the api
	 * @param apiCount the api count
	 * @return true, if is pie graph revenue breakdown sb
	 * @throws Exception the exception
	 */
	public boolean isPieGraphRevenueBreakdownSB(String api, String apiCount) throws Exception {
		flag = false;
		ArrayList<String> apiList = new ArrayList<String>();
		double amount = Double.parseDouble(apiCount);
		WebElement select;
		try {
			select = getElement(UIType.Xpath, pieChartRvenueBreakdownSB);
			List<WebElement> options = select.findElements(By.xpath(pieChartRvenueBreakdownSB));
			for (WebElement option : options) {
				apiList.add(option.getText());
			}

			int count = apiList.size();
			for (int i = 0; i < count; i++) {
				String element = apiList.get(i);
				int openParanthis = element.indexOf("(") + 1;
				int closeParanthis = element.indexOf(")");
				String value = element.substring(openParanthis, closeParanthis);
				String apiName = element.substring(0, openParanthis - 1).trim();
				double apiAmount = Double.parseDouble(value);
				if (apiName.equalsIgnoreCase(api) && (Math.abs(amount - apiAmount) <= 0.01)){
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating graphs data 'isPieGraph()'" + e.getMessage());
			throw new Exception("Exception While Validating graphs data 'isPieGraph()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Checks if is monthly invoice sb showed.
	 *
	 * @author JayaniP
	 * @return true, if is monthly invoice sb showed
	 * @throws Exception the exception
	 */
	public boolean isMonthlyInvoiceSBShowed() throws Exception {
		flag = false;
		logger.debug("Validating monthly invoice SB");
		List<WebElement> allElements = driver.findElements(By.xpath(monthlyInvoiceSBpath)); 
		List<String> stringList = new ArrayList<>();
		try {
			for (WebElement element: allElements) {
			      stringList.add(element.getText());
			}
			if (stringList.toString().contains("Monthly Invoice SB")) {
				flag = true;
				logger.debug("Monthly Invoice SB is showed");
			} else {
				logger.debug("Monthly Invoice SB is not showed");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Monthly Invoice SB 'isMonthlyInvoiceSBShowed()'" + e.getMessage());
			throw new Exception("Exception While Validating Monthly Invoice SB 'isMonthlyInvoiceSBShowed()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Checks if is monthly invoice nb showed.
	 *
	 * @author JayaniP
	 * @return true, if is monthly invoice nb showed
	 * @throws Exception the exception
	 */
	public boolean isMonthlyInvoiceNBNotShowed() throws Exception {
		flag = false;
		logger.debug("Validating monthly invoice SB");
		List<WebElement> allElements = driver.findElements(By.xpath(monthlyInvoiceSBpath)); 
		List<String> stringList = new ArrayList<>();
		try {
			for (WebElement element: allElements) {
			      stringList.add(element.getText());
			}
			if (!stringList.toString().contains("Monthly Invoice NB")) {
				flag = true;
				logger.debug("Monthly Invoice NB is not showed");
			} else {
				logger.debug("Monthly Invoice SB is showed");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Monthly Invoice SB 'isMonthlyInvoiceNBNotShowed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Monthly Invoice SB 'isMonthlyInvoiceNBNotShowed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	
	/**
	 * Checks if is monthly invoice sb not showed.
	 *
	 * @author JayaniP
	 * @return true, if is monthly invoice sb not showed
	 * @throws Exception the exception
	 */
	public boolean isMonthlyInvoiceSBNotShowed() throws Exception {
		flag = false;
		logger.debug("Validating monthly invoice SB");
		List<WebElement> allElements = driver.findElements(By.xpath(monthlyInvoiceSBpath)); 
		List<String> stringList = new ArrayList<>();		
		try {
			for (WebElement element: allElements) {
			      stringList.add(element.getText());
			}
			if (!stringList.toString().contains("Monthly Invoice SB")) {
				flag = true;
				logger.debug("Monthly Invoice SB is not showed");
			} else {
				logger.debug("Monthly Invoice SB is showed");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Monthly Invoice SB 'isMonthlyInvoiceSBNotShowed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Monthly Invoice SB 'isMonthlyInvoiceSBNotShowed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Checks if is monthly invoice nb showed.
	 *
	 * @author JayaniP
	 * @return true, if is monthly invoice nb showed
	 * @throws Exception the exception
	 */
	public boolean isMonthlyInvoiceNBShowed() throws Exception {
		flag = false;
		logger.debug("Validating monthly invoice SB");
		List<WebElement> allElements = driver.findElements(By.xpath(monthlyInvoiceSBpath)); 
		List<String> stringList = new ArrayList<>();		
		try {
			for (WebElement element: allElements) {
			      stringList.add(element.getText());
			}
			if (stringList.toString().contains("Monthly Invoice NB")) {
				flag = true;
				logger.debug("Monthly Invoice NB is showed");
			} else {
				logger.debug("Monthly Invoice SB is not showed");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Monthly Invoice SB 'isMonthlyInvoiceNBShowed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Monthly Invoice SB 'isMonthlyInvoiceNBShowed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Send api request.
	 *
	 * @author SulakkhanaW
	 * @param batFilePath the bat file path
	 */
	public void sendAPIRequest(String batFilePath){
		try {
			logger.debug("Sending API request using jmeter");
			Process process = Runtime.getRuntime().exec("cmd /c start /wait " + batFilePath);
			process.getInputStream();
			process.waitFor();
			logger.debug("Send API request using jmeter successfully");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Checks if is action comment required.
	 *
	 * @param msg the msg
	 * @return true, if is action comment required
	 * @throws Exception the exception
	 */
	public boolean isActionCommentRequired(String msg) throws Exception{
		flag = false;
		String uiMsg = getElement(lblRequiredMsg).getText();
		try {
			logger.debug("Validating Action comment is required");
			if (uiMsg.contains(msg)){
				flag = true;
				logger.debug("Reqired warning pop up visible");
			} else {
				logger.debug("Reqired warning pop up is not visible");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Action comment warning popup 'isActionCommentRequired()'" + e.getMessage());
			throw new Exception("Exception While Validating Action comment warning popup 'isActionCommentRequired()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click required ok.
	 */
	public void clickRequiredOk(){
		logger.debug("Clicking on required Ok");
		getElement(btnReqiredMsgOk).click();
		logger.debug("Clicked on required Ok");
	}
	
	/**
	 * Checks the application approval task status
	 *
	 * @param appname the appname
	 * @param status the status
	 * @return true, if the status matched
	 * @throws Exception the exception
	 */
	public boolean isApprovalTaskStatus(String appname, String status) throws Exception{
		flag = false;
		logger.debug("Validating approval task status");
		String xpath = String.format(lblApprovalTaskStatus, appname);
		WebPelement lblApprovalTaskStatus = defineEelement(UIType.Xpath, xpath);
		try {
			if (getElement(lblApprovalTaskStatus).getText().trim().equalsIgnoreCase(status)){
				flag = true;
				logger.debug("approval task status matched");
			} else {
				logger.debug("approval task status mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating approval task status 'isApprovalTaskStatus()'" + e.getMessage());
			throw new Exception("Exception While Validating approval task status 'isApprovalTaskStatus()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * click on actions drop down list 
	 
	 */
	public void clickDropdownActions(String appname){
		logger.debug("Clicking on actions dropdown");
		String xpath = String.format(ddlConditionList, appname);
		WebPelement ddlConditionList = defineEelement(UIType.Xpath, xpath);
		getElement(ddlConditionList).click();
		logger.debug("Clicked on actions dropdown");
	}
	
	/**
	 * Checks the actions of the task
	 *
	 * @param appname the appname
	 * @param action the action
	 * @return true, if the actions displayed
	 * @throws Exception the exception
	 */
	public boolean isApprovalActionsDisplayed(String actions, String appname) throws Exception{
		flag = false;
		logger.debug("Validating Approval actions in the dropdown");
		String[] options = actions.split(",");
		int optionCount = 1;
		
		try {
			for(int i=0; i<options.length; i++){
				
				String xpath = String.format(ddlConditionListOptions, appname, optionCount);
				WebPelement ddlConditionListOptions = defineEelement(UIType.Xpath, xpath);
				
				if (getElement(ddlConditionListOptions).getText().trim().equalsIgnoreCase(options[i])){
					flag = true;
					logger.debug("Approval actions in the dropdown matched");
					optionCount ++;
					
				} else {
					logger.debug("Approval actions in the dropdown mismatched");
				}
			}
			
		} catch (Exception e) {
			logger.debug("Exception While Validating Approval actions in the dropdown 'isApprovalActionsDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating Approval actions in the dropdown 'isApprovalActionsDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	
	/** 
	 * 
	 * @param appname the appname
	 * @param tier the tier
	 * @return true if tier value displayed
	 * @throws Exception
	 */
	public boolean isTierValueDisplayed(String tier, String appname) throws Exception{
		flag = false;
		logger.debug("Validating Tier value");
		
		String xpath = String.format(ddlTierL, appname);
		WebPelement ddlTierList = defineEelement(UIType.Xpath, xpath);
		Select s =new Select(getElement(ddlTierList));
//		WebPelement o=(WebPelement) s.getFirstSelectedOption();
		String availableTier = s.getFirstSelectedOption().getText();
		
		Thread.sleep(sleepTime);
		try {
			if (availableTier.trim().equalsIgnoreCase(tier)) {
				flag = true;
				logger.debug("Tier value displayed");
			} else {
				logger.debug("Tier value not displayed");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Tier value displayed 'isTierValueDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating Tier value not displayed 'isTierValueDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click subscription details.
	 *
	 * @author MalshaniS
	 * @param appname the appname
	 */
	public void clickSubscriptionDetails(String appname, String apiName) {
		String xpath = String.format(lnkSubscriptionDetails, appname, apiName);
		WebPelement lnkSubscriptionDetails = defineEelement(UIType.Xpath, xpath);
		logger.debug("Clicking on Subscription details");
		getElement(lnkSubscriptionDetails).click();
		logger.debug("Clicked on Subscription details");
	}

	/**
	 * Checks if the subscription task Removed.
	 *
	 * @author MalshaniS
	 * @param appName the app name
	 * @return true, if is subscription task removed
	 * @throws Exception the exception
	 */
	public boolean isSubscriptionTaskRemoved(String appName) throws Exception {
		flag = false;
		logger.debug("Validating subscription task removed");
		Thread.sleep(sleepTime);
		String xpath = String.format(lblApplicationName, appName);
		int Names = driver.findElements(By.xpath(xpath)).size();
		try {
			if (Names == 0) {
				flag = true;
				logger.debug("subscription task is removed");
			} else {
				logger.debug("subscription task is not removed");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating subscription task is removed 'isSubscriptionTaskRemoved()'" + e.getMessage());
			throw new Exception("Exception While Validating subscription task is removed 'isSubscriptionTaskRemoved()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Verifing Created Subscription is visible
	 * 
	 * @author MalshaniS
	 * @param appName
	 * @param apiName
	 * @return
	 * @throws Exception
	 */
	
	public boolean isSubscriptionVisible(String appName, String apiName) throws Exception{
		flag = false;
		logger.debug("Validating Subscription name");
		Thread.sleep(sleepTime/4);
		String xpath = String.format(lblSubscription, appName, apiName);
		int Names = driver.findElements(By.xpath(xpath)).size();
		try {
			if (Names == 1) {
				flag = true;
				logger.debug("Subscription name is visible");
			} else {
				logger.debug("Subscription creation name is not visible");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Subscription name 'isSubscriptionVisible()'" + e.getMessage());
			throw new Exception("Exception While Validating Subscription name 'isSubscriptionVisible()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Verifing Subscription is not visible after approving
	 * 
	 * @author MalshaniS
	 * @param appName
	 * @param apiName
	 * @return
	 * @throws Exception
	 */
	public boolean isSubscriptionNotVisible(String appName, String apiName) throws Exception{
		flag = false;
		logger.debug("Validating Subscription not visible");
		String xpath = String.format(lblSubscription, appName, apiName);
		int Names = driver.findElements(By.xpath(xpath)).size();
		try {
			if (Names < 1) {
				flag = true;
				logger.debug("Subscription not visible");
			} else {
				logger.debug("Subscription visible");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Subscription 'isSubscriptionNotVisible()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Subscription 'isSubscriptionNotVisible()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Checks the subscription approval task status
	 * 
	 * @author MalshaniS
	 * @param appname
	 * @param apiname
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public boolean isSubscriptionApprovalTaskStatus(String appname, String apiname, String status) throws Exception{
		flag = false;
		logger.debug("Validating approval task status");
		String xpath = String.format(lblSubscriptionApprovalTaskStatus, appname, apiname);
		WebPelement lblSubscriptionApprovalTaskStatus = defineEelement(UIType.Xpath, xpath);
		try {
			if (getElement(lblSubscriptionApprovalTaskStatus).getText().trim().equalsIgnoreCase(status)){
				flag = true;
				logger.debug("approval task status matched");
			} else {
				logger.debug("approval task status mismatched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating approval task status 'isSubscriptionApprovalTaskStatus()'" + e.getMessage());
			throw new Exception("Exception While Validating approval task status 'isSubscriptionApprovalTaskStatus()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click assign me.
	 * 
	 * @author MalshaniS
	 * @param appName
	 * @param apiname
	 */
	public void clickSubscriptionAssignMe(String appName, String apiname) {
		String xpath = String.format(btnSubscrtionAssignMe, appName, apiname);
		WebPelement btnSubscrtionAssignMe = defineEelement(UIType.Xpath, xpath);
		logger.debug("Clicking on Assign me");
		getElement(btnSubscrtionAssignMe).click();
		logger.debug("Clicked on Assign me");
	}
	
	/**
	 * Click Subscription approval start.
	 *
	 * @author MalshaniS
	 * @param appName
	 * @param apiName
	 */
	public void clickSubscriptionStart(String appName, String apiName) {
		String xpath = String.format(btnSubscriptionStart, appName, apiName);
		WebPelement btnSubscriptionStart = defineEelement(UIType.Xpath, xpath);
		logger.debug("Clicking on start button");
		getElement(btnSubscriptionStart).click();
		logger.debug("Clicked on start button");
	}
	
	/**
	 * Select Condition
	 * 
	 * @author MalshaniS
	 * @param condition
	 * @param appName
	 */
	public void selectSubscriptionActionCondition(String condition, String appName, String apiName) {
		String xpath = String.format(ddlSubscriptionConditionList, appName, apiName);
		WebPelement ddlSubscriptionConditionList = defineEelement(UIType.Xpath, xpath);
		logger.debug("Selecting condition");
		getElement(ddlSubscriptionConditionList).sendKeys(condition);
		getElement(ddlSubscriptionConditionList).sendEnter();
		logger.debug("Condition selected");
	}

	/**
	 * Click Subscription approal Complete button
	 * 
	 * @author MalshaniS
	 * @param appName
	 */
	public void clickSubscriptionComplete(String appName, String apiName) {
		String xpath = String.format(btnSubscriptionComplete, appName, apiName);
		WebPelement btnSubscriptionComplete = defineEelement(UIType.Xpath, xpath);
		logger.debug("Clicking on complete");
		getElement(btnSubscriptionComplete).click();
		logger.debug("Clicked on complete");
	}
	
	/**
	 * Click on Action Dropdown
	 * 
	 * @author MalshaniS
	 * @param appname
	 * @param apiname
	 */
	public void clickSubscriptionDropdownActions(String appname, String apiname){
		logger.debug("Clicking on actions dropdown");
		String xpath = String.format(ddlSubscriptionConditionList, appname, apiname);
		WebPelement ddlSubscriptionConditionList = defineEelement(UIType.Xpath, xpath);
		getElement(ddlSubscriptionConditionList).click();
		logger.debug("Clicked on actions dropdown");
	}
	
	/**
	 * Checks the actions of the task
	 *
	 * @param appname the appname
	 * @param action the action
	 * @param apiName the apiname
	 * @return true, if the actions displayed
	 * @throws Exception the exception
	 */
	public boolean isSubscriptionApprovalActionsDisplayed(String actions, String appname, String apiName) throws Exception{
		flag = false;
		logger.debug("Validating Approval actions in the dropdown");
		String[] options = actions.split(",");
		int optionCount = 1;
		
		try {
			for(int i=0; i<options.length; i++){
				
				String xpath = String.format(ddlSubscriptionConditionListOptions, appname,apiName, optionCount);
				WebPelement ddlSubscriptionConditionListOptions = defineEelement(UIType.Xpath, xpath);
				
				if (getElement(ddlSubscriptionConditionListOptions).getText().trim().equalsIgnoreCase(options[i])){
					flag = true;
					logger.debug("Approval actions in the dropdown matched");
					optionCount ++;
					
				} else {
					logger.debug("Approval actions in the dropdown mismatched");
				}
			}
			
		} catch (Exception e) {
			logger.debug("Exception While Validating Approval actions in the dropdown 'ddlSubscriptionConditionListOptions()'" + e.getMessage());
			throw new Exception("Exception While Validating Approval actions in the dropdown 'ddlSubscriptionConditionListOptions()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Select Subscription Tier
	 * 
	 * @param tier
	 * @param appname
	 * @param apiName
	 */
	public void selectSubscriptionTier(String tier, String appname, String apiName) {
		String xpath = String.format(ddlSubscriptionTierL, appname, apiName);
		WebPelement ddlSubscriptionTierL = defineEelement(UIType.Xpath, xpath);
		getElement(ddlSubscriptionTierL).click();
		logger.debug("Selecting tier");
		getElement(ddlSubscriptionTierL).sendKeys(tier);
		logger.debug("Tier selected");
		getElement(ddlSubscriptionTierL).sendEnter();		
	}
	
	/**
	 * Verify the subscription tier values are displayed
	 * 
	 * @param tier
	 * @param appname
	 * @param apiname
	 * @return
	 * @throws Exception
	 */
	public boolean isSubscriptionTierValueDisplayed(String tier, String appname, String apiname) throws Exception{
		flag = false;
		logger.debug("Validating Tier value");
		
		String xpath = String.format(ddlSubscriptionTierL, appname, apiname);
		WebPelement ddlSubscriptionTierL = defineEelement(UIType.Xpath, xpath);
		Select s =new Select(getElement(ddlSubscriptionTierL));

		String availableTier = s.getFirstSelectedOption().getText();
		
		Thread.sleep(sleepTime);
		try {
			if (availableTier.trim().equalsIgnoreCase(tier)) {
				flag = true;
				logger.debug("Tier value displayed");
			} else {
				logger.debug("Tier value not displayed");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Tier value displayed 'isSubscriptionTierValueDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating Tier value not displayed 'isSubscriptionTierValueDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}
}
