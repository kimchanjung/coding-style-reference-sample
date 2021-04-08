package com.codingstyle.practice.commerce.service.impl;

import com.codingstyle.practice.commerce.dto.OrderRequest;
import com.codingstyle.practice.commerce.dto.OrderResponse;
import com.codingstyle.practice.commerce.entity.Order;
import com.codingstyle.practice.commerce.entity.OrderProduct;
import com.codingstyle.practice.commerce.mapper.OrderMapper;
import com.codingstyle.practice.commerce.repository.OrderProductRepository;
import com.codingstyle.practice.commerce.repository.OrderRepository;
import com.codingstyle.practice.commerce.repository.ProductRepository;
import com.codingstyle.practice.commerce.service.OrderService;
import com.codingstyle.practice.ex.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kimchanjung on 2021-04-08 오후 6:54
 */
@Transactional
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;

    public OrderServiceImpl(OrderMapper orderMapper,
                            ProductRepository productRepository,
                            OrderRepository orderRepository,
                            OrderProductRepository orderProductRepository) {
        this.orderMapper = orderMapper;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public OrderResponse order(OrderRequest orderRequest) {
        return orderMapper.toResponse(orderRepository.save(Order.of(getOrderProducts(orderRequest))));
    }

    @Override
    public OrderResponse findOne(Long id) {
        return orderMapper.toResponse(
                orderRepository.findById(id)
                        .orElseThrow(() -> ResourceNotFoundException.notFound("주문")));
    }

    private List<OrderProduct> getOrderProducts(OrderRequest orderRequest) {
        return orderRequest.getOrderProductRequests().stream()
                .map(v -> orderProductRepository.save(OrderProduct.of(
                        productRepository.findById(v.getProductId())
                                .orElseThrow(() -> ResourceNotFoundException.notFound("상픔")),
                        v.getProductCount()))).
                        collect(Collectors.toList());
    }
}
