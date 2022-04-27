package com.ecommerce.project.laptop.dto;

import com.ecommerce.project.laptop.component.Excel;
import com.ecommerce.project.laptop.entitty.Product;
import com.ecommerce.project.laptop.entitty.Review;
import lombok.Data;
import org.apache.poi.ss.usermodel.Row;

import java.util.Date;
import java.util.List;

@Data
public class ProductDto extends Excel {
    private long id;
    private String name;
    private String description;
    private int quantity;
    private String nameCreate;
    private long administratorId;
    private Date createdDate;
    private double price;
    private int discount;
    private String nameBrand;
    private int brandId;
    private List<CategoryDto> categoryDtoList;
    private List<ProductImageDto> productImageDtos;
    private ProductDetailsDto productDetailsDto;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.quantity = product.getQuantity();
        this.nameCreate = product.getAdministrator().getName();
        this.administratorId = product.getAdministrator().getId();
        this.createdDate = product.getCreatedDate();
        this.price = product.getPrice();
        this.discount=product.getDiscount();
        this.nameBrand = product.getBrand().getName();
        this.brandId = product.getBrand().getId();
        this.categoryDtoList = CategoryDto.convert(product.getCategories());
        this.productImageDtos = ProductImageDto.convert(product.getProductImages());
        this.productDetailsDto = new ProductDetailsDto(product.getDetails());
    }

    public static String[] getTileProductRowExcel(){
        String titleProduct[]={"Id","Tên Sản Phẩm","Mô tả","Số Lượng","Giảm Giá","Ngày Tạo","Giá Tiền","Thương Hiệu",
        "Người Nhập","Thể Loại","Link Ảnh", "Tổng Tiền"};
        return titleProduct;
    }
    public static String[] getTitleInforProduct(){
        String titleInfor[]={"Id","Tên Sản Phẩm","Mô tả","Số Lượng","Giảm Giá","Ngày Tạo","Giá Tiền","Thương Hiệu",
                "Người Nhập","Thể Loại","Link Ảnh", };
        return titleInfor;
    }

    @Override
    public void write(Row cells) {
        cells.createCell(0).setCellValue(this.getId());
        //data row name
        cells.createCell(1).setCellValue(this.getName());
        //data row description
        cells.createCell(2).setCellValue(this.getDescription());
        //data row quantity
        cells.createCell(3).setCellValue(this.getQuantity());
        //data row discount
        cells.createCell(4).setCellValue(this.getDiscount());
        //data row date
        cells.createCell(5).setCellValue(this.getCreatedDate());
        //data row price
        cells.createCell(6).setCellValue(this.getPrice());
        //data row brand
        cells.createCell(7).setCellValue(this.nameBrand);
        //data row enter input by person
        cells.createCell(8).setCellValue(this.nameCreate);
        //data row category
        cells.createCell(9).setCellValue(this.categoryDtoList.toString());
        //data row link imag
        cells.createCell(10).setCellValue(this.productImageDtos.toString());
        //data row total price
        cells.createCell(10).setCellFormula("D4*H7");
    }
}
