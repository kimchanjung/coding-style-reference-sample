package com.homework.wemakeprice.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by kimchanjung on 2020-10-27 오후 5:17
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WebCrawlingResponse {
    private String quotient;
    private String remainder;

    public static WebCrawlingResponse of(String quotient, String remainder) {
        WebCrawlingResponse instance = new WebCrawlingResponse();
        instance.quotient = quotient;
        instance.remainder = remainder;
        return instance;
    }
}
