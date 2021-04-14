package com.crawling.practice.commerce.service.impl;

import com.crawling.practice.commerce.eums.ProductCategory;
import com.crawling.practice.commerce.service.*;
import com.crawling.practice.commerce.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by kimchanjung on 2021-04-08 오후 8:04
 */
@Slf4j
@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private ProductService ProductService;

    @Autowired
    private OrderService orderService;

    @Test
    public void 주문이_정상적으로_생성된다() {
        // Given
        ProductResponse product1 = ProductService.register(ProductRequest.of("만두", 8000, ProductCategory.FOOD));
        ProductResponse product2 = ProductService.register(ProductRequest.of("냉장", 2000000, ProductCategory.ELECTRONIC));
        OrderRequest orderRequest = OrderRequest.of(Arrays.asList(OrderProductRequest.of(product1.getId(), 1), OrderProductRequest.of(product2.getId(), 2)));

        // When
        OrderResponse orderResponse = orderService.order(orderRequest);

        // Then
        assertEquals(1L, orderResponse.getOrderProducts().get(0).getId());
        assertEquals(1L, orderResponse.getId());
        assertEquals(4008000, orderResponse.getTotalOrderAmount());
    }
}