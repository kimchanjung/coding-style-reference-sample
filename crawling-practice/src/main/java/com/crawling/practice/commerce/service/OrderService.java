package com.crawling.practice.commerce.service;

import com.crawling.practice.commerce.dto.OrderRequest;
import com.crawling.practice.commerce.dto.OrderResponse;

/**
 * Created by kimchanjung on 2021-04-08 오후 6:46
 */
public interface OrderService {
    OrderResponse order(OrderRequest orderRequest);

    OrderResponse findOne(Long id);
}
