package com.codingstyle.practice.commerce.dto;

import com.codingstyle.practice.commerce.entity.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimchanjung on 2021-04-08 오후 6:47
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderRequest {
    private List<OrderProductRequest> orderProductRequests = new ArrayList<>();

    public static OrderRequest of (List<OrderProductRequest> orderProductRequests) {
        OrderRequest instance = new OrderRequest();
        instance.orderProductRequests = orderProductRequests;
        return instance;
    }
}
