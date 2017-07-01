package io.github.mylyed.client1.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ControllerMonitor {
    @Autowired
    private CounterService counterService;

    @Autowired
    private GaugeService gaugeService;

    @Around("execution(* io.github.mylyed.client1.controller.*.*(..))")
    public Object latencyService(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            Object obj = pjp.proceed();//调用执行目标方法
            counterService.increment(pjp.getSignature().toString() + "调用次数" + "");
            return obj;
        } catch (Throwable throwable) {
            log.error("环绕出错", throwable);
            throw throwable;
        } finally {
            long end = System.currentTimeMillis();
            gaugeService.submit(pjp.getSignature().toString() + "耗时", end - start);
        }
    }
}