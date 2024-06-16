/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.productApi.dao;

import com.example.productApi.entity.Product;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hp
 */
@Repository
public class ProductDAOImpl implements ProductDAO {

    public ProductDAOImpl(EntityManager em) {
        this.em=em;
    }
    private EntityManager em;
    @Override
    public void create(Product p){
        this.em.persist(p);
    }
    
    @Override
    public List<Product> findAll(){
        return this.em.createQuery("FROM Product", Product.class).getResultList();
    }
    
    @Override
    public Product findProductById(Integer id){
        return this.em.find(Product.class, id);
    }
    
    @Override
    public Product update(Product p){
        return this.em.merge(p);
    }
    
    @Override
    public void delete(Integer id){
        this.em.remove(this.findProductById(id));
    }
}
