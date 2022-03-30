package com.hjl.Interface.Impl;

import com.hjl.Interface.test01;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class test01Impl implements test01 {

    @Override
    public Map getUserList() {
        HashMap map = new HashMap();
        String res = "调用失败，开启熔断。";
        map.put("res",res);
        return map;
    }

}
