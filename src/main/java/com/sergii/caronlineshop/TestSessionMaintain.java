//package com.sergii.caronlineshop;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
////import org.mockito.*;
//
//@RunWith(PowerMockRunner.class)
//@PrepareForTest(SessionMaintain.class)
//public class TestSessionMaintain {
//    @Test
//    public void testSetAttribute() throws Exception {
//
//        HttpServletRequest request = (HttpServletRequest)PowerMockito.mock(HttpServletRequest.class);
//        HttpServletResponse response = (HttpServletResponse)PowerMockito.mock(HttpServletResponse.class);
//        HttpSession session = (HttpSession)PowerMockito.mock(HttpSession.class);
//        session = request.getSession();
//
////        HttpSession httpSession = mock(HttpSession.class);
////        PowerMockito.mockStatic(SessionMaintain.class);
//        SessionMaintain.setAttribute(session, "login", "user1");
//        Assert.assertEquals("user1", SessionMaintain.getAttribute(session, "login"));
////        Mockito.when(SessionMaintain.getAttribute(httpSession,"login")).thenReturn("user1");
//    }
//    //    HttpServletRequest request;
////    HttpServletRequest response;
////    HttpSession httpSession;
//
////    public TestSessionMaintain() {
////         request = mock(HttpServletRequest.class);
////         response = mock(HttpServletRequest.class);
////         httpSession = mock(HttpSession.class);
////    }
//
//}
