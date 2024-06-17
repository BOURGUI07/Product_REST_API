/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.productApi.service;

import com.example.productApi.entity.Product;
import com.example.productApi.repo.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }
    private ProductRepository repo;
    
    @Override
    public Product save(Product p){
        return this.repo.save(p);
    }
    
    @Override
    public List<Product> findAll(){
        return this.repo.findAll();
    }
    
    @Override
    public Product findById(Integer id){
        return this.repo.findById(id).get();
    }
    
    
    @Override
    public void deleteById(Integer id){
        this.repo.deleteById(id);
    }
}
