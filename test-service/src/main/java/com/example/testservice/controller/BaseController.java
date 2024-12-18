package com.example.testservice.controller;

import com.example.testcommon.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * controller基础类
 *
 * @author lghuntfor
 * @since 2018/7/4
 */
public class BaseController {
    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 请求异常处理
     */
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Result exceptionHandler(Exception ex, HttpServletRequest request) throws IOException {
        Result result = new Result();
        result.setErrorMessage(100, "系统异常");
        logger.error(this.getErrorMsg(request), ex);
        return result;
    }

    private String getErrorMsg(HttpServletRequest request) {
        StringBuilder errorMsg = new StringBuilder("===exception handler===, url=").append(request.getRequestURL());
        errorMsg.append(", jsessionid=").append(getJSessionId(request));
        errorMsg.append("\n");
        return errorMsg.toString();
    }

    public String getJSessionId(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("jeesite.session.id".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

}
