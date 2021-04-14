package com.commerce.practice.ordersystem.services.impl;


import com.commerce.practice.ordersystem.dto.OrderItemRequest;
import com.commerce.practice.ordersystem.dto.OrderResponse;
import com.commerce.practice.ordersystem.entity.Order;
import com.commerce.practice.ordersystem.entity.OrderItem;
import com.commerce.practice.ordersystem.enums.OrderState;
import com.commerce.practice.ordersystem.repositories.OrderRepository;
import com.commerce.practice.ordersystem.services.OrderService;
import com.commerce.practice.ordersystem.services.StoreService;
import com.commerce.practice.ordersystem.services.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kimchanjung on 2021-04-10 오후 3:35
 */
@Transactional
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final StoreService storeService;

    public OrderServiceImpl(OrderRepository orderRepository, UserService userService, StoreService storeService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.storeService = storeService;
    }

    @Override
    public List<OrderResponse> findAllByUserId(Long userId, LocalDateTime from, LocalDateTime to) {
        return orderRepository.findAllByUserIdAndCreatedAtBetweenOrderByIdAsc(userId, from, to)
                .stream()
                .map(OrderResponse::of)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse order(Long userId, Long storeId, List<OrderItemRequest> orderItems) {
        Order order = Order.ofNew(userService.findMe(userId), storeService.findOneById(storeId));
        orderItems.forEach(v -> OrderItem.ofNew(order, v.getName(), v.getUnitPrice(), v.getUnitCount()));
        return OrderResponse.of(orderRepository.save(order));
    }

    @Override
    public OrderResponse cancel(Long userId, Long orderId, String cancelMsg) {
        return orderRepository.findByIdAndUserId(orderId, userId)
                .map(v -> v.cancel(cancelMsg)
                        .map(OrderResponse::of)
                        .orElseThrow(() ->  new IllegalStateException(v.getState().getDesc() + " 상태는 취소할 수 없습니다.")))
                .orElseThrow(() -> new IllegalArgumentException("잘못된 주문번호[" + orderId + "]입니다."));
    }
}
