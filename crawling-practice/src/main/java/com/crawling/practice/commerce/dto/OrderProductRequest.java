package com.crawling.practice.commerce.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by kimchanjung on 2021-04-08 오후 7:05
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderProductRequest {
    private Long productId;
    private Integer productCount;

    public static OrderProductRequest of(Long productId, Integer productCount) {
        OrderProductRequest instance = new OrderProductRequest();
        instance.productId = productId;
        instance.productCount = productCount;
        return instance;
    }
}
