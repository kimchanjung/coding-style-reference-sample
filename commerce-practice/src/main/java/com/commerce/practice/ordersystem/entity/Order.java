package com.commerce.practice.ordersystem.entity;



import com.commerce.practice.ordersystem.enums.OrderState;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimchanjung on 2021-04-10 오후 1:35
 */
@Table(name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Store store;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private final List<OrderItem> items = new ArrayList<>();

    @Column(nullable = false)
    private OrderState state;

    private String cancelMsg;

    private LocalDateTime canceledAt;

    private LocalDateTime completedA;

    @CreatedDate
    private LocalDateTime createdAt;

    protected Order() { }

    public static Order of (Long id, User user, Store store, OrderState state,
                 String cancelMsg, LocalDateTime canceledAt, LocalDateTime completedA,
                 LocalDateTime createdAt) {
        Order instance = new Order();
        instance.id = id;
        instance.user = user;
        instance.store = store;
        instance.state = state;
        instance.cancelMsg = cancelMsg;
        instance.canceledAt = canceledAt;
        instance.completedA = completedA;
        instance.createdAt = createdAt;
        return instance;
    }


    public Order addItem(OrderItem item) {
        this.items.add(item);
        return this;
    }

    /**
     * TODO - 취소로직 추가
     */
    public Order cancel(String cancelMsg) {
        this.cancelMsg = cancelMsg;
        this.canceledAt = LocalDateTime.now();
        return this;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Store getStore() {
        return store;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public OrderState getState() {
        return state;
    }

    public String getCancelMsg() {
        return cancelMsg;
    }

    public LocalDateTime getCanceledAt() {
        return canceledAt;
    }

    public LocalDateTime getCompletedA() {
        return completedA;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
