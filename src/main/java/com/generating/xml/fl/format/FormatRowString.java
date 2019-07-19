package com.generating.xml.fl.format;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FormatRowString {

    private FormatRowString(){}

    public static String formatStringSearchAllDeviceRow(ResultSet resultSet) throws SQLException {
        StringBuilder build = new StringBuilder();
        build.append("| ID: " +resultSet.getLong("id")+ " \t");
        build.append("| ACTIVE: " +resultSet.getBoolean("active")+ " \t");
        build.append("| IMEI: " +resultSet.getString("imei")+ " \t");
        build.append("| MSISDN: " +resultSet.getString("msisdn")+ " \t");
        build.append("| ACCOUNT_ID: " +resultSet.getString("account_id")+ " \t");
        build.append("| CREATION_DATE: " +resultSet.getDate("creation_date")+ " \t");
        build.append("| OS: " +resultSet.getString("os")+ " \t");
        build.append("| DEVICE_NAME: " +resultSet.getString("device_name"));
        return build.toString();
    }

    public static String formatStringSearchDeviceByEmailRow(ResultSet resultSet) throws SQLException {
        StringBuilder build = new StringBuilder();
        build.append("| ID: " + resultSet.getLong("id")+ " \t");
        build.append("| ACTIVE: " +resultSet.getBoolean("active")+ " \t");
        build.append("| BLOCKED: " +resultSet.getBoolean("blocked")+ " \t");
        build.append("| EMAIL: " +resultSet.getString("email")+ " \t");
        build.append("| USER_NAME: " +resultSet.getString("user_name")+ " \t");
        build.append("| ID: " + resultSet.getLong("id")+ " \t");
        build.append("| DEVICE_NAME: " +resultSet.getString("device_name")+ " \t");
        build.append("| MSISDN: " +resultSet.getString("msisdn")+ " \t");
        return build.toString();
    }

    public static String formatStringSearchDeviceActiveAndEmailRow(ResultSet resultSet) throws SQLException {
        StringBuilder build = new StringBuilder();
        build.append("| ID: " + resultSet.getLong("account_id")+ " \t");
        build.append("| EMAIL: " +resultSet.getString("email")+ " \t");
        build.append("| USER_NAME: " +resultSet.getString("user_name")+ " \t");
        build.append("| ID: " + resultSet.getLong("device_id")+ " \t");
        build.append("| DEVICE_NAME: " +resultSet.getString("device_name")+ " \t");
        build.append("| MSISDN:  " +resultSet.getString("msisdn")+ " \t");
        build.append("| IMEI: " +resultSet.getString("imei")+ " \t");
        build.append("| OS: " +resultSet.getString("os")+ " \t");
        return build.toString();
    }

    public static String formatStringCustomerByIdentificationNumberRow(ResultSet resultSet) throws SQLException {
        StringBuilder build = new StringBuilder();
        build.append("| ID:  " +resultSet.getLong("id")+ " \t");
        build.append("| STATUS_CLIENT: " +resultSet.getString("status_clien")+ " \t");
        build.append("| STATUS_IDENT: " +resultSet.getString("status_ident")+ " \t");
        build.append("| MSISDN: " +resultSet.getString("msisdn")+ " \t");
        build.append("| IS_PRIMARY: " +resultSet.getString("isprimary")+ " \t");
        build.append("| TELCO: " +resultSet.getString("telco")+ " \t");
        return build.toString();
    }


    public static String formatStringDailyTransactionRow(ResultSet resultSet) throws SQLException {
        StringBuilder build = new StringBuilder();
        build.append("| MSISDN:  " +resultSet.getString("msisdn")+ "\t");
        build.append("| TRANSACTION_DATE:  " +resultSet.getDate("transaction_date")+ "\t");
        build.append("| TRANSACTION_ID:  " +resultSet.getString("transaction_id")+ "\t");
        build.append("| SUB_TRANSACTION_TYPE: " +resultSet.getString("sub_transaction_type")+ "\t");
        build.append("| SUB_TRANSACTION_NAME: " +resultSet.getString("sub_transaction_name")+ "\t");
        build.append("| REQUEST_TYPE: " +resultSet.getString("request_type")+ "\t");
        build.append("| AMOUNT: " +resultSet.getLong("amount")+ "\t");
        build.append("| ACCOUNT_BANK " +resultSet.getString("cuenta_bancaria")+ "\t");
        build.append("| STATUS: " +resultSet.getString("status")+ "\t");
        build.append("| RESPONSE_CODE: " +resultSet.getString("response_code")+ "\t");
        build.append("| ACCOUNT_RECEIVED_CREDIT: " +resultSet.getString("cuenta_receptora_credito")+ "\t");
        build.append("| AUTHORIZED_CREDIT: " +resultSet.getString("autorizacion_credito")+ "\t");
        build.append("| SOC_RECEIVED_CREDIT: " +resultSet.getString("socio_receptor_credito")+ "\t");
        build.append("| IS_COMPLETE: " +resultSet.getString("incomplete")+ "\t");
        build.append("\n----------------------------  ***  ----------------------------\n");
        return build.toString();
    }

}
