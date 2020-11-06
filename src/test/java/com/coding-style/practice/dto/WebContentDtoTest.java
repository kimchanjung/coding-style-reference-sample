package com.codingStyle.practice.dto;

import org.junit.Test;

/**
 * Created by kimchanjung on 2020-10-28 오후 9:10
 */
public class WebContentDtoTest {

    @Test
    public void 웹컨텐츠의_파싱이_정상적으로_이루어진다() {
        // Given & When
        WebContentDto dto = WebContentDto.of("김@#BC1d2AaE1f1Fg40");

        // Then
        assertEquals("A0a1B1C1d2E4Ffg",dto.parse());
    }
}