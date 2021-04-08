package com.codingstyle.practice.commerce.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * Created by kimchanjung on 2021-04-08 오후 6:48
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderResponse {
    private Long id;
    private List<OrderProductResponse> orderProducts;
    private Integer totalOrderAmount;
    private final Date orderDate = new Date();
    private final Date lastModifiedDate = new Date();
}
