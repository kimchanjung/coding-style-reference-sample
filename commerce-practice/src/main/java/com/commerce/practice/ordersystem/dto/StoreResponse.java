package com.commerce.practice.ordersystem.dto;


import com.commerce.practice.ordersystem.entity.Store;
import com.commerce.practice.ordersystem.enums.StoreState;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
