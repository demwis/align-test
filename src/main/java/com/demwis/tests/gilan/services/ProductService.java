package com.demwis.tests.gilan.services;

import com.demwis.tests.gilan.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    String addProduct(Product product);

    void updateProduct(Product product);

    void deleteProductById(String id);

    Optional<Product> findProduct(String brand, String name);

    List<Product> findAllLeftovers();
}
