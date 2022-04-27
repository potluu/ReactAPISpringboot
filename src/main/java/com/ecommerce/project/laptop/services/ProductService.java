package com.ecommerce.project.laptop.services;


import com.ecommerce.project.laptop.entitty.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();

    Product getById(long id);

    boolean deleteById(long id);

    Product saveProduct(Product product);

    Product updateProduct(Product product);

    boolean exitsById(long id);
}
