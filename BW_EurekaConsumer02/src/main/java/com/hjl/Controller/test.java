package com.hjl.Controller;

import com.hjl.Interface.test01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class test {
    @Autowired
    private test01 test01;

    @GetMapping("/getAll")
    public Map test(){
        Map map = test01.getUserList();
        String Consumer = "Consumer02";
        String pro = (String) map.get("pro");
        System.out.println(Consumer+"|"+pro);
        return map;
    }
}
