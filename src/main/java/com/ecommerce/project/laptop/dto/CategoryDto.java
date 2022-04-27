package com.ecommerce.project.laptop.dto;

import com.ecommerce.project.laptop.entitty.Category;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class CategoryDto {
    private int id;
    private  String name;
    public CategoryDto(Category category){
        this.id=category.getId();
        this.name=category.getName();
    }
    public static List<CategoryDto> convert(Set<Category> list){
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        list.forEach(category -> categoryDtoList.add(new CategoryDto(category)) );
        return categoryDtoList;

    }
}
