package com.homework.wemakeprice.service;

import com.homework.wemakeprice.dto.WebCrawlingRequest;
import com.homework.wemakeprice.dto.WebCrawlingResponse;

/**
 * Created by kimchanjung on 2020-10-27 오후 2:41
 */
public interface WebCrawlingService {
    WebCrawlingResponse crawling(WebCrawlingRequest request);
}
