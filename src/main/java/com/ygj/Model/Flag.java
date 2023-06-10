package com.ygj.Model;

/**
 * @Author 微风
 * @Version 1.0.1
 * @StartTime Start
 * @EndTime End
 */
public class Flag {
    private int id=1;
    private String flagName;
    private String flagButton;

    public Flag() {
    }

    public Flag(int id, String flagName,String flagButton) {
        this.id = id;
        this.flagName = flagName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }

    public String getFlagButton() {
        return flagButton;
    }

    public void setFlagButton(String flagButton) {
        this.flagButton = flagButton;
    }
}
