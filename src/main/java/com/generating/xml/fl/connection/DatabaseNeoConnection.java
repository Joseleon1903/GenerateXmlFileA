package com.generating.xml.fl.connection;

import com.generating.xml.fl.MainApp;
import com.generating.xml.fl.connection.dto.QuerySearchByEmailResulset;
import com.generating.xml.fl.format.FormatRowString;
import com.generating.xml.fl.util.ConstatntQueryUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;

public class DatabaseNeoConnection {

    private static Logger log = LogManager.getLogger(MainApp.class);
    private static String neoIp = "10.225.192.61";
    private static String neoIpLocal= "localhost";

    private static int neoPort= 5432;
    private static String username= "wbinet";
    private static String password = "Prueba100";

    public DatabaseNeoConnection(){}

    public void searchAllDevice(){

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://"+neoIp+":5432/neo", username, password);
            log.debug("Java JDBC PostgreSQL Example");
            log.debug("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            log.debug("Reading car records...");
            ResultSet resultSet = statement.executeQuery("select * from device");
            while (resultSet.next()) {
                log.debug(FormatRowString.formatStringSearchAllDeviceRow(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }

    }

    public void connectionSearchByEmail(String email){

        try {
            log.debug("getting the connection with database......");
            Connection connection = getConnection();
            String sqlQuery = ConstatntQueryUtility.QUERY_SEARCH_BY_EMAIL;
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            log.debug("create Statement....");
            statement.setString(1, email);
            statement.setString(2, email);
            log.debug("prepared query: "+ sqlQuery);
            ResultSet resultSet = statement.executeQuery();
            QuerySearchByEmailResulset result = new QuerySearchByEmailResulset();
            while (resultSet.next()) {
                log.debug(FormatRowString.formatStringSearchDeviceByEmailRow(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }

    }

    public void connectionSearchByEmailAndDevice(String email){

        try {
            log.debug("getting the connection with database......");
            Connection connection = getConnection();
            String sqlQuery = ConstatntQueryUtility.QUERY_DEVICE_USER_BY_EMAIL_ACTIVE;
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            log.debug("create Statement....");
            statement.setString(1, email);
            statement.setString(2, email);
            log.debug("prepared query: "+ sqlQuery);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                log.debug(FormatRowString.formatStringSearchDeviceActiveAndEmailRow(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }

    }

    public Connection getConnection() throws  SQLException{
        return DriverManager.getConnection("jdbc:postgresql://"+neoIp+":5432/neo", username, password);
    }
}
