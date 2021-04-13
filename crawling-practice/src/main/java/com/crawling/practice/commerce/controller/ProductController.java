package com.crawling.practice.commerce.controller;

import com.crawling.practice.commerce.dto.ProductRequest;
import com.crawling.practice.commerce.dto.ProductResponse;
import com.crawling.practice.commerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by kimchanjung on 2021-04-08 오후 8:22
 */
@RestController
@RequestMapping("/api/v1/commerce/product")
public class ProductController {

    private final ProductService ProductService;

    public ProductController(ProductService ProductService) {
        this.ProductService = ProductService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ProductResponse register(@Valid @RequestBody ProductRequest request) {
        return ProductService.register(request);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductResponse find(@PathVariable("id") Long id) {
        return ProductService.findOne(id);
    }
}

