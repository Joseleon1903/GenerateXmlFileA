package com.generating.xml.fl.util;

import com.generating.xml.fl.MainApp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilityManager {

    private static Logger logger = LogManager.getLogger(MainApp.class);

    private UtilityManager(){}

    public static String formatDateToString(Date dateTransaction, String stringFormat){
        logger.info("Entering in formatDateToString");
        logger.info("dateTransaction =" + dateTransaction);
        logger.info("stringFormat =" + stringFormat);
        DateFormat df = new SimpleDateFormat(stringFormat);
        String dateFormated = df.format(dateTransaction);
        logger.info("dateFormat = "+dateFormated);
        return dateFormated;
    }

}
