package com.codingstyle.practice.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by kimchanjung on 2020-10-27 오후 5:17
 * 크롤링 후 처리 결과를 반환하는 DTO
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WebCrawlingResponse {
    // 몫
    private String quotient;
    // 나머지
    private String remainder;

    public static WebCrawlingResponse of(String content, Integer bundleUnit) {
        WebCrawlingResponse instance = new WebCrawlingResponse();
        instance.quotient = content;

        if (content.length() % bundleUnit > 0) {
            int bundlePosition = (content.length() / bundleUnit) * bundleUnit;
            instance.quotient = content.substring(0, bundlePosition);
            instance.remainder = content.substring(bundlePosition);
        }

        return instance;
    }

}
