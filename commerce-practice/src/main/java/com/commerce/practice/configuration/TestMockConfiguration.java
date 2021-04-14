package com.commerce.practice.configuration;

import com.commerce.practice.ordersystem.entity.OrderItem;
import com.commerce.practice.ordersystem.mocks.MockEntity;
import com.commerce.practice.ordersystem.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kimchanjung on 2021-04-13 오후 12:58
 */
@Configuration
public class TestMockConfiguration {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private BookmarkStoreRepository bookmarkStoreRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Bean
    public MockEntity mockEntity() {
        return new MockEntity(userRepository, storeRepository, bookmarkStoreRepository, orderRepository, orderItemRepository);
    }
}
