package com.ecommerce.project.laptop.component;

import com.ecommerce.project.laptop.dto.AccountDto;
import com.ecommerce.project.laptop.dto.ProductDto;

public class IExcel {

    public Excel getExcelFactory(String key) {
        if (key.equals("PRODUCT")) {
            return new ProductDto();
        } else if (key.equals("ACCOUNT")) {
            return new AccountDto();
        } else {
            return null;
        }
    }

}
