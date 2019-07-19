package com.generating.xml.fl.model.dto;

public class LogType {

    private String date;
    private String content;
    private String tag;

    public LogType() { }

    public LogType(String date, String content, String tag) {
        this.date = date;
        this.content = content;
        this.tag = tag;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
