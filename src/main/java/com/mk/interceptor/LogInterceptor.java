package com.mk.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * 日志拦截器
 */
public class LogInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = Logger.getLogger(LogInterceptor.class.getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info("Incoming request: " + request.getMethod() + " " + request.getRequestURI());
        return true; // 继续后续处理
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOGGER.info("Completed request: " + request.getMethod() + " " + request.getRequestURI() + " with status " + response.getStatus());
    }
}
