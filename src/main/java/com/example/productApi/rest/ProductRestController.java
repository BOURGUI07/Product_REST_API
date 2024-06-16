/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.productApi.rest;

import com.example.productApi.entity.Product;
import com.example.productApi.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hp
 */
@RestController
@RequestMapping("/api")
public class ProductRestController {
    @Autowired
    public ProductRestController(ProductService service) {
        this.service = service;
    }

    public ProductRestController() {
    }
    private ProductService service;
    
    @GetMapping("/products")
    public List<Product> products(){
        return this.service.findAll();
    }
    
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Integer id){
        return this.service.findProductById(id);
    }
    
    @PostMapping("/products")
    public void addproduct(@RequestBody Product p){
        this.service.create(p);
    }
    
    @PutMapping("products")
    public Product updateProduct(@RequestBody Product p){
        var x = this.service.update(p);
        return x;
    }
    
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Integer id){
        this.service.delete(id);
    }
}