package com.homework.wemakeprice.dto;

import com.homework.wemakeprice.enums.ParsingTypes;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by kimchanjung on 2020-10-27 오후 4:50
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WebCrawlingRequest {
    @NotBlank(message = "URL을 입력해주세요")
    private String url;

    @NotNull(message = "파싱타입을 선택해주세요")
    private ParsingTypes parsingTypes;

    @NotNull(message = "출력묶음단위를 입력해주세요")
    private Integer bundleUnit;

    public static WebCrawlingRequest ofMock(String url, ParsingTypes parsingTypes, Integer bundleUnit) {
        WebCrawlingRequest instance = new WebCrawlingRequest();
        instance.url = url;
        instance.parsingTypes = parsingTypes;
        instance.bundleUnit = bundleUnit;
        return instance;
    }
}
