package com.generating.xml.fl.model.xml;

import javax.xml.bind.annotation.XmlAttribute;

public class LoggerRow {

    private String date;
    private String tag;
    private String content;

    public LoggerRow(){}

    public String getDate() {
        return date;
    }

    @XmlAttribute(name = "DATE")
    public void setDate(String date) {
        this.date = date;
    }

    public String getTag() {
        return tag;
    }

    @XmlAttribute(name = "TAG")
    public void setTag(String tag) {
        this.tag = tag;
    }

    @XmlAttribute(name = "CONTENT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
