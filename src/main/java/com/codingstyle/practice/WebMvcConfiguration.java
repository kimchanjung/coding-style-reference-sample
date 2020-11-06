package com.codingstyle.practice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by kimchanjung on 2020-10-27 오후 2:01
 */
@Slf4j
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    /**
     * GET 이외 메소드를 허용하기 위해서 CORS 허용설정을 추가해야함
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*");
    }
}
