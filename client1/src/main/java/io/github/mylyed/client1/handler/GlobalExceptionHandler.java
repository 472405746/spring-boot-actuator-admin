package io.github.mylyed.client1.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一异常处理器
 */
@EnableWebMvc
@ControllerAdvice
@Slf4j
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Map<String, Object> signException(Exception ex) {
        log.error("出错了", ex);
        Map<String, Object> map = new HashMap<>();
        map.put("SUCCESS", false);
        map.put("MSG", ex.getMessage());
        map.put("EXCEPTION", ex.getClass().getName());
        return map;
    }

}  