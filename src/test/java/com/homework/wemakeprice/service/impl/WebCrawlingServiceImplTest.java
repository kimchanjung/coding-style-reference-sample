package com.homework.wemakeprice.service.impl;



import com.homework.wemakeprice.TestWeMakePriceConfiguration;
import com.homework.wemakeprice.dto.WebCrawlingRequest;
import com.homework.wemakeprice.dto.WebCrawlingResponse;
import com.homework.wemakeprice.enums.ParsingTypes;
import com.homework.wemakeprice.service.WebCrawlingService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by kimchanjung on 2020-10-27 오후 2:45
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestWeMakePriceConfiguration.class)
public class WebCrawlingServiceImplTest {

    @Autowired
    private WebCrawlingService webCrawlingService;

    @Test
    public void 웹크롤링_서비스가_정상적으로_호출된다() {
        //Given
        WebCrawlingRequest request = WebCrawlingRequest.ofMock("https://www.naver.com/", ParsingTypes.WITHOUT_TAG, 3);

        //When
        WebCrawlingResponse response = webCrawlingService.crawling(request);

        //Then
        assertSame("몫은 ", response.getQuotient(), "몫");
        assertSame("나머지는", response.getRemainder(), "나머지");
    }
}