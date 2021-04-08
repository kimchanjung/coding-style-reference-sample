package com.codingstyle.practice.crawling.service;

import com.codingstyle.practice.crawling.dto.WebContentDto;
import com.codingstyle.practice.crawling.enums.ParsingTypes;

/**
 * Created by kimchanjung on 2020-10-27 오후 6:01
 */
public interface JsoupService {
    WebContentDto parse(String url, ParsingTypes parsingTypes);
}
