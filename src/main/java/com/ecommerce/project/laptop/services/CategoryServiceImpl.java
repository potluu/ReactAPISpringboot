package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.entitty.Category;
import com.ecommerce.project.laptop.reponsitory.CategoryReponsitory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryReponsitory categoryReponsitory;

    @Override
    public List<Category> getAllCategory() {
        return categoryReponsitory.findAll();
    }

    @Override
    public Category getById(int id) {
        return categoryReponsitory.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        categoryReponsitory.deleteById(id);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryReponsitory.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryReponsitory.save(category);
    }
}
