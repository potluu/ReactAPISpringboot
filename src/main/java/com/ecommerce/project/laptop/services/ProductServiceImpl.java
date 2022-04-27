package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.entitty.Product;
import com.ecommerce.project.laptop.reponsitory.ProductReponsitory;
import com.ecommerce.project.laptop.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductReponsitory productReponsitory;

    @Override
    public List<Product> getAllProduct() {
        return productReponsitory.findAll();
    }

    @Override
    public Product getById(long id) {
        return productReponsitory.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(long id) {
        if (productReponsitory.existsById(id)) {
            Product product = productReponsitory.findById(id).orElse(null);
            String nameFile=product.getBrand().getName()+"/";
            product.getProductImages().forEach(productImage -> FileUtils.deleteFile(nameFile + productImage.getName()));
            productReponsitory.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Product saveProduct(Product product) {
        return productReponsitory.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productReponsitory.save(product);
    }

    @Override
    public boolean exitsById(long id) {
        if(productReponsitory.existsById(id)){
            return true;
        }
        return false;
    }
}
