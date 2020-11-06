package com.codingStyle.practice.service;

import com.codingStyle.practice.dto.WebCrawlingRequest;
import com.codingStyle.practice.dto.WebCrawlingResponse;

/**
 * Created by kimchanjung on 2020-10-27 오후 2:41
 */
public interface WebCrawlingService {
    WebCrawlingResponse crawling(WebCrawlingRequest request);
}
