package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.entitty.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategory();

    Category getById(int id);

    void deleteById(int id);

    Category saveCategory(Category category);

    Category updateCategory(Category category);
}
