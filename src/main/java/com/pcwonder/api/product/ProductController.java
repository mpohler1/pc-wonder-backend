package com.pcwonder.api.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private ProductRepository repository;

    @Autowired
    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin("https://mpohler1.github.io")
    @GetMapping("/products")
    List<Product> getProducts() {
        return repository.findAll();
    }

    @CrossOrigin("https://mpohler1.github.io")
    @GetMapping("/products/category/id/{categoryId}")
    List<Product> getProducts(@PathVariable long categoryId) {
        return repository.findAllByCategoryId(categoryId);
    }

    @CrossOrigin("https://mpohler1.github.io")
    @GetMapping("products/category/name/{categoryName}")
    List<Product> getProducts(@PathVariable String categoryName) {
        return repository.findAllByCategoryNameIgnoreCase(categoryName);
    }

    @CrossOrigin("https://mpohler1.github.io")
    @GetMapping("products/search/{searchString}")
    List<Product> search(@PathVariable String searchString) {
        return repository.findAllByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(searchString, searchString);
    }

    @CrossOrigin("https://mpohler1.github.io")
    @GetMapping("/product/{uuid}")
    Product getProduct(@PathVariable String uuid) {
        return repository.findByUuid(uuid)
                .orElseThrow(() -> new ProductNotFoundException(uuid));
    }
}
