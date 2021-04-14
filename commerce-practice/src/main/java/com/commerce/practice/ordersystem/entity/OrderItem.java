package com.commerce.practice.ordersystem.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by kimchanjung on 2021-04-10 오후 1:47
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Order order;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer unitPrice;

    @Column(nullable = false)
    private Integer unitCount;

    public static OrderItem ofNew(Order order, String name, Integer unitPrice, Integer unitCount) {
        OrderItem instance = new OrderItem();
        instance.order = order.addItem(instance);
        instance.name = name;
        instance.unitPrice = unitPrice;
        instance.unitCount = unitCount;
        return instance;
    }

    public Integer getTotalItemPrice() {
        return unitPrice * unitCount;
    }
}
