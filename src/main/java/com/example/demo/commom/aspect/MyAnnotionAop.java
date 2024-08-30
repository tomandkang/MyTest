package com.example.demo.commom.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Date;

@Slf4j
public class MyAnnotionAop {

   private Date parse;

    public Date getParse() {
        return parse;
    }

    public void setParse(Date parse) {
        this.parse = parse;
    }

    @Pointcut("@annotation(com.example.demo.commom.annotation.MyAnnotation)")
    private void pointcut(){

    }

    @Around(value="pointcut()")
    public Object aroud(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Object result = joinPoint.proceed(args);
        log.info("请求参数：{}", JSON.toJSON(args));
        log.info("返回结果：{}",JSON.toJSON(result));
        return result;
    }

}
