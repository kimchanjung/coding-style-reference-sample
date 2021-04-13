package com.commerce.practice.ordersystem.dto;



import com.commerce.practice.ordersystem.entity.Order;
import com.commerce.practice.ordersystem.enums.OrderState;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimchanjung on 2021-04-10 오후 2:50
 */
public class OrderResponse {
    private Long id;
    private Long storeId;
    private List<OrderItemResponse> items = new ArrayList<>();
    private Integer totalPrice;
    private String state;
    private Cancel cancel;
    private LocalDateTime completedAt;
    private LocalDateTime createdAt;

    private OrderResponse(){}

    public static OrderResponse of(Long id, Long storeId, List<OrderItemResponse> items,
                                   Integer totalPrice, OrderState state, String cancelMsg,
                                   LocalDateTime canceledAt, LocalDateTime completedAt,
                                   LocalDateTime createdAt) {
        OrderResponse instance = new OrderResponse();
        instance.id = id;
        instance.storeId = storeId;
        instance.items = items;
        instance.totalPrice = totalPrice;
        instance.state = state.name();
        instance.cancel = Cancel.of(cancelMsg, canceledAt);
        instance.completedAt = completedAt;
        instance.createdAt = createdAt;
        return instance;
    }

    public static OrderResponse of(Order order) {
        return new OrderResponse();
    }

    public static class Cancel {
        private String message;
        private LocalDateTime time;

        private Cancel(){}

        public static Cancel of(String message, LocalDateTime time) {
            if (message == null) return null;
            Cancel instance = new Cancel();
            instance.message = message;
            instance.time = time;
            return instance;
        }

        public String getMessage() {
            return message;
        }

        public LocalDateTime getTime() {
            return time;
        }
    }

    public Long getId() {
        return id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public List<OrderItemResponse> getItems() {
        return items;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public String getState() {
        return state;
    }

    public Cancel getCancel() {
        return cancel;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
