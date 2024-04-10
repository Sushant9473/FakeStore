package com.sushant.fakestore.services;

import com.sushant.fakestore.dtos.FakeStoreProductDto;
import com.sushant.fakestore.module.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    @Override
    public Product getProductById(Long id) {
        throw new RuntimeException();
//        RestTemplate restTemplate = new RestTemplate();
//        FakeStoreProductDto fakeStoreProductDto =
//                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
//                        FakeStoreProductDto.class);
//        if(fakeStoreProductDto == null){
//            return null;
//        }
//        Product product = new Product();
//        product.setId(fakeStoreProductDto.getId());
//        product.setTitle(fakeStoreProductDto.getTitle());
//        product.setDescription(fakeStoreProductDto.getDescription());
//        product.setImage(fakeStoreProductDto.getImage());
//
//        return product;
    }

    @Override
    public List<Product> allProducts() {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class);

        if(fakeStoreProductDtos != null){
            List<Product> products = new ArrayList<>();
            for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
                Product product = new Product();
                product.setId(fakeStoreProductDto.getId());
                product.setTitle(fakeStoreProductDto.getTitle());
                product.setDescription(fakeStoreProductDto.getDescription());
                product.setImage(fakeStoreProductDto.getImage());
                products.add(product);
            }
            return products;
        }

        return null;
    }
}
