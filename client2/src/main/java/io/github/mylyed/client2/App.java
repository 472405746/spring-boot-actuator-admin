package io.github.mylyed.client2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lilei on 2017/6/30.
 */
@SpringBootApplication
@Controller
public class App {

    @RequestMapping({"/", "index"})
    @ResponseBody
    public String index() {
        return "SUCCESS-CLIENT-2";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
