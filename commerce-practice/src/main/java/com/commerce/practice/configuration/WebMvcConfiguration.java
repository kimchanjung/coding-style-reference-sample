package com.commerce.practice.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by kimchanjung on 2021-04-09 오후 1:37
 */
@Slf4j
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    /**
     * GET 이외 메소드를 허용하기 위해서 CORS 허용설정을 추가해야함
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*");
    }
}
