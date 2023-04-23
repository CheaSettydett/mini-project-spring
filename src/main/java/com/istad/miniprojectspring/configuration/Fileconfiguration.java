package com.istad.miniprojectspring.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class Fileconfiguration implements WebMvcConfigurer {
    @Value("${server.path}")
    String serverPath;
    @Value("${client.path}")
    String clientPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(clientPath).addResourceLocations("file:"+serverPath);
    }
}
