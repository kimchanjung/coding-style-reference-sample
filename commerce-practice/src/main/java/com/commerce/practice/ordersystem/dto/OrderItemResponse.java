package com.commerce.practice.ordersystem.dto;

import com.commerce.practice.ordersystem.entity.OrderItem;

/**
 * Created by kimchanjung on 2021-04-10 오후 2:50
 */
public class OrderItemResponse {
    private Long id;
    private String name;
    private Integer unitPrice;
    private Integer unitCount;

    private OrderItemResponse() {
    }

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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public Integer getUnitCount() {
        return unitCount;
    }
}
