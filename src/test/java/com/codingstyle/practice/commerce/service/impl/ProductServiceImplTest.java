package com.codingstyle.practice.commerce.service.impl;

import com.codingstyle.practice.TestWebPracticeConfiguration;
import com.codingstyle.practice.commerce.dto.ProductRequest;
import com.codingstyle.practice.commerce.dto.ProductResponse;
import com.codingstyle.practice.commerce.entity.Product;
import com.codingstyle.practice.commerce.eums.ProductCategory;
import com.codingstyle.practice.commerce.repository.ProductRepository;
import com.codingstyle.practice.commerce.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by kimchanjung on 2021-04-08 오후 4:40
 */


@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestWebPracticeConfiguration.class)
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    public void 제품이_정상적으로_등록된다() {
        //Given
        ProductRequest productRequest = ProductRequest.of("고향만두", 8000, ProductCategory.FOOD);

        //When
        ProductResponse productResponse = productService.register(productRequest);

        //Then
        assertEquals(1L, productResponse.getId());
        assertEquals(productRequest.getName(), productResponse.getName());
        assertEquals(productRequest.getPrice(), productResponse.getPrice());
        assertEquals(productRequest.getProductCategory(), productResponse.getProductCategory());
    }

}