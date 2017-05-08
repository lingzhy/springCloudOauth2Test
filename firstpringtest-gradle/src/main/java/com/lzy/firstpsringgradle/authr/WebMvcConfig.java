package com.lzy.firstpsringgradle.authr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	@Bean
    public AccessTokenVerifyInterceptor tokenVerifyInterceptor() {
        return new AccessTokenVerifyInterceptor();
    }
 

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(tokenVerifyInterceptor()).addPathPatterns("/user/show");

        super.addInterceptors(registry);

    }
	
	

}
