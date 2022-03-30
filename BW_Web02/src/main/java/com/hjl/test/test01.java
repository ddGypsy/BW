package com.hjl.test;

import com.hjl.Bean.DataTest;
import com.hjl.Service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("")
public class test01 {

    @Resource
    private DataService dataService;

    @GetMapping("/getAll")
    public Map getUserList(){
        HashMap map = new HashMap();
        List<DataTest> list = dataService.queryAll();
        String pro = "pro02";
        map.put("list",list);
        map.put("pro",pro);
        int i = new Random().nextInt(3000);
        System.out.println("用户提供者2睡了"+i+"秒");
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map;
    }
}
