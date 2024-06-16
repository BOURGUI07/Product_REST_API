/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.productApi.service;

import com.example.productApi.dao.ProductDAO;
import com.example.productApi.entity.Product;
import jakarta.transaction.Transactional;
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
    public ProductServiceImpl(ProductDAO dao) {
        this.dao = dao;
    }
    private ProductDAO dao;
    
    @Override
    @Transactional
    public void create(Product p){
        this.dao.create(p);
    }
    
    @Override
    public List<Product> findAll(){
        return this.dao.findAll();
    }
    
    @Override
    public Product findProductById(Integer id){
        return this.dao.findProductById(id);
    }
    
    @Override
    @Transactional
    public Product update(Product p){
        return this.dao.update(p);
    }
    
    @Override
    @Transactional
    public void delete(Integer id){
        this.dao.delete(id);
    }
}
