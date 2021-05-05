package com.commerce.practice.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by kimchanjung on 2021-04-10 오후 1:47
 * [엔티티 관계에서 기본패치전략]
 * 기본패치전략을 그대로 사용하는 경우 생략해도 되지만
 * 사람은 항상 햇갈릴 수 있기 때문에 명시적으로 설정해주는 편이다
 */
@Getter
@Entity
@Table(name = "order_items")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Order order;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer unitPrice;

    @Column(nullable = false)
    private Integer unitCount;

    @Builder
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
