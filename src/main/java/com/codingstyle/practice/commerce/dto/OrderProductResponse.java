package com.codingstyle.practice.commerce.dto;

import com.codingstyle.practice.commerce.entity.Product;
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
    private Product product;
    private Integer productCount;
}
