//package com.sergii.caronlineshop;
//
//
//import junit.framework.TestCase;
//import org.junit.Assert;
//import org.mockito.Mockito;
//import org.powermock.api.mockito.PowerMockito;
//
//import javax.servlet.http.HttpSession;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestOrderMaintain extends TestCase {
//    private Car car1;
//    private Car car2;
//    private List<Car> carList;
//    private Cars cars;
//    private Order order;
//    private List<Order>orderList;
//    private Orders orders;
//
//    public TestOrderMaintain(){
//        car1 = new Car("audi",220);
//        car2 = new Car("BMV",210);
//        carList = new ArrayList<Car>();
//        carList.add(car1);
//        carList.add(car2);
//        cars = new Cars();
//        cars.setCars(carList);
//        order = new Order();
//        order.setLogin("user1");
//        order.setCars(cars);
//        orderList = new ArrayList<Order>();
//        orderList.add(order);
//        orders = new Orders();
//        orders.setOrders(orderList);
//    }
//
//    public void testSetCars() throws Exception {
//        Order tempOrder;
////        HttpServletRequest request = (HttpServletRequest) PowerMockito.mock(HttpServletRequest.class);
////        HttpServletResponse response = (HttpServletResponse)PowerMockito.mock(HttpServletResponse.class);
//        HttpSession session = (HttpSession)PowerMockito.mock(HttpSession.class);
//        Mockito.when(SessionMaintain.getAttribute(session, "login")).thenReturn("user1");
//        Mockito.when(SessionMaintain.getAttribute(session, "allOrders")).thenReturn(orders);
//        Mockito.when(SessionMaintain.getAttribute(session, "order")).thenReturn(order);
//
////        HttpSession session=request.getSession();
//        OrderMaintain orderMaintain = new OrderMaintain(session);
//        orderMaintain.setCars();
//        Assert.assertEquals("Order is wrong",null,orderMaintain.getCarList());
//
//    }
//}
