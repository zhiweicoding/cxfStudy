package com.myloverqian.server.impl;

import com.myloverqian.server.HelloWorldSample;

import javax.jws.WebService;

/**
 * Created by dzw on 2016/1/14.
 */
@WebService(endpointInterface = "com.myloverqian.server.HelloWorldSample", serviceName = "HelloWorldSample")
public class HelloWorldSampleImpl implements HelloWorldSample {

    @Override
    public String saySomething(String txt) {
        System.out.println("Client say:" + txt);
        return "Client say:" + txt;
    }
}
