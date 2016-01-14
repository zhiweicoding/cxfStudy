package com.myloverqian.client;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * Created by zhiwei on 2016/1/14.
 */
public class ClientSample {

    private static final String address = "http://localhost:9000/services/hello_world_sample?wsdl";

    public ClientSample() {
    }

    public static void main(String[] args) throws Exception {
        JaxWsDynamicClientFactory clientFactory =  JaxWsDynamicClientFactory.newInstance();
        Client client = clientFactory.createClient(address);
        Object[] res = client.invoke("saySomething", "hello");
        System.out.println(res[0]);
    }
}
