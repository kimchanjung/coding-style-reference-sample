package com.homework.wemakeprice.service.impl;

import com.homework.wemakeprice.dto.WebCrawlingRequest;
import com.homework.wemakeprice.dto.WebCrawlingResponse;
import com.homework.wemakeprice.service.JsoupService;
import com.homework.wemakeprice.service.WebCrawlingService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by kimchanjung on 2020-10-27 오후 2:42
 */
@Slf4j
@Service
public class WebCrawlingServiceImpl implements WebCrawlingService {

    private final JsoupService jsoupService;

    @Autowired
    public WebCrawlingServiceImpl(JsoupService jsoupService) {
        this.jsoupService = jsoupService;
    }

    @Override
    public WebCrawlingResponse crawling(WebCrawlingRequest request) {
        String parse = jsoupService.parse(request.getUrl(), request.getParsingTypes());
        return WebCrawlingResponse.of("몫","나머지");
    }

}