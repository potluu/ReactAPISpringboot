package com.ecommerce.project.laptop.dto;

import com.ecommerce.project.laptop.entitty.ProductImage;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class ProductImageDto {
    private long id;
    private String linkImage;
    private boolean check;

    public ProductImageDto(ProductImage productImage) {
        this.id = productImage.getId();
        this.linkImage = productImage.getName();
        this.check = productImage.isPrimaryLink();
    }
    public static List<ProductImageDto> convert(Set<ProductImage> list){
        List<ProductImageDto> productImages = new ArrayList<>();
        list.forEach(productImage -> productImages.add(new ProductImageDto(productImage)) );
        return productImages;

    }
}
