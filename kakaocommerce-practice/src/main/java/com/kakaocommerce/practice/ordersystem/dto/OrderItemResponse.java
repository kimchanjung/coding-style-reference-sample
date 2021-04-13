package com.kakaocommerce.practice.ordersystem.dto;

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
