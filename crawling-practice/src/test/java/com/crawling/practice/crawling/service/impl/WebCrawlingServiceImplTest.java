package com.crawling.practice.crawling.service.impl;

import com.crawling.practice.TestWebPracticeConfiguration;
import com.crawling.practice.crawling.dto.WebCrawlingRequest;
import com.crawling.practice.crawling.dto.WebCrawlingResponse;
import com.crawling.practice.crawling.enums.ParsingTypes;
import com.crawling.practice.crawling.service.WebCrawlingService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Created by kimchanjung on 2020-10-27 오후 2:45
 */

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestWebPracticeConfiguration.class)
public class WebCrawlingServiceImplTest {

    @Autowired
    private WebCrawlingService webCrawlingService;

    @Test
    public void 웹크롤링_서비스가_정상적으로_호출된다() {
        //Given
        WebCrawlingRequest request = WebCrawlingRequest.of("https://www.naver.com/", ParsingTypes.WITHOUT_TAG, 3);

        //When
        WebCrawlingResponse response = webCrawlingService.crawling(request);

        //Then
        assertNotEquals("몫은 존재한다", response.getQuotient());
        assertNotEquals("나머지는 존재한", response.getRemainder());
    }
}