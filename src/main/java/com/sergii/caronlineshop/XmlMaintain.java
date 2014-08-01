package com.sergii.caronlineshop;

import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.List;

public class XmlMaintain {

    public XmlMaintain() {
    }

    public static Object unMarshall(HttpSession session,XmlType xmlType) {
        Object object=null;
        try {
            String fileName="";
            Class className=null;
            switch (xmlType) {
                case USERS:
                    fileName="/UsersXml";
                    className=Users.class;
                    break;
                case ORDERS:
                    fileName="/OrdersXml";
                    className=Orders.class;
                    break;
            }
            JAXBContext jc = JAXBContext.newInstance(className);
            String serverRootPath = session.getServletContext().getRealPath("/") + fileName;
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            File file = new File(serverRootPath);
            object = (Object) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return object;
    }
    public static void  Marshall(HttpSession session,Object object){

        try {
            String fileName="";
            Class className=null;
            if(object instanceof Users) {
                fileName = "/UsersXml";
                className = Users.class;
            }else if(object instanceof Orders) {
                fileName = "/OrdersXml";
                className = Orders.class;
            }
            JAXBContext jc = JAXBContext.newInstance(className);
            String serverRootPath = session.getServletContext().getRealPath("/") + fileName;
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);

            File file = new File(serverRootPath);

            OutputStream os = new FileOutputStream(file);
            m.marshal(object,file);
            os.close();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
