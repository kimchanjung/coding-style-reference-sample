package com.codingstyle.practice.service;

import com.codingstyle.practice.dto.WebCrawlingRequest;
import com.codingstyle.practice.dto.WebCrawlingResponse;

/**
 * Created by kimchanjung on 2020-10-27 오후 2:41
 */
public interface WebCrawlingService {
    WebCrawlingResponse crawling(WebCrawlingRequest request);
}
