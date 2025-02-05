package com.mk.interceptor;

import com.mk.model.domain.User;
import com.mk.common.ErrorCode;
import com.mk.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.mk.constant.UserConstant.USER_LOGIN_STATE;

/**
 * 全局登录检验拦截器
 */
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("登录检验请求拦截器执行: {}", request.getRequestURI());
        User user = (User) request.getSession().getAttribute(USER_LOGIN_STATE);
        if (user == null)
            throw new BusinessException(ErrorCode.NOT_LOGIN);
        return true;
    }
}
