package com.sushant.fakestore.services;

import com.sushant.fakestore.module.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    //list of all products

    List<Product> allProducts();
}
