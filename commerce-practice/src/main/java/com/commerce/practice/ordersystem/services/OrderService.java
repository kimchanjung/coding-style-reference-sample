package com.commerce.practice.ordersystem.services;


import com.commerce.practice.ordersystem.dto.OrderResponse;
import com.commerce.practice.ordersystem.entity.OrderItem;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by kimchanjung on 2021-04-10 오후 3:24
 */
public interface OrderService {
    List<OrderResponse> findAllByUserId(Long userId, LocalDateTime from, LocalDateTime to);
    OrderResponse order(Long userId, List<OrderItem> orderItems);
    OrderResponse cancel(Long userId, String cancelMsg);
}
