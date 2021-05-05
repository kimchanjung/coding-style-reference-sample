package com.commerce.practice.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by kimchanjung on 2021-04-10 오후 2:00
 * 기본적으로 특별한 경우가 아니면 기본 fetch 전략을 사용하는 편인데
 * [엔티티 관계에서 기본패치전략]
 * 기본패치전략을 그대로 사용하는 경우 생략해도 되지만
 * 사람은 항상 햇갈릴 수 있기 때문에 명시적으로 설정해주는 편이다
 */

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, name = "passwd")
    private String password;
    @Column(nullable = false)
    private Integer loginCount;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private final List<BookmarkedStore> bookmarkedStores = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private final List<Order> orders = new ArrayList<>();
    @UpdateTimestamp
    private LocalDateTime lastLoginAt;
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public static User ofNew(String name, String email, String password) {
        User instance = new User();
        instance.name = name;
        instance.email = email;
        instance.password = password;
        instance.loginCount = 0;
        instance.lastLoginAt = LocalDateTime.now();
        return instance;
    }

    public User addOrder(Order order) {
        orders.add(order);
        return this;
    }

    public User addBookmarkStore(BookmarkedStore bookmarkedStore) {
        bookmarkedStores.add(bookmarkedStore);
        return this;
    }

    public User login() {
        loginCount++;
        return this;
    }
}