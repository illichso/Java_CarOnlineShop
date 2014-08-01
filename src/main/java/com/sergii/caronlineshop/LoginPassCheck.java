package com.sergii.caronlineshop;


import javax.servlet.http.HttpSession;

public class LoginPassCheck {
    public LoginPassCheck() {
    }

    public static Boolean isLoggedIn(HttpSession session){
        return SessionMaintain.getAttribute(session,"login")!=null;
    }

}
