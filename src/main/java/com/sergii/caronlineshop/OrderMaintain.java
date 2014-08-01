package com.sergii.caronlineshop;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class OrderMaintain {
    private HttpSession session;
    private Orders orders;
    private List<Order> orderList;
    private Order order;
    private Cars cars;
    private List<Car> carList ;

    public OrderMaintain(HttpSession session) {
        this.session = session;
        orders = (Orders)SessionMaintain.getAttribute(session,"allOrders");
        order = (Order)SessionMaintain.getAttribute(session,"order");
        cars=new Cars();
        carList = new ArrayList<Car>();
    }
    public void setCars(){
        if (order != null) {
            cars = order.getCars();
            carList = cars.getCarList();
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
    public void addNewOrder(String brand,String maxSpeed){
        if (brand!=null && brand!="" && maxSpeed!= null && maxSpeed!="" ){
            carList.add(new Car(brand, Double.parseDouble(maxSpeed)));
            cars.setCars(carList);
            if(order==null){
                order = new Order((String)session.getAttribute("login"));
            }
            order.setCars(cars);
            orderList = orders.getOrders();
            if(orderList.contains(order)) {
                orderList.set(orderList.indexOf(order), order);
            }else{
                orderList.add(order);
            }
            orders.setOrders(orderList);
            XmlMaintain.Marshall(session, orders);
            SessionMaintain.setAttribute(session,"order",order);
            SessionMaintain.setAttribute(session,"allOrders",orders);
        }
    }
    public boolean carListSizenotZero(){
        return carList.size() !=0;
    }
}
