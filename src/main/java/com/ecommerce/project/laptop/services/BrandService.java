package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.entitty.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getAllBrand();

    Brand getById(int id);

    void deleteById(int id);

    Brand saveBrand(Brand brand);


    Brand updateBrand(Brand brand);

    boolean exitsById(int id);
}
