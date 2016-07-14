package com.wso2telco.apimanager.databasequeries;

import org.apache.log4j.Logger;

import com.wso2telco.apimanager.pageobjects.apihome.manager.ManagerPage;
import com.wso2telco.apimanager.pageobjects.db.queries.SQLQuery;
import com.wso2telco.test.framework.db.connection.executers.SQLExecuter;
import com.wso2telco.test.framework.db.connection.sql.QueryResult;

public class DataBaseQueries {

	Logger logger = Logger.getLogger(DataBaseQueries.class);
	public void updateOperatorAppsStatus(String Status, String ApplicationName) {

		String UPDATE_OPERATORAPPS = SQLQuery.UPDATE_OPERATORAPPS.replace(
				"%Status", Status).replace("%ApplicationName", ApplicationName);
		System.out.println(UPDATE_OPERATORAPPS + "/n");
		try {
			SQLExecuter.executeUpdateQuery(UPDATE_OPERATORAPPS);
			logger.debug("Update query UPDATE_OPERATORAPPS executed.");
		} catch (Exception e) {
			System.err
					.println("Error occured when executing UPDATE_OPERATORAPPS : "
							+ e.getMessage());
		}
	}

	public void updateConsumerKeyandConsumerSecret(String ConsumerKNew,
			String ConsumerSNew, String ConsumerKOld, String ConsumerSOld) throws Exception {

		String UPDATE_SP_INBOUND_AUTH = SQLQuery.UPDATE_SP_INBOUND_AUTH
				.replace("%ConsumerKeyNew", ConsumerKNew)
				.replace("%ConsumerSecretNew", ConsumerSNew)
				.replace("%ConsumerKeyOld", ConsumerKOld)
				.replace("%ConsumerSecretOld", ConsumerSOld);
		String UPDATE_AM_APPLICATION_KEY_MAPPING = SQLQuery.UPDATE_AM_APPLICATION_KEY_MAPPING
				.replace("%ConsumerKeyNew", ConsumerKNew).replace(
						"%ConsumerKeyOld", ConsumerKOld);
		String INSERT_IDN_OAUTH_CONSUMER_APPS = SQLQuery.INSERT_IDN_OAUTH_CONSUMER_APPS;
		String UPDATE_TEMP_AM_APP_KEY_DOMAIN_MAPPING = SQLQuery.UPDATE_TEMP_AM_APP_KEY_DOMAIN_MAPPING
				.replace("%ConsumerKeyOld", ConsumerSOld);
		String UPDATE_TEMP_IDN_OAUTH2_ACCESS_TOKEN = SQLQuery.UPDATE_TEMP_IDN_OAUTH2_ACCESS_TOKEN
				.replace("%ConsumerKeyOld", ConsumerKOld);
		String UPDATE_TEMP_UPDATE_IDN_OAUTH2_AUTHORIZATION_CODE = SQLQuery.UPDATE_TEMP_UPDATE_IDN_OAUTH2_AUTHORIZATION_CODE
				.replace("%ConsumerKeyOld", ConsumerKOld);
		String UPDATE_IDN_OAUTH_CONSUMER_APPS = SQLQuery.UPDATE_IDN_OAUTH_CONSUMER_APPS
				.replace("%ConsumerKeyNew", ConsumerKNew)
				.replace("%ConsumerSecretNew", ConsumerSNew)
				.replace("%ConsumerKeyOld", ConsumerKOld);
		String UPDATE_AM_APP_KEY_DOMAIN_MAPPING = SQLQuery.UPDATE_AM_APP_KEY_DOMAIN_MAPPING
				.replace("%ConsumerKeyNew", ConsumerKNew);
		String UPDATE_IDN_OAUTH2_ACCESS_TOKEN = SQLQuery.UPDATE_IDN_OAUTH2_ACCESS_TOKEN
				.replace("%ConsumerKeyNew", ConsumerKNew);
		String UPDATE_IDN_OAUTH2_AUTHORIZATION_CODE = SQLQuery.UPDATE_IDN_OAUTH2_AUTHORIZATION_CODE
				.replace("%ConsumerKeyNew", ConsumerKNew);
		String UPDATE_SP_TOKEN = SQLQuery.UPDATE_SP_TOKEN.replace(
				"%ConsumerKeyNew", ConsumerKNew).replace("ConsumerKOld",
				ConsumerKOld);

		System.out.println(UPDATE_SP_INBOUND_AUTH + "\n ");
		System.out.println(UPDATE_AM_APPLICATION_KEY_MAPPING + "\n ");
		System.out.println(INSERT_IDN_OAUTH_CONSUMER_APPS + "\n ");
		System.out.println(UPDATE_TEMP_AM_APP_KEY_DOMAIN_MAPPING + "\n ");
		System.out.println(UPDATE_TEMP_IDN_OAUTH2_ACCESS_TOKEN + "\n ");
		System.out.println(UPDATE_TEMP_UPDATE_IDN_OAUTH2_AUTHORIZATION_CODE
				+ "\n ");
		System.out.println(UPDATE_IDN_OAUTH_CONSUMER_APPS + "\n ");
		System.out.println(UPDATE_AM_APP_KEY_DOMAIN_MAPPING + "\n ");
		System.out.println(UPDATE_IDN_OAUTH2_ACCESS_TOKEN + "\n ");
		System.out.println(UPDATE_IDN_OAUTH2_AUTHORIZATION_CODE + "\n ");
		System.out.println(UPDATE_SP_TOKEN + "\n ");

		try {
			SQLExecuter.executeUpdateQuery(UPDATE_SP_INBOUND_AUTH);
			logger.debug("Update query UPDATE_SP_INBOUND_AUTH executed.");
		} catch (Exception e) {
			logger.error("Error occured when executing UPDATE_SP_INBOUND_AUTH : "
							+ e.getMessage());
		}

		try {
			SQLExecuter.executeUpdateQuery(UPDATE_AM_APPLICATION_KEY_MAPPING);
			logger.debug("Update query UPDATE_AM_APPLICATION_KEY_MAPPING executed.");
		} catch (Exception e) {
			logger.error("Error occured when executing UPDATE_AM_APPLICATION_KEY_MAPPING : "
							+ e.getMessage());
		}

		// Check whether temp record available to manage foreign key constraint
		QueryResult qsTempKey = SQLExecuter.getQueryResults(SQLQuery.GET_TEMP_KEY);
		if (qsTempKey.getResultSize() == 0) {
			try {
				SQLExecuter.executeUpdateQuery(INSERT_IDN_OAUTH_CONSUMER_APPS);
				logger.debug("Update query INSERT_IDN_OAUTH_CONSUMER_APPS executed.");
			} catch (Exception e) {
				logger.error("Error occured when executing GET_TEMP_KEY: "
								+ e.getMessage());
			}
		}

		try {
			SQLExecuter
					.executeUpdateQuery(UPDATE_TEMP_AM_APP_KEY_DOMAIN_MAPPING);
			logger.debug("Update query UPDATE_TEMP_AM_APP_KEY_DOMAIN_MAPPING executed.");
		} catch (Exception e) {
			logger.error("Error occured when executing UPDATE_TEMP_AM_APP_KEY_DOMAIN_MAPPING : "
							+ e.getMessage());
		}

		try {
			SQLExecuter.executeUpdateQuery(UPDATE_TEMP_IDN_OAUTH2_ACCESS_TOKEN);
			logger.debug("Update query UPDATE_TEMP_IDN_OAUTH2_ACCESS_TOKEN executed.");
		} catch (Exception e) {
			logger.error("Error occured when executing UPDATE_TEMP_IDN_OAUTH2_ACCESS_TOKEN : "
							+ e.getMessage());
		}

		try {
			SQLExecuter
					.executeUpdateQuery(UPDATE_TEMP_UPDATE_IDN_OAUTH2_AUTHORIZATION_CODE);
			logger.debug("Update query UPDATE_TEMP_UPDATE_IDN_OAUTH2_AUTHORIZATION_CODE executed.");
		} catch (Exception e) {
			logger.error("Error occured when executing UPDATE_TEMP_UPDATE_IDN_OAUTH2_AUTHORIZATION_CODE : "
							+ e.getMessage());
		}

		try {
			SQLExecuter.executeUpdateQuery(UPDATE_IDN_OAUTH_CONSUMER_APPS);
			logger.debug("Update query UPDATE_IDN_OAUTH_CONSUMER_APPS executed.");
		} catch (Exception e) {
			logger.error("Error occured when executing UPDATE_IDN_OAUTH_CONSUMER_APPS : "
							+ e.getMessage());
		}

		try {
			SQLExecuter.executeUpdateQuery(UPDATE_AM_APP_KEY_DOMAIN_MAPPING);
			logger.debug("Update query UPDATE_AM_APP_KEY_DOMAIN_MAPPING executed.");
		} catch (Exception e) {
			logger.error("Error occured when executing UPDATE_AM_APP_KEY_DOMAIN_MAPPING : "
							+ e.getMessage());
		}

		try {
			SQLExecuter.executeUpdateQuery(UPDATE_IDN_OAUTH2_ACCESS_TOKEN);
			logger.debug("Update query UPDATE_IDN_OAUTH2_ACCESS_TOKEN executed.");
		} catch (Exception e) {
			logger.error("Error occured when executing UPDATE_IDN_OAUTH2_ACCESS_TOKEN : "
							+ e.getMessage());
		}

		try {
			SQLExecuter
					.executeUpdateQuery(UPDATE_IDN_OAUTH2_AUTHORIZATION_CODE);
			logger.debug("Update query UPDATE_IDN_OAUTH2_AUTHORIZATION_CODE executed.");
		} catch (Exception e) {
			logger.error("Error occured when executing UPDATE_IDN_OAUTH2_AUTHORIZATION_CODE : "
							+ e.getMessage());
		}

		try {
			SQLExecuter.executeUpdateQuery(UPDATE_SP_TOKEN);
			logger.debug("Update query UPDATE_SP_TOKEN executed.");
		} catch (Exception e) {
			logger.error(("Error occured when executing UPDATE_SP_TOKEN : "
					+ e.getMessage()));
					}

	}

/*	public static void main(String args[]) {
		DataBaseQueries s = new DataBaseQueries();
		s.updateOperatorAppsStatus("1", "ssgsg");
		s.updateConsumerKeyandConsumerSecret(
				"6b0037da-9002-4a1c-8c56-d0f8c763149f",
				"9fa3e85c-aeea-4022-9198-9118f48cec9b",
				"9f8wg5U1pYkVNSphvgSYod8C6CMa", "_bERff0XJW7kRIdh4w_NUC6QfpIa");
	}*/
}
