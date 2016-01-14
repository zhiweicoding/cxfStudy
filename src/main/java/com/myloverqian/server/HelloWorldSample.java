package com.myloverqian.server;

import javax.jws.WebService;

/**
 * Created by dzw on 2016/1/14.
 */

@WebService
public interface HelloWorldSample {

    String saySomething(String txt);
}
