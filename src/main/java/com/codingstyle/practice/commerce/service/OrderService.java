package com.codingstyle.practice.commerce.service;

import com.codingstyle.practice.commerce.dto.OrderRequest;
import com.codingstyle.practice.commerce.dto.OrderResponse;

/**
 * Created by kimchanjung on 2021-04-08 오후 6:46
 */
public interface OrderService {
    OrderResponse order(OrderRequest orderRequest);

    OrderResponse findOne(Long id);
}
