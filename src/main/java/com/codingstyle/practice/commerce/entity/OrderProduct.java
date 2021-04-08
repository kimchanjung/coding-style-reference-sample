package com.codingstyle.practice.commerce.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

/**
 * Created by kimchanjung on 2021-04-08 오후 1:30
 */

@Slf4j
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 엔티티는 기본생성자가 필요한데 public으로 완전 오픈보다 PROTECTED 정도로 제한을 둔다
public class OrderProduct {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Column(nullable = false)
    private Integer productCount;

    @Builder
    public static OrderProduct of (Product product, Integer productCount) {
        OrderProduct instance = new OrderProduct();
        instance.product = product;
        instance.productCount = productCount;
        return instance;
    }

    public Integer getProductPrice() {
        return product.getPrice() * productCount;
    }
}
