package com.sergii.caronlineshop;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

public class LoginServlet extends HttpServlet {
    private Users users;
    private List<User> userList;
    private Orders orders;
    private List<Order> orderList;


    public void fieldsCheck(HttpSession session){
        if(users==null){
            users=(Users)XmlMaintain.unMarshall(session,XmlType.USERS);
            userList=users.getUsers();
        }
        if(orders==null){
            orders=(Orders)XmlMaintain.unMarshall(session,XmlType.ORDERS);
            orderList=orders.getOrders();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        fieldsCheck(session);
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("<h2>Please, login</h2><br/>");
        out.print("<form name=\"input\" action=\"/login\" method=\"POST\">\n" +
                "Login: <input type=\"text\" name=\"login\">\n" +
                "<br/>"+
                "Password: <input type=\"password\" name=\"password\">\n" +
                "<br/>"+
                "<input type=\"submit\" value=\"Submit\">\n" +
                "</form>");
        out.print("</body></html>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        fieldsCheck(session);
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if(login=="" || password==""){
            resp.sendRedirect("/login");
        }
        else{
            boolean found =false;
            boolean passwordMatch=true;
            for(User us: userList){
                if(us.getLogin().equals(login)){
                    if(!us.getPassword().equals(password)){
                        ((HttpServletResponse)resp).sendError(403,"The password is incorrect!");
                        passwordMatch=false;
                    }
                    found = true;
                    break;
                }
            }
            if(!found) {
                userList.add(new User(login, password));
                users.setUsers(userList);
                XmlMaintain.Marshall(session,users);
            }
            if(passwordMatch) {
                setSessionAttributes(login, req);
                resp.sendRedirect("/orders.jsp");
            }
        }
    }

    public void setSessionAttributes(String login,HttpServletRequest req){
        HttpSession session = req.getSession();
        SessionMaintain.setAttribute(session,"login", login);
        SessionMaintain.setAttribute(session,"allOrders", orders);
        Order newOrder=null;
        for (Order order : orderList) {
            if (order.getLogin()!=null && order.getLogin().equals(login)) {
                newOrder=order;
                break;
            }
        }
        SessionMaintain.setAttribute(session,"order", newOrder);
    }
}
