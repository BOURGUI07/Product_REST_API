/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.productApi.rest;

import com.example.productApi.entity.Product;
import com.example.productApi.handler.ProductNotFoundException;
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
        if(id<0 || id>=this.service.findAll().size()){
            throw new ProductNotFoundException("Product With Id: " +  id + " Not Found");
        }
        return this.service.findById(id);
    }
    
    @PostMapping("/products")
    public Product addproduct(@RequestBody Product p){
        p.setId(0);
        return this.service.save(p);
    }
    
    @PutMapping("products")
    public Product updateProduct(@RequestBody Product p){
        return this.service.save(p);
    }
    
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Integer id){
        if(id<0 || id>=this.service.findAll().size()){
            throw new ProductNotFoundException("Product With Id: " +  id + " Not Found");
        }
        this.service.deleteById(id);
    }
}
