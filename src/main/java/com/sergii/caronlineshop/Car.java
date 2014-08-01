package com.sergii.caronlineshop;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car")
public class Car {
    private String brand;
    private double maxSpeed;

    public Car() {
    }

    public Car(String brand, double maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    public Car(String brand, int yearOfProduction, double maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    public String printCar(){
         return "Car brand: " + getBrand()+"; maxSpeed: "+getMaxSpeed();
    }

}
