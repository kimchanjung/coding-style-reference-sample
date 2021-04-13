package com.crawling.practice.commerce.controller;


import com.crawling.practice.commerce.dto.OrderRequest;
import com.crawling.practice.commerce.dto.OrderResponse;
import com.crawling.practice.commerce.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by kimchanjung on 2021-04-08 오후 8:56
 */
@RestController
@RequestMapping("/api/v1/commerce/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public OrderResponse register(@Valid @RequestBody OrderRequest request) {
        return orderService.order(request);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public OrderResponse find(@PathVariable("id") Long id) {
        return orderService.findOne(id);
    }
}
