package com.ecommerce.project.laptop.api;

import com.ecommerce.project.laptop.dto.CategoryDto;
import com.ecommerce.project.laptop.entitty.Category;
import com.ecommerce.project.laptop.services.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    /*

     */
    @GetMapping(value = "/categories")
    public ResponseEntity<List<CategoryDto>> getAll() {
        List<CategoryDto> listCategoryDtos = new ArrayList<>();
        categoryService.getAllCategory().forEach(category ->
                listCategoryDtos.add(new CategoryDto(category)));
        return new ResponseEntity<>(listCategoryDtos, HttpStatus.OK);
    }

    /*

     */
    @GetMapping(value = "/category/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        CategoryDto categoryDto = new CategoryDto(categoryService.getById(id));
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    /*

     */
    @PostMapping(value = "/category")
    public ResponseEntity<Boolean> save(@ModelAttribute(name = "CategoryDto") CategoryDto categoryDto) {
        Category category = Category.builder().
                name(categoryDto.getName()).products(null)
                .build();
        categoryService.saveCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }
    /*

     */

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        categoryService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /*

     */
    @PutMapping("/category")
    public ResponseEntity<?> updateCategory(@ModelAttribute(name = "categoryDto") CategoryDto categoryDto) {
        Category category = Category.builder().
                id(categoryDto.getId()).
                name(categoryDto.getName())
                .build();
        categoryService.updateCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body(true);

    }
}
