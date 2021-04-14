package com.commerce.practice.ordersystem.services.impl;

import com.commerce.practice.ordersystem.dto.OrderItemRequest;
import com.commerce.practice.ordersystem.dto.OrderResponse;
import com.commerce.practice.ordersystem.entity.Order;
import com.commerce.practice.ordersystem.entity.Store;
import com.commerce.practice.ordersystem.entity.User;
import com.commerce.practice.ordersystem.enums.OrderState;
import com.commerce.practice.ordersystem.mocks.MockEntity;
import com.commerce.practice.ordersystem.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by kimchanjung on 2021-04-14 오후 1:35
 */
@Slf4j
@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private MockEntity mockEntity;
    @Autowired
    private OrderService orderService;

    @Test
    public void 주문내역이_정상적으로_조회된다() {
        //Given
        List<Order> orders = mockEntity.createOrders(5, true);
        User user = orders.get(0).getUser();

        //When
        List<OrderResponse> responseList = orderService.findAllByUserId(user.getId(),
                LocalDate.now().minusDays(1).atStartOfDay(), LocalDate.now().plusDays(1).atStartOfDay());

        //Then
        responseList.forEach(v-> assertEquals(v.getCreatedAt().toLocalDate(), LocalDate.now()));
    }

    @Test
    public void 날짜범위를_벗어나면_주문은_검색되지_않는다() {
        //Given
        List<Order> orders = mockEntity.createOrders(5, true);
        User user = orders.get(0).getUser();

        //When
        List<OrderResponse> responseList = orderService.findAllByUserId(user.getId(),
                LocalDate.now().plusDays(1).atStartOfDay(), LocalDate.now().plusDays(2).atStartOfDay());

        //Then
        assertEquals(0, responseList.size());
    }

    @Test
    public void 주문이_정상적으로_생성된다() {
        //Given
        User user = mockEntity.creatUser();
        Store store = mockEntity.createStore();
        List<OrderItemRequest> orderItemRequests = Arrays.asList(OrderItemRequest.of("햄버거", 5000, 1),
                OrderItemRequest.of("콜라", 2000, 2));
        //When
        OrderResponse order = orderService.order(user.getId(), store.getId(), orderItemRequests);

        //Then
        assertEquals(9000, order.getTotalPrice());
    }


    @Test
    public void 주문이_정상적으로_취소된다() {
        //Given
        Order order = mockEntity.createOrder();

        //When
        OrderResponse response = orderService.cancel(order.getUser().getId(), order.getId(), "잘못된주문으로 취소요청");

        //Then
        assertEquals("잘못된주문으로 취소요청", response.getCancel().getMessage());
    }

    @Test
    public void 주문번호가_잘못된_주문을_취소하면_예외를_발생한다 () {
        //Given
        Order order = mockEntity.createOrder();

        //When & Then
        assertThrows(IllegalArgumentException.class, () -> orderService.cancel(order.getUser().getId(), 1000L, "잘못된주문으로 취소요청"));
    }

    @Test
    public void 완료된주문을_취소하면_예외가_발생한다() {
        //Given
        Order order = mockEntity.createOrder(OrderState.COMPLETE);

        //When & Then
        assertThrows(IllegalArgumentException.class, () -> orderService.cancel(order.getUser().getId(), 1000L, "잘못된주문으로 취소요청"));
    }

}