package com.sergii.caronlineshop;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

//@XmlType
//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "user", propOrder = {
//        "login",
//        "password",
//        "cars"
//})
@XmlRootElement(name = "user")
//@XmlAccessorType (XmlAccessType.FIELD)
public class User {
    private String login;
    private String password;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public  void printUser(){
        System.out.println("Login: " + getLogin()+"; password: "+getPassword());

    }
}
