package com.commerce.practice.repositories;

import com.commerce.practice.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kimchanjung on 2021-04-14 오후 2:20
 */
public interface OrderItemRepository  extends JpaRepository<OrderItem, Long> {
}
