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
    @OneToMany(mappedBy = "user")
    private final List<BookmarkedStore> bookmarkedStores = new ArrayList<>();
    @OneToMany(mappedBy = "user")
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