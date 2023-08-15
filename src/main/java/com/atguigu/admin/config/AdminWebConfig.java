package com.atguigu.admin.config;

import com.atguigu.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 1. 编写一个拦截器实现`HandlerInterceptor`接口
 *
 * 2. 拦截器注册到容器中（实现`WebMvcConfigurer`的`addInterceptors()`）
 *
 * 3. 指定拦截规则 注意 ，如果是拦截所有，静态资源也会被拦截】
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //这里 会拦截所有 动态和静态资源请求
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");//不拦截登录页和静态资源
    }
}
