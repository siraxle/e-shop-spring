package com.axle.springeshop.service;

import com.axle.springeshop.domain.Product;
import com.axle.springeshop.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();

    void addToUserBucket(Long productId, String username);
}
