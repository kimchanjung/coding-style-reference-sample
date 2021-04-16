package com.commerce.practice.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Created by kimchanjung on 2021-04-10 오후 2:37
 */
@Getter
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StoreResponse {
    private Long id;
    private String name;
    private String state;
    private BusinessHours businessHours;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @Getter
    @Builder
    @AllArgsConstructor(staticName = "of")
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class BusinessHours {
        private Integer offDay;
        private boolean run24;
        private Integer openTime;
        private Integer closeTime;
    }
}
