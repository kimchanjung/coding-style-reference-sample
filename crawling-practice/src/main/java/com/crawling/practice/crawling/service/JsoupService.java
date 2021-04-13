package com.crawling.practice.crawling.service;

import com.crawling.practice.crawling.dto.WebContentDto;
import com.crawling.practice.crawling.enums.ParsingTypes;

/**
 * Created by kimchanjung on 2020-10-27 오후 6:01
 */
public interface JsoupService {
    WebContentDto parse(String url, ParsingTypes parsingTypes);
}
