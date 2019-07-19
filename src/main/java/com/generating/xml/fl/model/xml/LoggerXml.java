package com.generating.xml.fl.model.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="LOGGER")
public class LoggerXml {

    private List<LoggerRow> loggerRows;

    public LoggerXml() {
    }

    public List<LoggerRow> getLoggerRows() {
        return loggerRows;
    }

    @XmlElement(name = "LOGGER_ROW")
    public void setLoggerRows(List<LoggerRow> loggerRows) {
        this.loggerRows = loggerRows;
    }
}
