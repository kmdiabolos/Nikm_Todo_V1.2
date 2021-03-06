package com.example.nikm_todo_v11;

import java.io.Serializable;

public class MainData implements Serializable {

    private String tv_time;
    private String tv_do;
    private String tv_value;

    public MainData(String tv_time, String tv_do, String tv_value) {
        this.tv_time = tv_time;
        this.tv_do = tv_do;
        this.tv_value = tv_value;
    }

    public String getTv_time() {
        return tv_time;
    }

    public void setTv_time(String tv_time) {
        this.tv_time = tv_time;
    }

    public String getTv_do() {
        return tv_do;
    }

    public void setTv_do(String tv_do) {
        this.tv_do = tv_do;
    }

    public String getTv_value() {
        return tv_value;
    }

    public void setTv_value(String tv_value) {
        this.tv_value = tv_value;
    }
}
