package com.generating.xml.fl.action;

import com.generating.xml.fl.model.dto.LogType;
import com.generating.xml.fl.util.DebugUtility;
import com.generating.xml.fl.util.UtilityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActionLoggerMaster {

    protected List<String> loggerCache= new ArrayList<>();
    protected List<LogType> loggerTypeCache =  new ArrayList<>();

    private LogType logType;

    public void info(String contenido){
        logType = new LogType();
        logType.setContent(contenido);
        logType.setDate(UtilityManager.formatDateToString(new Date(), "yyyy-MM-dd'T'HH:mm:ss"));
        logType.setTag(DebugUtility.TAG_INFO);
        loggerTypeCache.add(logType);
    }

    public void debug(String contenido){
        logType = new LogType();
        logType.setContent(contenido);
        logType.setDate(UtilityManager.formatDateToString(new Date(), "yyyy-MM-dd'T'HH:mm:ss"));
        logType.setTag(DebugUtility.TAG_WARNING);
        loggerTypeCache.add(logType);
    }

    public void error(String contenido){
        logType = new LogType();
        logType.setContent(contenido);
        logType.setDate(UtilityManager.formatDateToString(new Date(), "yyyy-MM-dd'T'HH:mm:ss"));
        logType.setTag(DebugUtility.TAG_ERROR);
        loggerTypeCache.add(logType);
    }

    public List<String> getLoggerCache() {
        return loggerCache;
    }

    public List<LogType> getLoggerTypeCache() {
        return loggerTypeCache;
    }

    public void genetaringFile(String root){
        ActionFile actionFile =  new ActionFile();
        String contenidoFile = DebugUtility.LogFormatWriteLine(loggerTypeCache);
        actionFile.writeFileTextByName(root, contenidoFile);
    }

}
