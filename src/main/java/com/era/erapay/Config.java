package com.era.erapay;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/Test**").addResourceLocations("file:///D:/Test/");
        registry.addResourceHandler("/qrcode/**").addResourceLocations("file:///D:/qrcode/");
    }
}