package com.myloverqian.server;

import com.myloverqian.server.IntegerUserMap;
import com.myloverqian.server.bean.User;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zhiwei on 2016/1/13.
 */
public class IntegerUserMapAdapter extends XmlAdapter<IntegerUserMap, Map<Integer, User>> {
    public IntegerUserMap marshal(Map<Integer, User> v) throws Exception {
        IntegerUserMap map = new IntegerUserMap();
        for (Map.Entry<Integer, User> e : v.entrySet()) {
            IntegerUserMap.IntegerUserEntry iue = new IntegerUserMap.IntegerUserEntry();
            iue.setUser(e.getValue());
            iue.setId(e.getKey());
            map.getEntries().add(iue);
        }
        return map;
    }

    public Map<Integer, User> unmarshal(IntegerUserMap v) throws Exception {
        Map<Integer, User> map = new LinkedHashMap<Integer, User>();
        for (IntegerUserMap.IntegerUserEntry e : v.getEntries()) {
            map.put(e.getId(), e.getUser());
        }
        return map;
    }

}