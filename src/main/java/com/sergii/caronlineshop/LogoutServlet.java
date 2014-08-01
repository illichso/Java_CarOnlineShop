package com.sergii.caronlineshop;


import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet{
    public LogoutServlet() {
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        try {
            SessionMaintain.clearAllAttributes(req.getSession());
            resp.sendRedirect("/index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
