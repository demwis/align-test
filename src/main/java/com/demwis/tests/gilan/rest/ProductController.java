package com.demwis.tests.gilan.rest;

import com.demwis.tests.gilan.model.Product;
import com.demwis.tests.gilan.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class ProductController {
    private final ProductService productService;

    public ProductController(@Autowired ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('admin')")
    public String addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('read')")
    public Product findProduct(@RequestParam("brand") String brand, @RequestParam("name") String name) {
        return productService.findProduct(brand, name).orElse(null);
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('admin')")
    public void updateProduct(@PathVariable("productId") String productId, @RequestBody Product product) {
        product.setId(productId);
        productService.updateProduct(product);
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('admin')")
    public void deleteProduct(@PathVariable("productId") String productId) {
        productService.deleteProductById(productId);
    }

    @RequestMapping(value = "/products/leftovers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('read')")
    public Collection<Product> findProductLeftovers() {
        return productService.findAllLeftovers();
    }
}
