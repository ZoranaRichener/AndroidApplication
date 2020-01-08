package com.example.ladyzorzy.peakselapp.data;

public class Notification {

    private String name,hideFlags,notificationName,xmlIndex;

    public Notification() {
    }

    public Notification(String name, String hideFlags, String notificationName, String xmlIndex) {
        this.name = name;
        this.hideFlags = hideFlags;
        this.notificationName = notificationName;
        this.xmlIndex = xmlIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHideFlags() {
        return hideFlags;
    }

    public void setHideFlags(String hideFlags) {
        this.hideFlags = hideFlags;
    }

    public String getNotificationName() {
        return notificationName;
    }

    public void setNotificationName(String notificationName) {
        this.notificationName = notificationName;
    }

    public String getXmlIndex() {
        return xmlIndex;
    }

    public void setXmlIndex(String xmlIndex) {
        this.xmlIndex = xmlIndex;
    }
}
