package com.homework.wemakeprice.service;

import com.homework.wemakeprice.dto.WebContentDto;
import com.homework.wemakeprice.enums.ParsingTypes;

/**
 * Created by kimchanjung on 2020-10-27 오후 6:01
 */
public interface JsoupService {
    WebContentDto parse(String url, ParsingTypes parsingTypes);
}
