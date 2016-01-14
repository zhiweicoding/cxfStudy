package com.myloverqian.server;

import com.myloverqian.server.impl.HelloWorldImpl;
import com.myloverqian.server.impl.HelloWorldSampleImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by zhiwei on 2016/1/13.
 */

public class Server {

    protected Server() throws Exception {
        System.out.println("Starting Server");
        HelloWorldImpl implementor = new HelloWorldImpl();
        String address = "http://localhost:9000/helloWorld";
        Endpoint.publish(address, implementor);

        /** sample version **/
        HelloWorldSample sample = new HelloWorldSampleImpl();
        String addressSample = "http://localhost:9000/helloWorldSample";
        Endpoint.publish(addressSample, sample);
    }

    public static void main(String args[]) throws Exception {
        new Server();
        System.out.println("Server ready...");

        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
    }
}
