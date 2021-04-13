package com.crawling.practice.commerce.service.impl;

import com.crawling.practice.commerce.dto.OrderRequest;
import com.crawling.practice.commerce.dto.OrderResponse;
import com.crawling.practice.commerce.entity.Order;
import com.crawling.practice.commerce.entity.OrderProduct;
import com.crawling.practice.commerce.mapper.OrderMapper;
import com.crawling.practice.commerce.repository.OrderProductRepository;
import com.crawling.practice.commerce.repository.OrderRepository;
import com.crawling.practice.commerce.repository.ProductRepository;
import com.crawling.practice.commerce.service.OrderService;
import com.crawling.practice.ex.ResourceNotFoundException;
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
    private final ProductRepository cpProductRepository;
    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;

    public OrderServiceImpl(OrderMapper orderMapper,
                            ProductRepository cpProductRepository,
                            OrderRepository orderRepository,
                            OrderProductRepository orderProductRepository) {
        this.orderMapper = orderMapper;
        this.cpProductRepository = cpProductRepository;
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public OrderResponse order(OrderRequest orderRequest) {
        return orderMapper.toResponse(orderRepository.save(Order.of(getProducts(orderRequest))));
    }

    private List<OrderProduct> getProducts(OrderRequest orderRequest) {
        return orderRequest.getOrderProductRequests()
                .stream()
                .map(v -> orderProductRepository.save(OrderProduct.of(cpProductRepository.findById(v.getProductId())
                                .orElseThrow(() -> ResourceNotFoundException.notFound("상품")),
                        v.getProductCount())))
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse findOne(Long id) {
        return orderMapper.toResponse(
                orderRepository.findById(id)
                        .orElseThrow(() -> ResourceNotFoundException.notFound("주문")));
    }

}
