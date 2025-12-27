package com.prathee.giftshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prathee.giftshop.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    // Derived query
    List<Product> findByProductName(String productName);

    // JPQL: products by category name
    @Query("SELECT p FROM Product p WHERE p.category.categoryName = ?1")
    List<Product> findProductsByCategoryName(String categoryName);

    // Price filtering
    List<Product> findByPriceBetween(double min, double max);
}
