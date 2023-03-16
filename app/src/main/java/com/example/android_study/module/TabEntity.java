package com.example.android_study.module;

public class TabEntity {
    private String tabName;
    private int tabIcon;

    public void setMsgCount(int msgCount) {
        this.msgCount = msgCount;
    }

    private int msgCount;

    public String getTabName() {
        return tabName;
    }

    public int getTabIcon() {
        return tabIcon;
    }

    public int getMsgCount() {
        return msgCount;
    }

    public TabEntity(String string, int tabIcon, int msgCount) {
    }
}
