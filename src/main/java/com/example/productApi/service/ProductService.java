/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.productApi.service;

import com.example.productApi.entity.Product;
import java.util.List;

/**
 *
 * @author hp
 */
public interface ProductService {
    Product save(Product p);
    List<Product> findAll();
    Product findById(Integer id);

    void deleteById(Integer id);
}
