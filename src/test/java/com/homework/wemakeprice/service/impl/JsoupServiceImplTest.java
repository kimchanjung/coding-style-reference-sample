package com.homework.wemakeprice.service.impl;

import com.homework.wemakeprice.TestWeMakePriceConfiguration;
import com.homework.wemakeprice.enums.ParsingTypes;
import com.homework.wemakeprice.ex.HttpBadRequestException;
import com.homework.wemakeprice.service.JsoupService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Created by kimchanjung on 2020-10-27 오후 7:33
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestWeMakePriceConfiguration.class)
public class JsoupServiceImplTest {

    @Autowired
    private JsoupService jsoupService;

    @Test
    public void 파싱문자열에_HTML_TAG가_포함된다() {
        //Given & When
        String parse = jsoupService.parse("http://www.naver.com", ParsingTypes.TEXT_ALL);
        log.info("ddd - "+parse.indexOf("<html"));
        //Then
        assertNotEquals( -1, parse.indexOf("<html"),"html 태그의 index는");
    }

    @Test
    public void 파싱문자열에_HTML_TAG가_제거된다() {
        //Given & When
        String parse = jsoupService.parse("http://www.naver.com", ParsingTypes.WITHOUT_TAG);
        //Then
        assertEquals( -1, parse.indexOf("<html"),"html 태그의 index는");
    }

    @Test(expected = HttpBadRequestException.class)
    public void URL_올바르지않으면_예외를_발생한다() {
        //Given & When & Then
        jsoupService.parse("http://localhost:1000", ParsingTypes.WITHOUT_TAG);
    }

    @Test(expected = HttpBadRequestException.class)
    public void HTTP_상태코드가_200아니면_예외를_발생한다() {
        //Given & When & Then
        jsoupService.parse("http://www.naver.com/2132131231231231", ParsingTypes.WITHOUT_TAG);
    }

}