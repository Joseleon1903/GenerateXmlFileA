package com.generating.xml.fl.util;

import com.generating.xml.fl.model.dto.LogType;
import java.util.List;

public class DebugUtility {

    private DebugUtility(){}

    public static String LogFileName= "phoneLog.txt";

    public static String XML_HEADER= "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    public static String XML_PARENT= "<LOGGER>";
    public static String XML_PARENT_CLOSE= "</LOGGER>";
    public static String XML_SPACE= " ";

    public static String TAG_ERROR= "ERROR";
    public static String TAG_INFO= "INFO";
    public static String TAG_WARNING= "WARNING";

    public static String DATE_XML= "DATE=";
    public static String TAG_XML= "TAG=";
    public static String CONTENT_XML= "CONTENT=";

    public static String LOGGER_ROW = "<LOGGER_ROW ";
    public static String LOGGER_ROW_CLOSE = "</LOGGER_ROW>";
    public static char DOUBLE_CUOTES= '"';

    public static String LogFormatHeader(){
        StringBuilder buildStr = new StringBuilder();
        buildStr.append(XML_HEADER);
        return buildStr.toString();
    }

    public static String LogFormatWriteLine(List<LogType> content){
        StringBuilder builStr = new StringBuilder();
        builStr.append(XML_PARENT);
        for (LogType cont : content) {
            builStr.append(LOGGER_ROW);
            builStr.append(writeLine(cont));
            builStr.append(LOGGER_ROW_CLOSE);
        }
        builStr.append(XML_PARENT_CLOSE);
        return builStr.toString();
    }

    public static String LogFormatWriteLine(LogType content){
        StringBuilder builStr = new StringBuilder();
        builStr.append(XML_PARENT);
        builStr.append(LOGGER_ROW);
        builStr.append(writeLine(content));
        builStr.append(LOGGER_ROW_CLOSE);
        builStr.append(XML_PARENT_CLOSE);
        return builStr.toString();
    }

    public static String writeLine(LogType input){
        StringBuilder builStr = new StringBuilder();
        builStr.append(DATE_XML +DOUBLE_CUOTES+ input.getDate()+ DOUBLE_CUOTES +XML_SPACE);
        builStr.append(TAG_XML +DOUBLE_CUOTES+ input.getTag()+DOUBLE_CUOTES +XML_SPACE);
        builStr.append(CONTENT_XML +DOUBLE_CUOTES+ input.getContent()+DOUBLE_CUOTES+">" +XML_SPACE);
        return builStr.toString();
    }

    public static String LogFormatCloser(){
        StringBuilder builStr = new StringBuilder();
        builStr.append(XML_HEADER);
        return builStr.toString();
    }

}
