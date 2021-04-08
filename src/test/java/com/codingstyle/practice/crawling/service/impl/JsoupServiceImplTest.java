package com.codingstyle.practice.crawling.service.impl;

import com.codingstyle.practice.TestWebPracticeConfiguration;
import com.codingstyle.practice.crawling.enums.ParsingTypes;
import com.codingstyle.practice.ex.HttpBadRequestException;
import com.codingstyle.practice.crawling.service.JsoupService;
import com.codingstyle.practice.crawling.dto.WebContentDto;
import lombok.extern.slf4j.Slf4j;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by kimchanjung on 2020-10-27 오후 7:33
 */

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestWebPracticeConfiguration.class)
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