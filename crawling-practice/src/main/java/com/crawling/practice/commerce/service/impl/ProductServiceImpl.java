package com.crawling.practice.commerce.service.impl;

import com.crawling.practice.commerce.dto.ProductRequest;
import com.crawling.practice.commerce.dto.ProductResponse;
import com.crawling.practice.commerce.mapper.ProductMapper;
import com.crawling.practice.commerce.repository.ProductRepository;
import com.crawling.practice.commerce.service.ProductService;
import com.crawling.practice.ex.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by kimchanjung on 2021-04-08 오후 3:02
 */

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    private final ProductRepository cpProductRepository;

    public ProductServiceImpl(ProductMapper productMapper, ProductRepository cpProductRepository) {
        this.productMapper = productMapper;
        this.cpProductRepository = cpProductRepository;
    }

    @Override
    public ProductResponse register(ProductRequest productRequest) {
       return productMapper.toResponse(cpProductRepository.save(productMapper.toEntity(productRequest)));
    }

    @Override
    public ProductResponse findOne(Long id) {
        return productMapper.toResponse(
                cpProductRepository.findById(id)
                        .orElseThrow(() -> ResourceNotFoundException.notFound("제품")));
    }
}
