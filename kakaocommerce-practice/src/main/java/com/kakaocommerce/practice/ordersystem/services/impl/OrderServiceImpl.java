package com.kakaocommerce.practice.ordersystem.services.impl;



import com.kakaocommerce.practice.ordersystem.dto.OrderResponse;
import com.kakaocommerce.practice.ordersystem.entity.OrderItem;
import com.kakaocommerce.practice.ordersystem.repositories.OrderRepository;
import com.kakaocommerce.practice.ordersystem.services.OrderService;
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

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * TODO -  날짜 범위로 주문내역 가져오기 로직 추가
     */
    @Override
    public List<OrderResponse> findAllByUserId(Long userId, LocalDateTime from, LocalDateTime to) {
        return orderRepository.findByUser(userId)
                .stream()
                .map(OrderResponse::of)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse order(Long userId, List<OrderItem> orderItems) {
        return null;
    }

    @Override
    public OrderResponse cancel(Long id, String cancelMsg) {
        return orderRepository.findById(id)
                .map(order -> OrderResponse.of(order.cancel(cancelMsg)))
                .orElseThrow(() -> new IllegalArgumentException("잘못된 주문번호["+id+"]입니다."));
    }
}
