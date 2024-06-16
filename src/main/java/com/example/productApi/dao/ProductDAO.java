/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.productApi.dao;

import com.example.productApi.entity.Product;
import java.util.List;

/**
 *
 * @author hp
 */
public interface ProductDAO {
    void create(Product p);
    List<Product> findAll();
    Product findProductById(Integer id);
    Product update(Product p);
    void delete(Integer id);
}
