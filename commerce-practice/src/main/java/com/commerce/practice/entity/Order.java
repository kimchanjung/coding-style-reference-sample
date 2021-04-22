package com.commerce.practice.entity;


import com.commerce.practice.enums.OrderState;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static java.util.Optional.empty;
import static java.util.Optional.of;

/**
 * Created by kimchanjung on 2021-04-10 오후 1:35
 */
@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Store store;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderItem> items = new ArrayList<>();

    @Column(nullable = false)
    private OrderState state;

    private String cancelMsg;

    private LocalDateTime canceledAt;

    private LocalDateTime completedAt;
    /**
     * 컬럼 정의를 구체적으로 할수 있다 즉
     * 날짜 컬럼 데이터베이스 차원에서 데이터 생성시 자동으로 채워지도록 하고
     * 수정이 가능하지 않도록 세부설정을 @Column 애노테이션을 통하여 살수 있다.
     * created_at    datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP(),
     *
     * @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
     * 그렇지 않고 애플리케이션 차원에서 엔티티 생성시 자동으로 날짜를 생성하려면 @CreationTimestamp
     * 이용하면 간다하다 다만 애플리케이션 차원에서의 자동생성 이므로 컬럼에 날짜는
     * created_at timestamp DEFAULT NULL <- 이렇게 설정한 것이나 마찬가지가 된다.
     * 적절히 용도에 맞게 사용하면 된다.
     */
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public static Order ofNew(User user, Store store) {
        Order instance = new Order();
        instance.user = user.addOrder(instance);
        instance.store = store;
        instance.state = OrderState.NEW;
        return instance;
    }

    protected Order addItem(OrderItem item) {
        if (!this.items.contains(item)) {
            this.items.add(item);
        }

        return this;
    }

    public Optional<Order> cancel(String cancelMsg) {
        if (this.state.stateChangeable(OrderState.CANCEL))
            return empty();
        this.cancelMsg = cancelMsg;
        this.canceledAt = LocalDateTime.now();
        this.state = OrderState.CANCEL;

        return of(this);
    }

    public Optional<Order> complete() {
        if (this.state.stateChangeable(OrderState.COMPLETE))
            return empty();
        this.completedAt = LocalDateTime.now();
        this.state = OrderState.COMPLETE;

        return of(this);
    }

    public Integer getTotalPrice() {
        return items.stream()
                .mapToInt(OrderItem::getTotalItemPrice)
                .sum();
    }
}
