package com.commerce.practice.configuration;

import com.commerce.practice.mocks.MockEntity;
import com.commerce.practice.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kimchanjung on 2021-04-13 오후 12:58
 */
@Configuration
public class TestMockConfiguration {
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final BookmarkedStoreRepository bookmarkStoreRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public TestMockConfiguration(UserRepository userRepository, StoreRepository storeRepository, BookmarkedStoreRepository bookmarkStoreRepository, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.userRepository = userRepository;
        this.storeRepository = storeRepository;
        this.bookmarkStoreRepository = bookmarkStoreRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Bean
    public MockEntity mockEntity() {
        return new MockEntity(userRepository, storeRepository, bookmarkStoreRepository, orderRepository, orderItemRepository);
    }
}
