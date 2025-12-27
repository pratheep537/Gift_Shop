package com.prathee.giftshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prathee.giftshop.exception.BadRequestException;
import com.prathee.giftshop.exception.ResourceNotFoundException;
import com.prathee.giftshop.model.Category;
import com.prathee.giftshop.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category createCategory(Category category) {
        if (category.getCategoryName() == null || category.getCategoryName().isBlank()) {
            throw new BadRequestException("Category name cannot be empty");
        }
        return categoryRepo.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found with id " + id));
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category existing = getCategoryById(id);
        existing.setCategoryName(category.getCategoryName());
        return categoryRepo.save(existing);
    }

    @Override
    public void deleteCategory(Long id) {
        if (!categoryRepo.existsById(id)) {
            throw new ResourceNotFoundException("Category not found with id " + id);
        }
        categoryRepo.deleteById(id);
    }
}
