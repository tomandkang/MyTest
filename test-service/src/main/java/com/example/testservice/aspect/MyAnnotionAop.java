package com.example.testservice.aspect;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MyAnnotionAop {


    @Pointcut("@annotation(com.example.testservice.annotation.LogAnnotation)")
    private void pointcut() {
    }


    @Around(value = "pointcut()")
    public Object aroud(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Object result = joinPoint.proceed(args);
        log.info("请求参数：{}", JSON.toJSON(args));
        log.info("返回结果：{}", JSON.toJSON(result));
        return result;
    }

}
