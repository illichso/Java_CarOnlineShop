package com.sergii.caronlineshop;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
public class Cars {
    private List<Car> cars;

    public Cars() {
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    @XmlElement(name="car")
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    public List<Car> getCarList(){
        return this.cars;
    }

}
