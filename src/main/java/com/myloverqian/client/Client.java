package com.myloverqian.client;


import com.myloverqian.server.HelloWorld;
import com.myloverqian.server.bean.User;
import com.myloverqian.server.bean.impl.UserImpl;

import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

/**
 * Created by zhiwei on 2016/1/13.
 */

public final class Client {

    private static final QName SERVICE_NAME = new QName("http://server.myloverqian.com/", "HelloWorld");
    private static final QName PORT_NAME = new QName("http://server.myloverqian.com/", "HelloWorldPort");


    private Client() {
    }

    public static void main(String args[]) throws Exception {
        Service service = Service.create(SERVICE_NAME);
        // Endpoint Address
        String endpointAddress = "http://localhost:9000/cxfstudy/services/hello_world";
        // If web service deployed on Tomcat (either standalone or embedded)
        // as described in sample README, endpoint should be changed to:
        // String endpointAddress = "http://localhost:8080/java_first_jaxws/services/hello_world";

        // Add a port to the Service
        service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);

        HelloWorld hw = service.getPort(HelloWorld.class);
        System.out.println(hw.sayHi("World"));

        User user = new UserImpl("World");
        System.out.println(hw.sayHiToUser(user));

        //say hi to some more users to fill up the map a bit
        user = new UserImpl("Galaxy");
        System.out.println(hw.sayHiToUser(user));

        user = new UserImpl("Universe");
        System.out.println(hw.sayHiToUser(user));

        System.out.println();
        System.out.println("Users: ");
        Map<Integer, User> users = hw.getUsers();
        for (Map.Entry<Integer, User> e : users.entrySet()) {
            System.out.println("  " + e.getKey() + ": " + e.getValue().getName());
        }

    }

}
