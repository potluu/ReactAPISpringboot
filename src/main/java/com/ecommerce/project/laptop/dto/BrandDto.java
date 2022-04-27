package com.ecommerce.project.laptop.dto;

import com.ecommerce.project.laptop.entitty.Brand;
import lombok.Data;

@Data
public class BrandDto {
    private int brandId;
    private String name;
   public BrandDto(Brand brand){
       this.brandId=brand.getId();
       this.name=brand.getName();
   }
}
