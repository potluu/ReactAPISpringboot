package com.ecommerce.project.laptop.api;

import com.ecommerce.project.laptop.component.Excel;
import com.ecommerce.project.laptop.dto.ProductDto;
import com.ecommerce.project.laptop.entitty.Product;
import com.ecommerce.project.laptop.entitty.ProductDetails;
import com.ecommerce.project.laptop.entitty.ProductImage;
import com.ecommerce.project.laptop.services.BrandServiceImpl;
import com.ecommerce.project.laptop.services.ProductServiceImpl;
import com.ecommerce.project.laptop.utils.FileUtils;
import com.ecommerce.project.laptop.utils.TimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v12")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;
    private final BrandServiceImpl brandService;

    private final FileUtils fileUtils;



    @PostMapping("/product/file/excel")
    public ResponseEntity<?> exportExcel(@RequestParam("url") String url, @RequestParam("nameFile") String name) {
        if (url!=null && name!=null){
          Excel excel=new ProductDto();
          excel.setHeader(ProductDto.getTileProductRowExcel());
          excel.setNameFile(name);
          excel.setTitleSheet("PRODUCT");
          excel.setUrl("D:");
            fileUtils.exportExcel(excel,"PRODUCT");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);

        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
        }
    }

    /*
     */
    @GetMapping("/products")
    public ResponseEntity<?> getAllProduct() {
        List<Product> productList=productService.getAllProduct();
        if(!productList.isEmpty()){
            List<ProductDto> productDtos=new ArrayList<>();
            productList.forEach(product -> productDtos.add(new ProductDto(product)));
            return ResponseEntity.status(HttpStatus.OK).body(productDtos);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found data ");
        }
    }

    /*

     */
    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable long id) {
        Product product = productService.getById(id);
        if (product != null) {
            return new ResponseEntity<>(new ProductDto(product), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found data by request url");
        }
    }

    /*

     */
    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable long id) {
        if (productService.deleteById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body("delete success data by request url");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not found data");
        }
    }

    /*

     */
    @PostMapping(value = "/product", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> saveProduct(@RequestPart MultipartFile[] fileUpload, @RequestPart ProductDto productDto) {
        if(fileUpload.length>0 &&productDto!=null){
            int count =0;
            List<ProductImage> imageList = new ArrayList<>();
            for (MultipartFile multipartFile:fileUpload){
                ProductImage productImage =ProductImage.builder()
                        .name(multipartFile.getName())
                        .build();
                String nameFile=productDto.getNameBrand()+"/"+multipartFile.getOriginalFilename();
                if(count==0){
                    productImage.setPrimaryLink(true);
                }
                imageList.add(productImage);
                FileUtils.saveImage(multipartFile,nameFile);
                count++;
            }
            Product product =Product.builder()
                    .productImages((Set<ProductImage>) imageList)
                    .administrator(null)
                    .brand(brandService.getById(productDto.getBrandId()))
                    .createdDate(TimeUtils.getTimeNowSystem())
                    .description(productDto.getDescription())
                    .discount(productDto.getDiscount())
                    .name(productDto.getName())
                    .price(productDto.getPrice())
                    .quantity(productDto.getQuantity())
                    .details(new ProductDetails(productDto.getProductDetailsDto()))
                    .build();
            productService.saveProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body("success");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("request url invalid data ");

    }
    /*

     */
    @PutMapping(value = "/product", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> updateProduct(@RequestPart MultipartFile[] fileUpload, @RequestPart ProductDto productDto){
        if(productDto!=null&& productService.exitsById(productDto.getId()) ){
            Product getProduct=productService.getById(productDto.getId());
            int count =0;
            Set<ProductImage> imageList = getProduct.getProductImages();
            for (MultipartFile multipartFile:fileUpload){
                imageList.clear();
                ProductImage productImage =ProductImage.builder()
                        .name(multipartFile.getName())
                        .build();
                String nameFile=productDto.getNameBrand()+"/"+multipartFile.getOriginalFilename();
                if(count==0){
                    productImage.setPrimaryLink(true);
                }
                imageList.add(productImage);
                FileUtils.saveImage(multipartFile,nameFile);
                count++;
            }
            Product product =Product.builder()
                    .productImages(imageList)
                    .administrator(null)
                    .brand(brandService.getById(productDto.getBrandId()))
                    .createdDate(TimeUtils.getTimeNowSystem())
                    .description(productDto.getDescription())
                    .discount(productDto.getDiscount())
                    .name(productDto.getName())
                    .price(productDto.getPrice())
                    .quantity(productDto.getQuantity())
                    .details(new ProductDetails(productDto.getProductDetailsDto()))
                    .build();
            productService.saveProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body("success");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("request url invalid data ");
    }

    @PostMapping(value = "/product/excel/file")
    public ResponseEntity<?> importExcel(@RequestParam("uploadFile") MultipartFile[] listFile) {
        return ResponseEntity.status(HttpStatus.OK).body("đs");
    }
}
