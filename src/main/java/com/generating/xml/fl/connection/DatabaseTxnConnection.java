package com.generating.xml.fl.connection;

import com.generating.xml.fl.MainApp;
import com.generating.xml.fl.format.FormatRowString;
import com.generating.xml.fl.util.ConstatntQueryUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;

public class DatabaseTxnConnection {

    private static Logger log = LogManager.getLogger(MainApp.class);
    private static String txnIp = "10.225.192.121";

    private static int txnPort= 55431;
    private static String username= "pdidev";
    private static String password = "pdidev2018";

    public DatabaseTxnConnection(){}

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://"+txnIp+":"+txnPort+"/txndev", username, password);
    }


    public void searchGcsCustomerByIdentificationNumber(String identification){
        try {
            Connection connection = getConnection();
            String sqlQuery = ConstatntQueryUtility.QUERY_CUSTOMER_BY_IDENTIFICATION_NUMBER;
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            log.debug("create Statement....");
            statement.setString(1, identification);
            log.debug("prepared query: "+ sqlQuery);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                log.debug(FormatRowString.formatStringCustomerByIdentificationNumberRow(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    public void searchGcsdailyTransactionByDate(){
        try {
            Connection connection = getConnection();
            String sqlQuery = ConstatntQueryUtility.QUERY_DAILY_TRANSACTION;
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            log.debug("prepared query: "+ sqlQuery);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                log.debug(FormatRowString.formatStringDailyTransactionRow(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }

    }


}
