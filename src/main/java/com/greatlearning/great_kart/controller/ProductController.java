package com.greatlearning.great_kart.controller;

import com.greatlearning.great_kart.entity.Product;
import com.greatlearning.great_kart.repository.ProductRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        System.out.println("product.getName() = " + product.getName());
        return this.productRepository.save(product);
    }

    @GetMapping("products/{id}")
    public ResponseEntity<?> searchProduct(@PathVariable Long id) {
//        Optional<Product> product = this.productRepository.findById(id);
//        if (product.isPresent()) {
//            return ResponseEntity.ok().body(product.get());
//        }
//        return ResponseEntity.notFound().build();
//
        return this.productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get - Getting the resource
    // Put - Add new resource
    // Patch - Update existing resource
    // Put - Replace existing resource
    // Delete - Delete existing resource
    @PatchMapping("/products")
    public @Nullable Product updateProduct(@RequestBody Product product) {
        if (!this.productRepository.existsById(product.getId())) {
            return null;
        }
        return this.productRepository.save(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.productRepository.deleteById(id);
    }

    @GetMapping("/search-product")
    public ResponseEntity<?> searchByName(@RequestParam String name) {
        return this.productRepository.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
