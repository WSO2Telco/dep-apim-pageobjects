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
	String OPERATOR_API_TRAFFIC = "select sb.operatorId, COUNT(*) as trafficCount from SB_API_RESPONSE_SUMMARY sb where sb.time BETWEEN  '%s' and '%s' and sb.userId = '%s' GROUP BY sb.operatorId";
	
	/** The transaction log. */
	String TRANSACTION_LOG = "";
}