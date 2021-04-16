package com.commerce.practice.ordersystem.dto;



import com.commerce.practice.ordersystem.entity.Order;
import com.commerce.practice.ordersystem.entity.OrderItem;
import com.commerce.practice.ordersystem.enums.OrderState;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kimchanjung on 2021-04-10 오후 2:50
 */
@Getter
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderResponse {
    private Long id;
    private Long storeId;
    private List<OrderItemResponse> items;
    private Integer totalPrice;
    private String state;
    private Cancel cancel;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime completedAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @Getter
    @Builder
    @AllArgsConstructor(staticName = "of")
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Cancel {
        private String message;
        private LocalDateTime time;
    }
}
