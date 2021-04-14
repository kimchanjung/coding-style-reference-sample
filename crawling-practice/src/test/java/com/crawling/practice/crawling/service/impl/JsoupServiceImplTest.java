package com.crawling.practice.crawling.service.impl;

import com.crawling.practice.crawling.enums.ParsingTypes;
import com.crawling.practice.ex.HttpBadRequestException;
import com.crawling.practice.crawling.service.JsoupService;
import com.crawling.practice.crawling.dto.WebContentDto;
import lombok.extern.slf4j.Slf4j;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by kimchanjung on 2020-10-27 오후 7:33
 */

@Slf4j
@SpringBootTest
public class JsoupServiceImplTest {

    @Autowired
    private JsoupService jsoupService;

    @Test
    public void 파싱문자열에_HTML_TAG가_포함된다() {
        //Given & When
        WebContentDto contentDto = jsoupService.parse("http://www.naver.com", ParsingTypes.TEXT_ALL);

        System.out.println(contentDto.getContent());
        //Then
        assertNotEquals(-1, contentDto.getContent().indexOf("<html"), "html 태그의 index는");
    }

    @Test
    public void 파싱문자열에_HTML_TAG가_제거된다() {
        //Given & When
        WebContentDto contentDto = jsoupService.parse("http://www.naver.com", ParsingTypes.WITHOUT_TAG);

        //Then
        assertEquals(-1, contentDto.getContent().indexOf("<html"), "html 태그의 index는");
    }

    @Test
    public void URL_올바르지않으면_예외를_발생한다() {
        //Given & When & Then
        assertThrows(HttpBadRequestException.class, () -> jsoupService.parse("http://localhost:1000", ParsingTypes.WITHOUT_TAG));
    }

}