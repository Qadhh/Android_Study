package com.example.android_study.bean;

public class TabBean {
    private String string;
    private int menu_icon;
    private int msgCount;

    public TabBean(String string, int menu_icon, int msgCount) {
        this.string = string;
        this.menu_icon = menu_icon;
        this.msgCount = msgCount;
    }
    public String getString() {
        return string;
    }

    public int getMenu_icon() {
        return menu_icon;
    }

    public int getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(int msgCount) {
        this.msgCount = msgCount;
    }
}
