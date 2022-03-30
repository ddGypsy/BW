package com.hjl.Interface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "BWWeb")
@Component
public interface test01 {

    @GetMapping("/getAll")
    Map getUserList();
}
