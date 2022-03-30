package com.hjl.Interface;

import com.hjl.Interface.Impl.test01Impl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Component
@FeignClient(name = "BWWeb",fallback = test01Impl.class)
public interface test01 {

    @GetMapping("/getAll")
    Map getUserList();
}
