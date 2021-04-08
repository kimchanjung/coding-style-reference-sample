package com.codingstyle.practice.commerce.service;

import com.codingstyle.practice.commerce.dto.ProductRequest;
import com.codingstyle.practice.commerce.dto.ProductResponse;

/**
 * Created by kimchanjung on 2021-04-07 오후 6:05
 */
public interface ProductService {
    ProductResponse register(ProductRequest productRequest);

    ProductResponse findOne(Long id);
}
