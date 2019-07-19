package com.generating.xml.fl.connection.dto;

public class QuerySearchByEmailResulset {

    private long id;
    private boolean active;
    private boolean blocked;
    private String email;
    private String userName;
    private long idDevice;
    private String deviceName;
    private String msisdn;

    public QuerySearchByEmailResulset(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(long idDevice) {
        this.idDevice = idDevice;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    @Override
    public String toString() {
        return "QuerySearchByEmailResulset{" +
                "id=" + id +
                ", active=" + active +
                ", blocked=" + blocked +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", idDevice=" + idDevice +
                ", deviceName='" + deviceName + '\'' +
                ", msisdn='" + msisdn + '\'' +
                '}';
    }
}
