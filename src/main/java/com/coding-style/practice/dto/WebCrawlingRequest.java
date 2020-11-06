package com.codingStyle.practice.dto;

import com.codingStyle.practice.enums.ParsingTypes;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by kimchanjung on 2020-10-27 오후 4:50
 * 프론트 페이지의 조건을 받아오는 DTO
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WebCrawlingRequest {

    @NotBlank(message = "URL을 입력해주세요")
    private String url;

    @NotNull(message = "파싱타입을 선택해주세요")
    private ParsingTypes parsingTypes;

    @NotNull(message = "묶음 단위를 입력하세요")
    @Min(value = 2, message = "2 이상 입력 해주세요")
    private Integer bundleUnit;

    public static WebCrawlingRequest ofMock(String url, ParsingTypes parsingTypes, Integer bundleUnit) {
        WebCrawlingRequest instance = new WebCrawlingRequest();
        instance.url = url;
        instance.parsingTypes = parsingTypes;
        instance.bundleUnit = bundleUnit;
        return instance;
    }
}
