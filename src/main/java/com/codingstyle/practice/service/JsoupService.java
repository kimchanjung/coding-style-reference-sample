package com.codingstyle.practice.service;

import com.codingstyle.practice.dto.WebContentDto;
import com.codingstyle.practice.enums.ParsingTypes;

/**
 * Created by kimchanjung on 2020-10-27 오후 6:01
 */
public interface JsoupService {
    WebContentDto parse(String url, ParsingTypes parsingTypes);
}
