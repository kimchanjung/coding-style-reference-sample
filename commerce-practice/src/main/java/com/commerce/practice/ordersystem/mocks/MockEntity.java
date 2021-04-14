package com.commerce.practice.ordersystem.mocks;

import com.commerce.practice.ordersystem.entity.*;
import com.commerce.practice.ordersystem.enums.OrderState;
import com.commerce.practice.ordersystem.enums.StoreState;
import com.commerce.practice.ordersystem.repositories.*;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
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
    private final BookmarkStoreRepository bookmarkStoreRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public MockEntity(UserRepository userRepository, StoreRepository storeRepository,
                      BookmarkStoreRepository bookmarkStoreRepository, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.userRepository = userRepository;
        this.storeRepository = storeRepository;
        this.bookmarkStoreRepository = bookmarkStoreRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public static Integer randomNumber() {
        return new Random().nextInt(1000 - 1) + 1;
    }

    public User creatUser() {
        return userRepository.save(User.of("김찬정" + randomNumber(), "kimchanjung.dev@gmail.com", "1234"));
    }

    public Store createStore() {
        return storeRepository.save(Store.of("홍콩반점" + randomNumber(), StoreState.NORMAL, 1, false, 11, 22));
    }

    public Store createStore(Integer offDay, boolean run24, Integer openTime, Integer closeTime) {
        return storeRepository.save(Store.of("홍콩반점" + randomNumber(), StoreState.NORMAL, offDay, false, openTime, closeTime));
    }

    public List<Store> createStores(int size) {
        return IntStream.range(0, size).mapToObj(i -> createStore()).collect(Collectors.toList());
    }


    public BookmarkStore createBookmarkStore() {
        return bookmarkStoreRepository.save(BookmarkStore.of(creatUser(), createStore()));
    }

    public Order createOrder() {
        Order order = Order.ofNew(creatUser(), createStore());
        OrderItem.ofNew(order, "햄버거" + randomNumber(), 5000, 1);
        OrderItem.ofNew(order, "콜" + randomNumber(), 2000, 2);
        return orderRepository.save(order);
    }

    public Order createOrder(User user) {
        Order order = Order.ofNew(user, createStore());
        OrderItem.ofNew(order, "햄버거" + randomNumber(), 5000, 1);
        OrderItem.ofNew(order, "콜" + randomNumber(), 2000, 2);
        return orderRepository.save(order);
    }

    public Order createOrder(OrderState state) {
        Order order = createOrder();
        order.complete();
        return order;
    }


    public List<Order> createOrders(Integer size, boolean onlyOneUser) {
        User user = onlyOneUser ? creatUser() : null;
        return IntStream.range(0, size)
                .mapToObj(v -> onlyOneUser ? createOrder(user) : createOrder())
                .collect(Collectors.toList());
    }


}
