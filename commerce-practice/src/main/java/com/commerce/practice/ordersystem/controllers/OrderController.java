package com.commerce.practice.ordersystem.controllers;

import com.commerce.practice.ordersystem.dto.CancelOrderRequest;
import com.commerce.practice.ordersystem.dto.OrderItemRequest;
import com.commerce.practice.ordersystem.dto.OrderResponse;
import com.commerce.practice.ordersystem.services.OrderService;
import com.commerce.practice.ordersystem.services.UserService;
import com.commerce.practice.ordersystem.utils.ResponseForm;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by kimchanjung on 2021-04-15 오전 11:27
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/between/{from}/and/{to}", method = RequestMethod.GET)
    public ResponseForm<List<OrderResponse>> findAll(@PathVariable("from") LocalDateTime from,
                                               @PathVariable("to") LocalDateTime to) {
        return ResponseForm.ok(orderService.findAllBy(1L, from, to));
    }
    /**
     * 세션에서 유저아이디로 User를 가져오지만
     * 로그인 구현이 없으므로 1번회원을 가져온다
     */
    @RequestMapping(value = "/store/{storeId}", method = RequestMethod.POST)
    public ResponseForm<OrderResponse> order(@PathVariable("storeId") Long storeId,
                                  @Valid @RequestBody List<OrderItemRequest> request) {
        return ResponseForm.ok(orderService.order(1L, storeId, request));
    }

    @RequestMapping(value = "/{orderId}/cancel", method = RequestMethod.PATCH)
    public ResponseForm<OrderResponse> cancel(@PathVariable("orderId") Long orderId,
                                              @Valid @RequestBody CancelOrderRequest request) {
        return ResponseForm.ok(orderService.cancel(1L, orderId, request.getMessage()));
    }
}

