package com.codingstyle.practice.crawling.service;

import com.codingstyle.practice.crawling.dto.WebCrawlingRequest;
import com.codingstyle.practice.crawling.dto.WebCrawlingResponse;

/**
 * Created by kimchanjung on 2020-10-27 오후 2:41
 */
public interface WebCrawlingService {
    WebCrawlingResponse crawling(WebCrawlingRequest request);
}
