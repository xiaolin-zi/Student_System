package com.lxg.listener;

import com.lxg.pojo.LoginEvent;

import java.util.EventListener;

public interface LoginEventListener extends EventListener {
    public void validateLogin(LoginEvent event);
}
