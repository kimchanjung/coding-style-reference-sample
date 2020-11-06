package com.codingStyle.practice.service.impl;

import com.codingStyle.practice.dto.WebCrawlingRequest;
import com.codingStyle.practice.dto.WebCrawlingResponse;
import com.codingStyle.practice.service.JsoupService;
import com.codingStyle.practice.service.WebCrawlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kimchanjung on 2020-10-27 오후 2:42
 * 크롤링 요청을 수행하는 서비스
 * 크롤링 라이브러리를 호출하고 응답 DTO를 리턴하는 로직만 수행함
 * 실제 조건에 맞게 파싱은 WebContentDto가 담당함
 */
@Service
public class WebCrawlingServiceImpl implements WebCrawlingService {

    private final JsoupService jsoupService;

    @Autowired
    public WebCrawlingServiceImpl(JsoupService jsoupService) {
        this.jsoupService = jsoupService;
    }

    @Override
    public WebCrawlingResponse crawling(WebCrawlingRequest request) {
        return WebCrawlingResponse.of(jsoupService.parse(request.getUrl(),
                request.getParsingTypes()).parse(),
                request.getBundleUnit());
    }

}