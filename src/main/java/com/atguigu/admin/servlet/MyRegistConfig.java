package com.atguigu.admin.servlet;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyRegistConfig {

    @Bean
    public ServletRegistrationBean myServlet(){
        MyServlet myServlet = new MyServlet();
        return new ServletRegistrationBean<>(myServlet,"/my","/my2");
    }

    @Bean
    public FilterRegistrationBean MyFilter(){
        MyFilter myFilter = new MyFilter();
        //表示拦截 我们自己的Servlet 里配置的 url-pattern
//        return new FilterRegistrationBean<>(myFilter,myServlet()); // 这种方式传入Filter组件 同时又传入 注册到容器里的Servlet组件

        //下面是自定义拦截
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean<>(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/*"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        MyServletContextListener myServletContextListener=new MyServletContextListener();
        return new ServletListenerRegistrationBean<>(myServletContextListener);
    }
}
