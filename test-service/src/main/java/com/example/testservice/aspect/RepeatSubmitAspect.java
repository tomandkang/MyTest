package com.example.testservice.aspect;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Slf4j
@Aspect
@Component
public class RepeatSubmitAspect {


    private static final String puintcut = "execution(public * com.example.testservice.controller..*Controller.*(..))";

    @Pointcut(puintcut)
    public void pointcut() {
    }

    @Before(value = puintcut)
    public void before(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
    }

    /**
     * 返回结果通知
     *
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = puintcut, returning = "result")
    public void afterReturnMethod(JoinPoint joinPoint, Object result) {
        Object[] args = joinPoint.getArgs();
        log.info("请求参数：{}", JSON.toJSON(args));
        log.info("返回结果：{}", JSON.toJSON(result));
    }

    /**
     * 异常通知
     *
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = puintcut, throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Exception ex) {

    }


}
