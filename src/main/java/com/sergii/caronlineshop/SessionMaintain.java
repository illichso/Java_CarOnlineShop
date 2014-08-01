package com.sergii.caronlineshop;

//import org.powermock.core.classloader.annotations.PrepareForTest;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;


public class SessionMaintain {
    public SessionMaintain() {
    }

    public static void setAttribute(HttpSession session,String attrName, Object attrValue){
        session.setAttribute(attrName, attrValue);
    }
    public static Object getAttribute(HttpSession session,String attrName){
        return (Object)session.getAttribute(attrName);
    }
    public static void clearAllAttributes(HttpSession session){
        Enumeration attrName = session.getAttributeNames();
        while (attrName.hasMoreElements()) {
            setAttribute(session,(String) attrName.nextElement(),null);
        }
    }
}
