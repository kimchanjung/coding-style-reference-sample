package com.codingstyle.practice.commerce.controller;

import com.codingstyle.practice.commerce.dto.ProductRequest;
import com.codingstyle.practice.commerce.dto.ProductResponse;
import com.codingstyle.practice.commerce.entity.Product;
import com.codingstyle.practice.commerce.service.ProductService;
import com.codingstyle.practice.crawling.dto.WebCrawlingRequest;
import com.codingstyle.practice.crawling.dto.WebCrawlingResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by kimchanjung on 2021-04-08 오후 8:22
 */
@RestController
@RequestMapping("/api/v1/commerce/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ProductResponse register(@Valid @RequestBody ProductRequest request) {
        return productService.register(request);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductResponse find(@PathVariable("id") Long id) {
        return productService.findOne(id);
    }
}

