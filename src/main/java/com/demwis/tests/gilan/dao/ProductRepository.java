package com.demwis.tests.gilan.dao;

import com.demwis.tests.gilan.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, String> {

    Optional<Product> findByBrandAndName(String brand, String name);

    @Query("select p from Product p where p.quantity <= 5")
    List<Product> findAllLeftovers();
}
