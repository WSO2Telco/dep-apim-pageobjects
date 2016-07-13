package com.wso2telco.apimanager.pageobjects.db.queries;

/**
 * The Interface SQLQuery.
 */
public interface SQLQuery {

	/**
	 * The total api traffic. %s_1 - fromDate %s_2 - toDate %s_3 - operatorId
	 * */
	String PERFORMANCE_ERROR_RATES = "select sb.exceptionId, COUNT(*) as valueCounts from SB_API_RESPONSE_SUMMARY sb where sb.time BETWEEN  '%s' and '%s' and sb.operatorId = '%s' and userId = '%s' and exceptionId IS NOT NULL GROUP BY sb.exceptionId";

	/**
	 * The total api traffic. %s_1 - fromDate %s_2 - toDate %s_3 - operatorId
	 * %s_4 - admin
	 * */
	String TOTAL_API_TRAFFIC = "select sb.api, COUNT(*) as trafficCount from SB_API_RESPONSE_SUMMARY sb where sb.time BETWEEN  '%s' and '%s' and sb.operatorId = '%s' and sb.userId = '%s' GROUP BY sb.api";

	/**
	 * The operator api traffic. %s_1 - fromDate %s_2 - toDate %s_4 - userId
	 * */
	// String OPERATOR_API_TRAFFIC =
	// "select sb.operatorId, COUNT(*) as trafficCount from SB_API_RESPONSE_SUMMARY sb where sb.time BETWEEN  '%s' and '%s' and sb.userId = '%s' GROUP BY sb.operatorId";
	// String
	// OPERATOR_API_TRAFFIC="select sb.time, sb.jsonBody, sb.api from SB_API_RESPONSE_SUMMARY sb where sb.time BETWEEN '%s' and '%s' and sb.operatorId = '%s'";
	String OPERATOR_API_TRAFFIC = "select sb.operatorId ,COUNT(sb.operatorId) as operatorcount from qadbApiStats.SB_API_RESPONSE_SUMMARY sb,qadbApiMgt.AM_APPLICATION app,qadbApiMgt.AM_APPLICATION_KEY_MAPPING appkey where app.APPLICATION_ID=appkey.APPLICATION_ID and appkey.CONSUMER_KEY=sb.consumerKey and sb.time BETWEEN '%s' and '%s' and sb.userId='%s' and app.NAME='%s' and sb.api='%s' GROUP BY sb.operatorId";

	/** The customer care for customercare role. */
	String CUSTOMER_CARE_FOR_CUSTOMERCARE_ROLE = "SELECT CONCAT(DATE(sb.time),' ',time(CONVERT_TZ(sb.time , '+00:00', '+05:30'))) as time,sb.jsonBody, sb.api, sb.responseCode FROM qadbApiStats.SB_API_RESPONSE_SUMMARY sb,qadbApiMgt.AM_APPLICATION app,qadbApiMgt.AM_APPLICATION_KEY_MAPPING appkey where app.APPLICATION_ID=appkey.APPLICATION_ID and appkey.CONSUMER_KEY=sb.consumerKey and appkey.KEY_TYPE='PRODUCTION' and sb.time BETWEEN '%s' and '%s' and app.NAME='%s'";

	/** The customer care. */
	String CUSTOMER_CARE = "SELECT CONCAT(DATE(sb.time),' ',time(CONVERT_TZ(sb.time , '+00:00', '+05:30'))) as time,sb.jsonBody, sb.api, sb.responseCode FROM qadbApiStats.SB_API_RESPONSE_SUMMARY sb,qadbApiMgt.AM_APPLICATION app,qadbApiMgt.AM_APPLICATION_KEY_MAPPING appkey where app.APPLICATION_ID=appkey.APPLICATION_ID and appkey.CONSUMER_KEY=sb.consumerKey and appkey.KEY_TYPE='PRODUCTION' and sb.time BETWEEN '%s' and '%s' and sb.operatorId='%s' and sb.userId='%s' and app.NAME='%s'";
	/**
	 * The transaction log. %s_1 - fromDate %s_2 - toDate %s_3 - operatorId %s_4
	 * - api
	 * */
	String TRANSACTION_LOG = "select CONCAT(DATE(sb.time),' ',time(CONVERT_TZ(sb.time , '+00:00', '+05:30'))) as time, sb.userId, sb.operatorId, sb.requestId, sb.msisdn, sb.chargeAmount, sb.responseCode from SB_API_RESPONSE_SUMMARY sb where sb.time BETWEEN  '%s' and '%s' and operatorId = '%s' and exceptionId IS NULL and sb.chargeAmount IS NOT NULL";

	/** The subscription rates nb. */
	String SUBSCRIPTION_RATES_NB = "select srnb.application_id from qadbApiStats.subscription_rates_nb srnb, qadbApiMgt.AM_APPLICATION app  where app.APPLICATION_ID=srnb.application_id and app.NAME='%s' and operation_id='200'";

	/** The subscription rates. */
	String SUBSCRIPTION_RATES = "select sr.application_id from qadbApiStats.subscription_rates sr, qadbApiMgt.AM_APPLICATION app  where app.APPLICATION_ID=sr.application_id and app.NAME='%s' and operation_id='200'";
	/** The subscription rates. */

	
	
	
	
	String UPDATE_OPERATORAPPS = "update rs_axiatadb.operatorapps set rs_axiatadb.operatorapps.isactive = '%Status' where rs_axiatadb.operatorapps.applicationid = (select rs_apimgt.AM_APPLICATION.APPLICATION_ID from rs_apimgt.AM_APPLICATION where rs_apimgt.AM_APPLICATION.NAME='%ApplicationName');";

	/** 7.1. Update 'SP_INBOUND_AUTH' table - ConsumerKey and ConsumerSecret */
	String UPDATE_SP_INBOUND_AUTH = "update rs_dbApiMgt.SP_INBOUND_AUTH set rs_dbApiMgt.SP_INBOUND_AUTH.INBOUND_AUTH_KEY='%ConsumerKeyNew', rs_dbApiMgt.SP_INBOUND_AUTH.PROP_VALUE='%ConsumerSecretNew' where rs_dbApiMgt.SP_INBOUND_AUTH.INBOUND_AUTH_KEY='%ConsumerKeyOld' and rs_dbApiMgt.SP_INBOUND_AUTH.PROP_VALUE='%ConsumerSecretOld';";

	/** 7.2. Update 'AM_APPLICATION_KEY_MAPPING' table - ConsumerKey */
	String UPDATE_AM_APPLICATION_KEY_MAPPING = "update rs_dbApiMgt.AM_APPLICATION_KEY_MAPPING set rs_dbApiMgt.AM_APPLICATION_KEY_MAPPING.CONSUMER_KEY='%ConsumerKeyNew' where rs_dbApiMgt.AM_APPLICATION_KEY_MAPPING.CONSUMER_KEY='%ConsumerKeyOld';";

	/**
	 * 7.3. Insert values To avoid Foreign key constraint Note: insert dummy
	 * consumer key for IDN_OAUTH_CONSUMER_APPS , this should be run for 1 time
	 * for a database.
	 */
	String INSERT_IDN_OAUTH_CONSUMER_APPS = "insert into rs_dbApiMgt.IDN_OAUTH_CONSUMER_APPS (CONSUMER_KEY, CONSUMER_SECRET,USERNAME, TENANT_ID, APP_NAME, OAUTH_VERSION, CALLBACK_URL) values ('tempConsumerKey', 'tempConsumerSecret', 'admin', 1234, 'tempapp', 'OAuth-2.0', '');";

	/** 7.4. Update 'AM_APP_KEY_DOMAIN_MAPPING' table - ConsumerKey */
	String UPDATE_TEMP_AM_APP_KEY_DOMAIN_MAPPING = "update rs_dbApiMgt.AM_APP_KEY_DOMAIN_MAPPING set rs_dbApiMgt.AM_APP_KEY_DOMAIN_MAPPING.CONSUMER_KEY='tempconsumerkey' where rs_dbApiMgt.AM_APP_KEY_DOMAIN_MAPPING.CONSUMER_KEY='%ConsumerKeyOld';";

	/** Update 'IDN_OAUTH2_ACCESS_TOKEN' table - ConsumerKey */
	String UPDATE_TEMP_IDN_OAUTH2_ACCESS_TOKEN = "update rs_dbApiMgt.IDN_OAUTH2_ACCESS_TOKEN set rs_dbApiMgt.IDN_OAUTH2_ACCESS_TOKEN.CONSUMER_KEY='tempConsumerkey' where rs_dbApiMgt.IDN_OAUTH2_ACCESS_TOKEN.CONSUMER_KEY='%ConsumerKeyOld';";

	/** Update 'IDN_OAUTH2_AUTHORIZATION_CODE' table - ConsumerKey */
	String UPDATE_TEMP_UPDATE_IDN_OAUTH2_AUTHORIZATION_CODE = "update rs_dbApiMgt.IDN_OAUTH2_AUTHORIZATION_CODE set rs_dbApiMgt.IDN_OAUTH2_AUTHORIZATION_CODE.CONSUMER_KEY='tempConsumerKey' where rs_dbApiMgt.IDN_OAUTH2_AUTHORIZATION_CODE.CONSUMER_KEY='%ConsumerKeyOld';";

	/**
	 * 7.5. Update 'IDN_OAUTH_CONSUMER_APPS' table - ConsumerKey /
	 * ConsumerSecret
	 */
	String UPDATE_IDN_OAUTH_CONSUMER_APPS = "update rs_dbApiMgt.IDN_OAUTH_CONSUMER_APPS set rs_dbApiMgt.IDN_OAUTH_CONSUMER_APPS.CONSUMER_KEY='%ConsumerKeyNew' , rs_dbApiMgt.IDN_OAUTH_CONSUMER_APPS.CONSUMER_SECRET='%ConsumerSecretNew' where rs_dbApiMgt.IDN_OAUTH_CONSUMER_APPS.CONSUMER_KEY='%ConsumerKeyOld';";

	/** Update 'AM_APP_KEY_DOMAIN_MAPPING' table - ConsumerKey */
	String UPDATE_AM_APP_KEY_DOMAIN_MAPPING = "update rs_dbApiMgt.AM_APP_KEY_DOMAIN_MAPPING set rs_dbApiMgt.AM_APP_KEY_DOMAIN_MAPPING.CONSUMER_KEY='%ConsumerKeyNew' where rs_dbApiMgt.AM_APP_KEY_DOMAIN_MAPPING.CONSUMER_KEY='tempConsumerkey';";

	/** Update 'IDN_OAUTH2_ACCESS_TOKEN' table - ConsumerKey */
	String UPDATE_IDN_OAUTH2_ACCESS_TOKEN = "update rs_dbApiMgt.IDN_OAUTH2_ACCESS_TOKEN set rs_dbApiMgt.IDN_OAUTH2_ACCESS_TOKEN.CONSUMER_KEY='%ConsumerKeyNew' where rs_dbApiMgt.IDN_OAUTH2_ACCESS_TOKEN.CONSUMER_KEY='tempConsumerkey';";

	/** Update 'IDN_OAUTH2_AUTHORIZATION_CODE' table - ConsumerKey */
	String UPDATE_IDN_OAUTH2_AUTHORIZATION_CODE = "update rs_dbApiMgt.IDN_OAUTH2_AUTHORIZATION_CODE set rs_dbApiMgt.IDN_OAUTH2_AUTHORIZATION_CODE.CONSUMER_KEY='%ConsumerKeyNew' where rs_dbApiMgt.IDN_OAUTH2_AUTHORIZATION_CODE.CONSUMER_KEY='tempConsumerKey';";

	/** 7.6 Update sp_token */
	String UPDATE_SP_TOKEN = "update rs_dbAxiataMife.sp_token set rs_dbAxiataMife.sp_token.consumer_key='%ConsumerKeyNew' where rs_dbAxiataMife.sp_token.consumer_key='%ConsumerKeyOld';";

	String GET_TEMP_KEY="select distinct rs_dbApiMgt.IDN_OAUTH_CONSUMER_APPS.CONSUMER_KEY from rs_dbApiMgt.IDN_OAUTH_CONSUMER_APPS where rs_dbApiMgt.IDN_OAUTH_CONSUMER_APPS.CONSUMER_KEY='tempConsumerKey';";
}
