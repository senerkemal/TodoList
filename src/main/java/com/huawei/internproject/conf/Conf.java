package com.huawei.internproject.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class Conf extends WebMvcConfigurerAdapter {
 
    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:3000");
    }*/
    
    public void addCorsMappings(CorsRegistry registry) {
    	registry.addMapping("/api/**")
    		.allowedOrigins("http://localhost:3000")
    		.allowedMethods("PUT", "DELETE", "OPTIONS", "POST", "GET");
    }
}
