package com.commerce.practice.services;


import com.commerce.practice.dto.OrderItemRequest;
import com.commerce.practice.dto.OrderResponse;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by kimchanjung on 2021-04-10 오후 3:24
 */
public interface OrderService {
    List<OrderResponse> findAllBy(Long userId, LocalDateTime from, LocalDateTime to);

    OrderResponse order(Long userId, Long storeId, List<OrderItemRequest> orderItems);

    OrderResponse cancel(Long userId, Long orderId, String cancelMsg);
}
