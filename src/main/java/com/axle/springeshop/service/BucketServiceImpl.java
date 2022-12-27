package com.axle.springeshop.service;

import com.axle.springeshop.dao.BucketRepository;
import com.axle.springeshop.dao.ProductRepository;
import com.axle.springeshop.domain.Bucket;
import com.axle.springeshop.domain.Product;
import com.axle.springeshop.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BucketServiceImpl implements BucketService{
    private final BucketRepository bucketRepository;
    private final ProductRepository productRepository;

    @Autowired
    public BucketServiceImpl(BucketRepository bucketRepository, ProductRepository productRepository) {
        this.bucketRepository = bucketRepository;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public Bucket createBucket(User user, List<Long> productIds) {
        Bucket bucket = new Bucket();
        bucket.setUser(user);
        List<Product> productList = getCollectRefProductsByIds(productIds);
        bucket.setProducts(productList);
        return bucketRepository.save(bucket);
    }

    private List<Product> getCollectRefProductsByIds(List<Long> productIds) {
        return productIds.stream().map(productRepository::getOne)
                .collect(Collectors.toList());
    }

    @Override
    public void addProducts(Bucket bucket, List<Long> productIds) {
        List<Product> products = bucket.getProducts();
        List<Product> newProductList = products == null ? new ArrayList<>() : new ArrayList<>(products);
        newProductList.addAll(getCollectRefProductsByIds(productIds));
        bucket.setProducts(newProductList);
        bucketRepository.save(bucket);
    }

}
