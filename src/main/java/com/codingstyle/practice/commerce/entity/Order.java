package com.codingstyle.practice.commerce.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kimchanjung on 2021-04-07 오후 5:24
 */

@Slf4j
@Getter
@Entity
@Builder
@Table(name = "orders") // order는 db 예약어라 오류남
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 엔티티는 기본생성자가 필요한데 public으로 완전 오픈보다 PROTECTED 정도로 제한을 둔다
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<OrderProduct> orderProducts;

    @Column(nullable = false)
    private Integer totalOrderAmount;

    @Temporal(TemporalType.TIMESTAMP)
    private final Date orderDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private final Date lastModifiedDate = new Date();

    public static Order of(List<OrderProduct> orderProducts) {
        Order instance = new Order();
        instance.orderProducts = orderProducts;
        instance.totalOrderAmount = orderProducts.stream()
                .mapToInt(OrderProduct::getProductPrice)
                .sum();
        return instance;
    }

}
