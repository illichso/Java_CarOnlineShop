package com.sergii.caronlineshop;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "order")
public class Order {
    private String login;
    private Cars cars;

    public Order() {
    }

    public Order(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @XmlElement(name="cars")
    public void setCars(Cars cars) {
        this.cars = cars;
    }
    public Cars getCars(){
        return this.cars;
    }
}
