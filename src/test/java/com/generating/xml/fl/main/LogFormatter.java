package com.generating.xml.fl.main;

import com.generating.xml.fl.action.ActionFile;
import com.generating.xml.fl.action.ActionLoggerMaster;
import com.generating.xml.fl.action.ActionXmlFile;
import com.generating.xml.fl.model.dto.LogType;
import com.generating.xml.fl.util.DebugUtility;
import com.generating.xml.fl.util.UtilityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogFormatter {

    private static Logger log = LogManager.getLogger(LogFormatter.class);


    public static void main( String[] args) {

        System.out.println("-----------  start program ------------------");
        log.debug("text log");
        log.debug("entering program communication");

        log.debug(" ----------- test generation xml header  ---------");

        String txt = DebugUtility.LogFormatHeader();
        log.debug("txt: "+ txt);
        log.debug("--------- finish test generation xml header  -------------");

        log.debug(" ----------- test generation xml body content  ---------");
        LogType type = new LogType();
        type.setContent("test contenido logger");
        type.setDate(new Date().toString());
        type.setTag(DebugUtility.TAG_INFO);
        List<LogType> listLogType = new ArrayList<>();
        listLogType.add(type);
        txt= DebugUtility.LogFormatWriteLine(listLogType);
        log.debug("txt: "+ txt);
        log.debug(" ----------- finish test generation xml body content ---------");

        log.debug(" ----------- test generation xml line content  ---------");
        type = new LogType();
        type.setContent("test contenido logger");
        type.setDate(UtilityManager.formatDateToString(new Date(), "yyyy-MM-dd'T'HH:mm:ss"));
        type.setTag(DebugUtility.TAG_INFO);
        txt= DebugUtility.LogFormatWriteLine(type);
        log.debug("txt: "+ txt);
        log.debug(" ----------- finish test generation xml line content ---------");

        log.debug(" -----------  test write file by name example.txt ---------");
        ActionFile actiofl = new ActionFile();
        String contenido = DebugUtility.LogFormatWriteLine(type);
        actiofl.writeFileTextByName("example.txt", contenido);
        log.debug(" ----------- finish write file by name example.txt ---------");

        log.debug(" -----------  test write file by name example byte ---------");
        contenido = DebugUtility.LogFormatWriteLine(type);
        actiofl.writeFileBinaryByName("example", contenido);
        log.debug(" ----------- finish write file by name example.txt ---------");

        log.debug(" ----------- text generation documet archive txt example ---------");
        LogType type1 = new LogType();
        type1.setContent("test contenido logger");
        type1.setDate(UtilityManager.formatDateToString(new Date(), "yyyy-MM-dd'T'HH:mm:ss"));
        type1.setTag(DebugUtility.TAG_INFO);

        LogType type2 = new LogType();
        type2.setContent("test contenido logger");
        type2.setDate(UtilityManager.formatDateToString(new Date(), "yyyy-MM-dd'T'HH:mm:ss"));
        type2.setTag(DebugUtility.TAG_INFO);

        StringBuilder txtBuild =  new StringBuilder();
        txtBuild.append(DebugUtility.LogFormatHeader());
        List<LogType> listLog = new ArrayList<>();
        listLog.add(type);
        listLog.add(type1);
        listLog.add(type2);
        txtBuild.append(DebugUtility.LogFormatWriteLine(listLog));
        actiofl.writeFileTextByName("example.txt", txtBuild.toString());

        log.debug(" --------------------------------------------------------------------------");
        log.debug(" --------------------------------------------------------------------------");
        log.debug(" ---------------------  //////////////////////////       ------------------");
        log.debug(" iniciando test libreria logger for generate file ");
        ActionLoggerMaster master = new ActionLoggerMaster();
        master.info("nuevo input para file info");
        master.debug("nuevo mensaje para debug");
        master.error("nuevo mensaje para error");
        master.genetaringFile("example1.txt");

        log.debug(" --------------------------------------------------------------------------");
        log.debug(" --------------------------------------------------------------------------");
        log.debug(" ---------------------  //////////////////////////       ------------------");
        log.debug(" iniciando test create file xml from class ");
        ActionXmlFile.mainTest();
        log.debug(" finish iniciando test create file xml from class ");

//        log.debug(" --------------------------------------------------------------------------");
//        log.debug(" --------------------------------------------------------------------------");
//        log.debug(" ---------------------  //////////////////////////       ------------------");
//        log.debug("test socket connection try....");
//        SocketServerManager socketManager = new SocketServerManager();
//        socketManager.init(9090);
//        socketManager.run();


    }


}
