package com.crawling.practice.commerce.repository;

import com.crawling.practice.commerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kimchanjung on 2021-04-08 오후 7:12
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
