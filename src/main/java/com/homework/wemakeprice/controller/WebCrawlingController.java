package com.homework.wemakeprice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kimchanjung on 2020-10-27 오후 2:05
 */

@Slf4j
@RestController
@RequestMapping("/api/v1/crawling")
public class WebCrawlingController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public void crawling() {
       log.info("test");
    }
}
