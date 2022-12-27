package com.axle.springeshop.service;

import com.axle.springeshop.domain.Bucket;
import com.axle.springeshop.domain.User;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Long> productIds);
    void addProducts(Bucket bucket, List<Long> productIds);
}
