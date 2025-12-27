package com.prathee.giftshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.prathee.giftshop.exception.ResourceNotFoundException;
import com.prathee.giftshop.model.Product;
import com.prathee.giftshop.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existing = getProductById(id);
        existing.setProductName(product.getProductName());
        existing.setPrice(product.getPrice());
        existing.setStockQuantity(product.getStockQuantity());
        existing.setDescription(product.getDescription());
        existing.setCategory(product.getCategory());
        return productRepo.save(existing);
    }

    @Override
    public List<Product> getProductByName(String name) {
        return productRepo.findByProductName(name);
    }

    @Override
    public List<Product> getProductsByCategory(String categoryName) {
        return productRepo.findProductsByCategoryName(categoryName);
    }

    @Override
    public Page<Product> getProductsPaginated(int page, int size, String sortBy) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy).ascending());

        return productRepo.findAll(pageable);
    }
}
