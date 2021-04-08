package com.codingstyle.practice.commerce.service.impl;

import com.codingstyle.practice.commerce.dto.ProductRequest;
import com.codingstyle.practice.commerce.dto.ProductResponse;
import com.codingstyle.practice.commerce.entity.Product;
import com.codingstyle.practice.commerce.mapper.ProductMapper;
import com.codingstyle.practice.commerce.repository.ProductRepository;
import com.codingstyle.practice.commerce.service.ProductService;
import com.codingstyle.practice.ex.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by kimchanjung on 2021-04-08 오후 3:02
 */

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse register(ProductRequest productRequest) {
       return productMapper.toResponse(productRepository.save(productMapper.toEntity(productRequest)));
    }

    @Override
    public ProductResponse findOne(Long id) {
        return productMapper.toResponse(
                productRepository.findById(id)
                        .orElseThrow(() -> ResourceNotFoundException.notFound("제품")));
    }
}
