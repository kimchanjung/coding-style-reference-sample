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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 양방향으로 연관관계 맺을 경우 이필드를 get하면 무한루프에 빠지므로 주의 해야한
    // 왜래키를 별도의 이름을 지정할때 사용한다 디폴트는 entity명_프라이머리키명(order_id)가 된다.
    // @JoinColumn(name = "member_order_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Column(nullable = false)
    private Integer productCount;

    @Builder
    public static OrderProduct of(Product product, Integer productCount) {
        OrderProduct instance = new OrderProduct();
        instance.product = product;
        instance.productCount = productCount;
        return instance;
    }

    // 연관관계편의 메소드
    public void amendOrder(Order order) {
        this.order = order;
    }

    public Integer getProductPrice() {
        return product.getPrice() * productCount;
    }
}
