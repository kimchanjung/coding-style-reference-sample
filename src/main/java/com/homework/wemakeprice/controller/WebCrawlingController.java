package com.homework.wemakeprice.controller;

import com.homework.wemakeprice.dto.WebCrawlingRequest;
import com.homework.wemakeprice.dto.WebCrawlingResponse;
import com.homework.wemakeprice.service.WebCrawlingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by kimchanjung on 2020-10-27 오후 2:05
 */

@Slf4j
@RestController
@RequestMapping("/api/v1/crawling")
public class WebCrawlingController {

    private final WebCrawlingService webCrawlingService;

    @Autowired
    public WebCrawlingController( WebCrawlingService webCrawlingService) {
        this.webCrawlingService = webCrawlingService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public WebCrawlingResponse crawling(@Valid @RequestBody WebCrawlingRequest request) {
        return webCrawlingService.crawling(request);
    }
}
