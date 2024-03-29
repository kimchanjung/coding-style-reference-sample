package com.commerce.practice.mocks;


import com.commerce.practice.entity.*;
import com.commerce.practice.enums.StoreState;
import com.commerce.practice.repositories.*;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by kimchanjung on 2021-04-13 오후 12:03
 */

@Transactional
@Component
public class MockEntity {
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final BookmarkedStoreRepository bookmarkedStoreRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private static final int OFF_DAY = LocalDateTime.now().minusDays(1).getDayOfWeek().getValue();

    public MockEntity(UserRepository userRepository, StoreRepository storeRepository,
                      BookmarkedStoreRepository bookmarkedStoreRepository, OrderRepository orderRepository,
                      OrderItemRepository orderItemRepository) {
        this.userRepository = userRepository;
        this.storeRepository = storeRepository;
        this.bookmarkedStoreRepository = bookmarkedStoreRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public static Integer randomNumber() {
        return new Random().nextInt(1000 - 1) + 1;
    }

    public User creatUser() {
        return userRepository.save(User.ofNew("김찬정" + randomNumber(),
                "kimchanjung.dev@gmail.com", "1234"));
    }

    public Store createStore() {
        return storeRepository.save(Store.ofNew("홍콩반점" + randomNumber(),
                StoreState.NORMAL, OFF_DAY, true, 11, 22));
    }

    public Store createStore(Integer offDay, boolean run24, Integer openTime, Integer closeTime) {
        return storeRepository.save(Store.ofNew("홍콩반점" + randomNumber(),
                StoreState.NORMAL, offDay, false, openTime, closeTime));
    }

    public List<Store> createStores(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> createStore())
                .collect(Collectors.toList());
    }

    public BookmarkedStore createBookmarkStore() {
        return bookmarkedStoreRepository.save(BookmarkedStore.ofNew(creatUser(), createStore()));
    }

    public Order createOrder() {
        Order order = orderRepository.save(Order.ofNew(creatUser(), createStore()));
        orderItemRepository.save(OrderItem.ofNew(order, "햄버거" + randomNumber(), 5000, 1));
        orderItemRepository.save(OrderItem.ofNew(order, "콜" + randomNumber(), 2000, 2));
        return order;
    }

    public Order createOrder(User user) {
        Order order = orderRepository.save(Order.ofNew(user, createStore()));
        orderItemRepository.save(OrderItem.ofNew(order, "햄버거" + randomNumber(), 5000, 1));
        orderItemRepository.save(OrderItem.ofNew(order, "콜" + randomNumber(), 2000, 2));
        return order;
    }

    public Order completeOrder() {
        return createOrder()
                .complete()
                .orElse(null);
    }

    public List<Order> createOrders(Integer size, boolean onlyOneUser) {
        User user = onlyOneUser ? creatUser() : null;
        return IntStream.range(0, size)
                .mapToObj(v -> onlyOneUser ? createOrder(user) : createOrder())
                .collect(Collectors.toList());
    }
}
