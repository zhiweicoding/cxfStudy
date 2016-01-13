package com.myloverqian.server;

import javax.jws.WebService;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zhiwei on 2016/1/13.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


// START SNIPPET: service
@WebService(endpointInterface = "com.myloverqian.server.HelloWorld", serviceName = "HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    Map<Integer, User> users = new LinkedHashMap<Integer, User>();

    public String sayHi(String text) {
        System.out.println("sayHi called");
        return "Hello " + text;
    }

    public String sayHiToUser(User user) {
        System.out.println("sayHiToUser called");
        users.put(users.size() + 1, user);
        return "Hello " + user.getName();
    }

    public Map<Integer, User> getUsers() {
        System.out.println("getUsers called");
        return users;
    }

}
// END SNIPPET: service