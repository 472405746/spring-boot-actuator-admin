package io.github.mylyed.client1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lilei on 2017/6/30.
 */
@SpringBootApplication
@Controller
public class App {

    @RequestMapping({"/", "/index"})
    @ResponseBody
    public String index() {
        return "SUCCESS-CLIENT-1";
    }

    @RequestMapping("/api/v1/order")
    @ResponseBody
    public String api() {
        return "PASS";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }

}