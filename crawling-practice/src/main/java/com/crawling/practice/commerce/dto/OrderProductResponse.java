package com.crawling.practice.commerce.dto;

import com.crawling.practice.commerce.entity.Product;
import com.crawling.practice.commerce.repository.ProductRepository;
import lombok.*;

/**
 * Created by kimchanjung on 2021-04-08 오후 9:44
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderProductResponse {
    private Long id;
    private ProductResponse product;
    private Integer productCount;
}
