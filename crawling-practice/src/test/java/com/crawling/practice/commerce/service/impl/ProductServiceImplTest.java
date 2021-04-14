package com.crawling.practice.commerce.service.impl;

import com.crawling.practice.commerce.dto.ProductRequest;
import com.crawling.practice.commerce.dto.ProductResponse;
import com.crawling.practice.commerce.eums.ProductCategory;
import com.crawling.practice.commerce.service.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by kimchanjung on 2021-04-08 오후 4:40
 */


@Slf4j
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductService ProductService;

    @Test
    public void 제품이_정상적으로_등록된다() {
    
        //Given
        ProductRequest productRequest = ProductRequest.of("고향만두", 8000, ProductCategory.FOOD);

        //When
        ProductResponse productResponse = ProductService.register(productRequest);

        //Then
        assertEquals(1L, productResponse.getId());
        assertEquals(productRequest.getName(), productResponse.getName());
        assertEquals(productRequest.getPrice(), productResponse.getPrice());
        Assertions.assertEquals(productRequest.getProductCategory(), productResponse.getProductCategory());
    }

}