package com.demwis.tests.gilan.services;

import com.demwis.tests.gilan.dao.ProductRepository;
import com.demwis.tests.gilan.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final IdGenerationService<String> idGenerationService;

    public ProductServiceImpl(@Autowired ProductRepository productRepository,
                              @Autowired @Qualifier(IdGenerationService.STRING) IdGenerationService<String> idGenerationService) {
        this.productRepository = productRepository;
        this.idGenerationService = idGenerationService;
    }

    @Override
    public String addProduct(Product product) {
        product.setId(idGenerationService.generateId());
        return productRepository.save(product).getId();
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProductById(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findProduct(String brand, String name) {
        return productRepository.findByBrandAndName(brand, name);
    }

    @Override
    public List<Product> findAllLeftovers() {
        return productRepository.findAllLeftovers();
    }
}
