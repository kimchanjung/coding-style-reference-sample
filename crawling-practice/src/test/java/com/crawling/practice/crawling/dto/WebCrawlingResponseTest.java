package com.crawling.practice.crawling.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by kimchanjung on 2020-10-29 오전 10:51
 */
public class WebCrawlingResponseTest {

    @Test
    public void 묶음처리에서_나머지가_없으면_전체를_몫으로_출력한다() {
        // Given & When
        WebCrawlingResponse response = WebCrawlingResponse.of("A0a1B1C1d2E4Ffg", 3);

        // Then
        assertEquals("A0a1B1C1d2E4Ffg", response.getQuotient());
        assertNull( response.getRemainder());
    }

    @Test
    public void 묶음처리에서_나머지가_있으면_나머지를_제외하고_묶음처리한다() {
        // Given & When
        WebCrawlingResponse response = WebCrawlingResponse.of("A0a1B1C1d2E4Ffg", 4);

        // Then
        assertEquals("A0a1B1C1d2E4", response.getQuotient());
        assertEquals("Ffg", response.getRemainder());
    }
}