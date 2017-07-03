package io.github.mylyed.client1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lilei on 2017/7/1.
 */
@RestController
public class IndexController {

    @RequestMapping({"/", "/index"})

    public String index() {
        return "SUCCESS-CLIENT-1";
    }

    @RequestMapping("/api/v1/order")
    @ResponseBody
    public String api() {
        return "PASS";
    }

    @RequestMapping("/api/e")
    @ResponseBody
    public String e() {
        if (1 == 1) {
            throw new RuntimeException("模拟异常");
        }
        return "PASS";
    }

    @GetMapping("/get")
    @ResponseBody
    public String p(String p) {
        return "p:" + p;
    }
}
