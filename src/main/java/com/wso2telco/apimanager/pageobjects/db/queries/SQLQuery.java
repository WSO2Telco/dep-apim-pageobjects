package com.wso2telco.apimanager.pageobjects.db.queries;

/**
 * The Interface SQLQuery.
 */
public interface SQLQuery {

	/** The total api traffic. 
	 * %s_1 - fromDate
	 * %s_2 - toDate
	 * %s_3 - operatorId
	 * */
	String PERFORMANCE_ERROR_RATES = "select sb.exceptionId, COUNT(*) as valueCounts from SB_API_RESPONSE_SUMMARY sb where sb.time BETWEEN  '%s' and '%s' and and sb.operatorId = '%s' exceptionId IS NOT NULL GROUP BY sb.exceptionId";
	
	/** The total api traffic. 
	 * %s_1 - fromDate
	 * %s_2 - toDate
	 * %s_3 - operatorId
	 * %s_4 - admin
	 * */
	String TOTAL_API_TRAFFIC = "select sb.api, COUNT(*) as trafficCount from SB_API_RESPONSE_SUMMARY sb where sb.time BETWEEN  '%s' and '%s' and sb.operatorId = '%s' and sb.userId = '%s' GROUP BY sb.api";
	
	/** The operator api traffic. 
	 * %s_1 - fromDate
	 * %s_2 - toDate
	 * %s_4 - userId
	 * */
	//String OPERATOR_API_TRAFFIC = "select sb.operatorId, COUNT(*) as trafficCount from SB_API_RESPONSE_SUMMARY sb where sb.time BETWEEN  '%s' and '%s' and sb.userId = '%s' GROUP BY sb.operatorId";
	//String OPERATOR_API_TRAFFIC="select sb.time, sb.jsonBody, sb.api from SB_API_RESPONSE_SUMMARY sb where sb.time BETWEEN '%s' and '%s' and sb.operatorId = '%s'";
	String OPERATOR_API_TRAFFIC="SELECT CONCAT(DATE(sb.time),' ',time(CONVERT_TZ(sb.time , '+00:00', '+05:30'))) as time,sb.jsonBody, sb.api, sb.responseCode FROM qadbApiStats.SB_API_RESPONSE_SUMMARY sb,qadbApiMgt.AM_APPLICATION app,qadbApiMgt.AM_APPLICATION_KEY_MAPPING appkey where app.APPLICATION_ID=appkey.APPLICATION_ID and appkey.CONSUMER_KEY=sb.consumerKey and appkey.KEY_TYPE='PRODUCTION' and sb.time BETWEEN '%s' and '%s' and sb.operatorId='%s' and sb.userId='%s' and app.NAME='%s'";
	
	/** The transaction log. 
	 * %s_1 - fromDate
	 * %s_2 - toDate
	 * %s_3 - operatorId
	 * %s_4 - api
	 * */
	String TRANSACTION_LOG = "select sb.time, sb.userId, sb.operatorId, sb.api, sb.requestId, sb.msisdn, sb.chargeAmount, sb.responseCode, sb.purchaseCategoryCode from SB_API_RESPONSE_SUMMARY sb where sb.time BETWEEN  '%s' and '%s' and operatorId = '%s' and sb.api = '%s' and exceptionId IS NULL";
}