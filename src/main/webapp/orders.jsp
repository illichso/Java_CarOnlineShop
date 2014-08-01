<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.IOException" %>
<%@ page import="com.sergii.caronlineshop.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  session = request.getSession();
    OrderMaintain orderMaintain = new OrderMaintain(session);
if(!LoginPassCheck.isLoggedIn(session)){
        ((HttpServletResponse)response).sendRedirect("/login");
    }else {
        orderMaintain.setCars();
%>
<html>
<head>
    <title>Your orders</title>
</head>

<% orderMaintain.addNewOrder(request.getParameter("brand"),request.getParameter("maxSpeed"));
%>


<body>
<h2>Hello, <%=session.getAttribute("login")%>!</h2>

<form action="/LogoutServlet" method = "POST">
    <input type="submit" name="logoutButton" value="Logout">
</form>

<form>
    <% if(orderMaintain.carListSizenotZero()){%>
    <h3>Your orders are:</h3>
    <% int carCount=1;
        for(Car car: orderMaintain.getCarList()){ %>
    <ol type="1">
        <% out.print("Car "+carCount + ":");%>
        <ul>
            <li><% out.print("Brand: " + car.getBrand()+";"); %></li>
            <li><% out.print("Max speed: " + car.getMaxSpeed()+".");
                carCount++;%></li>
        </ul>
    </ol>
    <%}
    }
    else {%>
    <h3>You have no orders yet. Make new order in the form below:</h3>
    <%}%>
</form>

<form action="orders.jsp" method = "POST">
    <h3>Order new car:</h3>
    Car brand: <input type="text" name="brand" >
    <br/>
    Max speed: <input type="number" name="maxSpeed" >
    <br/>
    <input type="submit" value="Submit">
</form>

</body>
</html>
<%}%>

