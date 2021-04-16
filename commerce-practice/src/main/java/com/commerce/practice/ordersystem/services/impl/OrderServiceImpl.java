package com.commerce.practice.ordersystem.services.impl;


import com.commerce.practice.ex.BadRequestException;
import com.commerce.practice.ex.ResourceNotFoundException;
import com.commerce.practice.ordersystem.dto.OrderItemRequest;
import com.commerce.practice.ordersystem.dto.OrderResponse;
import com.commerce.practice.ordersystem.entity.Order;
import com.commerce.practice.ordersystem.mappers.OrderItemMapper;
import com.commerce.practice.ordersystem.mappers.OrderMapper;
import com.commerce.practice.ordersystem.repositories.OrderItemRepository;
import com.commerce.practice.ordersystem.repositories.OrderRepository;
import com.commerce.practice.ordersystem.services.OrderService;
import com.commerce.practice.ordersystem.services.StoreService;
import com.commerce.practice.ordersystem.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kimchanjung on 2021-04-10 오후 3:35
 */
@Slf4j
@Transactional
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderMapper mapper;
    private final OrderItemMapper orderItemMapper;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final StoreService storeService;
    private final UserService userService;

    public OrderServiceImpl(OrderMapper mapper, OrderItemMapper orderItemMapper, OrderRepository orderRepository,
                            OrderItemRepository orderItemRepository, StoreService storeService,
                            UserService userService) {
        this.mapper = mapper;
        this.orderItemMapper = orderItemMapper;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.storeService = storeService;
        this.userService = userService;
    }

    @Override
    public List<OrderResponse> findAllBy(Long userId, LocalDateTime from, LocalDateTime to) {
        return mapper.toDto(orderRepository.findAllByUserIdAndCreatedAtBetweenOrderByIdAsc(userId, from, to));
    }

    @Override
    public OrderResponse order(Long userId, Long storeId, List<OrderItemRequest> orderItems) {
        Order order = orderRepository.save(Order
                .ofNew(userService.findMe(userId), storeService.findOneOpenShopById(storeId)));

        orderItemRepository.saveAll(orderItems.stream()
                .map(v -> orderItemMapper.toEntity(order,v))
                .collect(Collectors.toList()));

        return mapper.toDto(order);
    }

    @Override
    public OrderResponse cancel(Long userId, Long orderId, String cancelMsg) {
        return orderRepository.findByIdAndUserId(orderId, userId)
                .map(v -> v.cancel(cancelMsg)
                        .map(mapper::toDto)
                        .orElseThrow(() -> BadRequestException.badStatus(v.getState().getDesc())))
                .orElseThrow(() -> ResourceNotFoundException.notFound("주문"));
    }
}
