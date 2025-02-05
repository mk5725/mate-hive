package com.mk.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 跨域拦截器
 */
@Slf4j
public class CorsInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000"); // 替换为你的前端地址
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // 如果是预检请求，直接返回成功响应
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            log.info("CorsInterceptor OPTIONS预处理->{}", request.getRequestURI());
            response.setStatus(HttpServletResponse.SC_OK);
            return false; // 不继续后续处理
        }
        return true; // 继续处理实际请求
    }
}
