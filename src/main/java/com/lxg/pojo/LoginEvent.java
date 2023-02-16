package com.lxg.pojo;

import java.util.EventObject;

public class LoginEvent extends EventObject {

    private String username;

    private String password;

    public LoginEvent(Object source,String username,String password) {
        super(source);
        this.username=username;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
