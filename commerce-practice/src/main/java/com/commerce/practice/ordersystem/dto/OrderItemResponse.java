package com.commerce.practice.ordersystem.dto;

import com.commerce.practice.ordersystem.entity.OrderItem;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by kimchanjung on 2021-04-10 오후 2:50
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderItemResponse {
    private Long id;
    private String name;
    private Integer unitPrice;
    private Integer unitCount;

    public static OrderItemResponse of(Long id, String name, Integer unitPrice, Integer unitCount) {
        OrderItemResponse instance = new OrderItemResponse();
        instance.id = id;
        instance.name = name;
        instance.unitPrice = unitPrice;
        instance.unitCount = unitCount;
        return instance;
    }

    public static OrderItemResponse of(OrderItem orderItem) {
        return OrderItemResponse.of(orderItem.getId(),
                orderItem.getName(), orderItem.getUnitPrice(),
                orderItem.getUnitCount());
    }
}
