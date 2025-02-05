package com.mk.config;

import com.mk.interceptor.CorsInterceptor;
import com.mk.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域配置
 *
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // 替换为你的前端地址
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*") // 允许的请求头
                .allowCredentials(true) // 是否允许发送 Cookie
                .maxAge(3600); // 跨域缓存时间
    }


    /**
     * 注册登录拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // CORS 拦截器，最高优先级
        registry.addInterceptor(new CorsInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/**") // 确保 OPTIONS 请求放行
                .order(0);

        // 日志拦截器
/*        registry.addInterceptor(new LogInterceptor())
                .addPathPatterns("/**")
                .order(1);*/

        // 登录拦截器
        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns
                        (
                        "/user/login",
                        "/user/register",
                        "/user/logout",
                        "/user/test"
                        )
                .excludePathPatterns("/**") // 确保 OPTIONS 请求放行
                .order(2); // 设置拦截器的执行顺序

    }

}
