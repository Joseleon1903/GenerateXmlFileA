package com.generating.xml.fl;

import com.generating.xml.fl.connection.DatabaseNeoConnection;
import com.generating.xml.fl.connection.DatabaseTxnConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.generating.xml.fl.util.IntroLogUtility.DAILY_TRANSACTION;

/**
 * A Camel Application
 */
public class MainApp {


    private static Logger log = LogManager.getLogger(MainApp.class);

    public static void main(String... args) throws Exception {
        //init variable recurency

        DatabaseNeoConnection data = new DatabaseNeoConnection();
        data.searchAllDevice();
        data.connectionSearchByEmail("fgenao@gcs-systems.com");
        data.connectionSearchByEmailAndDevice("fgenao@gcs-systems.com");
        DatabaseTxnConnection txnDb = new DatabaseTxnConnection();
        txnDb.searchGcsCustomerByIdentificationNumber("12345678");
        log.debug(DAILY_TRANSACTION);
        txnDb.searchGcsdailyTransactionByDate();
    }


}

//        Thread t = new Thread(){
////            public void run() {
////
////                while(true){
////                    try {
////                        Thread.sleep(600000);
////                        data.connectionSearchByEmailAndDevice("fgenao@gcs-systems.com");
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                }
////
////            }
////        };
////        t.start();