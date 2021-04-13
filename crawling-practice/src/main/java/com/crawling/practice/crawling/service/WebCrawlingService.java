package com.crawling.practice.crawling.service;

import com.crawling.practice.crawling.dto.WebCrawlingRequest;
import com.crawling.practice.crawling.dto.WebCrawlingResponse;

/**
 * Created by kimchanjung on 2020-10-27 오후 2:41
 */
public interface WebCrawlingService {
    WebCrawlingResponse crawling(WebCrawlingRequest request);
}
