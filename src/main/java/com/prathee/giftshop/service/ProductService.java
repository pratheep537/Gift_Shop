package com.prathee.giftshop.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.prathee.giftshop.model.Product;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product updateProduct(Long id, Product product);

    List<Product> getProductByName(String name);

    List<Product> getProductsByCategory(String categoryName);

    Page<Product> getProductsPaginated(int page, int size, String sortBy);
}
