package com.codingStyle.practice.service;

import com.codingStyle.practice.enums.ParsingTypes;
import com.codingStyle.practice.dto.WebContentDto;

/**
 * Created by kimchanjung on 2020-10-27 오후 6:01
 */
public interface JsoupService {
    WebContentDto parse(String url, ParsingTypes parsingTypes);
}
