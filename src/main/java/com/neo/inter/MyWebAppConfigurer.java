package com.neo.inter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2017/11/25.
 */

@Configuration
public class MyWebAppConfigurer  extends WebMvcConfigurerAdapter {


    @Bean
    public UserAccessApiInterceptor getMyInterceptor(){
        return new UserAccessApiInterceptor();
    }




    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(getMyInterceptor()).addPathPatterns("/**");

        super.addInterceptors(registry);
    }

}
